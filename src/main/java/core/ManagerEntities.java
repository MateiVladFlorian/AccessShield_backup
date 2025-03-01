package core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author vlad
 */
public class ManagerEntities {
    private EntityManagerFactory emf;
    
    public ManagerEntities()
    {   
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("org_AccessShield_backup_jar_1.0-SNAPSHOTPU");
        }
    }

    public EntityManager getManagerEntities() { return emf.createEntityManager(); }
    
    public void BeginDataTransaction(EntityManager em) { 
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
    }
    public void InsertData(EntityManager em, Object entity) { 
        em.persist(entity); 
    }
    
    public void UpdateDataTransaction(EntityManager em) { 
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        } 
    }
    public void EndDataTransaction(EntityManager em) { 
        if (em.isOpen()) em.close();
    }
    
    public void RollBack(EntityManager em) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        } 
    }
    public void closeEntity() {
        if (emf != null && emf.isOpen()) emf.close();
    }
    public boolean ActiveTransaction(EntityManager em) { return em.getTransaction().isActive(); }
}
