package javax.naming;
public interface Context {
    String INITIAL_CONTEXT_FACTORY = "java.naming.factory.initial";
    String OBJECT_FACTORIES = "java.naming.factory.object";
    String STATE_FACTORIES = "java.naming.factory.state";
    String URL_PKG_PREFIXES = "java.naming.factory.url.pkgs";
    String PROVIDER_URL = "java.naming.provider.url";
    String DNS_URL = "java.naming.dns.url";
    String AUTHORITATIVE = "java.naming.authoritative";
    String BATCHSIZE = "java.naming.batchsize";
    String REFERRAL = "java.naming.referral";
    String SECURITY_PROTOCOL = "java.naming.security.protocol";
    String SECURITY_AUTHENTICATION = "java.naming.security.authentication";
    String SECURITY_PRINCIPAL = "java.naming.security.principal";
    String SECURITY_CREDENTIALS = "java.naming.security.credentials";
    String LANGUAGE = "java.naming.language";
    String APPLET = "java.naming.applet";
    void close() throws NamingException;
}
