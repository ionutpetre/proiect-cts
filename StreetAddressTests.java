package tests;

import junit.framework.TestCase;
import models.Address;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StreetAddressTests extends TestCase {

	private Address address;
	
	public StreetAddressTests(String name) {
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
	public void testStreetAddressCorrect() {
		try {
			this.address.setStreet("Mihai Eminescu");
			assertEquals("Mihai Eminescu", this.address.getStreet());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@Test
	public void testStreetAddressWrong1() {
		try {
			this.address.setStreet(null);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertEquals(null, this.address.getStreet());
		}
	}
	
	@Test(expected = AssertionError.class)
	public void testStreetAddressWrong2() {
		try {
			this.address.setStreet("Miha");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertEquals("Miha", this.address.getStreet());
		}
	}

	@Test(expected = AssertionError.class)
	public void testStreetAddressWrong3() {
		try {
			this.address.setStreet("Mihai Eminescuuuuuuuuuuuuuuuuuuuuuu");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertEquals("Mihai Eminescuuuuuuuuuuuuuuuuuuuuuu", this.address.getStreet());
		}
	}
	
	@Test(expected = AssertionError.class)
	public void testStreetAddressWrong4() {
		try {
			this.address.setStreet("Mihai Eminescu 123");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertEquals("Mihai Eminescu 123", this.address.getStreet());
		}
	}
	
	@After
	public void tearDown() throws Exception {
		this.address = null;
	}
}
