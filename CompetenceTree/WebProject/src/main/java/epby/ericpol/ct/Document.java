package epby.ericpol.ct;

import java.io.Serializable;

public class Document implements Serializable, Comparable<Document>
{

    private static final long serialVersionUID = 2720091736864359719L;

    private String itsName;

    private String itsDescription;

    private String itsWikiLink;

    public Document(final String aName, final String aDescription, final String aWikiLink)
    {
        this.itsName = aName;
        this.itsDescription = aDescription;
        this.itsWikiLink = aWikiLink;
    }

    public String getName()
    {
        return itsName;
    }

    public void setName(final String aName)
    {
        this.itsName = aName;
    }

    public String getDescription()
    {
        return itsDescription;
    }

    public void setDescription(final String aDescription)
    {
        this.itsDescription = aDescription;
    }

    public String getWikiLink()
    {
        return itsWikiLink;
    }

    public void setWikiLink(final String aWikiLink)
    {
        this.itsWikiLink = aWikiLink;
    }

    // Eclipse Generated hashCode and equals
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((itsName == null) ? 0 : itsName.hashCode());
        result = prime * result + ((itsDescription == null) ? 0 : itsDescription.hashCode());
        result = prime * result + ((itsWikiLink == null) ? 0 : itsWikiLink.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        Document other = (Document) obj;
        if (itsName == null)
        {
            if (other.itsName != null)
            {
                return false;
            }
        }
        else if (!itsName.equals(other.itsName))
        {
            return false;
        }
        if (itsDescription == null)
        {
            if (other.itsDescription != null)
            {
                return false;
            }
        }
        else if (!itsDescription.equals(other.itsDescription))
        {
            return false;
        }
        if (itsWikiLink == null)
        {
            if (other.itsWikiLink != null)
            {
                return false;
            }
        }
        else if (!itsWikiLink.equals(other.itsWikiLink))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return itsName;
    }

    public int compareTo(Document document)
    {
        return this.getName().compareTo(document.getName());
    }
}