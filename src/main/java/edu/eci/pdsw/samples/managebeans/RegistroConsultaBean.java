/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managebeans;


import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Eps;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.ServiciosHistorialPacientesFactory;
import edu.eci.pdsw.samples.services.ServiciosPacientes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 2106913
 */
@ManagedBean(name = "HistorialPacientes")
@SessionScoped
public class RegistroConsultaBean implements Serializable {
    
    private String nombre;
    private int id;
    private String tipoId;
    private Date fechaNacimiento;
    private String eps;
    private List<String> nombreEps = new ArrayList<String>();
    private Paciente paciente;

    
    
    private Date fechaConsulta;
    private String resumen;
    private long costo;





    private final ServiciosPacientes servicepacientes = ServiciosHistorialPacientesFactory.getInstance().getServiciosPaciente();

    

    public RegistroConsultaBean() {
    }

    public void showMessage(String estado, String mensaje) {
        FacesMessage message;
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, estado, mensaje);
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }
    
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }
    
    public List<String> getNombreEps() throws ExcepcionServiciosPacientes {
        epsRegistradas();
        return nombreEps;
    }

    public void setNombreEps(List<String> nombreEps) {
        this.nombreEps = nombreEps;
    }
    
    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public long getCosto() {
        return costo;
    }

    public void setCosto(long costo) {
        this.costo = costo;
    }
    
    public void epsRegistradas() throws ExcepcionServiciosPacientes{
        for(Eps epss:servicepacientes.obtenerEPSsRegistradas()){
            nombreEps.add(epss.getNombre());
        }

    }
    
    public Eps buscarEps() throws ExcepcionServiciosPacientes{
        Eps variable=null;
        for(Eps i: servicepacientes.obtenerEPSsRegistradas()){
            if(i.getNombre().equals(eps)){
                variable=i;
            }
        }
        return variable;
    }
    
    public void imprimir(){
        System.out.println("hola mundo");
    }
    
    public void registrarPaciente() throws ExcepcionServiciosPacientes{
        servicepacientes.registrarNuevoPaciente(new Paciente(id,tipoId,nombre,fechaNacimiento,buscarEps()));
        paciente = servicepacientes.consultarPaciente(id, tipoId);
    }
    
    public List<Paciente> mostrarPacientes() throws ExcepcionServiciosPacientes{
        return servicepacientes.consultarPacientes();
    }
    
    public void nuevaConsulta() throws ExcepcionServiciosPacientes{
        Consulta consulta = new Consulta(fechaConsulta,resumen,costo);
        servicepacientes.agregarConsultaPaciente(paciente.getId(), paciente.getTipoId(), consulta);
    }

}
