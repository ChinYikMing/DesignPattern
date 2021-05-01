import java.util.ArrayList;
import java.util.List;

interface Command {
    void execute();
}

class CookSteakCommand implements Command {
    private Chef chef;

    public CookSteakCommand(Chef chef) {
        this.chef = chef;
    }

    @Override
    public void execute() {
        chef.cookSteak();
    }
}

class CookChickenChopCommand implements Command {
    private Chef chef;

    public CookChickenChopCommand(Chef chef) {
        this.chef = chef;
    }

    @Override
    public void execute() {
        chef.cookChickenChop();
    }
}

class CookDessertCommand implements Command {
    private Chef chef;

    public CookDessertCommand(Chef chef) {
        this.chef = chef;
    }

    @Override
    public void execute() {
        chef.cookDessert();
    }
}

class Chef{
    void cookSteak(){
        System.out.println("Cooking steak");
    }

    void cookChickenChop(){
        System.out.println("Cooking chicken chop");
    }

    void cookDessert(){
        System.out.println("Cooking dessert");
    }
}

class Waiter{
    List<Command> list = new ArrayList<>();

    void addCommand(Command command){
        list.add(command);
    }

    void executeCommand(){
        for(Command cmd : list){
            cmd.execute();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Chef chef = new Chef();
        Waiter waiter = new Waiter();
        waiter.addCommand(new CookSteakCommand(chef));
        waiter.addCommand(new CookChickenChopCommand(chef));
        waiter.addCommand(new CookDessertCommand(chef));

        waiter.executeCommand();
    }
}
