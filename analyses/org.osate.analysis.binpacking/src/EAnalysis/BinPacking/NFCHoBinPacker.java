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

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

/**
 * @author Dionisio de Niz
 * 
 * This class implements the Not-Fully-Connected Homogeneous Bin Packing
 * algorithm
 */
public class NFCHoBinPacker {
	/*
	 * ToDo: - Add isolation constraint - Ensure type constraints are properly
	 * processed. Perhaps transformed into instance constraints at the time of
	 * adding to composite?
	 */

	LowLevelBinPacker packer;

	public NFCHoBinPacker(LowLevelBinPacker p) {
		packer = p;
	}

	/**
	 * This method takes an Assignment problem and builds a constrained
	 * architecture from its software graph. This architecture then is added as
	 * composites in the same software graphs of the assigment problem
	 */
	public void buildConstrainedArchitecture(OutDegreeAssignmentProblem problem) {
		boolean checkingConflicting = false;
		boolean addedComposite = false;
		TreeSet outDegreeList = (TreeSet) problem.orderedModulesByOutDegree.clone();
		TreeSet conflicting = new TreeSet(outDegreeList.comparator());

		// System.out.println("building the constrained architecture....");
		Iterator outDegreeIterator = outDegreeList.iterator();
		if (outDegreeList.size() > 0) {
			SoftwareNode nextModule = (SoftwareNode) outDegreeIterator.next();
			outDegreeIterator.remove();
			problem.removeSoftwareNode(nextModule);
			CompositeSoftNode composite = new CompositeSoftNode(new BandwidthComparator());
			addedComposite = false;
			composite.add(nextModule, problem.softwareConnectivity, problem.softConnectivityByTarget,
					problem.constraints);
			// System.out.println("\t checking module("+nextModule.name+")
			// composite("+composite.hashCode()+")");
			ArrayList virtualNeighbors = new ArrayList(1);
			virtualNeighbors.add(null);
			TreeMap map = (TreeMap) problem.softwareConnectivity.get(composite);
			Iterator neighbors = null;
			if (map != null && map.size() != 0) {
				neighbors = map.values().iterator();
				// System.out.println("\t\t
				// neighbors.size("+map.values().size()+")");
			} else {
				// System.out.println();
				if (outDegreeIterator.hasNext()) {
					virtualNeighbors.set(0, outDegreeIterator.next());
					neighbors = virtualNeighbors.iterator();
					// System.out.println("\t\t
					// virtualneighbors.size("+virtualNeighbors.size()+")");
				}
			}
			while (neighbors != null && neighbors.hasNext()) {
				/*
				 * Search for a neighbor that does not conflict with previous
				 * ones in the composite.
				 * 
				 * The search is done in descending order of bandwidth
				 * requirement with composite
				 */
				SoftwareNode neighbor = null;
				while (neighbor == null && neighbors != null && neighbors.hasNext()) {
					neighbor = (SoftwareNode) neighbors.next();

					if (checkingConflicting)
						System.out.println("Checking node(" + neighbor.getSemanticObject() + ")");
					if (neighbor instanceof CompositeSoftNode) {
						for (Iterator iter = ((CompositeSoftNode) neighbor).getBasicComponents().iterator(); iter
								.hasNext();) {
							SoftwareNode node = (SoftwareNode) iter.next();
							System.out.println("\t\t node(" + node.getSemanticObject() + ")");
						}
					}

					// System.out.println("\t\t checking
					// neighbor("+neighbor.name+")");
					if (!outDegreeList.contains(neighbor)) {
						neighbor = null;
						// System.out.println("\t\t\t NOT IN outDegreeList --
						// next neighbor");
						continue;
					}
					Vector v = (Vector) problem.constraints.get(neighbor);
					/* check possible constraints */
					if (v != null) {
						int vSize = v.size();
						for (int i = 0; (i < vSize) && (neighbor != null); i++) {
							Constraint c = (Constraint) v.get(i);
							if (c instanceof SetConstraint) {
								// Limit the aggregates to have the same type
								// constraints
								if (!c.members.contains(composite)) {
									// Conflicting
									conflicting.add(neighbor);
									outDegreeList.remove(neighbor);
									neighbor = null;
								}
							} else if (c instanceof Disjoint) {
								/*
								 * belongs to disjoint set -- cannot be deployed
								 * together
								 */
								if (c.members.contains(composite)) {
									System.out.println("\n\n  ******* CONFLICTING *******");
									System.out.println("\t Conflicting(" + neighbor.getSemanticObject() + ")");
									if (neighbor instanceof CompositeSoftNode) {
										for (Iterator iter = ((CompositeSoftNode) neighbor).getBasicComponents()
												.iterator(); iter.hasNext();) {
											SoftwareNode node = (SoftwareNode) iter.next();
											System.out.println("\t\t node(" + node.getSemanticObject() + ")");
										}
									}
									System.out.println("********************************\n\n");
									conflicting.add(neighbor);
									outDegreeList.remove(neighbor);
									neighbor = null;
								}
							} else if (c instanceof Isolation) {
								/* does not belong to the isolated set */
								if (!c.members.contains(composite)) {
									conflicting.add(neighbor);
									outDegreeList.remove(neighbor);
									neighbor = null;
								}
							}
						}
					}
				}
				if (neighbor != null) {
					outDegreeList.remove(neighbor);
					problem.removeSoftwareNode(neighbor);
					composite.add(neighbor, problem.softwareConnectivity, problem.softConnectivityByTarget,
							problem.constraints);
					// System.out.println("\t\t\t adding
					// neighbor("+neighbor.name+")");

					outDegreeIterator = outDegreeList.iterator();
					map = (TreeMap) problem.softwareConnectivity.get(composite);
					neighbors = null;
					if (map != null && map.size() != 0)
						neighbors = map.values().iterator();
					else {
						if (outDegreeIterator.hasNext()) {
							virtualNeighbors.set(0, outDegreeIterator.next());
							neighbors = virtualNeighbors.iterator();
						}
					}
				} else {
					outDegreeIterator = outDegreeList.iterator();
					if (outDegreeIterator.hasNext()) {
						nextModule = (SoftwareNode) outDegreeIterator.next();
						virtualNeighbors.set(0, nextModule);
						neighbors = virtualNeighbors.iterator();
					}
				}

				if (neighbors == null || !neighbors.hasNext()) {
					problem.addSoftwareNode(composite);
					addedComposite = true;
					// System.out.println("\t\t ADDED
					// composite("+composite.hashCode()+")");
					if (conflicting.size() > 0) {
						System.out.println("\n ----- Switching to explore conflicting nodes !! ----\n");
						checkingConflicting = true;
						TreeSet temp = outDegreeList;
						outDegreeList = conflicting;
						conflicting = temp;
						outDegreeIterator = outDegreeList.iterator();
						nextModule = (SoftwareNode) outDegreeIterator.next();
						System.out.println("\t nextModule(" + nextModule.getSemanticObject() + ")");
						if (nextModule instanceof CompositeSoftNode) {
							for (Iterator iter = ((CompositeSoftNode) nextModule).getBasicComponents().iterator(); iter
									.hasNext();) {
								SoftwareNode node = (SoftwareNode) iter.next();
								System.out.println("\t\t node(" + node.getSemanticObject() + ")");
							}
						}
						outDegreeIterator.remove();
						problem.removeSoftwareNode(nextModule);
						composite = new CompositeSoftNode(new BandwidthComparator());
						addedComposite = false;
						composite.add(nextModule, problem.softwareConnectivity, problem.softConnectivityByTarget,
								problem.constraints);
						map = (TreeMap) problem.softwareConnectivity.get(composite);
						neighbors = null;
						if (map != null && map.size() != 0)
							neighbors = map.values().iterator();
						else {
							if (outDegreeIterator.hasNext()) {
								virtualNeighbors.set(0, outDegreeIterator.next());
								neighbors = virtualNeighbors.iterator();
							}
						}
					} else
						neighbors = null;
				}
			}
			if (!addedComposite)
				problem.addSoftwareNode(composite);
		}
	}

