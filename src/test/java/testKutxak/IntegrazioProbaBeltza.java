package testKutxak;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import businessLogic.BLFacadeImplementation;
import configuration.ConfigXML;
import dataAccess.DataAccess;
import domain.Bezero;
import domain.Erabiltzaile;
import domain.Event;
import domain.Question;
import exceptions.EventFinished;
import exceptions.QuestionAlreadyExist;
import testBusinessLogic.TestFacadeImplementation;
import static org.junit.Assert.*;

import org.junit.Test;

public class IntegrazioProbaBeltza {

	 static BLFacadeImplementation sut;
	 static TestFacadeImplementation testBL;

	 private Erabiltzaile e;
		private Erabiltzaile e2;
	
	@BeforeClass
	public static void setUpClass() {
		//sut= new BLFacadeImplementation();
		
		// you can parametrize the DataAccess used by BLFacadeImplementation
		DataAccess da= new DataAccess(ConfigXML.getInstance().getDataBaseOpenMode().equals("initialize"));
		sut=new BLFacadeImplementation();
		
		testBL= new TestFacadeImplementation();
	}
	
	@Test
	public void test1() {
		//define paramaters: erabiltzailea login-a eginda dauka eta dena ondo joan da- return USER
	
			try {
				
				Erabiltzaile newErab = new Bezero("Maria","Mena",21,"mariane123@mail.com","kaixo");
				
				e2= testBL.addUser(newErab);
				String posta = e2.getPosta();
				String pasahitza = e2.getPasahitza();
				e2 = sut.isLogin(posta, pasahitza);
				
				System.out.println("Hau da login egin duen bezeroa" + " " + e2);
				assertTrue(e2 != null);

			} catch (Exception e) {
				// e.printStackTrace();
				
				System.out.println("Txarto, ez zen hemen sartu behar");
				fail();
			}finally {
				  //Remove the created objects in the database (cascade removing)   
				boolean b= testBL.removeUser(e2);
				System.out.println("Finally m" + b);        
		        }
		
		
}
	@Test
	public void test2() {
		//define paramaters: posta ez da string bat, beste parametro bezala sartzen da, return NULL
		try {
	
		Erabiltzaile newErab = new Bezero("Maria","tubet",21,"mariaa@mail.com","kaixo");
		
		e2= testBL.addUser(newErab);
		String posta = "1234";
		String pasahitza = e2.getPasahitza();
		e2 = sut.isLogin(posta, pasahitza);
		
		System.out.println("Hau da login egin duen bezeroa" + " " + e2);
		assertTrue(e2 != null);

	} catch (Exception e) {
		// e.printStackTrace();
		
		System.out.println("Exception");
		fail();
	}finally {
		  //Remove the created objects in the database (cascade removing)   
		boolean b= testBL.removeUser(e2);
		System.out.println("Finally m" + b);        
        }
}
	
	@Test
	public void test3() {
		//define paramaters: posta null da, orduan return NULL, ez da existitzen
		try {
			
			Erabiltzaile newErab = new Bezero("Maria","tubet",21,null,"kaixo");
			
			e2= testBL.addUser(newErab);
			String posta = e2.getPosta();
			String pasahitza = e2.getPasahitza();
			e2 = sut.isLogin(posta, pasahitza);
			
			System.out.println("Hau da login egin duen bezeroa" + " " + e2);
			assertTrue(e2 != null);

		} catch (Exception e) {
			// e.printStackTrace();
			
			System.out.println("Exception");
			fail();
		}finally {
			  //Remove the created objects in the database (cascade removing)   
			boolean b= testBL.removeUser(e2);
			System.out.println("Finally m" + b);        
	        }
		
		

}
	
	@Test
	public void test4() {
		//define paramaters: pasahitza ez da string bat, return NULL
		try {
			
			Erabiltzaile newErab = new Bezero("Maria","tubet",21,"mariaa@mail.com","kaixo");
			
			e2= testBL.addUser(newErab);
			String posta = e2.getPosta();
			String pasahitza = "1234";
			e2 = sut.isLogin(posta, pasahitza);
			
			System.out.println("Hau da login egin duen bezeroa" + " " + e2);
			assertTrue(e2 != null);

		} catch (Exception e) {
			// e.printStackTrace();
			
			System.out.println("Exception");
			fail();
		}finally {
			  //Remove the created objects in the database (cascade removing)   
			boolean b= testBL.removeUser(e2);
			System.out.println("Finally m" + b);        
	        }
		

}
	
	@Test
	public void test5() {
		//define paramaters: pasahitza null da, return NULL
		try {
			
			Erabiltzaile newErab = new Bezero("Maria","tubet",21,"mariaa@mail.com",null);
			
			e2= testBL.addUser(newErab);
			String posta = e2.getPosta();
			String pasahitza = e2.getPasahitza();
			e2 = sut.isLogin(posta, pasahitza);
			
			System.out.println("Hau da login egin duen bezeroa" + " " + e2);
			assertTrue(e2 != null);

		} catch (Exception e) {
			// e.printStackTrace();
			
			System.out.println("Exception");
			fail();
		}finally {
			  //Remove the created objects in the database (cascade removing)   
			boolean b= testBL.removeUser(e2);
			System.out.println("Finally m" + b);        
	        }
}
	
	@Test
	public void test6() {
		//define paramaters: sartzen den posta existitzen da baina ez du bat egiten bestearekin, return NULL
		try {
			
			Erabiltzaile newErab = new Bezero("Maria","tubet",21,"mariaa@mail.com","kaixo");
			
			e2= testBL.addUser(newErab);
			String posta = e2.getPosta();
			String pasahitza = e2.getPasahitza();
			e2 = sut.isLogin("mariannnnnnn@mail,com", pasahitza);
			
			System.out.println("Hau da login egin duen bezeroa" + " " + e2);
			assertTrue(e2 != null);

		} catch (Exception e) {
			// e.printStackTrace();
			
			System.out.println("Exception");
			fail();
		}finally {
			  //Remove the created objects in the database (cascade removing)   
			boolean b= testBL.removeUser(e2);
			System.out.println("Finally m" + b);        
	        }

}
	
	@Test
	public void test7() {
		//define paramaters: sartzen den posta ondo dago baina pasahitza ez du bat egiten, return NULL
try {
			
			Erabiltzaile newErab = new Bezero("Maria","tubet",21,"mariaa@mail.com","kaixo");
			
			e2= testBL.addUser(newErab);
			String posta = e2.getPosta();
			String pasahitza = e2.getPasahitza();
			e2 = sut.isLogin(posta, "12345463578");
			
			System.out.println("Hau da login egin duen bezeroa" + " " + e2);
			assertTrue(e2 != null);

		} catch (Exception e) {
			// e.printStackTrace();
			
			System.out.println("Exception");
			fail();
		}finally {
			  //Remove the created objects in the database (cascade removing)   
			boolean b= testBL.removeUser(e2);
			System.out.println("Finally m" + b);        
	        }
		
		

}


}
