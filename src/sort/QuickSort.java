package sort;

/**
 * 快速排序
 * 1. 基本思想：
 * 　　在当前无序区R[1..H]中任取一个数据元素作为比较的"基准"(不妨记为X)，用此基准将当前无序区划分为左右两个较小的无序区：R[1..I-1]和R[I+1..H]，
 * 且左边的无序子区中数据元素均小于等于基准元素，右边的无序子区中数据元素均大于等于基准元素，而基准X则位于最终排序的位置上，
 * 即R[1..I-1]≤X.Key≤R[I+1..H](1≤I≤H)，当R[1..I-1]和R[I+1..H]均非空时，分别对它们进行上述的划分过程，直至所有无序子区中的数据元素均已排序为止。
 * 2. 排序过程：
 * 【示例】：
 * 初始关键字  ［49 38 65 97 76 13 27 49］
 * 一趟排序之后 ［27 38 13］ 49 ［76 97 65 49］
 * 二趟排序之后 ［13］ 27 ［38］ 49 ［49 65］76 ［97］
 * 三趟排序之后 13 27 38 49 49 ［65］76 97
 * 最后的排序结果 13 27 38 49 49 65 76 97
 * 各趟排序之后的状态
 */
public class QuickSort {
    public static void main(String argus[]) {
        Integer[] intgArr = {5, 9, 1, 4, 2, 6, 3, 8, 0, 7};
        Utils.printIntArry(Out.Before, intgArr);
        quickSort(intgArr, 0, intgArr.length - 1);
        Utils.printIntArry(Out.After,intgArr);
    }

    //递归查找
    private static void quickSort(Integer[] intArr, int begin, int end) {
         /*
             * 以pivot为边界，把数组分成三部分[low, pivot - 1]、[pivot]、[pivot + 1, high]
             * 其中[pivot]为枢纽元素，不需处理，再对[low, pivot - 1]与[pivot + 1, high]
             * 各自进行分区排序整理与进一步分区
             */
        int middle=getMiddleIndex(intArr,begin,end);
        //System.out.println(middle+"-------------------");
        if (begin < end) {
            quickSort(intArr, begin,middle-1);
            quickSort(intArr,middle+1,end);
        }
    }

    /**
     * 重点方法
     * @param intArr
     * @param begin
     * @param end
     * @return
     */
    private static int getMiddleIndex(Integer intArr[],int begin,int end){
        int pivot=intArr[begin];
        while (begin<end){
            //System.out.println("ing");
            while(begin<end&&intArr[end]>=pivot)
                end--;
            intArr=Utils.swap(intArr,begin,end);

            while(begin<end&&intArr[begin]<=pivot) {
                begin++;
            }
            intArr=Utils.swap(intArr,begin,end);

        }
        return begin;
    }

}
