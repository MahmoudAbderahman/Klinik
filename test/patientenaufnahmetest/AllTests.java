package patientenaufnahmetest;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @RunWith Diese Annotation veranlasst, dass JUnit die Klasse aufruft, auf die
 *          es verweist, um die Tests in dieser Klasse anstelle des in JUnit
 *          integrierten Runners auszuf�hren.
 * 
 * @SuiteClasses Diese Annotation gibt an, welche Klassen werden beim Ausf�hren
 *               von @RunWith ausgef�hrt.
 * 
 * @SuiteDisplayName Diese Annotation wird verwendet, um einen
 *                   benutzerdefinierten Anzeigenamen f�r die mit Annotationen
 *                   versehene Testklasse zu deklarieren, die als Test Suite
 *                   ausgef�hrt wird.
 * 
 * @SelectPackages Diese Annotation gibt an, welche Packages werden beim
 *                 Ausf�hren von @RunWith ausgef�hrt. Somit werden alle Tests
 *                 innerhalb von diesen Packages ausgef�hrt.
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ DatumUhrzeitUmwandlerTest.class, KlinikKalendarTest.class })
@SuiteDisplayName("Test Suite")
@SelectPackages("patientenaufnahmetest")
public class AllTests {

}
