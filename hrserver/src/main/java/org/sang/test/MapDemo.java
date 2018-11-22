package org.sang.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class MapDemo {

    @Test
    public void test(){
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        map1.put("1",10);
        map1.put("2",20);
        map1.put("3",30);

        map1.put("2",22);
        map1.put("3",33);
        map1.put("4",44);

        Map<String,Integer> map3 = new HashMap<>();
        for(String key:list){
            Integer val1 = map1.get(key);
            Integer val2 = map2.get(key);
            if(val1==null){
                val1 = 0;
            }
            if(val2==null){
                val2 = 0;
            }
            map3.put(key,val1-val2);
        }
    }

    public void sort(){
        System.out.printf("sort -- 1");
    }

    public void pop(){
        System.out.printf("pop -- 1");
    }

}
