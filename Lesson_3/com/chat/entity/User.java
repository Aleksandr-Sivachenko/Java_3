package com.chat.entity;

public class User {
    private int id;
    private String nickname;
//    private String email;
//    private String password;

    public User(int id, String nickname) {
        this.id = id;
        this.nickname = nickname;
//        this.email = email;
//        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public String getPassword() {
//        return password;
//    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' + '}';
    }
}
