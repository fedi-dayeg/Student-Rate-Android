package com.example.studentrate.Volley;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.studentrate.Model.Class;
import com.example.studentrate.Model.Etudiant;

public class SharedPrefManager {

    private static final String SHARED_PREF_NAME = "volleyregisterlogin";
    private static final String KEY_ID = "keyid";
    private static final String KEY_NOM = "keynom";
    private static final String KEY_PRENOM = "keyprenom";
    private static final String KEY_EMAIL = "keyemail";
    private static final String KEY_NUMTEL = "keynumtel";
    private static final String KEY_NUMINSCRIPTION = "keynuminsciption";
    private static final String KEY_CIN = "keycin";

    private static final String KEY_ID_CLASS = "keyid";
    private static final String KEY_NOM_CLASS = "keynom";
    private static final String KEY_ANNEE_CLASS = "keyannee";


    private static SharedPrefManager mInstance;
    private static Context ctx;

    private SharedPrefManager(Context context) {
        ctx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public void etudiantLogin(Etudiant etudiant) {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_ID, etudiant.get_id());
        editor.putString(KEY_NOM, etudiant.getNom());
        editor.putString(KEY_PRENOM, etudiant.getPrenom());
        editor.putString(KEY_EMAIL, etudiant.getEmail());
        editor.putString(KEY_NUMTEL, etudiant.getNumTel());
        editor.putString(KEY_NUMINSCRIPTION, etudiant.getNumInscription());
        editor.putString(KEY_CIN, etudiant.getCin());
        editor.apply();
    }

    public void ClassLogin(Class classes) {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_ID_CLASS, classes.get_id());
        editor.putString(KEY_NOM_CLASS, classes.getNom());
        editor.putString(KEY_ANNEE_CLASS, classes.getAnnee());
        editor.apply();
    }

    public Etudiant getEtudiant() {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new Etudiant(sharedPreferences.getString(KEY_ID, null),
                sharedPreferences.getString(KEY_NOM,null),
                sharedPreferences.getString(KEY_PRENOM,null),
                sharedPreferences.getString(KEY_EMAIL,null),
                sharedPreferences.getString(KEY_NUMTEL,null),
                sharedPreferences.getString(KEY_NUMINSCRIPTION,null),
                sharedPreferences.getString(KEY_CIN,null)
        );
    }


}
