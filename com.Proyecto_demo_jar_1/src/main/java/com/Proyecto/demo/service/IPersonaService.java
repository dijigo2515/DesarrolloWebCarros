/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.demo.service;

import com.Proyecto.demo.entity.Persona;
import java.util.List;

/**
 *
 * @author maryg
 */
public interface IPersonaService {
    public List<Persona> getAllPersona();
    public void savePersona(Persona persona);
    public Persona getPersonaById (long id);
    public void delete (long id);
    public Persona findByNombre (String nombre);
}
