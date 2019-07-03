package avajLauncher.weather;

import avajLauncher.utils.FileReading;

public class Simulator {

    WeatherTower W = new WeatherTower();
    public void simulate(FileReading R) {

        int i = 0;
        while (i < R.f.size()) {
            R.f.get(i).registerTower(W);
            i++;
        }

        while (R.numOfCycles-- > 0){
            W.changeWeather();
        }
    }

}
