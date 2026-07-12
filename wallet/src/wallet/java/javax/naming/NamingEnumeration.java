package javax.naming;
public interface NamingEnumeration<T> extends java.util.Enumeration<T> {
    boolean hasMore() throws NamingException;
    T next() throws NamingException;
    void close() throws NamingException;
}