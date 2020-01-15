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

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public abstract class BaseLowLevelBinPacker implements LowLevelBinPacker {
	public int numberOfPartitions = 0;

	public static final int BY_SIZE = 0;

	public static final int BY_BANDWIDTH = 1;

	/**
	 * Assumes that there are no conflicts among nodes in the software graph
	 */
	public TreeSet getDisconnectedComponents(Comparator orderer, TreeSet softwareGraph,
			OutDegreeAssignmentProblem problem) {
		TreeSet disconnectedComponents = new TreeSet(orderer);
		Iterator modules = softwareGraph.iterator();

		while (modules.hasNext()) {
			SoftwareNode nextModule = (SoftwareNode) modules.next();
			modules.remove();
			// System.out.println("\t starting from
			// module("+nextModule.name+")");
			CompositeSoftNode composite = new CompositeSoftNode(orderer);
			composite.add(nextModule, problem.softwareConnectivity, problem.softConnectivityByTarget,
					problem.constraints);
			Iterator neighbors = ((TreeMap) problem.softwareConnectivity.get(composite)).entrySet().iterator();
			while (neighbors.hasNext()) {
				SoftwareNode neighbor = (SoftwareNode) ((Map.Entry) neighbors.next()).getValue();
				// System.out.print("\t\t -- neighbor("+neighbor.name+")");
				/* skip neighbors not in the current aggregate */
				if (!softwareGraph.contains(neighbor)) {
					// System.out.println("... SKIPPED!");
					continue;
				}
				softwareGraph.remove(neighbor);
				composite.add(neighbor, problem.softwareConnectivity, problem.softConnectivityByTarget,
						problem.constraints);
				// System.out.println("... ADDED!");
				neighbors = ((TreeMap) problem.softwareConnectivity.get(composite)).entrySet().iterator();
				problem.removeSoftwareNode(neighbor);
			}

			// DebugMonitor.println(DebugMonitor.channels[3], "---
			// Composite.size("+composite.getBandwidth()+") ELEMENTS ---");
			// double totalLoad =0.0;
			// for (Iterator iter = composite.getBasicComponents().iterator();
			// iter.hasNext();)
			// {
			// SoftwareNode n = (SoftwareNode) iter.next();
			// DebugMonitor.println(DebugMonitor.channels[3], "\t
			// element.size("+n.getBandwidth()+")");
			// totalLoad += n.getBandwidth();
			// }
			// DebugMonitor.println(DebugMonitor.channels[3], "--- END OF
			// ELEMENTS TOTAL LOAD("+totalLoad+")---");
			problem.addSoftwareNode(composite);
			disconnectedComponents.add(composite);

			/*
			 * Reinstantiate the modules iterator given that we may have deleted
			 * elements in the middle
			 */
			modules = softwareGraph.iterator();
		}
		return disconnectedComponents;
	}

	double nominalBinSize = 0.0;

	public void setNominalBinSize(double s) {
		nominalBinSize = s;
	}

	boolean breakExcessBinObjectsOnly = false;

	public void setBreakExcessBinObjectsOnly(boolean b) {
		breakExcessBinObjectsOnly = b;
	}

	public boolean isExcessBinObject(CompositeSoftNode composite) {
		return composite.getBandwidth() < (nominalBinSize / 3.0);
	}

	public double partition(CompositeSoftNode composite, double partitionSize, TreeSet moduleList,
			OutDegreeAssignmentProblem problem, int partitionMode, int justnotcall) {
		/* force the bandwidth partitioning */
		partitionMode = BY_BANDWIDTH;

		System.out.println(this + ": partition(composite(" + composite.getBandwidth() + "), partitionSize("
				+ partitionSize + "))");
		/* is this composite breakable? */
		if (!composite.breakable) {
			// System.out.println(" partition:not breakable");
			return -1;
		}

		// Check if we want to check the excess bin objects.
		if (breakExcessBinObjectsOnly && (!isExcessBinObject(composite)))
			return -1;

		CompositeSoftNode part = null; // = new CompositeSoftNode(new
										// BandwidthComparator());
		CompositeSoftNode part1 = new CompositeSoftNode(new BandwidthComparator());
		TreeSet componentMembers;
		TreeSet componentMembers2;
		if (partitionMode == BY_BANDWIDTH) {
			componentMembers = composite.getComponentsByOutDegree(); // composite.getComponents();
			componentMembers2 = composite.getComponents();
		} else // BY_SIZE
		{
			componentMembers = composite.getComponents();
			componentMembers2 = composite.getComponents();
		}

		Iterator components = componentMembers.iterator(); // composite.getComponents().iterator();
		while (components.hasNext()) {
			SoftwareNode module = (SoftwareNode) components.next();
			if (!(module instanceof CompositeSoftNode)) {
				part = new CompositeSoftNode(new BandwidthComparator());
			} else
				part = (CompositeSoftNode) module;

			// System.out.println("partition: checking
			// module("+module.name+").BW("+module.getBandwidth()+")
			// partitionSize("+partitionSize+")");
			// if (part.getBandwidth() + module.getBandwidth() <= partitionSize)
			if (part.getBandwidth() <= partitionSize) {
				components.remove();
				if (partitionMode == BY_BANDWIDTH)
					componentMembers2.remove(module);
				if (!part.equals(module))
					part.add(module, problem.softwareConnectivity, problem.softConnectivityByTarget,
							problem.constraints);
				// System.out.println("\t\t\t add(Module("+module.name+"))");

				Iterator neighbors = ((TreeMap) problem.softwareConnectivity.get(part)).entrySet().iterator();
				while (neighbors.hasNext()) {
					SoftwareNode neighbor = (SoftwareNode) ((Map.Entry) neighbors.next()).getValue();

					/* only neighbors members of this composite */
					if (!componentMembers.contains(neighbor))
						continue;

					if (part.getBandwidth() + neighbor.getBandwidth() <= partitionSize) {
						componentMembers.remove(neighbor);
						if (partitionMode == BY_BANDWIDTH)
							componentMembers2.remove(neighbor);
						components = componentMembers.iterator();
						part.add(neighbor, problem.softwareConnectivity, problem.softConnectivityByTarget,
								problem.constraints);
						// System.out.println("\t\t\t
						// add(Module("+neighbor.name+"))");
						/*
						 * reinstantiate iterator to account for addition of
						 * component
						 */
						neighbors = ((TreeMap) problem.softwareConnectivity.get(part)).entrySet().iterator();
					} else {
						/* first one that fails */
						break;
					}

					// just one addition
					break;
				}

				componentMembers.add(part);
				if (partitionMode == BY_BANDWIDTH)
					componentMembers2.add(part);
				problem.softwareGraph.add(part);

				/* reinstantiate the iterator to select the next largest */
				components = componentMembers.iterator();
			} else {
				break;
			}
		}

		((SoftwareNode) componentMembers2.iterator().next()).getBandwidthOutDegree();
		// part = (CompositeSoftNode) componentMembers2.iterator().next();
		// if (part.getComponentsByOutDegree().size()>0)
		// {
		// // for (components = componentMembers.iterator();
		// // components.hasNext();)
		// // {
		// // SoftwareNode n = (SoftwareNode) components.next();
		// // components.remove();
		// // if (partitionMode == BY_BANDWIDTH)
		// // componentMembers2.remove(n);
		// // part1.add(n, problem.softwareConnectivity,
		// problem.softConnectivityByTarget, problem.constraints);
		// // }
		// // problem.addSoftwareNode(part);
		// // moduleList.add(part);
		// // if (part1.getComponentsByOutDegree().size()>0)
		// // {
		// // problem.addSoftwareNode(part1);
		// // moduleList.add(part1);
		// // }
		// return part.getTotalMsgBandwidth();
		// }
		/* empty composite partition invalid */
		return -1;
	}

	/**
	 * partitions composite into a part whose size <= partitionSize and the
	 * rest. Both parts are
	 */
	public double partition(CompositeSoftNode composite, double partitionSize, TreeSet moduleList,
			OutDegreeAssignmentProblem problem, int partitionMode) {
		System.out.println(this + ": partition(composite(" + composite.getBandwidth() + "), partitionSize("
				+ partitionSize + "))");
		/* is this composite breakable? */
		if (!composite.breakable) {
			// System.out.println(" partition:not breakable");
			return -1;
		}

		CompositeSoftNode part = new CompositeSoftNode(new BandwidthComparator());
		CompositeSoftNode part1 = new CompositeSoftNode(new BandwidthComparator());
		TreeSet componentMembers;
		TreeSet componentMembers2;
		if (partitionMode == BY_BANDWIDTH) {
			componentMembers = composite.getComponentsByOutDegree(); // composite.getComponents();
			componentMembers2 = composite.getComponents();
		} else // BY_SIZE
		{
			componentMembers = composite.getComponents();
			componentMembers2 = composite.getComponents();
		}

		Iterator components = componentMembers.iterator(); // composite.getComponents().iterator();
		while (components.hasNext()) {
			SoftwareNode module = (SoftwareNode) components.next();
			// System.out.println("partition: checking
			// module("+module.name+").BW("+module.getBandwidth()+")
			// partitionSize("+partitionSize+")");
			if (part.getBandwidth() + module.getBandwidth() <= partitionSize) {
				components.remove();
				if (partitionMode == BY_BANDWIDTH)
					componentMembers2.remove(module);
				part.add(module, problem.softwareConnectivity, problem.softConnectivityByTarget, problem.constraints);
				// System.out.println("\t\t\t add(Module("+module.name+"))");

				Iterator neighbors = ((TreeMap) problem.softwareConnectivity.get(part)).entrySet().iterator();
				while (neighbors.hasNext()) {
					SoftwareNode neighbor = (SoftwareNode) ((Map.Entry) neighbors.next()).getValue();

					/* only neighbors members of this composite */
					if (!componentMembers.contains(neighbor))
						continue;

					if (part.getBandwidth() + neighbor.getBandwidth() <= partitionSize) {
						componentMembers.remove(neighbor);
						if (partitionMode == BY_BANDWIDTH)
							componentMembers2.remove(neighbor);
						components = componentMembers.iterator();
						part.add(neighbor, problem.softwareConnectivity, problem.softConnectivityByTarget,
								problem.constraints);
						// System.out.println("\t\t\t
						// add(Module("+neighbor.name+"))");
						/*
						 * reinstantiate iterator to account for addition of
						 * component
						 */
						neighbors = ((TreeMap) problem.softwareConnectivity.get(part)).entrySet().iterator();
					} else {
						/* first one that fails */
						break;
					}
				}
				/* Done */
				// problem.softwareGraph.add(part);
			} else {
				break;
			}
		}
		if (part.getComponentsByOutDegree().size() > 0) {
			for (components = componentMembers.iterator(); components.hasNext();) {
				SoftwareNode n = (SoftwareNode) components.next();
				components.remove();
				if (partitionMode == BY_BANDWIDTH)
					componentMembers2.remove(n);
				part1.add(n, problem.softwareConnectivity, problem.softConnectivityByTarget, problem.constraints);
			}
			problem.addSoftwareNode(part);
			moduleList.add(part);
			if (part1.getComponentsByOutDegree().size() > 0) {
				problem.addSoftwareNode(part1);
				moduleList.add(part1);
			}
			numberOfPartitions++;

			/*
			 * double cutBandwidth=0.0;
			 * 
			 * TreeMap conn = (TreeMap) problem.softwareConnectivity.get(part);
			 * 
			 * int i=0; for (Object[] neighs = conn.entrySet().toArray(); i <
			 * neighs.length; i++) { Map.Entry entry = (Map.Entry) neighs[i]; if
			 * (entry == null || entry.getValue() == null) continue;
			 * 
			 * Message msg = (Message) entry.getKey(); cutBandwidth +=
			 * msg.getBandwidth(); }
			 * 
			 * JOptionPane.showMessageDialog(null,
			 * "cutBandwidth("+Double.toString(cutBandwidth)+ ")
			 * totalBandwidth("+Double.toString(part.getTotalMsgBandwidth())+")");
			 * return cutBandwidth;
			 */

			TreeMap conn = (TreeMap) problem.softwareConnectivity.get(part);

			int i = 0;

			conn = (TreeMap) problem.softwareConnectivity.get(part1);

			System.out.println("partition() = part1(" + part + ") part2(" + part1 + ")");
			return part.getTotalMsgBandwidth();
		}
		/* empty composite partition invalid */
		return -1;
	}

	public abstract boolean solve(TreeSet moduleAggregate, TreeSet validProcessors, OutDegreeAssignmentProblem problem);
}