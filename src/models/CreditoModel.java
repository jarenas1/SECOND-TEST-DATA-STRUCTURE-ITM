package models;

public class CreditoModel {
    private String tipo;
    private String descripcion;

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

    @Override
    public String toString() {
        return "CreditoModel{" +
                "tipo='" + tipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
