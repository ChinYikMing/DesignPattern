interface State {
    void handle(Worker worker);
}

class Worker {
    private State mood;                   //現在的工作心情
    int time;                             //現在幾點

    public Worker(State mood, int time) {
        this.mood = mood;
        this.time = time;
    }

    public State getMood() {
        return mood;
    }

    public void setMood(State mood) {
        this.mood = mood;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    void moodHandle(){
        mood.handle(this);
    }
}

class MorningMood implements State {

    @Override
    public void handle(Worker worker) {
        if(worker.getTime() < 12)
            System.out.printf("時間：%d點，早上工作，一條龍\n", worker.getTime());
        else{
            worker.setMood(new NoonMood());
            worker.moodHandle();
        }
    }
}

class NoonMood implements State {

    @Override
    public void handle(Worker worker) {
        if(worker.getTime() >= 12 && worker.getTime() < 18)
            System.out.printf("時間：%d點，下午工作，一條蟲\n", worker.getTime());
        else {
            worker.setMood(new NightMood());
            worker.moodHandle();
        }
    }
}

class NightMood implements State {

    @Override
    public void handle(Worker worker) {
        if(worker.getTime() >= 18)
            System.out.printf("時間：%d點，晚上工作，老子才不幹！\n", worker.getTime());
    }
}

public class Main {
    public static void main(String[] args) {
        int startWorkeringTime = 8; /* 早上8點上班 */
        Worker worker = new Worker(new MorningMood(), startWorkeringTime);
        for(int i = startWorkeringTime; i < 24; ++i){
            worker.moodHandle();
            worker.setTime(worker.getTime() + 1);
        }
    }
}
