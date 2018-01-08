package com.myjava.lambda;

public class LambdaTest {

    
    public static void greet(Greeting g) {
        g.greet();
    }
    public static void main(String[] args) {
        Greeting g1 = () -> print();
        greet(g1);
        //greet(() -> System.out.println("hello world!"));
        
        addNums addLambda = (a,b) -> a + b;
        
        //System.out.println(addLambda)
        
        
        
    }

    private static void print() {
        System.out.println("hello world!");
    }

    interface addNums { 
        int add(int x, int y);
    };
    interface Greeting { 
        void greet(); 
    }
}
