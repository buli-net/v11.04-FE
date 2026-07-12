package javax.naming.directory;
import javax.naming.Binding;
public class SearchResult extends Binding {
    private static final long serialVersionUID = 1L;
    private Attributes attrs;
    public SearchResult(String name, Object obj, Attributes attrs) {
        super(name, obj);
        this.attrs = attrs;
    }
    public SearchResult(String name, Object obj, Attributes attrs, boolean isRelative) {
        super(name, obj);
        this.attrs = attrs;
    }
    public Attributes getAttributes() { return attrs; }
}