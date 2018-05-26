package com.example.hmanr.grades.Classes;

public class Nota {
    int id_Nota;
    String nombreActividad, nombreMateria;
    Double nota;

    public int getId_Nota() {
        return id_Nota;
    }

    public void setId_Nota(int id_Nota) {
        this.id_Nota = id_Nota;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Nota(int id_Nota, String nombreActividad, String nombreMateria, Double nota) {
        this.id_Nota = id_Nota;
        this.nombreActividad = nombreActividad;
        this.nombreMateria = nombreMateria;
        this.nota = nota;
    }
}
