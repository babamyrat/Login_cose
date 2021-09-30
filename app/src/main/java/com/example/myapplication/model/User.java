package com.example.myapplication.model;

import android.text.TextUtils;

public class User {
    private String username;
    private String password;

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

    public boolean isValidUsername(){
        if (this.username != null && !TextUtils.isEmpty(password)) {
            return true;
        }
        return false;
    }

    public boolean isValidPassword() {

        if (this.password != null && this.password.length() >= 6) {
            return true;
        }

        return false;
    }

    public boolean isValidCredential() {
        if (this.username.equalsIgnoreCase("ex@garpix.com") && this.password.equals("123456")) {
            return true;
        }
        return false;
    }

    public String getWelcomeMessage() {
        return "Welcome\n"+this.getUsername();
    }

}
