package tests;

import java.util.Calendar;
import junit.framework.TestCase;
import models.Student;
import models.UserFactory;
import models.UserType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BirthdateTests extends TestCase {

	private Student stud;

	public BirthdateTests(String name) {
		super(name);
	}
	
	@Before
	public void setUp() {
		try {
			this.stud = (Student) UserFactory.createUser(UserType.STUDENT);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}

	@Test
	public void testBirthdayCorrect() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(1993, 10, 10);
		this.stud.setBirthdate(calendar.getTime());
	}

	@Test
	public void testBirthdayWrong1() {
		try {
			this.stud.setBirthdate(null);
		} catch (Exception ex) {
			System.out.println(ex.toString());
			assertEquals(null, this.stud.getBirthdate());
		}
	}

	@Test(expected = AssertionError.class)
	public void testBirthdayWrong2() {
		Calendar calendar = null;
		try {
			calendar = Calendar.getInstance();
			calendar.set(1950, 01, 01);
			this.stud.setBirthdate(calendar.getTime());
		} catch (Exception ex) {
			System.out.println(ex.toString());
			assertEquals(calendar.getTime(), this.stud.getBirthdate());
		}
	}

	@Test(expected = AssertionError.class)
	public void testBirthdayWrong3() {
		Calendar calendar = null;
		try {
			calendar = Calendar.getInstance();
			calendar.set(2000, 01, 01);
			this.stud.setBirthdate(calendar.getTime());
		} catch (Exception ex) {
			System.out.println(ex.toString());
			assertEquals(calendar.getTime(), this.stud.getBirthdate());
		}
	}
	
	@After
	public void tearDown() {
		this.stud = null;
	}
}
