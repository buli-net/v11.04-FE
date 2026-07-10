package javax.naming;
public interface Context {
    String INITIAL_CONTEXT_FACTORY = "java.naming.factory.initial";
    String OBJECT_FACTORIES = "java.naming.factory.object";
    String STATE_FACTORIES = "java.naming.factory.state";
    String URL_PKG_PREFIXES = "java.naming.factory.url.pkgs";
    String PROVIDER_URL = "java.naming.provider.url";
    String SECURITY_AUTHENTICATION = "java.naming.security.authentication";
    String SECURITY_PRINCIPAL = "java.naming.security.principal";
    String SECURITY_CREDENTIALS = "java.naming.security.credentials";
    Object lookup(String name) throws NamingException;
    void close() throws NamingException;
}