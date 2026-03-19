import java.io.*;
import java.util.*;

public class PlaceSearchBST {
   public static void main(String args[]){
      Scanner scanner = new Scanner(System.in);
      
      PlaceNameBST object = new PlaceNameBST();  
      int choice = 0;
      while(choice != 3 ) { 
         System.out.println();
         System.out.println("From the menu choose an option: ");
         System.out.println("1. load data \n2. search for place name \n3.Quit");
         choice = scanner.nextInt(); 
         scanner.nextLine(); 
         System.out.println();
         if( choice == 1 ) {
            System.out.println("Enter the file to load: ");
            String filename = scanner.nextLine();
            System.out.println("Enter size of input N : ");
            int N = scanner.nextInt();
            scanner.nextLine();
            object.load(filename, N);
            System.out.println("File loaded.");
         }else if(choice == 2) {
            //boolean found = true;
            System.out.println("Enter the name of the place: ");
            String place_name = scanner.nextLine();
            PlaceNameEntry result = object.search(place_name);
            if (result != null) {
               System.out.println(result);
            } else {
               System.out.println("Not found");
            }            
            System.out.println("Comparisons made: "+object.getComparisonCount());
         } else if(choice!= 3 & choice != 1 & choice != 2){
            System.out.println("Invalid choice, please try again.");
         }

         
      }
      
           
      System.out.println("Goodbye.");
   }
}
