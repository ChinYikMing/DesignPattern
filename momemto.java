interface Gamer {
    void attack();
}

class Catetaker {
    private Momemto momento;

    public Momemto getMomento() {
        return momento;
    }

    public void setMomento(Momemto momento) {
        this.momento = momento;
    }
}

class Momemto {
    private String state;

    public Momemto(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

abstract class AbstractGamer implements Gamer {
    private String state;

    public AbstractGamer(String state) {
        this.state = state;
    }

    void setMomemto(Momemto momemto){
        this.state = momemto.getState();
    }

    Momemto createMomemto(){
        return new Momemto(this.state);
    }

    public void showState(){
        System.out.printf("State: %s\n", this.state);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

class SwordMan extends AbstractGamer {

    public SwordMan(String state) {
        super(state);
    }

    @Override
    public void attack() {
        System.out.println("受我一刀吧！");
        setState("Game Over");
    }
}

class Wizard extends AbstractGamer {

    public Wizard(String state) {
        super(state);
    }

    @Override
    public void attack() {
        System.out.println("受我一咒吧！");
        setState("Game Over");
    }
}

public class Main {
    public static void main(String[] args){
        AbstractGamer gamer1 = new SwordMan( "Alive");

        Catetaker catetaker = new Catetaker();
        catetaker.setMomento(gamer1.createMomemto());

        System.out.println("進入大魔王關卡");
        gamer1.attack();                              /* 攻擊一下就被大魔王打死了... */
        gamer1.showState();

        System.out.println("重新開始");
        gamer1.setMomemto(catetaker.getMomento());    /* 回复到一開始狀態，再打一次 */
        gamer1.showState();
    }
}
