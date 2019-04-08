package com.scorpio.service;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;
import org.hibernate.SessionFactory;
import com.scorpio.entity.ChargingStation;
import com.scorpio.repository.ChargingStationRepository;

@Service
public class ChargingStnService {
	@Autowired
	private ChargingStationRepository chargingstnrep;

	/*
	 * public void addStn() { int entityCount = 100; int batchSize = 50;
	 * 
	 * EntityManager entityManager = null; EntityTransaction et = null;
	 * 
	 * try { entityManager =
	 * Persistence.createEntityManagerFactory("unit1").createEntityManager();
	 * 
	 * et = entityManager.getTransaction(); et.begin();
	 * 
	 * Timestamp t1 = new Timestamp(System.currentTimeMillis());
	 * System.out.println("Method execution started at:" + t1); for (int i = 0; i <
	 * entityCount; ++i) { Timestamp timestamp = new
	 * Timestamp(System.currentTimeMillis()); ChargingStation stn = new
	 * ChargingStation(1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, "Singapore",
	 * "Teban", 0, 0, 0, "Singapore", "Singapore", 0); entityManager.persist(stn);
	 * 
	 * if (i > 0 && i % batchSize == 0) { entityManager.flush();
	 * entityManager.clear(); } }
	 * 
	 * et.commit(); Timestamp t2 = new Timestamp(System.currentTimeMillis());
	 * System.out.println("Method commited at:" + t2); } catch (RuntimeException e)
	 * { if (et != null && et.isActive()) { et.rollback(); } throw e; } finally { if
	 * (entityManager != null) {
	 * 
	 * entityManager.close(); Timestamp t3 = new
	 * Timestamp(System.currentTimeMillis());
	 * System.out.println("Method stopped at:" + t3);
	 * 
	 * } } }
	 */

	/*
	 * public void addStn(ArrayList<ChargingStation> e) { Timestamp timestamp = new
	 * Timestamp(System.currentTimeMillis());
	 * System.out.println("Begin Transaction : " + timestamp); int batchSize = 1000;
	 * EntityManager em =
	 * Persistence.createEntityManagerFactory("unit1").createEntityManager();
	 * EntityTransaction et = em.getTransaction();
	 * 
	 * Iterator<ChargingStation> iterator = e.iterator(); et.begin(); int cont = 0;
	 * int idSeq = 1; while (iterator.hasNext()) { ChargingStation c =
	 * iterator.next(); c.setChargingStnID(idSeq++); em.persist(c); cont++; if (cont
	 * % batchSize == 0) { em.flush(); em.clear(); et.commit(); et.begin(); } }
	 * et.commit(); Timestamp t2 = new Timestamp(System.currentTimeMillis());
	 * System.out.println("End Transaction : " + t2);
	 * 
	 * }
	 */
	

	public <S extends ChargingStation> S save(S entity) {
		return chargingstnrep.save(entity);
	}

	public <S extends ChargingStation> Iterable<S> saveAll(Iterable<S> entities) {
		return chargingstnrep.saveAll(entities);
	}

	public Optional<ChargingStation> findById(Long id) {
		return chargingstnrep.findById(id);
	}

	public boolean existsById(Long id) {
		return chargingstnrep.existsById(id);
	}

	public Iterable<ChargingStation> findAll() {
		return chargingstnrep.findAll();
	}

	public Iterable<ChargingStation> findAllById(Iterable<Long> ids) {
		return chargingstnrep.findAllById(ids);
	}

	public long count() {
		return chargingstnrep.count();
	}

	public void deleteById(Long id) {
		chargingstnrep.deleteById(id);
	}

	public void delete(ChargingStation entity) {
		chargingstnrep.delete(entity);
	}

	public void deleteAll(Iterable<? extends ChargingStation> entities) {
		chargingstnrep.deleteAll(entities);
	}

	public void deleteAll() {
		chargingstnrep.deleteAll();
	}
}
