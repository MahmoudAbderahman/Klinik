package patientenaufnahme;

import java.time.LocalDateTime;

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

	public String getPatientVorname() {
		return patientVorname;
	}

	public String getPatientNachname() {
		return patientNachname;
	}

	public LocalDateTime getTermin() {
		return termin;
	}

	public Arzt getArzt() {
		return arzt;
	}

	public LocalDateTime getTerminDatumUhrzeit() {
		return termin;
	}

}
