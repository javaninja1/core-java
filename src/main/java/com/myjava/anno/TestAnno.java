package com.myjava.anno;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestAnno {

    public static void main(String[] args) throws NoSuchMethodException, SecurityException {
        Hello h=new Hello();  
        Class<? extends Hello> clazz = h.getClass();
        
        Method m= clazz.getMethod("greet");
        if (m.isAnnotationPresent(MyAnno.class) ) {
          MyAnno manno = m.getAnnotation(MyAnno.class);
          System.out.println("value is: "+ manno.value());
        }

        Arrays.asList(clazz.getFields())
          .stream()
          .filter(e -> e.isAnnotationPresent(MyAutoWired.class))
          //.map(e ->e.set(h, "qqqq"))
          .forEach(e -> process(h, e));
        
        System.out.println(h);
        
    }

    private static void process(Hello h, Field e)  {
        try {
            e.set(h, "qqqqq");
        } catch (IllegalArgumentException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }
    }



}
