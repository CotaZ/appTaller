package com.example.aridosmanolo.model;

public class Encargo {
    String fecha,coste,material, proveedor;

    public Encargo(String fecha, String coste, String material, String proveedor) {
        this.fecha = fecha;
        this.coste = coste;
        this.material = material;
        this.proveedor = proveedor;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCoste() {
        return coste;
    }

    public void setCoste(String coste) {
        this.coste = coste;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
