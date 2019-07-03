package avajLauncher.aircraft;

import avajLauncher.utils.FileWriting;
import avajLauncher.weather.*;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }
    public void updateConditions() {

        String theWeather = this.weatherTower.getWeather(this.coordinates);
        if (theWeather.equalsIgnoreCase("RAIN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 5, this.coordinates.getHeight() - 5);
            FileWriting.messages.add("JetPlane#" + this.name + "(" + this.id + ")" + ": The clouds are crying!");
        } else if (theWeather.equalsIgnoreCase("FOG")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 1, this.coordinates.getHeight() - 5);
            FileWriting.messages.add("JetPlane#" + this.name + "(" + this.id + ")" + ": Giants are smoking. Can't see clearly");
        } else if (theWeather.equalsIgnoreCase("SUN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 10, this.coordinates.getHeight() + 2);
            FileWriting.messages.add("JetPlane#" + this.name + "(" + this.id + ")" + ": Nice sun, its summertime");
        } else if (theWeather.equalsIgnoreCase("SNOW")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 7);
            FileWriting.messages.add("JetPlane#" + this.name + "(" + this.id + ")" + ": This white thingy makes me cold");
        }
        unregisterTower();
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        FileWriting.messages.add("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " has registered to weather tower");
    }

    private void unregisterTower() {
        if (this.coordinates.getHeight() == 0) {
            this.weatherTower.unregister(this);
            FileWriting.messages.add("JetPlane#" + this.name + "(" + this.id + ") landing.");
            FileWriting.messages.add("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " has unregistered from weather tower");
        }
    }
}
