/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa;

import Entities.Account;
import Entities.UsersRoles;
import core.AccountSession;
import core.ManagerEntities;

/**
 *
 * @author vlad
 */
public class UsersRolesJpaController {
    private ManagerEntities em;
    private Account a;
    private AccountJpaController account_controller;
    
    public UsersRolesJpaController() 
    {
        em = new ManagerEntities();
        account_controller = new AccountJpaController();
    }
    
    public void InsertUsersRoles(String role, String Username)
    {
        a = em.getManagerEntities().find(Account.class, account_controller.getIndexAccountSelected(Username));
        UsersRoles table = new UsersRoles();
        table.setAccountId(a);
        table.setRole(role);
        
        try {
            em.BeginDataTransaction(em.getManagerEntities());
            em.InsertData(em.getManagerEntities(), table);
            em.UpdateDataTransaction(em.getManagerEntities());
            em.EndDataTransaction(em.getManagerEntities());
        }
        catch(Exception e) {
            if (em.ActiveTransaction(em.getManagerEntities())) em.RollBack(em.getManagerEntities());
        }
        finally { em.EndDataTransaction(em.getManagerEntities()); }
    }
}
