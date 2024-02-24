package com.example.lab2;

public class Contact {
    private int id;
    private String name, phoneNum;
    private boolean status;

    public Contact(int id, String name, String phoneNum, boolean status) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
