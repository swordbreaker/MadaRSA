package RSA;

import java.io.UnsupportedEncodingException;

/**
 * Created by Tobias on 10.03.2016.
 */
public class AsciiConverter {

    public static byte[] ConvertToByte(String s)
    {
        try{
            return s.getBytes("US-ASCII");
        }
        catch (UnsupportedEncodingException e){}

        return null;
    }

    public static String convertToString(byte[] bytes)
    {
        StringBuilder sb = new StringBuilder();
        for(byte b : bytes){
            sb.append((char)b);
        }

        return sb.toString();
    }
}
