import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTest
{
   public static void main(String[] args)
   {
      // utworzenie list a i b
      List<String> a = new LinkedList<>();
      a.add("Ania");
      a.add("Karol");
      a.add("Eryk");

      List<String> b = new LinkedList<>();
      b.add("Bartek");
      b.add("Daniel");
      b.add("Franek");
      b.add("Gosia");

      // Scalenie list a i b

      ListIterator<String> aIter = a.listIterator();  //iterator listy a
      Iterator<String> bIter = b.iterator();

      while (bIter.hasNext())
      {
         if (aIter.hasNext()) aIter.next();
         aIter.add(bIter.next());
      }

      System.out.println("Lista 'a' po scaleniu: \t\t\t\t\t\t\t\t\t" + a);

      // Usuniecie co drugiego slowa z listy b

      bIter = b.iterator();
      while (bIter.hasNext())
      {
         bIter.next();              // opuszczenie jednego elementu
         if (bIter.hasNext())
         {
            bIter.next();           // opuszczenie nastepnego elementu
            bIter.remove();         // usuniecie elementu
         }
      }
      System.out.println("Lista po usunieciu co drugiego elementu z listy b: \t\t" + b);

      // Usuniecie wszystkich slow znajdujacych sie w liscie b z listy a
      a.removeAll(b);
      System.out.println("Lista a po usunieciu elementow ktore sa na liscie b: \t" + a);
   }
}
