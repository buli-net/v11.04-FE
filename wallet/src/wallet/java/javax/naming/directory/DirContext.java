package javax.naming.directory;
import javax.naming.*;
public interface DirContext extends Context {
    Attributes getAttributes(String name) throws NamingException;
    NamingEnumeration<SearchResult> search(String name, String filter, SearchControls cons) throws NamingException;
    NamingEnumeration<SearchResult> search(String name, String filterExpr, Object[] filterArgs, SearchControls cons) throws NamingException;
}