class IntNodeAdvancedTest {
   public static void main(String[] args) {
      IntNode node1 = new IntNode(3,null);
      node1.addNodeAfterThis(2);
      node1.addNodeAfterThis(1);
      node1.addToEnd(3);
      node1.addToEnd(4);
      System.out.println(node1.toString());
      System.out.println("Even count: " + IntNode.listEvenNumber(node1)); // should be 3
      System.out.println("Even count: " + IntNode.listEvenNumber(node1.getLink())); // should be 2
      IntNode oddsNode1 = IntNode.copyOdd(node1);    // test copyOdd  
      System.out.println("New List, all odds from original:  " +oddsNode1.toString()); 
      
      
      
      node1.addToEnd(3);  // Test AddToEnd
      node1.addToEnd(3);
      node1.addToEnd(3);
      node1.addToEnd(3);
      node1.addToEnd(6);
      node1.addToEnd(3);
      System.out.println("List after testing addToEnd");
      System.out.println("Before removeAll(node1, 3):  " +node1.toString());
      node1 = IntNode.removeAll(node1, 3);
      System.out.println("After removeAll(node1, 3):   " +node1.toString());
      node1.getLink().addNodeAfterThis(3);                     // Add missing integers to create ordered list
      node1.getLink().getLink().getLink().addNodeAfterThis(5); 
      for(int i = 7; i < 15; i++) node1.addToEnd(i);
      System.out.println("Before reverse: " +node1.toString());           
      node1 = IntNode.reverse(node1);                               // Test reverse
      System.out.println("After reverse:  " +node1.toString());
      System.out.println("Sum of last 6 elements:  " +IntNode.sumLast(node1,6));

      System.out.println("Cyclical? " + IntNode.hasCycle(node1)); // list is not cyclical
      node1.getLink().getLink().getLink().getLink().getLink().setLink(node1.getLink().getLink());              // make node cyclical 
      System.out.println("Cyclical? " + IntNode.hasCycle(node1)); // list is now cyclical
      } // end main
}// end class