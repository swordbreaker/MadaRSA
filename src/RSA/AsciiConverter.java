package RSA;

import java.io.UnsupportedEncodingException;

/**
 * Created by Tobias on 10.03.2016.
 */
public class AsciiConverter {

    /**
     * @param s
     * @return
     */
    public static byte[] ConvertToByte(String s) {
        try {
            return s.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException e) {
        }

        return null;
    }

    /**
     * @param bytes
     * @return
     */
    public static String convertToString(byte[] bytes) {
        try {
            return new String(bytes, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
        }

        return null;
    }
}
