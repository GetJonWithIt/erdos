package erdos;

public class ComplexNumber {
	
	private RealNumber realPart;
	private RealNumber imaginaryPart;
	
	public ComplexNumber (RealNumber real) {
		realPart = real;
		imaginaryPart = new RealNumber (new RationalNumber (0));
	}
	
	public ComplexNumber (RealNumber real, RealNumber imaginary) {
		realPart = real;
		imaginaryPart = imaginary;
	}
	
	public String toString () {
		
		if (imaginaryPart.evaluate () == 0) {
			return realPart.toString ();
			
		} else if (imaginaryPart.evaluate () == 1) {
			
			 if (realPart.evaluate () == 0) {
				 return "i";
				 	
			 } else {
				 return realPart + " + i";
			 }
			 
		} else {
			
			if (realPart.evaluate () == 0) {
				return imaginaryPart + " i";
				
			} else {
				return realPart + " + " + imaginaryPart + " i"; 
			}
		}
	}
	
	public void setRealPart (RealNumber real) {
		realPart = real;
	}
	
	public void setImaginaryPart (RealNumber imaginary) {
		imaginaryPart = imaginary;
	}
	
	public RealNumber getRealPart () {
		return realPart;
	}
	
	public RealNumber getImaginaryPart () {
		return imaginaryPart;
	}
}
