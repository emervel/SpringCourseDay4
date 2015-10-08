package com.curso.springdaohibernate.aspectos;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.dao.DataAccessException;

//Primero le digo a Spring que esto es un Aspecto
@Aspect
public class Recuperacion {

    public Recuperacion() {
    }
    
    /*le decimos a Spring que en el metodo getPersona de cualquier clase que implemente 
    ServicioPersona cuando se lance una excepcion ejecute nuestro Advice (el codigo java que va despues)    
    */
    @AfterThrowing(pointcut = "execution(* *..ServicioPersona.getPersona(..))",
    throwing = "ex")
    public void realizarRecuperacion(DataAccessException ex) {
        System.out.println("Ha ocurrido un error al acceder a datos:" + ex.getMessage());
    }
}
