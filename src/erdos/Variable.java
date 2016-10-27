package erdos;

public class Variable {
	
	private String name;
	
	public Variable (String n) {
		name = n;
	}
	
	public String toString () {
		return name;
	}
	
	public boolean equals (Variable var) {
		
		if (name == var.getName()) {
			return true;
			
		} else {
			return false;
		}
	}
	
	public void setName (String n) {
		name = n;
	}
	
	public String getName () {
		return name;
	}
}
