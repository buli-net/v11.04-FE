package javax.naming;
import java.io.Serializable;
public class NameClassPair implements Serializable {
    String name; String className;
    public NameClassPair(String n,String c){name=n;className=c;}
    public String getName(){return name;}
    public String getClassName(){return className;}
}
