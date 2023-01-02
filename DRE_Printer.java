import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.*;

public class DRE_Printer {
   private static Printer printer = null;
   static  class Printer{
      Queue<String> queue=new PriorityQueue<String>();
      public void print() {
         System.out.println("Printer is ready to print...");
         if(queue.isEmpty()){
            System.out.println("No document is available to print...");
         }else{
            while (!queue.isEmpty()){
               String document = queue.remove();
               System.out.println(document+" is printed");
            }
            System.out.println("Print queue is empty...");
         }
         //print documents one by one
      }
   
      public void addDocumentToPrint(String document) {
         //add document to list
         queue.add(document);
         System.out.println("Printing request for "+document+" is sent to the print queue");
      }
   }
   

   public static void main(String ... args) {
      boolean appIsActive = true;
      // initialize printer
      printer = new Printer();
      // loop to keep app running
      while (appIsActive) {
         printMenu();
         int input = getNumberInput("Enter your choice: ");
         appIsActive = runCommandFor(input);
      }
   }

   private static boolean runCommandFor(int input) {
      switch (input){
         case 1:
            String document = getStringInput("Enter the name of the document: ");
            printer.addDocumentToPrint(document);
            break;
         case 2:
            printer.print();
            break;
         case 3:
            System.out.println("Thank you!");
            return false;
      }
      return true;
   }

   private static void printMenu() {
      System.out.println();
      System.out.println("………………….DRE TECHNOLOGY LLC PRINTER.…………………");
      
      System.out.println("Press 1 to send a print request");
      System.out.println("Press 2 to print the documents in the printing queue");
      System.out.println("Press 3 to terminate the program");
      
      System.out.println("…………………………….Printer by SMART.…………………………………");
   }

   private static int getNumberInput(String command) {
      System.out.println(command);
      Scanner sc = new Scanner(System.in);
      return sc.nextInt();
   }

   private static String getStringInput(String command) {
      System.out.println(command);
      Scanner sc = new Scanner(System.in);
      return sc.nextLine();
   }

}
