interface Mediator {
    void send(Colleague colleague, String message);
}

abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    abstract void receive(String message);
}

class ConcreteMediator implements Mediator {
    private Colleague colleague1;
    private Colleague colleague2;

    public void setColleague1(Colleague colleague1) {
        this.colleague1 = colleague1;
    }

    public void setColleague2(Colleague colleague2) {
        this.colleague2 = colleague2;
    }

    @Override
    public void send(Colleague colleague, String message) {
        if(colleague == colleague1){
            colleague2.receive(message);
        } else {
            colleague1.receive(message);
        }
    }
}

class ConcreteColleague1 extends Colleague {

    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    @Override
    void receive(String message) {
        System.out.printf("ConcreteColleage1 received: %s\n", message);
    }
}

class ConcreteColleague2 extends Colleague {

    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    @Override
    void receive(String message) {
        System.out.printf("ConcreteColleage2 received: %s\n", message);
    }
}

public class Main {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        Colleague colleague1 = new ConcreteColleague1(mediator);
        Colleague colleague2 = new ConcreteColleague2(mediator);
        mediator.setColleague1(colleague1);
        mediator.setColleague2(colleague2);

        mediator.send(colleague1, "Hello");
        mediator.send(colleague2, "World");
    }
}
