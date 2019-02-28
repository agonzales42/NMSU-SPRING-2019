// Alexander Gonzales
// CS 272
// 2/28/2019
// Lab 5 - DoublyLinkedListDummy.java
// **********
// Purpose: Define DoublyLinkedListDummy class

/**
* A list containing dynamic Doubly Linked Nodes, with several methods to mutate, access, or copy the list.
*/
public class DoublyLinkedListDummy {
   /**
   * A dummy head, which will always be at the very front of the list and be empty
   */
   DIntNode head = new DIntNode();
   
   /**
   * A dummy tail, which will always be at the very end of the list and be empty
   */
   DIntNode tail = new DIntNode();
   
   /**
   * Returns the first element in the Doubly Linked List.
   * @return head
   *     The first element in the list, or dummy head if list is empty.
   */
   public DIntNode getHead() {
      if(head.getNext() != tail) return head.getNext();
      return head;
   }// end getHead
   
   /**
   * Returns the last element in the Doubly Linked List.
   * @return tail
   *      The last element in the list, or dummy tail if list is empty.
   */
   public DIntNode getTail() {
      if(tail.getPrev() != head) return tail.getPrev();
      return tail;
   }// end getTail
   
   /**
   * Sets a given node as the first element in the list.
   * @param node
   *     The DIntNode to set as first element in list.
   */
   public void setHead(DIntNode node) {
      node.setPrev(head);              // connect node to head
      node.setNext(head.getNext());    // connect node to next node
      head.getNext().setPrev(node);    // connect next node to node
      head.setNext(node);              // connect head to node
   }// end setHead
   
   /**
   * Sets the a given node as the last element in the list.
   * @param node
   *     The DIntNode to set as the last element in the list.
   */
   public void setTail(DIntNode node) {
      node.setNext(tail);              // connect node to tail
      node.setPrev(tail.getPrev());    // connect not to previous node
      tail.getPrev().setNext(node);    // connect previous node to node
      tail.setPrev(node);              // connect tail to node
   }
   
   /**
   * Default constructor for DoublyLinkedListDummy.
   * Connects the head directly to the tail, and vice versa.
   */
   public DoublyLinkedListDummy() {
      head.setPrev(null);              // previous of head is null
      head.setNext(tail);              // connect head to tail
      tail.setPrev(head);              // connect tail to head
      tail.setNext(null);              // next of tail is null
   }// end DoublyLinkedListDummy
   
   /**
   * Method that adds a node with a given integer to the end of the list.
   * @param element
   *     The integer that the new node will contain
   */
   public void addEnd(int element) {
      DIntNode newnode = new DIntNode(element);    // create new node with given value
      newnode.setNext(tail);                       // connect new node to tail
      newnode.setPrev(tail.getPrev());             // connect new node to previous node
      tail.getPrev().setNext(newnode);             // connect previous node to new node
      tail.setPrev(newnode);                       // connect tail to node
   }// end addEnd
   
   /**
   * Removes the first element of the list. Big-O:   O(1)
   */
   public void removeFromHead() {                 
      if(head.getNext() != tail) {                 // check that the list is not empty
         DIntNode toRemove = head.getNext();       // declare first node
         head.setNext(toRemove.getNext());         // connect head to node after first node
         toRemove.getNext().setPrev(head);         // connect node after first node to head
      }// end if
   }// end removeFromHead
   
   /**
   * Method to create string of list elements.
   * @return sF + "\n" + sB
   *  The string of elements from head to tail, followed by a new line,
   *  followed by the string of elements from tail to head, each element separated by "<->"
   */
   public String toString() {
      String sF = "(Forward)  ", sB = "(Backward) ";   // declare a forward string and a backward string
      DIntNode cursor = head.getNext();
      while(cursor != tail) {
         sF = sF + cursor.getData();                   // add elements to forward string
         if(cursor.getNext() != tail) sF = sF + "<->"; // add "<->" between every element except for last
         cursor = cursor.getNext();             // move cursor forward
      }// end while        
      //  note: cursor = tail 
      cursor = cursor.getPrev();                       
      while(cursor != head) {                          
         sB = sB + cursor.getData();                   // add elements to backward string
         if(cursor.getPrev() != head) sB = sB + "<->"; // add "<->" between every element except for first
         cursor = cursor.getPrev();             // move cursor backward
      }// end while
      return (sF + "\n" + sB);
   }// end toString
      
