package patientenaufnahme;

import java.time.LocalDateTime;

/**
 * 
 * Die Klasse PatientenTermin stellt einen Patienten dar. Ein Patient hat einen
 * Vornamen und einen Nachnamen. Er bekommt einen Termin und einen Arzt.
 *
 */
public class PatientenTermin {

	private String patientVorname;
	private String patientNachname;
	private LocalDateTime termin;
	private Arzt arzt;

	public PatientenTermin(String patientVorname, String patientNachname, LocalDateTime termin, Arzt arzt) {
		this.patientVorname = patientVorname;
		this.patientNachname = patientNachname;
		this.termin = termin;
		this.arzt = arzt;
	}

	/**
	 * @Getter
	 * @return Vorname des Patienten
	 */
	public String getPatientVorname() {
		return patientVorname;
	}

	/**
	 * @Getter
	 * @return Nachname des Patienten
	 */
	public String getPatientNachname() {
		return patientNachname;
	}
	/**
	 * @Getter
	 * @return Datum und Uhrzeit des Termins vom Patienten
	 */
	public LocalDateTime getTermin() {
		return termin;
	}

	/**
	 * @Getter
	 * @return Name des behandelenden Artzs
	 */
	public Arzt getArzt() {
		return arzt;
	}

	


}