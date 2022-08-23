/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Proyecto.demo.service;


import com.Proyecto.demo.entity.Banco;
import com.Proyecto.demo.repository.BancoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Daniel Felipe
 */
@Service
public class BancoService implements IBancoService{
    @Autowired
    private BancoRepository localRepository;
    
    @Override
    public List<Banco> listLocal(){
        return (List<Banco>)localRepository.findAll();}
}
