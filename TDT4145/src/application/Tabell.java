package application;

/**
 * 
 * @author Martin Stigen
 *
 */

public class Tabell {
	
	public static class INSERT {
		
		private static final String TODO = "INSERT INTO ";
		
		public static String INNEND�RS�VELSE(int �velsesID, String luftventilasjon, int antallTilskuere) {
			return TODO + values(valueOf(�velsesID), valueOf(luftventilasjon), valueOf(antallTilskuere));
		}
		
		public static String M�L(int m�lNr, String tidsperiode, String beskrivelse, int �velsesID) {
			return TODO + values(valueOf(m�lNr), valueOf(tidsperiode), valueOf(beskrivelse), valueOf(�velsesID));
		}
		
		public static String RESULTAT(int resultatNr, String besteResultat, String dato, int �velsesID) {
			return TODO + values(valueOf(resultatNr), valueOf(besteResultat), valueOf(dato), valueOf(�velsesID));
		}
		
		public static String STYRKE_OG_KONDISJON(int �velsesID, int belastning, int antallRep, int antallSett) {
			return TODO + values(valueOf(�velsesID), valueOf(belastning), valueOf(antallRep), valueOf(antallSett));
		}
		
		public static String TRENINGS�KT(String dato, String tidspunkt, int varighet, int personligForm, int prestasjon, String notat) {
			return TODO + values(valueOf(dato), valueOf(tidspunkt), valueOf(varighet), valueOf(personligForm), valueOf(prestasjon), valueOf(notat));
		}
		
		public static String UTEND�RS�VELSE(int �velsesID, int temperatur, String v�rtype) {
			return TODO + values(valueOf(�velsesID), valueOf(temperatur), valueOf(v�rtype));
		}
		
		public static String UTHOLDENHET(int �velsesID, int lengdeKm, int minutter) {
			return TODO + values(valueOf(�velsesID), valueOf(lengdeKm), valueOf(minutter));
		}
		
		public static String �VELSE(String navn, String beskrivelse) {
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
		System.out.println(Tabell.INSERT.M�L(5, "Hei", "Anal", 55));
	}
}