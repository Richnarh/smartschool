
package com.khoders.smartschool.smartweb.services;

import com.khoders.smartschool.entities.setup.UserAccount;
import com.khoders.resource.jpa.CrudApi;
import static com.khoders.resource.utilities.SecurityUtil.hashText;
import com.khoders.smartschool.smartweb.jbeans.AuthModel;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

/**
 *
 * @author richa
 */
public class AuthService
{
    @Inject private CrudApi crudApi;
    
    public UserAccount login(AuthModel authModel)
    {
        
        try
        {
            String qryString = "SELECT e FROM UserAccount e WHERE e.username=?1 AND e.password=?2";
            TypedQuery<UserAccount> typedQuery = crudApi.getEm().createQuery(qryString, UserAccount.class)
                    .setParameter(1, authModel.getUsername())
                    .setParameter(2, hashText(authModel.getPassword()));
            
                 return typedQuery.getResultStream().findFirst().orElse(null);
                 
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }
    
    public boolean isTaken(String email)
    {
        String qryString = "SELECT e FROM UserAccount e WHERE e.username=?1";
        try {
            UserAccount account = crudApi.getEm().createQuery(qryString, UserAccount.class)
                    .setParameter(1, email)
                    .getSingleResult();
            
            return account != null;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return false;
    }
}
