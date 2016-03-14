package RSA;

import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.requests.SortingRequest;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Created by Tobias on 14.03.2016.
 */
public class RSAKeyTest {

    @Test
    public void testFastPow() throws Exception {
        RSAKey key = new RSAKey(BigInteger.valueOf(11), BigInteger.valueOf(13));
        BigInteger value = key.fastPow(BigInteger.valueOf(7));
        Assert.assertEquals(BigInteger.valueOf(2), value);

        RSAKey key2 = new RSAKey(BigInteger.valueOf(11), BigInteger.valueOf(4));
        BigInteger value2 = key2.fastPow(BigInteger.valueOf(5));
        Assert.assertEquals(BigInteger.valueOf(9), value2);
    }

    @Test
    public void testEncryptDecrypt() throws Exception{
        KeyGenerator kg = new KeyGenerator();
        String msg = "Test Message";
        BigInteger[] encrypted = kg.getPublicKey().encrypt(msg.getBytes());
        byte[] decrypted = kg.getPrivateKey().decrypt(encrypted);

        Assert.assertEquals("Test Message", new String(decrypted));
    }
}