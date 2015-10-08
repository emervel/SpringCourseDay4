package com.curso.springdaohibernate.dominio;

public class Aficion {

    private Integer id;
    private String nombre;
    private Persona persona;

    public Aficion() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Esta afición se denomina " + getNombre();
    }
}
