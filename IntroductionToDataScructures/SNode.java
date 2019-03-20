// Alexander Gonzales
// CS 272 - Data Structures
// 3/11/2019
// Lab 7
// SNode.java
// purpose: Define a Node containing generic data to be utilized in LinkStack.java 


/**
* A node of generic data type that contains a datum and a link to the next element
*/
public class SNode<E> {

   /**
   * A datum that the node carries
   */
   private E data;
   
   /**
   * Link to next node
   */
   private SNode<E> link;
   
   /**
   * Default constructor, sets link to null
   */
   public SNode() {
      link = null;
   }// end default constructor
   
   /** 
   * Simple constructor, creates node with given generic data
   */
   public SNode(E initialData) {
      data = initialData;
      link = null;
   }// end simple constructor
   
   
   /**
   * Complex constructor, creates node with given generic data and link to next node
   */
   public SNode(E initialData, SNode<E> initialLink) {
      data = initialData;
      link = initialLink;
   }// end complex constructor
   
   /**
   * Method to return data
   * @return
   *     data
   */
   public E getData() {
      return data;
   }// end getData
   
   /**
   * Method to return next node
   * @return
   *     Next node
   */
   public SNode<E> getLink() {
      return link;
   }// end getLink
   
   /**
   * Method to change data
   * @param newData
   *     New generic data
   */
   public void setData(E newData) {
      data = newData;
   }// end setData
   
   
   /**
   * Method to set next linked node
   * @param newLink
   *     New link to connect to
   */
   public void setLink(SNode<E> newLink) {
      link = newLink;
   }// end setLink
}// end SNode