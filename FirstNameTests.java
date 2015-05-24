package tests;

import junit.framework.TestCase;
import models.Professor;
import models.UserFactory;
import models.UserType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FirstNameTests extends TestCase {

	private Professor prof;

	public FirstNameTests(String name) {
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
	public void testFirstNameCorrect() {
		try {
			this.prof.setFirstName("Petre");
			assertEquals("Petre", this.prof.getFirstName());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Test
	public void testFirstNameWrong1() {
		try {
			this.prof.setFirstName(null);
			assertNull(this.prof.getFirstName());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertNull(this.prof.getFirstName());
		}
	}

	@Test(expected = AssertionError.class)
	public void testFirstNameWrong2() {
		try {
			this.prof.setFirstName("Pe");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertEquals("Pe", this.prof.getFirstName());
		}
	}

	@Test(expected = AssertionError.class)
	public void testFirstNameWrong3() {
		try {
			this.prof.setFirstName("Petrepetrepetrepetrepetrepetrepetre");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertEquals("Petrepetrepetrepetrepetrepetrepetre",
					this.prof.getFirstName());
		}
	}

	@Test(expected = AssertionError.class)
	public void testFirstNameWrong4() {
		try {
			this.prof.setFirstName("Petre123");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertEquals("Petre123", this.prof.getFirstName());
		}
	}

	@Test(expected = AssertionError.class)
	public void testFirstNameWrong5() {
		try {
			this.prof = (Professor) UserFactory.createUser(UserType.PROFESSOR);
			this.prof.setFirstName("petre");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertEquals("petre", this.prof.getFirstName());
		}
	}

	@Test(expected = AssertionError.class)
	public void testFirstNameWrong6() {
		try {
			this.prof.setFirstName("Pet re");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertEquals("Pet re", this.prof.getFirstName());
		}
	}

	@After
	public void tearDown() throws Exception {
		this.prof = null;
	}
}
