package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ FirstNameTests.class, LastNameTests.class,
		CityAddressTests.class, CountyAddressTests.class,
		CountryAddressTests.class, StreetAddressTests.class,
		StreetNumberAddressTests.class, UsernameTests.class,
		PasswordTests.class })
public class ProfessorTestsSuite {

}
