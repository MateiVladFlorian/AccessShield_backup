package jpa;

import core.AccountSession;
import Entities.*;
import core.ManagerEntities;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author vlad
 */
public class AccountJpaController {
    private static ManagerEntities em;
    private EntityManagerFactory f;
    private Account account;
    
    public AccountJpaController() {
        em = new ManagerEntities();
        f = Persistence.createEntityManagerFactory("org_AccessShield_backup_jar_1.0-SNAPSHOTPU");
    }
       
    public void InsertAccount(Account a)
    {
        if(a != null) {
            EntityManager e = f.createEntityManager();
            e.getTransaction().begin();
            e.persist(a);
            e.getTransaction().commit();
        }
    }
    
    public void InsertUserRole(UsersRoles role) {
        if(role != null) {
            EntityManager e = f.createEntityManager();
            e.getTransaction().begin();
            e.persist(role);
            e.getTransaction().commit();
        }
    }
    
    public String GetUserRole() {
        try {
            return ((List<UsersRoles>)(em.getManagerEntities()
                     .createNativeQuery("SELECT * FROM users_roles WHERE account_id = '" + AccountSession.getAccountId() + "'", UsersRoles.class)
                     .getResultList())).get(0).getRole();
            }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        
        return "";
    }
    
    public void UpdateAccount(int id, String password, String status) {
        try {
            em.getManagerEntities().find(Account.class, id).setPassword(password);
            em.getManagerEntities().find(Account.class, id).setStatus(status);
            
            em.BeginDataTransaction(f.createEntityManager());
            em.getManagerEntities().merge(em.getManagerEntities().find(Account.class, id)); 
            em.UpdateDataTransaction(em.getManagerEntities());
        }
        catch(Exception e) {
            if (em.ActiveTransaction(em.getManagerEntities())) em.RollBack(em.getManagerEntities());
        }
        finally { em.EndDataTransaction(em.getManagerEntities()); em.closeEntity(); }
    }
    
    public void RemoveAccount(String Username) { 
        account = em.getManagerEntities().find(Account.class, getIndexAccountSelected(Username));
        
        try {
            if (account != null) 
            {
                em.BeginDataTransaction(em.getManagerEntities());   
                em.getManagerEntities().remove(account);
                em.UpdateDataTransaction(em.getManagerEntities());
            }
        }
        catch(Exception e) {
            if (em.ActiveTransaction(em.getManagerEntities())) em.RollBack(em.getManagerEntities());
        }
        finally { em.EndDataTransaction(em.getManagerEntities()); em.closeEntity(); }
    }
    
    public boolean Login(String Username, String Password)
    {  
        account = em.getManagerEntities().find(Account.class, getIndexAccountSelected(Username));
        
        try {
            if (account != null) 
            {
                if (Username.equals(account.getUsername()) && Password.equals(account.getPassword())) 
                {
                    UpdateAccount(getIndexAccountSelected(Username), account.getPassword(), "activ");

                    AccountSession.setAccountId(account.getId());
                    AccountSession.setUsername(account.getUsername());
                    AccountSession.Authenticate(true);
                    return true;
                }
            }
        }
        catch(NullPointerException e) {
            if (account == null) {
                System.out.println("Entitate nula!"); e.printStackTrace();
            }
        }
        
        return false;
    }
    
    public boolean Reset(String Username, String Password, String finger_print) 
    {
        account = em.getManagerEntities().find(Account.class, getIndexAccountSelected(Username));
        
        try {
            if (account != null) 
            {
                if(!(Password.equals(account.getPassword())) && getIndexAccountSelected(Username) > 0) 
                {
                    UpdateAccount(getIndexAccountSelected(Username), Password, "inactiv");
                    AccountSession.Authenticate(false);
                    return true;       
                }
            }
        }
        catch(NullPointerException e) {
            if (account == null) {
                System.out.println("Entitate nula!"); e.printStackTrace();
            }
        }
        return false;
    }
    
    public int getIndexAccountSelected(String username) {
        try {
            return em.getManagerEntities()
                     .createQuery("SELECT a FROM Account a WHERE a.username = :username", Account.class)
                     .setParameter("username", username)
                     .getSingleResult().getId();
            }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        
        return 0;
    }
    
    public Account getAccountFromUsername(String username) {
        try {
            return em.getManagerEntities()
                     .createQuery("SELECT a FROM Account a WHERE a.username = :username", Account.class)
                     .setParameter("username", username)
                     .getSingleResult();
            }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        
        return null;
    }
    
    public int LastRowAccount()
    {
        String sql = "SELECT * FROM account ORDER BY id DESC LIMIT 1";
        Query nativeQuery = em.getManagerEntities().createNativeQuery(sql, Account.class);
        Account a = (Account) nativeQuery.getSingleResult();
        
        return a.getId();
    }
}
