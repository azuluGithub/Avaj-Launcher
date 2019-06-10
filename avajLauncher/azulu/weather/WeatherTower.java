package azulu.weather;

import azulu.aircrafts.*;
import azulu.weather.Tower;

/*this is a child class which inherits from parent class
 *this class makes generated Weather and updates accessible
*/
public class WeatherTower extends Tower {
	
	public String getWeather(Coordinates coordinates) {
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}
	
	public void changeWeather() {
		this.conditionsChanged();
	}
	
	public void addNewFlyables(Flyable flyable) {
		this.register(flyable);
	}
	
	public void removeFlyables(Flyable flyable) {
		this.unregister(flyable);
	}
}
