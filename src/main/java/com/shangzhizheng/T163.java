package com.shangzhizheng;

import com.sun.corba.se.spi.ior.iiop.IIOPFactories;
import com.sun.xml.internal.ws.util.exception.LocatableWebServiceException;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther wuqiong
 * @date 2021/12/18
 * @time 14:26
 * @description 缺失的空间
 */
public class T163 {

//    输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
//    输出: ["2", "4->49", "51->74", "76->99"]


    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> re = new ArrayList<>();
        long pre = lower-1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]-pre ==2 ) re.add(String.valueOf(pre+1));
            else if (nums[i]-pre>=2) re.add((pre+1)+"->"+(nums[i]-1));
            pre = nums[i];
        }
        //循环完毕之后还有可能情况
        if (upper-pre==1) {
            re.add(String.valueOf(upper));
        }
        if (upper-pre>1){
            re.add((pre + 1) + "->" + upper);
        }
        return re;
    }



    public List<String> findMissingRanges1(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        long pre = (long)lower - 1; // prevent 'int' overflow
        for (int i = 0; i < nums.length; i++) {
            // 12 - 20   -> 11  13
            //    输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
            //    输出: ["2", "4->49", "51->74", "76->99"]
            if (nums[i] - pre == 2) res.add(String.valueOf(pre + 1));  //插入一个元素的时候
            else if (nums[i] - pre > 2) res.add((pre + 1) + "->" + (nums[i] - 1)); //插入超过一个元素的时候
            pre = nums[i]; // 'int' to 'long' // 否则就是pre变化到3 这时候num已经+1了
        }
        //1 的时候  -> 加入最后一个
        if (upper - pre == 1) res.add(String.valueOf(pre + 1));
        else if (upper - pre > 1) res.add((pre + 1) + "->" + upper);
        return res;
    }


}
