package javax.naming.directory;
import java.util.Hashtable;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
public class InitialDirContext implements DirContext {
    public InitialDirContext() throws NamingException {}
    public InitialDirContext(Hashtable<?,?> env) throws NamingException {}
    public Object lookup(String n) throws NamingException { return null; }
    public void close() throws NamingException {}
    public Attributes getAttributes(String n) throws NamingException { return null; }
    public NamingEnumeration<SearchResult> search(String n, String f, SearchControls c) throws NamingException { return null; }
}