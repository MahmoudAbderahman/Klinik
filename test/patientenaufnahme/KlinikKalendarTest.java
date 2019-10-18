package patientenaufnahme;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KlinikKalendarTest {

	KlinikKalendar kalendar;
	@BeforeAll
	static void testClassSetup()
	{
		System.out.println("Before All.......");
	}
	
	
	@BeforeEach
	void init()
	{
		System.out.println("Before Each.......");
		 kalendar = new KlinikKalendar(LocalDate.of(2018, 8,26));
	}
	
	@Test
	public void erlaubTerminEintrag() {
		System.out.println("Eintrag.......");
		kalendar.terminErstellen("Mulham", "Alesali", "abdelrahman", "01/12/2019 14:00");
		List<PatientenTermin> termine = kalendar.getTermine();
		assertNotNull(termine);
		assertEquals(1, termine.size());
		PatientenTermin eingegebeneTermin = termine.get(0);
		assertEquals("Mulham", eingegebeneTermin.getPatientVorname());
		assertEquals("Alesali", eingegebeneTermin.getPatientNachname());
		assertSame(Arzt.abdelrahman, eingegebeneTermin.getArzt());
		assertEquals("1/12/2019 14:00",
				eingegebeneTermin.getTermin().format(DateTimeFormatter.ofPattern("d/M/yyyy HH:mm")));

	}

	@Test
	void returnTrueWennEsDenTerminGibt() {
		System.out.println("Eintrag.......");

		kalendar.terminErstellen("Mulham", "Alesali", "abdelrahman", "01/12/2019 14:00");
		assertTrue(kalendar.hatTermin(LocalDate.of(2019, 12, 01)));
	}

	@Test
	void returnFalseWennEsDenTerminNichtGibt() {
		assertFalse(kalendar.hatTermin(LocalDate.of(2019, 12, 01)));
	}

	@Test
	void returnAktuellerTagTermine() {
		System.out.println("Eintrag.......");

		kalendar.terminErstellen("Mulham", "Alesali", "abdelrahman", "26/8/2018 14:00");
		kalendar.terminErstellen("Mulham", "Alesali", "abdelrahman", "26/8/2018 16:00");
		kalendar.terminErstellen("Mulham", "Alesali", "abdelrahman", "18/10/2019 16:00");

		assertEquals(2, kalendar.getHeutigeTermine().size());
		//assertIterableEquals(kalendar.getHeutigeTermine(), kalendar.getTermine());
	}
	
	@AfterEach
	void tearDownEachTest()
	{
		System.out.println("After Each...");
	}
	@AfterAll
	static void testDownTestClass() // Muss static
	{
		System.out.println("After ALl");
	}
	
}
