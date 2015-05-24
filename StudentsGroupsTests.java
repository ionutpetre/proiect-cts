package tests;

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import models.Professor;
import models.Student;
import models.UserFactory;
import models.UserType;

public class StudentsGroupsTests extends TestCase {

	private Professor prof;

	public StudentsGroupsTests(String name) {
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
	public void testStudentsGroupsCorrect() {
		try {
			Student stud1 = (Student) UserFactory.createUser(UserType.STUDENT);
			stud1.setFirstName("Petre");
			Student stud2 = (Student) UserFactory.createUser(UserType.STUDENT);
			stud2.setFirstName("Zamfiroiu");
			List<Student> students = new ArrayList<Student>();
			students.add(stud1);
			students.add(stud2);

			this.prof.addStudent(1054, stud1);
			this.prof.addStudent(1054, stud2);
			assertEquals(students, this.prof.getStudentsByGroup(1054));

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Test(expected = AssertionError.class)
	public void testStudentsGroupsWrong1() {
		try {
			Student stud1 = (Student) UserFactory.createUser(UserType.STUDENT);
			stud1.setFirstName("Petre");
			Student stud2 = (Student) UserFactory.createUser(UserType.STUDENT);
			stud2.setFirstName("Zamfiroiu");
			Student stud3 = (Student) UserFactory.createUser(UserType.STUDENT);
			stud3.setFirstName("Popescu");
			List<Student> students = new ArrayList<Student>();
			students.add(stud1);
			students.add(stud2);
			students.add(stud3);

			this.prof.addStudent(1054, stud1);
			this.prof.addStudent(1054, stud2);
			assertEquals(students, this.prof.getStudentsByGroup(1054));

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Test(expected = AssertionError.class)
	public void testStudentsGroupsWrong2() {
		try {
			Student stud1 = (Student) UserFactory.createUser(UserType.STUDENT);
			stud1.setFirstName("Petre");
			Student stud2 = (Student) UserFactory.createUser(UserType.STUDENT);
			stud2.setFirstName("Zamfiroiu");
			List<Student> students = new ArrayList<Student>();
			students.add(stud1);
			students.add(stud2);

			this.prof.addStudent(999, stud1);
			this.prof.addStudent(999, stud2);
			assertEquals(students, this.prof.getStudentsByGroup(999));

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@After
	public void tearDown() {
		this.prof = null;
	}
}
