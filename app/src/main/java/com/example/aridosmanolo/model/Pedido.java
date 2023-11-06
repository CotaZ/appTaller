package com.example.aridosmanolo.model;

public class Pedido {

    String Cliente, fecha, valor, material;

    public Pedido(String cliente, String fecha, String valor, String material) {
        Cliente = cliente;
        this.fecha = fecha;
        this.valor = valor;
        this.material = material;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
