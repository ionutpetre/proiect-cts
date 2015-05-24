package tests;

import junit.framework.TestCase;
import models.Address;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ZipCodeAddressTests extends TestCase {

	private Address address;

	public ZipCodeAddressTests(String name) {
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
	public void testZipCodeAddressCorrect() {
		try {
			this.address.setZipCode("137340");
			assertEquals("137340", this.address.getZipCode());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Test
	public void testZipCodeAddressWrong1() {
		try {
			this.address.setZipCode(null);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertNull(null, this.address.getZipCode());
		}
	}

	@Test(expected = AssertionError.class)
	public void testZipCodeAddressWrong2() {
		try {
			this.address.setZipCode("12345");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertEquals("12345", this.address.getZipCode());
		}
	}

	@Test(expected = AssertionError.class)
	public void testZipCodeAddressWrong3() {
		try {
			this.address.setZipCode("193456");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertEquals("193456", this.address.getZipCode());
		}
	}

	@Test(expected = AssertionError.class)
	public void testZipCodeAddressWrong4() {
		try {
			this.address.setZipCode("1.3.6");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertEquals("1.3.6", this.address.getZipCode());
		}
	}

	@After
	public void tearDown() throws Exception {
		this.address = null;
	}
}
