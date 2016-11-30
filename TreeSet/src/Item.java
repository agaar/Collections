import java.util.*;


public class Item implements Comparable<Item> {
   private String name;
   private int id;

   public Item(String aName, int aAge) {
      name = aName;
      id = aAge;
   }

   public String getName() {
      return name;
   }

   public String toString() {
      return "[name = " + name + ", id = " + id + "]";
   }

    @Override
    public int compareTo(Item other) {
        return Integer.compare(id, other.id);       //items will be sorted by id by default
    }
}

