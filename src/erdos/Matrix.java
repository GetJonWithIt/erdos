package erdos;

import java.util.ArrayList;

public class Matrix {
	
	private ArrayList<Vector> columns;
	
	public Matrix (int size) {
		columns = new ArrayList<Vector> ();
		
		for (int i = 0; i < size; i ++) {
			columns.add (new Vector (size));
		}
	}
	
	public Matrix (int width, int height) {
		columns = new ArrayList<Vector> ();
		
		for (int i = 0; i < width; i ++) {
			columns.add (new Vector (height));
		}
	}
	
	public Matrix (ArrayList<Vector> col) {
		columns = col;
	}
	
	public int findWidth () {
		return columns.size ();
	}
	
	public int findHeight () {
		return columns.get (0).findDimension ();
	}
	
	public boolean isSquare () {
		
		if (findWidth () == findHeight ()) {
			return true;
			
		} else {
			return false;
		}
	}
	
	public String toString () {
		String output = "";
		
		for (int i = 0; i < findHeight (); i ++) {
			output += "{ ";
			
			for (int j = 0; j < findWidth (); j ++) {
				output += columns.get (j).getComponents ().get (i) + " ";
			}
			
			output += "}\n";
		}
		
		return output;
	}
	
	public void setColumns (ArrayList<Vector> col) {
		columns = col;
	}
	
	public ArrayList<Vector> getColumns () {
		return columns;
	}
}
