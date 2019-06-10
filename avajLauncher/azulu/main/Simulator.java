package azulu.main;

import azulu.ritefile.RidFile;
import azulu.weather.WeatherTower;

/* 1)-Aircrafts from array list are registered to tower
 * 2)-simulations run based on number passed from scenario file
 *   -in every cycle, a singleton instance is called which generates
 *	  new weather
 *   -registered aircrafts gets updates
 *	 -height of aircraft <= 0 aircraft lands and unregisters
*/

public class Simulator {

	WeatherTower W = new WeatherTower();
	public void simulate(RidFile R) {

		/*1*/
		int i = 0;
		while (i < R.f.size()) {
			R.f.get(i).registerTower(W);
			i++;
		}
		
		/*2*/
		while (R.numOfCycles-- > 0){
			W.changeWeather();
		}
	}

}
