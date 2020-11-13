package com.example.proyecto;

public class InfoDiario {

    public int id;
    public String emocion;
    public String texto;
    public String fecha;

    public InfoDiario() {
    }

    public InfoDiario(int id, String emocion, String texto, String fecha) {
        this.emocion = emocion;
        this.texto = texto;
        this.fecha = fecha;
        this.id = id;
    }

    public String getEmocion() {
        return emocion;
    }

    public void setEmocion(String emocion) {
        this.emocion = emocion;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
