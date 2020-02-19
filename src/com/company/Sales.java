package com.company;

/**
 * Class that represents the items in the store with product num(int), description (String),
 * smoothing factor(double), previous forecast(fore), and last weeks sale(int).
 * Implements Serializable for reading and writing binary files.
 *
 * @author Ben Baldino
 * @version 11/13/2019
 */

import java.io.*;

public class Sales implements Serializable
{
    /*** The product num. */
    private int num;
    /*** The description. */
    private String des;
    /*** The smoothing factor. */
    private double smoo;
    /*** The Previous forecast */
    private double fore;
    /*** The last week's sales. */
    private int last;

    /**
     * This method allows the number, description, smoothing, and sale to change.
     * @param num - the number for the product
     * @param des - the description of the product
     * @param smoo - the smoothing factor of the product
     * @param fore - the previous forecast
     * @param last - the last weeks sale of the product
     */
    public Sales(int num, String des, double smoo, double fore, int last) throws Exception
    {
        setNum(num);
        this.des = des;
        setSmoo(smoo);
        this.fore = fore;
        this.last = last;
    }

    /**
     * Default Constructor for the product
     */
    public Sales()
    {
        num = 0;
        des = "";
        smoo = 0.0;
        fore = 0.0;
        last = 0;
    }

    /**
     * This method returns the number of the product.
     * @return num - the number of the product
     */
    public int getNum()
    {
        return num;
    }

    /**
     * This methods allows the num of the product to be changed.
     * @param num - the number of the product
     */
    public void setNum(int num) throws Exception
    {
        if (num <= 0)
        {
            throw new Exception ("Number must be greater than 0");
        }
        this.num = num;
    }

    /**
     * This method returns the description of the product.
     * @return des - the description of the product
     */
    public String getDes()
    {
        return des;
    }

    /**
     * This methods allows the description of the product to be changed.
     * @param des - the description of the product
     */
    public void setDes(String des)
    {
        this.des = des;
    }

    /**
     * This method returns the smoothing factor of the product.
     * @return smoo - the smoothing factor of the product
     */
    public double getSmoo()
    {
        return smoo;
    }

    /**
     * This methods allows the smoothing factor of the product to be changed.
     * @param smoo - the smoothing factor of the product
     */
    public void setSmoo(double smoo) throws Exception
    {
        if (smoo < .50 && smoo > .95)
        {
            throw new Exception ("Smoothing factor must be between .5 and .95");
        }
        this.smoo = smoo;
    }

    /**
     * This method returns the previous forescast of the product.
     * @return fore - the previous forescast of the product
     */
    public double getFore()
    {
        return fore;
    }

    /**
     * This methods allows the previous forescast of the product to be changed.
     * @param fore - the previous forescast of the product
     */
    public void setFore(double fore)
    {
        this.fore = fore;
    }

    /**
     * This method returns the last weeks sale of the product.
     * @return last - the last weeks sale of the product
     */
    public int getLast()
    {
        return last;
    }

    /**
     * This methods allows the last weeks sale of the product to be changed.
     * @param last - the last weeks sales of the product
     */
    public void setLast(int last)
    {
        this.last = last;
    }

    /**
     * This method combines num, des, smoo, and sale into a single string and returns it.
     * @retun a String with num, des, smoo, andd sale
     */
    public String toString()
    {
        return String.format("%3d %-25s %8.2f %8.2f %5d" , num, des, smoo, fore, last);
    }
}
