package com.example.test_code_api;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.test_code_api.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private TextView mTextViewResult;
    private RequestQueue mQueue ;



    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTextViewResult = findViewById((R.id.text_view_result));
        Button buttonParse = findViewById(R.id.button_parse);

        mQueue = Volley.newRequestQueue(this);

        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonParse();


            }
        });
    }

    private void jsonParse() {
        String url = "https://api.themoviedb.org/3/trending/all/day?api_key=94919f610cee6635900db1b211be75e7" ;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray =response.getJSONArray("results");

                    for(int i = 0 ; i<3;i++) { /* ajouter jsonArray.length() pour la taille totale du dictionnaire */
                        JSONObject results = jsonArray.getJSONObject(i);

                        String title = results.getString("title");
                        int id = results.getInt("id");
                        String overview = results.getString("overview");
                        String image = results.getString("poster_path");
                        mTextViewResult.append(title + ", " + String.valueOf(id) + ", " + overview + ",  "+ image + "\n\n\n");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                /* JsonObjectRequest va permettre d'avoir une réponse lors de la requete */


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
           /* lorsque qu'on  va avoir une erreur lors de la requete */
            }
        });

        mQueue.add(request);
    }

}