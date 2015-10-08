package com.curso.springdaohibernate.dao;

import com.curso.springdaohibernate.dominio.Aficion;
import com.curso.springdaohibernate.dominio.Persona;

import java.util.List;

/**
 * Interfaz que establecerá los metodos a ser utilizados por el DAO 
 * Se pone como una interfaz para conseguir separar la capa de servicios ni de la capa de acceso a datos
 * @author Emervel
 */
public interface PersonaDao {

    List<Persona> getPersonas();

    Persona insertPersona(Persona una);

    void updatePersona(Persona una);

    void deletePersona(Persona una);

    Persona getPersona(Integer id);

    List<Persona> getPorNombreParecido(String nombre);

    Long getNumeroDePersonas();

    List<Aficion> getAficiones(Integer id);

    List<Aficion> getAficionesDeOtraManera(Integer id);

    List<Aficion> getAficionesDeOtraManeraMas(Integer id);
}
