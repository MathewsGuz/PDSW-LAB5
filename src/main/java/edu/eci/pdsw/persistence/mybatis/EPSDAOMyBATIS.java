/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.persistence.impl.mappers.EPSDAO;
import edu.eci.pdsw.persistence.impl.mappers.EpsMapper;

/**
 *
 * @author Guzman
 */
public class EPSDAOMyBATIS implements EPSDAO {
    
    @Inject
    private EpsMapper epsMapper;
    
    @Override
    public void loadAll() {
        epsMapper.loadAllEPS();
    }
    

    @Override
    public void load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadByID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
