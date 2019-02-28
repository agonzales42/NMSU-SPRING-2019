// Alexander Gonzales
// CS 272
// 2/28/2019
// Lab 5 - DoublyLinkedListDummyTest.java
// **********
// Purpose: Test DoublyLinkedListDummy class

class DoublyLinkedListDummyTest {
   public static void main(String[] args) {

      DoublyLinkedListDummy list1 = new DoublyLinkedListDummy();
      for(int i = 1; i<5; i++) list1.addEnd(i);
      System.out.println(list1.toString());
      list1.removeFromHead();
      System.out.println(list1.toString());
      list1.addEnd(7);
      list1.addEnd(6);
      list1.addEnd(6);
      list1.addEnd(7);
      list1.addEnd(7);
      list1.addEnd(8);
      list1.addEnd(9);
      list1.addEnd(9);
      list1.addEnd(9);
      list1.addEnd(7);
      System.out.println(list1.toString());
      list1.printStatistics();
      System.out.println("Occurrences of 7: " + list1.countOccurrence(7));
      list1.removeAll(7);
      System.out.println(list1.toString());
      System.out.println(list1.subList(2,5));
      System.out.println(list1.subList(2,20));
      DoublyLinkedListDummy list2 = list1.subList(3,7);
      System.out.println(list2);
      DIntNode jack = new DIntNode(17);
      DIntNode diane = new DIntNode(16);
      list2.setHead(jack);
      list2.setTail(diane);
      System.out.println(list2);
      }
}