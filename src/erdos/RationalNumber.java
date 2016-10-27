package erdos;

public class RationalNumber {
	
	private int numerator;
	private int denominator;
	
	public RationalNumber (int num) {
		numerator = num;
		denominator = 1;
	}
	
	public RationalNumber (int num, int den) {
		numerator =  num;
		denominator = den;
	}
	
	public RationalNumber (RationalNumber num) {
		numerator = num.getNumerator ();
		denominator = num.getDenominator ();
	}
	
	public void reciprocate () {
		int temp = numerator;
		numerator = denominator;
		denominator = temp;
	}
	
	public void negate () {
		numerator = -numerator;
	}
	
	public void simplify () {
		
		if (denominator < 0) {
			numerator = -numerator;
			denominator = -denominator;
		}
		
		boolean foundFactor = true;
		
		while (foundFactor) {
			foundFactor = false;
			
			int limit = denominator;
			
			if (Math.abs (numerator) > Math.abs (denominator)) {
				limit = numerator;
			}
			
			for (int i = 2; i <= Math.sqrt (Math.abs (limit)); i ++) {
				
				if ((numerator % i) == 0
						&& (denominator % i) == 0) {
					numerator /= i;
					denominator /= i;
					
					foundFactor = true;
				}
			}
		}
	}
	
	public void add (RationalNumber num) {
		numerator += num.getNumerator () * num.getDenominator ();
		denominator *= num.getDenominator ();
		simplify ();
	}
	
	public void subtract (RationalNumber num) {
		num.negate ();
		add (num);
		num.negate ();
	}
	
	public void multiply (RationalNumber num) {
		numerator *= num.getNumerator ();
		denominator *= num.getDenominator ();
		simplify ();
	}
	
	public void divide (RationalNumber num) {
		num.reciprocate ();
		multiply (num);
		num.reciprocate ();
	}
	
	public String toString () {
		
		if (denominator == 1) {
			return Integer.toString (numerator);
			
		} else {
			return numerator + " / " + denominator;
		}
	}
	
	public double evaluate () {
		return numerator / denominator;
	}
	
	public void setNumerator (int num) {
		numerator = num;
	}
	
	public void setDenominator (int den) {
		denominator = den;
	}
	
	public int getNumerator () {
		return numerator;
	}
	
	public int getDenominator () {
		return denominator;
	}
}
