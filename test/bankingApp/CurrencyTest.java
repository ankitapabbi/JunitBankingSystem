package bankingApp;



import com.ankita.bankingApp.Currency;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class CurrencyTest {
	
	/* Example currencies: 
	 * 	CAD = Canadian dollar
	 * 	EUR = Euros
	 * 	GBP = Great British Pounds
	 * 	HKD = Hong Kong Dollars
	 */
	public Currency CAD= new Currency("CAD", 0.75),
			EUR= new Currency("EUR", 1.14),
			GBP= new Currency("GBP", 1.26),
			HKD= new Currency("HKD", 0.13);
	
	@Before
	public void setUp() throws Exception {
		// Setup some test currencies to use in the below test cases
		CAD = new Currency("CAD", 0.75);
		EUR = new Currency("EUR", 1.14);
		HKD = new Currency("HKD", 0.13);
	}

	@Test
	public void testGetName() {
		// Write the test case for testing the getName() function
		assertEquals("GBP",GBP.getName());
		assertEquals("HKD",HKD.getName());
		assertEquals("CAD",CAD.getName());
		assertEquals("EUR",EUR.getName());
		//fail("Write test case here");
	}
	
	@Test
	public void testGetRate() {
		// @TODO: Write the test case for testing the getRate() function
		//fail("Write test case here");
		assertEquals(0,Double.compare(0.75,CAD.getRate()));
		assertEquals(1.26,GBP.getRate(),0.001);
		assertEquals(0.13,HKD.getRate(),0.001);
	}
	
	@Test
	public void testSetRate() {
		// @TODO: Write the test case for testing the setRate() function
		
		// For this function, you should do:
		// 1. Assert that the oldRate is correct
		// 2. Change the rate
		// 3. Assert that the newRate is correct
		// You will end up with 2 assert() statements in this function.
		//fail("Write test case here");
		assertEquals(0,Double.compare(0.75,CAD.getRate()));
		CAD.setRate(0.76);
		assertEquals(0,Double.compare(0.76,CAD.getRate()));

		assertEquals(1.14,EUR.getRate(),0.001);
		CAD.setRate(1.15);
		assertEquals(1.14,EUR.getRate(),0.001);

		assertEquals(1.26,GBP.getRate(),0.001);
		CAD.setRate(1.30);
		assertEquals(1.26,GBP.getRate(),0.001);
	}
	
	@Test
	public void testValueInUSD() {
		// @TODO: Write the test case for testing the valueInUSD() function
		//fail("Write test case here");
		assertEquals(0,Double.compare(7.5,CAD.valueInUSD(10)));
		assertEquals(7.5,CAD.valueInUSD(10),0.001); //Alternative Assert
		assertEquals(0,Double.compare(11.4,EUR.valueInUSD(10)));
		assertEquals(11.4,EUR.valueInUSD(10),0.001); //Alternative Assert
		assertEquals(0,Double.compare(12.6,GBP.valueInUSD(10)));
		assertEquals(12.6,GBP.valueInUSD(10),0.001);
		//assertEquals(0,Double.compare(1.3,HKD.valueInUSD(10)));
		//assertEquals(1.3,HKD.valueInUSD(10),0.001);
	}
	
	@Test
	public void testValueInThisCurrency() {
		// @TODO: Write the test case for testing the valueInThisCurrency() function
		// For this function, you should:
		// 1. Assert the value of the "other" currency
		// 2. Get the value in "this" currency
		// 3. Assert that the value in "this" currency is correct
		// You will end up with 2 assert() statements in this function.
		//fail("Write test case here");
		assertEquals(15.2,CAD.valueInThisCurrency(10,EUR),0.001);
		assertEquals(0,Double.compare(15.2,CAD.valueInThisCurrency(10,EUR)));
		assertEquals(16.8,CAD.valueInThisCurrency(10,GBP),0.001);
		//assertEquals(1.73,CAD.valueInThisCurrency(10,HKD),0.001);
	}

}
