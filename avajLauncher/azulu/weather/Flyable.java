package azulu.weather;

import azulu.weather.WeatherTower;
/*
 * All interface methods are to be impemented
*/
public interface Flyable {
	
	void updateConditions();
	void registerTower(WeatherTower weatherTower);
}
