package com.shangzhizheng;

/**
 * @auther wuqiong
 * @date 2021/12/18
 * @time 13:48
 * @description  相隔为 1的编辑距离
 */
public class T161 {

    public static void main(String[] args) {
//        System.out.println("".charAt(0));
        System.out.println(new T161().isOneEditDistance("a", ""));
    }

    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length()- t.length()) >= 2){
            return false;
        }
        if (s.length()- t.length()>0){
            return isOneEditDistance(t,s);
        }
        // 这个时候s.len < t .len
        //遍历
        System.out.println(s.length());
        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) != t.charAt(i))
             if (s.charAt(i) != t.charAt(i)){
                 int n = s.length()-t.length();
                 if (n==0){
                     return bianli(s.substring(i+1),t.substring(i+1));
                 }
                 else {
                     return bianli(s.substring(i),t.substring(i+1));
                 }
             }
        }

//        如果所有的比对完成之后这个时候应该就是true
        return (s.length() + 1 == t.length());
    }

    public boolean bianli(String s, String t){
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
            return false;
            }
        }
        return true;
    }

    /**
     * 官方答案
     */
//数字逻辑的来解答接到过
    public boolean isOneEditDistance1(String s, String t) {
        int ns = s.length();
        int nt = t.length();

        // Ensure that s is shorter than t.
        if (ns > nt)
            return isOneEditDistance1(t, s);

        // The strings are NOT one edit away distance
        // if the length diff is more than 1.
        if (nt - ns > 1)
            return false;

        for (int i = 0; i < ns; i++)
            if (s.charAt(i) != t.charAt(i))
                // if strings have the same length
                if (ns == nt)
                    return s.substring(i + 1).equals(t.substring(i + 1));
                    // if strings have different lengths
                else
                    return s.substring(i).equals(t.substring(i + 1));

        // If there is no diffs on ns distance
        // the strings are one edit away only if
        // t has one more character.
        return (ns + 1 == nt);
    }


}
