/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.demo.repository;

import com.Proyecto.demo.entity.Cotizacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Diana Jiménez
 */
@Repository
public interface CotizacionRepository extends CrudRepository<Cotizacion, Long> { 
}
