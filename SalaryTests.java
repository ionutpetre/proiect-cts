package tests;

import junit.framework.TestCase;
import models.Professor;
import models.UserFactory;
import models.UserType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SalaryTests extends TestCase {

	private Professor prof;

	public SalaryTests(String name) {
		super(name);
	}
	
	@Before
	public void setUp() {
		try {
			this.prof = (Professor) UserFactory.createUser(UserType.PROFESSOR);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Test
	public void testSalaryCorrect() {
		try {
			this.prof.setSalary(2500.0);
			assertEquals(new Double(2500.0), this.prof.getSalary());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Test
	public void testSalaryWrong1() {
		try {
			this.prof.setSalary(null);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertSame(null, this.prof.getSalary());
		}
	}
	
	@Test(expected = AssertionError.class)
	public void testSalaryWrong2() {
		try {
			this.prof.setSalary(new Double(-1));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertEquals(new Double(-1), this.prof.getSalary());
		}
	}
	
	@Test(expected = AssertionError.class)
	public void testSalaryWrong3() {
		try {
			this.prof.setSalary(new Double(200000));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertEquals(new Double(200000), this.prof.getSalary());
		}
	}

	@After
	public void tearDown() throws Exception {
		this.prof = null;
	}
}
