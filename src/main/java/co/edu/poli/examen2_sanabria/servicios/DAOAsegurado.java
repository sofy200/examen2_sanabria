package co.edu.poli.examen2_sanabria.servicios;

import co.edu.poli.examen2_sanabria.modelo.Asegurado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOAsegurado implements CRUD<Asegurado, Integer> {

    private Connection con;

    public DAOAsegurado() {
        con = ConexionBD.getInstancia().getConexion();
    }

    @Override
    public boolean insertar(Asegurado a) {
        try {
            String sql = "INSERT INTO asegurado (id, nombre) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, a.getId());
            ps.setString(2, a.getNombre());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error insertar asegurado: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Asegurado buscarPorId(Integer id) {
        try {
            String sql = "SELECT * FROM asegurado WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Asegurado(
                        rs.getInt("id"),
                        rs.getString("nombre")
                );
            }

        } catch (Exception e) {
            System.out.println("Error buscar asegurado: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean actualizar(Asegurado a) {
        try {
            String sql = "UPDATE asegurado SET nombre = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, a.getNombre());
            ps.setInt(2, a.getId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error actualizar asegurado: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(Integer id) {
        try {
            String sql = "DELETE FROM asegurado WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error eliminar asegurado: " + e.getMessage());
            return false;
        }
    }
}