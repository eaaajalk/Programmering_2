package observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    private int temp;
    private String type;
    private String luftfugtighed;
    private List<Observer> observerList = new ArrayList<>();

    public WeatherData() {
        this.temp = 0;
        this.type = "Unknown";
        this.luftfugtighed = "Unknown";
    }

    public WeatherData(int temp, String type, String luftfugtighed) {
        this.temp = temp;
        this.type = type;
        this.luftfugtighed = luftfugtighed;
    }
    @Override
    public void attach(Observer observer) {
        if (!observerList.contains(observer)) {
            observerList.add(observer);
        }
    }

    public void setWeatherData(WeatherData weatherData) {
        this.temp = weatherData.getTemp();
        this.type = weatherData.getType();
        this.luftfugtighed = weatherData.getLuftfugtighed();
    }
    @Override
    public void detach(Observer observer) {
        if (observerList.contains(observer)) {
            observerList.remove(observer);
        }
    }
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(getWeatherData());
        }
    }

    public int getTemp() {
        return temp;
    }

    public String getType() {
        return type;
    }

    public String getLuftfugtighed() {
        return luftfugtighed;
    }

    public WeatherData getWeatherData() {
        return this;
    }


}
