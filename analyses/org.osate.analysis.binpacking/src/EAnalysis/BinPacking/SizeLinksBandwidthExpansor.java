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