package com.example.mymiddletest;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MyViewModel extends AndroidViewModel {
    private String username;
    private String password;

    public MyViewModel(@NonNull Application application) {
        super(application);
    }
    public String loadUserName(String username) {
        SharedPreferences shp = getApplication().getSharedPreferences("user_data_base", Context.MODE_PRIVATE);
        return shp.getString(username,null);
    }
    public String loadPassword(String username) {
        SharedPreferences shp = getApplication().getSharedPreferences("user_data_base", Context.MODE_PRIVATE);
        return shp.getString(username+"password",null);
    }

    public String login(String username,String password) {
        this.username = loadUserName(username.trim());
        this.password = loadPassword(username);
        if (this.username == null) {
            return "用户名不存在!";
        }
        if (this.username.equals(username)) {
            System.out.println(this.password+"??"+password);
            if (this.password.equals(password)) {
                return "success";
            }
        }
        return "密码错误!";
    }

    public String register(String username,String password,String confirmPassword) {
        this.username = loadUserName(username);
        if (this.username != null) {
            return "用户名已存在";
        }else {
            if (username.trim() == null || username.trim().equals("")) {
                return "用户名不能为空!";
            }else if(password.trim() == null || password.trim().equals("")) {
                return "密码不能为空";
            }else if (password.trim().equals(confirmPassword.trim())){
                SharedPreferences shp = getApplication().getSharedPreferences("user_data_base",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = shp.edit();
                editor.putString(username,username.trim());
                editor.putString(username+"password",password.trim());
                editor.apply();
            }else {
                return "两次密码不一致,请重新输入!";
            }
        }
        return "success";
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

}







