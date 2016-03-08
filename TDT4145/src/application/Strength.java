package application;

/**
 * Created by Andreas on 08.03.2016.
 */
public class Strength extends Exercise {

    private int belastning;
    private int repetitions;
    private int sets;

    public Strength(int belastning, int repetitions, int sets, boolean indoor){
        this.belastning = belastning;
        this.repetitions = repetitions;
        this.sets = sets;
        if(indoor){
            setIndoor(super.ventilation, super.spectators);
        }else{
            setOutdoor(super.temp, super.weather);
        }
    }

    public void setBelastning(int belastning) {
        this.belastning = belastning;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public int getBelastning() {
        return belastning;
    }

    public int getSets() {
        return sets;
    }

}

