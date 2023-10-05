package observer;

public class WeatherDisplay implements Observer {
    public String displayName;

    public WeatherDisplay(String displayName) {
        this.displayName = displayName;
    }

    public void update(WeatherData weatherData) {
        System.out.println(displayName + ": Luftfugtighed: " + weatherData.getLuftfugtighed() + " Temperatur: " + weatherData.getTemp() +
                " Typer: " + weatherData.getType());

    }

}
