package com.example.projectpertanusa;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {

    final SharedPreferences preferences;
    private static final String SHARED_PREF_NAME = "MY_APP_PREF";
    private static final String USER_KEY = "USER_NIK";
    private static final String NAME_KEY = "USER_NAME";
    private static final String IS_LOGGED_IN_KEY = "ISLOGGEDIN";

    SharedPrefManager(Context context) {
        preferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

    }

    public UserModel getUserLogin(){
        return new UserModel(
                preferences.getString(USER_KEY,null),
                preferences.getString(NAME_KEY,null)
        );
    }

    public void setUserLogin(UserModel user, Boolean isLogedIn){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(USER_KEY,user.getUserName());
        editor.putString(USER_KEY,user.getUserNIK());

        editor.putBoolean(IS_LOGGED_IN_KEY,isLogedIn);
        editor.apply();

    }

    public Boolean isUserLoggedIn(){
        return preferences.getBoolean(IS_LOGGED_IN_KEY, false);
    }

    public void userlogout(){
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
    }
}
