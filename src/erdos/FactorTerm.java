package erdos;

import java.util.ArrayList;

public class FactorTerm {
	
	private ArrayList<Factor> factors;
	
	public FactorTerm (ArrayList<Factor> fact) {
		factors = fact;
	}
	
	public String toString () {
		String output = "";
		
		for (int i = 0; i < factors.size (); i ++) {
			
			if (i > 0) {
				output += " ";
			}
			
			output += factors.get (i);
		}
		
		return output;
	}
	
	public void setFactors (ArrayList<Factor> fact) {
		factors = fact;
	}
	
	public ArrayList<Factor> getFactors () {
		return factors;
	}
}
