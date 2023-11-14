package com.example.aridosmanolo.model;

public class Material {

    String Material, Valor, Cantidad;

    public Material(){}

    public Material(String Material, String Valor, String Cantidad) {
        this.Material = Material;
        this.Valor = Valor;
        this.Cantidad = Cantidad;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String Material) {
        Material = Material;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String Valor) {
        Valor = Valor;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String Cantidad) {
        Cantidad = Cantidad;
    }
}
