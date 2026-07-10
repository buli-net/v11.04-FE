package javax.naming.directory;
import javax.naming.NamingException;
public interface Attribute extends Cloneable, java.io.Serializable {
    String getID();
    Object get() throws NamingException;
}