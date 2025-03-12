package edu.miracosta.cs113.change;

import java.util.ArrayList;
import java.util.List;

public class ChangeCalculatorLinear extends ChangeCalculator {
    public static List<String> calculateLinear(int cents) {
        List<String> combinations = new ArrayList<String>();

        // Iterate over the number of quarters
        for (int q = 0; q <= cents / COINS[Quarter]; q++) {
            // Iterate over the number of dimes
            for (int d = 0; d <= (cents - q * COINS[Quarter]) / COINS[Dime]; d++) {
                // Iterate over the number of nickels
                for (int n = 0; n <= (cents - q * COINS[Quarter] - d * COINS[Dime]) / COINS[Nickel]; n++) {
                    // Calculate the number of pennies
                    int p = cents - q * COINS[Quarter] - d * COINS[Dime] - n * COINS[Nickel];

                    // If the remaining amount is valid (i.e., a non-negative number of pennies)
                    if (p >= 0) {
                        String combination = combinationToString(q, d, n, p);
                        combinations.add(combination);
                    }
                }
            }
        }
        // n/25 * (n/10 - n/25) * (n/5 - n/10 - n/25) * 1
        // n/25 * (5n/50-2n/50) * (10n/50-5n/50-2n/50) * 1
        // n/25 * 3n/50 * 3n/50 * 1
        // n/25 * 9n^2/2500 * 1
        // 9n^3/62500
        // O(n^3)

        return combinations;
    }
}
