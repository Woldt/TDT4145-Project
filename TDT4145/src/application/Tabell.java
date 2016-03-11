package application;

/**
 * 
 * @author Martin Stigen
 *
 */
public enum Tabell {
	
	Innendørsøvelse("Innendørsøvelse"),
	Mål("Mål"),
	Resultat("Resultat"),
	StyrkeOgKondisjon("Styrke og kondisjon"),
	Treningsøkt("Treningsøkt"),
	Utendørsøvelse("Utendørsøvelse"),
	Utholdenhet("Utholdenhet"),
	Øvelse("Øvelse");
	
	private final String path; 
	
	Tabell(String path) {
		this.path = path;
	}
	
	public String toString() {
		return path;
	}
}
