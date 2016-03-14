package RSA;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by Tobias on 10.03.2016.
 * 2nd Developer Janis Angst
 */
public class Prime {
    public BigInteger prime1;
    public BigInteger prime2;
    public BigInteger n;

    /**
     * Prime Constructor
     *
     * Creates two prime numbers and multiplies it
     */
    public Prime() {
        Random random = new Random();

        do {
            prime1 = new BigInteger(KeyGenerator.bigIntSize, 1, random);
            prime2 = new BigInteger(KeyGenerator.bigIntSize, 1, random);
        } while (prime1.compareTo(prime2) == 0);

        n = prime1.multiply(prime2);
    }

}
