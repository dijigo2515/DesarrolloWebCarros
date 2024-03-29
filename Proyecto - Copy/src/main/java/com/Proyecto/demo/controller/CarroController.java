/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.demo.controller;

import com.Proyecto.demo.entity.Carro;
import com.Proyecto.demo.entity.Cotizacion;
import com.Proyecto.demo.entity.Provincia;
import com.Proyecto.demo.entity.Marca;
import com.Proyecto.demo.entity.EstadoVehiculo;
import com.Proyecto.demo.service.IProvinciaService;
import com.Proyecto.demo.service.ICarroService;
import com.Proyecto.demo.service.ICotizacionService;
import com.Proyecto.demo.service.IMarcaService;
import com.Proyecto.demo.service.IEstadoVehiculoService;
import com.Proyecto.demo.service.Userprincipal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 * @author Diana Jiménez
 */
@Controller
public class CarroController {
    
    @Autowired
    private ICarroService carroService;
    
    @Autowired
    private ICotizacionService cotizacionService;
    
    @Autowired
    private IMarcaService marcaService;
    
    @Autowired
    private IProvinciaService provinciaService;
    
    @Autowired
    private IEstadoVehiculoService estadoVehiculoService;
    
    @GetMapping("/carro")
    public String index(Model model) {
        List<Carro> listaCarro = carroService.getAllCarro();        
        model.addAttribute("carros", listaCarro);
        return "getAllCarro";
    }
    
