abstract class SoftwareImp {
    abstract void app1Run();
    abstract void app2Run();
    abstract void app3Run();
}

class IOS extends SoftwareImp {

    @Override
    void app1Run() {
        System.out.println("App1 run at IOS");
    }

    @Override
    void app2Run() {
        System.out.println("App2 run at IOS");
    }

    @Override
    void app3Run() {
        System.out.println("App3 run at IOS");
    }
}

class Android extends SoftwareImp {

    @Override
    void app1Run() {
        System.out.println("App1 run at Android");
    }

    @Override
    void app2Run() {
        System.out.println("App2 run at Android");
    }

    @Override
    void app3Run() {
        System.out.println("App3 run at Android");
    }
}

abstract class PhoneBrand {
    SoftwareImp softwareImp;
    PhoneBrand(SoftwareImp softwareImp){
        this.softwareImp = softwareImp;
    }

    public abstract void app1Run();
    public abstract void app2Run();
    public abstract void app3Run();
}

class Apple extends PhoneBrand{

    Apple(SoftwareImp softwareImp) {
        super(softwareImp);
    }

    @Override
    public void app1Run() {
        softwareImp.app1Run();
    }

    @Override
    public void app2Run() {
        softwareImp.app2Run();
    }

    @Override
    public void app3Run() {
        softwareImp.app3Run();
    }
}

class Samsung extends PhoneBrand {

    Samsung(SoftwareImp softwareImp) {
        super(softwareImp);
    }

    @Override
    public void app1Run() {
        softwareImp.app1Run();
    }

    @Override
    public void app2Run() {
        softwareImp.app2Run();
    }

    @Override
    public void app3Run() {
        softwareImp.app3Run();
    }
}

public class Main {
    public static void main(String[] args) {
        SoftwareImp impIOS = new IOS();
        PhoneBrand apple = new Apple(impIOS);
        apple.app1Run();
        apple.app2Run();
        apple.app3Run();

        SoftwareImp impAndroid = new Android();
        PhoneBrand samsung = new Samsung(impAndroid);
        samsung.app1Run();
        samsung.app2Run();
        samsung.app3Run();
    }
}
