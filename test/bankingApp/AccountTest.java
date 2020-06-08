package bankingApp;

import com.ankita.bankingApp.Account;
import com.ankita.bankingApp.Bank;
import com.ankita.bankingApp.Currency;
import com.ankita.bankingApp.Money;
import org.junit.Before;
import org.junit.Test;



import static org.junit.Assert.*;

public class AccountTest {
	protected Currency CAD =new Currency("CAD", 0.75), HKD;
	protected Bank TD;
	protected Bank HSBC;
	protected Bank RBC = new Bank("Royal Bank of Canada", CAD);
	protected Account testAccount = new Account("Albert", CAD);
	
	@Before
	public void setUp() throws Exception {
		
		// setup test currencies
		CAD = new Currency("CAD", 0.75);
		RBC = new Bank("Royal Bank of Canada", CAD);
		
		// setup test accounts
		RBC.openAccount("Peter");
		testAccount = new Account("Albert", CAD);
		testAccount.deposit(new Money(100, CAD));

		// setup an initial deposit
		RBC.deposit("Peter", new Money(500, CAD));
	}

	@Test
	public void testAddWithdraw() {
		// Something to consider - can you withdraw in a different currency?
		//fail("Write test case here");
		testAccount.deposit(new Money(100, CAD));
		assertEquals(200,testAccount.getBalance().getAmount(),0.001);
		testAccount.withdraw(new Money(20, CAD));
		assertEquals(180,testAccount.getBalance().getAmount(),0.001);


	}
	
	@Test
	public void testGetBalance() {
		//fail("Write test case here");
		testAccount.deposit(new Money(100, CAD));
		assertEquals(200,testAccount.getBalance().getAmount(),0.001);
		testAccount.deposit(new Money(10,HKD));
		assertEquals(151.73,testAccount.getBalance().getAmount(),0.001);

//		testAccount.deposit(new Money(50, CAD));
//		assertEquals(250,testAccount.getBalance().getAmount(),0.001);
	}
}
