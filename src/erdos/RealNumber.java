package erdos;

public class RealNumber {
	
	private RationalNumber coefficient;
	private IrrationalConstant irrationalConstant;
	private RationalNumber exponent;
	
	public RealNumber (int num) {
		coefficient = new RationalNumber (num);
		irrationalConstant = null;
		exponent = new RationalNumber (0);
	}
	
	public RealNumber (RationalNumber num) {
		coefficient = num;
		irrationalConstant = null;
		exponent = new RationalNumber (0);
	}
	
	public RealNumber (IrrationalConstant irrat) {
		coefficient = new RationalNumber (1);
		irrationalConstant = irrat;
		exponent = new RationalNumber (1);
	}
	
	public RealNumber (RationalNumber coeff, IrrationalConstant irrat) {
		coefficient = coeff;
		irrationalConstant = irrat;
		exponent = new RationalNumber (1);
	}
	
	public RealNumber (IrrationalConstant irrat, RationalNumber exp) {
		coefficient = new RationalNumber (1);
		irrationalConstant = irrat;
		exponent = exp;
	}
	
	public RealNumber (RationalNumber coeff, IrrationalConstant irrat, RationalNumber exp) {
		coefficient = coeff;
		irrationalConstant = irrat;
		exponent = exp;
	}
	
	public RealNumber (RealNumber real) {
		coefficient = new RationalNumber (real.getCoefficient ());
		irrationalConstant = real.getIrrationalConstant ();
		exponent = new RationalNumber (real.getExponent ());
	}
	
	public void reciprocate () {
		coefficient.reciprocate ();
		exponent.negate ();
	}
	
	public void negate () {
		coefficient.negate ();
	}
	
	public void add (RealNumber num) {
		
		if (isRational ()
				&& num.isRational ()) {
			coefficient.add (num.getCoefficient ());
		}
	}
	
	public void subtract (RealNumber num) {
		
		if (isRational ()
				&& num.isRational ()) {
			coefficient.subtract (num.getCoefficient ());
		}
	}
	
	public void multiply (RealNumber num) {
		
		if (isRational ()
				&& num.isRational ()) {
			coefficient.multiply (num.getCoefficient ());
		}
	}
	
	public void divide (RealNumber num) {
		
		if (isRational ()
				&& num.isRational ()) {
			coefficient.divide (num.getCoefficient ());
		}
	}
	
	public boolean isRational () {
		
		if (exponent.evaluate () == 0) {
			return true;
			
		} else {
			return false;
		}
	}
	
	public String toString () {
		
		if (exponent.evaluate () == 0) {
			return coefficient.toString ();
			
		} else if (exponent.evaluate () == 1) {
			
			if (coefficient.evaluate () == 1) {
				return irrationalConstant.toString ();
				
			} else {
				return coefficient + " " + irrationalConstant;
			}
			
		} else {
			
			if (coefficient.evaluate () == 1) {
				return irrationalConstant + " ^ " + exponent;
				
			} else {
				return coefficient + " " + irrationalConstant + " ^ " + exponent; 	
			}
		}
	}
	
	public double evaluate () {
		
		if (irrationalConstant == null) {
			return coefficient.evaluate ();
			
		} else {
			return coefficient.evaluate () * Math.pow (irrationalConstant.evaluate (), exponent.evaluate ());
		}
	}
	
	public void setCoefficient (RationalNumber coeff) {
		coefficient = coeff;
	}
	
	public void setIrrationalConstant (IrrationalConstant irrat) {
		irrationalConstant = irrat;
	}
	
	public void setExponent (RationalNumber exp) {
		exponent = exp;
	}
	
	public RationalNumber getCoefficient () {
		return coefficient;
	}
	
	public IrrationalConstant getIrrationalConstant () {
		return irrationalConstant;
	}
	
	public RationalNumber getExponent () {
		return exponent;
	}
}
