package com.company;

/**
 * Reads the binary file (sales1.dat) and uses its contents to predict the next weeks sales
 * and then writes and reads the information to a new binary file (sales2.dat).
 *
 * @author Ben Baldino
 * @version 11/14/2019
 */

import java.util.ArrayList;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.*;

public class SalesForecasting
{
    private static ArrayList<Sales> store;
    /**
     * The main method of the project.
     * @throw Exeption if the products do not meet the produc constructor requirements.
     */
    public static void main(String[] args)
    {
        try
        {
            System.out.println("\n\tStart Forecasting");

            FileInputStream fis = new FileInputStream("sales1.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            store = (ArrayList <Sales>) ois.readObject();

            //System.out.println(store);
            calculateNew();
            //displayItems();
            displayUpdated();
            displayItems();

            FileOutputStream fos = new FileOutputStream("sales2.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(store);
            oos.close();

            System.out.println("\nClosed sales2.dat, now verifying contents...");

            FileInputStream fis2 = new FileInputStream("sales2.dat");
            ObjectInputStream ois2 = new ObjectInputStream(fis2);

            store = (ArrayList <Sales>) ois2.readObject();
            displayItems();

            System.out.println("\n\tEnd Forecasting");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage()); //need to fix this.
        }
    }

    /**
     * This method displays all the sales items in the list using the for-each
     * operator and the class' toString() method
     */
    private static void displayItems()
    {
        System.out.println("\n\tCurrent List Of Products in Store\n");
        for(Sales item : store)
            System.out.println(item.toString());
    }

    /**
     * This method calculates the new predicted forecast and
     * displays all the sales items with the new predicted forecasts.
     * @param smoo - the smoothing factor of the product
     * @param fore - the previous forecast
     * @param last - the last weeks sale of the product
     */
    private static void calculateNew()
    {
        System.out.println("\n\tNew Forecast for the Products in the Store:\n");

        double x = 0.0;
        double pf = 0.0;
        double nf = 0.0;
        int s = 0;

        for(Sales item : store)
        {
            x = item.getSmoo();
            pf = item.getFore();
            s = item.getLast();
            nf = (x*pf) + (1-x)*s;
            //return String.format("%s Forecast: %.1f", item.toString() , nf);
            System.out.println(String.format("%s Forecast: %.1f", item.toString() , nf));
        }

    }

    /**
     * This method calculates the new predicted forecast and
     * replaces the old sales and forecast with the updated versions.
     * @param smoo - the smoothing factor of the product
     * @param fore - the previous forecast
     * @param last - the last weeks sale of the product
     */
    private static void displayUpdated()
    {
        System.out.println("\n\tUpdated Products for Store");

        double x = 0.0;
        double pf = 0.0;
        double nf = 0.0;
        int s = 0;

        for(Sales item : store)
        {
            x = item.getSmoo();
            pf = item.getFore();
            s = item.getLast();
            nf = (x*pf) + (1-x)*s;

            item.setFore(nf);
            item.setLast(0);

        }
    }
}