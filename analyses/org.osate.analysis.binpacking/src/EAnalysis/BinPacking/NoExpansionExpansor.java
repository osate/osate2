package EAnalysis.BinPacking;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Dionisio de Niz Expansor that does not allows expansion
 */

public class NoExpansionExpansor extends NFCExpansor {
	public NoExpansionExpansor() {
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
	 * Cannot add new links
	 */
	public Link addLinkBetween(HardwareNode node1, HardwareNode node2, Message msg,
			OutDegreeAssignmentProblem problem) {
		return null;
	}

	public HardwareNode cloneProcessorInto(HardwareNode n, Location site, TreeSet validProcessors,
			OutDegreeAssignmentProblem problem) {
		return null;
	}
}