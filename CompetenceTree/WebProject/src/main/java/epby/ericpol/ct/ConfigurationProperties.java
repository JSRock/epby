package epby.ericpol.ct;

import java.util.logging.Logger;

public final class ConfigurationProperties
{
    private static final Logger LOGGER = Logger.getLogger(ConfigurationProperties.class.getName());
    private static String itsLdapBase = null;
    private static String itsLdapUri = null;
    private static String itsLMList = null;

    private ConfigurationProperties()
    {
        // Utility class
    }

    // Getters
    public static String getLdapBase()
    {
        LOGGER.finest("getLdapBase " + itsLdapBase);
        if (null == itsLdapBase)
        {
            itsLdapBase = PropertiesStore.getProperty(Constants.LDAP_BASE);
        }
        return itsLdapBase;
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

    public static String getLMList()
    {
        LOGGER.finest("getLMList " + itsLMList);
        if (null == itsLMList)
        {
            itsLMList = PropertiesStore.getProperty(Constants.CT_LM_LIST);
        }
        return itsLMList;
    }
}
