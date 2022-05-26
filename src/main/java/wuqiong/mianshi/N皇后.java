package wuqiong.mianshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther wuqiong
 * @date 2022/5/15
 * @time 13:49
 * @description
 */
public class N皇后 {
    public static void main(String[] args) {
        N皇后 n皇后 = new N皇后();
         n皇后.solveNQueens(4);
        System.out.println(lists);
        System.out.println(n皇后.count);
    }
    int count=0;
    //写一个N皇后的问题
    int[] col ;
    static  ArrayList<List<String>> lists = new ArrayList<>();
    String[] strings ;
    public List<List<String>> solveNQueens(int n) {
        col = new int[n];
        strings= new String[n];

//        ArrayList<List<Integer>> integers = new ArrayList<>();
        NHH(0);
        return lists;
    }

    public  void NHH(int i){

        if (i >= col.length){
            System.out.println(Arrays.toString(col));
            count ++;
            //这里就是最后的结果
            int length = col.length;
            for (int qq = 0; qq < col.length; qq++) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i1 = 0; i1 < length; i1++) {
                    if (col[qq] ==i1){//1 == i1
                        stringBuffer.append("Q");
                    }else {
                        stringBuffer.append(".");
                    }
                }
                strings[qq] = "\""+ stringBuffer.toString()+"\"";

                System.out.println( Arrays.toString(strings ));

            }
//            List<String> stringsaa = Arrays.asList(this.strings);
            ArrayList<String> stringsaa = new ArrayList<>();
            for (String string11 : strings) {
                stringsaa.add(string11);
            }
            System.out.println("===============");
            System.out.println(Arrays.toString(this.strings));
            System.out.println((stringsaa));
            System.out.println("===============");

            lists.add(stringsaa);


        }else {
//            遍历所有的情况
            for (int j = 0; j < col.length; j++) {
                col[i] = j;
                //如果满足情况就是下一行
                if (check(i)){
                    NHH(i+1);
                }
            }
        }
    }

//    这个是检查的
    public boolean check(int i){
        //检查第i行第j列  是否可以存放这个皇后情况
        for (int j = 0; j < i; j++) {
            if (col[j]  == col[i] || (i-j==Math.abs(col[i]-col[j]))){
                return false;
            }
        }
        return true;
    }



//    static int Max=8;
//    static int a[]=new int[Max];
//    static int count=0;
//
//    public static void main(String[] args){
//        put(0);
//        System.out.println("最多有"+count+"种排序");
//    }
//    public static void print(){
//        count++;
//        for(int i=0;i<Max;i++){
//            System.out.print(a[i]+" ");
//        }
//        System.out.println();
//    }
//
//    public static boolean judge(int n){
//        for(int i=0;i<n;i++){
//            //如果行和列相等的话  或者
//            if(a[n]==a[i] || n-i==Math.abs(a[n]-a[i])){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static void put(int n){
//        //打印完结束
//        if(n == Max){
//            print();
//            return;
//        }
//
//        //i 代表的是列  如果这个for 循环一直没有结束的
//        for(int i=0;i<Max;i++){
//            //放在第一列，，放在第二列
//            a[n]=i;
//            //检测n是否可以放下去
//            if(judge(n)){
//                put(n+1);
//            }
//        }
//    }

}
