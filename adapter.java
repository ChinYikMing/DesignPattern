interface Worker {
    void work();
    void play();
    void eat();
}

class DomesticWorker implements Worker {
    private String name;

    public DomesticWorker(String name) {
        this.name = name;
    }

    @Override
    public void work() {
        System.out.printf("%s is Working\n", name);
    }

    @Override
    public void play() {
        System.out.printf("%s is Playing\n", name);
    }

    @Override
    public void eat() {
        System.out.printf("%s is Eating\n", name);
    }
}

class ForeignWorker{
    private String name;

    public ForeignWorker(String name) {
        this.name = name;
    }

    public void 工作() {
        System.out.printf("%s在工作\n", name);
    }

    public void 玩耍() {
        System.out.printf("%s在玩耍\n", name);
    }

    public void 吃飯() {
        System.out.printf("%s在吃飯\n", name);
    }
}

class Translator implements Worker {
    ForeignWorker worker;

    Translator(String name){
        this.worker = new ForeignWorker(name);
    }

    @Override
    public void work() {
        worker.工作();
    }

    @Override
    public void play() {
        worker.玩耍();
    }

    @Override
    public void eat() {
        worker.吃飯();
    }
}

public class Main {
    public static void main(String[] args) {
        Worker worker1 = new DomesticWorker("Jason");
        
        // 由於worker2不是國內人，不知道英語
        // 我們可以藉由adapter的DP來幫worker2加上一個翻譯員Translator(adapter)，worker2則成為ForeignWorker(adaptee)
        Worker worker2 = new Translator("曾益銘");

        worker1.eat();
        worker1.play();
        worker1.work();

        worker2.eat();
        worker2.play();
        worker2.work();
    }
}
