package javax.naming;
public class Binding extends NameClassPair {
    private Object obj;
    public Binding(String n,Object o){super(n,o!=null?o.getClass().getName():null);obj=o;}
    public Object getObject(){return obj;}
}
