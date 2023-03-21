package book.tobyspring.user.domain;

public class User {
    String id;
    String name;
    String password;

    // added from chapter2
    public User(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    // added from chapter2
    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
}
