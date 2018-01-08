package com.myjava.jdbc;

public interface SqlQueries {
    public static final String MOST_COMMON_AGE = 
                    "select age, max(count) from  "
                    + "(select count(email) count, age from member group by age ) counts";
    public static final String MOST_COMMON_BAND = "select a1 *5, max(count)  from  "
                    + "( select count(email) count, age div 5 a1 from member group by a1 ) tab1";
 }
