/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.demo.service;

import com.Proyecto.demo.entity.Cotizacion;
import java.util.List;

/**
 *
 * @author Diana Jiménez
 */
public interface ICotizacionService {
    public List<Cotizacion> getCotizaciones();  
    public int saveCotizacion(Cotizacion cotizacion);
    public void delete(long id);
}
