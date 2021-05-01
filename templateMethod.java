import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

interface LoginHandler {
    void login(String email, String passwd);
}

class User {
    private String email;
    private String passwd;

    public User(String email, String passwd) {
        this.email = email;
        this.passwd = passwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}

class Database {
    private List<String> authorizedUserDB = new LinkedList<>();
    private List<User> userDB = new ArrayList<>();

    public void addUser(User user){
        userDB.add(user);
    }

    public void rmUser(User user){
        userDB.remove(user);
    }

    public boolean findUser(User user){
        for(User u: userDB){
            if(u.getEmail().equals(user.getEmail()))
                return true;
        }
        return false;
    }

    public void addAuthorizedUser(String email){
        authorizedUserDB.add(email);
    }

    public void rmAuthorizedUser(String email){
        authorizedUserDB.remove(email);
    }

    public boolean findAuthorizedUser(String email){
        for(String e: authorizedUserDB){
            if(e.equals(email))
                return true;
        }
        return false;
    }
}

abstract class AbstractLoginHandler implements LoginHandler {
    private Database db;

    AbstractLoginHandler(Database db){
        this.db = db;
    }

    abstract boolean validate(String email);
    boolean authenticate(String email, String passwd){
        return db.findUser(new User(email, passwd));
    }
    boolean authorizate(String email){
        return db.findAuthorizedUser(email);
    }

    @Override
    public void login(String email, String passwd){
        if(!validate(email)){
            System.out.println("validation failed!");
            return;
        }

        if(!authenticate(email, passwd)){
            System.out.println("Email or password wrong! Please try again");
            return;
        }

        if(!authorizate(email)){
            System.out.println("You are not authorized");
            return;
        }

        System.out.println("Welcome Back!");
    }
}

class EmailLoginHandler extends AbstractLoginHandler {

    EmailLoginHandler(Database db) {
        super(db);
    }

    @Override
    boolean validate(String email) {
        return email.contains("@");
    }
}

class FacebookLoginHandler extends AbstractLoginHandler {
    FacebookLoginHandler(Database db) {
        super(db);
    }

    @Override
    boolean validate(String email) {
        return email.contains("fb");
    }
}

public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        db.addUser(new User("test@gmail.com", "123456"));
        db.addAuthorizedUser("test@gmail.com");
        db.addUser(new User("test@fb.com", "123"));
        db.addAuthorizedUser("test@fb.com");

        LoginHandler loginHandler = new FacebookLoginHandler(db);
        loginHandler.login("test@fb.com", "123");
    }
}
