package RSA;

import com.sun.nio.sctp.AssociationChangeNotification;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * Created by Tobias on 10.03.2016.
 * 2nd Developer Janis Angst
 * <p>
 * This Program creates a RSA-keys
 */
public class Main {
    /**
     * Main method for the RSA-Key
     *
     * @param args
     */
    public static void main(String[] args) {
        //generateKey();
        //encrypt();
        decrypt();
    }

    private static void generateKey() {
        // Generates the two keys.
        KeyGenerator keyGenerator = new KeyGenerator();

        // Writes the private key into the sk.txt file
        FileManager.writeKeyToFile(keyGenerator.getPrivateKey(), "sk.txt");

        // Writes the public key into the pk.txt file
        FileManager.writeKeyToFile(keyGenerator.getPublicKey(), "pk.txt");
    }

    private static void encrypt() {
        RSAKey key = FileManager.readKeyFromFile("pk.txt");
        String message = FileManager.readFile("text.txt");
        byte[] messageBytes = AsciiConverter.ConvertToByte(message);
        BigInteger[] encrypted = key.encrypt(messageBytes);

        FileManager.writeToFile("chiffre.txt", encrypted);
    }

    private static void decrypt() {
        RSAKey key = FileManager.readKeyFromFile("sk.txt");
        BigInteger[] bis = FileManager.readBigIntArrayFromFile("chiffre.txt");
        byte[] bytes = key.decrypt(bis);
        System.out.println(AsciiConverter.convertToString(bytes));
    }
}
