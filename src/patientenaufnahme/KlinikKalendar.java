package patientenaufnahme;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class KlinikKalendar {

	private List<PatientenTermin> termine;
	private LocalDate heute;
	public KlinikKalendar() {
		this.termine = new ArrayList<>();
	}

	public KlinikKalendar(LocalDate heute) {
		this.heute = heute;
		this.termine = new ArrayList<>();
	}

	public void terminErstellen(String patientVorname, String patientNachname, String arztKey, String wann) {
		Arzt doc = Arzt.valueOf(arztKey.toLowerCase());
		LocalDateTime localDateTime;
		
		localDateTime = DatumUhrzeitUmwandler.umwandleStringToDateTime(wann, heute);
		PatientenTermin termin = new PatientenTermin(patientVorname, patientNachname, localDateTime, doc);
		termine.add(termin);
	}

	public List<PatientenTermin> getTermine() {
		return this.termine;
	}
	public List<PatientenTermin> getHeutigeTermine()
	{
		return termine.stream().filter(ter -> ter.getTerminDatumUhrzeit().toLocalDate().equals(heute)).collect(Collectors.toList());
	}
	
	public boolean hatTermin(LocalDate datum)
	{
		return termine.stream()
		         .anyMatch(appt -> appt.getTerminDatumUhrzeit().toLocalDate().equals(datum));
		}

}
