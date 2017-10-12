/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.impl.mappers;

import edu.eci.pdsw.samples.entities.Eps;
import edu.eci.pdsw.samples.entities.Paciente;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Guzman
 */
public interface PacienteDAO {
    public List<Paciente> loadAll();
    public void load();
    public Paciente loadByID(int id, String tipoid);
    public void save(Paciente p);
    public void update(int id,String nombre,Eps eps, Date fechaNacimiento);
    
}
