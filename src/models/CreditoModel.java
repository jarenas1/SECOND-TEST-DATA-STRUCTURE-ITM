package models;

public class CreditoModel {
    private String tipo;
    private String descripcion;
    private int tomados;
    public CreditoModel() {
    }

    public CreditoModel(String tipo, String descripcion) {
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTomados() {
        return tomados;
    }

    public void setTomados(int tomados) {
        this.tomados = tomados;
    }

    @Override
    public String toString() {
        return "CreditoModel{" +
                "tipo='" + tipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
