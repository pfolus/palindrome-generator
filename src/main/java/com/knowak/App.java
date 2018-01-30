package com.knowak;


import java.util.concurrent.TimeUnit;

public class App
{

    public static void main( String[] args ) {
        long startTime = System.nanoTime();

        System.out.println("Calculating...");
        PrimesGenerator fiveDigitPrimes = new PrimesGenerator();
        PalindromeFinder finder = new PalindromeFinder(fiveDigitPrimes.getCollection());
        long result = finder.getMaxPalindrome();
        int[] factors = finder.getFactors();

        long endTime = System.nanoTime();
        System.out.println("Result: " + result);
        System.out.println("Factors: " + factors[0] + " " + factors[1]);
        System.out.println("calculation time: " +
                TimeUnit.NANOSECONDS.toSeconds(endTime - startTime) + " sec");

    }
}
