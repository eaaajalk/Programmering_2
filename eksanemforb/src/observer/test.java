package observer;

import com.sun.source.tree.NewArrayTree;

public class test {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        WeatherDisplay weatherDisplay1 = new WeatherDisplay("Display 1");
        WeatherDisplay weatherDisplay2 = new WeatherDisplay("Display 2");

        weatherData.attach(weatherDisplay1);
        weatherData.attach(weatherDisplay2);

        // Simulér opdatering af vejrdata
        WeatherData updatedWeatherData = new WeatherData(25, "god", "Sunny");
        weatherData.setWeatherData(updatedWeatherData);
        weatherData.notifyObservers();


    }
}
