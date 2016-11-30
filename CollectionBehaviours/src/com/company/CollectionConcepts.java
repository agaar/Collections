package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionConcepts {

    public static void main(String[] args) {
        Product door = new Product("Wooden door",35);
        Product floorPanel = new Product("Floor panel",25);
        Product window = new Product("Glass window",10);

        Collection<Product> products = new ArrayList<>();
        products.add(door);
        products.add(floorPanel);
        products.add(window);

        //region Printing products

        System.out.println("Prints all products in one line: \n" + products + "\n");

        /*System.out.println("Printing with iterator:");
        final Iterator<Product> productIterator = products.iterator();          //allows to step through products
        while (productIterator.hasNext()) {                                     //if there is next product
            Product product = productIterator.next();
            System.out.println(product);
        }*/

        //A better way of printing all products - foreach loop
        System.out.println("Printing with foreach loop: ");
        for (Product prod: products) {
            System.out.println(prod);
        }
        //--------------------------------------------------------------------------------------------------------------
        //endregion

        //region When do we use iterators?
        //if a weight <= 20 - remove the product
        System.out.println("\nPrinting products that weigh > 20 using iterator: ");
        final Iterator<Product> productIterator = products.iterator();
        while (productIterator.hasNext()) {                                  //if there is next product

            Product product = productIterator.next();
            if(product.getWeight() < 20)  productIterator.remove();          //we cant modify elements with foreach loop
        }
        System.out.println(products);
        System.out.println("Number of elements in collection: " + products.size());
        System.out.println("Colection is empty: " + products.isEmpty());
        System.out.println("Collection contains window: " + products.contains(window));
        System.out.println("Collection contains door: " + products.contains(door));
        //--------------------------------------------------------------------------------------------------------------
        //endregion

        //region Creating another collection
        Collection<Product> otherProducts = new ArrayList<>();
        otherProducts.add(window);
        otherProducts.add(door);

        products.removeAll(otherProducts);
        System.out.println("\nProducts after removeAll(otherProducts): " + products);
        //--------------------------------------------------------------------------------------------------------------
        //endregion


    }

}
