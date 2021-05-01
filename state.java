abstract class State {
    abstract void work(Work work);
}

class Work {
    private State mood;                   //現在的工作心情
    int time;                             //現在幾點

    public Work(State mood, int time) {
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
        mood.work(this);
    }
}

class MorningMood extends State {

    @Override
    void work(Work work) {
        if(work.getTime() < 12)
            System.out.printf("時間：%d點，早上工作，一條龍\n", work.getTime());
        else{
            work.setMood(new NoonMood());
            work.moodHandle();
        }
    }
}

class NoonMood extends State {

    @Override
    void work(Work work) {
        if(work.getTime() >= 12 && work.getTime() < 18)
            System.out.printf("時間：%d點，下午工作，一條蟲\n", work.getTime());
        else {
            work.setMood(new NightMood());
            work.moodHandle();
        }
    }
}

class NightMood extends State {
    @Override
    void work(Work work) {
        if(work.getTime() >= 18)
            System.out.printf("時間：%d點，晚上工作，老子才不幹！\n", work.getTime());
    }
}

public class Main {
    public static void main(String[] args) {
        int startWorkingTime = 8;
        Work work = new Work(new MorningMood(), startWorkingTime);
        for(int i = startWorkingTime; i < 24; ++i){
            work.moodHandle();
            work.setTime(work.getTime() + 1);
        }
    }
}
