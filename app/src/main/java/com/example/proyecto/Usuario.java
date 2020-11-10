package com.example.proyecto;

public class Usuario {
    public String correo;
    public String nombre;
    public String nombreusu;
    public String contrasena;

    public Usuario() {
    }

    public Usuario(String correo, String nombre, String nombreusu, String contrasena) {
        this.correo = correo;
        this.nombre = nombre;
        this.nombreusu = nombreusu;
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreusu() {
        return nombreusu;
    }

    public void setNombreusu(String nombreusu) {
        this.nombreusu = nombreusu;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
