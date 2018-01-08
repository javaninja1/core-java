package com.myjava.generics;

import java.util.*;

//List<? extends Number> does not mean "a list that can hold all objects of subclasses of Number",
//it means "a list parameterized to one concrete class that extends Number".

public class Test {

    public static void main(String[] args) {
        
     List<Dog> list = new ArrayList<>();
     list.add(new Dog());
     list.add(new SheepDog());
     printExtends(list); 

     List<SheepDog> list2 = new ArrayList<>();
     list2.add(new SheepDog());
     printExtends(list2);
     
    
     
     List<Animal> list3 = new ArrayList<>();
     list3.add(new Dog());
     list3.add(new Animal());
     printSuper(list3); 

   }
    
    public static void printExtends(List<? extends Dog> list) {
        System.out.println("Extends...");
        list.forEach(System.out::println);
    }

    public static void printSuper(List<? super Dog> list) {
        System.out.println("Super...");
        list.forEach(System.out::println);
    }
}
