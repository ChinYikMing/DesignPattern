import java.util.ArrayList;
import java.util.List;

interface Visitor {
    void visitConcreteElementA(ConcreteElementA a);
    void visitConcreteElementB(ConcreteElementB b);
}

class ConcreteVisitor1 implements Visitor {

    @Override
    public void visitConcreteElementA(ConcreteElementA a) {
        System.out.println("concrete visitor 1 visit a");
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB b) {
        System.out.println("concrete visitor 1 visit b");
    }
}

class ConcreteVisitor2 implements Visitor {

    @Override
    public void visitConcreteElementA(ConcreteElementA a) {
        System.out.println("concrete visitor 2 visit a");
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB b) {
        System.out.println("concrete visitor 2 visit b");
    }
}

interface Element {
    void accept(Visitor visitor);
}

class ConcreteElementA implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementA(this);
    }

    void operationA(){

    }
}

class ConcreteElementB implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementB(this);
    }

    void operationB(){

    }
}

class ObjectStructure {
    private List<Element> list = new ArrayList<>();

    void add(Element e){
        list.add(e);
    }

    void remove(Element e){
        list.remove(e);
    }

    void accept(Visitor visitor){
        for(Element e : list){
            e.accept(visitor);
        }
    }
}

public class Main {
    public static void main(String[] args){
        ObjectStructure o = new ObjectStructure();
        Element e1 = new ConcreteElementA();
        Element e2 = new ConcreteElementB();

        o.add(e1);
        o.add(e2);

        Visitor v1 = new ConcreteVisitor1();
        Visitor v2 = new ConcreteVisitor2();

        o.accept(v1);
        o.accept(v2);
    }
}
