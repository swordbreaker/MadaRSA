package RSA;

import java.math.BigInteger;

/**
 * Created by Tobias Bollinger on 10.03.2016.
 * 2nd Developer Janis Angst
 *
 * This Program creates a RSA-keys
 */
public class Main {
    /**
     * Main method for the RSA-Key
     *
     * @param args
     */
    public static void main(String[] args) {
        generateKey();
        encrypt();
        decrypt();
    }

    /**
     * Generates two keys and safes each key in the specific textfile
     */
    private static void generateKey() {
        // Generates the two keys.
        KeyGenerator keyGenerator = new KeyGenerator();

        // Writes the private key into the sk.txt file
        FileManager.writeKeyToFile(keyGenerator.getPrivateKey(), "sk.txt");

        // Writes the public key into the pk.txt file
        FileManager.writeKeyToFile(keyGenerator.getPublicKey(), "pk.txt");
    }

    /**
     * Encrypts the content from the file with the public key and safes it into an other file.
     */
    private static void encrypt() {
        RSAKey key = FileManager.readKeyFromFile("pk.txt");
        String message = FileManager.readFile("text.txt");
        byte[] messageBytes = AsciiConverter.ConvertToByte(message);
        BigInteger[] encrypted = key.encrypt(messageBytes);

        FileManager.writeToFile("chiffre.txt", encrypted);
    }

    /**
     * Decrypts the content from the encrypted file with the private key.
     */
    private static void decrypt() {
        RSAKey key = FileManager.readKeyFromFile("sk.txt");
        BigInteger[] bis = FileManager.readBigIntArrayFromFile("chiffre.txt");
        byte[] bytes = key.decrypt(bis);
        System.out.println(AsciiConverter.convertToString(bytes));
    }
}
