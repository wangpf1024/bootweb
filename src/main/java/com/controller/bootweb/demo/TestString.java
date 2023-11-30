package com.controller.bootweb.demo;

public class TestString {
    public static void main(String[] args) {
        String str1= "abc";
        String str2= new String("abc");
        String str3= str2.intern();
        System.out.println(str1==str2);
        System.out.println(str2==str3);
        System.out.println(str1==str3);
        System.out.println(str1.hashCode()+"---"+str2.hashCode()+"---"+str3.hashCode());
        System.out.println(16 >>> 2);
        System.out.println(16 - (16 >>> 2) );

        String s1 = new String ("1")+new String("1");
        s1.intern();
        String s2 = "11";
        System.out.println(s1 == s2);

        String s3 = new String ("11");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);

        final int a = 1;
        int b = 2;
        //a = b;
        System.out.println(a);
    }
}