	public boolean solve(OutDegreeAssignmentProblem problem) {
		// System.out.println("--------- INITIAL SOFTWARE GRAPH ----------");
		// for (Iterator iter = problem.softwareGraph.iterator();
		// iter.hasNext();)
		// {
		// SoftwareNode n = (SoftwareNode) iter.next();
		// System.out.println("\t node("+n.name+")");
		// }
		// System.out.println("----- END OF INITIAL SOFTWARE GRAPH -------");

		BinPackerTester.toDeploy = problem.softwareGraph.size();

		buildConstrainedArchitecture(problem);
		// System.out.println("---- CONSTRAINED ARCHITECTURE -------");
		// for (Iterator iter = problem.softwareGraph.iterator();
		// iter.hasNext();)
		// {
		// SoftwareNode n = (SoftwareNode) iter.next();
		// System.out.println("\t node("+n.name+")");
		// }
		// System.out.println("---- END OF CONSTRAINED ARCHITECTURE ----");

		// DebugMonitor.println(DebugMonitor.channels[3], " -- CONSTRAINED
		// COMPONENTS --");
		// for (Iterator iter = problem.softwareGraph.iterator();
		// iter.hasNext();)
		// {
		// SoftwareNode n = (SoftwareNode) iter.next();
		// DebugMonitor.println(DebugMonitor.channels[3], "\t
		// module.size("+BinPackerTester.decFormat.format(n.getBandwidth())+")");
		// }
		// DebugMonitor.println(DebugMonitor.channels[3], "--- END OF
		// CONSTRAINED COMPONENTS ---");

		Iterator orderedComposites = problem.softwareGraph.iterator();
//		System.out.println("OrderedComposites.size("
//				+ problem.softwareGraph.size() + ")");
		SoftwareNode composite = null;
		while (orderedComposites.hasNext() || composite != null) {
			if (composite == null) {
				composite = (SoftwareNode) orderedComposites.next();
			}

			if (composite.deployed()) {
				composite = null;
				continue;
			}

			TreeSet currentValidProcessors = problem.getValidProcessorsForModule(composite);

			/*
			 * The lowLevelBinPacking verifies hardware conflicts. If needed it
			 * will also add additional hardware on the site architecture.
			 */

			TreeSet aggregates = null;
			if (composite instanceof CompositeSoftNode)
				aggregates = ((CompositeSoftNode) composite).getComponents();
			else {
				aggregates = new TreeSet(new BandwidthComparator());
				aggregates.add(composite);
			}
			if (packer.solve(aggregates, currentValidProcessors, problem)) {
				// System.out.println("succesful lowlevel packer");
				// problem.softwareGraph.remove(composite);

				problem.removeSoftwareNode(composite);
				if (composite instanceof CompositeSoftNode) {
					Iterator inIter = ((CompositeSoftNode) composite).getBasicComponents().iterator();
					if (inIter.hasNext())
						composite.setDeployedTo(((SoftwareNode) inIter.next()).getDeployedTo());
				}
				orderedComposites = problem.softwareGraph.iterator();

				if (orderedComposites.hasNext()) {
					/* explore neighbors */
					TreeMap connectivityVector = (TreeMap) problem.softwareConnectivity.get(composite);
					if (connectivityVector != null) {
						Iterator neighborLinks = connectivityVector.entrySet().iterator();
						boolean undeployedNeighbor = false;
						while (!undeployedNeighbor && neighborLinks.hasNext()) {
							Map.Entry entry = (Map.Entry) neighborLinks.next();
							composite = (SoftwareNode) entry.getValue();
							undeployedNeighbor = !composite.deployed(); // (composite.getDeployedTo()
																		// ==
																		// null);
						}
						if (!undeployedNeighbor)
							composite = null;

					} else {
						composite = (SoftwareNode) orderedComposites.next();
					}
				} else
					composite = null;
			} else {
				// System.out.println("lowlevelpacker failed");
				return false;
			}
		}
		return true;
	}

