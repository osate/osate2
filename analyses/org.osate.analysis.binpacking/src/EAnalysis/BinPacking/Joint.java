package EAnalysis.BinPacking;

import java.util.Vector;

public class Joint extends Constraint {
	public Joint(Vector v) {
		super(v);
	}

	public Joint(SoftwareNode[] m) {
		super(m);
	}

	public Joint() {
	}

	CompositeSoftNode compNode;

	public void setCompositeNode(CompositeSoftNode n) {
		compNode = n;
	}

	public CompositeSoftNode getCompositeNode() {
		return compNode;
	}
}