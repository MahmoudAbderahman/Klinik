package patientenaufnahmetest;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @RunWith Diese Annotation veranlasst, dass JUnit die Klasse aufruft, auf die
 *          es verweist, um die Tests in dieser Klasse anstelle des in JUnit
 *          integrierten Runners auszuführen.
 * 
 * @SuiteClasses Diese Annotation gibt an, welche Klassen werden beim Ausführen
 *               von @RunWith ausgeführt.
 * 
 * @SuiteDisplayName Diese Annotation wird verwendet, um einen
 *                   benutzerdefinierten Anzeigenamen für die mit Annotationen
 *                   versehene Testklasse zu deklarieren, die als Test Suite
 *                   ausgeführt wird.
 * 
 * @SelectPackages Diese Annotation gibt an, welche Packages werden beim
 *                 Ausführen von @RunWith ausgeführt. Somit werden alle Tests
 *                 innerhalb von diesen Packages ausgeführt.
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ DatumUhrzeitUmwandlerTest.class, KlinikKalendarTest.class })
@SuiteDisplayName("Test Suite")
@SelectPackages("patientenaufnahmetest")
public class AllTests {

}
