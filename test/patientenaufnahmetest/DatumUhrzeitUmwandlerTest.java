package patientenaufnahmetest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import patientenaufnahme.DatumUhrzeitUmwandler;

@DisplayName("DatumUhrzeitUmwandler Muss")
class DatumUhrzeitUmwandlerTest {

	@Nested
	@DisplayName("String mit 'heute' umwandeln")
	class HeuteTests
	{
		@Test
		@DisplayName("mit")
		void testUmwandleStringToDateTimeMitHeute() {
			LocalDate heute = LocalDate.of(2019, 10, 21);
			LocalDateTime ergebnis = DatumUhrzeitUmwandler.umwandleStringToDateTime("heute 15:35", heute);
			assertEquals(ergebnis, LocalDateTime.of(2019, 10, 21, 15, 35), "Fehler: konnte 'heute' String in erwartete DatumUhrzeit nicht umwandeln "
					+ "war: " + heute + "\n");
		}
		
		@Test
		@DisplayName("ohne")
		void testUmwandleStringToDateTime()
		{
			LocalDateTime ergebnis = DatumUhrzeitUmwandler.umwandleStringToDateTime("25.10.2019 15:35", LocalDate.of(2019, 10, 25));
			assertEquals(ergebnis, LocalDateTime.of(2019, 10, 25, 15, 35));
		}
	}
	
	
	
	@Test
	@DisplayName("Gross- und Kleinschreibung nicht beruecksichtigen")
	void heuteSchluesselWortInCaseSensitive()
	{
		LocalDate heute = LocalDate.of(2019, 10, 21);
		LocalDateTime ergebnis = DatumUhrzeitUmwandler.umwandleStringToDateTime("Heute 15:35", heute);
		assertEquals(ergebnis, LocalDateTime.of(2019, 10, 21, 15, 35), () -> "Fehler: konnte 'heute' String in erwartete DatumUhrzeit nicht umwandeln "
				+ "war: " + heute + "\n"); // Lambda Expression beschleunigt die Ausgabe. Wird nur ausgefuehrt, wenn es einen Fehler auftritt
	}

}
