package epby.ericpol.ct.servlet;

import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public final class DefaultSessionListener implements HttpSessionListener
{
    public static final String SESSION_ATTRIBUTE = "UserSessionService";
    private static final Logger LOGGER = Logger.getLogger(DefaultSessionListener.class.getName());

    @Override
    public void sessionCreated(HttpSessionEvent arg0)
    {
        LOGGER.finest("sessionCreated");

        /*
         * if (itsService != null) { arg0.getSession().setAttribute(SESSION_ATTRIBUTE, itsService);
         * LOGGER.warning("Session bean stored in HTTP session."); } else {
         * LOGGER.warning("There is no reference to session bean"); }
         */

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0)
    {
        LOGGER.finest("sessionDestroyed");

    }

}
