package javax.naming.directory;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
public interface DirContext extends Context {
    Attributes getAttributes(String name) throws NamingException;
    NamingEnumeration<SearchResult> search(String name, String filter, SearchControls cons) throws NamingException;
}