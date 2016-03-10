package RSA;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Created by Tobias on 10.03.2016.
 */
public class KeyGeneratorTest {

    @Test
    public void testPhi() throws Exception {
        BigInteger phi = KeyGenerator.phi(BigInteger.valueOf(2L), BigInteger.valueOf(5L));
        Assert.assertEquals(4, phi.intValue());
    }

    @Test
    public void testExtendedEuclidean() throws Exception {
        BigInteger y0 = KeyGenerator.extendedEuclidean(BigInteger.valueOf(31), BigInteger.valueOf(9));
        Assert.assertEquals(BigInteger.valueOf(7), y0);
    }
}