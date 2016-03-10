package RSA;

import java.math.BigInteger;

/**
 * Created by Tobias on 10.03.2016.
 */
public class RSAKey {
    public BigInteger n;
    public BigInteger ed;

    public RSAKey(BigInteger n, BigInteger ed)
    {
        this.n = n;
        this.ed = ed;
    }
}
