package avajLauncher.aircraft;

import avajLauncher.utils.FileWriting;
import avajLauncher.weather.*;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions() {

        String theWeather = this.weatherTower.getWeather(this.coordinates);
        if (theWeather.equalsIgnoreCase("RAIN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5, this.coordinates.getLatitude(), this.coordinates.getHeight());
            FileWriting.messages.add("Helicopter#" + this.name + "(" + this.id + ")" + ": Damn you rain! You messed up my baloon");
        } else if (theWeather.equalsIgnoreCase("FOG")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight());
            FileWriting.messages.add("Helicopter#" + this.name + "(" + this.id + ")" + ": Can't see a thing!");
        } else if (theWeather.equalsIgnoreCase("SUN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
            FileWriting.messages.add("Helicopter#" + this.name + "(" + this.id + ")" + ": This is hot.");
        } else if (theWeather.equalsIgnoreCase("SNOW")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
            FileWriting.messages.add("Helicopter#" + this.name + "(" + this.id + ")" + ": It's snowing. We're gonna crash");
        }
        unregisterTower();
    }

    public void registerTower(WeatherTower weatherTower) {

        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        FileWriting.messages.add("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " has registered to weather tower");
    }

    private void unregisterTower() {
        if (this.coordinates.getHeight() <= 0) {
            this.weatherTower.unregister(this);
            FileWriting.messages.add("Helicopter#" + this.name + "(" + this.id + ") landing.");
            FileWriting.messages.add("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " has unregistered from weather tower");
        }
    }
}
