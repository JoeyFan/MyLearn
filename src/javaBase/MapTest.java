package javaBase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by joey on 14-10-27.
 * 测试hashmap put null key的情况
 */
public class MapTest {

    private static void doXxxx(int a){
        a=a+'Z';
    }

    public static void main(String argus[]){
        int a='a';
       doXxxx(a);
        System.out.println(a);
    }
}
