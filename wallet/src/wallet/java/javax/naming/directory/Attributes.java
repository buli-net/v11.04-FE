package javax.naming.directory;
import javax.naming.NamingEnumeration;
public interface Attributes extends Cloneable, java.io.Serializable {
    Attribute get(String attrID);
    NamingEnumeration<? extends Attribute> getAll();
    NamingEnumeration<String> getIDs();
    int size();
}
