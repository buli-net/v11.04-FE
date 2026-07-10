package javax.naming.directory;
import javax.naming.NamingEnumeration;
public interface Attributes {
    Attribute get(String attrID);
    NamingEnumeration<? extends Attribute> getAll();
}