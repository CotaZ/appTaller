package com.example.aridosmanolo.model;

public class Proveedor {
    String Celular, Email,Empresa,Nombre;
    public Proveedor(){}

    public Proveedor(String Nombre, String Celular, String Email, String Empresa){
        this.Nombre = Nombre;
        this.Celular = Celular;
        this.Email = Email;
        this.Empresa = Empresa;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String celular) {
        Celular = celular;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String empresa) {
        Empresa = empresa;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
