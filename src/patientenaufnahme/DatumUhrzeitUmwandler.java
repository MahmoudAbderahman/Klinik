package patientenaufnahme;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DatumUhrzeitUmwandler {

	public static LocalDateTime umwandleStringToDateTime(String datumUhrzeitString, LocalDate heute)
	{
		LocalDateTime aktuelleDatumUhrzeit = null;
		try {
			if(datumUhrzeitString.toLowerCase().startsWith("heute"))
			{
				String [] teile = datumUhrzeitString.split(" ", 2);
				LocalTime uhrzeit = LocalTime.parse(teile[1].toUpperCase(), DateTimeFormatter.ofPattern("H:mm", Locale.GERMANY));
				aktuelleDatumUhrzeit = LocalDateTime.of(heute, uhrzeit);
			}
			else 
			{
				aktuelleDatumUhrzeit = LocalDateTime.parse(datumUhrzeitString.toUpperCase(), DateTimeFormatter.ofPattern("d.M.yyyy H:mm", Locale.GERMANY));
			}
		} catch(Throwable t) {
			throw new RuntimeException("Das Datum kann nicht erzeugt werden im form von [ " + datumUhrzeitString + "], bitte nutzt das format [d.M.yyyy H:mm]");
		}
		return aktuelleDatumUhrzeit;
	}
}
