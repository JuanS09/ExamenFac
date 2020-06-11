package com.example.examenfac.objetos;

public class Producto {
    private String NombreProd;
    private String Precio;
    private String Presentacion;
    private String Laboratorio;
    private String Cantidad;
    private int Img;

    public Producto() { //Constructor vacio
    }

    public Producto(String nombreProd, String precio, String presentacion, String laboratorio, String cantidad) {
        this.NombreProd=nombreProd;
        this.Precio=precio;
        this.Presentacion=presentacion;
        this.Laboratorio=laboratorio;
        this.Cantidad=cantidad;
    }

    public String getNombreProd() {
        return NombreProd;
    }

    public void setNombreProd(String nombreProd) {
        NombreProd = nombreProd;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public String getPresentacion() {
        return Presentacion;
    }

    public void setPresentacion(String presentacion) {
        Presentacion = presentacion;
    }

    public String getLaboratorio() {
        return Laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        Laboratorio = laboratorio;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String cantidad) {
        Cantidad = cantidad;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }
}
