package com.controller.bootweb.demo.dsa;

import java.math.BigDecimal;

public class SqrtExample {

    public static double sqrtWithPrecision(double number, int precision) {
        double result = Math.sqrt(number);
        BigDecimal bd = new BigDecimal(result);
        bd = bd.setScale(precision, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }

    public static void main(String[] args) {
        double number = 25;
        int precision = 6;
        double result = sqrtWithPrecision(number, precision);
        System.out.printf("The square root of %.2f is approximately %.6f%n", number, result);
    }
}
