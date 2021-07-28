package com.example.todoapp.settings;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefConfig {

    private SharedPreferences sharedPreferences;
    private Context context;
    private static final String SHARED_PREF_NAME ="com.example.todoapp.settings.SHARED_PREF";
    private static final String LOGIN_STATUS ="com.example.todoapp.setting.login";
    private static final String USER_NAME ="com.example.todoapp.setting.USER.NAME";
    private static final String USER_EMAIL ="com.example.todoapp.setting.USER.EMAIL";
    private static final String USER_NUMBER ="com.example.todoapp.setting.USER.NUMBER";
    private static final String USER_PASSWORD ="com.example.todoapp.setting.USER.PASSWORD";


    public SharedPrefConfig(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public void setLoggingInStatus(boolean status){
         SharedPreferences.Editor editor = sharedPreferences.edit();
         editor.putBoolean(LOGIN_STATUS, status);
         editor.apply();
    }
    public boolean isLoggedIn(){
       // Boolean login_status = sharedPreferences.getBoolean(LOGIN_STATUS, false);
       // return login_status;
        return sharedPreferences.getBoolean(LOGIN_STATUS, false);
    }

    public void setUserInfo(String name, String email, String number, String password){

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_NAME, name);
        editor.putString(USER_EMAIL, email);
        editor.putString(USER_NUMBER, number);
        editor.putString(USER_PASSWORD, password);

        editor.apply();

    }
}
