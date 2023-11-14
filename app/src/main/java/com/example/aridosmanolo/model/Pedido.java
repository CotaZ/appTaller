package com.example.aridosmanolo.model;

public class Pedido {

    String Cliente, Fecha, Descripcion, Direccion;

    public Pedido(){}

    public Pedido(String cliente, String fecha, String descripcion, String direccion) {
        this.Cliente = cliente;
        this.Fecha = fecha;
        this.Descripcion = descripcion;
        this.Direccion = direccion;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }
}
