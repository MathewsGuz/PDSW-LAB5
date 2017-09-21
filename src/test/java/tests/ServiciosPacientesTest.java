/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;



import edu.eci.pdsw.samples.entities.Consulta;

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
    ServiciosPacientes servicepacientes;
    Eps eps7;
    Paciente mateo;
    Consulta consulta;
    
    Eps nuevaEps;
    Paciente paciente1;
            
    
    public ServiciosPacientesTest() {

        
        this.nuevaEps = new Eps("nuevaEps","123732345");
        this.paciente1 = new Paciente(10, "cc", "Paciente1", new Date(803109600000l),nuevaEps);

    }
    
    @Before
    public void setUp() {
        servicepacientes = ServiciosHistorialPacientesFactory.getInstance().getServiciosPaciente();
    }
//    EQ1
//    Descripcion :Consultara todos los pacientes registrados 
//    Resultado: una lista de pacientes
    
    @Test
    public void pruebaRegistroDeConsulta() throws ExcepcionServiciosPacientes{
        eps7 = new Eps("famisanar", "01234567890-2");
        mateo = new Paciente(10142,"CC", "Julian Diaz", java.sql.Date.valueOf("1956-05-01"), eps7);
        consulta= new Consulta(java.sql.Date.valueOf("2000-02-09"), "Dolor de oido", 322);
        servicepacientes.registrarNuevoPaciente(mateo);
        System.out.println(servicepacientes.consultarPacientes());
        servicepacientes.agregarConsultaPaciente(0, "CC", consulta);
        assertEquals(servicepacientes.obtenerConsultasEps("famisanar").get(0),consulta);  
    }
    
    
    @Test
    public void RegistroPacientesTestCE1(){
        try{
            servicepacientes.registrarNuevoPaciente(paciente1);
            assertTrue(servicepacientes.consultarPaciente(0, "cc").equals(paciente1));
        }catch(ExcepcionServiciosPacientes e){
            fail("Se ha producido una excepción:" + e.getMessage());
        }
    }
    
}
