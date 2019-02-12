// CS 278
// Alexander Gonzales
// Lab2
// 1/30/2019
// ********
// Purpose: generate a truth table based on the Scottish Club Puzzle

public class lab2part1 {
   
   static int not(int x) { // ~
      if( x == 0 ) return 1;
      return 0;
   } // end not
   
   // and /\
   static int and(int a, int b) {
      if(a == 1 && b == 1) return 1;
      return 0;
   } // end and (2 param)
   static int and(int a, int b, int c) {
      if(and(a,b) == 1 && c == 1) return 1;
      return 0;
   } // end and (3 param)
   static int and(int a, int b, int c, int d) {
      if(and(a,b,c) == 1 && d == 1) return 1;
      return 0;
   } // end and (4 param)
   static int and(int a, int b, int c, int d, int e) {
      if(and(a,b,c,d) == 1 && e == 1) return 1;
      return 0;
   } // end and (5 param)
   static int and(int a, int b, int c, int d, int e, int f) {
      if(and(a,b,c,d,e) == 1 && f == 1) return 1;
      return 0;
   } // end and (6 param)
   
   static int or(int x, int y) {  //  \/
      if(x == 1 && y == 1) return 1;
      if(x == 1 && y == 0) return 1;
      if(x == 0 && y == 1) return 1;
      return 0;
   } // end or
   
   static int ifthen(int x, int y) {//  ->
      if(x == 1 && y == 1) return 1;
      if(x == 1 && y == 0) return 0;
      if(x == 0 && y == 1) return 1;
      return 1;
   } // end if_then
   
   static int iff(int x, int y) {   // <->
      if(x == 1 && y == 1) return 1;
      if(x == 1 && y == 0) return 0;
      if(x == 0 && y == 1) return 0;
      return 1;
   } // end iff
   
   
   public static void main(String[] args) {
   
      int Rule1, Rule2, Rule3, Rule4, Rule5, Rule6;
      System.out.print("G M R S W    "); // print Proposition Header
      System.out.printf("(~ S -> R) /\\ (W \\/ ~ R) /\\ (M -> ~ G) /\\ (G <-> S) /\\ (W -> S /\\ M) /\\ (S -> W)\n"); // Print Header
      
      for (int G=0; G<=1; G++) // G = goes out on sunday
      for (int M=0; M<=1; M++) // M = Married
      for (int R=0; R<=1; R++) // R = Wears Red Socks
      for (int S=0; S<=1; S++) // S = Scottish
      for (int W=0; W<=1; W++) // W = Wears Kilt
      {
         Rule1 = ifthen(not(S),R);    // if not scottish, then wears red socks
         Rule2 = or(W, not(R));       // if Wears Kilt or does not wear Red Socks
         Rule3 = ifthen(M, not(G));       // if Married, then does not Go Out on Sunday
         Rule4 = iff(G,S);            // Goes Out on Sunday if and only if Scottish
         Rule5 = ifthen(W, and(S,M)); // If Wears Kilt, then Scottish and Married
         Rule6 = ifthen(S,W);         // If Scottish, then Wears Kilt
         
         System.out.printf("%d %d %d %d %d  | ",G,M,R,S,W); // print Propositions
         
         System.out.printf(" %d %d  %d %d   ", not(S), S, ifthen(not(S),R), R);           // Rule 1
         System.out.printf("%d  ", and(Rule1, Rule2));                                    // Rules 1,2 (and) true?
         System.out.printf("%d  %d %d %d   ", W, or(W,not(R)), not(R), R);                // Rule 2
         System.out.printf("%d  ", and(Rule1, Rule2, Rule3));                             // Rules 1,2,3 (and) true?
         System.out.printf("%d  %d %d %d   ", M, ifthen(M,not(G)), not(G), G);            // Rule 3
         System.out.printf("%d  ", and(Rule1, Rule2, Rule3, Rule4));                      // Rules 1,2,3,4 (and) true?
         System.out.printf("%d  %d  %d   ", G, iff(G,S), S);                              // Rule 4
         System.out.printf("%d  ", and(Rule1, Rule2, Rule3, Rule4, Rule5));               // Rules 1,2,3,4,5 (and) true?
         System.out.printf("%d  %d %d  %d %d   ", W, ifthen(W, and(S,M)), S, and(S,M), M);// Rule 5        
         System.out.printf("%d  ", and(Rule1, Rule2, Rule3, Rule4, Rule5, Rule6));        // Rules 1,2,3,4,5,6 (and) true?
         System.out.printf("%d  %d %d", S, ifthen(S,W), W);                               // Rule 6
         System.out.println();  
      } // end for
   } // end main
} // end class

/* I prefer the plain English Argument. It's much easier to read the contradictions when
 speaking in plain english. However, it should be considered that the computer-generated
Truth Table gives more precision when trying to find who can still be admitted to the club
should certain rules be ignored. */