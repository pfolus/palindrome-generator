package com.knowak;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class PrimesGenerator {

    private static final int MAX_RANGE = 99999;
    private List collection = new LinkedList<Integer>();

    public PrimesGenerator() {
        generateInitialCollection();
        filterFiveDigitPrimes();

    }

    private boolean hasNotFiveDigits(int number) {
        // check if given number is 5 digit

        int length = String.valueOf(number).length();

        return (length != 5);
    }

    private void generateInitialCollection() {
        // generates <2;99999> integer collection

        for (int i=2; i <= this.MAX_RANGE; i++) {
            this.collection.add(i);
        }
    }

    public List<Integer> getCollection() {
        return this.collection;
    }

    private void filterFiveDigitPrimes() {
        // using Sieve of Eratosthenes algorithm,
        // starting with calculating sqrt(9999) which is max
        // range of first iteration.
        double sqrt = Math.sqrt(this.MAX_RANGE);
        // rounding sqrt(9999) up to the next integer value
        int n = (int) Math.ceil(sqrt);

        // iterating through collection and removing multiplications of i as non-primes.
        for(int i = 2; i <= n; i++) {
            ListIterator<Integer> iterator = this.collection.listIterator();
            while(iterator.hasNext()) {
                int current = iterator.next();
                if (current % i == 0 && current > i || hasNotFiveDigits(current)) {
                    iterator.remove();
                }
            }
        }


    }
}
