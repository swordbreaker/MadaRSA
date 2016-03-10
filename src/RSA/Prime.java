package RSA;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by Tobias on 10.03.2016.
 */
public class Prime {
    public BigInteger prime1;
    public BigInteger prime2;
    public BigInteger n;

    public Prime() {
        Random random = new Random();

        do {
            prime1 = new BigInteger(KeyGenerator.bigIntSize, random);
            prime2 = new BigInteger(KeyGenerator.bigIntSize, random);
        } while (prime1.compareTo(prime2) == 0);

        n = prime1.multiply(prime2);
    }

}
