package com.example.studentrate.Model;

public class Etudiant {
    private String _id;
    private String nom;
    private String prenom;
    private String email;
    private String numTel;
    private String numInscription;
    private String cin;


    public Etudiant() {
    }

    public Etudiant(String _id, String nom, String prenom, String email, String numTel, String numInscription, String cin) {
        this._id = _id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numTel = numTel;
        this.numInscription = numInscription;
        this.cin = cin;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getNumInscription() {
        return numInscription;
    }

    public void setNumInscription(String numInscription) {
        this.numInscription = numInscription;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }
}
