package tests;

import java.io.BufferedReader;
import java.io.FileReader;
import junit.framework.TestCase;
import models.AddressBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CityAddressTests extends TestCase {

	private AddressBuilder addressBuilder;
	private BufferedReader reader1;
	private BufferedReader reader2;

	public CityAddressTests(String name) {
		super(name);
	}

	@Before
	public void setUp() {
		try {
			this.addressBuilder = new AddressBuilder();
			this.reader1 = new BufferedReader(new FileReader(
					"CitiesCorrect.txt"));
			this.reader2 = new BufferedReader(new FileReader("CitiesWrong.txt"));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Test
	public void testCityAddressCorrect() {
		try {
			this.addressBuilder.setCountry("România").setCounty("Dâmbovița")
					.setCity("Târgoviște");
			assertEquals("Târgoviște", this.addressBuilder.getAddress()
					.getCity());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			fail(ex.toString());
		}
	}

	@Test
	public void testCitiesAddressCorrectUsingFile() {
		try {
			String line = reader1.readLine();
			while (line != null) {
				this.addressBuilder.setCountry("România")
						.setCounty("Dâmbovița").setCity(line);
				System.out.print(this.addressBuilder.getAddress().getCity()
						+ " ");
				assertEquals(line, this.addressBuilder.getAddress().getCity());
				line = reader1.readLine();
			}
			System.out.println();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Test(expected = AssertionError.class)
	public void testCitiesAddressWrongUsingFile() {
		String line = null;
		try {
			line = reader2.readLine();
			while (line != null) {
				try {
					this.addressBuilder.setCountry("România")
							.setCountry("Dâmbovița").setCity(line);
					assertEquals(line, this.addressBuilder.getAddress()
							.getCity());
					System.out.print(this.addressBuilder.getAddress().getCity()
							+ " ");
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
					assertEquals(line, this.addressBuilder.getAddress()
							.getCity());
				}
				line = reader2.readLine();
			}
			System.out.println();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Test
	public void testCityAddressWrong1() {
		try {
			this.addressBuilder.setCity(null);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertNull(this.addressBuilder.getAddress().getCity());
		}
	}

	@Test(expected = AssertionError.class)
	public void testCityAddressWrong2() {
		try {
			this.addressBuilder.setCity("Tar");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertEquals("Tar", this.addressBuilder.getAddress().getCity());
		}
	}

	@Test(expected = AssertionError.class)
	public void testCityAddressWrong3() {
		try {
			this.addressBuilder
					.setCity("Targovisteeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertEquals("Targovisteeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee",
					this.addressBuilder.getAddress().getCity());
		}
	}

	@Test(expected = AssertionError.class)
	public void testCityAddressWrong4() {
		try {
			this.addressBuilder.setCity("T1rg0viste");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			fail(ex.toString());
			assertEquals("T1rg0viste", this.addressBuilder.getAddress()
					.getCity());
		}
	}

	@Test(expected = AssertionError.class)
	public void testCityAddressWrong5() {
		try {
			this.addressBuilder.setCity("targoviste");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			fail(ex.toString());
			assertEquals("targoviste", this.addressBuilder.getAddress()
					.getCity());
		}
	}

	@Test(expected = AssertionError.class)
	public void testCityAddressWrong6() {
		try {
			this.addressBuilder.setCity("TarGoVisTe");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			fail(ex.toString());
			assertEquals("TarGoVisTe", this.addressBuilder.getAddress()
					.getCity());
		}
	}

	@Test(expected = AssertionError.class)
	public void testCityAddressWrong7() {
		try {
			this.addressBuilder.setCountry("România").setCounty("Dâmbovița")
					.setCity("Random");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			fail(ex.toString());
			assertEquals("Random", this.addressBuilder.getAddress().getCity());
		}
	}

	@After
	public void tearDown() throws Exception {
		this.reader1.close();
		this.reader2.close();
		this.addressBuilder = null;
	}
}
