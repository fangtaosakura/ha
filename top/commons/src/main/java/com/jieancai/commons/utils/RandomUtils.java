package com.jieancai.commons.utils;

import java.util.Random;

public class RandomUtils {

    // 去掉Oo和1l
    //public static final String SEEDS = "ABCDEFGHIGKLMNPQRSTUVWXYZ023456789abcdefghigkmnpqrstuvwxyz";

    private static final char[] SEEDS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'G', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'g', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static String genRandomNumbers(int size) {
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            sb.append(r.nextInt(10));
        }
        return sb.toString();
    }

    /**
     * 随机数字和字符<br/>
     *
     * @param length
     * @return
     * @since JDK 1.8
     */
    public static String genRandomChars(int length) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(SEEDS[r.nextInt(SEEDS.length)]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(genRandomChars(8));
    }
}
