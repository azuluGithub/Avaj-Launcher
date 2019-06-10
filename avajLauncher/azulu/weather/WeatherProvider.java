package azulu.weather;

import azulu.aircrafts.*;
import azulu.weather.WeatherProvider;

/*1)-this class uses singleton pattern, only one instance is created
 *2)-it uses lazy instantiation
 *3)-random weather is generated
*/

public class WeatherProvider {

	private static WeatherProvider weatherProvider = null;
	private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
	/*1*/
	private WeatherProvider () {}
	
	public static WeatherProvider getProvider() {
		/*2*/
		if (weatherProvider == null) {
			weatherProvider = new WeatherProvider();
		}
		return weatherProvider;
	}
	/*3*/
	public String getCurrentWeather(Coordinates coordinates) {
		int Lon = coordinates.getLongitude();
		int Lat = coordinates.getLatitude();
		int Hei = coordinates.getHeight();
		int x, y, z;
		int rand = (int)(Math.random() * 60);
		
		if (Lon >= rand) {
			x = 1;
		} else {
			x = 0;
		}
		if (Lat >= rand) {
			y = 1;
		} else {
			y = 0;
		}
		if (Hei >= rand) {
			z = 1;
		} else {
			z = 0;
		}
		return weather[x + y + z];
	}
	
}

