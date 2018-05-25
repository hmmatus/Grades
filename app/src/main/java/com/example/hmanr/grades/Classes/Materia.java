package com.example.hmanr.grades.Classes;

public class Materia {
    int idMat;
    String nombreMat, abrevMat,cantUvMat;

    public int getIdMat() {
        return idMat;
    }

    public void setIdMat(int idMat) {
        this.idMat = idMat;
    }

    public String getNombreMat() {
        return nombreMat;
    }

    public void setNombreMat(String nombreMat) {
        this.nombreMat = nombreMat;
    }

    public String getAbrevMat() {
        return abrevMat;
    }

    public void setAbrevMat(String abrevMat) {
        this.abrevMat = abrevMat;
    }

    public String getCantUvMat() {
        return cantUvMat;
    }

    public void setCantUvMat(String cantUvMat) {
        this.cantUvMat = cantUvMat;
    }

    public Materia(int idMat, String nombreMat, String abrevMat, String cantUvMat) {
        this.idMat = idMat;
        this.nombreMat = nombreMat;
        this.abrevMat = abrevMat;
        this.cantUvMat = cantUvMat;
    }
}
