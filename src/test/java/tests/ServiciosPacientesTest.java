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
        eps7 = new Eps("famisanar", "01234567890-2");
        mateo = new Paciente(23456,"CC", "Julian ", java.sql.Date.valueOf("1956-05-01"), eps7);
        this.nuevaEps = new Eps("nuevaEps","123732345");
        this.paciente1 = new Paciente(10, "cc", "Paciente1", new Date(803109600000l),nuevaEps);

    }
    
    @Before
    public void setUp() {
        servicepacientes = ServiciosHistorialPacientesFactory.getInstance().getTestingServiciosPaciente();
    }
//    EQ1
//    Descripcion :Deberia confirmar que un paciente se encuentra registrado
//    Resultado:  True
    
    @Test
    public void pruebaRegistroDeConsulta() throws ExcepcionServiciosPacientes{
        try{
            servicepacientes.registrarNuevoPaciente(mateo);
            consulta= new Consulta(java.sql.Date.valueOf("2000-02-09"), "Dolor de oido", 322);
            Paciente mateo1 = servicepacientes.consultarPaciente(23456,"CC");
            servicepacientes.agregarConsultaPaciente(23456, "CC", consulta);
            mateo = servicepacientes.consultarPaciente(23456,"CC");
            
            System.out.println(mateo.getConsultas().contains(consulta));
            assertTrue(mateo.getConsultas().size()==mateo1.getConsultas().size()+1);
        }catch(ExcepcionServiciosPacientes e){
            fail("Se ha producido una excepción:" + e.getMessage());
            }
       
    }
    
    
    @Test
    public void RegistroPacientesTestCE1(){
        try{
            servicepacientes.registrarNuevoPaciente(paciente1);
            assertTrue(servicepacientes.consultarPaciente(10, "cc").equals(paciente1));
        }catch(ExcepcionServiciosPacientes e){
            fail("Se ha producido una excepción:" + e.getMessage());
        }
    }
    
}
