package patientenaufnahme;

public enum Arzt {
	titinang("Steve Titinang"), 
	abdelrahman("Mahmoud Abdelrahman"), 
	shaibani("Wesam Shaibani");

	private String arztNachname;

	Arzt(String arztNachname) {
		this.arztNachname = arztNachname;
	}

	public String getArztNachName() {
		return arztNachname;
	}

}
