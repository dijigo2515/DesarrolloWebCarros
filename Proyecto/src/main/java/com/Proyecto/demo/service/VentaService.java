/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Proyecto.demo.service;

import com.Proyecto.demo.entity.Venta;
import com.Proyecto.demo.repository.VentaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Daniel Felipe
 */
@Service
public class VentaService implements IVentaService{
    
    @Autowired      //dependencias
    private VentaRepository ventaRepository;

    @Override
    public List<Venta> getAllVenta() {
      return (List<Venta>)ventaRepository.findAll();  //Devuelve toda la lista de verduras
    }

    @Override
    public Venta getVentaById(long id) {
       return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public void saveVenta(Venta venta) {
       ventaRepository.save(venta);
    }

    @Override
    public void delete(long id) {
       ventaRepository.deleteById(id);
    }
}
