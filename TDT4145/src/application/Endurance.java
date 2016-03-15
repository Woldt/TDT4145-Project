package application;

/**
 * @author Andreas Norstein
 * @author SigveAndreEvensen
 */
public class Endurance extends Exercise {

    private static int length;
    private static int minutes;
//
//    public Endurance(int length, int minutes, boolean indoor){
//        this.length = length;
//        this.minutes = minutes;
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
		
    public void setLength(int length) {
        this.length = length;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

// Get methods
    public static int getLength() {
        return length;
    }

    public static int getMinutes() {
        return minutes;
    }
    
    


}
