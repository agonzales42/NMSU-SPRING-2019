// Alexander Gonzales
// CS 273
// 2/11/2019
// Lab 3 - IntNode.java
// **********
// Purpose: Define IntNode class


public class IntNode {

   private int data; // an integer that each node contains
   private IntNode link; // the reference of the next IntNode in the chain
   
   public IntNode() { // default constructor
      data = 0;
      link = null;
   } // end IntNode (default)
   
   public IntNode(int _data, IntNode _node) { // constructor with new data and given link to next node
        data = _data;
        link = _node;
   } // end IntNode (2 arg constructor)
   
   public int getData() { // data accessor
      return data;
   } // end getData
   
   public IntNode getLink() { // link accessor
      return link;
   } // end getLink
   
   public void setData(int newData) { // data mutator
      data = newData;
   } // end setData
   
   public void setLink(IntNode newLink) { // link mutator
      link = newLink;
   } // end setLink
   
   public static int listLength(IntNode head) { // returns count of elements in the IntNode train
      int count = 0;
      for(IntNode cursor = head; cursor != null; cursor = cursor.link) count++;
      return count;
   } // end listLength
   
   public String toString() { // returns a string of each element of the train in order
      String s = "";
      for(IntNode cursor = this; cursor != null; cursor = cursor.link) {
         s = s + cursor.data;
         if(cursor.link != null) s = s + "->"; // so the '->' does not come after the last element
      }
      return s;
   } // end toString
   
   public void addNodeAfterThis(int newdata) { // sticks a node between the current node and the next
      IntNode newNode = new IntNode(newdata, null);
      newNode.setLink(this.getLink());
      this.setLink(newNode);
   } // end addNodeAfterThis
   
   public static boolean search(IntNode head, int data) { // checks each element in the given train for the specified data
      for(IntNode cursor = head; cursor != null; cursor = cursor.link)
         if(cursor.data == data) return true; // returns true if the data has been found 
      return false; // returns false otherwise
   } // end search
   
   public void removeNodeAfterThis() { // pulls the next node after current node out of the train
      this.setLink(this.getLink().getLink()); // next node is removed by being 'skipped'
   } // end removeNodeAfterThis

} // end IntNode