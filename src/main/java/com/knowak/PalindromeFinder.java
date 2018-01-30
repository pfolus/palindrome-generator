package com.knowak;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

public class PalindromeFinder {

    private List<Integer> primes;
    private List<Integer> primesCopy;
    private HashMap<Long, int[]> palindromes = new HashMap<Long, int[]>();

    public PalindromeFinder(List<Integer> primes) {
        this.primes = primes;
        this.primesCopy = primes;
        calculatePalindromes();
    }

    public void calculatePalindromes() {

        ListIterator<Integer> iterator = this.primes.listIterator(this.primes.size());

        while(iterator.hasPrevious()) {
            int current = iterator.previous();
            ListIterator<Integer> copiesIterator = this.primesCopy.listIterator(this.primesCopy.size());

            while(copiesIterator.hasPrevious()) {
                int copiesCurrent = copiesIterator.previous();

                if(isProductPalindrome(current, copiesCurrent)) {

                    long palindrome = (long) current * copiesCurrent;
                    int[] factors = {current, copiesCurrent};
                    this.palindromes.put(palindrome, factors);
                }
            }
        }
    }

    private boolean isProductPalindrome(int first, int second) {

        long product = (long) first * second;
        String productString = String.valueOf(product);
        String reversedString = new StringBuilder(productString).reverse().toString();

        return productString.equals(reversedString);
    }

    public long getMaxPalindrome() {

        return Collections.max(this.palindromes.keySet());
    }

    public int[] getFactors() {
        return this.palindromes.get(getMaxPalindrome());
    }
}
