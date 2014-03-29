package epby.ericpol.ct;

import java.util.logging.Logger;

public final class ConfigurationProperties
{
    private static final Logger LOGGER = Logger.getLogger(ConfigurationProperties.class.getName());

    private static String itsLdapUri = null;

    private static boolean isCacheMode = false;

    private ConfigurationProperties()
    {
        // Utility class
    }

    public static String getLdapUri()
    {
        LOGGER.finest("getLdapUri " + itsLdapUri);
        if (null == itsLdapUri)
        {
            itsLdapUri = PropertiesStore.getProperty(Constants.LDAP_URI);
        }
        return itsLdapUri;
    }

}
