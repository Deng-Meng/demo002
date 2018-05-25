package com.dm.demo002.uitl.random;

import java.util.Random;

public class Code {
    public static String getCodeTest(){
        String randText = "1234567890";
        Random random = new Random();

        StringBuffer buffer = new StringBuffer();

        for (int i = 1; i <= 6; i++) {
            int index = random.nextInt(randText.length());
            buffer.append(randText.charAt(index));
        }

        String code=buffer.toString();

        return code;
    }
}

