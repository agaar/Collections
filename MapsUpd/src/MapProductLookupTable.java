import java.util.HashMap;
import java.util.Map;

public class MapProductLookupTable implements ProductLookupTable {

    private final Map<Integer, Product> idToProduct = new HashMap<>();

    @Override
    public Product lookupById(int id) {
        return idToProduct.get(id);
    }

    @Override
    public void addProduct(Product productToAdd) {
        if(idToProduct.containsKey(productToAdd.getId()) ) {    //metoda 'put' gdy dodamy drugi raz ten sam klucz,
                                                                // podmienia nową wartość do klucza, nie chcemy tego
            throw new IllegalArgumentException(
                    "Unable to add product, duplicate id for: " + productToAdd);
        }
        idToProduct.put(productToAdd.getId(), productToAdd);
    }

    @Override
    public void clear() {
        idToProduct.clear();
    }
}