// Alexander Gonzales
// CS 273
// 2/11/2019
// Lab 3 - IntNodeTest.java
// **********
// Purpose: Test IntNode class


public class IntNodeTest {
   public static void main(String[] args) {
      System.out.println("node1");
      
      IntNode node1 = new IntNode();
      System.out.println( node1.getData() );
      node1.addNodeAfterThis(7);
      System.out.println( node1.getLink().getData() );
      node1.addNodeAfterThis(-4);
      System.out.println( node1.getLink().getData() );
      node1.addNodeAfterThis(11);
      System.out.println( node1.getLink().getData() );
     
      
      System.out.println("Length = " + IntNode.listLength(node1));
      System.out.println(node1.toString());
            
            
      System.out.println();
      System.out.println();
      
      System.out.println("node2");
      IntNode node2 = new IntNode(13, null);
      
      System.out.println( node2.getData() );
      node2.addNodeAfterThis(20);
      System.out.println( node2.getLink().getData() );
      node2.addNodeAfterThis(25);
      System.out.println( node2.getLink().getData() );
      
      System.out.println("Length = " + IntNode.listLength(node2));
      System.out.println(node2.toString());
      
      
      System.out.println();
      System.out.println();
      
      System.out.println("node3");
      
      IntNode node3 = new IntNode(40, node2);
      System.out.println( node3.getData() );
      System.out.println( node3.getLink().getData() );
      System.out.println( node3.getLink().getLink().getData() );
      System.out.println( node3.getLink().getLink().getLink().getData() );
      try {
         System.out.println(node3.getLink().getLink().getLink().getLink().getData() );
      } catch (NullPointerException e) {
         System.out.println("Null pointer, link does not exist...");
      } // end try-catch
      
      
      node3.setData(30);
      node3.addNodeAfterThis(34);
      node3.addNodeAfterThis(33);
      node3.addNodeAfterThis(32);
      node3.addNodeAfterThis(31);
      
      System.out.println(node3.toString());
      System.out.println("node3 contains 34 and '-4' : " + ((IntNode.search(node3, 34) && IntNode.search(node3, -4))));
      System.out.println();
      
      node3.getLink().getLink().getLink().getLink().setLink(node1);
      System.out.println(node3.toString());
      System.out.println("node3 contains 34 and '-4' : " + (IntNode.search(node3, 34) && (IntNode.search(node3, -4))));
      System.out.println();
      
      node3.getLink().getLink().getLink().setLink(node1);
      System.out.println(node3.toString());
      System.out.println("node3 contains 34 and '-4' : " + (IntNode.search(node3, 34) && (IntNode.search(node3, -4))));
      
      System.out.println();
      node3.removeNodeAfterThis(); // delete '31'
      System.out.println(node3.toString());
      
      node3.getLink().removeNodeAfterThis(); // delete '33'
      System.out.println(node3.toString());
      
      System.out.println("\nTest setData and cursor\n");
      int num = 30;
      for(IntNode cursor = node3; cursor != null; cursor = cursor.getLink()) {
            cursor.setData(num);
            num = num - 5;
            System.out.println(node3.toString());
      } // end for
      
      
      
      
   } // end main
} // end class