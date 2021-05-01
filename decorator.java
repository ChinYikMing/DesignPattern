interface Component {
    void operation();
}

class ConcreteComponent implements Component {

    @Override
    public void operation() {
        System.out.println("Original undecorated component");
    }
}

class Decorator implements Component {
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}

class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    private String addedState;

    @Override
    public void operation(){
        super.operation();
        addedState = "New State";
        System.out.println("DecoratorA operation");
        System.out.println("New state is added in concrete decorator A");
    }
}

class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    private void AddedBehavior(){
        System.out.println("This is added behavior in concrete decorator B");
    }

    @Override
    public void operation(){
        super.operation();
        System.out.println("DecoratorB operation");
        AddedBehavior();
    }
}

public class Main {
    public static void main(String[] args){
        Component component = new ConcreteDecoratorB(new ConcreteDecoratorA(new ConcreteComponent()));

        component.operation();
    }
}

