package com.pookraidee.panupongthongsri.pookraidee;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {
    SharedPreferences sharedPreferences;

    public SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "LOGIN";
    private static final String LOGIN = "IS_LOGIN";
    public static final String NAME = "NAME";

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);

    }

    public void CreateSession (String username){
        editor.putBoolean(LOGIN,false);
        editor.putString(NAME,username);
        editor.apply();

    }

    public boolean isLoggin(){

        return sharedPreferences.getBoolean(LOGIN,false);
    }

    public void Checklogin(){

        if (!this.isLoggin()){
            Intent i = new Intent(context,Login.class);
            context.startActivity(i);
            ((Home2)context).finish();
        }

    }


    public HashMap<String,String>getUserDetail(){

        HashMap<String,String> userD = new HashMap<>();
        userD.put(NAME,sharedPreferences.getString(NAME,null));
        return userD;

    }

    public void Ulogout(){
        editor.clear();
        editor.commit();
        Intent i = new Intent(context,Login.class);
        context.startActivity(i);
        ((Home2)context).finish();

    }

}
