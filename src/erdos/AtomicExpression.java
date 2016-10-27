package erdos;

import java.util.ArrayList;

public class AtomicExpression {
	
	private ArrayList<AtomicTerm> terms;
	
	public AtomicExpression (ArrayList<AtomicTerm> t) {
		terms = t;
	}
	
	public RealNumber findDegree (Variable var) { 
		RealNumber degree = new RealNumber (0);
		
		for (int i = 0; i < terms.size (); i ++) {
			
			if (terms.get (i).getVariable ().equals (var)
					&& terms.get (i).getExponent ().evaluate () > degree.evaluate ()) {
				
				degree = terms.get (i).getExponent ();
			}
		}
		
		return degree;
	}
	
	public RealNumber findCoefficient (Variable var, RealNumber exp) {
		RealNumber coefficient = new RealNumber (0);
		
		for (int i = 0 ; i < terms.size (); i ++) {
			
			if (terms.get (i).getVariable ().equals (var)
					&& terms.get (i).getExponent ().evaluate () == exp.evaluate ()) {
				
				coefficient.add(terms.get (i).getCoefficient ());
			}
		}
		
		return coefficient;
	}
	
	public RealNumber findConstant () {
		RealNumber constant = new RealNumber (0);
		
		for (int i = 0; i < terms.size (); i ++) {
			
			if (terms.get (i).getExponent ().evaluate () == 0) {
				constant.add (terms.get (i).getCoefficient ());
			}
		}
		
		return constant;
	}
	
	public void collectLikeTerms () {
		
		for (int i = 0; i < terms.size (); i ++) {
			
			for (int j = 0; j < terms.size (); j ++) {
				
				if (i != j
						&& terms.get (i).getVariable ().equals (terms.get (j).getVariable ())
						&& terms.get (i).getExponent ().evaluate () == terms.get (j).getExponent ().evaluate ()) {
					
					terms.get (i).getCoefficient ().add (terms.get (j).getCoefficient ());
					terms.remove (j);
				}
			}
		}
	}
	
	public void multiply (RealNumber num) {
		
		for (int i = 0; i < terms.size (); i ++) {
			terms.get (i).getCoefficient ().multiply (num);
		}
	}
	
	public void divide (RealNumber num) {
		num.reciprocate ();
		multiply (num);
		num.reciprocate ();
	}
	
	public String toString () {
		String output = "";
		
		for (int i = 0; i < terms.size (); i ++) {
			
			boolean coefficientNegated = false;
			
			if (i > 0) {
				
				if (terms.get (i).getCoefficient ().evaluate () < 0) {
					output += " - ";
					terms.get (i).getCoefficient ().negate ();
					coefficientNegated = true;
					
				} else {
					output += " + ";
				}
			}
			
			output += terms.get (i);
			
			if (coefficientNegated) {
				terms.get (i).getCoefficient ().negate ();
			}
		}
		
		return output;
	}
	
	public void setTerms (ArrayList<AtomicTerm> t) {
		terms = t;
	}
	
	public ArrayList<AtomicTerm> getTerms () {
		return terms;
	}
}
