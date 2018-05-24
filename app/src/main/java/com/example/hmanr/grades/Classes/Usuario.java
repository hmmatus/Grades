package com.example.hmanr.grades.Classes;

public class Usuario {
  private int idUsuario;
  private String usuario;
  private String contra;

    //Constructor
    public Usuario(int idUsuario, String usuario, String contra) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.contra = contra;
    }

    //Constructor vacio
    public Usuario() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
}


