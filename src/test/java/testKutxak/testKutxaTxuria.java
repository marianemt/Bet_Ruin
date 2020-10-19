package testKutxak;

import static org.junit.Assert.*;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.Test;

import configuration.ConfigXML;
import dataAccess.DataAccess;
import businessLogic.*;
import domain.Bezero;
import domain.Erabiltzaile;
import domain.Event;
import exceptions.QuestionAlreadyExist;
import testBusinessLogic.TestFacadeImplementation;
import testDataAccess.TestDataAccess;

public class testKutxaTxuria {

	static DataAccess sut = new DataAccess(ConfigXML.getInstance().getDataBaseOpenMode().equals("initialize"));;
	static TestFacadeImplementation testBL = new TestFacadeImplementation();;
	
	private Erabiltzaile e;
	private Erabiltzaile e2;
	@Test
	public void test1() {
		// return null, lehenengo if-a FALSE delako
		try {
			//define parameters
	
			String posta = "mariane@mail.com";
			String pasahitza = null;
			/*Erabiltzaile newErab = new Bezero("Mariane","Menath",21,"mariane@mail.com","12345678");
			 * e.setIzena("Maria");
			e.setAbizena("Marin");
			e.setAdina(12);
			e.setPosta(posta);
			e.setPasahitza(pasahitza);
			e2 = testBL.addUser(e);
			sut.storeUser(e2);*/
			e2= sut.isLogin(posta, pasahitza);
			System.out.println(e2);
			
			//assertTrue(newUser == 0); // user was created in the database
			
			//assertTrue(e != null);
			fail();
		} catch (Exception e) {
			 e.printStackTrace();
			assertTrue(true);
			System.out.println("Lehenengo IF(F) bada, return null");
		
		}
	}
	@Test
	public void test2() {
		// return USER, bi if-ak TRUE direlako

		try {
			
			String posta = "mariane@mail.com";
			String pasahitza = "12345678";
			/*e.setIzena("Mariane");
			e.setAbizena("Menath");
			e.setAdina(20);
			e.setPasahitza(pasahitza);
			e.setPosta(posta);
			e2 = testBL.addUser(e);
			int newuser = sut.storeUser(e2);
			assertTrue(newuser == 0); // user was created in the database*/

			e2 = sut.isLogin(posta, pasahitza);
			
			System.out.println(e2);
			assertTrue(e2 != null);

		} catch (Exception e) {
			// e.printStackTrace();
			
			System.out.println("Txarto, ez zen hemen sartu behar");
			fail();
		}
		/*finally {
			  //Remove the created objects in the database (cascade removing)   
			boolean b= sut.removeUser(e);
			System.out.println("Finally m" + b);        
	        }*/
		
	}
	
	@Test
	public void test3() {
		//return NULL, lehenengo if-a TRUE da baina ez du bat egiten posta eta pasahitza
			try {
			
				String posta = "larrea@mail.com";
				String pasahitza = "12345678";
				/*e.setIzena("Maria");
				e.setAbizena("Menath");
				e.setAdina(21);
				e.setPasahitza(pasahitza);
				e.setPosta(posta);
				int newuser= sut.storeUser(e);
				
				assertTrue(newuser==0); //user was created in the database
				*/
				e2=sut.isLogin(posta, "1234");
				System.out.println("Hau da ez dagoela erabiltzailerik orduan null bueltatu behar du" + "=" + " "+ e2);
				assertTrue(e2==null); //ez dago erabiltzailerik
				
			}catch (Exception e) {
				// e.printStackTrace();
				
				System.out.println("NULL-2");
				fail();
			}
		
		

}

}
