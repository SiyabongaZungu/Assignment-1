import java.io.*;
import java.util.*;

public class PlaceNameBST {
   public BinaryTreeNode<PlaceNameEntry> root;
   public int comparisonCounter;
   int count = 0;
   
   public PlaceNameBST(PlaceNameEntry root, int comparisonCounter)   {
      root = null;
   }
   
   public PlaceNameBST() {
      this.root = null;
      this.comparisonCounter = 0;
   }
   public void insert(PlaceNameEntry data)   {
      root = insert(data, root );
      
   }
   
   public BinaryTreeNode<PlaceNameEntry> insert (PlaceNameEntry d, BinaryTreeNode<PlaceNameEntry> node )
  {
      if (node == null) {
         return new BinaryTreeNode<PlaceNameEntry>(d, null, null);
      }
      if(d.getPlaceName().compareTo(node.data.getPlaceName()) == 0){
         return node;
      }
      if (d.getPlaceName().compareTo(node.data.getPlaceName()) < 0)
      {
        node.left = insert(d, node.left);
      }
      else
      {
         node.right = insert(d, node.right);
      }
      
      return node;
   }

   public void load(String filename, int N)  {
      File file = new File(filename);
      
      try(Scanner scanner = new Scanner(file)){
         
         scanner.nextLine();
         int count = 0;
         while(scanner.hasNextLine()){
            
            if(count >= N) {
               break;
            }
            //count++;
            
            String line = scanner.nextLine();
            
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0]);
            String placeName = parts[1];
            String municipality = parts[2];
            String province = parts[3];
            String population = parts[4];
            
            PlaceNameEntry object = new PlaceNameEntry(id, placeName, municipality, province, population);
            
            insert(object);
            
            count++;
            System.out.println("Inserted: " + placeName);
         }
      } catch (FileNotFoundException error) {
         System.out.println("File not found.");
            
      }
   }
   
  public void load(List<PlaceNameEntry> input, int N) {
       root = null;
       count = 0;

       for (PlaceNameEntry entry : input) {
           if (count >= N)
               break;
           if (!contains(entry.getPlaceName())) {
               root = insert(entry, root);
               count++;
           }
       }
   }   
   
   
   public boolean contains(String placeName) {
   
       BinaryTreeNode<PlaceNameEntry> current = root;
   
       while (current != null) {
   
           int cmp = placeName.compareTo(
                   current.data.getPlaceName());
   
           if (cmp == 0)
               return true;
           else if (cmp < 0)
               current = current.left;
           else
               current = current.right;
       }
   
       return false;
   }
   
   public PlaceNameEntry find(String placeName, BinaryTreeNode<PlaceNameEntry> node) {
      if (node == null) {
         return null; 
      }
      int result = placeName.compareTo(node.data.getPlaceName());
      comparisonCounter++;
   
      if (result == 0) {
         return node.data; 
      } else if (result < 0) {
         return find(placeName, node.left);  
      } else {
         return find(placeName, node.right); 
      }
   }
   
   public PlaceNameEntry search(String placeName) {
      comparisonCounter = 0;
      return find(placeName, root);
   }
   
   public int getComparisonCount() {
      return comparisonCounter;
   }
}