package bankingApp;



import com.ankita.bankingApp.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankTest {
	protected Currency CAD = new Currency("CAD", 0.75);
	protected Currency HKD= new Currency("HKD", 0.13);
	protected Bank RBC = new Bank("Royal Bank of Canada", CAD);
	protected Bank TD = new Bank("TD Bank", CAD);
	protected Bank HSBC = new Bank("Hong Kong Shanghai Banking Corporation", HKD);
	
	
	@Before
	public void setUp() throws Exception {
		
		// setup some test currencies
		this.HKD = new Currency("HKD", 0.13);
		this.CAD = new Currency("CAD", 0.75);
		
		// setup test banks
		this.RBC = new Bank("Royal Bank of Canada", CAD);
		this.TD = new Bank("TD Bank", CAD);
		this.HSBC = new Bank("Hong Kong Shanghai Banking Corporation", HKD);
		
		// add sample customers to the banks
		
		
		// HINT:  uncomment these lines AFTER you test the openAccount() function
		// You can quickly uncomment / comment by highlighting the lines of code and pressing 
		// CTRL + / on your keyboard  (or CMD + / for Macs)
		
		this.RBC.openAccount("Marcos");
		this.RBC.openAccount("Albert");
		this.TD.openAccount("Jigesha");
		this.HSBC.openAccount("Pritesh");
	}

	@Test
	public void testGetName() {
		//fail("Write test case here");
        assertEquals("TD Bank",TD.getName());
        assertEquals("Royal Bank of Canada",RBC.getName());
        assertEquals("Hong Kong Shanghai Banking Corporation",HSBC.getName());

	}

	@Test
	public void testGetCurrency() {
		//fail("Write test case here");
        assertEquals("CAD",RBC.getCurrency().getName());
        //this fails as expected is CAD
       // assertEquals("HKD",RBC.getCurrency().getName());
        assertEquals("HKD",HSBC.getCurrency().getName());
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.
		
		// See the example in class notes for testing exceptions.
		
		//fail("Write test case here");
		Exception exception = assertThrows(AccountExistsException.class, () -> {
			RBC.openAccount("Albert");

		});

		String expectedExceptionMessage = "Account Already Exist";
		String actualExceptionMessage = exception.getMessage();
		assertTrue(actualExceptionMessage.contains(expectedExceptionMessage));

		Exception exception1 = assertThrows(AccountExistsException.class, () -> {
			RBC.openAccount("Marcos");

		});

		String expectedExceptionMessage1 = "Account Already Exist";
		String actualExceptionMessage1 = exception1.getMessage();
		assertTrue(actualExceptionMessage1.contains(expectedExceptionMessage1));



	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.
		
		// See the example in class notes for testing exceptions.
		
		//fail("Write test case here");

		//created Albert's account with 30 CAD
		RBC.deposit("Albert",new Money(30,CAD));
		Exception exception = assertThrows(AccountDoesNotExistException.class, () -> {
			RBC.deposit("ABC",new Money(10,CAD));
			TD.deposit("DEF",new Money(20,CAD));

		});
		assertEquals(30,RBC.getBalance("Albert"),0.001);
		String expectedExceptionMessage = "Account Does Not Exist";
		String actualExceptionMessage = exception.getMessage();
		assertTrue(actualExceptionMessage.contains(expectedExceptionMessage));

	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.
		
		// See the example in class notes for testing exceptions.
		
		//fail("Write test case here");
		assertEquals(0,RBC.getBalance("Albert"),0.001);
		RBC.deposit("Marcos",new Money(150,CAD));
		assertEquals(15,RBC.getBalance("Albert"),0.001);
		RBC.withdraw("Marcos",new Money(20,CAD));
		assertEquals(10,RBC.getBalance("Albert"),0.001);
		Exception exception = assertThrows(AccountDoesNotExistException.class, () -> {
			RBC.withdraw("ABC",new Money(5,CAD));

		});
		assertEquals(130,RBC.getBalance("Albert"),0.001);
		String expectedExceptionMessage = "Account Does Not Exist";
		String actualExceptionMessage = exception.getMessage();
		assertTrue(actualExceptionMessage.contains(expectedExceptionMessage));

	}
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.
		
		// See the example in class notes for testing exceptions.
		
		//fail("Write test case here");
		TD.deposit("Jigesha",new Money(10,CAD));

		assertEquals(10,RBC.getBalance("Jigesha"),0.001);
		Exception exception = assertThrows(AccountDoesNotExistException.class, () -> {
			TD.getBalance("ABC");

		});
		String expectedExceptionMessage = "Account Does Not Exist";
		String actualExceptionMessage = exception.getMessage();
		assertTrue(actualExceptionMessage.contains(expectedExceptionMessage));

	}
	
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		// Note: You should test both types of transfers:
		// 1. Transfer from account to account
		RBC.deposit("Marcos",new Money(30,CAD));
		assertEquals(30,RBC.getBalance("Marcos"),0.001);
		RBC.deposit("Albert",new Money(10,CAD));
		assertEquals(10,RBC.getBalance("Albert"),0.001);
		RBC.transfer("Marcos","Albert",new Money(10,CAD));
		assertEquals(20,RBC.getBalance("Marcos"),0.001);

		// 2. Transfer between banks

		assertEquals(6,RBC.getBalance("Albert"),0.001);
		TD.deposit("Jigesha",new Money(50,CAD));
		assertEquals(50,TD.getBalance("Jigesha"),0.001);

		RBC.transfer("Marcos",TD,"Jigesha",new Money(10,CAD));
		assertEquals(40,TD.getBalance("Jigesha"),0.001);
		// See the Bank.java file for more details on Transfers
		//fail("Write test case here");



		Exception exception = assertThrows(AccountDoesNotExistException.class, () -> {
			RBC.transfer("Marcos","ABC",new Money(1,CAD));
		});
		assertEquals(20,RBC.getBalance("Marcos"),0.001);
		String expectedExceptionMessage = "Account Does Not Exist";
		String actualExceptionMessage = exception.getMessage();
		assertTrue(actualExceptionMessage.contains(expectedExceptionMessage));
	}
	
}
