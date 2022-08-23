
package com.Proyecto.demo.controller;


import com.Proyecto.demo.entity.Persona;
import com.Proyecto.demo.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author maryg
 */
@Controller 
public class PersonaController {
    @Autowired
    private IPersonaService personaService;
    
    @GetMapping("/persona") 
    public String index (Model model){
    List <Persona> listarPersona = personaService.getAllPersona();
    model.addAttribute("titulo","Tabla Personas");
    model.addAttribute("personas",listarPersona);
    return "personas";
    }
}
