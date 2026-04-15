package co.edu.poli.examen2_sanabria.modelo;

public class SeguroDeVida extends Seguro {

	 private String beneficiario;

	    public SeguroDeVida() {
	        super();
	    }

	    public SeguroDeVida(String numero, String fechaExpedicion, String estado, Asegurado asegurado, String beneficiario) {
	        super(numero, fechaExpedicion, estado, asegurado);
	        this.beneficiario = beneficiario;
	    }

	    public String getBeneficiario() {
	        return beneficiario;
	    }

	    public void setBeneficiario(String beneficiario) {
	        this.beneficiario = beneficiario;
	    }

	    @Override
	    public String toString() {
	        return "SeguroDeVida{numero='" + getNumero() + "', fechaExpedicion='" + getFechaExpedicion() +
	                "', estado='" + getEstado() + "', asegurado=" + getAsegurado() +
	                ", beneficiario='" + beneficiario + "'}";
	    }
	
}
