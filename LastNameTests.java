package tests;

import junit.framework.TestCase;
import models.Student;
import models.UserFactory;
import models.UserType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LastNameTests extends TestCase {

	private Student stud;

	public LastNameTests(String name) {
		super(name);
	}
	
	@Before
	public void setUp() {
		try {
			this.stud = (Student) UserFactory.createUser(UserType.STUDENT);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Test
	public void testLastNameCorrect() {
		try {
			this.stud.setLastName("Ionut");
			assertEquals("Ionut", this.stud.getLastName());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Test
	public void testLastNameWrong1() {
		try {
			this.stud.setLastName(null);
			assertNull(this.stud.getLastName());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertNull(this.stud.getLastName());
		}
	}

	@Test(expected = AssertionError.class)
	public void testLastNameWrong2() {
		try {
			this.stud.setLastName("Io");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertEquals("Io", this.stud.getLastName());
		}
	}

	@Test(expected = AssertionError.class)
	public void testLastNameWrong3() {
		try {
			this.stud.setLastName("Ionutionutionutionutionutionutionutionut");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertEquals("Ionutionutionutionutionutionutionutionut",
					this.stud.getLastName());
		}
	}

	@Test(expected = AssertionError.class)
	public void testLastNameWrong4() {
		try {
			this.stud.setLastName("Ionut123");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertEquals("Ionut123", this.stud.getLastName());
		}
	}

	@Test(expected = AssertionError.class)
	public void testLastNameWrong5() {
		try {
			this.stud.setLastName("ionut");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertEquals("ionut", this.stud.getLastName());
		}
	}

	@Test(expected = AssertionError.class)
	public void testLastNameWrong6() {
		try {
			this.stud.setLastName("Ionut giorgian");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertEquals("Ionut giorgian", this.stud.getLastName());
		}
	}

	@After
	public void tearDown() {
		this.stud = null;
	}
}
