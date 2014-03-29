package epby.ericpol.ct;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Logger;

public final class PropertiesStore
{
    private static final Logger LOGGER = Logger.getLogger(PropertiesStore.class.getName());

    private PropertiesStore()
    {
        // Utility class
    }

    static String getProperty(final String aParam)
    {
        LOGGER.finest("getProperty(" + aParam + ")");
        String value = "";
        try
        {
            Properties p = new Properties();
            FileInputStream fis = new FileInputStream(Constants.CONFIGURATION_FILE);
            p.load(fis);
            value = p.getProperty(aParam, "");
            fis.close();
        }
        catch (Exception e)
        {
            LOGGER.finest(Constants.IGNORE_EXCEPTION + e.getMessage());
        }
        LOGGER.finest("getProperty = " + value);
        return value;
    }
}
