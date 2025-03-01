package AccountsManager;

import core.AccountsUtil;
import jpa.AccountJpaController;

/**
 *
 * @author vlad
 */
public class LoginModel 
{
    private AccountJpaController accountController;
    
    public LoginModel() {
        accountController = new AccountJpaController();
    }
    
    public boolean Login_Model(String Username, String Password) {      
        return accountController.Login(Username, AccountsUtil.GenerateSHA256(Password));
    }   
}