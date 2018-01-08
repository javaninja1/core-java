package com.myjava.anno;

public class Hello {
    
    @MyAutoWired
    public String abc = "000";
    
    public void setAbc(String abc) {
        this.abc = abc;
    }

    @MyAnno (value = 10)
    public void greet() {
        System.out.println("hello annotation");
    }

    @Override
    public String toString() {
        return "Hello [abc=" + abc + "]";
    }
    
    
}
