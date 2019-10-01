package ru.geekbrains.server.mvc;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.execute();
    }
}

class User {
    String name = "Max";
    String password = "*******";
    int age =  17;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface ModelUser {
    User getUser();
}

class DBUser implements ModelUser{
    @Override
    public User getUser() {
        return new User();
    }
}

class FileUser implements ModelUser {
    @Override
    public User getUser() {
        return new User();
    }
}

interface View {
    void showUser(User user);
}

class ConsoleView implements View {
    @Override
    public void  showUser(User user) {
        System.out.println("User name: " + user.getName() + ";" + " age: " + user.getAge() + ";" + " password: " + user.getPassword());
    }
}

class HtmlView implements View {
    @Override
    public void  showUser(User user) {
        System.out.println("<html><body>User name: " + user.getName() + ";" + " age: " + user.getAge() + ";" + " password: " + user.getPassword() + "</body></html>");
    }
}

class Controller {
    ModelUser modelUser = new DBUser();
    View view = new ConsoleView();
//     View view = new HtmlView();
//    ModelUser modelUser = new FileUser();
    void execute() {
        User user = modelUser.getUser();
        view.showUser(user);
    }
}
