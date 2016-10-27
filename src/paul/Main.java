package paul;

import erdos.*;
import java.util.ArrayList;

public class Main {
	
	public static void main (String[] args) {
		ArrayList<AtomicTerm> lhs = new ArrayList<AtomicTerm> ();
		ArrayList<AtomicTerm> rhs = new ArrayList<AtomicTerm> ();
		
		lhs.add(new AtomicTerm (new RealNumber (2), new Variable ("x"), new RealNumber (2)));
		lhs.add(new AtomicTerm (new RealNumber (-8), new Variable ("x")));
		lhs.add(new AtomicTerm (new RealNumber (-4)));
		rhs.add(new AtomicTerm (new RealNumber (3), new Variable ("x")));
		rhs.add(new AtomicTerm (new RealNumber (-1), new Variable ("x"), new RealNumber (2)));
		
		AtomicEquation eqn = new AtomicEquation (new AtomicExpression (lhs), new AtomicExpression (rhs));
		System.out.println (eqn);
		
		eqn.solve (new Variable ("x"));
		System.out.println (eqn);
	}
}
