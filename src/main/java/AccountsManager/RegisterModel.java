package AccountsManager;


import Entities.Account;
import core.LoadsTablesData;
import java.util.List;
import jpa.AccountJpaController;

/**
 *
 * @author vlad
 */
public class RegisterModel {
    private List<Account> accounts;
    private LoadsTablesData load;
    private AccountJpaController account_controller;
    
    public RegisterModel() 
    {
        load = new LoadsTablesData();
        accounts = load.Load_Account_TableData();
        account_controller = new AccountJpaController();
    }
    
    public int Register_model(Account a)
    {
        int count = 0;
        
        int s = accounts.size();
        String username = a.getUsername();
        String email = a.getEmail();
        String password = a.getPassword();
        String cnp = a.getCnp();
        
        if (s > 0) 
        {
            for (Account b : accounts)
                if (!(username.equals(b.getUsername())) && !(email.equals(b.getPassword())) && !(password.equals(b.getPassword())) && !(cnp.equals(b.getCnp())))
                    count++;

            return count;
        }
        return 0;
    }
    
    public void Register(Account a) 
    {
        try {
            if (Register_model(a) > 0) 
            {
                account_controller.InsertAccount(a);
            }
            else if (Register_model(a) == 0)
                account_controller.InsertAccount(a);
            else 
                System.out.println("Error add dates");
        } 
        catch(Exception e) {
            System.out.println(e.getMessage() + "\n" + e.getLocalizedMessage());
        }
    }
}