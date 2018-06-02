package com.example.hmanr.grades.AsyncTasks;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.hmanr.grades.AlertDialogs.AlertDialogManager;
import com.example.hmanr.grades.Classes.Alumno;
import com.example.hmanr.grades.MenuCiclos;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class LoginAsync extends AsyncTask<String,String,String> {
    Context context;
    String usuario,contra;
    Alumno alumno;
    String url="";
    String response;
    AlertDialogManager alert=new AlertDialogManager();
    SessionManager session;
    ArrayList<Alumno> aLumnos=new ArrayList<>();

    public LoginAsync(Context context,String usuario,String contra) {
        this.usuario=usuario;
        this.contra=contra;
        this.context=context;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            response=insertarUsuario(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String result){
        if(response=="") {
            alert.showAlertDialog(context,"Login Failed","Username/Password is incorrect", false);
        }
        else {
            Intent i=new Intent(context, MenuCiclos.class);
            try {
                alumno=llenarAlumno(response);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            session=new SessionManager(context);
            session.createLoginSession(alumno.getIdAlumno(),alumno.getIdUsuario(),alumno.getClaveUsuario());
            context.startActivity(i);
        }

    }

    public String insertarUsuario(String url)throws MalformedURLException {
        URL uri = new URL(url);
        String linea = "";
        StringBuilder result = null;
        int respuesta = 0;
        String exit = "";
        try {
            HttpURLConnection httpCon = (HttpURLConnection) uri.openConnection();
            httpCon.setReadTimeout(20000);
            httpCon.setConnectTimeout(20000);
            httpCon.setDoInput(true);
            httpCon.setDoOutput(true);
            respuesta = httpCon.getResponseCode();
            result = new StringBuilder();
            if (respuesta == HttpURLConnection.HTTP_OK) {
                //Log.d(TAG, "getInfoWeb: Funciona");
                InputStream in = new BufferedInputStream(httpCon.getInputStream());
                BufferedReader read = new BufferedReader(new InputStreamReader(in));
                while ((linea = read.readLine()) != null) {
                    result.append(linea);
                }
                exit = result.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return exit;
    }

    public Alumno llenarAlumno(String jsonCad) throws JSONException {
        JSONArray jsonArr=new JSONArray(jsonCad);
        for (int i=0;i<jsonArr.length();i++){
            aLumnos.add(new Alumno(jsonArr.getJSONObject(i).getString("idOferta"),
                        jsonArr.getJSONObject(i).getString("usuario"),
                        jsonArr.getJSONObject(i).getString("contrasenia")));
        }
        return aLumnos.get(0);
    }
}
