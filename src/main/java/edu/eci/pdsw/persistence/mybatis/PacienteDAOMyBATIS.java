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
import java.sql.Date;

/**
 *
 * @author Guzman
 */
public class PacienteDAOMyBATIS implements PacienteDAO {
    public Eps eps;
    public Date fecha;
    @Inject
    private PacienteMapper pacienteMapper;
    
    @Override
    public void loadByID() {
        pacienteMapper.loadPacienteById(0, "");
    }

    @Override
    public void update() {
        pacienteMapper.updatePaciente(0, "",(Eps) eps, fecha);
    }
    

    @Override
    public void loadAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
