package kz.java;

public class user {
    private int id;
    private String login;
    private String password;
    private NAME name;

    public user() {
    }

    public user(int id, String login, String password, NAME name) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public NAME getName() {
        return name;
    }

    public void setName(NAME name) {
        this.name = name;
    }

    public enum NAME {
        Sagi, Adam, UNK
    }
}
