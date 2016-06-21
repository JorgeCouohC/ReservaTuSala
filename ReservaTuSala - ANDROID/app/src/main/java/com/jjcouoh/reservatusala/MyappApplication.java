package com.jjcouoh.reservatusala;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by jjcouoh on 20/06/2016.
 */
public class MyappApplication extends Application {

    private static final String APP_PREFERENCES = "APP_PREFENCES";
    private static final String APP_KEY_IS_LOGIN_START = "APP_KEY_IS_LOGIN_START";

    private SharedPreferences preferences;

    public void onCreate(){
        super.onCreate();

        preferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    public void registerLogIn(){
        saveValuePreferences(MyappApplication.APP_KEY_IS_LOGIN_START, true);
    }

    public void registerLogOut(){
        saveValuePreferences(MyappApplication.APP_KEY_IS_LOGIN_START, false);
    }

    public boolean isLoginStart(){
        return getBooleanRegisterValuePreferences(MyappApplication.APP_KEY_IS_LOGIN_START);
    }

    public void saveValuePreferences(String key, String value){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void saveValuePreferences(String key, int value){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public void saveValuePreferences(String key, Boolean value){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public String getStringRegisterValuePreferences(String key){
        return preferences.getString(key,null);
    }

    public boolean getBooleanRegisterValuePreferences(String key){
        return preferences.getBoolean(key,false);
    }



    public SharedPreferences getPreferences() {
        return preferences;
    }

    public void setPreferences(SharedPreferences preferences) {
        this.preferences = preferences;
    }
}