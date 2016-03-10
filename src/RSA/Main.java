package RSA;

import java.io.*;

/**
 * Created by Tobias on 10.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        KeyGenerator keyGenerator = new KeyGenerator();
        System.out.printf("n: %d \n", keyGenerator.getPrivateKey().n);
        System.out.printf("d: %d \n", keyGenerator.getPrivateKey().ed);

        System.out.printf("e: %d \n", keyGenerator.getPublicKey().ed);

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

        try(  PrintWriter out = new PrintWriter( "ek.txt" )  ){
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
