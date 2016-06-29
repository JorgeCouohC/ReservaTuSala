package com.jjcouoh.reservatusala;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.sromku.simple.fb.Permission;
import com.sromku.simple.fb.SimpleFacebook;
import com.sromku.simple.fb.SimpleFacebookConfiguration;
import com.sromku.simple.fb.entities.Profile;


/**
 * Created by jjcouoh on 20/06/2016.
 */
public class MyappApplication extends Application {

    private static final String APP_PREFERENCES = "APP_PREFENCES";
    private static final String APP_KEY_IS_LOGIN_START = "APP_KEY_IS_LOGIN_START";

    public static final String APP_VALUE_ID = "APP_VALUE_ID";
    public static final String APP_VALUE_NAME = "APP_VALUE_NAME";
    public static final String APP_VALUE_EMAIL = "APP_VALUE_EMAIL";
    public static final String APP_VALUE_PICTURE = "APP_VALUE_PICTURE";
    Permission[] permissions = new Permission[] {
            Permission.EMAIL
    };

    private SharedPreferences preferences;

    public void onCreate(){
        super.onCreate();

        preferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        SimpleFacebookConfiguration configuration = new SimpleFacebookConfiguration.Builder()
                .setAppId(getResources().getString(R.string.facebook_app_id))
                .setNamespace("reservatusala")
                .setPermissions(permissions)
                .build();

        SimpleFacebook.setConfiguration(configuration);
    }

    public void registerLogIn(Profile profile){
        saveValuePreferences(MyappApplication.APP_KEY_IS_LOGIN_START, true);
        saveValuePreferences(MyappApplication.APP_VALUE_ID, profile.getId());
        saveValuePreferences(MyappApplication.APP_VALUE_NAME, profile.getName());
        saveValuePreferences(MyappApplication.APP_VALUE_EMAIL, profile.getEmail());
        saveValuePreferences(MyappApplication.APP_VALUE_PICTURE, profile.getPicture());
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