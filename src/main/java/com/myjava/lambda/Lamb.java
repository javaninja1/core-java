package com.myjava.lambda;

import java.util.function.*;
import java.util.stream.*;
import java.util.Date;

@SuppressWarnings("unchecked")
public class Lamb {
   static void work(int val, Function<Integer,Integer> func) {
      System.out.println(func.apply(val));
   }
 
  static Function<Integer, Integer>  chain(Function<Integer,Integer>... funcs) {
    return Stream.of (funcs)
             .reduce(Function.identity(), Function::andThen);
//             .reduce(Integer -> Integer,
//  (funcs2, aFunc) -> funcs2.andThen(aFunc));
  }

  static void print(String s, Consumer<String> c) {
      c.accept(s);
  }
  public static void main(String args[]) {

    Consumer<String> consumer = (x) -> System.out.println(x.toLowerCase());
    consumer.accept("HELLO");
    print ("SSSS", consumer);
    
    Supplier<String> supplier = () -> { return new Date().toString(); }; 
    System.out.println(supplier.get());
    
    
    BiFunction<Integer, Integer, Integer> l1 =   (x , y) ->  { return x +y; };
    System.out.println(l1.apply(3,4));

    Function<Integer,Integer> inc = e -> e + 1;
    Function<Integer,Integer> doubleIt = e -> e*2;
    work(5, inc.andThen(doubleIt) );

    Function<Integer,Integer> func = chain (inc, doubleIt);
    work (3, func);
    
    
    
  }

}