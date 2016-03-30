package EAnalysis.BinPacking;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Dionisio de Niz Expansor creates links as needed to evaluate the
 *         needs for link bandwidth
 */

public class SizeLinksBandwidthExpansor extends NFCExpansor {
	public long addedBandwidth = 0;

	public SizeLinksBandwidthExpansor() {
	}

	/**
	 * Don't create initial hardware
	 */
	public void createInitialHardware(OutDegreeAssignmentProblem problem, TreeSet validProcessors,
			double softwareLoad) {
	}

	/**
	 * cannot expand
	 */
	public boolean expandProcessorForModule(SoftwareNode module, TreeSet validProcessors,
			OutDegreeAssignmentProblem problem, HardwareNode[] largestProcessor, Site[] largestSite) {
		for (Iterator iter = validProcessors.iterator(); iter.hasNext();) {
			HardwareNode node = (HardwareNode) iter.next();
			if (largestProcessor[0] == null)
				largestProcessor[0] = node;
			else if (largestProcessor[0].getAvailableCapacity() < node.getAvailableCapacity())
				largestProcessor[0] = node;
		}

		// assumes the site architecture has a unique site
		largestSite[0] = (Site) siteArchitecture.sitesBySize.iterator().next();
		return false;
	}

	/**
	 * Create Infinitely large link with all processors connected to it
	 */
	public Link addLinkBetween(HardwareNode node1, HardwareNode node2, Message msg,
			OutDegreeAssignmentProblem problem) {
		Link link = new Link(problem.capComparator, new EDFScheduler(problem.bwComparator), 1000000000);

		for (Iterator iter = problem.hardwareGraph.iterator(); iter.hasNext();) {
			HardwareNode node = (HardwareNode) iter.next();
			link.add(node);
		}

		problem.addLink(link);
		addedBandwidth += 1000000000;
		return link;
	}

	public HardwareNode cloneProcessorInto(HardwareNode n, Location site, TreeSet validProcessors,
			OutDegreeAssignmentProblem problem) {
		return null;
	}
}