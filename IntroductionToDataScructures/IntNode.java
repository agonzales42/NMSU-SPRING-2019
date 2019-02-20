// Alexander Gonzales
// CS 273
// 2/17/2019
// Lab 4 - IntNode.java
// **********
// Purpose: Define IntNode class (with Advanced Methods)


/**
* A node in a list of integer elements
* Each Node is connected to the next node in the list or 'null'
*/

public class IntNode {
   
   /**
   * An integer that each node contains.
   */
   private int data;
   /**
   * The reference of the next IntNode in the chain.
   */
   private IntNode link;
   
   /**
   * Creates a new IntNode with data 0 and link set to null.
   */
   public IntNode() {
      data = 0;
      link = null;
   } // end IntNode (default)
   
   /** 
   /* Creates a new IntNode with given data and given link to next IntNode
   /* @param _data
   /*        The integer the new node will carry.
   /* @param _node
   /*        The IntNode that the new IntNode will link to.
   */
   public IntNode(int _data, IntNode _node) {
        data = _data;
        link = _node;
   } // end IntNode (2 arg constructor)
   
   /** 
   * Accessor that returns the integer carried by the IntNode that calls this method.
   * @return data
   *         The Integer that this IntNode carries.
   */
   public int getData() {
      return data;
   } // end getData
   
   /**
   * Accessor that returns the IntNode that is linked from the IntNode that calls this method.
   * @return link
   *        The IntNode that this IntNode is linked to.
   */
   public IntNode getLink() {
      return link;
   } // end getLink
   
   /**
   * Mutator that changes the data of the IntNode that calls this method.
   * @param newData
   *        The new integer that this IntNode will carry
   */   
   public void setData(int newData) {
      data = newData;
   } // end setData
   
   /** 
   /* Mutator that sets the IntNode that the IntNode that calls this method is linked to.
   /* @param newLink
   /*        IntNode to which the link is set.
   */
   public void setLink(IntNode newLink) {
      link = newLink;
   } // end setLink
   
   /** 
   * Method to return the number of elements in a given list.
   * @param head
   *        The IntNode at which the list begins.
   * @return count
   *        The number of elements in this list.
   */
   
   public static int listLength(IntNode head) { // returns count of elements in the IntNode train
      int count = 0;
      for(IntNode cursor = head; cursor != null; cursor = cursor.link) count++;
      return count;
   } // end listLength
   
   /**
   * Method to convert a list into a string.
   * @return s
   *         A string formatted as the following: "[data1]->[data2]->[data3]->....->[dataN]"
   */
   public String toString() { // returns a string of each element of the train in order
      String s = "";
      for(IntNode cursor = this; cursor != null; cursor = cursor.link) {
         s = s + cursor.data;
         if(cursor.link != null) s = s + "->"; // so the '->' does not come after the last element
      }
      return s;
   } // end toString
   
   /**
   * Adds IntNode directly after the IntNode that calls this method.
   * @param newdata
   *        The integer that the new IntNode will carry.
   */
   public void addNodeAfterThis(int newdata) { // sticks a node between the current node and the next
      IntNode newNode = new IntNode(newdata, null);
      newNode.setLink(this.getLink());
      this.setLink(newNode);
   } // end addNodeAfterThis
   
   /**
   * Determines if a given list contains a given integer.
   * @param head
   *        The IntNode that begins the list to search.
   * @param data
   *        The integer to find in the list.
   * @return
   *        Boolean whether or not the given integer has been found in the given list.
   */
   public static boolean search(IntNode head, int data) { // checks each element in the given train for the specified data
      for(IntNode cursor = head; cursor != null; cursor = cursor.link)
         if(cursor.data == data) return true; // returns true if the data has been found 
      return false; // returns false otherwise
   } // end search
   
   /**
   * Removes the IntNode directly after the IntNode that calls it.
   * @exception NullPointerException
   *            There is no IntNode linked from the IntNode that calls the method.
   */
   public void removeNodeAfterThis() { // pulls the next node after current node out of the train
      try{ 
         this.setLink(this.getLink().getLink()); // next node is removed by being 'skipped'
      } catch (NullPointerException e) {
         System.out.println("No Node after this"); }
   } // end removeNodeAfterThis
   
   //************ADVANCED*INTNODE********
   
   /**
   * Returns the amount of even integers in the list.
   * @param head
   *        The IntNode at which the list starts.
   * @return evenCount
   *         The amount of even elements in the list.
   */
   public static int listEvenNumber(IntNode head) {
      int evenCount = 0;
      for(IntNode cursor = head; cursor != null; cursor = cursor.link)
        if(cursor.getData() % 2 == 0) evenCount++;
      return evenCount; // if head = null, evenCount will return 0
   }// end listEvenNumber
   
