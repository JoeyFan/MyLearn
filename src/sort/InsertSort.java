package sort;

/**
 * 插入排序
 1. 基本思想：
 每次将一个待排序的数据元素，插入到前面已经排好序的数列中的适当位置，使数列依然有序；直到待排序数据元素全部插入完为止。
 2. 排序过程：　
 【示例】：
 [初始关键字]
         [49] 38 65 97 76 13 27 49
 J=2(38) [38 49] 65 97 76 13 27 49
 J=3(65) [38 49 65] 97 76 13 27 49
 J=4(97) [38 49 65 97] 76 13 27 49
 J=5(76) [38 49 65 76 97] 13 27 49
 J=6(13) [13 38 49 65 76 97] 27 49
 J=7(27) [13 27 38 49 65 76 97] 49
 J=8(49) [13 27 38 49 49 65 76 97]
 */
public class InsertSort {
    public static void main(String[] argus){
        Integer[] intgArr = { 5, 9, 1, 4, 2, 6, 3, 8, 0, 7 };
        Utils.printIntArry(Out.After,intgArr);
        for(int i=1;i<intgArr.length;i++){
            for(int j=0;j<i;j++){
                if(intgArr[i]<intgArr[j]){
                    Integer temp=new Integer(intgArr[i]);
                    intgArr[i]=intgArr[j];
                    intgArr[j]=temp;
                }
            }
            Utils.printIntArry(Out.ING,intgArr);
        }
        Utils.printIntArry(Out.After,intgArr);
    }
}
