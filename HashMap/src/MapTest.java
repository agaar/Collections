import java.util.*;

/**
 * Program demonstruje uzycie mapy z kluczami typu String i wartosciami typu Employee
 */
public class MapTest
{
   public static void main(String[] args)
   {
      Map<String, Employee> staff = new HashMap<>();
      staff.put("144-25-5464", new Employee("Amy Lee"));
      staff.put("567-24-2546", new Employee("Harry Hacker"));
      staff.put("157-62-7935", new Employee("Gary Cooper"));
      staff.put("456-62-5527", new Employee("Francesca Cruz"));

      // wydruk wszystkich pozycji
      System.out.println("Wydruk wszystkich pozycji: \n" + staff);
      System.out.println();

      // usuniecie wartosci
      staff.remove("567-24-2546");

      // podmienienie pozycji
      staff.put("456-62-5527", new Employee("Francesca Miller"));

      // wyszukanie wartosci
      System.out.println("Wyszukanie wartosci o kluczu 157-62-7935: \n" + staff.get("157-62-7935"));
      System.out.println();

      // iteracja przez wszystkie pozycje
       System.out.println("Iteracja przez wszystkie pozycje: ");

      for (Map.Entry<String, Employee> entry : staff.entrySet())
      {
         String key = entry.getKey();
         Employee value = entry.getValue();
         System.out.println("key=" + key + ", value=" + value);
      }
   }
}

