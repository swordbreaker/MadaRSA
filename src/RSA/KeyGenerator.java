package RSA;

import java.math.BigInteger;
import java.util.Random;

public class KeyGenerator {
    private RSAKey publicKey;
    private RSAKey privateKey;

    public static int bigIntSize = 32; //1024

    public KeyGenerator() {
        Random random = new Random();
        Prime prime = new Prime();
        BigInteger e = new BigInteger(bigIntSize, random);
        BigInteger phiN = phi(prime.prime1, prime.prime2);

        System.out.printf("Prim1: %d \n", prime.prime1);
        System.out.printf("Prim2: %d \n", prime.prime2);
        System.out.printf("Phi N: %d \n", phiN);

        BigInteger d = extendedEuclidean(phiN, e);

        privateKey = new RSAKey(prime.n, d);
        publicKey = new RSAKey(prime.n, e);
    }

    public static BigInteger phi(BigInteger p, BigInteger q) {
        //(p - 1)*(q - 1)
        return (p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)));
    }

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
            if(b.compareTo(BigInteger.ZERO) == 0) continue;
            q = a.divide(b);
            r = a.mod(b);
        }

        return y0;
    }

    public RSAKey getPrivateKey() {
        return privateKey;
    }

    public RSAKey getPublicKey() {
        return publicKey;
    }
}
