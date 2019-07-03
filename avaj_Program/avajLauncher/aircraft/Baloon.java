package avajLauncher.aircraft;

import avajLauncher.utils.FileWriting;
import avajLauncher.weather.*;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions() {
        String theWeather = this.weatherTower.getWeather(this.coordinates);
        if (theWeather.equalsIgnoreCase("RAIN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
            FileWriting.messages.add("Baloon#" + this.name + "(" + this.id + ")" + ": It's raining. Better watch out for lightings.");
        } else if (theWeather.equalsIgnoreCase("FOG")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
            FileWriting.messages.add("Baloon#" + this.name + "(" + this.id + ")" + ": OMG! Winter is coming!");
        } else if (theWeather.equalsIgnoreCase("SUN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
            FileWriting.messages.add("Baloon#" + this.name + "(" + this.id + ")" + ": Let's enjoy the good weather and take some pics.");
        } else if (theWeather.equalsIgnoreCase("SNOW")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
            FileWriting.messages.add("Baloon#" + this.name + "(" + this.id + ")" + ": My rotor is going to freeze!");
        }

        unregisterTower();
    }

    public void registerTower(WeatherTower weatherTower) {

        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        FileWriting.messages.add("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " has registered to weather tower");
    }

    private void unregisterTower() {
        if (this.coordinates.getHeight() <= 0) {
            this.weatherTower.unregister(this);
            FileWriting.messages.add("Baloon#" + this.name + "(" + this.id + ") landing.");
            FileWriting.messages.add("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " has unregistered from weather tower");
        }
    }

}
