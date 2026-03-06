package com.e_social.repository;

import com.example.demo1.Cotisation;
import com.example.demo1.Declaration;
import e_Social.jpaUtil.jPA;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CotisationRepo {
    public void save(Cotisation cotisation){
        EntityManager em= jPA.getEntityManager();
        em.getTransaction().begin();
        em.persist(cotisation);
        em.getTransaction().commit();
        em.close();
    }
    public Cotisation findId(int id){
        EntityManager em=jPA.getEntityManager();
        Cotisation ct= em.find(Cotisation.class,id);
        em.close();
        return ct;
    }

    public List<Cotisation> findAll(){
        EntityManager em =jPA.getEntityManager();
        List<Cotisation> cotisationList= em.createQuery("SELECT c from Cotisation c",Cotisation.class).getResultList();
        em.close();
        return cotisationList;
    }
    public void update(Cotisation  cotisation){
        EntityManager em=jPA.getEntityManager();
        em.getTransaction().begin();
        em.merge(cotisation);
        em.getTransaction().commit();
        em.close();
    }
    public void delete(int id){
        EntityManager em=jPA.getEntityManager();
        em.getTransaction().begin();
        Cotisation ct=em.find(Cotisation.class,id);
        if(ct !=null){
            em.remove(ct);
        }
        em.getTransaction().commit();
        em.close();
    }
}
