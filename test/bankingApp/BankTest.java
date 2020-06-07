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

	}

	@Test
	public void testGetCurrency() {
		//fail("Write test case here");

	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.
		
		// See the example in class notes for testing exceptions.
		
		//fail("Write test case here");


	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.
		
		// See the example in class notes for testing exceptions.
		
		//fail("Write test case here");

	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.
		
		// See the example in class notes for testing exceptions.
		
		//fail("Write test case here");

	}
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.
		
		// See the example in class notes for testing exceptions.
		
		//fail("Write test case here");

	}
	
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		// Note: You should test both types of transfers:
		// 1. Transfer from account to account
		// 2. Transfer between banks
		// See the Bank.java file for more details on Transfers
		//fail("Write test case here");

	}
	
}
