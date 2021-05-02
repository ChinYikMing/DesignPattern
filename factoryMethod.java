interface Worker {
    void work();
}

interface WorkerFactory {
    Worker createWorker();
}

class Worker1Factory implements WorkerFactory {

    @Override
    public Worker createWorker() {
        return new Worker1();
    }
}

class Worker2Factory implements WorkerFactory {

    @Override
    public Worker createWorker() {
        return new Worker2();
    }
}

class Worker1 implements Worker {

    @Override
    public void work() {
        System.out.println("work work work");
    }
}

class Worker2 implements Worker {

    @Override
    public void work() {
        System.out.println("work work work");
    }
}

public class Main {
    public static void main(String[] args){
        WorkerFactory workerFactory = new Worker1Factory(); /* 如果要更換其他工廠的worker，只需要更換這一行的實體類別 */
        Worker worker1 = workerFactory.createWorker();
        Worker worker2 = workerFactory.createWorker();

        worker1.work();
        worker2.work();
    }
}
