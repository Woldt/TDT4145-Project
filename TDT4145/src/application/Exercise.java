package application;

/**
 * Created by Andreas on 08.03.2016.
 */

public abstract class Exercise {

    protected int ovelsesID;
    protected String name;
    protected String description;

    protected int temp; //outdoor exercise
    protected String weather; //outdoor exercise

    protected String ventilation; //indoor exercise
    protected int spectators; //indoor exercise


    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setOvelsesID(int id){
        this.ovelsesID = id;
    }

    public int getOvelsesID() {
        return ovelsesID;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public void setSpectators(int spectators) {
        this.spectators = spectators;
    }

    public void setVentilation(String ventilation) {
        this.ventilation = ventilation;
    }

    public String getWeather() {
        return weather;
    }

    public int getTemp() {
        return temp;
    }

    public String getVentilation() {
        return ventilation;
    }

    public int getSpectators() {
        return spectators;
    }

    public void setOutdoor(int temp, String weather){
        this.temp = temp;
        this.weather = weather;
    }

    public void setIndoor(String ventilation, int spectators){
        this.ventilation = ventilation;
        this.spectators = spectators;
    }

}
