package patientenaufnahme;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * Die Klasse KlinikKalendar repräsentiert ein Terminbuchungssystem für eine Klinik.
 *
 */
public class KlinikKalendar {

	private List<PatientenTermin> termine;
	private LocalDate heute;

	/**
	 * Der Standard-Konstruktor von der Klasse KlinikKalendar.
	 */
	public KlinikKalendar() {
		this.termine = new ArrayList<>();
	}

	/**
	 * Der Initialisierungskonstruktor von der Klasse KlinikKalendar.
	 * 
	 * @param heute eine Variable, die den heutigen Tag darstellen soll.
	 */
	public KlinikKalendar(LocalDate heute) {
		this.heute = heute;
		this.termine = new ArrayList<>();
	}

	/**
	 * Erstellt einen neuen Termin f¸r den Patienten. Dabei werden Daten wie Vorname
	 * und Nachname des Patienten verlangt. Auﬂerdem sind Daten wie Name des Arzt
	 * und den Termin auch wichtig.
	 * 
	 * @param patientVorname  Vorname des Patienten
	 * @param patientNachname Nachname des Patienten
	 * @param arztKey         Name des Arzts
	 * @param wann            Termin der Behandlung
	 */
	public void terminErstellen(String patientVorname, String patientNachname, String arztKey, String wann) {
		Arzt doc = Arzt.valueOf(arztKey.toLowerCase());
		LocalDateTime localDateTime;

		localDateTime = DatumUhrzeitUmwandler.umwandleStringToDateTime(wann, heute);
		PatientenTermin termin = new PatientenTermin(patientVorname, patientNachname, localDateTime, doc);
		termine.add(termin);
	}

	/**
	 * Gibt alle Termine im System zurueck.
	 * 
	 * @return aller vorher eingetragene Termine als eine Liste.
	 */
	public List<PatientenTermin> getTermine() {
		return this.termine;
	}

	/**
	 * Gibt nur die Termine von dem heutigen Tag zurueck.
	 * 
	 * @return aller vorher eingetragene Termine als eine Liste.
	 */
	public List<PatientenTermin> getHeutigeTermine() {
		return termine.stream().filter(ter -> ter.getTermin().toLocalDate().equals(heute))
				.collect(Collectors.toList());
	}

	/**
	 * Zeigt, ob es an einem bestimmten datum einen Termin gibt. Falls ja, dann
	 * true, ansonsten false.
	 * 
	 * @param datum das zu ueberpruefende Datum.
	 * @return true, wenn das eingegebene Datum in dem Stream (Liste der Termine)
	 *         gefunden wurde, ansonsten false.
	 */
	public boolean hatTermin(LocalDate datum) {
		return termine.stream().anyMatch(ter -> ter.getTermin().toLocalDate().equals(datum));
	}

}
