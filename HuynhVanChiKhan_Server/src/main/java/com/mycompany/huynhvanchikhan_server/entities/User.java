/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.huynhvanchikhan_server.entities;


public class User {
    private int id;
    private String username;
    private String password_hash;
    private int per;
    private String path;

    public User(int id, String username, String password_hash, int per, String path) {
        this.id = id;
        this.username = username;
        this.password_hash = password_hash;
        this.per = per;
        this.path = path;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public int getPer() {
        return per;
    }

    public void setPer(int per) {
        this.per = per;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
 
    @Override
    public String toString(){
        return "User:\n"
                + "-id: " + getId() + "\n"
                + "-username: " + getUsername()+ "\n"
                + "-path: " + getPath()+ "\n"
                + "-per: " + getPer()+ "\n"
                + "-password: " + getPassword_hash()+ "\n";
    }
}
