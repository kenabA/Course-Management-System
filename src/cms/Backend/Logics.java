/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.Backend;

/**
 *
 * @author kenabkc
 */
public class Logics {
    
     public static String convertToOrdinal(int number) {
        if (number >= 11 && number <= 13) {
            return number + "th";
        }

         return switch (number % 10) {
             case 1 -> number + "st";
             case 2 -> number + "nd";
             case 3 -> number + "rd";
             default -> number + "th";
         };
    }

    
}