	/**
	 * This is a method to test the building of the constrained architecture
	 */
	public static void testConstrainedArchitecture() {
	}

	public static void unitTest() {
	}

	public static void hardwareGrowingTest(LowLevelBinPacker lowLevelBinPacker, SiteArchitecture siteArchitecture) {
		/* build the software graph */
		BandwidthComparator comparator = new BandwidthComparator();
		CapacityComparator capComparator = new CapacityComparator();
		OutDegreeComparator outDegreeComparator = new OutDegreeComparator();

		OutDegreeAssignmentProblem prob = new OutDegreeAssignmentProblem(outDegreeComparator, comparator,
				capComparator);

		TreeSet softGraph = new TreeSet(comparator);
		SoftwareNode nA = new SoftwareNode(10, 50000, 50000, comparator, "A");
		SoftwareNode nB = new SoftwareNode(10, 50000, 50000, comparator, "B");
		SoftwareNode nC = new SoftwareNode(40, 100000, 100000, comparator, "C");
		SoftwareNode nD = new SoftwareNode(5, 50000, 50000, comparator, "D");
		SoftwareNode nE = new SoftwareNode(5, 50000, 50000, comparator, "E");
		SoftwareNode nJ = new SoftwareNode(5, 50000, 50000, comparator, "J");

		prob.addSoftwareNode(nA);
		prob.addSoftwareNode(nB);
		prob.addSoftwareNode(nC);
		prob.addSoftwareNode(nD);
		prob.addSoftwareNode(nE);
		prob.addSoftwareNode(nJ);

		Message m1 = new Message(64, 50000, 50000, nA, nC);
		prob.addMessage(m1);
		Message m2 = new Message(24, 50000, 50000, nB, nC);
		prob.addMessage(m2);
		Message m3 = new Message(10, 100000, 100000, nC, nD);
		prob.addMessage(m3);
		Message m4 = new Message(20, 100000, 100000, nC, nE);
		prob.addMessage(m4);
		Message m7 = new Message(20, 100000, 100000, nE, nJ);
		prob.addMessage(m7);

		SoftwareNode nF = new SoftwareNode(25, 100000, 100000, comparator, "F");
		prob.addSoftwareNode(nF);

		SoftwareNode nG = new SoftwareNode(25, 100000, 100000, comparator, "G");
		SoftwareNode nH = new SoftwareNode(60, 200000, 200000, comparator, "H");
		SoftwareNode nI = new SoftwareNode(25, 100000, 100000, comparator, "I");
		prob.addSoftwareNode(nG);
		prob.addSoftwareNode(nH);
		prob.addSoftwareNode(nI);

		Message m5 = new Message(30, 100000, 100000, nG, nH);
		prob.addMessage(m5);
		Message m6 = new Message(30, 100000, 100000, nH, nI);
		prob.addMessage(m6);

		/*
		 * speed set to process one cycle every microsecond,i.e., can process
		 * 1000000 cycles per second. Slow machine but just an example
		 */
		// HardwareNode h1 = new HardwareNode("1",new EDFScheduler(comparator),
		// 1000001.0);
		MPC555 h1 = new MPC555("1", new EDFScheduler(comparator), 1000000.0, new NetInterface[] {
				new NetInterface(new Ethernet()), new NetInterface(new CANBus()), new NetInterface(new CANBus()) });
		prob.hardwareGraph.add(h1);
		// HardwareNode h2 = new HardwareNode("2", new EDFScheduler(comparator),
		// 1000002.0);
		MPC555 h2 = new MPC555("2", new EDFScheduler(comparator), 1000000.0,
				new NetInterface[] { new NetInterface(new Ethernet()), new NetInterface(new CANBus()) });
		prob.hardwareGraph.add(h2);
		// HardwareNode h3 = new HardwareNode("3", new EDFScheduler(comparator),
		// 1000000.0);
		MPC555 h3 = new MPC555("3", new EDFScheduler(comparator), 1000000.0, new NetInterface[] {
				new NetInterface(new Ethernet()), new NetInterface(new CANBus()), new NetInterface(new CANBus()) });
		prob.hardwareGraph.add(h3);

		/*
		 * links
		 */

		Ethernet ethernet = new Ethernet();
		ethernet.name = "Ethernet";
		ethernet.add(h1);
		ethernet.add(h2);
		h1.attachToLink(ethernet);
		h2.attachToLink(ethernet);

		CANBus canBus = new CANBus();
		canBus.name = "CanBus";
		canBus.add(h2);
		canBus.add(h3);
		h2.attachToLink(canBus);
		h3.attachToLink(canBus);
		prob.addLink(ethernet);
		prob.addLink(canBus);

		prob.addConstraint(new Joint(new SoftwareNode[] { nG, nF }));
		prob.addConstraint(new Disjoint(new SoftwareNode[] { nE, nJ }));

		PrintWriter stdout = new PrintWriter(System.out);
		int next = prob.dumpHardwareText(stdout, 0, 0, true);
		prob.dumpSoftGraphText(prob.softwareGraph, stdout, next, 0, false);
		stdout.flush();

		Site site = (Site) siteArchitecture.sitesBySize.iterator().next();

		site.addGuest(h1);
		site.addGuest(h2);
		site.addGuest(h3);
		site.addGuest(ethernet);
		site.addGuest(canBus);

		NFCHoBinPacker test = new NFCHoBinPacker(lowLevelBinPacker);
		if (test.solve(prob)) {
			// System.out.println("Bin Packing Succesful");
		} else {
			// System.out.println("Bin Packing failed!");
		}

		System.out.println("\n\n -------- HARDWARE ---------");
		prob.dumpHardwareText(stdout, 0, 0, false);
		stdout.flush();
		System.out.println("----- END OF HARDWARE ---------\n");
		/* Display assignments */
		System.out.println("\n\n -----  ASSIGNMENTS ------");
		int i = 0;
		for (Iterator iter = prob.hardwareGraph.iterator(); iter.hasNext();) {
			HardwareNode n = (HardwareNode) iter.next();
			System.out.println("Node " + n.name + ":");
			for (Iterator taskSet = n.getTaskSet().iterator(); taskSet.hasNext();) {
				SoftwareNode m = (SoftwareNode) taskSet.next();
				System.out.println("\t Module " + m.name + " " + "C(" + m.cycles + " cycles)," + "T(" + m.period
						+ " nanos)," + "D(" + m.deadline + " nanos)" + "BW Load(" + ((ProcessingLoad) m).getBandwidth()
						+ ") cycles/sec");
			}
			System.out.println("\t\t Available Capacity = " + n.getAvailableCapacity() + " cycles / sec");
		}
		System.out.println("---- END OF ASSIGNMENTS ---");
	}

