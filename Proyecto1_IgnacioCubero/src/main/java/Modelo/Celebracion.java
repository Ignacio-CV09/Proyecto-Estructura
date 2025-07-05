package Modelo;

import java.util.Date;

public class Celebracion {
    private static int contador = 1;

    private int id;
    private Date fecha;
    private String descripcion;
    private String pais;

    public Celebracion(Date fecha, String descripcion, String pais) 
    {
        this.id = contador++;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Fecha: " + fecha + ", Descripción: " + descripcion + ", País: " + pais;
    }
}
