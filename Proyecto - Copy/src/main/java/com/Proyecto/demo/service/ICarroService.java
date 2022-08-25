/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.demo.service;

import com.Proyecto.demo.entity.Carro;
import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Diana Jiménez
 */
public interface ICarroService {
    public List<Carro> getAllCarro();           //Lista de objetos de tipo carro 
    public Carro getCarroById (long id);
    public int saveCarro(Carro carro, MultipartFile file) throws IllegalStateException, IOException;         //Nueva fila en la tabla
    public void delete (long id);               //Eliminar fila dado un id        
}
