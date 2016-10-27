package erdos;

import java.util.ArrayList;

public class Factor {
	
	private AtomicExpression factor;
	private RealNumber exponent;
	
	public Factor (AtomicExpression fact) {
		factor = fact;
		exponent = new RealNumber (1);
	}
	
	public Factor (AtomicExpression fact, RealNumber exp) {
		factor = fact;
		exponent = exp;
	}
	
	public Factor (Factor fact) {
		factor = fact.getFactor ();
		exponent = fact.getExponent ();
	}
	
	public FactorTerm powerExpand () {
		Factor tempFactor = new Factor (this);
		ArrayList<Factor> factors = new ArrayList<Factor> ();
		
		while (tempFactor.getExponent ().evaluate () > 1) {
			factors.add (new Factor (factor));
			tempFactor.getExponent ().subtract (new RealNumber (1));
		}
		
		factors.add (tempFactor);
		return new FactorTerm (factors);
	}
	
	public String toString () {
		
		if (exponent.evaluate () == 1) {
			
			if (factor.getTerms ().size () == 1) {
				return factor.toString ();
				
			} else {
				return "( " + factor + " )";
			}
			
		} else {
			return "( " + factor + " ) ^ " + exponent;
		}
	}
	
	public void setFactor (AtomicExpression fact) {
		factor = fact;
	}
	
	public void setExponent (RealNumber exp) {
		exponent = exp;
	}
	
	public AtomicExpression getFactor () {
		return factor;
	}
	
	public RealNumber getExponent () {
		return exponent;
	}
}
