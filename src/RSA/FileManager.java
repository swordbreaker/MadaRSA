package RSA;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Tobias on 10.03.2016.
 */
public class FileManager {

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

    public static RSAKey readKeyFromFile(String file) {
        StringBuilder n = new StringBuilder();
        StringBuilder ed = new StringBuilder();
        boolean isN = false;
        boolean isEd = false;

        try (FileReader fileReader = new FileReader(file)) {
            int charCode;
            while ((charCode = fileReader.read()) != -1) {

                if ((char) charCode == ')') break;

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

    public static void writeToFile(String file, String message) {
        try (PrintWriter out = new PrintWriter(file)) {
            out.print(message);
        } catch (IOException e) {
            System.out.println("Hallo ERROR");
        }
    }

    public static void writeToFile(String file, BigInteger[] bis) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bis.length; i++) {
            BigInteger bi = bis[i];
            sb.append(bi);
            if (i < bis.length - 1) sb.append(",");
        }
        writeToFile(file, sb.toString());
    }

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
