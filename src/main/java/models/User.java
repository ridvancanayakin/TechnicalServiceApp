package models;

public class User {
    private int uid;
    private String email;
    private String name;


    public User(){}

    public User(int uid, String name, String email) {
        this.uid = uid;
        this.email = email;
        this.name = name;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
