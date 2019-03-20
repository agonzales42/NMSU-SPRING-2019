// Alexander Gonzales
// CS 272 - Data Structures
// 3/19/2019
// Lab 8
// ArrayQueue.java
// purpose: Define an Array-structured Queue containing generic data that implements MyQueue.java 

/**
* ArrayQueue<E> implements function prototypes in MyQueue<E>, which is a queue of generic type data
*/
public class ArrayQueue<E> implements MyQueue<E>{
  
   /**
   * The index of the first element in queue
   */
   private int front;
   
   /**
   * The index of the last element in queue
   */
   private int rear;
   
   /**
   * An array of generic data
   */
   private E[] data;
   
   /**
   * The number of elements in the queue
   */
   private int elements;
   
   /**
   * Default constructor that sets all instance variables to zero, and initializes 'data' as an array of size 2
   */
   public ArrayQueue() {
      this.rear = 0;
      this.front = 0;
      this.elements = 0;
      data = (E[]) new Object[2];
   }// end default constructor
   
   /**
   * Constructor that sets all instance variables to zero and initializes 'data' with a given size
   * @param initial Capacity
   * The specified size of the array
   */
   public ArrayQueue(int initialCapacity) {
      this.rear = 0;
      this.front = 0;
      this.elements = 0;
      this.data = (E[]) new Object[initialCapacity];
   }// end constructor w/ initial capacity
   
   /**
   * Method to double the size of the array if the 'rear' reaches the end of the array
   */
   private void ensureCapacity() {
      if(this.rear+1 == data.length) { // if rear is the at the last index of the array
         E[] temp = (E[]) new Object[data.length*2]; // create temp array double the size of 'data'
        
         // move 'i' along the list starting at 'front' and ending at 'last', start 'j' at zero, put each element in queue at beginning of temp array
         for(int i = this.front, j = 0; i <= this.rear; i++, j++) temp[j] = this.data[i];
         
         this.data = temp; // point data to temp
         this.front = 0;   // assign front index to beginning of array
         this.rear = elements-1; // assign rear index to last index of queue
      }//end if
   }// end ensureCapacity
   
   /**
   * Method that adds an element to the end of the queue
   * @param e
   * The element of generic type to add to the end of the queue
   */
   public void enqueue(E e) {
      ensureCapacity();
      if(!isEmpty()) this.rear++; // move the rear index along the array; if the array is empty, then the rear is at index 0
      this.data[rear] = e;
      this.elements++; // increase number of elements in queue
   }// end enqueue
   
   /**
   * Method that removes and returns the first element in queue
   * @return temp
   * The first element in the queue
   */
   public E dequeue() {
      if(isEmpty()) return null; // if empty, return null
      E temp = this.data[front]; // save the element at the front
      this.front++; // move the front index to next index
      this.elements--; // decrease number of elements in queue
      return temp; // return the saved front element
   }// end dequeue
   
   /**
   * Method that returns the first element in queue
   * @return
   * The first element in queue
   */
   public E front() {
      if(isEmpty()) return null; // if empty, return null
      return this.data[front];
   }// end front
   
   /**
   * Method to determine if the queue is empty
   * @return
   * Boolean true if queue is empty, false if not. Condition based on 'elements'
   */
   public boolean isEmpty() {
      return (this.elements == 0);
   }// end empty
   
   /**
   * Method to determine size of array
   * @return elements
   * The integer quantity of elements in the queue
   */
   public int size() {
      return this.elements;
   }// end size
   
   /**
   * Method to convert queue to string
   * @return s
   * The string of queue elements
   */
   public String toString() {
      String s = "";
      for(int i = this.front; i <= this.rear; i++) {
         s += this.data[i];
         if(i < this.rear) s += "<-"; // unless data[i] is the last element in the queue, the add "<-" after each element
      }// end for
      return s;
   }// end toString
   
}// end ArrayQueue