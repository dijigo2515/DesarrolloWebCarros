/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Proyecto.demo;

import java.util.Locale;
import lombok.experimental.var;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 *
 * @author Daniel Felipe
 * Internationalization-------il8n----18 letras entre I y n
 * Locale:Representa es el lenguaje, la region geografica, variantes del dialecto/idioma, de un usuario
 * SessionLocaleResolver: guardar el locale seleccionado por un usuario como atributo en el request HTTP
 * LocaleChangeInterceptor: Detectar cualquier cambio de parte del usuario hacia lo que es el Locale
 */

@Configuration
/* Las configurasciones */
public class WebConfig implements WebMvcConfigurer {
     @Bean
    public SessionLocaleResolver localeResolver(){
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("en"));
        return slr;
    }
    
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registro){
        registro.addInterceptor(localeChangeInterceptor());
    } 
    
}
