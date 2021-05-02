import java.util.ArrayList;
import java.util.List;

interface Notifier {
    void notifyObserver();
    void attach(Observer observer);
    void detach(Observer observer);
    void stateChange();
}

interface Observer {
    void update();
}

class AbstractNotifier implements Notifier {
    private List<Observer> list = new ArrayList<>();
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public void notifyObserver() {
        for(Observer observer : list)
            observer.update();
    }

    @Override
    public void attach(Observer observer) {
        list.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void stateChange() {

    }
}

class Secretary extends AbstractNotifier {
    @Override
    public void stateChange(){
        setState("大家，老闆在門口了！");
    }
}

class Boss extends AbstractNotifier {
    @Override
    public void stateChange(){
        setState("大家，老闆我回來了！好久不見！");
    }
}

class StockObserver implements Observer {

    @Override
    public void update() {
        System.out.println("趕快關閉股票網頁，回去工作！");
    }
}

class NBAObserver implements Observer {

    @Override
    public void update() {
        System.out.println("趕快關閉NBA網頁，回去工作");
    }
}

public class Main {
    public static void main(String[] args){
        Notifier notifier = new Boss();
        Observer stockObserver = new StockObserver();
        Observer NBAObserver = new NBAObserver();

        notifier.attach(stockObserver);
        notifier.attach(NBAObserver);

        /* 看股票的觀察者，沒有被老闆通知到 */
        notifier.detach(stockObserver);

        notifier.stateChange();

        notifier.notifyObserver();
    }
}
