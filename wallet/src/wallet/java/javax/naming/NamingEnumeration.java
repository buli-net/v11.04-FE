package javax.naming;
import java.util.Enumeration;
public interface NamingEnumeration<T> extends Enumeration<T> {
    boolean hasMore() throws NamingException;
    T next() throws NamingException;
    void close() throws NamingException;
}