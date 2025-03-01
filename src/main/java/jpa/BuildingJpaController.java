/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa;

import core.AccountSession;
import Entities.*;
import core.ManagerEntities;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.*;
import java.util.*;

/**
 *
 * @author vlad
 */
public class BuildingJpaController {
    private EntityManagerFactory f;
    private ManagerEntities em;
    
    public BuildingJpaController() {
        em = new ManagerEntities();
        f = Persistence.createEntityManagerFactory("org_AccessShield_backup_jar_1.0-SNAPSHOTPU");
    }
    
    public boolean InsertBuilding(Building building)
    {
        if (building != null) {
            EntityManager e = f.createEntityManager();
            e.getTransaction().begin();
            e.persist(building);
            e.getTransaction().commit();
            return true;
        }
        
        return false;
    }
    
    public void UpdateBuilding(String getname, Building build)
    {
        try {            
            em.BeginDataTransaction(f.createEntityManager());
            em.getManagerEntities().merge(em.getManagerEntities().find(Building.class, getIndexBuildSelected(getname))); 
            em.UpdateDataTransaction(em.getManagerEntities());
        }
        catch(Exception e) {
            if (em.ActiveTransaction(em.getManagerEntities())) em.RollBack(em.getManagerEntities());
        }
        finally { em.EndDataTransaction(em.getManagerEntities()); em.closeEntity(); }
    }
    
    public List<Building> getBuildingItems(int accountId) {
        try {
            return em.getManagerEntities()
                     .createNativeQuery("SELECT * FROM Building WHERE account_id = " + "'" + AccountSession.getAccountId() + "' and count_rooms > 0", Building.class)
                     .getResultList();
            }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        
        return new ArrayList<>();
    }
    
    public List<Building> getAllBuildingItems() {
        try {
            return em.getManagerEntities()
                     .createNativeQuery("SELECT * FROM Building WHERE count_rooms > 0", Building.class)
                     .getResultList();
            }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        
        return new ArrayList<>();
    }
    
    public List<Building> getAllBuildingItems(String name) {
        try {
            return em.getManagerEntities()
                     .createNativeQuery("SELECT * FROM Building WHERE count_rooms > 0 and LOWER(name) like '" + name + "%'", Building.class)
                     .getResultList();
            }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        
        return new ArrayList<>();
    }
    
    public List<Building> getBuildingItems(int accountId, String name) {
        try {
            return em.getManagerEntities()
                     .createNativeQuery("SELECT * FROM Building WHERE account_id = " + "'" + AccountSession.getAccountId() + "' and count_rooms > 0 and LOWER(name) like '" + name + "%'", Building.class)
                     .getResultList();
            }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        
        return new ArrayList<>();
    }
    
    public int getIndexBuildSelected(String name) {
        try {
            return em.getManagerEntities()
                     .createQuery("SELECT b FROM Building b WHERE b.name = :name", Building.class)
                     .setParameter("name", name)
                     .getSingleResult().getId();
            }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        
        return 0;
    }
    
    public Building getBuildingByName(String name) {
        try {
            return em.getManagerEntities()
                     .createQuery("SELECT b FROM Building b WHERE b.name = :name", Building.class)
                     .setParameter("name", name)
                     .getSingleResult();
            }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        
        return null;
    }
}
