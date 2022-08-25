/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.demo.service;

import com.Proyecto.demo.entity.Usuario;
import java.util.List;

/**
 *
 * @author maryg
 */
public interface IUsuarioService {
    public List<Usuario> getAllUsuario();
    public void saveUsuario(Usuario usuario);
    public Usuario getUsuarioById (long id);
    public void delete (long id);
    public Usuario findByNombre (String nombre);
}
