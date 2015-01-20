package sort;

/**
 * Created by joey on 14-10-16.
 */
public class Utils {

    public static void printIntArry(Out out,Integer[] intArr){
        if(intArr==null||intArr.length==0){
            System.out.println("数组为空");
        }
        System.out.print(out.getValue());
        for (Integer i:intArr){
            System.out.print(" "+i);
        }
        System.out.println("");
    }

    public static Integer[] swap(Integer []intArr,int i,int j){
        Integer temp=new Integer(intArr[i]);
        intArr[i]=intArr[j];
        intArr[j]=temp;
        return intArr;
    }
}



enum Out{
    Before("排序前:"),ING("   排序中"),After("排序后:");
    private String value;
    private Out(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
