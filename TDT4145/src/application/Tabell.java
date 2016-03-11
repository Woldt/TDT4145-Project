package application;

/**
 * 
 * @author Martin Stigen
 *
 */

public class Tabell {
	
	public static class Insert {
		
		private static final String TODO = "INSERT INTO ";
		
		public static String Innendørsøvelse(int øvelsesID, String luftventilasjon, int antallTilskuere) {
			return TODO + "Innendørsøvelse VALUES(" + øvelsesID + ", '" + luftventilasjon + "', " + antallTilskuere +");";
		}
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(Tabell.Insert.Innendørsøvelse(1, "bra", 10));
	}
}