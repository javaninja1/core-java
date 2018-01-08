package com.myjava.logic;

import java.util.*;

public class Sums {

    static int numCalls = 0;
    
    public static void subsetSum(List<Integer> numList, int target, List<Integer> partial, List<Integer> firstMatching) {
        numCalls++;
        if (partial == null || partial.size() == 0) {
            partial = new ArrayList<Integer>();
        }
        int sum = partial.stream().reduce(Integer::sum).orElse(0);
        if (sum == target ) {
            firstMatching.addAll(partial);
            System.out.println(Arrays.toString(partial.toArray()) + "=" + target); // .join("+")
            return;
        }
        if (sum >= target) {
            return;
        }
        for (int i = 0; i < numList.size(); i++) {
            Integer n = numList.get(i);
            List<Integer> remaining = numList.subList(i + 1, numList.size());
            List<Integer> copy = new ArrayList<Integer>(partial);
            copy.add(n);
            subsetSum(remaining, target, copy, firstMatching);
        }
    }
    
    public static void subsetSum2(List<Integer> numList, int target, List<Integer> partial) {
        partial = new ArrayList<Integer>();
        int sum = 0;
        for (int i = 0; i < numList.size(); i++) {
            int newSum = sum + numList.get(i);
            if ( newSum == target) {
                partial.add(numList.get(i));
                System.out.println("partial:" + Arrays.toString(partial.toArray()));
                return;
            } else if (newSum < target) {
                sum = newSum;
                partial.add(numList.get(i));
            } else {
              //skip the element  
            }
        }
    }

    private static List<Integer> findSum(List<Integer> intList,int target) {
        int listSize = intList.size();
        List<Integer> resultList = null;
        
        for(int index = 0; index < listSize; index++) {
            int startPoint = index;
            int totalTime = 0;
            resultList = new ArrayList<Integer>();
            
            // Loop to get possible combination.
            while(startPoint < listSize) {
                int currentCount = startPoint;
                startPoint++;
                int intVal = intList.get(currentCount);
                if ((intVal + totalTime) <= target) {
                    resultList.add(intVal);
                    System.out.println("resultList:" + Arrays.toString(resultList.toArray()));

                    totalTime += intVal;
                    if(totalTime == target) {
                        break;
                    }
                }
            }
            boolean validSession = false;
            validSession = (totalTime == target);
            
            // If session is valid than add this session in the possible combination list and set all added talk as scheduled.
            if(validSession) {
                return resultList;
            }
        }
        return resultList;
        
    }
    
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(new Integer[] {7, 3, 9, 8, 4, 5, 2, 10 });
        System.out.println("b4:" + Arrays.toString(intList.toArray()));
        List<Integer> result = new ArrayList<>();
        subsetSum(intList,15,null,result);
        System.out.println("FIRST:" + Arrays.toString(result.toArray()));
        
//        List<Integer> list = findSum(intList, 15);
//        //list.stream().map(e -> Arrays.toString(e.toArray())).forEach(System.out::println);
//      System.out.println("list:" + Arrays.toString(list.toArray()));

        System.out.println("numCalls:" + numCalls);
    }



//  intList.sort( new Comparator<Integer>() {
//  @Override
//  public int compare(Integer o1, Integer o2) {
//     return o1.compareTo(o2);
//  }
//  
//});
//intList.sort( (o1, o2) -> o2.compareTo(o1));
//System.out.println("after:" + Arrays.toString(intList.toArray()));

}
