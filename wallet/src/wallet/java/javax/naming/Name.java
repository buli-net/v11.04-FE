package javax.naming;
import java.io.Serializable;
import java.util.Enumeration;
public interface Name extends Cloneable, Comparable<Object>, Serializable {
    int size(); boolean isEmpty(); Enumeration<String> getAll();
    String get(int posn); Name getPrefix(int posn); Name getSuffix(int posn);
    Object clone(); int compareTo(Object obj);
    boolean startsWith(Name n); boolean endsWith(Name n);
    Name addAll(Name s) throws InvalidNameException;
    Name addAll(int p, Name n) throws InvalidNameException;
    Name add(String c) throws InvalidNameException;
    Name add(int p, String c) throws InvalidNameException;
    Object remove(int p) throws InvalidNameException;
}
