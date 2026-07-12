package javax.naming.directory;
import java.io.Serializable;
public class SearchControls implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final int OBJECT_SCOPE = 0;
    public static final int ONELEVEL_SCOPE = 1;
    public static final int SUBTREE_SCOPE = 2;
    public SearchControls() {}
    public SearchControls(int scope, long countlim, int timelim, String[] attrs, boolean retobj, boolean deref) {}
    public void setSearchScope(int scope) {}
    public int getSearchScope() { return SUBTREE_SCOPE; }
    public void setCountLimit(long lim) {}
    public void setTimeLimit(int ms) {}
    public void setReturningAttributes(String[] attrs) {}
}