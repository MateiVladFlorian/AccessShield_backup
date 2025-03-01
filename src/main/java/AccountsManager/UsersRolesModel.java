package AccountsManager;

import jpa.UsersRolesJpaController;

/**
 *
 * @author vlad
 */
public class UsersRolesModel 
{
    private final UsersRolesJpaController users_role;
    
    public UsersRolesModel()
    {
        users_role = new UsersRolesJpaController();
    }
    
    public void Insert_Role(String role, String username) 
    { 
        if (role.equals("admin") || role.equals("quest"))
            users_role.InsertUsersRoles(role, username);
    }
}
