/**
 * Filename : GenericTest.java
 * Beschreibung :
 * Author : Mouaad Gssair
 * Imm.Nummer : 294618
 * 
*/

//Note
/*Zur Erzeugung von Date
 * GregorianCalendar theCalTime = new GregorianCalendar(1976,2,12);
 * Date theDate = new Date(theCalTime.getTimeInMillis());
 */
/*
 * Zur Formatierung
 * SimpleDateFormat theFormatter = new SimpleDateFormat("dd.MM.yyyy");
 * String theString = theFormatter.format(theDate);
 * System.out.println(theString);
 */

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;


public abstract class GenericTest implements Serializable {
	
	private String name;
	private Date date;
	protected Measurement[] measurementArray=new Measurement[0];
	//creat a Constractor
	public GenericTest(String name)
	{
		this.name = name;
	}
	public void readRandomValues()
	{
		int pulse, systolic, diastolic;
		for (int i = 0; i < measurementArray.length; i++)
        {
            pulse = rand(70, 140);
            systolic = rand(40, 120);
            diastolic = rand(40, 80);
            measurementArray[i] = new Measurement(pulse, diastolic, systolic);
        }
	}
	public void readValues(int index,int pulse, int dia, int sys)
	{
		measurementArray[index] = new Measurement(pulse, dia, sys);
	}
	public int rand (int min , int max)
	{
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		return randomNum;
	}
	
	//set value of name 
	//string name { get; set; }
	public void setName(String newName)
	{
		name = newName;
	}
	//get value of name
	public String getName()
	{
		return (name);
	}

	public Date getTime()
	{
		return date;
	}
	public Measurement[] getMeasurementArray()
    {
        return measurementArray;
    }
	public void print(PrintWriter printWriter)
	{
		
		printWriter.println("\nName : " + name);
		printWriter.println("\nDate : " + date);
		for(int i = 0 ; i < (measurementArray.length - 1);i++ )
		{
			printWriter.printf("\nMessung: %i", (i+1));
			measurementArray[i].printValues(printWriter);
		}
		printWriter.println("----------------------------------------------------------------");
		
	}

	public abstract String analyzeValues();
	
	public void startTest()
	{
		GregorianCalendar now = new GregorianCalendar();
		date = new Date(now.getTimeInMillis());
	}
}
