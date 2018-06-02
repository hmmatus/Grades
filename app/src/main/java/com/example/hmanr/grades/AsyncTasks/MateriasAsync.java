package com.example.hmanr.grades.AsyncTasks;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.hmanr.grades.Adapter.MateriasAdapter;
import com.example.hmanr.grades.Classes.Materia;
import com.example.hmanr.grades.MainMenu;
import com.example.hmanr.grades.R;

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

public class MateriasAsync extends AsyncTask<String,String,String> {
    Context context;
    MateriasAdapter materiasAdapter;
    RecyclerView recyclerView;

    ArrayList<Materia> materias = new ArrayList<>();
    ProgressBar progressBar;
    String url ="http://sales-app-com.stackstaging.com/WebServlet/materias.php";
    String response;


    public MateriasAsync(Context context, RecyclerView recyclerView, MateriasAdapter materiasAdapter){
        this.context=context;
        this.recyclerView=recyclerView;
        this.materiasAdapter=materiasAdapter;
    }

    @Override
    protected String doInBackground(String... voids) {
        //result=getInfoWeb("");
        try {
            response=getInfoWeb(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result){
        if(response=="") {
            Intent intent=new Intent(context,MainMenu.class);
            context.startActivity(intent);
            Toast.makeText(context, "Se produjo un error de conexion., intente de nuevo mas tarde.", Toast.LENGTH_SHORT).show();
            ((Activity)context).finish();
        }
        try {
            setMateriaShop(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    //Hacer la consulta a la base
    public String getInfoWeb(String url) throws MalformedURLException {
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
    public void setMateriaShop(String jsonCad) throws JSONException {
        JSONArray jsonArr=new JSONArray(jsonCad);
        for (int i=0;i<jsonArr.length();i++){
            materias.add(new Materia(
                    jsonArr.getJSONObject(i).getString("codigo"),
                    jsonArr.getJSONObject(i).getString("nombre"),
                    jsonArr.getJSONObject(i).getString("abreviatura"),
                    jsonArr.getJSONObject(i).getString("uv")

            ));
        }
        materiasAdapter = new MateriasAdapter(materias,context, R.layout.recycler_menu_materia);
        recyclerView.setAdapter(materiasAdapter);

    }
    }
