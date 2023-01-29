package com.example.group_project_ict;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class InfoAdder extends AsyncTask<String,Void,String> {

    Context context;
    AlertDialog alertDialog;
    InfoAdder(Context ctx){
        context = ctx;
    }

    String add_info_url;

    @Override
    protected void onPreExecute() {
        add_info_url = "https://database-ict650-test.000webhostapp.com/add_info.php";
    }

    @Override
    protected String doInBackground(String... params) {
        String personName = params[0];
        String email = params[1];
        String GivenName = params[2];

        StringRequest stringRequest = new StringRequest(Request.Method.POST, add_info_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(context.getApplicationContext(), response.trim(), Toast.LENGTH_LONG).show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context.getApplicationContext(), error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() {
                Map<String,String> params = new HashMap<String, String>();
                params.put("personName",personName);
                params.put("email",email);
                params.put("GivenName",GivenName);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        requestQueue.add(stringRequest);

        return "Success";

    }

}
