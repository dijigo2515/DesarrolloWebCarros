/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Proyecto.demo.service;

import com.Proyecto.demo.entity.Venta;
import java.util.List;

/**
 *
 * @author Daniel Felipe
 */
public interface IVentaService {
    public List<Venta> getAllVenta();  //Lista de objetos de tipo verdura
    public Venta getVentaById (long id);
    public void saveVenta(Venta venta);  //Nueva fila en la tabla
    public void delete (long id);    //Eliminar fila dado un id
}
