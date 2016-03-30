package EAnalysis.BinPacking;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class CompositeMsgNode extends Message {
	protected double totalBandwidth = 0.0;

	public double getBandwidth() {
		return totalBandwidth;
	}

	public TreeSet components;

	public void add(Message m) {
		if (!components.contains(m)) {
			// if (m instanceof CompositeMsgNode)
			// {
			// TreeSet basicMessages = new TreeSet(comparator);
			// getBasicMessages(basicMessages);
			// for (Iterator iter = basicMessages.iterator(); iter.hasNext();)
			// {
			// Message msg = (Message) iter.next();
			// if (!components.contains(msg))
			// {
			// components.add(msg);
			// totalBandwidth += msg.getBandwidth();
			// }
			// }
			// }
			// else
			// {
			components.add(m);
			totalBandwidth += m.getBandwidth();
			// }
		}
	}

	public CompositeMsgNode() {
		super();
		components = new TreeSet(new BandwidthComparator());
	}

	public void getBasicMessages(TreeSet basicMessages) {
		for (Iterator iter = components.iterator(); iter.hasNext();) {
			Message msg = (Message) iter.next();
			if (msg instanceof CompositeMsgNode) {
				CompositeMsgNode composite = (CompositeMsgNode) msg;
				composite.getBasicMessages(basicMessages);
			} else
				basicMessages.add(msg);
		}
	}

	public CompositeMsgNode(Comparator comparator) {
		super();
		components = new TreeSet(comparator);
	}
}