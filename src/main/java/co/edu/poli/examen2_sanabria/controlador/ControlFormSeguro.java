package co.edu.poli.examen2_sanabria.controlador;

import co.edu.poli.examen2_sanabria.modelo.Asegurado;
import co.edu.poli.examen2_sanabria.modelo.Seguro;
import co.edu.poli.examen2_sanabria.modelo.SeguroDeVida;
import co.edu.poli.examen2_sanabria.modelo.SeguroDeVehiculo;
import co.edu.poli.examen2_sanabria.servicios.DAOAsegurado;
import co.edu.poli.examen2_sanabria.servicios.DAOSeguro;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControlFormSeguro {

    private DAOAsegurado daoAsegurado = new DAOAsegurado();
    private DAOSeguro daoSeguro = new DAOSeguro();

    // ASEGURADO
    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    // SEGURO VIDA
    @FXML
    private TextField txtNumeroVida;

    @FXML
    private TextField txtFechaVida;

    @FXML
    private TextField txtEstadoVida;

    @FXML
    private TextField txtIdAseguradoVida;

    @FXML
    private TextField txtBeneficiario;

    // SEGURO VEHICULO
    @FXML
    private TextField txtNumeroVehiculo;

    @FXML
    private TextField txtFechaVehiculo;

    @FXML
    private TextField txtEstadoVehiculo;

    @FXML
    private TextField txtIdAseguradoVehiculo;

    @FXML
    private TextField txtMarca;

    // CONSULTA
    @FXML
    private TextField txtBuscar;

    @FXML
    private TextArea txtResultado;

    @FXML
    public void guardarAsegurado() {
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            String nombre = txtNombre.getText().trim();

            Asegurado asegurado = new Asegurado(id, nombre);
            boolean res = daoAsegurado.insertar(asegurado);

            if (res) {
                txtResultado.setText("Asegurado guardado correctamente.");
                txtId.clear();
                txtNombre.clear();
            } else {
                txtResultado.setText("No se pudo guardar el asegurado.");
            }

        } catch (Exception e) {
            txtResultado.setText("Error al guardar asegurado: " + e.getMessage());
        }
    }

    @FXML
    public void guardarSeguroVida() {
        try {
            int idAsegurado = Integer.parseInt(txtIdAseguradoVida.getText().trim());
            Asegurado asegurado = daoAsegurado.buscarPorId(idAsegurado);

            if (asegurado == null) {
                txtResultado.setText("No existe un asegurado con ese ID.");
                return;
            }

            SeguroDeVida seguro = new SeguroDeVida(
                    txtNumeroVida.getText().trim(),
                    txtFechaVida.getText().trim(),
                    txtEstadoVida.getText().trim(),
                    asegurado,
                    txtBeneficiario.getText().trim()
            );

            boolean res = daoSeguro.insertarSeguroVida(seguro);

            if (res) {
                txtResultado.setText("Seguro de vida guardado correctamente.");
                txtNumeroVida.clear();
                txtFechaVida.clear();
                txtEstadoVida.clear();
                txtIdAseguradoVida.clear();
                txtBeneficiario.clear();
            } else {
                txtResultado.setText("No se pudo guardar el seguro de vida.");
            }

        } catch (Exception e) {
            txtResultado.setText("Error al guardar seguro de vida: " + e.getMessage());
        }
    }

    @FXML
    public void guardarSeguroVehiculo() {
        try {
            int idAsegurado = Integer.parseInt(txtIdAseguradoVehiculo.getText().trim());
            Asegurado asegurado = daoAsegurado.buscarPorId(idAsegurado);

            if (asegurado == null) {
                txtResultado.setText("No existe un asegurado con ese ID.");
                return;
            }

            SeguroDeVehiculo seguro = new SeguroDeVehiculo(
                    txtNumeroVehiculo.getText().trim(),
                    txtFechaVehiculo.getText().trim(),
                    txtEstadoVehiculo.getText().trim(),
                    asegurado,
                    txtMarca.getText().trim()
            );

            boolean res = daoSeguro.insertarSeguroVehiculo(seguro);

            if (res) {
                txtResultado.setText("Seguro de vehículo guardado correctamente.");
                txtNumeroVehiculo.clear();
                txtFechaVehiculo.clear();
                txtEstadoVehiculo.clear();
                txtIdAseguradoVehiculo.clear();
                txtMarca.clear();
            } else {
                txtResultado.setText("No se pudo guardar el seguro de vehículo.");
            }

        } catch (Exception e) {
            txtResultado.setText("Error al guardar seguro de vehículo: " + e.getMessage());
        }
    }

    @FXML
    public void buscarSeguro() {
        try {
            String numero = txtBuscar.getText().trim();
            Seguro s = daoSeguro.buscarPorNumero(numero);

            if (s != null) {
                String resultado = "Número: " + s.getNumero() + "\n"
                        + "Fecha de expedición: " + s.getFechaExpedicion() + "\n"
                        + "Estado: " + s.getEstado() + "\n"
                        + "Asegurado ID: " + s.getAsegurado().getId() + "\n"
                        + "Asegurado Nombre: " + s.getAsegurado().getNombre();

                if (s instanceof SeguroDeVida) {
                    SeguroDeVida vida = (SeguroDeVida) s;
                    resultado += "\nTipo: Seguro de Vida"
                            + "\nBeneficiario: " + vida.getBeneficiario();
                } else if (s instanceof SeguroDeVehiculo) {
                    SeguroDeVehiculo vehiculo = (SeguroDeVehiculo) s;
                    resultado += "\nTipo: Seguro de Vehículo"
                            + "\nMarca: " + vehiculo.getMarca();
                }

                txtResultado.setText(resultado);
            } else {
                txtResultado.setText("No se encontró ningún seguro con ese número.");
            }

        } catch (Exception e) {
            txtResultado.setText("Error al consultar seguro: " + e.getMessage());
        }
    }
}