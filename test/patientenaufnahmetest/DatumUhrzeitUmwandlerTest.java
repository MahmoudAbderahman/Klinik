package patientenaufnahmetest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import patientenaufnahme.DatumUhrzeitUmwandler;

/**
 * @DisplayName Diese Annotation wird verwendet, um einen benutzerdefinierten
 *              Anzeigenamen, f�r die mit dieser Annotation versehene Klasse
 *              oder Methode, zu deklarieren.
 * 
 *              Die Klasse DatumUhrzeitUmwandler enth�lt Methoden zum Testen der
 *              richtigen Eingabe vom Datum und von der Zeit mit und ohne den
 *              Schl�sselwort heute.
 */
@DisplayName("DatumUhrzeitUmwandler Muss")
class DatumUhrzeitUmwandlerTest {

	/**
	 * @Nested Diese Annotation erm�glicht es der Klasse, eine innere Klasse zu
	 *         haben, die im Wesentlichen eine Testklasse ist, sodass sie mehrere
	 *         Testklassen unter demselben �bergeordneten Element gruppieren kann.
	 * 
	 * @DisplayName Diese Annotation wird verwendet, um einen benutzerdefinierten
	 *              Anzeigenamen, f�r die mit dieser Annotation versehene Klasse
	 *              oder Methode, zu deklarieren.
	 * 
	 */
	@Nested
	@DisplayName("String mit 'heute' umwandeln")
	class HeuteTests {
		/**
		 * @Test Diese Annotation erlaubt es die Methode returnTrueWennEsDenTerminGibt()
		 *       getestet zu werden. Ohne @Test wird die Methode beim Testen einfach
		 *       ignoriert.
		 * 
		 * @DisplayName Diese Annotation wird verwendet, um einen benutzerdefinierten
		 *              Anzeigenamen, f�r die mit dieser Annotation versehene Klasse
		 *              oder Methode, zu deklarieren.
		 * 
		 *              Die Methode testUmwandleStringToDateTimeMitHeute() testet auf
		 *              das Vorkommen von dem Schl�sselwort heute (kleingeschrieben) in
		 *              dem String, der zu DateTime umgewandelt werden soll.
		 */
		@Test
		@DisplayName("mit")
		void testUmwandleStringToDateTimeMitHeute() {
			LocalDate heute = LocalDate.of(2019, 10, 21);
			LocalDateTime ergebnis = DatumUhrzeitUmwandler.umwandleStringToDateTime("heute 15:35", heute);
			assertEquals(ergebnis, LocalDateTime.of(2019, 10, 21, 15, 35),
					"Fehler: konnte 'heute' String in erwartete DatumUhrzeit nicht umwandeln " + "war: " + heute
							+ "\n");
		}

		/**
		 * @Test Diese Annotation erlaubt es die Methode returnTrueWennEsDenTerminGibt()
		 *       getestet zu werden. Ohne @Test wird die Methode beim Testen einfach
		 *       ignoriert.
		 * 
		 * @DisplayName Diese Annotation wird verwendet, um einen benutzerdefinierten
		 *              Anzeigenamen, f�r die mit dieser Annotation versehene Klasse
		 *              oder Methode, zu deklarieren.
		 * 
		 *              Die Methode testUmwandleStringToDateTime() testet auf das
		 *              Vorkommen eines g�ltigen Datums und einer g�ltigen Uhrzeit, mit
		 *              g�ltigen Formaten, in dem String, die zu DateTime umgewandelt
		 *              werden soll.
		 */
		@Test
		@DisplayName("ohne")
		void testUmwandleStringToDateTime() {
			LocalDateTime ergebnis = DatumUhrzeitUmwandler.umwandleStringToDateTime("25.10.2019 15:35",
					LocalDate.of(2019, 10, 25));
			assertEquals(ergebnis, LocalDateTime.of(2019, 10, 25, 15, 35));
		}
	}

	/**
	 * @Test Diese Annotation erlaubt es die Methode returnTrueWennEsDenTerminGibt()
	 *       getestet zu werden. Ohne @Test wird die Methode beim Testen einfach
	 *       ignoriert.
	 * 
	 * @DisplayName Diese Annotation wird verwendet, um einen benutzerdefinierten
	 *              Anzeigenamen, f�r die mit dieser Annotation versehene Klasse
	 *              oder Methode, zu deklarieren.
	 * 
	 *              Die Methode heuteSchluesselWortInCaseSensitive() testet auf das
	 *              Vorkommen von dem Schl�sselwort heute und achtet dabei nicht auf
	 *              Gro�- und Kleinschreibung.
	 */
	@Test
	@DisplayName("Gross- und Kleinschreibung nicht beruecksichtigen")
	void heuteSchluesselWortInCaseSensitive() {
		LocalDate heute = LocalDate.of(2019, 10, 21);
		LocalDateTime ergebnis = DatumUhrzeitUmwandler.umwandleStringToDateTime("Heute 15:35", heute);
		assertEquals(ergebnis, LocalDateTime.of(2019, 10, 21, 15, 35),
				() -> "Fehler: konnte 'heute' String in erwartete DatumUhrzeit nicht umwandeln " + "war: " + heute
						+ "\n"); // Lambda Expression beschleunigt die Ausgabe. Wird nur ausgef�hrt, wenn
									// ein Fehler auftritt
	}

}
