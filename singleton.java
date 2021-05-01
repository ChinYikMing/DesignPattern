class Singleton {
    private static Singleton instance = null;
    private static String instance_attr1 = "";
    private static String instance_attr2 = "";

    public static String getInstance_attr1() {
        return instance_attr1;
    }

    public static void setInstance_attr1(String instance_attr1) {
        Singleton.instance_attr1 = instance_attr1;
    }

    public static String getInstance_attr2() {
        return instance_attr2;
    }

    public static void setInstance_attr2(String instance_attr2) {
        Singleton.instance_attr2 = instance_attr2;
    }

    private Singleton(){
    }

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public void show(){
        System.out.printf("attr1: %s, attr2: %s\n", getInstance_attr1(), getInstance_attr2());
    }
}

public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.show();

        Singleton.setInstance_attr1("apple");
        Singleton.setInstance_attr2("banana");

        singleton.show();
    }
}