   /**
   * Adds an IntNode to the end of the list that calls this method.
   * @param newdata
   *        The integer that the new IntNode will carry.
   */
   public void addToEnd(int newdata) {
      IntNode lastNode = new IntNode(newdata, null);
      for(IntNode cursor = this; cursor != null; cursor = cursor.link)
         if(cursor.link == null) {
            cursor.setLink(lastNode);
            break;
      }// end for
   }// end addToEnd
  
   /**
   * Finds the sum of the last 'num' elements.
   * @param head
   *        The IntNode at which the list starts.
   * @param num
   *        The quantity of elements from the end to sum.
   * @return sum
   *        The sum of the last 'num' elements.
   */
   public static int sumLast(IntNode head, int num) {//********
      IntNode last = null;
      int sum = 0;
      int count = listLength(head);
      // no preconditions needed
      for(IntNode counter = head; counter != null; counter = counter.link) {
         if(count <= num) sum = sum + counter.data;
         count--;
      } // end for
      return sum;
   }// end sumLast
 
   /**
   * Returns a new list of just the IntNodes carrying odd integers.
   * @param head
   *        The IntNode that starts the list to copy.
   * @return copyNode
   *         The IntNode at which the new list of odd integers begins.
   */
   public static IntNode copyOdd(IntNode head) {
      IntNode copyNode = null;
      for(IntNode cursor = head; cursor != null; cursor=cursor.link) {
         if(cursor.getData() % 2 != 0) {
            if(copyNode == null)
               copyNode = new IntNode(cursor.getData(), null);
            else
               copyNode.addToEnd(cursor.getData());
         } // end if
      }// end for   
      return copyNode;
   }// end copyOdd
   
   /**
   * Removes all IntNodes that carry a given integer 'e'.
   * @param head
   *        The IntNode at which the list to modify begins.
   * @param e
   *        The Integer to find and remove from the list.
   * @return head
   *        The original list after modification.
   */
   public static IntNode removeAll(IntNode head, int e) { // figure out if last node is e
      if(head.data == e) head = head.link; // in case the first node needs to be removed
      
      for(IntNode cursor = head; (cursor != null && cursor.link != null); cursor=cursor.link) {
          // in case last node needs to be removed
         while(cursor.link.data == e) {
            if(cursor.link.link == null && cursor.link.data == e) {
               cursor.link = null;
               break;
            } // end if
            cursor.removeNodeAfterThis();
         } // end while
      } // end for
      return head;
   }// end removeAll
   
   /**
   * Reverses a list.
   * @param head
   *        The IntNode at which the list to reverse begins.
   * @return newHead
   *        The last IntNode in the original list, but the list is now linked in reverse.
   */
   public static IntNode reverse(IntNode head) {
      IntNode last = null; // 'last' keeps track of where the redirections will take place
      IntNode tail = null;  // the head of the list after redirection
      IntNode cursor = null;   // to move along original side list
      IntNode cursorBack = null; // to move along reversed part of list
      
      for(int i = listLength(head); i > 0; i--) { // there are as many redirections as there are nodes in the list
         cursor = head;
         while( cursor.link != last )                 // move cursor to end of original side of list
            cursor = cursor.link;
         if(last == null) {                           // for first move, initialize newHead and last at the cursor
            tail = cursor;
            last = cursor;                    
         } else {                                      // for all other moves, 
            last.setLink(cursor);                      // reattach the marker to the cursor
            cursorBack = tail;                         // start cursorBack at the new head
            while (cursorBack != last)                 // move the cursorBack along the list until...
               cursorBack = cursorBack.link;           // the new list reaches the marker 
            cursorBack.setLink(cursor);                // and reconnects with the original list
            last = last.link;                          
         } // end if-else-if-else
      } // end for
      head.setLink(null);                              // the original head is the new tail
      return tail;                                  // return the list, now starting with the new head
   }// end reverse  
     
   /**
   * Method to determine if a list is cyclical.
   * @param head
   *        The IntNode that begins the list to determine if cyclical.
   * @return
   *        Boolean of whether or not the list is cyclical.
   */
   public static boolean hasCycle(IntNode head) {
      if(head == null) return true;    // an empty list is cyclical
      IntNode cursorTurtle = head;
      IntNode cursorRabbit = head.link;
      while(cursorRabbit != null && cursorRabbit.link !=null) {
         cursorRabbit = cursorRabbit.link.link;
         cursorTurtle = cursorTurtle.link;
         if(cursorRabbit == cursorTurtle) return true;
      }// end while
      return false; // if cursor = head, true, if cursor != head, false
      
      // Proof on rabbit and turtle:
      // We declare two cursor nodes, one initialized to the head, Turtle,
      // and the other initialized to the second element, Rabbit.
      // (giving the Rabbit a head start slightly saves on runtime)
      // The rabbit jumps two nodes, and the turtle jumps one.
      // If the rabbit "catches up" to the turtle,
      // then we know that the list is a circuit and we can return 'true;'
      // however, if the rabbit 'crosses the winning line' by reaching null,
      // then we can return false, because the list is not cyclical
   } // end hasCycle
      
} // end IntNode