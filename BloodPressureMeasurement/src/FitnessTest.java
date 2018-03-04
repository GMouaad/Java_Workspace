import java.io.Serializable;

/**
 * Projekt : BloodPressureMeasurement
 * Filename : FitnessTest.java
 * Beschreibung :
 * Author : Mouaad Gssair
 * Imm.Nummer : 294618
 * Verlauf : Oct 31, 2017
*/


public class FitnessTest extends GenericTest implements Serializable
{
	private FitnessControl fitnessControlDialog;
	
	public FitnessTest(String name) 
	{
		super(name);
		measurementArray = new Measurement[4];
	}
	
	public String analyzeValues()
    {
		String analysResult=" ";
		int checkPulse=0;
		int checkDia=0;
		int checkSys=0;
		
        for (int i = 0; i < measurementArray.length; i++) {
             checkPulse +=  measurementArray[i].getPulse();
             checkDia += measurementArray[i].getDiastolic();
             checkSys += measurementArray[i].getSystolic(); }
        System.out.println(checkPulse);
        
        if(checkPulse/measurementArray.length < 90 || checkPulse/measurementArray.length > 170) {
        	analysResult +="Puls not OK!,   ";
        } else analysResult+="Puls OK!,   ";
        if(checkDia/measurementArray.length < 80 || checkDia/measurementArray.length > 110) {
        	analysResult +="DB not OK!,   ";
        } else analysResult+="DB OK!,   ";
        if(checkSys/measurementArray.length < 110 || checkSys/measurementArray.length > 140) {
        	analysResult +="SB not OK!";
        } else analysResult+="SB OK!";
        return analysResult;
    }
	public void startTest()
	{
		fitnessControlDialog = new  FitnessControl();
		fitnessControlDialog.showDialog();
	}
	
	public String toString()
	{
		return (super.getName());
	}

}
