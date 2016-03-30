package EAnalysis.BinPacking;

import java.util.TreeSet;

/**
 * @author Dionisio de Niz Interface to expand hardware. It allow variation
 *         between cannonical architectures.
 */
public interface Expansor {
	public void setSiteArchitecture(SiteArchitecture s);

	/**
	 * The initial Hardware (processors) must be created to host the software
	 * components of size
	 * 
	 * @param softwareLoad
	 *            cycle requirement to run the software graph
	 * @param problem
	 *            assignment problem to where the hardware is to be added.
	 */
	public void createInitialHardware(OutDegreeAssignmentProblem problem, TreeSet validProcessors, double softwareLoad);

	/**
	 * Largest processor possible suitable for the module. This imply that the
	 * processor enables the communication with the module's neighbors.
	 * 
	 * @param module
	 *            Module to be fitted
	 * @param problem
	 *            from where to find the processor
	 */
	public double getLargestProcessorSizeForModule(SoftwareNode module, TreeSet validProcessors,
			OutDegreeAssignmentProblem problem);

	/**
	 * Try to expand the processor to fit the given module
	 * 
	 * @param module
	 *            Module to be fitted
	 * @param problem
	 *            where to put the new processor
	 * @param largestProcessor
	 *            is an array of a single element to return the largest
	 *            processor that the algorithm was able to find
	 * @param largestSite
	 *            the site for this processor
	 */
	public boolean expandProcessorForModule(SoftwareNode module, TreeSet validProcessors,
			OutDegreeAssignmentProblem problem, HardwareNode[] largestProcessor, Site[] largestSite);

	/**
	 * Add new link between node1 and node2
	 * 
	 * @param node1
	 *            Hardware node to which the link should be added
	 * @param node2
	 *            Hardware node to which the link should be added
	 */
	public Link addLinkBetween(HardwareNode node1, HardwareNode node2, Message msg, OutDegreeAssignmentProblem problem);

	// public Processor cloneProcessorInto(Processor n, Location site, TreeSet
	// validProcessor, OutDegreeAssignmentProblem problem);
	public HardwareNode cloneProcessorInto(HardwareNode n, Location site, TreeSet validProcessor,
			OutDegreeAssignmentProblem problem);
}