import java.util.ArrayList;
import java.util.List;

public abstract class Observable {

    List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }
    public void removeObserver(Observer observer, String message) {
        observers.remove(observer);
        System.out.println(message);
    }

    public void notifyObservers(){
        for(Observer observer : observers){
            observer.update();
        }
    }
}
