import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
/** porównuje szybkość obu metod: ArrayList i HashMap **/

public class LookupTableComparison
{
    private static final int ITERATIONS = 5;
    private static final int NUMBER_OF_PRODUCTS = 20000;

    private static final List<Product> products = generateProducts();

    public static void main(String[] args)
    {
        runLookups(new MapProductLookupTable());        //tworzy nową Mapę
        runLookups(new ListProductLookupTable());       //tworzy nową Listę
    }

    private static List<Product> generateProducts()
    {
        final List<Product> products = new ArrayList<>();
        final Random weightGenerator = new Random();
        for (int i = 0; i < NUMBER_OF_PRODUCTS; i++)
        {
            products.add(new Product(i, "Product" + i, 10 + weightGenerator.nextInt(10))); //losowe wartości między 10-20
        }
        Collections.shuffle(products);
        Collections.shuffle(products);
        Collections.shuffle(products);
        return products;
    }

    private static void runLookups(final ProductLookupTable lookupTable)
    {
        final List<Product> products = LookupTableComparison.products;
        System.out.println("Running lookups with " + lookupTable.getClass().getSimpleName());

        for (int i = 0; i < ITERATIONS; i++)
        {
            final long startTime = System.currentTimeMillis();

            //dodanie wszystkich produktów do Mapy/Listy
            for (Product product : products)
            {
                lookupTable.addProduct(product);
            }
            //odszukanie każdego z produktów i sprawdzenie jego id
            for (Product product : products)
            {
                final Product result = lookupTable.lookupById(product.getId());
                if (result != product)
                {
                    throw new IllegalStateException("Lookup Table returned wrong result for " + product);
                }
            }
            //usunięcie wszystkiego z Mapy/Listy
            lookupTable.clear();

            System.out.println(System.currentTimeMillis() - startTime + "ms");
        }
    }
}
