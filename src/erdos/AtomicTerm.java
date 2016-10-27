package erdos;

public class AtomicTerm {
	
	private RealNumber coefficient;
	private Variable variable;
	private RealNumber exponent;
	
	public AtomicTerm (RealNumber num) {
		coefficient = num;
		variable = new Variable ("c");
		exponent = new RealNumber (0);
	}
	
	public AtomicTerm (Variable var) {
		coefficient = new RealNumber (1);
		variable = var;
		exponent = new RealNumber (1);
	}
	
	public AtomicTerm (RealNumber coeff, Variable var) {
		coefficient = coeff;
		variable = var;
		exponent = new RealNumber (1);
	}
	
	public AtomicTerm (Variable var, RealNumber exp) {
		coefficient = new RealNumber (1);
		variable = var;
		exponent = exp;
	}
	
	public AtomicTerm (RealNumber coeff, Variable var, RealNumber exp) {
		coefficient = coeff;
		variable = var;
		exponent = exp;
	}
	
	public void negate () {
		coefficient.negate ();
	}
	
	public String toString () {
		
		if (exponent.evaluate () == 0) {
			return coefficient.toString ();
			
		} else if (exponent.evaluate () == 1) {
			
			if (coefficient.evaluate () == 1) {
				return variable.toString ();
				
			} else {
				return coefficient + " " + variable;
			}
			
		} else {
			
			if (coefficient.evaluate () == 1) {
				return variable + " ^ " + exponent;
				
			} else {
				return coefficient + " " + variable + " ^ " + exponent;
			}
		}
	}
	
	public void setCoefficient (RealNumber coeff) {
		coefficient = coeff;
	}
	
	public void setVariable (Variable var) {
		variable = var;
	}
	
	public void setExponent (RealNumber exp) {
		exponent = exp;
	}
	
	public RealNumber getCoefficient () {
		return coefficient;
	}
	
	public Variable getVariable () {
		return variable;
	}
	
	public RealNumber getExponent () {
		return exponent;
	}
}
