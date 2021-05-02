class MVFacade {
    private Model model1;
    private Model model2;

    private View view1;
    private View view2;

    public MVFacade(Model model1, Model model2, View view1, View view2) {
        this.model1 = model1;
        this.model2 = model2;
        this.view1 = view1;
        this.view2 = view2;
    }

    /* 各種子系統方法的組合，達成商業需求功能 */
    public void method1(){
        model1.method1();
        view2.method1();
    }

    /* 各種子系統方法的組合，達成商業需求功能 */
    public void method2(){
        model1.method2();
        view1.method1();
        view2.method2();
    }
}

class VCFacade {
    private View view1;
    private View view2;

    private Controller controller1;
    private Controller controller2;

    public VCFacade(View view1, View view2, Controller controller1, Controller controller2) {
        this.view1 = view1;
        this.view2 = view2;
        this.controller1 = controller1;
        this.controller2 = controller2;
    }

    /* 各種子系統方法的組合，達成商業需求功能 */
    public void method1(){
        view1.method1();
        view2.method2();
        controller1.method1();
    }

    /* 各種子系統方法的組合，達成商業需求功能 */
    public void method2(){
        view1.method2();
        controller2.method1();
        controller1.method2();
    }
}

class Model {
    public void method1(){
        System.out.println("model method 1");
    }

    public void method2(){
        System.out.println("model method 2");
    }
}

class View {
    public void method1(){
        System.out.println("view method 1");
    }

    public void method2(){
        System.out.println("view method 2");
    }
}

class Controller {
    public void method1(){
        System.out.println("controller method 1");
    }

    public void method2(){
        System.out.println("controller method 2");
    }
}

public class Main {
    public static void main(String[] args){
        Model model1 = new Model();
        Model model2= new Model();
        View view1 = new View();
        View view2 = new View();
        Controller controller1 = new Controller();
        Controller controller2 = new Controller();

        MVFacade mvFacade = new MVFacade(model1, model2, view1, view2);
        VCFacade vcFacade = new VCFacade(view1, view2, controller1, controller2);

        mvFacade.method1();
        vcFacade.method2();
    }
}
