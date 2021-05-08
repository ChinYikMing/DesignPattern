import java.util.HashMap;

class WebsiteFactory {
    /* 內部狀態 */
    private final HashMap<String, Website> websiteCategory = new HashMap<>();

    public Website getWebsiteCategory(String key){
        if(!websiteCategory.containsKey(key))
            websiteCategory.put(key, new ConcreteWebsite(key));
        return websiteCategory.get(key);
    }

    public int getWebsiteCategoryCount(){
        return websiteCategory.size();
    }
}

interface Website {
    void run(User user);
}

class ConcreteWebsite implements Website{
    private String name;

    public ConcreteWebsite(String name) {
        this.name = name;
    }

    @Override
    public void run(User user) {
        System.out.printf("This website is %s which run by %s(id: %d)\n", this.name, user.getName(), user.getId());
    }
}

/* 外部狀態（用來區分內部狀態）*/
class User {
    private String name;
    private int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

public class Main {
    public static void main(String[] args){
        WebsiteFactory websiteFactory = new WebsiteFactory();

        Website website1 = websiteFactory.getWebsiteCategory("產品展示");
        website1.run(new User("Yik Ming", 1));
        Website website2 = websiteFactory.getWebsiteCategory("產品展示");
        website2.run(new User("Sing Lek", 2));
        Website website3 = websiteFactory.getWebsiteCategory("產品展示");
        website3.run(new User("Jason Lee", 3));

        Website website4 = websiteFactory.getWebsiteCategory("部落格");
        website4.run(new User("Ting Ye", 4));
        Website website5 = websiteFactory.getWebsiteCategory("部落格");
        website5.run(new User("Rui Quan", 5));

        /* 即使有5個網站，但他們有些屬於同一個類型，所以Website物件（Flyweight物件）使同一類型的網站共享，所以數量不是5而是2 */
        System.out.printf("website's category count: %d\n", websiteFactory.getWebsiteCategoryCount());
    }
}
