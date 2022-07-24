/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.demo.service;

import com.Proyecto.demo.entity.Marca;
import com.Proyecto.demo.repository.MarcaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diana Jiménez
 */
@Service
public class MarcaService implements IMarcaService {
    
    @Autowired
    private MarcaRepository marcaRepository;
    
    @Override
    public List<Marca> listSucursal(){
        return (List<Marca>)marcaRepository.findAll();}
}
