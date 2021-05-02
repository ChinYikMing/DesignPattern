import java.util.ArrayList;
import java.util.List;

interface Component {
    void operation();
    void add(Component component);
    void remove(Component component);
    void getChild(int depth);
}

abstract class AbstractComposite implements Component {
    private String name;

    public AbstractComposite(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Leaf extends AbstractComposite {

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void operation() {
        System.out.println("Leaf do something");
    }

    @Override
    public void add(Component component) {
        System.out.println("Leaf cannot add child");
    }

    @Override
    public void remove(Component component) {
        System.out.println("Leaf cannot remove child");
    }

    @Override
    public void getChild(int depth) {
        String level = "-".repeat(depth);
        System.out.printf("%s%s\n", level, getName());
    }
}

class Composite extends AbstractComposite {
    private List<Component> list = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void operation() {
        System.out.println("Composite do something");
    }

    @Override
    public void add(Component component) {
        this.list.add(component);
    }

    @Override
    public void remove(Component component) {
        this.list.remove(component);
    }

    @Override
    public void getChild(int depth) {
        String level = "-".repeat(depth);
        System.out.printf("%s%s\n", level, getName());
        for(Component component : this.list){
            component.getChild(depth + 2);
        }
    }
}

public class Main {
    public static void main(String[] args){
        Component root = new Composite("root");
        Component leaf1 = new Leaf("leaf1");
        Component leaf2 = new Leaf("leaf2");
        root.add(leaf1);
        root.add(leaf2);

        Component composite1 = new Composite("composite1");
        Component leaf3 = new Leaf("leaf3");
        Component leaf4 = new Leaf("leaf4");
        Component leaf5 = new Leaf("leaf5");
        composite1.add(leaf3);
        composite1.add(leaf4);
        composite1.add(leaf5);

        root.add(composite1);

        root.getChild(0);
    }
}
