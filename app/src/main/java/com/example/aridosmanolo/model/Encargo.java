package com.example.aridosmanolo.model;

public class Encargo {
    String Fecha,Gasto,Material,Cantidad,Proveedor;

    public Encargo(){}

    public Encargo(String fecha, String gasto, String material, String cantidad, String proveedor) {
        Fecha = fecha;
        Gasto = gasto;
        Material = material;
        Cantidad = cantidad;
        Proveedor = proveedor;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getGasto() {
        return Gasto;
    }

    public void setGasto(String gasto) {
        Gasto = gasto;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String material) {
        Material = material;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String cantidad) {
        Cantidad = cantidad;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String proveedor) {
        Proveedor = proveedor;
    }
}
