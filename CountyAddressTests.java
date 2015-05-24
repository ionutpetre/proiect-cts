package tests;

import java.io.BufferedReader;
import java.io.FileReader;
import junit.framework.TestCase;
import models.Address;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CountyAddressTests extends TestCase {

	private Address address;
	private BufferedReader reader1;
	private BufferedReader reader2;
	
	public CountyAddressTests(String name) {
		super(name);
	}
	
	@Before
	public void setUp() {
		try {
			this.address = new Address();
			this.reader1 = new BufferedReader(new FileReader("CountiesCorrect.txt"));
			this.reader2 = new BufferedReader(new FileReader("CountiesWrong.txt"));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Test
	public void testCountyAddressCorrect() {
		try {
			this.address.setCountry("România");
			this.address.setCounty("Dâmbovița");
			assertEquals("Dâmbovița", this.address.getCounty());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			fail(ex.getMessage());
		}
	}

	@Test
	public void testCountiesAddressCorrectUsingFile() {
		try {
			String line = reader1.readLine();
			while (line != null) {
				this.address.setCountry("România");
				this.address.setCounty(line);
				System.out.print(this.address.getCounty() + " ");
				assertEquals(line, this.address.getCounty());
				line = reader1.readLine();
			}
			System.out.println();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@Test(expected = AssertionError.class)
	public void testCountiesAddressWrongUsingFile() {
		String line = null;
		try {
			line = reader2.readLine();
			while (line != null) {
				try {
					this.address.setCountry("România");
					this.address.setCounty(line);
					assertEquals(line, this.address.getCounty());
					System.out.print(this.address.getCounty() + " ");
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
					assertEquals(line, this.address.getCounty());
				}
				line = reader2.readLine();
			}
			System.out.println();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@Test
	public void testCountyAddressWrong1() {
		try {
			this.address.setCountry("România");
			this.address.setCounty(null);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertNull(address.getCounty());
			// fail(ex.getMessage());
		}
	}

	@Test(expected = AssertionError.class)
	public void testCountyAddressWrong2() {
		try {
			this.address.setCountry("România");
			this.address.setCounty("Dâmbovițaaaaaaaaaaaaaaaaaaaaaaaa");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			// fail(ex.getMessage());
			assertEquals("Dâmbovițaaaaaaaaaaaaaaaaaaaaaaaa",
					this.address.getCounty());
		}
	}

	@Test(expected = AssertionError.class)
	public void testCountyAddressWrong3() {
		try {
			this.address.setCountry("România");
			this.address.setCounty("Dâ");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			// fail(ex.getMessage());
			assertEquals("Dâ", this.address.getCounty());
		}
	}

	@Test(expected = AssertionError.class)
	public void testCountyAddressWrong4() {
		try {
			this.address.setCountry("România");
			this.address.setCounty("Dâmbovița123");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			// fail(ex.getMessage());
			assertEquals("Dâmbovița123", this.address.getCounty());
		}
	}

	@Test(expected = AssertionError.class)
	public void testCountyAddressWrong5() {
		try {
			this.address.setCountry("România");
			this.address.setCounty("dâmbovița");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			// fail(ex.getMessage());
			assertEquals("dâmbovița", this.address.getCounty());
		}
	}

	@Test(expected = AssertionError.class)
	public void testCountyAddressWrong6() {
		try {
			this.address.setCountry("România");
			this.address.setCounty("Satu MARE");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			// fail(ex.getMessage());
			assertEquals("Satu MARE", this.address.getCounty());
		}
	}

	@Test(expected = AssertionError.class)
	public void testCountyAddressWrong7() {
		try {
			this.address.setCountry("România");
			this.address.setCounty("Moldova");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			// fail(ex.getMessage());
			assertEquals("Moldova", this.address.getCounty());
		}
	}

	@After
	public void tearDown() throws Exception {
		this.address = null;
		this.reader1.close();
		this.reader2.close();
	}
}
