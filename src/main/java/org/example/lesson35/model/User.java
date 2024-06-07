package org.example.lesson35.model;

/**
 * Class describing the user.
 */
public class User {
    private int id;
    private String email;
    private String login;

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

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private int id;
        private String email;
        private String login;

        public UserBuilder() {
        }

        public UserBuilder id(int id) {
            this.id = id;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder login(String login) {
            this.login = login;
            return this;
        }

        public User build() {
            return new User(id, email, login);
        }

        @Override
        public String toString() {
            return "UserBuilder{" +
                    "id=" + id +
                    ", email='" + email + '\'' +
                    ", login='" + login + '\'' +
                    '}';
        }
    }
}
