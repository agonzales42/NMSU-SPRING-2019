class Lab3Part1Predicate1 {
     
   static int ifthen(int x, int y) {
      if ( x == 1 && y == 1) return 1;
      if ( x == 0 && y == 1) return 1;
      if ( x == 0 && y == 0) return 1;
      return 0;
   }
   
   static int and(int x, int y) {
      if(x == 1 && y == 1) return 1;
      return 0;
   }

   static int ForSomeX (int[] f) {
         for(int x = 0; x < f.length; x++)
            if(f[x]==1) return 1;
         return 0;
   }
   
   
   static int ForSomeXPandQ (int[] p, int[]q) {
         
         for(int x = 0; x < p.length; x++)
            if(p[x] == 1 && q[x] == 1) return 1;
         return 0;
   }
   
   static boolean predicateOne(int[] p, int[] q) {
         if(ifthen(and(ForSomeX(p),ForSomeX(q)),ForSomeXPandQ(p,q)) == 1) return true;
         return false;
   }
   
   public static void main(String[] args) {
         int[] p1 = {1, 0, 1, 1};
         int[] q1 = {0, 1, 0, 1};
         
         int[] p2 = {0, 0, 0, 0};
         int[] q2 = {0, 0, 0, 0};
         
         int[] p3 = {1, 1, 0, 1};
         int[] q3 = {0, 0, 0, 0};
         
         int[] p4 = {1, 0, 1, 1};
         int[] q4 = {0, 1, 0, 0};
         
         System.out.println("Predicate One:");
         
         System.out.println("p1 q1");
         for(int i = 0; i < 4; i++) 
            System.out.printf(" %d  %d\n", p1[i], q1[i]);
         
         System.out.println("p1 and q1, model if true, countermodel if false...  *" + predicateOne(p1,q1) + "*");
         System.out.println();
         
         System.out.println("p2 q2");
         for(int i = 0; i < 4; i++) 
            System.out.printf(" %d  %d\n", p2[i], q2[i]);
         
         System.out.println("p1 and q1, model if true, countermodel if false...  *" + predicateOne(p2,q2) + "*");
         System.out.println();
         
         System.out.println("p3 q3");
         for(int i = 0; i < 4; i++) 
            System.out.printf(" %d  %d\n", p3[i], q3[i]);
         
         System.out.println("p3 and q3, model if true, countermodel if false...  *" + predicateOne(p3,q3) + "*");
         System.out.println();
         
         System.out.println("p4 q4");
         for(int i = 0; i < 4; i++)
            System.out.printf(" %d  %d\n", p4[i], q4[i]);
         
         System.out.println("p4 and q4, model if true, countermodel if false...  *" + predicateOne(p4,q4) + "*");
         System.out.println();
         
         
   } // end main
} // end class