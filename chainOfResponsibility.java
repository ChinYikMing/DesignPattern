interface Handler {
    void setNextHandler(Handler nextHandler);
    void handle(int req);
}

class Handler1 implements Handler {
    Handler nextHandler;
    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handle(int req) {
        if(req >= 0 && req < 10)
            System.out.println("I am the first handler");
        else
            nextHandler.handle(req);
    }
}

class Handler2 implements Handler {
    Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handle(int req) {
        if(req >= 10 && req < 20)
            System.out.println("I am second handler");
        else
            nextHandler.handle(req);
    }
}

class Handler3 implements Handler {
    @Override
    public void setNextHandler(Handler nextHandler) {
    }

    @Override
    public void handle(int req) {
        if(req >= 20)
            System.out.println("I am third handler");
        else
            System.out.println("The req cannot be solved");
    }
}

public class Main {
    public static void main(String[] args){
        Handler handler1 = new Handler1();
        Handler handler2 = new Handler2();
        Handler handler3 = new Handler3();
        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);

        int[] req_arr = {25, 35, 1, 5, 15};
        for(int req : req_arr){
            handler1.handle(req);
        }
    }
}
