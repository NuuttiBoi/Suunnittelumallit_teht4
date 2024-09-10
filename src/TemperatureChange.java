public class TemperatureChange implements Observer{
    private String message;
    private WeatherStation observable;
    public TemperatureChange(String message, WeatherStation observable){
        this.message = message;
        System.out.println(message);
        this.observable = observable;
        observable.addObserver(this);
    }
    @Override
    public void update() {
        System.out.println("Observer has received an update, ");
        System.out.println("the new tempature is: " + observable.getTempature() + " °C");
    }
}
