package epby.ericpol.ct;

import java.util.Hashtable;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import org.primefaces.context.RequestContext;

public class LoginBean
{

    private static final Logger LOGGER = Logger.getLogger(LoginBean.class.getName());
    private String itsUsername;

    private String itsPassword;

    public String getUsername()
    {
        return itsUsername;
    }

    public void setUsername(final String anUsername)
    {
        this.itsUsername = anUsername;
    }

    public String getPassword()
    {
        return itsPassword;
    }

    public void setPassword(final String aPassword)
    {
        this.itsPassword = aPassword;
    }

    public void login(ActionEvent actionEvent)
    {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        boolean loggedIn = false;

        if (null != itsUsername && null != itsPassword && ldapLogin(itsUsername, itsPassword))
        {
            loggedIn = true;
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", itsUsername);
        }
        else
        {
            loggedIn = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", loggedIn);
    }

    /**
     * Method authenticated by LDAP
     * 
     * @param paramMap
     * @return boolean - if LDAP authentication pass
     */
    private boolean ldapLogin(final String anUser, final String aPassword)
    {

        // Set up the environment for creating the initial context
        String username = anUser;
        String password = aPassword;
        String dn = "uid=" + username + "," + ConfigurationProperties.getLdapBase();

        Hashtable<String, String> authEnv = new Hashtable<String, String>();
        authEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        authEnv.put(Context.PROVIDER_URL, ConfigurationProperties.getLdapUri());
        authEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
        authEnv.put(Context.SECURITY_PRINCIPAL, dn);
        authEnv.put(Context.SECURITY_CREDENTIALS, password);

        // Create the initial context
        try
        {
            DirContext ctx = new InitialDirContext(authEnv);

            boolean result = ctx != null;
            LOGGER.finest("LDAP Login result:" + result);

            if (ctx != null)
            {
                ctx.close();
            }
            return result;
        }
        catch (Exception ex)
        {
            LOGGER.finest(ex.getMessage());
            LOGGER.finest(dn);
            ex.printStackTrace();
            return false;
        }
    }
}