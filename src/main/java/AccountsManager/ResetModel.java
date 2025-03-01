package AccountsManager;

import core.AccountsUtil;
import jpa.AccountJpaController;

/**
 *
 * @author vlad
 */
public final class ResetModel {
    AccountJpaController account_controller;
    
    public ResetModel() {
        account_controller = new AccountJpaController();
    }
    
    public boolean Reset_Model(String Username, String Password, String finger_print) {
        return account_controller.Reset(Username, AccountsUtil.GenerateSHA256(Password), AccountsUtil.GenerateSHA256(finger_print));
    }    
}