	public static void hardwareSizingTest(LowLevelBinPacker lowLevelBinPacker) {
		/* build the software graph */
		BandwidthComparator comparator = new BandwidthComparator();
		CapacityComparator capComparator = new CapacityComparator();
		OutDegreeComparator outDegreeComparator = new OutDegreeComparator();

		OutDegreeAssignmentProblem prob = new OutDegreeAssignmentProblem(outDegreeComparator, comparator,
				capComparator);

		TreeSet softGraph = new TreeSet(comparator);
		SoftwareNode nA = new SoftwareNode(10, 50000, 50000, comparator, "A");
		SoftwareNode nB = new SoftwareNode(10, 50000, 50000, comparator, "B");
		SoftwareNode nC = new SoftwareNode(40, 100000, 100000, comparator, "C");
		SoftwareNode nD = new SoftwareNode(5, 50000, 50000, comparator, "D");
		SoftwareNode nE = new SoftwareNode(5, 50000, 50000, comparator, "E");
		SoftwareNode nJ = new SoftwareNode(5, 50000, 50000, comparator, "J");

		prob.addSoftwareNode(nA);
		prob.addSoftwareNode(nB);
		prob.addSoftwareNode(nC);
		prob.addSoftwareNode(nD);
		prob.addSoftwareNode(nE);
		prob.addSoftwareNode(nJ);

		Message m1 = new Message(64, 50000, 50000, nA, nC);
		prob.addMessage(m1);
		Message m2 = new Message(24, 50000, 50000, nB, nC);
		prob.addMessage(m2);
		Message m3 = new Message(10, 100000, 100000, nC, nD);
		prob.addMessage(m3);
		Message m4 = new Message(20, 100000, 100000, nC, nE);
		prob.addMessage(m4);
		Message m7 = new Message(20, 100000, 100000, nE, nJ);
		prob.addMessage(m7);

		SoftwareNode nF = new SoftwareNode(25, 100000, 100000, comparator, "F");
		prob.addSoftwareNode(nF);

		SoftwareNode nG = new SoftwareNode(25, 100000, 100000, comparator, "G");
		SoftwareNode nH = new SoftwareNode(60, 200000, 200000, comparator, "H");
		SoftwareNode nI = new SoftwareNode(25, 100000, 100000, comparator, "I");
		prob.addSoftwareNode(nG);
		prob.addSoftwareNode(nH);
		prob.addSoftwareNode(nI);

		Message m5 = new Message(30, 100000, 100000, nG, nH);
		prob.addMessage(m5);
		Message m6 = new Message(30, 100000, 100000, nH, nI);
		prob.addMessage(m6);

		/*
		 * speed set to process one cycle every microsecond,i.e., can process
		 * 1000000 cycles per second. Slow machine but just an example
		 */

		prob.addConstraint(new Joint(new SoftwareNode[] { nG, nF }));
		prob.addConstraint(new Disjoint(new SoftwareNode[] { nE, nJ }));

		PrintWriter stdout = new PrintWriter(System.out);
		int next = prob.dumpHardwareText(stdout, 0, 0, true);
		prob.dumpSoftGraphText(prob.softwareGraph, stdout, next, 0, false);
		stdout.flush();

		NFCHoBinPacker test = new NFCHoBinPacker(lowLevelBinPacker);
		if (test.solve(prob)) {
			System.out.println("Bin Packing Succesful");
		} else {
			System.out.println("Bin Packing failed!");
		}

		/* Display assignments */
		System.out.println("\n\n -------- HARDWARE ---------");
		prob.dumpHardwareText(stdout, 0, 0, false);
		stdout.flush();
		System.out.println("----- END OF HARDWARE ---------\n");
		System.out.println("\n\n -----  ASSIGNMENTS  ------");
		int i = 0;
		for (Iterator iter = prob.hardwareGraph.iterator(); iter.hasNext();) {
			HardwareNode n = (HardwareNode) iter.next();
			System.out.println("Node " + n.name + ":");
			for (Iterator taskSet = n.getTaskSet().iterator(); taskSet.hasNext();) {
				SoftwareNode m = (SoftwareNode) taskSet.next();
				System.out.println("\t Module " + m.name + " " + "C(" + m.cycles + " cycles)," + "T(" + m.period
						+ " nanos)," + "D(" + m.deadline + " nanos)" + "BW Load(" + ((ProcessingLoad) m).getBandwidth()
						+ ") cycles/sec");
			}
			System.out.println("\t\t Available Capacity = " + n.getAvailableCapacity() + " cycles / sec");
		}
		System.out.println("------- END OF ASSIGNMENTS -----------");
	}

