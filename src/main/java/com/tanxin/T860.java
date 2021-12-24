package com.tanxin;

import sun.text.resources.cldr.es.FormatData_es_419;

/**
 * @auther wuqiong
 * @date 2021/12/10
 * @time 16:46
 * @description
 */
public class T860 {

    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {

            if (bill == 5) {
                //收取5元
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
//                收取是10元
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
//                    优先10+5
                    five--;
                    ten--;
                } else if (five >= 3) {
//                    次之减小5 5 5
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;


    }
}
