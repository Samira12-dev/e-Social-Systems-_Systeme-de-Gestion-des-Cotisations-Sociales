package com.e_social.repository;

import com.example.demo1.Employeur;
import e_Social.jpaUtil.jPA;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EmployeurRepo {
    //Save
    public void save(Employeur employeur) {

        EntityManager em = jPA.getEntityManager();
        em.getTransaction().begin();

        em.persist(employeur);

        em.getTransaction().commit();
        em.close();
    }
    //find by id
    public Employeur findID(int id){
        EntityManager et = jPA.getEntityManager();
        Employeur emp= et.find(Employeur.class,id);
        et.close();
        return emp;
    }
    //find all
    public List<Employeur> findAll(){
        EntityManager et= jPA.getEntityManager();
        List<Employeur> list= et.createQuery("SELECT e FROM Employeur e", Employeur.class)
                .getResultList();
        et.close();
        return list;
    }
    // update
    public void update(Employeur employeur){
        EntityManager et= jPA.getEntityManager();
        et.getTransaction().begin();
        et.merge(employeur);
        et.getTransaction().commit();
        et.close();
    }
    // delete
    public void delete(int id){
        EntityManager et = jPA.getEntityManager();
        et.getTransaction().begin();
        Employeur emp= et.find(Employeur.class,id);
        if(emp !=null){
            et.remove(emp);
        }
        et.getTransaction().commit();
        et.close();
    }
}
