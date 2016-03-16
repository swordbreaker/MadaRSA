package RSA;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by Tobias Bollinger on 10.03.2016.
 * 2nd Developer Janis Angst
 */

public class KeyGenerator {
    private RSAKey publicKey;
    private RSAKey privateKey;

    public static int bigIntSize = 1024;

    /**
     * KeyGenerator Constructor
     *
     * Creates a random number.
     * With the two prime numbers and "e", the Constructor will calculate
     * The 3 numbers are saved as private key(n,d) and public key(n,e)
     */
    public KeyGenerator() {
        Random random = new Random();
        Prime prime = new Prime();
        BigInteger e;
        BigInteger phiN = phi(prime.prime1, prime.prime2);

        // Check if the prerequisite for the extended euclidean is correct else create a new random number
        BigInteger d = BigInteger.ZERO;
        do {
            e = new BigInteger(bigIntSize,1, random);

            if(phiN.compareTo(e) >= 0) {
                d = extendedEuclidean(phiN, e);
            }
        }while (d.compareTo(BigInteger.ZERO) <= 0);

        privateKey = new RSAKey(prime.n, d);
        publicKey = new RSAKey(prime.n, e);
    }


    /**
     * With the Euler's phi function we get phi(n)
     *
     * @param p prime number 1
     * @param q prime number 2
     * @return BigInteger Euler's phi of p * q
     */
    public static BigInteger phi(BigInteger p, BigInteger q) {
        return (p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)));
    }

    /**
     *
     *
     * @param a phiN
     * @param b random number "e"
     * @return returns the value of "d"
     */
    public static BigInteger extendedEuclidean(BigInteger a, BigInteger b) {
        BigInteger x0 = BigInteger.ONE;
        BigInteger y0 = BigInteger.ZERO;
        BigInteger x1 = BigInteger.ZERO;
        BigInteger y1 = BigInteger.ONE;
        BigInteger q = a.divide(b);
        BigInteger r = a.mod(b);

        BigInteger oldX0;
        BigInteger oldY0;

        while (b.compareTo(BigInteger.ZERO) > 0){
            a = b;
            b = r;
            oldX0 = x0;
            oldY0 = y0;
            x0 = x1;
            y0 = y1;
            //oldX0-q*x1
            x1 = oldX0.subtract(q.multiply(x1));
            //oldY0-q*y1;
            y1 = oldY0.subtract(q.multiply(y1));
            //Break when b is Zero to permit divided by Zero
            if(b.compareTo(BigInteger.ZERO) == 0) break;
            q = a.divide(b);
            r = a.mod(b);
        }

        return y0;
    }

    /**
     * Returns the value of the private key
     * @return privateKey
     */
    public RSAKey getPrivateKey() {
        return privateKey;
    }

    /**
     * Returns the value of the public key
     * @return publicKey
     */
    public RSAKey getPublicKey() {
        return publicKey;
    }
}
