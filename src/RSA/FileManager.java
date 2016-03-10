package RSA;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Tobias on 10.03.2016.
 */
public class FileManager {

    public static void writeKeyToFile(RSAKey key, String file)
    {
        try(  PrintWriter out = new PrintWriter(file)  ){
            out.print("(");
            out.print(key.n);
            out.print(",");
            out.print(key.ed);
            out.print(")");
        }
        catch (IOException e)
        {
            System.out.println("Hallo ERROR");
        }
    }

    public static String readFile(String file)
    {
        StringBuilder sb = new StringBuilder();
        try(FileReader fileReader = new FileReader(file))
        {
            int charCode;
            while ((charCode = fileReader.read()) != -1)
            {
                sb.append((char)charCode);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
