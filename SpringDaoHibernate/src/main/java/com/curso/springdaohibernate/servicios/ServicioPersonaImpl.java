package com.curso.springdaohibernate.servicios;

import com.curso.springdaohibernate.dao.PersonaDao;

import com.curso.springdaohibernate.dominio.Aficion;
import com.curso.springdaohibernate.dominio.Persona;

import java.util.List;

/**
 *
 * Interfaz de mi servicio que sera expuesta para ser invocada desde la capa web o negocio
 * @author Emervel
 */
public class ServicioPersonaImpl implements ServicioPersona {

    private PersonaDao personaDao;

    public ServicioPersonaImpl() {
    }

    @Override
    public List<Persona> getPersonas() {
        return personaDao.getPersonas();
    }

    @Override
    public Persona insertPersona(Persona una) {
        return personaDao.insertPersona(una);
    }

    public void updatePersona(Persona una) {
        personaDao.updatePersona(una);
    }

    @Override
    public void deletePersona(Persona una) {
        personaDao.deletePersona(una);
    }

    @Override
    public Persona getPersona(Integer id) {
        return personaDao.getPersona(id);
    }
    
    @Override
    public List<Persona> getPorNombreParecido(String nombre) {
        return personaDao.getPorNombreParecido(nombre);
    }

    public void setPersonaDao(PersonaDao personaDao) {
        this.personaDao = personaDao;
    }

    @Override
    public Long getNumeroDePersonas() {
        return personaDao.getNumeroDePersonas();
    }

    @Override
    public List<Aficion> getAficiones(Integer id) {
        return personaDao.getAficiones(id);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public List<Aficion> getAficionesDeOtraManera(Integer id) {
        return personaDao.getAficionesDeOtraManera(id);
    }

    @Override
    public List<Aficion> getAficionesDeOtraManeraMas(Integer id) {
        return personaDao.getAficionesDeOtraManeraMas(id);
    }
}
