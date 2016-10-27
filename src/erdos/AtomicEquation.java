package erdos;

import java.util.ArrayList;

public class AtomicEquation {
	
	private AtomicExpression leftHandSide;
	private AtomicExpression rightHandSide;
	
	public AtomicEquation (AtomicExpression lhs, AtomicExpression rhs) {
		leftHandSide = lhs;
		rightHandSide = rhs;
	}
	
	public RealNumber findDegree (Variable var) {
		
		if (leftHandSide.findDegree (var).evaluate () > rightHandSide.findDegree (var).evaluate ()) {
			return leftHandSide.findDegree (var);
			
		} else {
			return rightHandSide.findDegree (var);
		}
	}
	
	public RealNumber findCoefficient (Variable var, RealNumber exp) {
		RealNumber coefficient = leftHandSide.findCoefficient (var, exp);
		coefficient.subtract (rightHandSide.findCoefficient (var, exp));
		
		return coefficient;
	}
	
	public RealNumber findConstant () {
		RealNumber constant = leftHandSide.findConstant ();
		constant.subtract (rightHandSide.findConstant ());
		
		return constant;
	}
	
	public RealNumber findDiscriminant (Variable var) {
		RealNumber discriminant = new RealNumber (0);
		
		if (findDegree (var).evaluate () == 2) {
			discriminant = findCoefficient (var, new RealNumber (1));
			discriminant.multiply (discriminant);
			
			RealNumber discriminant2 = new RealNumber (4);
			discriminant2.multiply (findCoefficient (var, new RealNumber (2)));
			discriminant2.multiply (findConstant ());
			
			discriminant.subtract (discriminant2);
		}
		
		return discriminant;
	}
	
	public void solve (Variable var) {
		isolate (var);
		leftHandSide.collectLikeTerms ();
		rightHandSide.collectLikeTerms ();
		
		if (findDegree (var).evaluate () == 1) {
			RealNumber coeff = findCoefficient (var, new RealNumber (1));
			leftHandSide.divide (coeff);
			rightHandSide.divide (coeff);
		}
		
	}
	
	public void isolate (Variable var) {
		ArrayList<AtomicTerm> leftTerms = leftHandSide.getTerms ();
		ArrayList<AtomicTerm> rightTerms = rightHandSide.getTerms ();
		
		shiftTermsRight (var, leftTerms, rightTerms);
		shiftTermsLeft (var, leftTerms, rightTerms);
		
		leftHandSide.setTerms (leftTerms);
		rightHandSide.setTerms (rightTerms);
	}
	
	public void shiftTermsRight (Variable var, ArrayList<AtomicTerm> leftTerms, ArrayList<AtomicTerm> rightTerms) {
		boolean foundTerm = true;
		
		while (foundTerm) {
			foundTerm = false;
		
			for (int i = 0; i < leftTerms.size (); i ++) {
				
				if (! leftTerms.get (i).getVariable ().equals (var)) {
					leftTerms.get (i).negate ();
					rightTerms.add (leftTerms.get (i));
					leftTerms.remove (i);
					
					foundTerm = true;
				}
			}
		}
	}
	
	public void shiftTermsLeft (Variable var, ArrayList<AtomicTerm> leftTerms, ArrayList<AtomicTerm> rightTerms) {
		boolean foundTerm = true;
		
		while (foundTerm) {
			foundTerm = false;
			
			for (int i = 0; i < rightTerms.size (); i ++) {
				
				if (rightTerms.get (i).getVariable ().equals (var)) {
					rightTerms.get (i).negate ();
					leftTerms.add (rightTerms.get (i));
					rightTerms.remove (i);
					
					foundTerm = true;
				}
			}
		}
	}
	
	public String toString () {
		return leftHandSide + " = " + rightHandSide;
	}
	
	public void setLeftHandSide (AtomicExpression lhs) {
		leftHandSide = lhs;
	}
	
	public void setRightHandSide (AtomicExpression rhs) {
		rightHandSide = rhs;
	}
	
	public AtomicExpression getLeftHandSide () {
		return leftHandSide;
	}
	
	public AtomicExpression getRightHandSide () {
		return rightHandSide;
	}
}
