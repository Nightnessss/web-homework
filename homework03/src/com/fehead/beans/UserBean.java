package com.fehead.beans;

/**
 * @author Nightessss 2020/5/8 16:10
 */
public class UserBean {

    private String name;
    private String password;
    private String email;

    public UserBean(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public UserBean() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
