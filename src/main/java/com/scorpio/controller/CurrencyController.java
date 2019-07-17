package com.scorpio.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.handler.StationAlreadyExistsException;
import com.handler.StationNotFoundException;
import com.scorpio.entity.Currency;
import com.scorpio.repository.CurrencyRepository;

@Controller
@RequestMapping(path = "/api")
public class CurrencyController {    
	@Autowired
	CurrencyRepository currencyRepository;
	
	@GetMapping("/getCurrencyByID/{Currency}")
	@ResponseBody
	public Currency findBycIdIgnoreCase(@PathVariable String Currency) {
		
		Optional<Currency> currency = currencyRepository.findBycIdIgnoreCase(Currency);

		return currency.get();
	}
	
	@GetMapping("/refreshCurrency")
	@ResponseBody
	public void reloadAll() throws SQLException {
		
	    PreparedStatement preparedStatement = null;
				
	    final String sql = "INSERT INTO EST_CURRENCY\n" + 
	    		"    (ISO, CurrencyRate, CreatedAt, UpdatedAt)\n" + 
	    		"VALUES\n" + 
	    		"    (?, ?, ?, ?)\n" + 
	    		"ON DUPLICATE KEY UPDATE\n" + 
	    		"    CurrencyRate = ?,\n" + 
	    		"    CreatedAt = ?,\n" + 
	    		"    UpdatedAt = ?;";	    
			
		try {
		
			URL url = new URL("https://api.exchangerate-api.com/v4/latest/SGD");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			
			StringBuffer response = new StringBuffer();
			
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			
			String output;
			String outstr = null;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				response.append(output);
			}

			HashMap<String, Double> exrates = new HashMap<String, Double>();
			
			ObjectMapper mapper = new ObjectMapper();
			
			Map<String, Object> cashMap = mapper.readValue(response.toString(), new TypeReference<Map<String, Object>>() {
            });
			
			ObjectMapper mapper2 = new ObjectMapper();
			
			String ratesString = cashMap.get("rates").toString();
			
			ratesString=ratesString.replace("{","{\"");
			ratesString=ratesString.replace("=","\":");
			ratesString=ratesString.replace(", ",", \"");
			
			Map<String, Object> cashHash = mapper2.readValue(ratesString, new TypeReference<Map<String, Object>>() {
            });
			
			String urldb = "jdbc:mysql://localhost:3306/scorpiodb"; 
			Properties infodb = new Properties(); 
			infodb.put("user", "dbuser"); 
			infodb.put("password", "eurosportssg");

			Connection dbconn = DriverManager.getConnection(urldb, infodb);
			
			Statement sta = dbconn.createStatement();
			
			ResultSet res = sta.executeQuery("SELECT * FROM EST_COUNTRY");
		    
		    int result = 0;
		    	    
		    Calendar calendar = Calendar.getInstance();
		    java.util.Date now = calendar.getTime();
		    java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		    
		    double d = 0;
		    
		    preparedStatement = dbconn.prepareStatement(sql);
		    
		    while (res.next()) {
				d = Double.parseDouble((cashHash.get(res.getString("ISO"))).toString());
				preparedStatement.setString(1, res.getString("ISO"));
				preparedStatement.setDouble(2, d); 
				preparedStatement.setTimestamp(3, currentTimestamp); 
				preparedStatement.setTimestamp(4, currentTimestamp);
				preparedStatement.setDouble(5, d); 
				preparedStatement.setTimestamp(6, currentTimestamp); 
				preparedStatement.setTimestamp(7, currentTimestamp);
				  
				result = preparedStatement.executeUpdate();
				  
				if (result>0) { 
					System.out.println ("Successfully updated"); 
				} else {
					System.out.println ("Cannot update currency rates for "+res.getString("ISO")); 
				} 
				 
		    }
		    
			/*
			 * try (Statement s = dbconn.createStatement(); ResultSet rs = s.executeQuery(
			 * "SELECT ISO FROM EST_COUNTRY" ); PreparedStatement u =
			 * dbconn.prepareStatement(
			 * "UPDATE EST_COUNTRY SET CURRENCYRATE='"+cashHash.get(res.getString("ISO"))
			 * +"' WHERE ISO = ?" )) { if (rs.next()) { u.setInt(1, rs.getInt(1));
			 * u.addBatch(); } u.executeBatch(); }
			 */
		    dbconn.close();
			
			conn.disconnect();
		
		} catch (MalformedURLException e) {
		
			e.printStackTrace();
		
		} catch (IOException e) {
		
			e.printStackTrace();
		
		} catch (Exception e) {
			
			System.err.println("Exception: "+e.getMessage());
			
	    }
	}
}
