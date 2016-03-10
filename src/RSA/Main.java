package RSA;

import java.io.*;

/**
 * Created by Tobias on 10.03.2016.
 * 2nd Developer Janis Angst
 *
 * This Program creates a RSA-keys
 */
public class Main {
    /**
     * Main method for the RSA-Key
     * @param args
     */
    public static void main(String[] args) {

        // Generates the two keys.
        KeyGenerator keyGenerator = new KeyGenerator();
        System.out.printf("n: %d \n", keyGenerator.getPrivateKey().n);
        System.out.printf("d: %d \n", keyGenerator.getPrivateKey().ed);

        System.out.printf("e: %d \n", keyGenerator.getPublicKey().ed);

        // Writes the private key into the sk.txt file
        try(  PrintWriter out = new PrintWriter( "sk.txt" )  ){
            out.print("(");
            out.print(keyGenerator.getPrivateKey().n);
            out.print(",");
            out.print(keyGenerator.getPrivateKey().ed);
            out.print(")");
        }
        catch (IOException e)
        {
            System.out.println("Hallo ERROR");
        }

        // Writes the public key into the pk.txt file
        try(  PrintWriter out = new PrintWriter( "pk.txt" )  ){
            out.print("(");
            out.print(keyGenerator.getPublicKey().n);
            out.print(",");
            out.print(keyGenerator.getPublicKey().ed);
            out.print(")");
        }
        catch (IOException e)
        {
            System.out.println("Hallo ERROR");
        }
    }
}
