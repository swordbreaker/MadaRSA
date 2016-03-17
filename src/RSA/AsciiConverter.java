package RSA;

import java.nio.charset.StandardCharsets;

/**
 * Created by Tobias Bollinger on 10.03.2016.
 * 2nd Developer Janis Angst
 */
public class AsciiConverter {

    /**
     * Converts the string text into Bytes
     *
     * @param s Text as String
     * @return Converted string in Bytes
     */
    public static byte[] ConvertToByte(String s) {
            return s.getBytes(StandardCharsets.ISO_8859_1);
    }

    /**
     * Converts the Bytes into a text
     *
     * @param bytes converted Bytes
     * @return Converted Bytes in string
     */
    public static String convertToString(byte[] bytes) {
            return new String(bytes, StandardCharsets.ISO_8859_1);
    }
}
