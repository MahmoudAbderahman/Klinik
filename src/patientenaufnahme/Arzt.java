package patientenaufnahme;

/**
 * 
 * Der Datentyp Arzt enth‰lt drei Konstanten als Wertebereich, die zwischen den
 * Klammern stehen.
 *
 */
public enum Arzt {
	/**
	 * Titinang ist ein Objekt vom Datentyp Arzt. Es ruft den Konstruktor mit dem
	 * String wert Steve Titinang.
	 */
	titinang("Steve Titinang"),
	/**
	 * Abdelrahman ist ein Objekt vom Datentyp Arzt. Es ruft den Konstruktor mit dem
	 * String wert Mahmoud Abdelrahman.
	 */
	abdelrahman("Mahmoud Abdelrahman"),
	/**
	 * Shaibani ist ein Objekt vom Datentyp Arzt. Es ruft den Konstruktor mit dem
	 * String wert Wesam Shaibani.
	 */
	shaibani("Wesam Shaibani");

	// Instazvariable
	private String arztNachname;

	/**
	 * Der Konstruktor vom Enum Arzt enth‰lt nur ein Parameter.
	 * 
	 * @param arztNachname ist der Nachname des Arzts
	 */
	Arzt(String arztNachname) {
		this.arztNachname = arztNachname;
	}

	/**
	 * Name des Arzts.
	 *
	 * @return den jeweiligen Arzt mittels seinem Namen.
	 */
	public String getArztNachName() {
		return arztNachname;
	}

}
