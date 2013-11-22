/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.purdue.cs408.testify;

import java.io.Serializable;

/**
 *
 * @author Austin
 */
public class Time implements Serializable {
    int hour;
    int minute;
    int second;
    boolean am;
    /** Make time from seconds since midnight
     * 
     * @param s seconds since midnight
     */
    
    public Time(int hour, int minute, int second, boolean am) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.am = am;
    }
    
    /**
     * Creates new Time from string
     * @param str  String of format "h:mm a"
     */
    public Time(String str) {
        try {
            this.hour = Integer.valueOf(str.substring(0,1));
            this.minute = Integer.valueOf(str.substring(2,4));
            this.second = 0;
            this.am = str.substring(5,7).equalsIgnoreCase("AM");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Malformed time string");
        }
    }
    
    public String toString() {
        return String.format("%d:%02d %s", hour, minute, am ? "AM" : "PM");
    }
}
