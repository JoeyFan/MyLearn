package sort;

/**
 * 选择排序
 * 基本思想：每一趟从待排序的数据元素中选出最小（或最大）的一个元素，顺序放在已排好序的数列的最后，直到全部待排序的数据元素排完。
 2.排序过程
 初始关键字 [49 38 65 97 76 13 27 49]
 第一趟排序后 13 ［38 65 97 76 49 27 49]
 第二趟排序后 13 27 ［65 97 76 49 38 49]
 第三趟排序后 13 27 38 [97 76 49 65 49]
 第四趟排序后 13 27 38 49 [49 97 65 76]
 第五趟排序后 13 27 38 49 49 [97 97 76]
 第六趟排序后 13 27 38 49 49 76 [76 97]
 第七趟排序后 13 27 38 49 49 76 76 [ 97]
 最后排序结果 13 27 38 49 49 76 76 97
 */
public class SelectSort {
    public static void main(String argus[]){
        Integer[] intgArr = { 7, 2, 4, 3, 12, 1, 9, 6, 8, 5, 11, 10 };
        Utils.printIntArry(Out.Before,intgArr);
        for(int i=0;i<intgArr.length-1;i++){
            int minIndex=i;//每次获取的最小值的下标
            for(int j=i+1;j<intgArr.length;j++){
                if(intgArr[minIndex]>intgArr[j].intValue()){
                    minIndex=j;
                }
            }
            //确定了最小值与交换的位置
            if(minIndex!=i){
                Integer temp=new Integer(intgArr[i]);
                intgArr[i]=intgArr[minIndex];
                intgArr[minIndex]=temp;
            }
            //Utils.printIntArry(Out.ING,intgArr);
        }
        Utils.printIntArry(Out.After,intgArr);
    }
}
