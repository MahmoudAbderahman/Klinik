package patientenaufnahme;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * Die Klasse KlinikMenue enth‰lt die main Methode bzw. den Startpunkt unseres
 * Programms und somit dient sie als Testdriver Klasse. Sie stellt das
 * Programmoberfl‰che dar. Auﬂerdem enth‰lt diese Klasse Methoden zum Zeigen
 * aller Termine, aller heutigen Termin und zum Eintragen von Patientendaten.
 *
 */
public class KlinikMenue {
	/*
	 * KlinikKalendar ist static, damit diese Kopie von allen Instanzen lesbar wird.
	 */
	private static KlinikKalendar kalendar;

	/**
	 * Die main Methode ist der Startpunkt jedes Programms und von hier werden alle
	 * anderen Methoden aufgerufen.
	 * 
	 * @param args ist ein Array von Stringreferenzen
	 * @throws Throwable f‰ngt sowohl checkedExceptions als auch uncheckedExceptions
	 */
	public static void main(String[] args) throws Throwable {
		kalendar = new KlinikKalendar(LocalDate.now());

		Scanner scanner = new Scanner(System.in);
		System.out.println("Willkommen bei dem Patientenaufnahmesystem!\n\n");
		String letzteAuswahl = "";

		while (!letzteAuswahl.equalsIgnoreCase("x")) {
			letzteAuswahl = zeigeMeneu(scanner);
		}
		System.out.println("\nSystem schliessen...\n");
	}

	/**
	 * Stellt die Oberfl‰che unseres Programms dar und gibt die Wahl des Benutzers
	 * zur¸ck.
	 * 
	 * @param scanner dient zum Eingeben vom Daten durch den Benutzer.
	 * @return die Operation, die der Benutzer gew‰hlt hat
	 * @throws Throwable f‰ngt sowohl checkedExceptions als auch uncheckedExceptions
	 */
	private static String zeigeMeneu(Scanner scanner) throws Throwable {
		System.out.println("\nBitte waehlen Sie eine Option aus:");
		System.out.println("1. Erstelle einen neuen Patiententermin");
		System.out.println("2. Zeige alle Termine");
		System.out.println("3. Zeige alle Termine vom heute");
		System.out.println("X. System schliessen.");
		System.out.print("Auswahl: ");
		String auswahl = scanner.next();

		switch (auswahl) {
		case "1":
			patientenEintragen(scanner);
			return auswahl;
		case "2":
			alleTermineZeigen(scanner);
			return auswahl;
		case "3":
			getHeutigeTermine();
			return auswahl;
		default:
			System.out.println("System wird geschlossen...");
			return auswahl;
		}
	}

	/**
	 * Stellt die Oberfl‰che unseres Programms dar und tr‰gt die Daten eines
	 * Patienten ein.
	 * 
	 * @param scanner dient zum Eingeben vom Daten durch den Benutzer.
	 */
	private static void patientenEintragen(Scanner scanner) {
		scanner.nextLine();
		System.out.println("\n\nBitte Termininformationen eingeben:");
		System.out.print("  Patient Nachname: ");
		String nachname = scanner.nextLine();
		System.out.print("  Patient Vorname: ");
		String vorname = scanner.nextLine();
		System.out.print("  Datum und Zeit des Termins (dd.MM.yyyy HH:mm): ");
		String wann = scanner.nextLine();
		System.out.print("  Arzt Nachname: ");
		String arzt = scanner.nextLine();

		try {
			kalendar.terminErstellen(vorname, nachname, arzt, wann);
		} catch (Throwable t) {
			System.out.println("Fehler! " + t.getMessage());
			return;
		}

		System.out.println("Patient wurde erfolgreich eingetragen.\n\n");

	}

	/**
	 * Zeigt aller Termine samt Patienten Daten im System.
	 * 
	 * @param scanner dient zum Eingeben vom Daten durch den Benutzer.
	 * @throws Throwable f‰ngt sowohl checkedExceptions als auch uncheckedExceptions
	 */
	private static void alleTermineZeigen(Scanner scanner) throws Throwable {
		System.out.println("\n\nAlle Termine im System:");

		for (PatientenTermin termin : kalendar.getTermine()) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
			String terminZeit = formatter.format(termin.getTermin());
			System.out.println(String.format("%s:  %s, %s\t\tArzt: %s", terminZeit, termin.getPatientNachname(),
					termin.getPatientVorname(), termin.getArzt().getArztNachName()));
		}

		System.out.println("\nDruecken Sie bitte irgendwelche Taste, um fortzufahren...");
		System.in.read();
		System.out.println("\n\n");
	}

	/**
	 * Zeigt aller Termine samt Patienten Daten im System.
	 * 
	 * @param termine ist eine Variable, die alle Termine in der Liste darstellt.
	 */
	private static void getAlleTermine(List<PatientenTermin> termine) {
		for (PatientenTermin termin : termine) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
			String terminZeit = formatter.format(termin.getTerminDatumUhrzeit());
			System.out.printf("%s:  %s,  %s\t\tArzt: %s", terminZeit, termin.getPatientNachname(),
					termin.getPatientVorname(), termin.getArzt().getArztNachName());
		}
	}

	/**
	 * Zeigt nur die heutigen Termine.
	 * 
	 * @throws Throwable f‰ngt sowohl checkedExceptions als auch uncheckedExceptions
	 */
	private static void getHeutigeTermine() throws Throwable {
		System.out.println("\n\nTermine fuer heute:");
		getAlleTermine(kalendar.getHeutigeTermine());
		System.out.println("\nDruecken Sie bitte irgendwelche Taste, um fortzufahren...");
		System.in.read();
		System.out.println("\n\n");
	}

}
