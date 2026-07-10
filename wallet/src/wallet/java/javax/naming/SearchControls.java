package javax.naming.directory;
public class SearchControls {
    public static final int OBJECT_SCOPE = 0;
    public static final int ONELEVEL_SCOPE = 1;
    public static final int SUBTREE_SCOPE = 2;
    public void setSearchScope(int s) {}
    public void setReturningAttributes(String[] a) {}
    public void setCountLimit(long l) {}
}