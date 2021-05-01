import java.util.ArrayList;
import java.util.List;

interface Aggregate {
    Iterator createIterator();
}

class ConcreteAggregate implements Aggregate {
    private List<Object> list = new ArrayList<>();
    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }

    public void add(Object obj){
        this.list.add(obj);
    }

    public void remove(Object obj){
        this.list.remove(obj);
    }

    public int size(){
        return this.list.size();
    }

    public Object get(int idx){
        return this.list.get(idx);
    }
}

interface Iterator {
    Object first();
    Object next();
    boolean isDone();
    Object currentItem();
}

class ConcreteIterator implements Iterator {
    private ConcreteAggregate a;
    private int idx = 0;
    public ConcreteIterator(ConcreteAggregate a) {
        this.a = a;
    }

    @Override
    public Object first() {
        return a.get(0);
    }

    @Override
    public Object next() {
        return a.get(idx++);
    }

    @Override
    public boolean isDone() {
        return idx >= a.size();
    }

    @Override
    public Object currentItem() {
        return a.get(idx);
    }
}

public class Main {
    public static void main(String[] args){
        ConcreteAggregate a = new ConcreteAggregate();

        a.add("test");
        a.add(2);
        a.add(true);
        a.add("test2");
        a.add("DD");

        Iterator iterator = a.createIterator();
        while(!iterator.isDone()){
            System.out.println(iterator.currentItem());
            iterator.next();
        }
    }
}

