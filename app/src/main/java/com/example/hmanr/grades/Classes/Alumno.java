package com.example.hmanr.grades.Classes;

public class Alumno {
    private int idAlumno;
    private String nombre;
    private String fechab;
    private String correo;
    private int idUsuario;

    //Constructor
    public Alumno(int idAlumno, String nombre, String fechab, String correo, int idUsuario) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.fechab = fechab;
        this.correo = correo;
        this.idUsuario = idUsuario;
    }
    //Constructor vacio
    public Alumno() {
    }

    //Setters y Getters
    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechab() {
        return fechab;
    }

    public void setFechab(String fechab) {
        this.fechab = fechab;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
