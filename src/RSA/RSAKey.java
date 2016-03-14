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
        return fastPow(value);
    }

    public BigInteger[] encrypt(byte[] bytes) {
        BigInteger[] biResults = new BigInteger[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            biResults[i] = encrypt(BigInteger.valueOf(b));
        }
        return biResults;
    }

    /**
     * y^d mod n
     * @param value to decrypt
     * @return decripted BigInterger
     */
    public BigInteger decrypt(BigInteger value)
    {
        return fastPow(value);
        //return value.modPow(ed, n);
    }

    public byte[] decrypt(BigInteger[] bytes) {
        byte[] byteResults = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            BigInteger bi = bytes[i];
            byteResults[i] = decrypt(bi).byteValue();
        }
        return byteResults;
    }

    public BigInteger fastPow(BigInteger k){
        int i = 0;
        BigInteger h = BigInteger.ONE;

        while (i < ed.bitLength()){
            if(ed.testBit(i)){
                h = h.multiply(k).mod(n);
            }
            k = k.pow(2).mod(n);
            i++;
        }
        return h;
    }
}
