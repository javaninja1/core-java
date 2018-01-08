package com.myjava.stream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

 interface Abc {
    public default void print(String str) { System.out.println(str); }
}
 class Impl implements Abc {
     
 }
 
 
 
public class Java8 {
    
    public static <T> T firstOrNull(List<T> list) {
        Optional<T> first = Optional.ofNullable(list).orElse(Collections.emptyList()).stream().findFirst();
        if(first.isPresent()){
            return first.get();
        } else {
            return null;
        }
    }
    
    public static List<Integer> convertStrArrToIntList(String[] strArr) {
        
        List<String> strList= new ArrayList<String>(Arrays.asList(strArr));
        
//        return   Optional.ofNullable((strArr ==null)? null : )
//                         .orElse(Collections.EMPTY_LIST)
                       return strList
                         .stream()
                         .map(Integer::parseInt)
                         .collect(Collectors.toList());
    }
    public static List<String> getRemaining(List<String> entireList, List<String> subList) {
        return entireList.stream()
                  .filter(e -> !subList.contains(e))
                  .collect(Collectors.toList());
    }
    
    public static <T> List<T> safeToList(T[] array) {
        return Optional.ofNullable(Arrays.asList(array))
                       .orElse(Collections.emptyList());
    }
    
    public static boolean isAnyListElementInString(List<String> list, String source) {
        return Optional.ofNullable(list).orElse(Collections.emptyList()).stream().anyMatch(e ->  source.contains(e));
    }
    public static List<Integer> convertStrArrToIntList2(String[] strArr) {
        //return list.stream().anyMatch(e ->  source.contains(e));
        
        List<String> newStrArr = safeToList(strArr);
        List<Integer> newIntArr = new ArrayList<Integer>();
        if (newStrArr != null && !newStrArr.isEmpty()) {
            for (String str : newStrArr) {
                newIntArr.add(Integer.valueOf(str));
            }
        }
        return newIntArr;
      }

    static void fraction (String...  ar ) {
        Map<Integer, Long> result =  Arrays.stream(ar)
                        .map(i -> Integer.parseInt(i))
                        .collect(Collectors.groupingBy(i ->i>0? 1 : i<0? -1: 0
                                        , Collectors.counting()) );
        
        for(Map.Entry<Integer, Long> entry : result.entrySet() ) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        
        long total = result.values().stream().map(i -> i.longValue()).reduce(Long::sum).orElse(0l);
        System.out.println("--##-" + total);

          System.out.println( (float)result.getOrDefault(1, 0l)/total);
          System.out.println((float) result.getOrDefault(-1,0l)/total);
          System.out.println( (float) result.get(0)/total);
                        
        
    }
      
    


    class MyNumber {
        Integer number;
        List<Integer> all = new ArrayList<Integer>();

        public MyNumber(Integer num, List<Integer> list) {
            all = list;
            number = num;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public int sumRest() {
            return all.stream().filter(i -> i != number).reduce(Integer::sum).orElse(0);
        }

    }
    public static void main(String args[]) {
    
        listToMap();
        
        
        System.exit(0);
        fraction ("1","-22","0", "-33", "-3") ;
        
        
        String[] arr = {"Apple", "banana", "pie"};
        Spliterator<String> s = Arrays.spliterator(arr);
        s.tryAdvance(System.out::println);
        
        
        System.out.println("first:" + firstOrNull(null));
        System.exit(0);

        getRemaining(Arrays.asList("aa", "bb", "cc", "dd"), Arrays.asList( "cc", "dd"))
          .stream()
           .forEach(System.out::println);
        

        String[] strArr = {"123", "444", "556"};
        strArr = null;
        convertStrArrToIntList(strArr).stream().forEach(System.out::println);

        //Predicate
        List<String> strList = Arrays.asList("aa", "bb", "cc", "dd");
        if (isAnyListElementInString(null, "zzcczz")) {
            System.out.println("Yes");
        }
        
        List<Integer> intList = Arrays.asList(1,2,3,4,5);
        Arrays.asList(1,2,3,4,5)
               .stream()
               .map(i -> i.intValue())
               .reduce(Integer::sum);
        
//               .filter(n -> n%2 == 0)
//               .collect(Collectors.toList())
//               .forEach(System.out::println);
//               //.reduce(identity, accumulator, combiner)
//               
//               
//               
//               

        LocalDate now = LocalDate.now();
        LocalDate twoDaysPrior = now.minusDays(2);
        System.out.println(twoDaysPrior);

        intList.forEach(System.out::println);
        
        Runnable r1 = new Runnable() { @Override public void run() {System.out.println("running"); } };
        Runnable r2 = () -> {System.out.println("running2");};
        r2.run();
        for (int i=0; i<intList.size(); i++) {
            System.out.println(intList.get(i));
        }
        
        log("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for(int k : intList) { //can throw NPE
            System.out.println (k);
        }
        log("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        intList.forEach((k) -> System.out.println(k));
        log("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        
        //Default method
        Impl im = new Impl();
        im.print("default method");

        
    }

    private static void listToMap() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        //Predicate<Integer> notEqualToSelf = (p) -> (p != p); 
        
        List<Integer> list = Arrays.asList(str.split(" "))
                        .stream()
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        
        Map<Object, Long> numberMap =  list.stream()
                        .collect(Collectors.groupingBy( Function.identity(),
                                         Collectors.counting() )
                              );
        //Collectors.reducing(op)(p -> p.sumRest())
        
        numberMap.entrySet().forEach(System.out::println);
    }





    private static void log(String str) {
        Consumer<String> con = (k) -> {System.out.println(k);};
        con.accept(str);
    }

}
