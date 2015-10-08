package com.curso.springdaohibernate;

import com.curso.springdaohibernate.dominio.Aficion;
import com.curso.springdaohibernate.dominio.Persona;

import com.curso.springdaohibernate.servicios.ServicioPersona;
import static java.lang.System.out;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

public class Principal {

    private ApplicationContext ctx;
    private static final Logger logger = Logger.getAnonymousLogger();

    public Principal() {
    }

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.cargarContexto();
        principal.cargarDatosPrueba();
        principal.probarAccesoDatos();
        principal.probarAspectoRecuperacion();
    }

    private void cargarContexto() {
        String[] paths
                = {"applicationContext.xml", "daoContext.xml", "aspectosContext.xml"};
        ctx = new ClassPathXmlApplicationContext(paths);
        System.out.println("Contexto cargado");
    }

    private void probarAccesoDatos() {
        ServicioPersona s = (ServicioPersona) ctx.getBean("servicioPersona");
        System.out.printf("Hay %d personas en la base de datos\n",
                s.getNumeroDePersonas());
        System.out.println("************************************************");
        System.out.println("Personas en la base de datos");
        s.getPersonas().forEach(out::println);
        System.out.println("************************************************");
        System.out.println("Personas en la base de datos cuyo nombre contiene la letra 'p'");
        s.getPorNombreParecido("p").forEach(out::println);
        System.out.println("************************************************");
        System.out.println("Datos de la persona con id 1");
        Persona p = s.getPersona(1);
        System.out.println(p);
        System.out.println("************************************************");
        System.out.println("Borrando a aa persona con id = 1");
        s.deletePersona(p);
        System.out.println("************************************************");
        System.out.println("Aficiones de la persona con id 2");
        s.getAficiones(2).forEach(out::println);
        System.out.println("************************************************");
        System.out.println("Aficiones de la persona con id 2 obtenidas de otra manera");
        s.getAficionesDeOtraManera(2).forEach(out::println);
        System.out.println("************************************************");
        System.out.println("Aficiones de la persona con id 2 de una tercera forma");
        s.getAficionesDeOtraManeraMas(2).forEach(out::println);
        System.out.println("************************************************");
    }

    private void cargarDatosPrueba() {
        ServicioPersona s = (ServicioPersona) ctx.getBean("servicioPersona");
        logger.log(Level.INFO, "Servicio de personas encontrado");
        for (int i = 0; i < 10; i++) {
            Persona p = new Persona();
            p.setNombre("pepe" + i);
            Aficion a = new Aficion();
            a.setNombre("Afición" + i);
            a.setPersona(p);
            p.getAficionesInternas().add(a);
            s.insertPersona(p);
        }
        System.out.println("************************************************");
    }

    private void probarAspectoRecuperacion() {
        ServicioPersona s = (ServicioPersona) ctx.getBean("servicioPersona");
        System.out.println("Probando el aspecto de recuperación...");
        try {
            Persona p = s.getPersona(20000);
        } catch (DataAccessException e) {
            System.out.println("Excepción de tipo DataAccessException");
        }
    }
}
