public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        TemperatureChange observer1 = new TemperatureChange("New observer added",station);
        TemperatureChange observer2 = new TemperatureChange("New observer added",station);

        Thread thread = new Thread(station);
        thread.start();

        // Antaa WeatherStationin runata 10 sekuntia ennen kuin yksi observer poistetaan
        try {
            Thread.sleep(10000);
        } catch (Exception e){
            e.printStackTrace();
        }
        station.removeObserver(observer2, "Observer 2 has been removed");
    }
}