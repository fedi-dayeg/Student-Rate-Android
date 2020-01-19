package com.example.studentrate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.studentrate.Model.Etudiant;
import com.example.studentrate.Volley.SharedPrefManager;
import com.example.studentrate.Volley.URL;
import com.example.studentrate.Volley.VolleySingleton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button bt_login;
    TextInputLayout textInputLayoutUsername, textInputLayoutPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);
        bt_login = findViewById(R.id.btn_login);
        textInputLayoutUsername = findViewById(R.id.layoutUsrname);
        textInputLayoutPassword = findViewById(R.id.layoutPassword);

        Login();

    }

    private void Login() {
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().trim().isEmpty()) {
                    Snackbar snackbar = Snackbar.make(view, "Please fill out these fields", Snackbar.LENGTH_SHORT);
                    View snackbarView = snackbar.getView();
                    snackbarView.setBackgroundColor(getResources().getColor(R.color.Red));
                    snackbar.show();
                    textInputLayoutUsername.setError("Username should not be empty");
                    textInputLayoutPassword.setError("Password should not be empty");
                }
                if (password.getText().toString().trim().isEmpty()) {
                    Snackbar snackbar = Snackbar.make(view, "Please fill out these fields", Snackbar.LENGTH_SHORT);
                    View snackbarView = snackbar.getView();
                    snackbarView.setBackgroundColor(getResources().getColor(R.color.Red));
                    snackbar.show();
                    textInputLayoutPassword.setError("Password should not be empty");
                }else {
                    etudiantLogin();
                }
            }
        });

    }

    private void etudiantLogin() {
        //first getting the value
        final String usernameVolley = username.getText().toString();
        final String passwordVolley = password.getText().toString();
        //if every thing is good
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL.URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("VOLLEY", response);
                        System.out.println("the responce is :" + response);
                        try {
                            //convert response to jsonObject
                            JSONObject object = new JSONObject(response);
                            System.out.println("the jasoObject is : " + object);
                            boolean reponse = object.getBoolean("success");

                            if (reponse == true) {
                                System.out.println(reponse);
                                System.out.println("objet json apres if is :" + object);
                                Toast.makeText(getApplicationContext(), "Student Found", Toast.LENGTH_SHORT).show();
                                JSONObject etudiantJson = object.getJSONObject("etudiants");
                                System.out.println("etudiant json is " + etudiantJson);
                                Etudiant etudiant = new Etudiant(
                                        etudiantJson.getString("_id"),
                                        etudiantJson.getString("nom"),
                                        etudiantJson.getString("prenom"),
                                        etudiantJson.getString("email"),
                                        etudiantJson.getString("numTel"),
                                        etudiantJson.getString("numInscription"),
                                        etudiantJson.getString("cin"));
                                System.out.println("etudiant ID is: "+etudiant.get_id());
                                SharedPrefManager.getInstance(getApplicationContext()).etudiantLogin(etudiant);
                                System.out.println(etudiant.get_id());
                            } else {
                                Toast.makeText(getApplicationContext(), "NOT FOUND", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String,String> getParams() throws AuthFailureError{
                Map<String,String> params =new HashMap<>();
                params.put("nom",usernameVolley);
                params.put("password",passwordVolley);
                System.out.println("the params in map is: "+params);
                return params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }
}
