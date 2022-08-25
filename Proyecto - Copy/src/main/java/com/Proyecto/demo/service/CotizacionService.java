/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.demo.service;

import com.Proyecto.demo.entity.Cotizacion;
import com.Proyecto.demo.repository.CotizacionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diana Jiménez
 */
@Service
public class CotizacionService implements ICotizacionService {
    
    @Autowired
    private CotizacionRepository cotizacionRepository;
    
    @Override
    public List<Cotizacion> getCotizaciones(){
        return (List<Cotizacion>)cotizacionRepository.findAll();
    }   
    
    @Override
    public int saveCotizacion(Cotizacion cotizacion) {
        int res = 0;                
        Cotizacion c = cotizacionRepository.save(cotizacion);        
        if(!c.equals(null)){
            res = 1;
        }                                          
        return res;
    }
    
    @Override
    public void delete(long id) {
       cotizacionRepository.deleteById(id);
    }
}
