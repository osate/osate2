/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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