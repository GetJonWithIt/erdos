package erdos;

public class Radix implements IrrationalConstant {
	
	private RealNumber index;
	private RealNumber radicand;
	
	public Radix (RealNumber rad) {
		index = new RealNumber (new RationalNumber (2));
		radicand = rad;
	}
	
	public Radix (RealNumber ind, RealNumber rad) {
		index = ind;
		radicand = rad;
	}
	
	public String toString () {
		
		if (index.evaluate () == 2) {
			return "Sqrt [ " + radicand + " ]";
			
		} else {
			return "Root " + index + " [ " + radicand + " ]";
		}
	}
	
	public double evaluate () {
		return Math.pow (radicand.evaluate (), (1 / index.evaluate ()));
	}
	
	public void setIndex (RealNumber ind) {
		index = ind;
	}
	
	public void setRadicand (RealNumber rad) {
		radicand = rad;
	}
	
	public RealNumber getIndex () {
		return index;
	}
	
	public RealNumber getRadicand () {
		return radicand;
	}
}
