/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.demo.controller;

import com.Proyecto.demo.entity.Carro;
import com.Proyecto.demo.service.ICarroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Diana Jiménez
 */
@Controller
public class HomeController {   
    
    @Autowired
    private ICarroService carroService;

    @GetMapping("/Home/index")
    public String index(Model model) { 
        List<Carro> listaCarro = carroService.getAllCarro();        
        model.addAttribute("carros", listaCarro);
        return "home";
    }

}
    

