package testKutxak;

import static org.junit.Assert.*;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import configuration.ConfigXML;
import dataAccess.DataAccess;
import domain.Erabiltzaile;
import domain.Event;
import exceptions.QuestionAlreadyExist;
import testBusinessLogic.TestFacadeImplementation;

public class testKutxaBeltza {
	
	static DataAccess sut=new DataAccess(ConfigXML.getInstance().getDataBaseOpenMode().equals("initialize"));;
	static TestFacadeImplementation testBL=new TestFacadeImplementation();;

	private Erabiltzaile e;
	private Erabiltzaile e2;
	@Test
	public void test1() {
		//define paramaters: erabiltzailea login-a eginda dauka eta dena ondo joan da- return USER
	
			try {
				
				String posta = "larrea@mail.com";
				String pasahitza = "12345678";
				

				e2 = sut.isLogin(posta, pasahitza);
				
				System.out.println("Hau da login egin duen bezeroa" + " " + e2);
				assertTrue(e2 != null);

			} catch (Exception e) {
				// e.printStackTrace();
				
				System.out.println("Txarto, ez zen hemen sartu behar");
				fail();
			}
		
		
}
	@Test
	public void test2() {
		//define paramaters: posta ez da string bat, beste parametro bezala sartzen da, return NULL
		
		try {
			
			String posta = "12345";
			String pasahitza = "aa";
			
			
			e= sut.isLogin(posta, pasahitza);
			System.out.println("Hau da ez dagoela erabiltzailerik orduan null bueltatu behar du" + "=" + " "+ e2);
			assertTrue(e2==null); //ez dago erabiltzailerik
			
			
			
		}catch (Exception e) {
			// e.printStackTrace();
		
			System.out.println("Return null");
			fail();
		}
}
	
	@Test
	public void test3() {
		//define paramaters: posta null da, orduan return NULL, ez da existitzen
		try {
			
			String posta = null;
			String pasahitza = "123456789";
			
			e2 = sut.isLogin(posta, pasahitza);
			
			System.out.println("NullPointerException eman behar du, erabiltzailea = " + e2);
			assertTrue(e2 != null);

		} catch (Exception e) {
			e.printStackTrace();
			
			System.out.println("NULLPOINTEREXPECTION1");
			fail();
		}
		
		

}
	
	@Test
	public void test4() {
		//define paramaters: pasahitza ez da string bat, return NULL
		
		try {
			
			String posta = "mariane78@mail.com";
			int pasahitza = 123456789;
			
			
		}catch (Exception e) {
			e.printStackTrace();
		
			System.out.println("Return null");
			fail();
		}		
		
		

}
	
	@Test
	public void test5() {
		//define paramaters: pasahitza null da, return NULL
		try {
			
			String posta = "mariane@mail.com";
			String pasahitza = null;
			
			e2 = sut.isLogin(posta, pasahitza);
			
			System.out.println("NullPointerException eman behar du, erabiltzailea = " + e2);
			assertTrue(e2 != null);

		} catch (Exception e) {
			System.out.println("NULLPOINTEREXPECTION2");
			e.printStackTrace();
			fail();
		}
}
	
	@Test
	public void test6() {
		//define paramaters: sartzen den posta existitzen da baina ez du bat egiten bestearekin, return NULL
		try {
			
			String posta = "mariane@mail.com";
			String pasahitza = "12345678";	
			e= sut.isLogin("mm@mail.com2", pasahitza);
			
			assertTrue(e!= null);

		} catch (Exception e) {
			System.out.println("Ez dute bat egiten");
			e.printStackTrace();
			fail();
		}
		

}
	
	@Test
	public void test7() {
		//define paramaters: sartzen den posta ondo dago baina pasahitza ez du bat egiten, return NULL
		try {
			
			String posta = "mariane78@mail.com";
			String pasahitza = "123456789";
			
			e2 = sut.isLogin(posta, "1234");
			
			System.out.println(e2);
			fail();

		} catch (Exception e) {
			// e.printStackTrace();
			
			System.out.println("Ez dute bat egiten");
			assertTrue(true);
		}
		
		

}
	
}
