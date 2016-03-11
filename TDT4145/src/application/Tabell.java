package application;

/**
 * 
 * @author Martin Stigen
 *
 */

public class Tabell {
	
	public static class INSERT {
		
		private static final String TODO = "INSERT INTO ";
		
		public static String INNENDØRSØVELSE(int øvelsesID, String luftventilasjon, int antallTilskuere) {
			return TODO + "Innendørsøvelse VALUES(" + øvelsesID + ", " + valueOf(luftventilasjon) + ", " + antallTilskuere +");";
		}
		
		public static String MÅL(int målNr, String tidsperiode, String beskrivelse, int øvelsesID) {
			return TODO + values(valueOf(målNr), valueOf(tidsperiode), valueOf(beskrivelse), valueOf(øvelsesID));
		}
		
		public static String RESULTAT(int resultatNr, String besteResultat, String dato, int øvelsesID) {
			return TODO;
		}
		
		public static String STYRKE_OG_KONDISJON(int øvelsesID, int belastning, int antallRep, int antallSett) {
			return TODO;
		}
		
		public static String TRENINGSØKT(int treningsID, String dato, String tidspunkt, int varighet, int personligForm, int prestasjon, String notat) {
			return TODO;
		}
		
		public static String UTENDØRSØVELSE(int øvelsesID, int temperatur, String værtype) {
			return TODO;
		}
		
		public static String UTHOLDENHET(int øvelsesID, int lengdeKm, int minutter) {
			return TODO;
		}
		
		public static String ØVELSE(int øvelsesID, String navn, String beskrivelse) {
			return TODO;
		}
	}
	
	private static String valueOf(String value) {
		return "'" + value + "'";
	}
	
	private static String valueOf(int value) {
		return String.valueOf(value);
	}
	
	private static String values(String... values) {
		StringBuilder statement = new StringBuilder();
		
		for (String value : values) {
			if (statement.length() == 0) {
				statement.append("VALUES(");
			}
			else {
				statement.append(", ");
			}
			statement.append(value);
		}
		
		statement.append(");");
		return statement.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(Tabell.INSERT.MÅL(5, "Hei", "Anal", 55));
	}
}