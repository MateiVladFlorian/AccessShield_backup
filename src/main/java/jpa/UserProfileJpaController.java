/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa;

import Entities.UserProfile;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vlad
 */
public class UserProfileJpaController {
    
    private EntityManagerFactory f;
    
    public UserProfileJpaController() 
    {
        f = Persistence.createEntityManagerFactory("org_AccessShield_backup_jar_1.0-SNAPSHOTPU");
    }
    
    public void AddProfile(UserProfile profile)
    {
        if (profile != null) {
            EntityManager e = f.createEntityManager();
            e.getTransaction().begin();
            e.persist(profile);
            e.getTransaction().commit();
        }
    }
    
}
