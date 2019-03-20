// Alexander Gonzales
// CS 272 - Data Structures
// 3/19/2019
// Lab 8
// QueueTest.java
// purpose: Test Array Queue and Linked List Queue defined in ArrayQueue.java and LinkedQueue.java


public class QueueTest {
   public static void main(String[] args) {
      
      // Test ArrayQueue
      ArrayQueue arrQueue = new ArrayQueue();
      System.out.println("Size of arrQueue: " + arrQueue.size());
      System.out.println("arrQueue empty: " + arrQueue.isEmpty());
      arrQueue.enqueue(1);
      arrQueue.enqueue(2);
      arrQueue.enqueue(3);
      arrQueue.enqueue(4);
      System.out.println(arrQueue);
      arrQueue.enqueue(5);
      arrQueue.enqueue(6);
      arrQueue.enqueue(7);
      arrQueue.enqueue(8);
      System.out.println(arrQueue);
      System.out.println("Size of arrQueue: " + arrQueue.size());
      System.out.println("Front of arrQueue: " + arrQueue.front());
      for(int i = 4; i < 0; i--) System.out.println("Dequeue: " + arrQueue.dequeue());
      System.out.println(arrQueue);
      System.out.println("Size of arrQueue: " + arrQueue.size());
      System.out.println("Front of arrQueue: " + arrQueue.front());
      System.out.println("arrQueue empty: " + arrQueue.isEmpty());
      for(int i = 4; i > 0; i--) System.out.println("Dequeue: " + arrQueue.dequeue());
      for(int i = 9; i < 13; i++) arrQueue.enqueue(i);
      System.out.println(arrQueue);
      System.out.println("Size of arrQueue: " + arrQueue.size());
      System.out.println("Front of arrQueue: " + arrQueue.front());
      System.out.println("arrQueue empty: " + arrQueue.isEmpty());
      for(int i = arrQueue.size(); i >= 0; i--) System.out.println("Dequeue: " + arrQueue.dequeue());
      System.out.println("Size of arrQueue: " + arrQueue.size());
      System.out.println("Front of arrQueue: " + arrQueue.front());
      System.out.println("arrQueue empty: " + arrQueue.isEmpty());
      
      // Test LinkedQueue
      LinkedQueue linkQueue = new LinkedQueue();
      System.out.println("Size of linkQueue: " + linkQueue.size());
      System.out.println("linkQueue empty: " + linkQueue.isEmpty());
      linkQueue.enqueue('a');
      linkQueue.enqueue("hi");
      linkQueue.enqueue(3);
      linkQueue.enqueue('[');
      linkQueue.enqueue('^');
      linkQueue.enqueue("four twenty");
      linkQueue.enqueue(7);
      linkQueue.enqueue(8);
      System.out.println(linkQueue);
      System.out.println("Size of linkQueue: " + linkQueue.size());
      System.out.println("Front of linkQueue: " + linkQueue.front());
      for(int i = 4; i < 0; i--) System.out.println("Dequeue: " + linkQueue.dequeue());
      System.out.println(linkQueue);
      System.out.println("Size of linkQueue: " + linkQueue.size());
      System.out.println("Front of linkQueue: " + linkQueue.front());
      System.out.println("arrQueue empty: " + linkQueue.isEmpty());
      for(int i = 4; i > 0; i--) System.out.println("Dequeue: " + linkQueue.dequeue());
      for(int i = 9; i < 13; i++) linkQueue.enqueue(i);
      System.out.println(linkQueue);
      System.out.println("Size of linkQueue: " + linkQueue.size());
      System.out.println("Front of linkQueue: " + linkQueue.front());
      System.out.println("linkQueue empty: " + linkQueue.isEmpty());
      for(int i = linkQueue.size(); i >= 0; i--) System.out.println("Dequeue: " + linkQueue.dequeue());
      System.out.println("Size of linkQueue: " + linkQueue.size());
      System.out.println("Front of linkQueue: " + linkQueue.front());
      System.out.println("linkQueue empty: " + linkQueue.isEmpty());
      
   }// end main
}// end class  
   