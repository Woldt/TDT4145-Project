package application;

/**
 * 
 * @author Martin Stigen
 *
 */

public class Tabell {
	
	public static class Insert {
		
		private static final String TODO = "INSERT INTO ";
		
		public static String Innend�rs�velse(int �velsesID, String luftventilasjon, int antallTilskuere) {
			return TODO + "Innend�rs�velse VALUES(" + �velsesID + ", '" + luftventilasjon + "', " + antallTilskuere +");";
		}
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(Tabell.Insert.Innend�rs�velse(1, "bra", 10));
	}
}