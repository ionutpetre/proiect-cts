package tests;

import junit.framework.TestCase;
import models.Student;
import models.UserFactory;
import models.UserType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UsernameTests extends TestCase {

	private Student stud;

	public UsernameTests(String name) {
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
	public void testUsernameCorrect() {
		this.stud.setUsername("ionut.petre");
		assertEquals("ionut.petre", this.stud.getUsername());
	}
	
	@Test
	public void testUsernameWrong1() {
		try {
			this.stud.setUsername(null);
		} catch (Exception ex) {
			System.out.println(ex.toString());
			assertEquals(null, this.stud.getUsername());
		}
	}
	
	@Test(expected = AssertionError.class)
	public void testUsernameWrong2() {
		try {
			this.stud.setUsername("Ionut.petre");
		} catch (Exception ex) {
			System.out.println(ex.toString());
			assertEquals("Ionut.petre", this.stud.getUsername());
		}
	}
	
	@Test(expected = AssertionError.class)
	public void testUsernameWrong3() {
		try {
			this.stud.setUsername("ionut_petre");
		} catch (Exception ex) {
			System.out.println(ex.toString());
			assertEquals("ionut_petre", this.stud.getUsername());
		}
	}
	
	@Test(expected = AssertionError.class)
	public void testUsernameWrong4() {
		try {
			this.stud.setUsername("ion");
		} catch (Exception ex) {
			System.out.println(ex.toString());
			assertEquals("ion", this.stud.getUsername());
		}
	}

	@Test(expected = AssertionError.class)
	public void testUsernameWrong5() {
		try {
			this.stud.setUsername("ionut.petreeeeeeeeeeeeeeeeeeeee");
		} catch (Exception ex) {
			System.out.println(ex.toString());
			assertEquals("ionut.petreeeeeeeeeeeeeeeeeeeee", this.stud.getUsername());
		}
	}
	
	@After
	public void tearDown() throws Exception {
		this.stud = null;
	}
}
