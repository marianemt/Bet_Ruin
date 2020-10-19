package testDataAccess;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import configuration.ConfigXML;
import domain.Event;
import domain.Bezero;
import domain.Erabiltzaile;
import dataAccess.DataAccess;

public class TestDataAccess {
	protected  EntityManager  db;
	protected  EntityManagerFactory emf;

	ConfigXML  c=ConfigXML.getInstance();


	public TestDataAccess()  {
		
		System.out.println("Creating TestDataAccess instance");

		open();
		
	}

	public void open(){
		
		System.out.println("Opening TestDataAccess instance ");

		String fileName=c.getDbFilename();
		
		if (c.isDatabaseLocal()) {
			  emf = Persistence.createEntityManagerFactory("objectdb:"+fileName);
			  db = emf.createEntityManager();
		} else {
			Map<String, String> properties = new HashMap<String, String>();
			  properties.put("javax.persistence.jdbc.user", c.getUser());
			  properties.put("javax.persistence.jdbc.password", c.getPassword());

			  emf = Persistence.createEntityManagerFactory("objectdb://"+c.getDatabaseNode()+":"+c.getDatabasePort()+"/"+fileName, properties);

			  db = emf.createEntityManager();
    	   }
		
	}
	public void close(){
		db.close();
		System.out.println("DataBase closed");
	}

	/*public boolean removeEvent(Event ev) {
		System.out.println(">> DataAccessTest: removeEvent");
		Event e = db.find(Event.class, ev.getEventNumber());
		if (e!=null) {
			db.getTransaction().begin();
			db.remove(e);
			db.getTransaction().commit();
			return true;
		} else 
		return false;
    }
		
		public Event addEvent(String desc, Date d) {
			System.out.println(">> DataAccessTest: addEvent");
			Event ev=null;
				db.getTransaction().begin();
				try {
				    ev=new Event(desc,d);
					db.persist(ev);
					db.getTransaction().commit();
				}
				catch (Exception e){
					e.printStackTrace();
				}
				return ev;
	    }*/

		public boolean removeUser(Erabiltzaile e) {
			System.out.println(">> DataAccessTest: removeErabiltzaile");
			Erabiltzaile e1 = db.find(Erabiltzaile.class, e.getPosta());
			if (e1!=null) {
				db.getTransaction().begin();
				db.remove(e1);
				db.getTransaction().commit();
				return true;
			} else 
			return false;
	    }
		
		public Erabiltzaile addUser(Erabiltzaile e) {
			System.out.println(">> DataAccessTest: addErabiltzaile");
			Erabiltzaile e1= null;
			db.getTransaction().begin();
			try {
				e = new Bezero();
				db.persist(e);
				db.getTransaction().commit();
				return e;
			} catch (Exception e3){
				e3.printStackTrace();
			}	
			return null;
	    }
		
		
		
		
		
}

