package tests;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import models.Grade;
import models.Student;
import models.UserFactory;
import models.UserType;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import junit.framework.TestCase;
import static org.mockito.Mockito.*;

public class StudentTests extends TestCase {

	private Student stud;

	public StudentTests(String name) {
		super(name);
	}

	@Before
	public void setUp() throws Exception {
		// this.stud = (Student) UserFactory.createUser(UserType.STUDENT);
		this.stud = mock(Student.class);
		when(stud.getUsername()).thenReturn("ionut.petre");
		when(stud.getPassword()).thenReturn("a1A@a");
		when(stud.getFirstName()).thenReturn("Petre");
		when(stud.getLastName()).thenReturn("Ionut");
		Calendar calendar = Calendar.getInstance();
		calendar.set(1993, 10, 10);
		when(stud.getBirthdate()).thenReturn(calendar.getTime());
		when(stud.getPlaceOfBirth()).thenReturn("Moreni");
		when(stud.getCountry()).thenReturn("România");
		when(stud.getCounty()).thenReturn("Dâmbovița");
		when(stud.getCity()).thenReturn("Ocnița");
		when(stud.getStreet()).thenReturn("Mihail Moxa");
		when(stud.getStreetNumber()).thenReturn(11);
		when(stud.getZipCode()).thenReturn("123456");
		when(stud.getPhone()).thenReturn("0721120747");
		when(stud.getEmail()).thenReturn("ionutpetre.ro@gmail.com");
		when(stud.getUniversity()).thenReturn("ASE Bucuresti");
		when(stud.getSpecialization()).thenReturn(
				"Cibernetica, Statistica si Informatica Economica");
		when(stud.getStudyYear()).thenReturn(3);
		when(stud.getGroup()).thenReturn(1054);
		when(stud.getSeries()).thenReturn("B");
		when(stud.getGrades()).thenAnswer(new Answer<List<Grade>>() {
			public List<Grade> answer(InvocationOnMock invocation)
					throws Throwable {
				List<Grade> grades = new ArrayList<Grade>();
				grades.add(new Grade("SDD", 8.0, 5, 2));
				grades.add(new Grade("PAW", 8.0, 4, 2));
				grades.add(new Grade("JAVA", 9.0, 4, 2));
				return grades;
			}
		});
	}

	@Test
	public void testStudentGrades() throws Exception {
		if (this.stud.getUsername().equals("ionut.petre")
				&& this.stud.getPassword().equals("a1A@a")) {
			assertEquals("Petre", this.stud.getFirstName());
			assertEquals("Ionut", this.stud.getLastName());
			
			List<Grade> grades = new ArrayList<Grade>();
			grades.add(new Grade("SDD", 8.0, 5, 2));
			grades.add(new Grade("PAW", 8.0, 4, 2));
			grades.add(new Grade("JAVA", 9.0, 4, 2));
			System.out.println(this.stud.getGrades());
			assertEquals(grades, this.stud.getGrades());
		}
	}
	
	@Test
	public void testAverageOfGrades() {
		try {
			Student stud = (Student) UserFactory.createUser(UserType.STUDENT);
			stud.addGrade(new Grade("SDD", 8.0, 5, 2));
			stud.addGrade(new Grade("PAW", 8.0, 4, 2));
			stud.addGrade(new Grade("JAVA", 9.0, 4, 2));
			assertEquals(8.3, stud.getAverageOfGradeByStudyYear(2), 0.5);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {
		this.stud = null;
	}
}
