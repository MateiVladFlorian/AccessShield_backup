/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccountsManager;

import Entities.UserProfile;
import jpa.UserProfileJpaController;

/**
 *
 * @author vladu
 */
public class AddProfile {
    
    private UserProfileJpaController p;
    
    public AddProfile()
    {
        p = new UserProfileJpaController();
    }
    
    public void AddUserProfile(UserProfile profile) 
    {
        if (profile != null) 
            p.AddProfile(profile);
    }
}
