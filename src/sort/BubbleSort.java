package sort;

/**
 * 冒泡排序
 1.基本思想：
 　　两两比较待排序数据元素的大小，发现两个数据元素的次序相反时即进行交换，直到没有反序的数据元素为止。
 2. 排序过程：
 　　设想被排序的数组R［1..N］垂直竖立，将每个数据元素看作有重量的气泡，根据轻气泡不能在重气泡之下的原则，从下往上扫描数组R，凡扫描到违反本原则的轻气泡，就使其向上"漂浮"，
    如此反复进行，直至最后任何两个气泡都是轻者在上，重者在下为止。
 示例：（垂直看）
 49 13 13 13 13 13 13 13
 38 49 27 27 27 27 27 27
 65 38 49 38 38 38 38 38
 97 65 38 49 49 49 49 49
 76 97 65 49 49 49 49 49
 13 76 97 65 65 65 65 65
 27 27 76 97 76 76 76 76
 49 49 49 76 97 97 97 97
 3.个人理解：执行完一次内for循环后，最小的一个数放到了数组的最前面，（元素是进行两两比较）
 */
public class BubbleSort {
    public static void main(String args[]){
        Integer[] intgArr = { 7, 2, 4, 3, 12, 1, 9, 6, 8, 5, 11, 10};
        Utils.printIntArry(Out.Before,intgArr);

        /*for(int i=0;i<intgArr.length-1;i++){//注意：这里i<intgArr.length-1
            for(int j=i+1;j<intgArr.length;j++){
                if(intgArr[i]>intgArr[j]){
                    Integer temp=new Integer(intgArr[i]);
                    intgArr[i]=intgArr[j];
                    intgArr[j]=temp;
                }
                //Utils.printIntArry(Out.ING,intgArr);
            }
        }*/
        for(int i=0;i<intgArr.length;i++) {
           for (int j=intgArr.length-1;j>0;j--){
                    if(intgArr[j]<intgArr[j-1]){
                      int temp=intgArr[j-1];
                        intgArr[j-1]=intgArr[j];
                        intgArr[j]=temp;
                    }
           }
        }
        Utils.printIntArry(Out.After,intgArr);
    }
}
