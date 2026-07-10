package javax.naming.directory;
import javax.naming.*;
import java.util.Hashtable;
public class InitialDirContext implements DirContext {
    public InitialDirContext() throws NamingException {}
    public InitialDirContext(Hashtable<?,?> env) throws NamingException {}
    // --- Context ---
    public Object lookup(String n) throws NamingException {return null;}
    public void bind(String n,Object o) throws NamingException {}
    public void rebind(String n,Object o) throws NamingException {}
    public void unbind(String n) throws NamingException {}
    public void rename(String a,String b) throws NamingException {}
    public NamingEnumeration list(String n) throws NamingException {return null;}
    public NamingEnumeration listBindings(String n) throws NamingException {return null;}
    public void destroySubcontext(String n) throws NamingException {}
    public Context createSubcontext(String n) throws NamingException {return null;}
    public Object lookupLink(String n) throws NamingException {return null;}
    public String composeName(String n,String p) throws NamingException {return n;}
    public Object addToEnvironment(String k,Object v) throws NamingException {return null;}
    public Object removeFromEnvironment(String k) throws NamingException {return null;}
    public Hashtable<?,?> getEnvironment() throws NamingException {return null;}
    public void close() throws NamingException {}
    public String getNameInNamespace() throws NamingException {return "";}
    // --- DirContext ---
    public Attributes getAttributes(String n) throws NamingException {return null;}
    public Attributes getAttributes(String n,String[] ids) throws NamingException {return null;}
    public NamingEnumeration<SearchResult> search(String n,String f,SearchControls c) throws NamingException {return null;}
    public NamingEnumeration<SearchResult> search(String n,String f,Object[] a,SearchControls c) throws NamingException {return null;}
}
