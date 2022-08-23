/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.demo.service;

import com.Proyecto.demo.entity.Carro;
import com.Proyecto.demo.repository.CarroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diana Jiménez
 */
@Service
public class CarroService implements ICarroService{
    
    @Autowired                                //dependencias
    private CarroRepository carroRepository;

    @Override
    public List<Carro> getAllCarro() {
      return (List<Carro>)carroRepository.findAll();             //Devuelve toda la lista de verduras
    }

    @Override
    public Carro getCarroById(long id) {
       return carroRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCarro(Carro carro) {
       carroRepository.save(carro);
    }

    @Override
    public void delete(long id) {
       carroRepository.deleteById(id);
    }
}