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
 *              Anzeigenamen, für die mit dieser Annotation versehene Klasse
 *              oder Methode, zu deklarieren.
 * 
 *              Die Klasse DatumUhrzeitUmwandler enthält Methoden zum Testen der
 *              richtigen Eingabe vom Datum und von der Zeit mit und ohne den
 *              Schlüsselwort heute.
 */
@DisplayName("DatumUhrzeitUmwandler Muss")
class DatumUhrzeitUmwandlerTest {

	/**
	 * @Nested Diese Annotation ermöglicht es der Klasse, eine innere Klasse zu
	 *         haben, die im Wesentlichen eine Testklasse ist, sodass sie mehrere
	 *         Testklassen unter demselben übergeordneten Element gruppieren kann.
	 * 
	 * @DisplayName Diese Annotation wird verwendet, um einen benutzerdefinierten
	 *              Anzeigenamen, für die mit dieser Annotation versehene Klasse
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
		 *              Anzeigenamen, für die mit dieser Annotation versehene Klasse
		 *              oder Methode, zu deklarieren.
		 * 
		 *              Die Methode testUmwandleStringToDateTimeMitHeute() testet auf
		 *              das Vorkommen von dem Schlüsselwort heute (kleingeschrieben) in
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
		 *              Anzeigenamen, für die mit dieser Annotation versehene Klasse
		 *              oder Methode, zu deklarieren.
		 * 
		 *              Die Methode testUmwandleStringToDateTime() testet auf das
		 *              Vorkommen eines gültigen Datums und einer gültigen Uhrzeit, mit
		 *              gültigen Formaten, in dem String, die zu DateTime umgewandelt
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
	 *              Anzeigenamen, für die mit dieser Annotation versehene Klasse
	 *              oder Methode, zu deklarieren.
	 * 
	 *              Die Methode heuteSchluesselWortInCaseSensitive() testet auf das
	 *              Vorkommen von dem Schlüsselwort heute und achtet dabei nicht auf
	 *              Groß- und Kleinschreibung.
	 */
	@Test
	@DisplayName("Gross- und Kleinschreibung nicht beruecksichtigen")
	void heuteSchluesselWortInCaseSensitive() {
		LocalDate heute = LocalDate.of(2019, 10, 21);
		LocalDateTime ergebnis = DatumUhrzeitUmwandler.umwandleStringToDateTime("Heute 15:35", heute);
		assertEquals(ergebnis, LocalDateTime.of(2019, 10, 21, 15, 35),
				() -> "Fehler: konnte 'heute' String in erwartete DatumUhrzeit nicht umwandeln " + "war: " + heute
						+ "\n"); // Lambda Expression beschleunigt die Ausgabe. Wird nur ausgeführt, wenn
									// ein Fehler auftritt
	}

}
