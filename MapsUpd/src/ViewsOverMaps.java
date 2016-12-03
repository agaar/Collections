import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ViewsOverMaps
{
    public static void main(String[] args) {
        final Map<Integer, Product> idToProduct = new HashMap<>();
        idToProduct.put(1, ProductFixtures.door);
        idToProduct.put(2, ProductFixtures.floorPanel);
        idToProduct.put(3, ProductFixtures.window);

        System.out.println(idToProduct);

        System.out.println("---------------------------------------------------------------------------------");
        final Set<Integer> ids = idToProduct.keySet();  //Set because keys are unique
        System.out.println("Set of keys: \t" + ids);

        //if we modificate a Set, a Map also changes
        ids.remove(1);
        System.out.println("After remove: \t" + ids);
        System.out.println("Map: \t\t\t" + idToProduct);

        //we cant add element to the set, because in Map there cant be a key without the value:
        //ids.add(1);       UnsupportedOperationException

        System.out.println("----------------------------------------------------------------------------------");
        final Collection<Product> products = idToProduct.values();
        System.out.println("Collection of values: " + products);
        products.remove(ProductFixtures.floorPanel);
        System.out.println("After remove: \t\t" + products);
        System.out.println("Map: \t\t\t\t" + idToProduct);

        //we cant add element to the Collection, because in Map there cant be a value without the key:
        //products.add(ProductFixtures.floorPanel);      //UnsupportedOperationException

        System.out.println("------------------------------------------------------------------------------------");
        final Set<Map.Entry<Integer, Product>> entries = idToProduct.entrySet();
        for(Map.Entry<Integer, Product> entry : entries) {
            System.out.println("Using entrySet: " + entry.getKey() +" -> " + entry.getValue());
            entry.setValue(ProductFixtures.floorPanel);
        }
        System.out.println("Updated value: " + idToProduct);
    }
}
