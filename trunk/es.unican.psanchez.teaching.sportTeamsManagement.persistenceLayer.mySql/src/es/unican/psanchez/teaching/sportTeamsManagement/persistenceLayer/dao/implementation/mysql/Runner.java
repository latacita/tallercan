package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.dao.implementation.mysql;

import java.util.Set;

import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ISportDao;

public class Runner {
	
	protected static void testAnhadirDeporte(String name) {
		
		Sport prueba = new Sport(name);
		ISportDao sportDao = new SportDaoMySqlImpl(); 
		sportDao.addSport(prueba);
		System.out.println("Fin añadir deporte " + name);

	} // testAnhadirDeporte
	
	protected static void testBorrarDeporte(String name) {
		
		ISportDao sportDao = new SportDaoMySqlImpl(); 
		sportDao.delete(name);
		System.out.println("Fin borrar deporte " + name);

	} // testAnhadirDeporte
	
	protected static void testObtenerDeportes() {
		
		ISportDao sportDao = new SportDaoMySqlImpl(); 
		Set<Sport> sports = sportDao.findAll();
		
		int i = 0;
		
		System.out.println(" Lista de deportes ");
		System.out.println("===================");
		
		for(Sport s : sports) {
			System.out.println("Deporte " + i++ + ": " + s.getName()); 
		} // for
		
		System.out.println("Fin listar deportes");

	} // testAnhadirDeporte
	
	public static void main(String args[]) {
		
		testAnhadirDeporte("PingPong");
		testAnhadirDeporte("Vela");
		
		testObtenerDeportes();
		
		testBorrarDeporte("Vela");
		testBorrarDeporte("PingPong");
	} // main 

} // Runner
