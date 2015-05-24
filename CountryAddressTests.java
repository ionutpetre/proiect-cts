package tests;

import java.io.BufferedReader;
import java.io.FileReader;
import junit.framework.TestCase;
import models.Address;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CountryAddressTests extends TestCase {

	private Address address;
	private BufferedReader reader1;
	private BufferedReader reader2;

	public CountryAddressTests(String name) {
		super(name);
	}
	
	@Before
	public void setUp() {
		try {
			this.address = new Address();
			this.reader1 = new BufferedReader(new FileReader("CountriesCorrect.txt"));
			this.reader2 = new BufferedReader(new FileReader("CountriesWrong.txt"));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Test
	public void testCountryAddressCorrect() {
		try {
			this.address.setCountry("România");
			assertEquals("România", this.address.getCountry());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			fail(ex.getMessage());
		}
	}

	@Test
	public void testCountriesAddressCorrectUsingFile() {
		try {
			String line = reader1.readLine();
			while (line != null) {
				this.address.setCountry(line);
				System.out.print(this.address.getCountry() + " ");
				assertEquals(line, this.address.getCountry());
				line = reader1.readLine();
			}
			System.out.println();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@Test(expected = AssertionError.class)
	public void testCountriesAddressWrongUsingFile() {
		String line = null;
		try {
			line = reader2.readLine();
			while (line != null) {
				try {
					this.address.setCountry(line);
					assertEquals(line, this.address.getCountry());
					System.out.print(this.address.getCountry() + " ");
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
					assertEquals(line, this.address.getCountry());
				}
				line = reader2.readLine();
			}
			System.out.println();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Test
	public void testCountryAddressWrong1() {
		try {
			this.address.setCountry(null);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			// fail(ex.getMessage());
			assertNull(this.address.getCountry());
		}
	}

	@Test(expected = AssertionError.class)
	public void testCountryAddressWrong2() {
		try {
			this.address.setCountry("Ro");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			// fail(ex.getMessage());
			assertEquals("Ro", this.address.getCountry());
		}
	}

	@Test(expected = AssertionError.class)
	public void testCountryAddressWrong3() {
		try {
			this.address.setCountry("Româniaaaaaaaaaaaaaaaaaaaaaaaaaa");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			// fail(ex.getMessage());
			assertEquals("Româniaaaaaaaaaaaaaaaaaaaaaaaaaa",
					this.address.getCountry());
		}
	}

	@Test(expected = AssertionError.class)
	public void testCountryAddressWrong4() {
		try {
			this.address.setCountry("România#$%");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			// fail(ex.getMessage());
			assertEquals("România#$%", this.address.getCountry());
		}
	}

	@Test(expected = AssertionError.class)
	public void testCountryAddressWrong5() {
		try {
			this.address.setCountry("românia");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			// fail(ex.getMessage());
			assertEquals("românia", this.address.getCountry());
		}
	}

	@Test(expected = AssertionError.class)
	public void testCountryAddressWrong6() {
		try {
			this.address.setCountry("Republica moldova");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			// fail(ex.getMessage());
			assertEquals("Republica moldova", this.address.getCountry());
		}
	}

	@Test(expected = AssertionError.class)
	public void testCountryAddressWrong7() {
		try {
			this.address.setCountry("Republica MOLDOVA");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			// fail(ex.getMessage());
			assertEquals("Republica MOLDOVA", this.address.getCountry());
		}
	}

	@After
	public void tearDown() throws Exception {
		this.reader1.close();
		this.reader2.close();
		this.address = null;
	}
}
