package javax.naming.directory;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
public interface Attribute extends Cloneable, java.io.Serializable {
    String getID();
    Object get() throws NamingException;
    Object get(int ix) throws NamingException;
    int size();
    boolean add(Object attrVal);
    Object remove(int ix);
    void clear();
    NamingEnumeration<?> getAll() throws NamingException;
}
