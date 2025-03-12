package edu.miracosta.cs113.change;

import java.util.ArrayList;
import java.util.List;

/**
 * ChangeCalculator : Class containing the recursive method calculateChange, which determines and prints all
 * possible coin combinations representing a given monetary value in cents.
 *
 * Problem derived from Koffman & Wolfgang's Data Structures: Abstraction and Design Using Java (2nd ed.):
 * Ch. 5, Programming Project #7, pg. 291.
 *
 * NOTE: An additional method, printCombinationsToFile(int), has been added for the equivalent tester file to
 * verify that all given coin combinations are unique.
 */
public class ChangeCalculatorRecursive extends ChangeCalculator {

    /**
     * Wrapper method for determining all possible unique combinations of quarters, dimes, nickels, and pennies that
     * equal the given monetary value in cents
     *
     * @param cents a monetary value in cents
     * @return the total number of unique combinations of coins of which the given value is comprised
     */
    public static List<String> calculateRecursive(int cents) {
        // TODO:
        // Implement a recursive solution following the given documentation.
        List<String> combinations = new ArrayList<>();

        calculateChange(cents, combinations, 0, 0, 0, 0, 0);
        return combinations;
    }

        static void calculateChange(int change, List<String> combinations, int q, int d, int n, int p, int coinIndex){

            if (change == 0) {
                String result = combinationToString(q, d, n, p);
                combinations.add(result);
                return;
            }

            if (change < 0 || coinIndex >= COINS.length) {
                return;
            }
            for (int c = 0; c <= change / COINS[coinIndex]; c++) {
                int spent = c * COINS[coinIndex];
                switch (coinIndex){
                    case Quarter: q = c; break;
                    case Dime: d = c; break;
                    case Nickel: n = c; break;
                    case Penny: p = c; break;
                }
                calculateChange(change - spent, combinations, q, d, n, p, coinIndex + 1);
            }
        }
    }
