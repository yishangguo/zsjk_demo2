package com.example.demo.entity;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String phone;
    private int type;
    private String token;
    private String encoderUid;

    public User() {
    }

    public User(Integer id, String username, String password, String phone, int type, String token, String encoderUid) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.type = type;
        this.token = token;
        this.encoderUid = encoderUid;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", type=" + type +
                ", token='" + token + '\'' +
                ", encoderUid='" + encoderUid + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEncoderUid() {
        return encoderUid;
    }

    public void setEncoderUid(String encoderUid) {
        this.encoderUid = encoderUid;
    }
}
