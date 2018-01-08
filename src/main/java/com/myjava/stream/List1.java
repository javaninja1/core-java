package com.myjava.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class List1 {

    public static void main(String[] args) {
        int[][] arr= {{1,2}, {3,4},{13,4},{33,4}};
        sum(arr);
    }

    static void sum (int[][] ar ) {
        List<List<Integer>> listOfLists = new ArrayList<>();
        
        Map<Integer,List<Integer>> mapList = new HashMap<>();
        
        for (int i=0; i< ar.length; i++) {
            List<Integer> intList = Arrays.stream(ar[i]).boxed().collect(Collectors.toList());
            listOfLists.add(intList);
            //mapList.put(i, intList);
        }
//        mapList.entrySet().stream()
//        .collect(collector)
        
        listOfLists.parallelStream()
          .mapToInt( e -> e.stream().reduce(Integer::sum).orElse(0))
          .forEach(System.out::println);
        //return Arrays.stream(ar).boxed().mapToInt(i -> i.intValue()).reduce(Integer::sum).orElse(0);
    }
}
