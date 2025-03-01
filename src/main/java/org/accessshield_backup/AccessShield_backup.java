package org.accessshield_backup;

/*
import Entities.Account;
import core.AccountsUtil;
import core.ManagerEntities;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence; */
//import migrate_db.MigrateDatabase;  
/**
 *
 * @author vlad
 */
public class AccessShield_backup {

    public static void main(String[] args) 
    {
        //MigrateDatabase migrate = new MigrateDatabase();
        new Accounts().setVisible(true);
    }
}
