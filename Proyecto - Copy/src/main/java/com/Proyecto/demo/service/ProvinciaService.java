/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.demo.service;

import com.Proyecto.demo.entity.Provincia;
import com.Proyecto.demo.repository.ProvinciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diana Jiménez
 */
@Service
public class ProvinciaService implements IProvinciaService {
    
    @Autowired
    private ProvinciaRepository provinciaRepository;
    
    @Override
    public List<Provincia> getAll(){
        return (List<Provincia>)provinciaRepository.findAll();
    }
}
