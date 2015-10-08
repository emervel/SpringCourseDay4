package com.curso.springdaohibernate.aspectos;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.util.StopWatch;

@Aspect
//Si quisieramos no tener que definirlo en un xml podríamos ponera aqui @Component
public class Profiler {

    public Profiler() {
    }

    //Este aspecto viene genial porque nos determinara el tiempo de ejecución de cada metodo de acceso a datos
    @Around("execution(* *..ServicioPersona.get*(..))")
    public Object calcularTiempo(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch clock = new StopWatch("Calculando tiempo de ejecución...");
        try {
            clock.start(pjp.toShortString());
            return pjp.proceed();
        } finally {
            clock.stop();
            System.out.println(clock.prettyPrint());
        }
    }
}
