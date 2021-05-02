import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface UserTable {
    void add(String username, int age);
    boolean find(String username);
}

interface Database {
    UserTable createUserTable();
}

class MariaDB implements Database{
    MariaDB(){
        System.out.println("Welcome to using MariaDB database!");
    }
    @Override
    public UserTable createUserTable() {
        return new MariaDBUserTable();
    }
}

class Oracle implements Database{
    Oracle(){
        System.out.println("Welcome to using Oracle database!");
    }
    @Override
    public UserTable createUserTable() {
        return new OracleUserTable();
    }
}

class User {
    User(String name, int age){
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;

    public String getName() {
        return name;
    }
}

class OracleUserTable implements UserTable {
    // using List to implement table in database
    List<User> list = new ArrayList<>();

    @Override
    public void add(String username, int age) {
        list.add(new User(username, age));
    }

    @Override
    public boolean find(String username) {
        for (User u : list) {
            if (u.getName().equals(username))
                return true;
        }
        return false;
    }
}

class MariaDBUserTable implements UserTable {
    // using List to implement table in database
    List<User> list = new ArrayList<>();

    @Override
    public void add(String username, int age) {
        list.add(new User(username, age));
    }

    @Override
    public boolean find(String username) {
        for (User u : list) {
            if (u.getName().equals(username))
                return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args){
//        Database db = new MariaDB();
//      we can simply change MariaDB to Oracle without changing other client code
        Database db = new Oracle();

        UserTable userUserTable =  db.createUserTable();

        userUserTable.add("Yik Ming", 20);
        userUserTable.add("Sing Lek", 20);
        userUserTable.add("Jason Lee", 20);
        userUserTable.add("Ting Ye", 20);

        //input a username and query to database to check whether the user exists or not
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter a username to find:");
        do {
            String username = console.nextLine();

            if(userUserTable.find(username)){
                System.out.printf("%s was found!\n", username);
            } else {
                System.out.printf("%s was not found!\n", username);
            }
            System.out.println("Please enter a username to find:");
        } while(console.hasNextLine());
    }
}
