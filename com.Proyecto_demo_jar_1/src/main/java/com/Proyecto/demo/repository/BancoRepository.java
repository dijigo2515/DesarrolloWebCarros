/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Proyecto.demo.repository;


import com.Proyecto.demo.entity.Banco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Daniel Felipe
 */
@Repository
public interface BancoRepository extends CrudRepository<Banco, Long>{
    
}
