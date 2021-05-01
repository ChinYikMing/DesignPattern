interface Prototype {
    Object clone();
}

class Packet implements Prototype {
    public Packet(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }

    private int src;
    private int dest;

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    private Packet copy(){
        return new Packet(src, dest);
    }

    @Override
    public Object clone() {
        return this.copy();
    }

    void show(){
        System.out.printf("src: %d, dest: %d\n", src, dest);
    }
}

public class Main {
    public static void main(String[] args) {
        Packet packet1 = new Packet(12, 30);
        Packet packet2 = (Packet)packet1.clone();
        Packet packet3 = (Packet)packet1.clone();
        Packet packet4 = (Packet)packet1.clone();
        Packet packet5 = (Packet)packet1.clone();

        packet2.setDest(40);
        packet3.setDest(100);
        packet4.setDest(11);
        packet5.setDest(87);

        packet1.show();
        packet2.show();
        packet3.show();
        packet4.show();
        packet5.show();
    }
}
