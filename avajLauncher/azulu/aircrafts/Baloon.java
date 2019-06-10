package azulu.aircrafts;

import azulu.aircrafts.Aircraft;
import azulu.ritefile.*;
import azulu.weather.*;

/*1)-This class is a child class of aircraft class so it inherits 
 *  -attributes and methods from parent class
 *2)-it implements all flayble class methods
 *3)-we access weatherTower class which is passed in through
 *   registerTower method
 *4)-when a class constructor is called, a superClass creates a new
 *   aircraft with a unique ID
 *5)-the generated weather is used to increase/decrease aircraft's 
 *   height, latitude, longitude
 *   coordinates are updated on this class
 *6)-messages are stored on array list
 *7)-if height is <= 0 the aircraft unregisters from tower
 *8)-a created aircraft is registered to the tower
*/
					/*1*/				/*2*/
public class Baloon extends Aircraft implements Flyable {
	/*3*/
	private WeatherTower weatherTower;
	/*4*/
	Baloon(String name, Coordinates coordinates){
		super(name, coordinates);
	}
	public void updateConditions() {
		/*5*/
		String theWeather = this.weatherTower.getWeather(this.coordinates);
		if (theWeather.equalsIgnoreCase("RAIN")) {
			this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
			/*6*/
			RiteFile.messages.add("Baloon#" + this.name + "(" + this.id + ")" + ": It's raining. Better watch out for lightings.");
		} else if (theWeather.equalsIgnoreCase("FOG")) {
			this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
			RiteFile.messages.add("Baloon#" + this.name + "(" + this.id + ")" + ": OMG! Winter is coming!");
		} else if (theWeather.equalsIgnoreCase("SUN")) {
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
			RiteFile.messages.add("Baloon#" + this.name + "(" + this.id + ")" + ": Let's enjoy the good weather and take some pics.");
		} else if (theWeather.equalsIgnoreCase("SNOW")) {
			this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
			RiteFile.messages.add("Baloon#" + this.name + "(" + this.id + ")" + ": My rotor is going to freeze!");
		}
		/*7*/
		unregisterTower();
	}
	/*8*/
	public void registerTower(WeatherTower weatherTower) {
		/*3*/
		this.weatherTower = weatherTower;
		this.weatherTower.addNewFlyables(this);
		RiteFile.messages.add("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " has registered to weather tower");
	}
	
	private void unregisterTower() {
		if (this.coordinates.getHeight() <= 0) {
			this.weatherTower.removeFlyables(this);
			RiteFile.messages.add("Baloon#" + this.name + "(" + this.id + ") landing.");
			RiteFile.messages.add("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " has unregistered from weather tower");
		}
	}
}
