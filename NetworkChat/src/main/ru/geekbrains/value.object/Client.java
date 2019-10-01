package com.company.value.object;

import java.time.LocalDate;

public class Client {
    public static void main(String[] args) {
//        Vector2 vec1 = new Vector2(1,1);
//        Vector2 res = vec1
//                .add(new Vector2(4,3))
//                .mul(-3)
//                .add(new Vector2(-3, -4));
//
//        System.out.println("res = " + res);
//        System.out.println("vec1 = " + vec1);

        LocalDate date = LocalDate.now();
        LocalDate date1 = date.plusDays(24);
        LocalDate date2 = date.plusYears(7);

        System.out.println("date = " + date);
        System.out.println("date in a 24 days = " + date1);
        System.out.println("date in 7 years = " + date2);




    }
}
