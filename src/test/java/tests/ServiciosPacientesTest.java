/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import edu.eci.pdsw.samples.entities.Eps;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.ServiciosHistorialPacientesFactory;
import edu.eci.pdsw.samples.services.ServiciosPacientes;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Diseño de pruebas metodo registro de pacientes:
 * 
 * Clases de equivalencia:
 *  
 *      CE1: Deberia aceptar un paciente correctamente creado
 *           Resultado esperado: True.
 * 
 *      CE2: No deberia aceptar un paciente nulo.
 *           Resultado esperado: False.
 * 
 */
public class ServiciosPacientesTest {
    
    ServiciosPacientes sp;
    Eps nuevaEps;
    Paciente paciente1;
            
    
    public ServiciosPacientesTest() {
        this.sp = ServiciosHistorialPacientesFactory.getInstance().getServiciosPaciente();
        this.nuevaEps = new Eps("nuevaEps","123732345");
        this.paciente1 = new Paciente(10, "cc", "Paciente1", new Date(803109600000l),nuevaEps);
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void RegistroPacientesTestCE1(){
        try{
            sp.registrarNuevoPaciente(paciente1);
            assertTrue(sp.consultarPaciente(0, "cc").equals(paciente1));
        }catch(ExcepcionServiciosPacientes e){
            fail("Se ha producido una excepción:" + e.getMessage());
        }
    }
    
}
