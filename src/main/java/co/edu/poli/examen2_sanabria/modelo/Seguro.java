package co.edu.poli.examen2_sanabria.modelo;

public class Seguro {

    private String numero;
    private String fechaExpedicion;
    private String estado;
    private Asegurado asegurado;

    public Seguro() {
    }

    public Seguro(String numero, String fechaExpedicion, String estado, Asegurado asegurado) {
        this.numero = numero;
        this.fechaExpedicion = fechaExpedicion;
        this.estado = estado;
        this.asegurado = asegurado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(String fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Asegurado getAsegurado() {
        return asegurado;
    }

    public void setAsegurado(Asegurado asegurado) {
        this.asegurado = asegurado;
    }
}