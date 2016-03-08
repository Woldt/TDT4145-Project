package application;

/**
 * @author Andreas Norstein
 */
public class Endurance extends Exercise {

    private int length;
    private int minutes;

    public Endurance(int length, int minutes, boolean indoor){
        this.length = length;
        this.minutes = minutes;
        if(indoor){
            setIndoor(super.ventilation, super.spectators);
        }else{
            setOutdoor(super.temp, super.weather);
        }
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getLength() {
        return length;
    }

    public int getMinutes() {
        return minutes;
    }
}
