// Alexander Gonzales
// CS 272 - Data Structures
// 3/19/2019
// Lab 8
// ArrayQueue.java
// purpose: Define an Array-structured Queue containing generic data that implements MyQueue.java 


/**
* Defines of queue of generic data structured as a singly linked list
*/
public class LinkedQueue<E> implements MyQueue<E> {
  
   /**
   * The front node of the queue 
   */
   private SNode front;
   
   /**
   * The last node of the queue
   */
   private SNode rear;
   
   /**
   * The number of elements in the queue
   */
   private int elements;
   
   /**
   * Default constructor for the linked list queue
   */
   public LinkedQueue() {
      this.front = this.rear = null;
      this.elements = 0;
   }// end LinkQueue
   
   /**
   * Method to add generic type datum to queue
   * @param e
   * Generic type data to add to queue
   */
   public void enqueue(E e) {
      SNode newNode = new SNode(e); // initialize a new node containing given data
      if(this.rear == null)                // if this is the first node,
         this.front = this.rear = newNode; // then the new node is both the front and the rear
      else {                               // otherwise,
         this.rear.setLink(newNode);       // connect the rear to the new node
         this.rear = newNode;              // and declare the new node as the rear
      }
      this.elements++;   // increase number of elements
   }// end enqueue
   
   /**
   * Method to remove and return the first element in the queue
   * @return temp
   * The first element in the queue (which is removed)
   */
   public E dequeue() {
      if(this.isEmpty()) return null;    // if queue is empty, return null
      E temp = (E)this.front.getData();  // record first element of queue
      this.front = this.front.getLink(); // declare the node after the front as the new front
      this.elements--;                   // decrease the number of elements in queue 
      return temp;                       // return saved first element of queue
   }// end dequeue
   
   /**
   * Method to return first element in queue
   * @return
   * First element in the queue (not removed)
   */
   public E front() {
      if(isEmpty()) return null;      // if queue is empty, return null
      return (E)this.front.getData(); // otherwise, return the first element of queue
   }// end front
   
   /**
   * Method to find quantity of elements in queue
   * @return
   * Integer number of elements in queue
   */
   public int size() {
      return this.elements;
   }// end size
   
   /**
   * Method to determine whether or not the queue is empty
   * @return
   * Boolean true if empty, false if not, condition based on 'elements'
   */
   public boolean isEmpty() {
      return ( this.elements == 0 );
   }// end isEmpty
   
   /**
   * Method to turn elements of queue into a string
   * @return s
   * The elements of the queue as a string
   */
   public String toString() {
      String s = "";  // initialize an empty string
      for(SNode cursor = this.front; cursor != null; cursor = cursor.getLink()) { // move along linked list
         s += (E)cursor.getData();               // add each element to the end of the string
         if(cursor.getLink() != null) s += "<-"; // add "<-" to each element except for last
      }// end for
      return s;     // return string
   }// end toString
}// end LinkedQueue