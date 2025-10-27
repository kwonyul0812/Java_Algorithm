package ch06;

import java.util.Arrays;

public class RodCutting {
    public static void main(String[] args) {
        RodCutting rc = new RodCutting();
        int[] priceArray = {2, 5, 9, 10};
        int size = priceArray.length;
        int maxPriceDC = rc.cutRod_DC(priceArray, size);
        System.out.println("DC maxPrice : " + maxPriceDC);

        int maxPriceDP = rc.cutRod_DP(priceArray, size);
        System.out.println("DP maxPrice : " + maxPriceDP);

    }

    private int cutRod_DP(int[] p, int i) {
        int[] maxSell = new int[i + 1];
        maxSell[0] = 0;
        for (int j = 0; j <= i; j++) {
            int maxVal = 0;
            for (int k = 1; k <= j; k++) {
                maxVal = Math.max(maxVal, p[k - 1] + maxSell[j - k]);
            }
            maxSell[j] = maxVal;
            Arrays.stream(maxSell).forEach(n -> System.out.printf("%5d", n));
            System.out.println();
        }
        return maxSell[i];
    }


    private int cutRod_DC(int[] p, int i) {
        if (i == 0) {
            return 0;
        } else {
            int maxSell = 0;
            for (int j = 1; j <= i; j++) {
                maxSell = Math.max(maxSell, p[j - 1] + cutRod_DC(p, i - j));
            }
            return maxSell;
        }
    }
}
