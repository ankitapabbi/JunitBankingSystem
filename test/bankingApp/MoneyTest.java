package bankingApp;


import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.jupiter.api.Assertions.*;

import com.ankita.bankingApp.Currency;
import com.ankita.bankingApp.Money;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class MoneyTest {
	protected Currency CAD = new Currency("CAD", 0.75),
            HKD= new Currency("HKD", 0.13),
            NOK, EUR= new Currency("EUR", 1.14);
	protected Money CAD100 = new Money(100, CAD),
            CAD10= new Money(10, CAD),
            EUR10= new Money(10, EUR),
            CAD200= new Money(200, CAD),
            EUR20= new Money(20, EUR),
            CAD0= new Money(0, CAD),
            EUR0= new Money(0, EUR),
            CADnegative100= new Money(-100, CAD);

	@Before
	public void setUp() throws Exception {
		// setup sample currencies
		CAD = new Currency("CAD", 0.75);
		HKD = new Currency("HKD", 0.13);
		EUR = new Currency("EUR", 1.14);

		// setup sample money amounts
		CAD100 = new Money(100, CAD);

		EUR10 = new Money(10, EUR);
		CAD200 = new Money(200, CAD);
		EUR20 = new Money(20, EUR);
		CAD0 = new Money(0, CAD);
		EUR0 = new Money(0, EUR);
		CADnegative100 = new Money(-100, CAD);
	}

	@Test
	public void testGetAmount() {
		//fail("Write test case here");
		if(CAD100.getAmount()!=0) {
			assertEquals(100, CAD100.getAmount(), 0.001);
		}
        assertEquals(0,Double.compare(100,CAD100.getAmount()));
        assertEquals(0,Double.compare(10,EUR10.getAmount()));
	}

	@Test
	public void testGetCurrency() {
		//fail("Write test case here");
		assertEquals(new Currency("CAD",0.75).getName(),CAD100.getCurrency().getName());
        assertEquals(new Currency("EUR",1.14).getName(),EUR20.getCurrency().getName());
        assertEquals(new Currency("EUR",0.13).getName(),EUR10.getCurrency().getName());
        assertNotEquals(new Currency("CAD",0.75),CAD100.getCurrency());


	}

	@Test
	public void testToString() {
		//fail("Write test case here");
        assertEquals("100.0 CAD",CAD100.toString());
        assertEquals("200.0 CAD",CAD200.toString());
        assertEquals("10.0 EUR",EUR10.toString());
        assertEquals("20.0 EUR",EUR20.toString());
	}

	@Test
	public void testGetUniversalValue() {
		//fail("Write test case here");
        assertEquals(75,CAD100.getUniversalValue(),0.001);
       assertEquals(150,CAD200.getUniversalValue(),0.001);
        assertEquals(22.8,EUR20.getUniversalValue(),0.001);
        assertEquals(11.4,EUR10.getUniversalValue(),0.001);
        assertEquals(0,Double.compare(75,CAD100.getUniversalValue()));

	}

	@Test
	public void testEqualsMoney() {
		//fail("Write test case here");
        assertFalse(CAD100.equals(CAD200));
        assertTrue(CAD100.equals(CAD100));
        assertTrue(EUR20.equals(EUR20));
        assertTrue(EUR10.equals(EUR10));
	}

	@Test
	public void testAdd() {
	//	fail("Write test case here");
        Money CAD300 = CAD100.add(CAD10);
        assertEquals(110.0,CAD300.getAmount(),0.001);
        assertEquals(0,Double.compare(110.0,CAD300.getAmount()));
        Money CADx = CAD100.add(EUR20);
        assertEquals(130.4,CADx.getAmount(),0.001);
        assertEquals(0,Double.compare(130.4,CADx.getAmount()));
	}

	@Test
	public void testSubtract() {
		//fail("Write test case here");
        Money CAD190 = CAD200.subtract(CAD10);
        assertEquals(190.0,CAD190.getAmount(),0.001);
        assertEquals(0,Double.compare(190.0,CAD190.getAmount()));
        Money CADx = CAD100.subtract(EUR20);
        assertEquals(69.6,CADx.getAmount(),0.001);
        assertEquals(0,Double.compare(69.6,CADx.getAmount()));
	}

	@Test
	public void testIsZero() {
	//	fail("Write test case here");
        assertTrue(CAD0.isZero());
        assertTrue(EUR0.isZero());
        assertFalse(CAD100.isZero());
        assertFalse(EUR10.isZero());
	}

	@Test
	public void testNegate() {
		//fail("Write test case here");
        assertEquals(100.0,CADnegative100.negate().getAmount(),0.001);
        assertEquals(-100.0,CAD100.negate().getAmount(),0.001);
	}

	@Test
	public void testCompareTo() {
		//fail("Write test case here");
        assertEquals(-1,CAD100.compareTo(CAD200));
        assertEquals(1,CAD100.compareTo(CAD10));
        assertEquals(0,CAD100.compareTo(CAD100));
        assertEquals(1,CAD100.compareTo(EUR20));
	}
}
