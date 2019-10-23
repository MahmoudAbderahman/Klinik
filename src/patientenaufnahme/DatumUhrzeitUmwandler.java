package patientenaufnahme;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * 
 * Die Klasse DatumUhrzeitUmwandler wandelt das eingegebene Datum und die
 * eingegebene Uhrzeit vom Datentyp String in den Datentyp LocalDateTime um.
 *
 */
public class DatumUhrzeitUmwandler {

	/**
	 * Die Methode umwandleStringToDate nimmt als Eingabe ein String paramter, der
	 * f¸r die Benutzer das Datum und die Uhrzeit darstellt und ein Paramter vom
	 * Datentyp LocalDate, das den heutigen Tag darstellt. Die Methode ¸berpr¸ft,
	 * ob die Eingabe den String heute und eine Uhrzeit oder das deutsche Datum -und
	 * Zeitformat hat.
	 * 
	 * @param datumUhrzeitString das Datum und die Zeit bzw. den String heute und
	 *                           die Zeit in String format.
	 * @param heute              den heutigen Tag
	 * @return das Datum und die Uhrzeit in LocalDateTime Format, damit
	 *         LocalDateTime Methoden damit arbeiten koennen.
	 */
	public static LocalDateTime umwandleStringToDateTime(String datumUhrzeitString, LocalDate heute) {
		LocalDateTime aktuelleDatumUhrzeit = null;
		try {
			if (datumUhrzeitString.toLowerCase().startsWith("heute")) {
				String[] teile = datumUhrzeitString.split(" ", 2);
				LocalTime uhrzeit = LocalTime.parse(teile[1].toUpperCase(),
						DateTimeFormatter.ofPattern("HH:mm", Locale.GERMANY));
				aktuelleDatumUhrzeit = LocalDateTime.of(heute, uhrzeit);
			} else {
				aktuelleDatumUhrzeit = LocalDateTime.parse(datumUhrzeitString.toUpperCase(),
						DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm", Locale.GERMANY));
			}
		} catch (Throwable t) {
			throw new RuntimeException("Das Datum kann nicht erzeugt werden im form von [ " + datumUhrzeitString
					+ "], bitte nutzen Sie das format [dd.MM.yyyy HH:mm]");
		}
		return aktuelleDatumUhrzeit;
	}
}
