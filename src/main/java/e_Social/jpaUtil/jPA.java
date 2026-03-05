package e_Social.jpaUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class jPA {
    private  static final EntityManagerFactory ent= Persistence.createEntityManagerFactory("e_Social");
    public static EntityManager getEntityManager(){
        return ent.createEntityManager();
    }
}
