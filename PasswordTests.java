package tests;

import junit.framework.TestCase;
import models.Professor;
import models.UserFactory;
import models.UserType;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PasswordTests extends TestCase {

	private Professor prof;

	public PasswordTests(String name) {
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
	public void testPasswordCorrect() {
		this.prof.setPassword("a1A@a");
		assertEquals("a1A@a", this.prof.getPassword());
	}

	@Test
	public void testPasswordWrong1() {
		try {
			this.prof.setPassword(null);
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.toString());
			assertEquals(null, this.prof.getPassword());
		}
	}

	@Test(expected = AssertionError.class)
	public void testPasswordWrong2() {
		try {
			this.prof.setPassword("paro");
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.toString());
			assertEquals("paro", this.prof.getPassword());
		}
	}

	@Test(expected = AssertionError.class)
	public void testPasswordWrong3() {
		try {
			this.prof.setPassword("parolaparolaparolaparolaparolaparola");
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.toString());
			assertEquals("paroparolaparolaparolaparolaparola",
					this.prof.getPassword());
		}
	}

	@Test(expected = AssertionError.class)
	public void testPasswordWrong4() {
		try {
			this.prof.setPassword("0parola");
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.toString());
			assertEquals("0parola", this.prof.getPassword());
		}
	}

	@Test(expected = AssertionError.class)
	public void testPasswordWrong5() {
		try {
			this.prof.setPassword("parola");
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.toString());
			assertEquals("parola", this.prof.getPassword());
		}
	}

	@Test(expected = AssertionError.class)
	public void testPasswordWrong6() {
		try {
			this.prof.setPassword("par0la");
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.toString());
			assertEquals("par0la", this.prof.getPassword());
		}
	}

	@Test(expected = AssertionError.class)
	public void testPasswordWrong7() {
		try {
			this.prof.setPassword("par0La");
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.toString());
			assertEquals("par0La", this.prof.getPassword());
		}
	}

	@Test(expected = AssertionError.class)
	public void testPasswordWrong8() {
		try {
			this.prof.setPassword("par0La# parola");
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.toString());
			assertEquals("par0La# parola", this.prof.getPassword());
		}
	}

	@After
	public void tearDown() throws Exception {
		this.prof = null;
	}
}
