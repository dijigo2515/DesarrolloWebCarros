/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.demo.controller;

import com.Proyecto.demo.entity.Carro;
import com.Proyecto.demo.entity.Lugar;
import com.Proyecto.demo.entity.Marca;
import com.Proyecto.demo.service.ICarroService;
import com.Proyecto.demo.service.ILugarService;
import com.Proyecto.demo.service.IMarcaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Diana Jiménez
 */
@Controller
public class CarroController {
    
    @Autowired
    private ICarroService carroService;

    @Autowired
    private ILugarService lugarService;
    
    @Autowired
    private IMarcaService marcaService;
    

    @GetMapping("/carro")
    public String index(Model model) {
        List<Carro> listaCarro = carroService.getAllCarro();
        model.addAttribute("titulo", "Tabla Carros");
        model.addAttribute("carros", listaCarro);
        return "carros";
    }

    @GetMapping("/carroN")
    public String crearCarro(Model model) {
        List<Marca> listaMarcas = marcaService.listMarcs();
        List<Lugar> listaLugares = lugarService.listSucursal();
        model.addAttribute("carro", new Carro());
        model.addAttribute("marcas", listaMarcas);
        model.addAttribute("lugares", listaLugares);
        return "crearcarro";
    }

    @PostMapping("/save")
    public String guardarCarro(@ModelAttribute Carro carro) {
        carroService.saveCarro(carro);
        return "redirect:/carro";
    }

    @GetMapping("/editCarro/{id}")
    public String editarCarro(@PathVariable("id") Long idCarro, Model model) {
        Carro carro = carroService.getCarroById(idCarro);
        List<Marca> listaMarcas = marcaService.listMarcs();
        List<Lugar> listaLugares = lugarService.listSucursal();
        model.addAttribute("carro", carro);
        model.addAttribute("marcas", listaMarcas);
        model.addAttribute("lugares", listaLugares);
        return "crearcarro";
    }
    @GetMapping("/delete/{id}")
    public String eliminarCarro(@PathVariable("id") Long idCarro) {
      carroService.delete(idCarro);
        return "redirect:/carro";
    }
}
    

