package EAnalysis.BinPacking;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Link extends HardwareNode {
	TreeSet connectedNodes;

	public void add(HardwareNode node) {
		if (!connectedNodes.contains(node))
			connectedNodes.add(node);
	}

	public void remove(HardwareNode node) {
		connectedNodes.remove(node);
	}

	public void addAllNodes(Collection c) {
		for (Iterator iter = c.iterator(); iter.hasNext();)
			add((HardwareNode) iter.next());
	}

	/**
	 * return the set of nodes connected to this link order in non-decreasing of
	 * available capacity
	 */
	public TreeSet getConnectedNodes() {
		return connectedNodes;
	}

	/**
	 * The messages deployed over this link will be scheduled with
	 * 
	 * @param s
	 */
	public Link(Comparator c, Scheduler s, double cyclesPerSec) {
		super(s, cyclesPerSec);
		connectedNodes = new TreeSet(c);
	}
}