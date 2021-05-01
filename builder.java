class Sticker {
    private String color;
    private int width;
    private int height;

    public Sticker() {
    }

    public Sticker(String color, int width, int height) {
        this.color = color;
        this.width = width;
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    void show(){
        System.out.printf("my color: %s, my width: %d, my height: %d\n", color, width, height);
    }
}

interface StickerBuilder {
    void buildColor();
    void buildWidth();
    void buildHeight();
    Sticker getResult();
}

class StickerDirector {
    void construct(StickerBuilder bui){
        bui.buildColor();
        bui.buildWidth();
        bui.buildHeight();
    }
}

class CuteStickerBuilder implements StickerBuilder{
    Sticker sticker = new Sticker();

    @Override
    public void buildColor() {
        sticker.setColor("blue");
    }

    @Override
    public void buildWidth() {
        sticker.setWidth(12);
    }

    @Override
    public void buildHeight() {
        sticker.setHeight(12);
    }

    @Override
    public Sticker getResult() {
        return sticker;
    }
}

class FunnyStickerBuilder implements StickerBuilder {
    Sticker sticker = new Sticker();

    @Override
    public void buildColor() {
        sticker.setColor("orange");
    }

    @Override
    public void buildWidth() {
        sticker.setWidth(87);
    }

    @Override
    public void buildHeight() {
        sticker.setHeight(78);
    }

    @Override
    public Sticker getResult() {
        return sticker;
    }
}

public class Main {
    public static void main(String[] args) {
        StickerDirector di = new StickerDirector();
        StickerBuilder bui1 = new CuteStickerBuilder();
        StickerBuilder bui2 = new FunnyStickerBuilder();

        // build sticker based on builder 1
        di.construct(bui1);
        Sticker sticker1 = bui1.getResult();
        sticker1.show();

        // build sticker based on builder 1
        di.construct(bui2);
        Sticker sticker2 = bui2.getResult();
        sticker2.show();
    }
}
