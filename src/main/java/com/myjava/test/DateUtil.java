package com.myjava.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class DateUtil {

    final static long NUM_MILLISECS_IN_DAY = 1000 * 60 * 60 * 24;
    
    final static long NUM_MILLISECS_IN_MIN = 1000*60;

    public static long numberOfDaysBetween(Date d1, Date d2) {
        return numberOfDaysBetween(d1, d2, false);
    }

    public static long numberOfDaysBetween(Date d1, Date d2, boolean rounded) {
        if(d1.equals(d2)) {
            return 0;
        }
        double diff = (d1.getTime() - d2.getTime());
        if (diff < 0) {
            diff = -1 * diff;
        }
        double diffdays = diff / NUM_MILLISECS_IN_DAY;
        long days = rounded ? java.lang.Math.round(diffdays) : (long)diffdays;
        return days;
    }
    
    /**
     * Method to calculate the minutes difference between two dates
     * @param d1
     * @param d2
     * @return
     */
    public static long numberOfMinutesBetween ( Date d1, Date d2 ) {
      long minsDiff = 0;
      if( d2 == null || d1 == null) {
        return 0;
      }
      if( d1.equals(d2)) {
        return 0;       
      }
      double diff = (d2.getTime() - d1.getTime());
      minsDiff = (long)(diff/NUM_MILLISECS_IN_MIN);
      return minsDiff;
    }
    
    /**
     * Returns a future or past date that is off by number of days passed as argument
     * @param d1
     * @param numberOfDays
     * @return
     */
    public static Date getDateFrom(Date d1, int numberOfDays) {
        return new Date(d1.getTime() + (numberOfDays*24*60*60*1000));
    }
    
    /**
     * Returns a string representation of the date in the format specified.
     * @param d1
     * @param strFormat
     * @return
     */
    public static String getStringFromDate(Date d1, String strFormat) {
        DateFormat df = new SimpleDateFormat(strFormat);
        return df.format(d1);
    }
    
    /**
     * 
     * This method will compare two dates passed to it
     * @param d1
     * @param d2
     * @return
     */
    public static int compareDate(Date d1, Date d2) {
        if(d1 == null && d2 == null) return 0;
        else if(d1 == null && d2 != null) return -1;
        else if(d1 != null && d2 == null) return 1;
        else return d1.compareTo(d2);
    }
     /**
     * A function to determine the maximum time of a day.
     * Used for determine differences between dates when we are only interested in whole days.
     *
     * @param the date
     * @return the maximum time of the day.
     */
    public static Date getMaxTime(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, cal.getMaximum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getMaximum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getMaximum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMaximum(Calendar.MILLISECOND));
        return cal.getTime();
    }
    
    /**
     * A function to determine the minimum time of a day.
     * Used for determing differences between dates when we are only interested in whole days.
     *
     * @param the date
     * @return the minimum time of the day.
     */
    public static Date getMinTime(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, cal.getMinimum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getMinimum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getMinimum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));
        return cal.getTime();
    }
    
    public static void main(String args[]) throws ParseException {
        String string = "January 2, 2010 08:12 am";
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy hh:mm aaa", Locale.ENGLISH);
        Date date1 = format.parse(string);
        String string2 = "January 3, 2010 12:30 pm";
        Date date2 = format.parse(string2);
        date1 = DateUtil.getMinTime(date1);
        date2 = DateUtil.getMaxTime(date2);
        System.out.println("date1:" + date1.toString());
        System.out.println("date2:" + date2.toString());
        System.out.println("Diff:" + numberOfDaysBetween(date1, null, true));
    }
    
}
