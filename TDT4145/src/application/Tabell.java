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
			return TODO + values(valueOf(øvelsesID), valueOf(luftventilasjon), valueOf(antallTilskuere));
		}
		
		public static String MÅL(int målNr, String tidsperiode, String beskrivelse, int øvelsesID) {
			return TODO + values(valueOf(målNr), valueOf(tidsperiode), valueOf(beskrivelse), valueOf(øvelsesID));
		}
		
		public static String RESULTAT(int resultatNr, String besteResultat, String dato, int øvelsesID) {
			return TODO + values(valueOf(resultatNr), valueOf(besteResultat), valueOf(dato), valueOf(øvelsesID));
		}
		
		public static String STYRKE_OG_KONDISJON(int øvelsesID, int belastning, int antallRep, int antallSett) {
			return TODO + values(valueOf(øvelsesID), valueOf(belastning), valueOf(antallRep), valueOf(antallSett));
		}
		
		public static String TRENINGSØKT(String dato, String tidspunkt, int varighet, int personligForm, int prestasjon, String notat) {
			return TODO + values(valueOf(dato), valueOf(tidspunkt), valueOf(varighet), valueOf(personligForm), valueOf(prestasjon), valueOf(notat));
		}
		
		public static String UTENDØRSØVELSE(int øvelsesID, int temperatur, String værtype) {
			return TODO + values(valueOf(øvelsesID), valueOf(temperatur), valueOf(værtype));
		}
		
		public static String UTHOLDENHET(int øvelsesID, int lengdeKm, int minutter) {
			return TODO + values(valueOf(øvelsesID), valueOf(lengdeKm), valueOf(minutter));
		}
		
		public static String ØVELSE(String navn, String beskrivelse) {
			return TODO + values(valueOf(navn), valueOf(beskrivelse));
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