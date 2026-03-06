package com.e_social.repository;

import com.example.demo1.Assure;
import com.example.demo1.Declaration;
import e_Social.jpaUtil.jPA;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DeclarationRepo {
    public void save(Declaration declaration){
        EntityManager em= jPA.getEntityManager();
        em.getTransaction().begin();
        em.persist(declaration);
        em.getTransaction().commit();
        em.close();
    }
    public Declaration findId(int id){
        EntityManager em=jPA.getEntityManager();
        Declaration dr= em.find(Declaration.class,id);
        em.close();
        return dr;
    }

    public List<Declaration> findAll(){
        EntityManager em =jPA.getEntityManager();
        List<Declaration> declarationList= em.createQuery("SELECT d from Declaration d",Declaration.class).getResultList();
        em.close();
        return declarationList;
    }
    public void update(Declaration declaration){
        EntityManager em=jPA.getEntityManager();
        em.getTransaction().begin();
        em.merge(declaration);
        em.getTransaction().commit();
        em.close();
    }
    public void delete(int id){
        EntityManager em=jPA.getEntityManager();
        em.getTransaction().begin();
        Declaration dr=em.find(Declaration.class,id);
        if(dr !=null){
            em.remove(dr);
        }
        em.getTransaction().commit();
        em.close();
    }
}
