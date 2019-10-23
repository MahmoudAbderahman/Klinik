package patientenaufnahmetest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import patientenaufnahme.Arzt;
import patientenaufnahme.KlinikKalendar;
import patientenaufnahme.PatientenTermin;

/**
 * 
 * Die Klasse KlinikKalendarTest erstellt eine Instanz der Klasse KlinikKalendar
 * um die Methoden von der Klasse KlinikKalendar zu testet. Dazu wurden einige
 * Annotationen und Asserts verwendet.
 *
 */
class KlinikKalendarTest {

	// Instanzvariable
	KlinikKalendar kalendar;

	/**
	 * @BeforAll Das Code in der Methode testClassSetup() wird zum Beginn des Tests
	 *           einmal ganz am Anfang ausgef�hrt.
	 */
	@BeforeAll
	public static void testClassSetup() {
		System.out.println("Before All.......");
	}

	/**
	 * @BeforEach Das Code in der Methode init() wird zum Beginn des Tests jeweils
	 *            vor dem Ausf�hren jeder der anderen Methoden in dieser Klasse
	 *            ausgef�hrt. Ausgeschlossen ist die Methode, die die
	 *            Annotation @BeforeAll davor hat.
	 */
	@BeforeEach
	public void init() {
		System.out.println("Before Each.......");
		kalendar = new KlinikKalendar(LocalDate.of(2019, 10, 21));
	}

	/**
	 * @Test Diese Annotation erlaubt es die Methode erlaubTerminEintrag() getestet
	 *       zu werden. Ohne @Test wird die Methode einfach beim Testen ignoriert.
	 * 
	 *       Die Methode erlaubTerminEintrag �berpr�ft mithilfe von
	 *       asserNotNull(...) und assertEquals(...), dass die Liste der Termine
	 *       nicht leer ist und es nur einen Termin zur gleichen Zeit und zum
	 *       gleichen Datum gibt. Au�erdem wird mithilfe von assertSame(...) auf
	 *       alle Fehler und nicht nur auf den ersten Fehler ,beim Run, getestet.
	 */
	@Test
	public void erlaubTerminEintrag() {
		System.out.println("Eintrag.......");
		kalendar.terminErstellen("Mulham", "Alesali", "abdelrahman", "01.12.2019 14:00");
		List<PatientenTermin> termine = kalendar.getTermine();
		assertNotNull(termine);
		assertEquals(1, termine.size());
		PatientenTermin eingegebeneTermin = termine.get(0);
		assertAll(() -> assertEquals("Mulham", eingegebeneTermin.getPatientVorname()),
				() -> assertEquals("Alesali", eingegebeneTermin.getPatientNachname()),
				() -> assertSame(Arzt.abdelrahman, eingegebeneTermin.getArzt()), () -> assertEquals("1.12.2019 14:00",
						eingegebeneTermin.getTermin().format(DateTimeFormatter.ofPattern("d.M.yyyy HH:mm"))));

	}

	/**
	 * @Test Diese Annotation erlaubt es die Methode returnTrueWennEsDenTerminGibt()
	 *       getestet zu werden. Ohne @Test wird die Methode beim Testen einfach
	 *       ignoriert.
	 * 
	 *       Wenn es einen Termin zu dem jeweiligen Datum gibt, liefert die Methode
	 *       true mithilfe von assertTrue(...).
	 */
	@Test
	public void returnTrueWennEsDenTerminGibt() {
		System.out.println("Eintrag.......");

		kalendar.terminErstellen("Mulham", "Alesali", "abdelrahman", "01.12.2019 14:00");
		assertTrue(kalendar.hatTermin(LocalDate.of(2019, 12, 01)));
	}

	/**
	 * @Test Diese Annotation erlaubt es die Methode
	 *       returnFalseWennEsDenTerminNichtGibt() getestet zu werden. Ohne @Test
	 *       wird die Methode beim Testen einfach ignoriert.
	 * 
	 *       Wenn es keinen Termin zu dem jeweiligen Datum gibt, liefert die Methode
	 *       false mithilfe von assertFalse(...).
	 */
	@Test
	public void returnFalseWennEsDenTerminNichtGibt() {
		assertFalse(kalendar.hatTermin(LocalDate.of(2019, 12, 01)));
	}

	/**
	 * @Test Diese Annotation erlaubt es die Methode returnAktuellerTagTermine()
	 *       getestet zu werden. Ohne @Test wird die Methode beim Testen einfach
	 *       ignoriert.
	 * 
	 *       Mit assertEquals(...) wurde hier die Anzahl der Termine ,am heutigen
	 *       Tag, �berpr�ft. Mit assertIterableEquals(...) werden die erwarteten
	 *       Termine vom heutigen Tag gegen die Termine im System auf Gleichheit
	 *       verglichen.
	 * 
	 * @Disabled Diese Annotation verhindert, dass der Test an der jeweiligen
	 *           Methode ausgef�rht wird.
	 */
	@Test
	@Disabled
	public void returnAktuellerTagTermine() {
		System.out.println("Eintrag.......");

		// kalendar.terminErstellen("Mulham", "Alesali", "abdelrahman", "26/8/2018
		// 14:00");
		kalendar.terminErstellen("Mulham", "Alesali", "abdelrahman", "21.10.2019 16:00");
		kalendar.terminErstellen("Mulham", "Alesali", "abdelrahman", "21.10.2019 17:00");

		assertEquals(2, kalendar.getHeutigeTermine().size());
		assertIterableEquals(kalendar.getHeutigeTermine(), kalendar.getTermine());
	}

	/**
	 * @AfterEach Das Code in der Methode tearDownEachTest() wird nach jeder Methode
	 *            des Tests jeweils einmal ausgef�hrt. Ausgeschlossen ist die
	 *            Methode, die die Annotation @AfterAll davor hat.
	 */
	@AfterEach
	public void tearDownEachTest() {
		System.out.println("After Each...");
	}

	/**
	 * @AfterAll Das Code in der Methode testDownTestClass() wird zum Ende des Tests
	 *           einmal ganz am Ende ausgef�hrt.
	 */
	@AfterAll
	public static void testDownTestClass() // Muss static
	{
		System.out.println("After ALl");
	}

}
