package com.bancoagricola.certificacion.omnicanalidadpersonas.web.models;

public class ProductosDisponibles {

    private String producto;
    private String telefono;
    private String pais;

    public String getProducto() { return producto; }
    public void setProducto(String producto) { this.producto = producto; }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
}
