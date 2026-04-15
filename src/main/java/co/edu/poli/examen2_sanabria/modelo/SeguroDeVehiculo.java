package co.edu.poli.examen2_sanabria.modelo;

public class SeguroDeVehiculo extends Seguro {
	 private String marca;

	    public SeguroDeVehiculo() {
	        super();
	    }

	    public SeguroDeVehiculo(String numero, String fechaExpedicion, String estado, Asegurado asegurado, String marca) {
	        super(numero, fechaExpedicion, estado, asegurado);
	        this.marca = marca;
	    }

	    public String getMarca() {
	        return marca;
	    }

	    public void setMarca(String marca) {
	        this.marca = marca;
	    }

	    @Override
	    public String toString() {
	        return "SeguroDeVehiculo{numero='" + getNumero() + "', fechaExpedicion='" + getFechaExpedicion() +
	                "', estado='" + getEstado() + "', asegurado=" + getAsegurado() +
	                ", marca='" + marca + "'}";
	    }
	
}
