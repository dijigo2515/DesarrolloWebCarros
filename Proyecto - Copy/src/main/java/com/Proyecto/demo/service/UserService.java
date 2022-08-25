/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.demo.service;


import com.Proyecto.demo.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diana Jiménez
 */
@Service
public class UserService implements UserDetailsService {           //userservice: se guarda la info para despues ser utilizada
                                                                   //Interactua con spring security 
    @Autowired
    public IUsuarioService usuarioService; 
    
    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException{  //Cargando la info del username
        Usuario usuario = this.usuarioService.findByNombre(username);            
        Userprincipal userPrincipal = new Userprincipal(usuario);   //Toda la informacion de la persona
        return userPrincipal;
    }
}
