package me.else_junsuk.junseclibrary.stringsapi;

import java.text.DecimalFormat;
import java.util.Random;

public class C {

    /**
     * Double형태의 소수를 #.##으로 포멧합니다. ex) 1.23456... -> 1.23
     */
    public static DecimalFormat doubleFormatter = new DecimalFormat("#.##");
    public static DecimalFormat doubleP3Formatter = new DecimalFormat("#.###");

    public static Double doubleFormat(double doub) {
        return Double.parseDouble(doubleFormatter.format(doub));
    }

    public static Double doubleP3Format(double doub) {
        return Double.parseDouble(doubleP3Formatter.format(doub));
    }

    /**
     * 파라미터 min~max사이의 정수 형태의 난수를 생성합니다.
     * @param min
     * @param max
     * @return int
     */
    public static int randomInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
