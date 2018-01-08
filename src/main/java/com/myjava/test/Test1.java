package com.myjava.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test1 {
    static List<Book> bookList = new ArrayList<Book>();
    
    private static int getInt(BufferedReader br) throws IOException {
        System.out.print("Enter Integer:");
        int i = -1;
        try{
            i = Integer.parseInt(br.readLine());
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }
        return i;
    }
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.print("Enter String");
//        String s = br.readLine();
//        System.out.println("string:" + s );
        init();
        print(bookList);
    }

    private static void init() {
        
        for (int i=0; i<10; i++) {
            Book b = new Book(i,"aaa");
            bookList.add(b);
        }
    }

    private static void print(List<Book> list) {
        for (Book b : list) {
            System.out.println(b.toString());
        }
    }
    
    private static class Book {
        @Override
        public String toString() {
            return "Book [isbn=" + isbn + ", title=" + title + "]";
        }
        public Book(int isbn, String title) {
            super();
            this.isbn = isbn;
            this.title = title;
        }
        public int getIsbn() {
            return isbn;
        }
        public void setIsbn(int isbn) {
            this.isbn = isbn;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        int isbn;
        String title;
        
    }
}