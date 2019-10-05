package com.company.permutation;

public class FunctionalPermutation {


    public static int permute(String s) {
        if (s == null) return 0;
        return permute("", s);
    }

    private static int permute(String c, String r) {


        if (r.length() == 0) {
            System.out.println(c);
            return 1;
        }

        int sum = 0;
        for (int i = 0; i < r.length(); ++i) {
            sum += permute(c + r.charAt(i),
                    r.substring(0, i) + r.substring(i + 1));
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Permutation Count: " + permute("abcd"));
    }
}