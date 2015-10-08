package com.curso.springdaohibernate.aspectos;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.dao.DataAccessException;

@Aspect
public class Recuperacion {

    public Recuperacion() {
    }

    @AfterThrowing(pointcut = "execution(* *..ServicioPersona.getPersona(..))",
    throwing = "ex")
    public void realizarRecuperacion(DataAccessException ex) {
        System.out.println("Ha ocurrido un error al acceder a datos:" + ex.getMessage());
    }
}
