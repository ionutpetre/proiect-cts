package tests;

import junit.framework.TestCase;
import models.Professor;
import models.UserFactory;
import models.UserType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UniversityTests extends TestCase {

	private Professor prof;

	public UniversityTests(String name) {
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
	public void testUniversityCorrect() {
		try {
			this.prof.setUniversity("ASE Bucuresti");
			assertEquals("ASE Bucuresti", this.prof.getUniversity());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			fail(ex.getMessage());
		}
	}
	
	@Test
	public void testUniversityWrong1() {
		try {
			this.prof.setUniversity(null);
			assertNull(this.prof.getUniversity());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertNull(this.prof.getUniversity());
		}
	}
	
	@Test(expected = AssertionError.class)
	public void testUniversityWrong2() {
		try {
			this.prof.setUniversity("AS");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertEquals("AS", this.prof.getUniversity());
		}
	}

	@Test(expected = AssertionError.class)
	public void testUniversityWrong3() {
		try {
			this.prof.setUniversity("Academia de Studii Economice din Bucuresti");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertEquals("Academia de Studii Economice din Bucuresti", this.prof.getUniversity());
		}
	}
	
	@Test(expected = AssertionError.class)
	public void testUniversityWrong4() {
		try {
			this.prof.setUniversity("ASE Bucuresti 123");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertEquals("ASE Bucuresti 123", this.prof.getUniversity());
		}
	}
	
	@After
	public void tearDown() {
		this.prof = null;
	}
}
