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
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

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
      return (List<Carro>)carroRepository.findAll();             //Devuelve toda la lista de carros
    }   

    @Override
    public Carro getCarroById(long id) {
       return carroRepository.findById(id).orElse(null);
    }

    @Override
    public int saveCarro(Carro carro, MultipartFile file) throws IOException {
        int res = 0;        
        //si no se seleccionó imagen
        if(file.getOriginalFilename().equals("")){
            Carro c = carroRepository.save(carro);     
            if(!c.equals(null)){
                res = 1;
            } 
        }else{
            Carro c = carroRepository.save(carro);
            uploadImageCarro(file);
            if(!c.equals(null)){
                res = 1;
            } 
        }                                       
        return res;
    }

    @Override
    public void delete(long id) {
       carroRepository.deleteById(id);
    }
        
    public void uploadImageCarro(MultipartFile file) throws IllegalStateException, IOException{
        file.transferTo(new File("C:\\Users\\Daniel Felipe\\Documents\\Desarrollo de Aplicaciones Web y Patrones\\Proyecto TodoAutos\\Proyecto - Copy\\src\\main\\resources\\static\\images\\" + file.getOriginalFilename()));
    }
}