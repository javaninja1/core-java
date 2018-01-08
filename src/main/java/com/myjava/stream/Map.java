package com.myjava.stream;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.*;


public class Map {
    
    static Consumer<String> print = (s) -> System.out.println(s);
    final static String[] arr1 = {"a","b","c"};
    final static String[] arr2 = {"e","f","g"};
    
    static void printArr(String[] arr) {
        Stream.of(arr)
        .map(String::toUpperCase)
        .collect(Collectors.toList())
        .forEach(print);
    }
    
    static List<String> combine(String[] arr1, String[] arr2) {
        return Stream.of(Arrays.asList(arr1), Arrays.asList(arr2))
                         .flatMap(List::stream)
                         .map(e ->e)
                         .collect(Collectors.toList());
    }
      public static void main(String args[]) {
          

          Stream.of("aa").findFirst();
          
          Supplier<String> a = () -> "hello";
          
          Consumer<String> b = (s) -> System.out.println(s);
          
          //b.accept(( ((Supplier<String>)(() -> "hello")).get() ));
          
          
          ((Consumer<String>) (s) -> System.out.println(s))
            .accept(( ((Supplier<String>)(() -> "hello world"))
                            .get() ));

          Optional.ofNullable(null).orElseGet(() -> "john");
          
          ((Consumer<String>) (s) -> System.out.println(s))
          .accept(( ((Supplier<String>)(() -> 
              Optional.of("aaa").get()
          ))
                          .get() ));
          ;
          
          List<String> list = combine(arr1, arr2);
          printArr( list.toArray(new String[list.size()]) );
     }
}
