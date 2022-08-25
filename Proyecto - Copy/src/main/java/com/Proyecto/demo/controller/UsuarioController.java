
package com.Proyecto.demo.controller;


import com.Proyecto.demo.entity.Usuario;
import com.Proyecto.demo.service.IUsuarioService;
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
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;
    
    @GetMapping("/usuario") 
    public String index (Model model){
    List <Usuario> listarUsuario = usuarioService.getAllUsuario();
    model.addAttribute("titulo","Tabla Usuarios");
    model.addAttribute("usuarios",listarUsuario);
    return "usuarios";
    }
}
