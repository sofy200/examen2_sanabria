package co.edu.poli.examen2_sanabria.tests.integracion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import co.edu.poli.examen2_sanabria.modelo.Asegurado;
import co.edu.poli.examen2_sanabria.modelo.Seguro;
import co.edu.poli.examen2_sanabria.modelo.SeguroDeVida;
import co.edu.poli.examen2_sanabria.servicios.DAOAsegurado;
import co.edu.poli.examen2_sanabria.servicios.DAOSeguro;

public class TestDAOSeguro {

    @Test
    void create_seguro_vida_y_readone() throws Exception {

        DAOAsegurado daoAsegurado = new DAOAsegurado();
        DAOSeguro daoSeguro = new DAOSeguro();

      
        int idAsegurado = 5001;

        
        String numeroSeguro = "SV" + System.currentTimeMillis();

       
        Asegurado asegurado = daoAsegurado.buscarPorId(idAsegurado);
        if (asegurado == null) {
            daoAsegurado.insertar(new Asegurado(idAsegurado, "Asegurado Test"));
            asegurado = daoAsegurado.buscarPorId(idAsegurado);
        }


        SeguroDeVida seguro = new SeguroDeVida(
                numeroSeguro,
                "2026-04-15",
                "ACTIVO",
                asegurado,
                "Beneficiario Test"
        );

        System.out.println("Insertando seguro: " + numeroSeguro);

        boolean insertado = daoSeguro.insertarSeguroVida(seguro);

        System.out.println("Resultado inserción: " + insertado);

        assertTrue(insertado);

    
        Seguro leido = daoSeguro.buscarPorNumero(numeroSeguro);

        assertNotNull(leido);
        assertEquals(numeroSeguro, leido.getNumero());
        assertEquals("ACTIVO", leido.getEstado());
    }
}