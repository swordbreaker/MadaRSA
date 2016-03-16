package RSA;

import java.math.BigInteger;

/**
 * Created by Tobias Bollinger on 10.03.2016.
 * 2nd Developer Janis Angst
 */
public class RSAKey {
    public BigInteger n;
    public BigInteger ed;

    /**
     * Constructor for the RSAKey
     *
     * @param n Primenumber
     * @param ed public/private key number
     */
    public RSAKey(BigInteger n, BigInteger ed) {
        this.n = n;
        this.ed = ed;
    }

    /**
     * x^e mod n
     *
     * @param value to encrypt
     * @return encrypted BigInterger
     */
    public BigInteger encrypt(BigInteger value) {
        return fastPow(value);
    }

    /**
     * Encription of every byte
     *
     * @param bytes text in bytesarray
     * @return encripted text
     */
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
     *
     * @param value to decrypt
     * @return decripted BigInterger
     */
    public BigInteger decrypt(BigInteger value) {
        return fastPow(value);
        //return value.modPow(ed, n);
    }

    /**
     * Decription of every byte
     *
     * @param bytes encripted text in BigIntegerarray
     * @return returns the text in bytes
     */
    public byte[] decrypt(BigInteger[] bytes) {
        byte[] byteResults = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            BigInteger bi = bytes[i];
            byteResults[i] = decrypt(bi).byteValue();
        }
        return byteResults;
    }

    /**
     * The fast exponentiation operation
     *
     * @param k exponent
     * @return result of square and multiply
     */
    public BigInteger fastPow(BigInteger k) {
        int i = 0;
        BigInteger h = BigInteger.ONE;

        while (i < ed.bitLength()) {
            if (ed.testBit(i)) {
                h = h.multiply(k).mod(n);
            }
            k = k.pow(2).mod(n);
            i++;
        }
        return h;
    }
}
