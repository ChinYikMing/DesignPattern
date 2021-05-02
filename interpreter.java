import java.util.ArrayList;
import java.util.List;

/* 解譯器以外的一些全域資訊, 可以當作是要解譯的句子, 可以先稍微整理再交給interpret方法去解譯 */
class Context {
    private String info1;
    private String info2;

    public String getInfo1() {
        return info1;
    }

    public void setInfo1(String info1) {
        this.info1 = info1;
    }

    public String getInfo2() {
        return info2;
    }

    public void setInfo2(String info2) {
        this.info2 = info2;
    }
}

interface AbstractExpression {
    void interpret(Context context);
}

class TerminalExpression implements AbstractExpression {

    @Override
    public void interpret(Context context) {
        System.out.println("Terminal expression interpreter");
    }
}

class NonTerminalExpression implements AbstractExpression {

    @Override
    public void interpret(Context context) {
        System.out.println("Non-terminal expression interpreter");
    }
}

public class Main {
    public static void main(String[] args){
        Context context = new Context();
        List<AbstractExpression> list = new ArrayList<>();
        list.add(new TerminalExpression());
        list.add(new TerminalExpression());
        list.add(new TerminalExpression());
        list.add(new NonTerminalExpression());
        list.add(new NonTerminalExpression());

        for(AbstractExpression expr : list){
            expr.interpret(context);
        }
    }
}
