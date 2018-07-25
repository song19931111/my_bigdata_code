package com.nd.s414567.po;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/12
 */
public class User {
    private String username ;
    private String password;
    private Integer userId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUser_id() {
        return userId;
    }

    public void setUser_id(Integer user_id) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userId=" + userId +
                '}';
    }
}
