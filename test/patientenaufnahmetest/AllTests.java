package patientenaufnahmetest;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({DatumUhrzeitUmwandlerTest.class, KlinikKalendarTest.class})
@SuiteDisplayName("Test Suite")
@SelectPackages("patientenaufnahmetest")
public class AllTests {
	
}
