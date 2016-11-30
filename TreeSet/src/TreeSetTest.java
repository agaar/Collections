import java.util.*;

/**
   Program sortujacy zbior elementow
*/
public class TreeSetTest {
   public static void main(String[] args) {
       
       SortedSet<Item> sortedSet = new TreeSet<Item>();
       sortedSet.add(new Item("Agnieszka", 24));
       sortedSet.add(new Item("Piotrek", 7));
       sortedSet.add(new Item("Kasia", 10));
       sortedSet.add(new Item("Julia", 12));
       sortedSet.add(new Item("Bartek", 11));
       sortedSet.add(new Item("Amelia", 13));

       System.out.println("Sorted by id: " + sortedSet);

       //How to sort by name? We have to define a new comparator
       SortedSet<Item> sortedByName = new TreeSet<Item>(new Comparator<Item>(){
          public int compare(Item a, Item b) {
              String nameA = a.getName();
              String nameB = b.getName();
              return nameA.compareTo(nameB);
          }
       });
       sortedByName.addAll(sortedSet);          //adding all items to 'sortedByName' set
       System.out.println("Sorted by name: " + sortedByName);

   }
}