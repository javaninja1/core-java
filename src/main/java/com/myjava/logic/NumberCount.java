package com.myjava.logic;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class NumberCount {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(
        new InputStreamReader(System.in));
        String s, numStr = "";
       try {
        while ((s = in.readLine()) != null) {
            numStr = new String(s);
        }
      }catch (Exception ex) {}
        
        Map<Integer, Long> result = Arrays.stream(numStr.split(" "))
               .map(i -> Integer.parseInt(i))
               .collect(Collectors.groupingBy(i ->i>0? 1 : i<0? -1: 0, Collectors.counting()) );
        
        long total = result.values().stream().map (i -> i.longValue()).reduce(Long::sum).orElse(0l);
        
        System.out.println((float) result.getOrDefault(1,0l)/total) ;
        System.out.println((float) result.getOrDefault(-1,0l)/total);
        System.out.println((float) result.getOrDefault(0,0l)/total );
        
        
    }
    
}
