package com.myjava.logic;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class WordCount {

    public static void main(String[] args) {
        String input = "This is a test 11 22$55#22,is,a, ,, abc efg";
        
//      .collect(Collectors.toMap(Map.Entry<String,Long>::getKey, Map.Entry<String,Long>::getValue))
//      .entrySet()
//      .stream()
        
        Arrays.asList(input.split("\\W+"))
         .stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet()
        .stream()
        .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue())) 
        .map(e -> new String(e.getKey() + ":" + e.getValue()))
        .forEach(System.out::println);
        
        
        System.out.println("~~~~~~~INtStream~~~~~~~");
        IntStream.range(1, 10)
                        .filter(i -> i%2 == 0)
                        .forEach(System.out::println);
        
        System.out.println("~~~~~~~infinite stream~~~~~~~");
//                        .limit(4)
//                  .noneMatch(i -> i > 6) );
        //~~~~~
        
        Stream.iterate(1, e -> e+1)
                .filter(e -> e %2 == 0)
                .limit(10)
                .forEach(System.out::println);
        
        
    }

}
