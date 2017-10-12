/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.impl.mappers;

/**
 *
 * @author Guzman
 */
public interface EPSDAO {
    public void loadAll();
    public void load();
    public void loadByID();
    public void save();
    public void update();
}
