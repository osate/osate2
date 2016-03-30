/* Created on Oct 19, 2004
 */
package TestBinPacker;

import java.util.Iterator;
import java.util.TreeSet;

import org.osate.analysis.binpacking.rma.RMASchedulerNew;

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
import EAnalysis.BinPacking.Scheduler;
import EAnalysis.BinPacking.Site;
import EAnalysis.BinPacking.SiteArchitecture;
import EAnalysis.BinPacking.SiteGuest;
import EAnalysis.BinPacking.SoftwareNode;

/**
 * @author aarong
 */
public class BadExample {
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

		/* Create our problem space */
		final OutDegreeAssignmentProblem problem = new OutDegreeAssignmentProblem(new OutDegreeComparator(),
				new BandwidthComparator(), new CapacityComparator());

		// --- Add procs ---

		// Processor with 35 cycles/second
//		final Scheduler s = new EDFScheduler(new BandwidthComparator());
		final Scheduler s = new RMASchedulerNew();
		final Processor proc = new Processor("Proc", s, 100000000L);
		siteArchitecture.addSiteGuest(proc, theSite);
		problem.hardwareGraph.add(proc);

		// --- Add threads ---

		final SoftwareNode t1 = new SoftwareNode(2, 50L, 50L, "t1");
		final SoftwareNode t2 = new SoftwareNode(4, 70L, 70L, "t2");

		problem.softwareGraph.add(t1);
		problem.softwareGraph.add(t2);

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
