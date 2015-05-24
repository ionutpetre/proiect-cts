package tests;

import junit.framework.TestCase;
import models.Student;
import models.UserFactory;
import models.UserType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmailTests extends TestCase {

	private Student stud;

	public EmailTests(String name) {
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
	public void testEmailCorrect() {
		this.stud.setEmail("ionutpetre.ro@gmail.com");
		assertEquals("ionutpetre.ro@gmail.com", this.stud.getEmail());
	}
	
	@Test
	public void testEmailWrong1() {
		try {
			this.stud.setEmail(null);
		} catch(Exception ex) {
			System.out.println(ex.toString());
			assertSame(null, this.stud.getEmail());
		}
	}
	
	@Test(expected = AssertionError.class)
	public void testEmailWrong2() {
		try {
			this.stud.setEmail("ionutpetre");
		} catch(Exception ex) {
			System.out.println(ex.toString());
			assertEquals("ionutpetre", this.stud.getEmail());
		}
	}
	
	@Test(expected = AssertionError.class)
	public void testEmailWrong3() {
		try {
			this.stud.setEmail("ionutpetre.ro");
		} catch(Exception ex) {
			System.out.println(ex.toString());
			assertEquals("ionutpetre.ro", this.stud.getEmail());
		}
	}
	
	@Test(expected = AssertionError.class)
	public void testEmailWrong4() {
		try {
			this.stud.setEmail("ionutpetre.ro@");
		} catch(Exception ex) {
			System.out.println(ex.toString());
			assertEquals("ionutpetre.ro@", this.stud.getEmail());
		}
	}
	
	@Test(expected = AssertionError.class)
	public void testEmailWrong5() {
		try {
			this.stud.setEmail("ionutpetre.ro@gmail");
		} catch(Exception ex) {
			System.out.println(ex.toString());
			assertEquals("ionutpetre.ro@gmail", this.stud.getEmail());
		}
	}
	
	@Test(expected = AssertionError.class)
	public void testEmailWrong6() {
		try {
			this.stud.setEmail("ionutpetre.ro@gmail.");
		} catch(Exception ex) {
			System.out.println(ex.toString());
			assertEquals("ionutpetre.ro@gmail.", this.stud.getEmail());
		}
	}
	
	@After
	public void tearDown() throws Exception {
		this.stud = null;
	}
}
