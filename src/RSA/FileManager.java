package RSA;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Tobias Bollinger on 10.03.2016.
 * 2nd Developer Janis Angst
 */
public class FileManager {

    /**
     * Writes the prime number and public or private key into a file.
     *
     * @param key the public/private key.
     * @param file name of file in which the key should be saved.
     */
    public static void writeKeyToFile(RSAKey key, String file) {
        try (PrintWriter out = new PrintWriter(file)) {
            out.print("(");
            out.print(key.n);
            out.print(",");
            out.print(key.ed);
            out.print(")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads the prime number and public/private key from a file.
     *
     * @param file path to file, where prime number and public/private key is.
     * @return returns the prime number and private/public key.
     */
    public static RSAKey readKeyFromFile(String file) {
        StringBuilder n = new StringBuilder();
        StringBuilder ed = new StringBuilder();
        boolean isN = false;
        boolean isEd = false;

        try (FileReader fileReader = new FileReader(file)) {
            int charCode;
            while ((charCode = fileReader.read()) != -1) {

                // Check if the current char is a closing bracket
                if ((char) charCode == ')') break;

                // Check if the current char is a comma. The next char will be the start of the "ed"-number
                if ((char) charCode == ',') {
                    isN = false;
                    isEd = true;
                    continue;
                }

                if (isN) {
                    n.append((char) charCode);
                } else if (isEd) {
                    ed.append((char) charCode);
                }
                // Check if the current char is opening bracket. The next char will be the start of the "n"-number
                if ((char) charCode == '(') {
                    isN = true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new RSAKey(new BigInteger(n.toString()), new BigInteger(ed.toString()));
    }

    /**
     * Reads a file and returns the content.
     *
     * @param file path to the file.
     * @return content of file.
     */
    public static String readFile(String file) {
        StringBuilder sb = new StringBuilder();
        try (FileReader fileReader = new FileReader(file)) {
            int charCode;
            while ((charCode = fileReader.read()) != -1) {
                sb.append((char) charCode);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    /**
     * Writes the string into a file
     *
     * @param file path to the file
     * @param message string with the message
     */
    public static void writeToFile(String file, String message) {
        try (PrintWriter out = new PrintWriter(file)) {
            out.print(message);
        } catch (IOException e) {
            System.out.println("Hallo ERROR");
        }
    }

    /**
     *
     *
     * @param file
     * @param bis
     */
    public static void writeToFile(String file, BigInteger[] bis) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bis.length; i++) {
            BigInteger bi = bis[i];
            sb.append(bi);
            if (i < bis.length - 1) sb.append(",");
        }
        writeToFile(file, sb.toString());
    }

    /**
     * Method to read numbers into Array of BigIntegers
     *
     * @param file path to the file with the BigInteger
     * @return Returns Array with a BigInteger
     */
    public static BigInteger[] readBigIntArrayFromFile(String file) {
        ArrayList<BigInteger> bis = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        try (FileReader fileReader = new FileReader(file)) {
            int charCode;
            while ((charCode = fileReader.read()) != -1) {
                if ((char) charCode == ',') {
                    bis.add(new BigInteger(sb.toString()));
                    sb.setLength(0);
                    continue;
                }
                sb.append((char) charCode);
            }
            sb.append((char) charCode);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bis.toArray(new BigInteger[0]);
    }
}
