class Lab2Part2Predicate2 {

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
   static int forallX(int[][] f) {
      for(int i = 0; i < f[0].length; i++)
      for(int j = 0; j < f[1].length; j++)
         if(f[i][j] == 0) return 1;
      return 1;
   }
   
   static int forallX_PxImplies_forallY_Qxy_implies_Qyx(int[] p, int[][] q) {
      for(int x = 0; x < p.length; x++)
      for(int y = 0; y < q.length; y++)
         if(ifthen(p[x],ifthen(q[x][y],q[y][x])) == 0) return 1;
      return 1;
   }
   
   static boolean predicateTwo(int[] p, int[][] q) {
      if(ifthen( and(forallX(p),forallX(q)), forallX_PxImplies_forallY_Qxy_implies_Qyx(p,q)) == 1) return true;
      return false;
   }
   
   public static void main(String[] args) {
      int[] p = {1,1};
      int[][] q = {{1,0},{0,1}};
      System.out.println(predicateTwo(p,q));
   }
}