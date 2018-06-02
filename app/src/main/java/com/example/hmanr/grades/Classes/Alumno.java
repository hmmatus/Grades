package com.example.hmanr.grades.Classes;

public class Alumno {
    private String idAlumno;
    private String nombre;
    private String fechab;
    private String correo;
    private String idUsuario;
    private String claveUsuario;

    //Constructor
    public Alumno(String idAlumno, String nombre, String fechab, String correo, String idUsuario) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.fechab = fechab;
        this.correo = correo;
        this.idUsuario = idUsuario;
    }

    public Alumno(String idAlumno, String idUsuario, String claveUsuario) {
        this.idAlumno = idAlumno;
        this.idUsuario = idUsuario;
        this.claveUsuario = claveUsuario;
    }

    //Constructor vacio
    public Alumno() {
    }

    //Setters y Getters
    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
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

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }
}

