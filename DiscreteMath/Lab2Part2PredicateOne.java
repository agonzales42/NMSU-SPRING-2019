class Lab2Part2PredicateOne {
   
   static int and(int a, int b) {
      if(a == 1 && b == 1) return 1;
      return 0;
   }
   
   static int ifthen(int a, int b) {
      if(a == 1 && b == 1) return 1;
      if(a == 0 && b == 1) return 1;
      if(a == 0 && b == 0) return 1;
      return 0;
   }
   
   static int forallX(int[] f) {
      for(int i = 0; i < f.length; i++)
         if(f[i] == 0) return 0;
      return 1;
   }
   
   static int forAllX_P_implies_Q(int[] p, int[] q) {
      for(int i = 0; i < q.length; i++)
         if(ifthen(p[i],q[i]) == 0) return 0;
      return 1;
   }
   
   static boolean predicateOne(int[] p, int[] q) {
      if(ifthen(ifthen(forallX(p), forallX(q)), forAllX_P_implies_Q(p,q)) == 1) return true;
      return false;
   }
   
   public static void main(String[] args) {
      int[] p1 = {1,1};
      int[] q1 = {1,1};
      
      int[] p2 = {1,0};
      int[] q2 = {1,0};
      
      int[] p3 = {1,0};
      int[] q3 = {0,1};
      
      int[] p4 = {0,1};
      int[] q4 = {1,0};
      
      System.out.println("Predicate One:");
         
      System.out.println("p1 q1");
      for(int i = 0; i < 2; i++)
        System.out.printf(" %d  %d\n", p1[i], q1[i]);
      
      System.out.println("p1 and q1, model if true, countermodel if false...  *" + predicateOne(p1,q1) + "*");
      System.out.println();
         
      System.out.println("p2 q2");
      for(int i = 0; i < 2; i++)
        System.out.printf(" %d  %d\n", p2[i], q2[i]);
      
      System.out.println("p1 and q1, model if true, countermodel if false...  *" + predicateOne(p2,q2) + "*");
      System.out.println();
         
      System.out.println("p3 q3");
      for(int i = 0; i < 2; i++)
        System.out.printf(" %d  %d\n", p3[i], q3[i]);
      
      System.out.println("p3 and q3, model if true, countermodel if false...  *" + predicateOne(p3,q3) + "*");
      System.out.println();
         
      System.out.println("p4 q4");
      for(int i = 0; i < 2; i++) 
        System.out.printf(" %d  %d\n", p4[i], q4[i]);
      
      System.out.println("p4 and q4, model if true, countermodel if false...  *" + predicateOne(p4,q4) + "*");
      System.out.println();
   }// end main
} // end class