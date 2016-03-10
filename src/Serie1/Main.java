package Serie1;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by Tobias on 27.02.2016.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(multiplyTwoRandPrim());
    }

    private static double multiplyTwoRandPrim() {
        Random random = new Random();
        BigInteger bigInt = new BigInteger(1024, 1, random);
        BigInteger bigInt2 = new BigInteger(1024, 1, random);
        bigInt.multiply(bigInt2);

        return bigInt.doubleValue();
    }

/*    private static int getRandomPrim() {
        int min = 1024;
        int max = 2047;

        Random random = new Random();
        int number = 0;

        while (!isPrim(number)) {
            number = min + random.nextInt(max - min + 1);
        }
        return number;
    }

    private static boolean isPrim(int n) {
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }*/
}
