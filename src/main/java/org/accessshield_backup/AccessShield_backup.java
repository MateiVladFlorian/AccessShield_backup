package org.accessshield_backup;

import Application.Accounts;
import migrate_db.MigrateDatabase;  
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
