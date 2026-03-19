import java.io.*;
import java.util.*;

public class PlaceNameArray {
   public static int max_size = 100000;
   public int count = 0;
   public PlaceNameEntry[] placeNames;
   public int countComparison = 0 ;
   
   public PlaceNameArray (int max_size) {
      placeNames = new PlaceNameEntry[max_size];
   }
   
   public void load(String filename, int N){
         
      File file = new File(filename);
      
      try(Scanner scan = new Scanner(file)){
         
         scan.nextLine();
         
         while(scan.hasNextLine() && count <  N){
         
            String line = scan.nextLine();
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0]);
            String placeName = parts[1];
            String municipality = parts[2];
            String province = parts[3];
            String population = parts[4];
            
            PlaceNameEntry object = new PlaceNameEntry(id, placeName, municipality, province, population);
            boolean duplicate = false;

            for (int i = 0; i < count; i++) {
               if (placeNames[i].getPlaceName().compareTo(placeName) == 0) {
                  duplicate = true;
                  break;
               }
            }

            if (duplicate) {
               continue;
            }

            placeNames[count] = object;
            count++;           
         }
      }
      
      catch (FileNotFoundException error) {
         System.out.println("File not found.");
      }
   }
   
   public PlaceNameEntry search(String placeName)   {
   
      countComparison = 0;
      
      for( int i = 0 ; i < count ; i++ ) {
      
         countComparison++;
      
         if(placeNames[i].getPlaceName().compareTo(placeName) == 0) {
      
            return placeNames[i];
      
         }
      
      }
       return null; 
   } 
}
   
   
      