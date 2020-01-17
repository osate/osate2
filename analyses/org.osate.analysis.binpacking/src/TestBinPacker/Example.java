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
package TestBinPacker;

import java.util.Iterator;
import java.util.TreeSet;

import EAnalysis.BinPacking.AssignmentResult;
import EAnalysis.BinPacking.BFCPBinPacker;
import EAnalysis.BinPacking.BandwidthComparator;
import EAnalysis.BinPacking.CapacityComparator;
import EAnalysis.BinPacking.CompositeSoftNode;
import EAnalysis.BinPacking.EDFScheduler;
import EAnalysis.BinPacking.HardwareNode;
import EAnalysis.BinPacking.NFCExpansor;
import EAnalysis.BinPacking.NFCHoBinPacker;
import EAnalysis.BinPacking.NoExpansionExpansor;
import EAnalysis.BinPacking.OutDegreeAssignmentProblem;
import EAnalysis.BinPacking.OutDegreeComparator;
import EAnalysis.BinPacking.Processor;
import EAnalysis.BinPacking.Site;
import EAnalysis.BinPacking.SiteArchitecture;
import EAnalysis.BinPacking.SiteGuest;
import EAnalysis.BinPacking.SoftwareNode;

/**
 * @author aarong
 */
public class Example {
	public static void main(String[] args) {
		/*
		 * One site to rule them all! We don't care about the site
		 * architecture, so just create one site to hold everything.
		 * We aren't worried about power or space issues either, so
		 * we just set them to 100.0 because those are nice values.
		 * The site accepts all processors.
		 */
		final SiteArchitecture siteArchitecture = new SiteArchitecture();
		final Processor prototype = new Processor("PROTOTYPE", new EDFScheduler(new BandwidthComparator()),
				1000000000L);
		final Site theSite = new Site(100.0, 100.0, new SiteGuest[] { prototype });
		siteArchitecture.addSite(theSite);

		/*
		 * The hardware is fixed, based on the AADL specification, so we
		 * use the NoExpansionExpansor to keep the hardware from being
		 * generated for us.
		 */
		final NFCExpansor expansor = new NoExpansionExpansor();
		expansor.setSiteArchitecture(siteArchitecture);

		/*
		 * Populate the problem space based on the AADL specification. First
		 * we walk the instance model and add all the processors. Then we
		 * walk the instance model again to add all the threads.
		 */
		final OutDegreeAssignmentProblem problem = new OutDegreeAssignmentProblem(new OutDegreeComparator(),
				new BandwidthComparator(), new CapacityComparator());

		// --- Add procs ---

		// One 400MHz processor
		final Processor proc = new Processor("Proc", new EDFScheduler(new BandwidthComparator()), 400000000L);
		siteArchitecture.addSiteGuest(proc, theSite);
		problem.hardwareGraph.add(proc);

		// --- Add threads ---

//		final SoftwareNode t1 = new SoftwareNode(3000, 50000, 50000, problem.bwComparator, "t1");
//		final SoftwareNode t2 = new SoftwareNode(3000, 50000, 50000, problem.bwComparator, "t2");
//		final SoftwareNode t3 = new SoftwareNode(3000, 50000, 50000, problem.bwComparator, "t3");
//		final SoftwareNode t4 = new SoftwareNode(3000, 50000, 50000, problem.bwComparator, "t4");

		final SoftwareNode t1 = new SoftwareNode(3000, 50000, 50000, "t1");
		final SoftwareNode t2 = new SoftwareNode(3000, 50000, 50000, "t2");
		final SoftwareNode t3 = new SoftwareNode(3000, 50000, 50000, "t3");
		final SoftwareNode t4 = new SoftwareNode(3000, 50000, 50000, "t4");

		problem.softwareGraph.add(t1);
		problem.softwareGraph.add(t2);
		problem.softwareGraph.add(t3);
		problem.softwareGraph.add(t4);

//		final SoftwareNode t5 = new SoftwareNode(3000, 50000, 50000, "t5");
//		final SoftwareNode t6 = new SoftwareNode(3000, 50000, 50000, "t6");
//		final SoftwareNode t7 = new SoftwareNode(3000, 50000, 50000, "t7");
//		final SoftwareNode t8 = new SoftwareNode(3000, 50000, 50000, "t8");
//		problem.softwareGraph.add(t5);
//		problem.softwareGraph.add(t6);
//		problem.softwareGraph.add(t7);
//		problem.softwareGraph.add(t8);

		// Try to bin pack
		final BFCPBinPacker packer = new BFCPBinPacker(expansor);
		final NFCHoBinPacker highPacker = new NFCHoBinPacker(packer);
		final boolean res = highPacker.solve(problem);
		showResults(new AssignmentResult(problem, res));
	}

	public static void showResults(AssignmentResult result) {
		System.out.println("Bin packing " + (result.success ? "successful" : "unsuccessful"));

		double totalCapacityGap = 0.0;
		double totalBandwidthRequirement = 0.0;
		int moduleNumber = 0;
		for (Iterator iter = result.problem.hardwareGraph.iterator(); iter.hasNext();) {
			HardwareNode n = (HardwareNode) iter.next();
			System.out.println("Hardware " + n.name);
			System.out.println("Available Capacity = " + n.getAvailableCapacity() + " cycles/sec");
			for (Iterator taskSet = n.getTaskSet().iterator(); taskSet.hasNext();) {
				SoftwareNode m = (SoftwareNode) taskSet.next();
				if (m instanceof CompositeSoftNode) {
					CompositeSoftNode cn = (CompositeSoftNode) m;
					TreeSet set = cn.getBasicComponents();
					moduleNumber += set.size();
				} else {
					moduleNumber += 1;
				}
				totalBandwidthRequirement += m.getBandwidth();
				System.out.println("  Software " + m.name + ": " + m.getCycles() + " cycles, " + m.getPeriod()
						+ " ns period, " + m.getDeadline() + " ns deadline, " + m.getBandwidth() + " cycles/sec load");
			}
			totalCapacityGap += (n.getAvailableCapacity() / n.cyclesPerSecond);
		}
		totalCapacityGap /= result.problem.hardwareGraph.size();
		System.out.println("total load = " + totalBandwidthRequirement);
		System.out.println("total capacity gap = " + totalCapacityGap);
	}
}
