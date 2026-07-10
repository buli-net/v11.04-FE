package javax.naming;
import java.io.Serializable;
public class Binding implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Object obj;
    public Binding(String name, Object obj) { this.name = name; this.obj = obj; }
    public String getName() { return name; }
    public Object getObject() { return obj; }
}