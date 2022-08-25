/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Proyecto.demo.service;

import com.Proyecto.demo.entity.Lugar;
import com.Proyecto.demo.repository.LugarRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Daniel Felipe
 */
@Service
public class LugarService implements ILugarService {
    
    @Autowired
    private LugarRepository lugarRepository;
    
    @Override
    public List<Lugar> listSucursal(){
        return (List<Lugar>)lugarRepository.findAll();}
}
