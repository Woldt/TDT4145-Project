package application;

/**
 * @author Andreas Norstein
 * @author SigveAndreEvensen
 */
public class Strength extends Exercise {

    private static int belastning;
    private static int repetitions;
    private static int sets;
//
//    public Strength(int belastning, int repetitions, int sets, boolean indoor){
//        this.belastning = belastning;
//        this.repetitions = repetitions;
//        this.sets = sets;
//        if(indoor){
//            setIndoor(super.ventilation, super.spectators);
//        }else{
//            setOutdoor(super.temp, super.weather);
//        }
//    }

// Making the UI-model:
	public void removePropertyChangeListener(ExcercisesController excercisesController) {
		// TODO Auto-generated method stub
		
	}

	public void addPropertyChangeListener(ExcercisesController excercisesController) {
		// TODO Auto-generated method stub
		
	}

// Set methods
    public void setBelastning(int belastning) {
        this.belastning = belastning;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

// Get methods
    public static int getRepetitions() {
        return repetitions;
    }

    public static int getBelastning() {
        return belastning;
    }

    public static int getSets() {
        return sets;
    }



}

