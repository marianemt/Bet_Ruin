package testBusinessLogic;


import java.util.Date;

import configuration.ConfigXML;
import domain.Erabiltzaile;
import domain.Event;
import testDataAccess.TestDataAccess;

public class TestFacadeImplementation {
	TestDataAccess dbManagerTest;
 	
    
	   public TestFacadeImplementation()  {
			
			System.out.println("Creating TestFacadeImplementation instance");
			ConfigXML c=ConfigXML.getInstance();
			dbManagerTest=new TestDataAccess(); 
			dbManagerTest.close();
		}
		
	 
		/*public boolean removeEvent(Event ev) {
			dbManagerTest.open();
			boolean b=dbManagerTest.removeEvent(ev);
			dbManagerTest.close();
			return b;

		}
		
		public Event addEvent(String desc, Date d) {
			dbManagerTest.open();
			Event o=dbManagerTest.addEvent(desc,d);
			dbManagerTest.close();
			return o;

		}*/
	 
	   public boolean removeUser(Erabiltzaile e) {
			dbManagerTest.open();
			boolean b=dbManagerTest.removeUser(e);
			dbManagerTest.close();
			return b;
	    }
		
		public Erabiltzaile addUser(Erabiltzaile e) {
			dbManagerTest.open();
			Erabiltzaile e1=dbManagerTest.addUser(e);
			dbManagerTest.close();
			return e1;
	    }
		
		/*
		 public Erabiltzaile isLogin(String posta, String pasahitza){
		 	dbManagerTest.open();
		 	Erabiltzaile e=dbManagerTest.isLogin(posta, pasahitza);
		 	dbManagerTest.close();
		 	return e;
		 
		 
		 */

}

