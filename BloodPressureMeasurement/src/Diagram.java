import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Projekt : BloodPressureMeasurement
 * Filename : Diagram.java
 * Beschreibung :
 * Author : Mouaad Gssair
 * Imm.Nummer : 294618
 * Verlauf : Jan 2, 2018
*/

/**
 * @author MouaadGssair
 *
 */
public class Diagram extends JPanel {

	private MainContent mainContentInstance;
	private GenericTest actualTest;
	private Measurement[] measurementArray;
	
	/**
	 * 
	 */
	public Diagram(MainContent instance) {
		mainContentInstance = instance;
	}

	/**
	 * Method to draw the diagramm components
	 * @param : graphic
	 */
	public void paintComponent(Graphics graphic){
		super.paintComponent(graphic);
		final int zeroX = 50;							// X-Nullpunkt
		final int zeroY = 310;							// Y-Nullpunkt
		final int endX = 380;							// Endwert X-Achse
		final int endY = 40;							// Endwert Y-Achse
		
		final int legX = 300;							// X-Position Legende
		final int legY = 40;							// Y-Position Legende
		
		graphic.drawLine(zeroX, zeroY, endX, zeroY);
		graphic.drawLine(zeroX, zeroY, zeroX, endY);
		
		this.setBackground(Color.white);
				//  Arrow X-Achse
				graphic.drawLine(endX, zeroY, endX-10, zeroY+5);
				graphic.drawLine(endX, zeroY, endX-10, zeroY-5);
				
				// Arrow Y-Achse
				graphic.drawLine(zeroX, endY, zeroX+5, endY+10);
				graphic.drawLine(zeroX, endY, zeroX-5, endY+10);
				
				//  Achsen-Beschriftung 
				graphic.setFont(new Font("Arial", Font.PLAIN, 10)); 
				graphic.drawString("Messwert", endX-20, zeroY+20);	// x-Achse
				graphic.drawString("Puls", zeroX-40, endY+5);			// y-Achse
				graphic.drawString("Blutdruck", zeroX-40, endY-10);	// y-Achse
				
				//  Legende 
				graphic.setFont(new Font("Arial", Font.PLAIN, 11));
				
				graphic.setColor(Color.red);
				graphic.fillRect(legX, legY-5, 4, 4);
				graphic.drawString("Puls", legX+10, legY);
				
				graphic.setColor(Color.blue);
				graphic.fillRect(legX, legY+10, 4, 4);
				graphic.drawString("diastolischer Blutdruck", legX+10, legY+15);
				
				graphic.setColor(Color.green);
				graphic.fillRect(legX, legY+25, 4, 4);
				graphic.drawString("systolischer Blutdruck", legX+10, legY+30);
		
				// draw Measurement
				actualTest = mainContentInstance.getActualTest();
				if(actualTest != null){
					measurementArray = actualTest.getMeasurementArray();
					if(measurementArray[0] != null)
					{
						mainContentInstance.setAnalysLabel(actualTest.analyzeValues());
						for(int i=0 ; i < measurementArray.length ; i++){
							graphic.setColor(Color.red);
							graphic.fillRect(40+zeroX+i*40, zeroY-measurementArray[i].getPulse(), 4, 4);
							graphic.setColor(Color.blue);
							graphic.fillRect(40+zeroX+i*40, zeroY-measurementArray[i].getDiastolic(), 4, 4);
							graphic.setColor(Color.green);
							graphic.fillRect(40+zeroX+i*40, zeroY-measurementArray[i].getSystolic(), 4, 4);
						}	
					}
				}
				
				
	}
	
	
}