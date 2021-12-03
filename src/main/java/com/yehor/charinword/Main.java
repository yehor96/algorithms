package com.yehor.charinword;

public class Main {
    public static void main(String[] args) {
        CharUtil charUtil = new CharUtil();

        int i = charUtil.getOccurrences("information", 'i');
        System.out.println(i);

        i = charUtil.getOccurrences("information", 'o');
        System.out.println(i);

        i = charUtil.getOccurrences("information", 'o');
        System.out.println(i);

        i = charUtil.getOccurrences("information", 'r');
        System.out.println(i);

        i = charUtil.getOccurrences("integration", 'i');
        System.out.println(i);


    }
}
