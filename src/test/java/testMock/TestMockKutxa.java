package testMock;

import static org.junit.Assert.*;
import testBusinessLogic.TestFacadeImplementation;
import testDataAccess.TestDataAccess;
import domain.*;
import businessLogic.*;
import dataAccess.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class TestMockKutxa {

	 DataAccess dataAccess=Mockito.mock(DataAccess.class);
     //Event mockedEvent=Mockito.mock(Event.class);
	Erabiltzaile mockedErabiltzaile = Mockito.mock(Erabiltzaile.class);
	@InjectMocks
	 BLFacade sut=new BLFacadeImplementation(dataAccess);
	
	Erabiltzaile e;
	Erabiltzaile e2;
	@Test
	public void test1() {
		//define paramaters: erabiltzailea login-a eginda dauka eta dena ondo joan da- return USER
	
			try {
				
				String posta = "larrea@mail.com";
				String pasahitza = "12345678";
				String izena = "Maria";
				String abizena = "larrea";
				int adina = 21;
				String posta1 = null;
				e2= new Bezero(izena, abizena, adina, posta, pasahitza);
				Mockito.doReturn(e2).when(dataAccess).isLogin(Mockito.any(String.class), Mockito.any(String.class));
				
				
				e = sut.isLogin(posta, pasahitza);
				
				assertEquals(e, e2);

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
			String pasahitza = "kaixo";
			String izena = "Maria";
			String abizena = "larrea";
			int adina = 21;
			
			e2= new Bezero(izena, abizena, adina, posta, pasahitza);
			Mockito.doThrow(new Exception()).when(dataAccess).isLogin(Mockito.any(String.class), Mockito.any(String.class));
			
			e = sut.isLogin(posta, pasahitza);
			fail();
			
			
		}catch (Exception e) {
			// e.printStackTrace();
			assertTrue(true);
			System.out.println("Return null");
			
		}
}
	
	@Test
	public void test3() {
		//define paramaters: posta null da, orduan return NULL, ez da existitzen
		try {
			
			String posta = null;
			String pasahitza = "kaixo";
			String izena = "Maria";
			String abizena = "larrea";
			int adina = 21;
			
			e2= new Bezero(izena, abizena, adina, posta, pasahitza);
			Mockito.doThrow(new Exception()).when(dataAccess).isLogin(Mockito.any(String.class), Mockito.any(String.class));
			
			e = sut.isLogin(posta, pasahitza);
			fail();
			
			
		}catch (Exception e) {
			// e.printStackTrace();
			assertTrue(true);
			System.out.println("NULLPOINTEREXCEPTION");
			
		}
		
		

}
	
	@Test
	public void test4() {
		//define paramaters: pasahitza ez da string bat, return NULL
		try {
			
			String posta = "marianee@mail.com";
			String pasahitza = "111111111111111111111111111111111111111111";
			String izena = "Maria";
			String abizena = "larrea";
			int adina = 21;
			
			e2= new Bezero(izena, abizena, adina, posta, pasahitza);
			Mockito.doThrow(new Exception()).when(dataAccess).isLogin(Mockito.any(String.class), Mockito.any(String.class));
			
			e = sut.isLogin(posta, pasahitza);
			fail();
			
			
		}catch (Exception e) {
			// e.printStackTrace();
			assertTrue(true);
			System.out.println("Return null");
			
		}
		
		

}
	
	@Test
	public void test5() {
		//define paramaters: pasahitza null da, return NULL
		try {
			
			String posta = "mariane@mail.com";
			String pasahitza = null;
			String izena = "Maria";
			String abizena = "larrea";
			int adina = 21;
			
			e2= new Bezero(izena, abizena, adina, posta, pasahitza);
			Mockito.doThrow(new Exception()).when(dataAccess).isLogin(Mockito.any(String.class), Mockito.any(String.class));
			
			e = sut.isLogin(posta, pasahitza);
			fail();
			
			
		}catch (Exception e) {
			// e.printStackTrace();
			assertTrue(true);
			System.out.println("NULLPOINTEREXCEPTION2");
			
		}
}
	
	@Test
	public void test6() {
		//define paramaters: sartzen den posta existitzen da baina ez du bat egiten bestearekin, return NULL
		try {
			
			String posta = "larrea@mail.com";
			String pasahitza = "12345678";
			String izena = "Maria";
			String abizena = "larrea";
			int adina = 21;
			String posta1 = null;
			e2= new Bezero(izena, abizena, adina, posta, pasahitza);
			Mockito.doReturn(e2).when(dataAccess).isLogin(Mockito.any(String.class), Mockito.any(String.class));
			
			
			e = sut.isLogin("mariane@mail.com", pasahitza);
			Mockito.doThrow(new Exception()).when(dataAccess).isLogin(Mockito.any(String.class), Mockito.any(String.class));
			fail();

		} catch (Exception e) {
			// e.printStackTrace();
			
			System.out.println("Ez dute bat egiten");
			assertTrue(true);
		}
	
		

}
	
	@Test
	public void test7() {
		//define paramaters: sartzen den posta ondo dago baina pasahitza ez du bat egiten, return NULL
		try {
			
			String posta = "larrea@mail.com";
			String pasahitza = "12345678";
			String izena = "Maria";
			String abizena = "larrea";
			int adina = 21;
			String posta1 = null;
			e2= new Bezero(izena, abizena, adina, posta, pasahitza);
			Mockito.doReturn(e2).when(dataAccess).isLogin(Mockito.any(String.class), Mockito.any(String.class));
			
			
			e = sut.isLogin(posta, "12");
			Mockito.doThrow(new Exception()).when(dataAccess).isLogin(Mockito.any(String.class), Mockito.any(String.class));
			fail();

		} catch (Exception e) {
			// e.printStackTrace();
			
			System.out.println("Ez dute bat egiten");
			assertTrue(true);
		}
		
		

}
}
