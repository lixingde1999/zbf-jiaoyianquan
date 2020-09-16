package com.zbf.common.utils;

import java.util.Random;

/**
 * @author: 冀培银
 * 日期: 2020/9/10 20:01
 * 描述:
 */
public class RanDomUtils {

    public static String getFourRandom(){
        Random random = new Random();
        String fourRandom = random.nextInt(10000) + "";
        int randLength = fourRandom.length();
        if(randLength<4){
            for(int i=1; i<=4-randLength; i++)
                fourRandom = "0"+ fourRandom ;
        }
        return fourRandom;
    }
}
