// CS 273
// Alexander Gonzales
// Lab 1
// 1/28/2019
// **********************
// Inputs: none
// Outputs: tests on class Book, defined below


public class Book implements Cloneable { // define class Book
  
   
   // Declare class variables
  
   private String title;                 // book title
   private int numAuthors;               // number of authors
   private String[] author;              // list of authors
   private String ISBN;                  // ISBN
   
   // Constructors
   
   public Book () {                      // define default constructor for class Book
      title = null;                      // set title to null
      numAuthors = 0;                    // set number of authors to 0
      ISBN = null;                       // set ISBN to null 
      author = new String[3];            // create array of authors with size 3
   } // of Book (default)
     
     
   public Book (String _title) {         // define constructor for class Book with known title 
      title = _title;                    // set title of book equal to known title
      numAuthors = 0;                    // set number of authors to 0
      ISBN = null;                       // set ISBN to null
      author = new String[3];            // create array of authors with size 3
   } // of Book (title known)
   
   
   
   // Accessors
   
   public String getTitle() {            // accessor for title
      return title;
   } // of getTitle
   
   public int getAuthorNumber() {        // accessor for number of authors
      return numAuthors;
   } // of getAuthorNumber
   
   public String getISBN() {             // accessor for ISBN
      return ISBN;
   } // of get ISBN
   
   
   //Mutators
   public void setTitle (String _title) {// mutator for title
      title = _title;                    // set title to new title
   } // of setTitle
   
   public void setISBN (String _ISBN) {  // mutator for ISBN
      ISBN = _ISBN;                      // set ISBN to new ISBN 
   } // of setISBN
   
   public boolean addAuthor (String newAuthor) { // mutator for authors
      if(numAuthors < author.length) {           // ensure that the list of authors does not excede array length
         author[numAuthors] = newAuthor;         // enter new author into the list
         numAuthors++;
         return false;                          // increment the number of authors         
      }else        
       return true;                 
   } // of addAuthor
   
   
   // Copy the Book
   
   public Book clone() {                         // define clone constructor
      Book bookCopy;                             // declare the copy
      try {
         bookCopy = (Book) super.clone();        // use super class to clone book
    
      } catch (CloneNotSupportedException e) {   
         System.out.println(e.getMessage());
         throw new RuntimeException("This class does not implement Cloneable.");
         
      } // of try-catch
      
      return bookCopy;
      
   } // of clone
      
   
   
   
   public boolean equals(Object obj) {                      // define equals method to compare two books
      Book mobj = Book.class.cast(obj);                     // cast obj as a book
     
      if(!title.equals(mobj.title)) return false;           // test titles
      if(!ISBN.equals(mobj.ISBN)) return false;             // test ISBN's
      if(numAuthors != mobj.numAuthors) return false;       // test Number of Authors
      
      for(int i = 0; i<numAuthors; i++) {
        if(!author[i].equals(mobj.author[i])) return false; // test authors
      } // end for
     
      return true;                                          // statement is executed if all respective variables are equal
      
   } // end equals
          
   
   public String toString() {                
   
      String authorsList = "";                                // declare list of authors as string
      for(int i = 0; i < numAuthors; i++) {                   // format list of authors
         authorsList = authorsList.concat(", " + author[i]); 
      } // end of for
    
      return title + ", " + ISBN + ", " + numAuthors + authorsList; // title, ISBN, number of Authors, list of authors
   } // end toString
   

      
   public static String[] getAllAuthors(Book b1, Book b2) {
      
      int b1Size = b1.getAuthorNumber();               
      int b2Size = b2.getAuthorNumber();
      
      String[] returnString = new String[b1Size + b2Size];   // declare new array of size total-authors
      
      int T = 0;                                       // int T to serve as new array index operand
      boolean isRepeat;                                // boolean to test if current working author already exists in new array
      
      for(int i = 0; i < b1Size; i++) {                 
         isRepeat = false;
      
         for(int j = 0; j < T; j++) {
            if(b1.author[i].equals(returnString[j]))   // test first book authors against all existing authors in new array
               isRepeat = true;
         } // end for
      
         if(!isRepeat) { 
            returnString[T] = b1.author[i];             // if no repeats found, shove book one author into respective index of new array
            T++;                                       // increment new array index
         } // end if
      } // end for
      
      
     
      for(int i = 0; i < b2Size; i++) {
     
         isRepeat = false;
      
         for(int j = 0; j<T; j++) {
      
            if(b2.author[i].equals(returnString[j]))   // test second book authors against all existing authors in new array
               isRepeat = true;
      
         } // end for
     
         if(!isRepeat) {
            returnString[T] = b2.author[i];            // if no repeats found, shove book two author into respective index of new array
            T++;                                         // increment new array index  
      
         } // end if
      
      } // end for
               
      return returnString;
   }  

   
   
   public static void main(String[] args) { // Main Method
      /*
      Book b1 = new Book();
      Book b2 = new Book();
      b1.addAuthor("Jake");
      b1.addAuthor("John");
      b1.addAuthor("Jake");
      b2.addAuthor("Joanna");
      b2.addAuthor("Joanna");
      b2.addAuthor("Jim");
      
      for(int i = 0; i < getAllAuthors(b1,b2).length; i++) {
        if(getAllAuthors(b1,b2)[i] != null) System.out.println(getAllAuthors(b1, b2)[i]);
      }
      */
      Book FavoriteBook = new Book();
      FavoriteBook.setTitle("Theory of Everything");
      FavoriteBook.setISBN("283-2874-28173-2939");
      FavoriteBook.addAuthor("Stephen Hawking");
      FavoriteBook.addAuthor("Neil DeGrasse Tyson");
      FavoriteBook.addAuthor("Carl Sagan");
      FavoriteBook.addAuthor("Bill Nye");
      
      System.out.println(FavoriteBook.getTitle());
      System.out.println(FavoriteBook.getISBN());
      System.out.println(FavoriteBook.getAuthorNumber());
      System.out.println(FavoriteBook.toString());
      
      
      Book SummerReading = new Book("Macbeth");
            
      if(FavoriteBook.equals(SummerReading))
         System.out.println("My Summer Reading is my Favorite Book");
      else
         System.out.println("My Summer Reading is not my Favorite Book");
      
      System.out.println();
      
      SummerReading.setISBN("3873-373BB-363");
      SummerReading.addAuthor("William Shakespeare");
      System.out.println(SummerReading.getAuthorNumber());
      
      
      
      System.out.println("SummerReading = " +SummerReading.toString());
      System.out.println("FavoriteBook = " + FavoriteBook.toString());
      
      if(FavoriteBook.equals(SummerReading))
         System.out.println("My Summer Reading is my Favorite Book");
      else
         System.out.println("My Summer Reading is not my Favorite Book");  
     
      System.out.println();
      
      
       for(int i = 0; i < getAllAuthors(FavoriteBook, SummerReading).length; i++)
        if(getAllAuthors(FavoriteBook, SummerReading)[i] != null)
           System.out.println(getAllAuthors(FavoriteBook, SummerReading)[i]);  // test getAllAuthors
         
   } // end main
         
} // end Book
   