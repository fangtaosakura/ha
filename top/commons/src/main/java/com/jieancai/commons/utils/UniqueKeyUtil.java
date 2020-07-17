package com.jieancai.commons.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class UniqueKeyUtil {

    /**
     * 根据时间生成标识号
     *
     * @return
     */
    public static String genRandom(String prefix) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ssSSS");
        String newDate = LocalDateTime.now(ZoneOffset.of("+8")).format(formatter);
        String orderNum = prefix + newDate + RandomUtils.genRandomNumbers(2)+RandomUtils.genRandomNumbers(2);
        return orderNum;
    }

    /**
     * 根据时间coupon码
     *
     * @return
     */
    public static String genSixRandom() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ssSSS");
        String newDate = LocalDateTime.now(ZoneOffset.of("+8")).format(formatter);
        return newDate + RandomUtils.genRandomNumbers(1)+RandomUtils.genRandomNumbers(2);

    }

    public static void main(String[] args) {
        System.out.println(genSixRandom());
    }
}
