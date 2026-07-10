package javax.naming.directory;
import javax.naming.NamingException;
import javax.naming.NamingEnumeration;
public interface Attribute extends Cloneable, java.io.Serializable {
    String getID();
    Object get() throws NamingException;
    int size();
    NamingEnumeration<?> getAll() throws NamingException;
}
