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

import java.text.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class GenericTest {
	
	private String name;
	private Date date;
	protected Measurement[] measurementArray;
	//creat a Constractor
	public GenericTest(String name)
	{
		this.name = name;
	}
	public void readValues()
    {
        
        int pulse, systolic, diastolic;
        for (int i = 0; i < measurementArray.length; i++)
        {
            pulse = rand(70, 140);
            systolic = rand(40, 120);
            diastolic = rand(40, 80);
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            //measurementArray[i] = new Measurement(pulse, diastolic, systolic, dateFormat.format(date));
            measurementArray[i] = new Measurement(pulse, diastolic, systolic, date);
        }
    }
	public int rand (int min , int max)
	{
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		return randomNum;
	}
	
	//set value of name 
	//string name { get; set; }
	public void MsetNameG(String newName)
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
	public Measurement[] getArray()
    {
        return measurementArray;
    }
	public void print()
	{
		
		System.out.println("Name :\n" + name);
	}


}
