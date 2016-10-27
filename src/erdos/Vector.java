package erdos;

import java.util.ArrayList;

public class Vector {
	
	private ArrayList<RealNumber> components;
	
	public Vector (int dimension) {
		components = new ArrayList<RealNumber> ();
		
		for (int i = 0; i < dimension; i ++) {
			components.add (new RealNumber (0));
		}
	}
	
	public Vector (ArrayList<RealNumber> comp) {
		components = comp;
	}
	
	public int findDimension () {
		return components.size ();
	}
	
	public void negate () {
		
		for (int i = 0; i < findDimension () ; i ++) {
			components.get (i).negate ();
		}
	}
	
	public void scalarMultiply (RealNumber scalar) {
		
		for (int i = 0; i < findDimension (); i ++) {
			components.get (i).multiply (scalar);
		}
	}
	
	public RealNumber dotProduct (Vector v) {
		RealNumber product = new RealNumber (0);
		
		if (findDimension () == v.findDimension ()) {
		
			for (int i = 0; i < findDimension (); i ++) {
				RealNumber temp = components.get (i);
				temp.multiply (v.getComponents ().get (i));
				
				product.add (temp);
			}
		}
		
		return product;
	}
	
	public void crossProduct (Vector v) {
		
		if (findDimension () == v.findDimension ()
				&& findDimension () == 3) {
			ArrayList<RealNumber> c = new ArrayList<RealNumber> ();
			
			RealNumber a1 = new RealNumber (components.get (1));
			RealNumber a2 = new RealNumber (components.get (2));
			RealNumber a3 = new RealNumber (components.get (0));
			
			RealNumber b1 = new RealNumber (components.get (2));
			RealNumber b2 = new RealNumber (components.get (0));
			RealNumber b3 = new RealNumber (components.get (1));
			
			a1.multiply (v.getComponents ().get (2));
			a2.multiply (v.getComponents ().get (0));
			a3.multiply (v.getComponents ().get (1));
			
			b1.multiply (v.getComponents ().get (1));
			b2.multiply (v.getComponents ().get (2));
			b3.multiply (v.getComponents ().get (0));
			
			a1.subtract (b1);
			a2.subtract (b2);
			a3.subtract (b3);
			
			c.add(a1);
			c.add(a2);
			c.add(a3);
			setComponents (c);
		}
	}
	
	public void add (Vector v) {
		
		if (findDimension () == v.findDimension ()) {
			
			for (int i = 0; i < findDimension () ; i ++) {
				components.get (i).add (v.getComponents ().get (i));
			}
		}
	}
	
	public void subtract (Vector v) {
		
		if (findDimension () == v.findDimension ()) {
			v.negate ();
			add (v);
			v.negate ();
		}
	}
	
	public String toString () {
		String output = "";

		for (int i = 0; i < components.size (); i ++) {
			output += "{ " + components.get (i) + " }\n";
		}

		return output;
	}
	
	public void setComponents (ArrayList<RealNumber> comp) {
		components = comp;
	}
	
	public ArrayList<RealNumber> getComponents () {
		return components;
	}
}
