/* 安全代理, e.g.,限制連接Database的client端數量; */ 
/* 這邊也可看成有遠端代理, e.g., database的連線可能是遠端 */
/* 這邊也可成有智慧參考，e.g., proxy在connect的時候先去檢查目前連線數量(檢查這一動作可看作是處理另外一些事情) */

interface Database {
    void connect(Client client);
}

class Client {
    private String name;

    public Client(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class MySQLDB implements Database {
    @Override
    public void connect(Client client) {
        System.out.printf("%s has connected to db!\n", client.getName());
    }
}

class MySQLProxy implements Database {
    private static final int NUM_CLIENT_CONNECT = 3;

    private int num_client_connect = 0;

    private Database db;

    MySQLProxy(Database db){
        this.db = db;
    }

    @Override
    public void connect(Client client) {
        if(num_client_connect < NUM_CLIENT_CONNECT){
            db.connect(client);
            num_client_connect++;
        } else {
            System.out.printf("%s connect db failed!\n", client.getName());
        }
    }
}

/* 虛擬代理，e.g., 加載網頁的時候，圖片的載入速度，虛擬代理會先把網頁的架構顯示，當圖片有需要的時候再載入; 這樣的做法也叫做copy-on-write */
/* 以下例子，當使用proxy的時候，proxy會記得image的reference但沒有真的去load image，而是等真正要顯示圖片的時候才會把委託真正的ImageViewer去load image */

interface ImageViewer {
    void display();
}

class ConcreteImageViewer implements ImageViewer {
    private final String imagePath;

    public ConcreteImageViewer(String imagePath) {
        System.out.printf("load image in path: %s\n", imagePath);
        this.imagePath = imagePath;
    }

    @Override
    public void display() {
        System.out.printf("show image in path: %s\n", imagePath);
    }
}

class ImageViewerProxy implements ImageViewer {
    private final String imagePath;

    public ImageViewerProxy(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public void display() {
        ImageViewer imageViewer = new ConcreteImageViewer(this.imagePath);
        imageViewer.display();
    }
}

public class Main {
    public static void main(String[] args) {
        /*
        限制connect的client端數量，達到安全代理; 如果database的遠端的話，可以看作是遠端代理
         */
//        MySQLProxy proxy = new MySQLProxy(new MySQLDB());
//        proxy.connect(new Client("Ming"));
//        proxy.connect(new Client("Sing Lek"));
//        proxy.connect(new Client("Jason"));
//        proxy.connect(new Client("John"));
//        proxy.connect(new Client("Ting Ye"));

        /*
        proxy只有display的時候才會去load image，達到虛擬代理
         */
//        ImageViewerProxy proxy = new ImageViewerProxy("test");
//        proxy.display();

        /*
        concrete會直接去load image
         */
//        ConcreteImageViewer viewer = new ConcreteImageViewer("test");
//        viewer.display();
    }
}
