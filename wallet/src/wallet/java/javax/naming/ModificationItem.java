package javax.naming.directory;
public class ModificationItem implements java.io.Serializable {
    int op; Attribute attr;
    public ModificationItem(int o,Attribute a){op=o;attr=a;}
    public int getModificationOp(){return op;}
    public Attribute getAttribute(){return attr;}
}
