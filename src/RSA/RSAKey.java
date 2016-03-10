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

    /**
     * x^e mod n
     * @param value to encrypt
     * @return encrypted BigInterger
     */
    public BigInteger encrypt(BigInteger value)
    {
        return value.modPow(ed, n);
    }

    /**
     * y^d mod n
     * @param value to decrypt
     * @return decripted BigInterger
     */
    public BigInteger decrypt(BigInteger value)
    {
        return value.modPow(ed, n);
    }
}
