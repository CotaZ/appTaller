package com.example.aridosmanolo.model;

public class Material {

    String Material, Valor, Cantidad;

    public Material(){}

    public Material(String material, String valor, String cantidad) {
        Material = material;
        Valor = valor;
        Cantidad = cantidad;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String material) {
        Material = material;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        Valor = valor;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String cantidad) {
        Cantidad = cantidad;
    }
}
