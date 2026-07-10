package org.bouncycastle.jce.provider;

import java.security.cert.CertificateFactory;
import java.util.Date;
import org.bouncycastle.asn1.x509.DistributionPoint;

public class CrlCache
{
    public static PKIXCRLStore getCrl(CertificateFactory certFact, Date date, DistributionPoint dp)
    {
        // Wallet không dùng CRL LDAP, trả về null để bỏ qua cache
        return null;
    }

    public static PKIXCRLStore getCrl(CertificateFactory certFact, Date date, DistributionPoint dp, boolean delta)
    {
        return null;
    }

    public static void clear()
    {
    }
}
