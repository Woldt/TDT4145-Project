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
			return TODO + "Innend�rs�velse " + values(valueOf(�velsesID), valueOf(luftventilasjon), valueOf(antallTilskuere));
		}
		
		public static String M�L(String tidsperiode, String beskrivelse, int �velsesID) {
			return TODO + "M�l " + values("DEFAULT", valueOf(tidsperiode), valueOf(beskrivelse), valueOf(�velsesID));
		}
		
		public static String RESULTAT(int resultatNr, String besteResultat, String dato, int �velsesID) {
			return TODO + "Resultat " + values(valueOf(resultatNr), valueOf(besteResultat), valueOf(dato), valueOf(�velsesID));
		}
		
		public static String STYRKE_OG_KONDISJON(int �velsesID, int belastning, int antallRep, int antallSett) {
			return TODO + "Styrke og kondisjon " + values(valueOf(�velsesID), valueOf(belastning), valueOf(antallRep), valueOf(antallSett));
		}
		
		public static String TRENINGS�KT(String dato, String tidspunkt, int varighet, int personligForm, int prestasjon, String notat) {
			return TODO + "Trenings�kt " + values("DEFAULT" , valueOf(dato), valueOf(tidspunkt), valueOf(varighet), valueOf(personligForm), valueOf(prestasjon), valueOf(notat));
		}
		
		public static String UTEND�RS�VELSE(int �velsesID, int temperatur, String v�rtype) {
			return TODO + "Utend�rs�velse " + values(valueOf(�velsesID), valueOf(temperatur), valueOf(v�rtype));
		}
		
		public static String UTHOLDENHET(int �velsesID, int lengdeKm, int minutter) {
			return TODO + "Utholdenhet " + values(valueOf(�velsesID), valueOf(lengdeKm), valueOf(minutter));
		}
		
		public static String �VELSE(String navn, String beskrivelse) {
			return TODO + "�velse " + values("DEFAULT" , valueOf(navn), valueOf(beskrivelse));
		}
		public static String BEST�R_AV(int treningsid, int �velsesid) {
			return TODO + "Best�rAv " + values(valueOf(treningsid), valueOf(�velsesid));
		}
	}
	
	public static class SELECT {
		
		private static final String TODO = "SELECT * FROM ";
		
		public static String INNEND�RS�VELSE() {
			return TODO + "Innend�rs�velse";
		}
		
		public static String M�L() {
			return TODO + "M�l";
		}
		
		public static String RESULTAT() {
			return TODO + "Resultat";
		}
		
		public static String STYRKE_OG_KONDISJON() {
			return TODO + "Styrke og kondisjon";
		}
		
		public static String TRENINGS�KT() {
			return TODO + "Trenings�kt";
		}
		
		public static String UTEND�RS�VELSE() {
			return TODO + "Utend�rs�velse";
		}
		
		public static String UTHOLDENHET() {
			return TODO + "Utholdenhet";
		}
		
		public static String �VELSE() {
			return TODO + "�velse";
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