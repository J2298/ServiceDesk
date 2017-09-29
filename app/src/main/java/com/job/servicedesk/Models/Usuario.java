package com.job.servicedesk.Models;

public class Usuario {

    String usuario;
    String contraseña;
    String nombre;
    String rol;

    public Usuario() {
    }

    public Usuario(String usuario, String contraseña, String nombre, String rol) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}