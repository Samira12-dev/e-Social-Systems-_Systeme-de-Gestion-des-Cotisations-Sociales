package com.e_social.repository;


import com.example.demo1.Assure;
import e_Social.jpaUtil.jPA;
import jakarta.persistence.EntityManager;

import java.util.List;

public class AssureRepo {
    public void save(Assure assure){
      EntityManager em= jPA.getEntityManager();
      em.getTransaction().begin();
      em.persist(assure);
      em.getTransaction().commit();
      em.close();
    }
    public Assure findId(int id){
        EntityManager em=jPA.getEntityManager();
        Assure as= em.find(Assure.class,id);
        em.close();
        return as;
    }

    public List<Assure> findAll(){
        EntityManager em =jPA.getEntityManager();
        List<Assure> assureList= em.createQuery("SELECT s from Assure s",Assure.class).getResultList();
        em.close();
        return assureList;
    }
    public void update(Assure assure){
        EntityManager em=jPA.getEntityManager();
        em.getTransaction().begin();
        em.merge(assure);
        em.getTransaction().commit();
        em.close();
    }
    public void delete(int id){
        EntityManager em=jPA.getEntityManager();
        em.getTransaction().begin();
        Assure a=em.find(Assure.class,id);
        if(a !=null){
            em.remove(a);
        }
        em.getTransaction().commit();
        em.close();
    }

}
