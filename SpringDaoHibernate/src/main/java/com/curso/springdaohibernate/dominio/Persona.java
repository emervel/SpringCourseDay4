package com.curso.springdaohibernate.dominio;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Persona implements Serializable {

    private Integer id;
    private String nombre;
    private Set<Aficion> aficionesInternas = new HashSet<Aficion>();
    private List<Aficion> aficiones;

    public Persona() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Mi nombre es " + getNombre();
    }

    public List<Aficion> getAficiones() {
        return Collections.unmodifiableList(new ArrayList<Aficion>(aficionesInternas));
    }

    public Set<Aficion> getAficionesInternas() {
        return aficionesInternas;
    }

    protected void setAficionesInternas(Set<Aficion> aficionesInternas) {
        this.aficionesInternas = aficionesInternas;
    }
}
