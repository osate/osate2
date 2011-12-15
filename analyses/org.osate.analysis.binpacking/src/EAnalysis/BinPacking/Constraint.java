package EAnalysis.BinPacking;

import java.util.Vector;

public class Constraint implements Cloneable {
	public Vector members;

	public void add(SoftwareNode o) {
		if (!members.contains(o))
			members.add(o);
	}

	public Constraint() {
	}

	public Constraint(SoftwareNode[] m) {
		members = new Vector();
		for (int i = 0; i < m.length; i++)
			members.add(m[i]);
	}

	public Constraint(Vector v) {
		members = v;
	}

	public Object clone() {
		Constraint c = new Constraint();
		c.members = (Vector) members.clone();
		return c;
	}
}