// Alexander Gonzales
// CS 272 - Data Structures
// 3/19/2019
// Lab 8
// MyQueue.java
// purpose: Interface to declare Queue methods

/**
* The Queue is a first in, first out structure where elements are added to the end and removed from the front
*/
public interface MyQueue<E> {
   
   /**
   * Method to add elements to end of queue
   */
   public void enqueue(E e);
   
   /**
   * Method to remove and return elements at beginning of queue
   */
   public E dequeue();
   
   /**
   * Method to return element at beginning of queue
   */
   public E front();
   
   /**
   * Method to find quantity of elements in queue
   */
   public int size();
   
   /**
   * Method to determine if queue is empty
   */
   public boolean isEmpty();
}// end MyQueue