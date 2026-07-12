package javax.naming.directory;
import javax.naming.*;
import java.util.Hashtable;
public class InitialDirContext implements DirContext {
    public InitialDirContext() throws NamingException {}
    public InitialDirContext(Hashtable<?,?> e) throws NamingException {}
    public Object lookup(String n) throws NamingException {return null;}
    public void bind(String n,Object o) throws NamingException {}
    public void rebind(String n,Object o) throws NamingException {}
    public void unbind(String n) throws NamingException {}
    public void rename(String a,String b) throws NamingException {}
    public NamingEnumeration<NameClassPair> list(String n) throws NamingException {return null;}
    public NamingEnumeration<Binding> listBindings(String n) throws NamingException {return null;}
    public void destroySubcontext(String n) throws NamingException {}
    public Context createSubcontext(String n) throws NamingException {return null;}
    public Object lookupLink(String n) throws NamingException {return null;}
    public NameParser getNameParser(String n) throws NamingException {return null;}
    public String composeName(String n,String p) throws NamingException {return n;}
    public Object addToEnvironment(String k,Object v) throws NamingException {return null;}
    public Object removeFromEnvironment(String k) throws NamingException {return null;}
    public Hashtable<?,?> getEnvironment() throws NamingException {return null;}
    public void close() throws NamingException {}
    public String getNameInNamespace() throws NamingException {return "";}
    public Object lookup(Name n) throws NamingException {return null;}
    public void bind(Name n,Object o) throws NamingException {}
    public void rebind(Name n,Object o) throws NamingException {}
    public void unbind(Name n) throws NamingException {}
    public void rename(Name a,Name b) throws NamingException {}
    public NamingEnumeration<NameClassPair> list(Name n) throws NamingException {return null;}
    public NamingEnumeration<Binding> listBindings(Name n) throws NamingException {return null;}
    public void destroySubcontext(Name n) throws NamingException {}
    public Context createSubcontext(Name n) throws NamingException {return null;}
    public Object lookupLink(Name n) throws NamingException {return null;}
    public NameParser getNameParser(Name n) throws NamingException {return null;}
    public Name composeName(Name a,Name b) throws NamingException {return a;}
    public Attributes getAttributes(String n) throws NamingException {return null;}
    public Attributes getAttributes(String n,String[] i) throws NamingException {return null;}
    public void modifyAttributes(String n,int o,Attributes a) throws NamingException {}
    public void modifyAttributes(String n,ModificationItem[] m) throws NamingException {}
    public void bind(String n,Object o,Attributes a) throws NamingException {}
    public void rebind(String n,Object o,Attributes a) throws NamingException {}
    public DirContext createSubcontext(String n,Attributes a) throws NamingException {return null;}
    public DirContext getSchema(String n) throws NamingException {return null;}
    public DirContext getSchemaClassDefinition(String n) throws NamingException {return null;}
    public NamingEnumeration<SearchResult> search(String n,Attributes m) throws NamingException {return null;}
    public NamingEnumeration<SearchResult> search(String n,Attributes m,String[] r) throws NamingException {return null;}
    public NamingEnumeration<SearchResult> search(String n,String f,SearchControls c) throws NamingException {return null;}
    public NamingEnumeration<SearchResult> search(String n,String f,Object[] a,SearchControls c) throws NamingException {return null;}
    public Attributes getAttributes(Name n) throws NamingException {return null;}
    public Attributes getAttributes(Name n,String[] i) throws NamingException {return null;}
    public void modifyAttributes(Name n,int o,Attributes a) throws NamingException {}
    public void modifyAttributes(Name n,ModificationItem[] m) throws NamingException {}
    public void bind(Name n,Object o,Attributes a) throws NamingException {}
    public void rebind(Name n,Object o,Attributes a) throws NamingException {}
    public DirContext createSubcontext(Name n,Attributes a) throws NamingException {return null;}
    public DirContext getSchema(Name n) throws NamingException {return null;}
    public DirContext getSchemaClassDefinition(Name n) throws NamingException {return null;}
    public NamingEnumeration<SearchResult> search(Name n,Attributes m) throws NamingException {return null;}
    public NamingEnumeration<SearchResult> search(Name n,Attributes m,String[] r) throws NamingException {return null;}
    public NamingEnumeration<SearchResult> search(Name n,String f,SearchControls c) throws NamingException {return null;}
    public NamingEnumeration<SearchResult> search(Name n,String f,Object[] a,SearchControls c) throws NamingException {return null;}
}
