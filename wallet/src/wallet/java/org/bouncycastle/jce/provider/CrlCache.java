package org.bouncycastle.jce.provider;

import java.security.cert.CertificateFactory;
import java.util.Date;
import org.bouncycastle.jcajce.PKIXCRLStore;

public class CrlCache
{
    public static PKIXCRLStore getCrl(CertificateFactory certFact, Date date, Object crl)
    {
        return null;
    }

    public static PKIXCRLStore getCrl(CertificateFactory certFact, Date date, Object crl, boolean delta)
    {
        return null;
    }

    public static void clear()
    {
    }
}
