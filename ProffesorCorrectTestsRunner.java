package tests;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class ProffesorCorrectTestsRunner {

	public static void main(String[] args) {

		TestSuite suite = new TestSuite();
		suite.addTest(new FirstNameTests("testFirstNameCorrect"));
		suite.addTest(new LastNameTests("testLastNameCorrect"));
		suite.addTest(new UniversityTests("testUniversityCorrect"));
		suite.addTest(new SalaryTests("testSalaryCorrect"));
		suite.addTest(new StudentsGroupsTests("testStudentsGroupsCorrect"));
		suite.addTest(new UsernameTests("testUsernameCorrect"));
		suite.addTest(new PasswordTests("testPasswordCorrect"));
		TestRunner.run(suite);
	}
}
