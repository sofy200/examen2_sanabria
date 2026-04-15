package co.edu.poli.examen2_sanabria.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import co.edu.poli.examen2_sanabria.modelo.Asegurado;
import co.edu.poli.examen2_sanabria.servicios.DAOAsegurado;

public class TestDAOAsegurado {

    @Test
    public void testCRUDCompleto() {

        DAOAsegurado dao = new DAOAsegurado();

        // INSERTAR
        Asegurado nuevo = new Asegurado(999, "Test JUnit");
        boolean insertado = dao.insertar(nuevo);
        assertTrue(insertado);

        // BUSCAR
        Asegurado encontrado = dao.buscarPorId(999);
        assertNotNull(encontrado);
        assertEquals("Test JUnit", encontrado.getNombre());

        // ACTUALIZAR
        nuevo.setNombre("Test Actualizado");
        boolean actualizado = dao.actualizar(nuevo);
        assertTrue(actualizado);

        Asegurado actualizadoObj = dao.buscarPorId(999);
        assertEquals("Test Actualizado", actualizadoObj.getNombre());

        // ELIMINAR
        boolean eliminado = dao.eliminar(999);
        assertTrue(eliminado);

        Asegurado eliminadoObj = dao.buscarPorId(999);
        assertNull(eliminadoObj);
    }
}