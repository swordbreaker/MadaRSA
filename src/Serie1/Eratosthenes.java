package Serie1;

/**
 * Created by Tobias on 25.02.2016.
 */
public class Eratosthenes {

    public static void main(String[] args)
    {
        final int MAX_NUMBER = 1000000;

        boolean[] notPrims = new boolean[MAX_NUMBER];

        notPrims[0] = true;
        notPrims[1] = true;

        int primCout = 0;

        for(int i = 2; i*i < notPrims.length; i++) {

            if(notPrims[i] == false) {
                for(int j = 2*i; j < notPrims.length; j += i)
                {
                    notPrims[j] = true;
                }
            }
        }

        for (boolean notPrim : notPrims) {
            if(! notPrim)
                primCout++;
        }

        System.out.println(primCout);
    }
}