    @GetMapping("/carro/getAll")
    public String getAllCarro(Model model) {
        //tomar la info del usuario logueado para validar si es administrador
        Userprincipal usuario = (Userprincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();                
        if(usuario.hasRole("ADMIN")){
            List<Carro> listaCarro = carroService.getAllCarro();
            model.addAttribute("titulo", "Tabla Carros");
            model.addAttribute("carros", listaCarro);
            return "getAllCarro";
        }        
        return "redirect:/Home/index";  
    }
    
    @GetMapping("/carro/misCarros")
    public String getMyCars(Model model) {
        //tomar el id del usuario logueado
        Userprincipal usuario = (Userprincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();           
        long idUsuario = usuario.getId();
        List<Carro> listaCarro = carroService.getAllCarro(); 
        List<Carro> carrosUsuario = new ArrayList<>();
        if(!listaCarro.isEmpty()){
            for(int i = 0; i<listaCarro.size(); i++){
                Carro c = listaCarro.get(i);
                if(c.getIdUsuario() == idUsuario){
                    carrosUsuario.add(c);
                }
            } 
        }                           
        model.addAttribute("carros", carrosUsuario);
        return "myCars";
    }
    
    @GetMapping("/carro/getNuevos")
    public String getNuevos(Model model) {        
        List<Carro> listaCarro = carroService.getAllCarro(); 
        List<Carro> carrosUsuario = new ArrayList<>();
        if(!listaCarro.isEmpty()){
            for(int i = 0; i<listaCarro.size(); i++){
                Carro c = listaCarro.get(i);
                if(c.getEstadoVehiculo().getId() == 1){
                    carrosUsuario.add(c);
                }
            } 
        }                           
        model.addAttribute("carros", carrosUsuario);
        return "getNuevos";
    }
    
    @GetMapping("/carro/getUsados")
    public String getUsados(Model model) {        
        List<Carro> listaCarro = carroService.getAllCarro(); 
        List<Carro> carrosUsuario = new ArrayList<>();
        if(!listaCarro.isEmpty()){
            for(int i = 0; i<listaCarro.size(); i++){
                Carro c = listaCarro.get(i);
                if(c.getEstadoVehiculo().getId() == 2){
                    carrosUsuario.add(c);
                }
            } 
        }                           
        model.addAttribute("carros", carrosUsuario);
        return "getUsados";
    }
    
    @GetMapping("/carro/getVendidos")
    public String getVendidos(Model model) {        
        List<Carro> listaCarro = carroService.getAllCarro(); 
        List<Carro> carrosUsuario = new ArrayList<>();
        if(!listaCarro.isEmpty()){
            for(int i = 0; i<listaCarro.size(); i++){
                Carro c = listaCarro.get(i);
                if(c.getEstadoVehiculo().getId() == 3){
                    carrosUsuario.add(c);
                }
            } 
        }                           
        model.addAttribute("carros", carrosUsuario);
        return "getVendidos";
    }
        
    @GetMapping("/carro/getMarca/{id}")
    public String getCarroByMarca(@PathVariable("id") Long idMarca ,Model model) {        
        List<Carro> listaCarro = carroService.getAllCarro(); 
        List<Carro> carrosUsuario = new ArrayList<>();
        if(!listaCarro.isEmpty()){
            for(int i = 0; i<listaCarro.size(); i++){
                Carro c = listaCarro.get(i);
                if(c.getMarca().getId() == idMarca){
                    carrosUsuario.add(c);
                }
            } 
        }                           
        model.addAttribute("carros", carrosUsuario);
        return "getMarca";
    }

    @GetMapping("/carro/create")
    public String create(Model model) {
        List<Marca> listaMarcas = marcaService.listMarcs(); 
        model.addAttribute("marcas", listaMarcas);     
        List<EstadoVehiculo> listaMarcas2 = estadoVehiculoService.getAll(); 
        model.addAttribute("marcas2", listaMarcas2);    
        List<Provincia> provincias = provinciaService.getAll(); 
        model.addAttribute("provincias", provincias);   
        model.addAttribute("carro", new Carro());           
        return "createCarro";
    }

    @PostMapping("/carro/create")
    public String create(@ModelAttribute Carro carro, @RequestParam("image") MultipartFile multipartFile) throws IOException {        
        //tomar el id del usuario logueado
        Userprincipal usuario = (Userprincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();        
        long idUsuario = usuario.getId();
        //Nuevo registro
        if(carro.getId() == 0){
            carro.setIdUsuario(idUsuario); 
            carro.setRuta_Imagen(multipartFile.getOriginalFilename());   
            carroService.saveCarro(carro,multipartFile); 
        }//Actualizar registro
        else{
            //si no seleccionó imagen
            if(multipartFile.getOriginalFilename().equals("")){
                Carro c = carroService.getCarroById(carro.getId()); 
                carro.setIdUsuario(c.getIdUsuario());
                carro.setRuta_Imagen(c.getRuta_Imagen());
                carroService.saveCarro(carro,multipartFile);  
            }else{
                Carro c = carroService.getCarroById(carro.getId()); 
                carro.setIdUsuario(c.getIdUsuario());
                carro.setRuta_Imagen(multipartFile.getOriginalFilename());   
                carroService.saveCarro(carro,multipartFile);  
            } 
        }                                              
        return "redirect:/carro/misCarros";               
    }
    
    @GetMapping("/carro/cotizar/{id}")
    public String createCotizacion(@PathVariable("id") Long idCarro, Model model) {        
        //tomar el id del usuario logueado
        Userprincipal usuario = (Userprincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();        
        long idUsuario = usuario.getId();
        Carro car = carroService.getCarroById(idCarro); 
        List<Cotizacion> cotizaciones = cotizacionService.getCotizaciones(); 
        //si el carro no pertenece al usuario que quiere cotizar
        if(car.getIdUsuario() != idUsuario){
            boolean cotizado = false;
            for(int i = 0; i<cotizaciones.size(); i++){                                            
                if(cotizaciones.get(i).getIdUsuario() == idUsuario){
                    cotizado = true;
                }
            }
            //si el carro no ha sido cotizado anteriormente por el usuario
            if(!cotizado){
                //obtener fecha actual
                java.util.Date currDate = Calendar.getInstance().getTime();
                Date todaysDate = new Date(currDate.getTime()); 
                
                Cotizacion cotizacion = new Cotizacion();
                cotizacion.setIdCarro(idCarro);
                cotizacion.setIdUsuario(idUsuario);
                cotizacion.setFecha(todaysDate);
                cotizacionService.saveCotizacion(cotizacion);
                return "redirect:/carro/cotizacionRealizada";        
            }
        }    
        return "redirect:/carro/errorCotizacion";  
    }
    
    @GetMapping("/carro/misCotizaciones")
    public String getMisCotizaciones(Model model) {
        //tomar el id del usuario logueado
        Userprincipal usuario = (Userprincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();           
        long idUsuario = usuario.getId();
        //consulta todos los carros
        List<Carro> listaCarro = carroService.getAllCarro(); 
        List<Carro> carrosUsuario = new ArrayList<>();
        //consulta todas las cotizaciones y las del usuario
        List<Cotizacion> listaCotizaciones = cotizacionService.getCotizaciones(); 
        List<Cotizacion> cotizacionesUsuario = new ArrayList<>();
        //si existen cotizaciones
        if(!listaCotizaciones.isEmpty()){
            //se recorren las cotizaciones y se almacenan en una lista las del usuario
            for(int i = 0; i<listaCotizaciones.size(); i++){
                Cotizacion c = listaCotizaciones.get(i);
                if(c.getIdUsuario() == idUsuario){
                    cotizacionesUsuario.add(c);
                }
            } 
        } 
        //si el usuario tiene cotizaciones
        if(!cotizacionesUsuario.isEmpty()){            
            for(int i = 0; i<listaCarro.size(); i++){
                for(int y = 0; y<cotizacionesUsuario.size(); y++){
                    Carro c = listaCarro.get(i);
                    if(c.getId() == cotizacionesUsuario.get(y).getIdCarro()){
                        carrosUsuario.add(c);
                    }
                }                
            } 
        }                           
        model.addAttribute("carros", carrosUsuario);
        return "misCotizaciones";
    }

    @GetMapping("/carro/errorCotizacion")
    public String errorCotizacion(Model model) {        
        return "errorCotizacion";
    }
    
    @GetMapping("/carro/cotizacionRealizada")
    public String cotizacionRealizada(Model model) {        
        return "cotizacionRealizada";
    }
    
    @GetMapping("/carro/deleteCotizacion/{id}")
    public String deleteCotizacion(@PathVariable("id") Long idCarro) {
        //tomar el id del usuario logueado
        Userprincipal usuario = (Userprincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();           
        long idUsuario = usuario.getId();
        List<Cotizacion> listaCotizaciones = cotizacionService.getCotizaciones();
        for(int i = 0; i<listaCotizaciones.size(); i++){
            if(listaCotizaciones.get(i).getIdCarro() == idCarro && listaCotizaciones.get(i).getIdUsuario()== idUsuario){
                cotizacionService.delete(listaCotizaciones.get(i).getId());
            }
        }        
        return "redirect:/carro/misCotizaciones";
    }
    
    @GetMapping("/carro/edit/{id}")
    public String edit(@PathVariable("id") Long idCarro, Model model) {
        List<Marca> listaMarcas = marcaService.listMarcs(); 
        model.addAttribute("marcas", listaMarcas);     
        List<EstadoVehiculo> listaMarcas2 = estadoVehiculoService.getAll(); 
        model.addAttribute("marcas2", listaMarcas2);    
        List<Provincia> provincias = provinciaService.getAll(); 
        model.addAttribute("provincias", provincias);  
        Carro carro = carroService.getCarroById(idCarro);              
        model.addAttribute("carro", carro);         
        return "editCarro";
    }   
    
    @GetMapping("/carro/details/{id}")
    public String details(@PathVariable("id") Long idCarro, Model model) {         
        Carro carro = carroService.getCarroById(idCarro);              
        model.addAttribute("carro", carro);         
        return "detailsCarro";
    }  
    
    @GetMapping("/carro/delete/{id}")
    public String deleteCarro(@PathVariable("id") Long idCarro) {
        carroService.delete(idCarro);
        return "redirect:/carro/getAll";
    }
    
    @GetMapping("/carro/deleteMyCar/{id}")
    public String deleteMyCar(@PathVariable("id") Long idCarro) {
        carroService.delete(idCarro);
        return "redirect:/carro/misCarros";
    }
}
    

