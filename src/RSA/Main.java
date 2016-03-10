package RSA;

import java.io.*;
import java.util.stream.Stream;

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
        FileManager.writeKeyToFile(keyGenerator.getPrivateKey(), "sk.txt");

        // Writes the public key into the pk.txt file
        FileManager.writeKeyToFile(keyGenerator.getPublicKey(), "pk.txt");

        byte[] bytes = AsciiConverter.ConvertToByte("Hallo Mueter, hallo Vater");
        Stream.of(bytes).forEach(bytes1 -> System.out.print(bytes1));
        System.out.println("\n");
        System.out.println(AsciiConverter.convertToString(bytes));
    }
}
