/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.demo.service;

import com.Proyecto.demo.entity.EstadoVehiculo;
import com.Proyecto.demo.repository.EstadoVehiculoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diana Jiménez
 */
@Service
public class EstadoVehiculoService implements IEstadoVehiculoService {
    
    @Autowired
    private EstadoVehiculoRepository estadoVehiculoRepository;
    
    @Override
    public List<EstadoVehiculo> getAll(){
        return (List<EstadoVehiculo>)estadoVehiculoRepository.findAll();
    }
}
