/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.demo.service;

import com.Proyecto.demo.entity.Carro;
import java.util.List;

/**
 *
 * @author Diana Jiménez
 */
public interface ICarroService {
    public List<Carro> getAllCarro();           //Lista de objetos de tipo carro
    public Carro getCarroById (long id);
    public void saveCarro(Carro carro);         //Nueva fila en la tabla
    public void delete (long id);               //Eliminar fila dado un id
}
