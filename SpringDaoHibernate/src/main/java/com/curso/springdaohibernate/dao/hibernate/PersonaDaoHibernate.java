package com.curso.springdaohibernate.dao.hibernate;

import com.curso.springdaohibernate.dao.PersonaDao;

import com.curso.springdaohibernate.dominio.Aficion;
import com.curso.springdaohibernate.dominio.Persona;

import java.util.List;

import org.hibernate.Session;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *  Clase implementa los métodos DAO usando los metodos de acceso a datos de la
 *  clase HibernateDaoSupport
 * @author Emervel
 */
public class PersonaDaoHibernate extends HibernateDaoSupport implements PersonaDao {

    public PersonaDaoHibernate() {
    }

    @Override
    public List getPersonas() {
        return getHibernateTemplate().find("from Persona p order by p.nombre");
    }

    @Override
    public Persona insertPersona(Persona una) {
        getHibernateTemplate().saveOrUpdate(una);
        return una;
    }

    @Override
    public void updatePersona(Persona una) {
        getHibernateTemplate().update(una);
    }

    @Override
    public void deletePersona(Persona una) {
        getHibernateTemplate().delete(una);
    }

    @Override
    public Persona getPersona(Integer id) {
        return (Persona) getHibernateTemplate().load(Persona.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Persona> getPorNombreParecido(final String nombre) {
        final String orden = "from Persona p where p.nombre like :nombre";
        return getHibernateTemplate()
                .execute(
                        session -> session.createQuery(orden).setString("nombre", "%" + nombre + "%").list()
                );
    }

    @Override
    public Long getNumeroDePersonas() {
        List lista
                = getHibernateTemplate().find("select count(*) from Persona");
        return (Long) lista.get(0);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Aficion> getAficiones(Integer id) {
        return (List<Aficion>) getHibernateTemplate().find("select p.aficionesInternas from Persona p where p.id = ?",
                new Object[]{id});
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Aficion> getAficionesDeOtraManera(final Integer id) {
        return getHibernateTemplate().execute(new HibernateCallback<List<Aficion>>() {

            @Override
            public List<Aficion> doInHibernate(Session session) {
                Persona p = (Persona) session.load(Persona.class, id);
                return p.getAficiones();
            }
        });
    }

    @Override
    public List<Aficion> getAficionesDeOtraManeraMas(Integer id) {
        Persona p = (Persona) getHibernateTemplate().load(Persona.class, id);
        return p.getAficiones();
    }
}
