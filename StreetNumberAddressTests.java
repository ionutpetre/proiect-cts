package tests;

import junit.framework.TestCase;
import models.Address;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StreetNumberAddressTests extends TestCase {

	private Address address;

	public StreetNumberAddressTests(String name) {
		super(name);
	}
	
	@Before
	public void setUp() {
		try {
			this.address = new Address();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Test
	public void testStreetNumberAddressCorrect() {
		try {
			this.address.setStreetNumber(123);
			assertEquals(new Integer(123), this.address.getStreetNumber());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Test
	public void testStreetNumberAddressWrong1() {
		try {
			this.address.setStreetNumber(null);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertNull(null, this.address.getStreetNumber());
		}
	}

	@Test(expected = AssertionError.class)
	public void testStreetNumberAddressWrong2() {
		try {
			this.address.setStreetNumber(-1);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertEquals(new Integer(-1), this.address.getStreetNumber());
		}
	}

	@After
	public void tearDown() throws Exception {
		this.address = null;
	}
}
