package com.Proyecto.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Diana Jiménez
 */
@Controller
public class LoginController {
    
    @GetMapping("/login")
    public String index(){
        return "/login";     //Este login si es el de nuestro html
    }
}
