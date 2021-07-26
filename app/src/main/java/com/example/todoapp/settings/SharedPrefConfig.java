package com.example.todoapp.settings;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefConfig {

    private SharedPreferences sharedPreferences;
    private Context context;
    private static final String SHARED_PREF_NAME ="com.example.todoapp.settings.SHARED_PREF";
    private static final String LOGIN_STATUS ="com.example.todoapp.setting.login";

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

}
