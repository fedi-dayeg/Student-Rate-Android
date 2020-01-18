package com.example.studentrate.Model;

public class Class {
    private String _id;
    private String nom;
    private String  annee;

    public Class(){}

    public Class(String _id, String nom, String annee) {
        this._id = _id;
        this.nom = nom;
        this.annee = annee;
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

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }
}
