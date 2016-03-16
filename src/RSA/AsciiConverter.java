package RSA;

import java.io.UnsupportedEncodingException;
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
        //try {
            //return s.getBytes("US-ASCII");
           // return s.getBytes("UTF-16");
            return s.getBytes(StandardCharsets.ISO_8859_1);
      //  } catch (UnsupportedEncodingException e) {
      //  }

      //  return null;
    }

    /**
     * Converts the Bytes into a text
     *
     * @param bytes converted Bytes
     * @return Converted Bytes in string
     */
    public static String convertToString(byte[] bytes) {
      //  try {
            //return new String(bytes, "US-ASCII");
            //return new String(bytes, "UTF-16");
            return new String(bytes, StandardCharsets.ISO_8859_1);
      //  } catch (UnsupportedEncodingException e) {
      //  }

      //  return null;
    }
}
