package com.company;

/**
 * Makes an array for store products then populates it and stores the array into
 * binary file (sales1.dat).
 *
 * @author Ben Baldino
 * @version 11/13/2019
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.*;

public class SalesCreation
{
    /*** ArrayList object to store Sales objects in */
    private static ArrayList<Sales> store;

    /**
     * The main method for this project
     * @throw Exeption if the products do not meet the produc constructor requirements.
     */
    public static void main(String[] args) //throws Exception
    {
        try
        {
            System.out.println("\n\tStart Sales Creation");

            store = new ArrayList<Sales>();
            addProductsToStore();
            displayItems();

            FileOutputStream fos = new FileOutputStream("sales1.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(store);
            oos.close();

            System.out.println("\n\tEnd Sales Creation");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());  //need to fix this.
        }
    }

    /**
     * This method adds the five products to the store inventory
     * @param Sales - reference to the Linkedlist object into which
     * to add the five elements
     */
    private static void addProductsToStore() throws Exception
    {
        store.add(new Sales(123, "Heinz Catsup", .8, 45.4, 55));
        store.add(new Sales(244, "Guilden's Mustard", .85, 23.4, 28));
        store.add(new Sales(303, "Lipton Noodle Soup", .9, 9.0, 6));
        store.add(new Sales(445, "Meow Mix Cat Food", .7, 25.7, 43));
        store.add(new Sales(501, "Hershey's Chocolate Syrup", .95, 38.0, 23));
    }

    /**
     * This method displays all the sales items in the list using the for-each
     * operator and the class' toString() method
     */
    private static void displayItems()
    {
        System.out.println("\n\tCurrent List of Products in the Store:\n");
        for(Sales s : store)
            System.out.println(s.toString());
    }
}

