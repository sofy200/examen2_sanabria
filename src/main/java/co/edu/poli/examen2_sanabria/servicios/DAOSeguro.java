package co.edu.poli.examen2_sanabria.servicios;

import co.edu.poli.examen2_sanabria.modelo.Asegurado;
import co.edu.poli.examen2_sanabria.modelo.Seguro;
import co.edu.poli.examen2_sanabria.modelo.SeguroDeVida;
import co.edu.poli.examen2_sanabria.modelo.SeguroDeVehiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOSeguro {

    private Connection con;

    public DAOSeguro() {
        con = ConexionBD.getInstancia().getConexion();
    }

    public boolean insertarSeguroVida(SeguroDeVida s) {
        try {
            String sql = "INSERT INTO seguro (numero, fecha_expedicion, estado, asegurado_id, tipo_seguro, beneficiario, marca) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, s.getNumero());
            ps.setString(2, s.getFechaExpedicion());
            ps.setString(3, s.getEstado());
            ps.setInt(4, s.getAsegurado().getId());
            ps.setString(5, "VIDA");
            ps.setString(6, s.getBeneficiario());
            ps.setString(7, null);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error insertar seguro vida: " + e.getMessage());
            return false;
        }
    }

    public boolean insertarSeguroVehiculo(SeguroDeVehiculo s) {
        try {
            String sql = "INSERT INTO seguro (numero, fecha_expedicion, estado, asegurado_id, tipo_seguro, beneficiario, marca) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, s.getNumero());
            ps.setString(2, s.getFechaExpedicion());
            ps.setString(3, s.getEstado());
            ps.setInt(4, s.getAsegurado().getId());
            ps.setString(5, "VEHICULO");
            ps.setString(6, null);
            ps.setString(7, s.getMarca());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error insertar seguro vehiculo: " + e.getMessage());
            return false;
        }
    }

    public Seguro buscarPorNumero(String numero) {
        try {
            String sql = "SELECT * FROM seguro WHERE numero = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, numero);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Asegurado asegurado = new DAOAsegurado().buscarPorId(rs.getInt("asegurado_id"));
                String tipo = rs.getString("tipo_seguro");

                if ("VIDA".equalsIgnoreCase(tipo)) {
                    return new SeguroDeVida(
                            rs.getString("numero"),
                            rs.getString("fecha_expedicion"),
                            rs.getString("estado"),
                            asegurado,
                            rs.getString("beneficiario")
                    );
                } else if ("VEHICULO".equalsIgnoreCase(tipo)) {
                    return new SeguroDeVehiculo(
                            rs.getString("numero"),
                            rs.getString("fecha_expedicion"),
                            rs.getString("estado"),
                            asegurado,
                            rs.getString("marca")
                    );
                }
            }

        } catch (Exception e) {
            System.out.println("Error buscar seguro: " + e.getMessage());
        }
        return null;
    }
}