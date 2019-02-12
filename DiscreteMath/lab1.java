// LAB 1
// ALEXANDER GONZALES
// 1/25/2019
// CS 278 - DISCRETE MATH
// ****************
// Input: n dollars
// Output: how many chocolate bars n dollars can buy 

import java.util.*;

public class lab1 {

   
   // PART I: RECURSIVE METHOD
   static int barsRecursion(int dollars, int currentBars, int coupons) {
   
      if (dollars <= 0) // base case; dollars must be positive
         return currentBars; // all money's been spent
         
      if (coupons == 9) { // At nine coupons, the next coupon will earn a free Chocolate Bar
         coupons = 0; // reset coupons
         currentBars++; // give extra bar for 10 redeemed coupons
      }
      return barsRecursion(dollars - 1, currentBars + 1, coupons+1); 
      // each recursion represents $1 being spent, adding one bar and one coupon
    
   } // end of barsRecursion
   
 
 
   // PART II: LOOP METHOD
   public static int barsLoop(int n) {
      int coupons = 0;
      int bars = 0;
      
      for(int i = 0; i<n; i++) {
         bars++;    // Each dollar spent returns additional chocolate bar
         coupons++; // Each chocolate bar comes with 1 coupon 
         if(coupons == 10) { // when there are 10 coupons...
            bars++;          // one free chocolate bar,
            coupons = 1;     // which comes with another extra coupon
         } // end if
      } // end for
      
      return bars;
   } // end of barsLoop
 
 
   
   // PART III: FORMULA METHOD
   static int barsFormula (int n) { // To Test Formula 
      int bars = 0;
      
      double couponValue = 0;
      for(int i = 1; i<10; i++) { // for loop to demonstrate repeating nature of coupon value
         couponValue = couponValue + Math.pow(0.1, i); // Coupon Value = 0.1repeating
      }//end for
      
      // bars(n) = n + barsRedeemed(n)
      // barsRedeemed(n) = floor(1.1repeating * n)
      
      if(n >= 0) bars = n + (int)Math.floor(couponValue * n);     // bars(n) = n + floor(1.1repeating * n)
      return bars;
   
   } // end of barsFormula
 
 
 
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int n; // n = dollars
      do {
         System.out.print("Exit Code: -1\nDollars = ");
         n = scnr.nextInt();
         
         // starting with n dollars, 0 bars, and 0 coupons in hand    PART I
         System.out.println("Chocolate Bars (Recursion) = " + barsRecursion(n,0,0));
         
         // using for-loop                                            PART II
         System.out.println("Chocolate Bars (Loop)      = " + barsLoop(n)); 
         
         // bars(n) = n + floor(1.1repeating * n)                     PART III 
         System.out.println("Chocolate Bars (Formula)   = " + barsFormula(n));  
              
         System.out.println();      
      } while (n >= 0); // loop for user convinience, negative integer to end
   } // end of main
   
} // end of class