/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.persistence.impl.mappers.PacienteDAO;
import edu.eci.pdsw.persistence.impl.mappers.PacienteMapper;
import edu.eci.pdsw.samples.entities.Eps;
import edu.eci.pdsw.samples.entities.Paciente;
import java.sql.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import org.mybatis.guice.transactional.Transactional;

/**
 *
 * @author Guzman
 */
public class PacienteDAOMyBATIS implements PacienteDAO {

    
    @Inject
    private PacienteMapper pacienteMapper;
    
    @Transactional
    @Override
    public List<Paciente> loadAll() {
        try{
           return pacienteMapper.loadPacientes();
        }catch(Exception e){
            throw new PersistenceException("Error al cargar los pacientes",e);
        }
    }
    
    
    @Transactional
    @Override
    public void load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Transactional
    @Override
    public void save(Paciente p) {
        try{
            pacienteMapper.insertarPaciente(p);
            pacienteMapper.updatePaciente(p.getId(), p.getNombre(), p.getEps(), p.getFechaNacimiento());
        }catch(Exception e){
            throw new PersistenceException("No se a podido salvar a el pacientes "+p.getId(),e);
            
        }
    }
    
    @Transactional
    @Override
    public Paciente loadByID(int id, String tipoid) throws PersistenceException {
        try{
            return pacienteMapper.loadPacienteById(0, "");
           
        }catch(Exception e){
            throw new PersistenceException("Error al cargar paciente"+id,e);
        }
    }
    
    @Transactional
    @Override
    public void update(int id, String nombre, Eps eps, Date fechaNacimiento) throws PersistenceException {
        try{
            pacienteMapper.updatePaciente(id, nombre, eps, fechaNacimiento);
        }catch(Exception e){
            throw new PersistenceException("Error al actualizar paciente"+id,e);
        }
        
    }


    
}
