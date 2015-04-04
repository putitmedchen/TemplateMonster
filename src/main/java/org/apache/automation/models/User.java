package org.apache.automation.models;

/**
 * Created by mika on 19.03.2015.
 */
public class User {

    private String login;
    private String password;

    private static  User user;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public static User generateUser(){
        user = new User();
        user.setLogin("test-user@rocky.devoffice.com");
        user.setPassword("09mn1j1vhi6k0m0ihy79");

        return user;
    }

    public static User generateAnauthorisedUser(){
        user = new User();
        user.setLogin("test-user@rocky.devoffice.com");
        user.setPassword("==");

        return user;
    }

}
