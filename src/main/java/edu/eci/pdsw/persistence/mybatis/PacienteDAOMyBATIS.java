/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.persistence.impl.mappers.PacienteDAO;
import edu.eci.pdsw.persistence.impl.mappers.PacienteMapper;
import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Eps;
import edu.eci.pdsw.samples.entities.Paciente;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.exceptions.PersistenceException;

/**
 *
 * @author Guzman
 */
public class PacienteDAOMyBATIS implements PacienteDAO {

    
    @Inject
    private PacienteMapper pacienteMapper;
    

    @Override
    public List<Paciente> loadAll() throws PersistenceException{
        try{
           return pacienteMapper.loadPacientes();
        }catch(Exception e){
            throw new PersistenceException("Error al cargar los pacientes",e);
        }
    }
    
    

    @Override
    public void load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public void save(Paciente p) throws PersistenceException{
        try{
            pacienteMapper.insertarPaciente(p);
//            pacienteMapper.updatePaciente(p.getId(), p.getNombre(), p.getEps(), p.getFechaNacimiento());
        }catch(Exception e){
            throw new PersistenceException("No se a podido salvar a el pacientes "+p.getId(),e);
            
        }
    }
    

    @Override
    public Paciente loadByID(int id, String tipoid) throws PersistenceException {
        try{
            return pacienteMapper.loadPacienteById(id, tipoid);
           
        }catch(Exception e){
            throw new PersistenceException("Error al cargar paciente"+id,e);
        }
    }
    

    @Override
    public void update(int id, String tipoid, String nombre, Eps eps, Date fechaNacimiento) throws PersistenceException {
        try{
            Paciente paci=loadByID(id,tipoid);
            for(Consulta i: paci.getConsultas()){
                if(i.getId()==0 && i.getFechayHora()!=null){
                    pacienteMapper.insertConsulta(i, id, tipoid, (int)i.getCosto());
                }
            }
            pacienteMapper.updatePaciente(id, nombre, eps, fechaNacimiento);
            
        }catch(Exception e){
            throw new PersistenceException("Error al actualizar paciente"+id,e);
        }
        
    }


    
}
