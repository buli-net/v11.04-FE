package javax.naming.directory;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
public interface Attribute {
    String getID();
    Object get() throws NamingException;
    NamingEnumeration<?> getAll() throws NamingException;
}