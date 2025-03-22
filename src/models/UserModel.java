package models;

import java.util.Stack;

public class UserModel {
    private String cedula;
    private String nombre;
    Stack<CreditoModel> creditos;

    public UserModel() {
    }

    public UserModel(String cedula, String nombre, Stack<CreditoModel> creditos) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public UserModel(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Stack<CreditoModel> getCreditos() {
        return creditos;
    }

    public void setCreditos(Stack<CreditoModel> creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", creditos=" + creditos +
                '}';
    }
}