	public static void main(String args[]) {
		/* Single site architecture for simplicity */
		SiteArchitecture siteArchitecture = new SiteArchitecture();

		Site site = new Site(500.0, 50.0,
				new SiteGuest[] {
						new MPC555("",
								new EDFScheduler(new BandwidthComparator()), 1000000.0, new NetInterface[] {
										new NetInterface(new Ethernet()), new NetInterface(new CANBus()) }),
						new Ethernet(), new CANBus() });

		siteArchitecture.addSite(site);
		// hardwareGrowingTest(new DFCPBinPacker(new
		// NFCExpansor(siteArchitecture)), siteArchitecture);
		// hardwareSizingTest(new DFCPBinPacker(new
		// NFCExpansor(siteArchitecture)));

		// hardwareGrowingTest(new DFBPBinPacker(new
		// NFCExpansor(siteArchitecture)), siteArchitecture);
		// hardwareSizingTest(new DFBPBinPacker(new
		// NFCExpansor(siteArchitecture)));

		// hardwareGrowingTest(new BFCPBinPacker(new
		// NFCExpansor(siteArchitecture)), siteArchitecture);
		hardwareSizingTest(new BFCPBinPacker(new NFCExpansor(siteArchitecture)));

		/* this are not valid combinations */
		// hardwareGrowingTest(new BFBPBinPacker(new
		// NFCExpansor(siteArchitecture)), siteArchitecture);
		// hardwareSizingTest(new BFBPBinPacker(new
		// NFCExpansor(siteArchitecture)));
	}
}