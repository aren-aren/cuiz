package com.groupb.cuiz.web.quiz;

import java.util.Arrays;

public enum QuizEnum {
    Lv1( 2, 1 ),Lv2( 5, 3 ),Lv3( 10, 5),Lv4( 15, 7),Lv5( 20,9);


    QuizEnum(int jumsu, int price) {
        this.jumsu = jumsu;
        this.price = price;
    }

    private final int jumsu;
    private final int price;

    public int getJumsu() {
        return jumsu;
    }

    public int getPrice() {
        return price;
    }

    /**
     * level에 따라 해당하는 QuizEnum을 리턴
     * @param level
     * @return
     */
    public static QuizEnum get(int level){
        return values()[level-1];
    }

}
