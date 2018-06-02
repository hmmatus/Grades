package com.example.hmanr.grades.AsyncTasks;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.hmanr.grades.Classes.Alumno;
import com.example.hmanr.grades.MainActivity;

public class SessionManager {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "AndroidHivePref";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    private static final String KEY_ID="id";

    private static final String KEY_USER="user";

    private static final String KEY_PASS="pass";

    //Constructor
    public SessionManager(Context context) {
        this.context = context;
    }

    public void createLoginSession(String id,String user,String pass){
        editor.putBoolean(IS_LOGIN,true);
        editor.putString(KEY_ID,id);
        editor.putString(KEY_USER,user);
        editor.putString(KEY_PASS,pass);
        editor.commit();
    }

    public void checkLogin(){
        // Check login status
        if(!this.isLoggedIn()){
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(context, MainActivity.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            context.startActivity(i);
        }

    }

    public Alumno getUserDetails(){
        Alumno alumno=new Alumno();
        alumno.setIdUsuario(pref.getString(KEY_USER,null));
        alumno.setIdAlumno(pref.getString(KEY_ID,null));
        alumno.setClaveUsuario(pref.getString(KEY_PASS,null));
        return alumno;
    }

    private boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }

    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(context,MainActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        context.startActivity(i);
    }
}
