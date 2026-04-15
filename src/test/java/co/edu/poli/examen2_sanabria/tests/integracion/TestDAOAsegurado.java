package co.edu.poli.examen2_sanabria.tests.integracion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import co.edu.poli.examen2_sanabria.modelo.Asegurado;
import co.edu.poli.examen2_sanabria.servicios.DAOAsegurado;

public class TestDAOAsegurado {

    @Test
    void create_asegurado_y_readone() throws Exception {
        DAOAsegurado dao = new DAOAsegurado();

        int idPrueba = 8001;
        Asegurado asegurado = new Asegurado(idPrueba, "Test Asegurado");

        boolean insertado = dao.insertar(asegurado);
        assertTrue(insertado);

        Asegurado leido = dao.buscarPorId(idPrueba);

        assertNotNull(leido);
        assertEquals(idPrueba, leido.getId());
        assertEquals("Test Asegurado", leido.getNombre());
    }
}