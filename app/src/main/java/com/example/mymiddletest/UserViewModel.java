package com.example.mymiddletest;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

public class UserViewModel extends AndroidViewModel {
    private String username,password;
    public UserViewModel(@NonNull Application application) {
        super(application);
        loadUserName("lastLogin");
        loadPassword(this.username);
    }

    // TODO: Implement the ViewModel
    public void outLogin() {
        SharedPreferences shp = getApplication().getSharedPreferences("user_data_base", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putString("lastLogin","");
        editor.apply();
    }

    public void loadUserName(String username) {
        SharedPreferences shp = getApplication().getSharedPreferences("user_data_base", Context.MODE_PRIVATE);
        this.username = shp.getString(username, null);
    }

    public void loadPassword(String username) {
        SharedPreferences shp = getApplication().getSharedPreferences("user_data_base", Context.MODE_PRIVATE);
        this.password = shp.getString(username + "password", null);
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