   /**
   * Counts how many of a given integer there are in the list. Big-O:  O(n)
   * @param e
   *     The integer to count.
   * @return count
   *     The amount of times the given integer appears in the list.
   */
   public int countOccurrence(int e) {
      int count=0;
      for(DIntNode cursor = head; cursor != tail; cursor = cursor.getNext()) // move cursor along the list
         if(cursor.getData() == e) count++;   // increment count if cursor finds element
      return count;                     
   } // end countOccurrence
   
   /**
   * Removes all of a given integer from a list. Big-O:   O(n)
   * @param e
   *     The integer to remove.
   * @return found
   *     Boolean value of whether or not the integer was found in the list.
   */
   public boolean removeAll(int e) {
      DIntNode toRemove; // this node will mark the node to "reattach to," ensures that multiple in a row can be removed
      boolean found = true;
      for(DIntNode cursor = head.getNext(); (cursor != tail) && (cursor != null); cursor = cursor.getNext()) { // move cursor along list
         if(cursor.getData() == e) {
            toRemove = cursor;   // if cursor finds element, toRemove begins at cursor
            while(toRemove.getData() == e) {
               toRemove = toRemove.getNext();  // increment toRemove so long as toRemove points to the element to remove
            }// end while
            cursor.getPrev().setNext(toRemove);  // connect the node previous of the cursor to the node toRemove 
            toRemove.setPrev(cursor.getPrev());  // connect toRemove to the node previous of the cursor. All nodes between these two nodes have virtually been removed
            cursor = toRemove;                   // set the cursor to toRemove to avoid redundant/cyclical operations
            found = true;             // a removal has been done
         }// if
      }// end for
      return found;
   }// end removeAll
   
   /**
   * Creates a copy of this list between specified indices (inclusive). Big-O: O(n)
   * @param beginIdx
   *     The index to begin copy
   * @param endIdx
   *     The index to end copy
   * @precondition
   *     Either the beginning index or ending index is outside the bounds of the list.
   * @return sublist
   *     The copy of the list of elements between the given indices (inclusive).
   */ 
   public DoublyLinkedListDummy subList(int beginIdx, int endIdx) {
      if(beginIdx < 0 || endIdx < 0 || beginIdx > endIdx) { // (preconditions)
         System.out.println("Invalid indices");
         return null;
      }
      DoublyLinkedListDummy sublist = new DoublyLinkedListDummy();
      DIntNode cursor = head.getNext(); // begin cursor at first element
      int i = 0;
      while(i <= endIdx) { // begin loop at
         if(i >= beginIdx) {           // begin transcribing when beginIdx has been reached
            if(cursor == tail) {       // if endIdx is too large...
               System.out.println("End Index extends past list size");
               return null;            // return null (precondition)
            }// end if
            sublist.addEnd(cursor.getData()); // transcribe sublist
         }// end if
         cursor = cursor.getNext();    // move cursor
         i++;                          // for every increment of i
      }// end while
      return sublist;
   }// end subList
   
   /**
   * Prints each unique value in the list and how many times it occurs.
   */
   public void printStatistics() {   
      System.out.println("number occurrence"); // print header
      for(DIntNode cursor = head.getNext(); cursor != tail; cursor = cursor.getNext()) { // move cursor along list
         if(unique(cursor)) // only print unique values
            System.out.printf("%-6d %d\n", cursor.getData(), countOccurrence(cursor.getData())); // print the value and its occurences
      }// end for
   }//end printStatistics
   
   /**
   * Method used in printStatistics to ensure unique values.
   * @return
   *     Boolean, true if element is unique, false if not.
   */
   private boolean unique(DIntNode node) {
      for(DIntNode cursorPrev = node.getPrev(); cursorPrev != head; cursorPrev = cursorPrev.getPrev()) // backtrack value check starting at most recent node before current
         if(cursorPrev.getData() == node.getData()) return false;               // if the element was found prior, return false, because this node was not unique
      return true;
   }// end unique
   
}// end DoublyLinkedListDummy