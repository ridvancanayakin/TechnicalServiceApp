package models;

import lombok.Data;

@Data
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
}
