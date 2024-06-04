package org.example.lesson35.model;

/**
 * Class describing the user.
 */
public class User {
    private int id;
    private String email;
    private String login;

    public User() {

    }

    public User(int id, String email, String login) {
        this.id = id;
        this.email = email;
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
