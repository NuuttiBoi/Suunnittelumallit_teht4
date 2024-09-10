import java.lang.reflect.UndeclaredThrowableException;

public class WeatherStation extends Observable implements Runnable{
    private double tempature;
    private double maxTemp = 45.0;
    private double minTemp = -30;
    private WeatherStation station;
    private boolean running = true;
    private int sleepTime;
    public WeatherStation(){
        this.tempature =  Math.random() * ((maxTemp - minTemp) + 1) + minTemp;
        System.out.println("Current temperature is: " + this.tempature + " °C");
    }

    public void changeTemperature(){
        double newTemp = this.tempature +  (Math.random() * (1) -1);
        if(newTemp > minTemp && newTemp < maxTemp){
            this.tempature = newTemp;
            notifyObservers();
        } else
            System.out.println("The new tempature is either too high or too low," +
                    "there must be something wrong with the weather station");
    }

    public double getTempature(){
        return tempature;
    }

    @Override
    public void run() {
        while (running){
            sleepTime = (int) (Math.random()*((5000-1000)+1)+1000);
            try{
                Thread.sleep(sleepTime);
            }catch (Exception e){
                e.printStackTrace();
            }
            changeTemperature();
        }
    }
}
