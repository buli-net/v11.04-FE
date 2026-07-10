package javax.naming.directory;
import javax.naming.*;
import java.util.Hashtable;
public class InitialDirContext implements DirContext {
    public InitialDirContext() throws NamingException {}
    public InitialDirContext(Hashtable<?,?> env) throws NamingException {}
    protected InitialDirContext(boolean lazy) throws NamingException {}
    public Attributes getAttributes(String name) throws NamingException { return null; }
    public NamingEnumeration<SearchResult> search(String name, String filter, SearchControls cons) throws NamingException { return null; }
    public NamingEnumeration<SearchResult> search(String name, String filterExpr, Object[] filterArgs, SearchControls cons) throws NamingException { return null; }
    public void close() throws NamingException {}
}