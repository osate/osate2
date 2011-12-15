package EAnalysis.BinPacking;

import java.util.Vector;

public class Isolation extends Constraint {
	public Isolation(Vector v) {
		super(v);
	}

	public Isolation(SoftwareNode[] m) {
		super(m);
	}
}