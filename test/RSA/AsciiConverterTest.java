package RSA;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tobias on 14.03.2016.
 */
public class AsciiConverterTest {

    @Test
    public void testConvert() throws Exception {
        String value = "Test String";
        byte[] bytes = AsciiConverter.ConvertToByte(value);
        String result = AsciiConverter.convertToString(bytes);

        Assert.assertEquals("Test String", result);
    }
}