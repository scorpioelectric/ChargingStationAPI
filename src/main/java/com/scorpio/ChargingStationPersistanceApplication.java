package com.scorpio;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.scorpio.entity.ChargingStation;
import com.scorpio.service.ChargingStnService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Configuration
@ComponentScan(basePackages = { "com.scorpio" })
@EnableAutoConfiguration

public class ChargingStationPersistanceApplication extends SpringBootServletInitializer implements CommandLineRunner {
	/*
	 * @Autowired UserAccountService usersServ;
	 */
	@Autowired
	ChargingStnService chargeServ;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
	{
		return builder.sources(ChargingStationPersistanceApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ChargingStationPersistanceApplication.class, args);
	}


	@Override
	public void run(String... arg0) throws Exception {
	
		 /* Timestamp t1 = new Timestamp(System.currentTimeMillis()); //
		 * usersServ.addUser("test", "test", "test"); // chargeServ.addStn(1, 1.1, 1.1,
		 * 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, "Singapore", // "Teban", 0, 0, 0, "Singapore",
		 * "Singapore", 0);
		 * 
		 * ArrayList<ChargingStation> e = new ArrayList<ChargingStation>(); for (int i =
		 * 0; i < 1000; i++) { Math.random(); ChargingStation c = new ChargingStation(1,
		 * 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, "Singapore", "Teban", 0, 0, 0,
		 * "Singapore", "Singapore", 0); e.add(c); }
		 * System.out.println("Completed arraylist" + t1);
		 * 
		 * chargeServ.saveAll(e); Timestamp t2 = new
		 * Timestamp(System.currentTimeMillis());
		 * 
		 * System.out.println("End of program" + t2); // chargeServ.deleteAll();
		 */	}
}
