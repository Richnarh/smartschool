package com.khoders.smartschool.smartweb.jbeans.controller.auth;

import com.khoders.resource.jpa.CrudApi;
import com.khoders.resource.utilities.Msg;
import com.khoders.smartschool.entities.setup.UserAccount;
import com.khoders.smartschool.smartweb.Pages;
import com.khoders.smartschool.smartweb.jbeans.AuthModel;
import com.khoders.smartschool.smartweb.listener.AppSession;
import com.khoders.smartschool.smartweb.services.AuthService;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.util.Faces;

/**
 *
 * @author richard
 */
@Named(value="loginController")
@RequestScoped
public class LoginController implements Serializable
{
    @Inject private CrudApi crudApi;
    @Inject private AppSession appSession;
    @Inject private AuthService authService;

    private String username;
    private String password;
    private AuthModel authModel = new AuthModel();
        
    public String doLogin()
    {
        try
        {
            authModel.setUsername(username);
            authModel.setPassword(password);

            UserAccount account = authService.login(authModel);

            if (account == null)
            {
                FacesContext.getCurrentInstance().addMessage(null, 
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, Msg.setMsg("Wrong username or Password"), null));
                return null;
            }

            initLogin(account);
            
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }
    
    public String initLogin(UserAccount userAccount)
    {
        try
        {
            if (userAccount == null)
            {
                FacesContext.getCurrentInstance().addMessage(null, 
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, Msg.setMsg("Wrong username or Password"), null));
                return null;
            }
            appSession.login(userAccount);
            appSession.initAcademicTerm(userAccount.getAcademicTerm());
            Faces.redirect(Pages.index);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public String doLogout()
    {
        try
        {
            Faces.invalidateSession();
            Faces.logout();

            Faces.redirect(Pages.login);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
    
}
