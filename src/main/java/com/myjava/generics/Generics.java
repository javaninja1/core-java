package com.myjava.generics;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;


class Glass<E> {
    public E liguid;
    
    public static <T> T print(T liquid) {
        System.out.println(liquid.getClass().getName());
        return liquid;
    }
}

class MySuperInt {
    int x;
    public int getVal() { return x;};
}
class MyInt extends MySuperInt {}


public class Generics {
    
    public static double sum( List<? extends Number> list) {
        double d = 0;
        for(Number n : list) {
            d += n.doubleValue();
        }
        return d;
    }
    
    public static void print(List<? super MySuperInt> list) {
        for(Object n : list) {
            n.toString();
        }  
    }
    
    public static void main(String[] args) {
        
        List<? super Integer> list = new ArrayList<Number>();
        List<? extends Integer> list2 = new ArrayList<Integer>();
        
     System.out.println( "sum of ints:" + sum(IntStream.range(1, 5).boxed().collect(Collectors.toList())));
     
     System.out.println( "sum of longs:" + sum(LongStream.range(5, 8).boxed().collect(Collectors.toList())));
    }

}

 class Util { 
    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        for (int i = 0; i < src.size(); i++) 
          dest.set(i, src.get(i)); 
    } 
  }
 
 //https://stackoverflow.com/questions/4343202/difference-between-super-t-and-extends-t-in-java

//<? extends T> and <? super T> are examples of bounded wildcards. 
//An unbounded wildcard looks like <?>, and basically means <? extends Object>. 
//It loosely means the generic can be any type. A bounded wildcard (<? extends T> or <? super T>) 
//places a restriction on the type by saying that it either has to extend a specific
//type (<? extends T> is known as an upper bound), or has to be an ancestor of a specific type 
//(<? super T> is known as a lower bound).