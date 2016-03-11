package application;

/**
 * 
 * @author Martin Stigen
 *
 */
public enum Tabell {
	
	Innend�rs�velse("Innend�rs�velse"),
	M�l("M�l"),
	Resultat("Resultat"),
	StyrkeOgKondisjon("Styrke og kondisjon"),
	Trenings�kt("Trenings�kt"),
	Utend�rs�velse("Utend�rs�velse"),
	Utholdenhet("Utholdenhet"),
	�velse("�velse");
	
	private final String path; 
	
	Tabell(String path) {
		this.path = path;
	}
	
	public String toString() {
		return path;
	}
}
