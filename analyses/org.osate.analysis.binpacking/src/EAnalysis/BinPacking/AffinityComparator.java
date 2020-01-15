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

import java.util.Collection;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author Dionisio de Niz
 * 
 * This is a comparator to be used only when the connectivity and bandwidth
 * between modules is static. If such connectivity is modified the comparator
 * will give the wrong order given that it will cache intermediate results.
 * 
 * This comparator works partitioning the natural order into three components:
 * affinity of current node affinity of neighboring nodes and capacity. The
 * affinity parts has an order of magnitud larger value than the capacity. What
 * this effectively means is that we let the capacity difference range from -1
 * to 1, the affinity of current node difference range from -100 to 100, and the
 * affinitiy of neighboring nodes range from -10 to 10
 */
public class AffinityComparator implements Comparator {

	SoftwareNode targetNode = null;

	TreeMap neighborsMap = null;

	Collection neighbors = null;

	Hashtable neighborsByTarget = null;

	Hashtable bandwidthByNeighbor = new Hashtable();

	Hashtable bandwidthByNeighbor2nd = new Hashtable();

	OutDegreeAssignmentProblem problem;

	public AffinityComparator(SoftwareNode node, OutDegreeAssignmentProblem problem) {
		targetNode = node;
		neighborsMap = (TreeMap) problem.softwareConnectivity.get(node);
		neighborsByTarget = (Hashtable) problem.softConnectivityByTarget.get(node);
		if (neighborsMap != null)
			neighbors = neighborsMap.values();
		this.problem = problem;
	}

	public int compare(Object o1, Object o2) {
		if (o1 instanceof HardwareNode && o2 instanceof HardwareNode) {
			if (((HardwareNode) o1).getUniqueID() == ((HardwareNode) o2).getUniqueID())
				return 0;
		} else {
			if (o1.hashCode() == o2.hashCode())
				return 0;
		}

		CapacityProvider n1 = (CapacityProvider) o1;
		CapacityProvider n2 = (CapacityProvider) o2;
		double difference = n1.getAvailableCapacity() - n2.getAvailableCapacity();

		/* check for neighbors deployed there */
		if (neighbors != null && neighbors.size() > 0) {
			HardwareNode h1 = (HardwareNode) o1;
			HardwareNode h2 = (HardwareNode) o2;
			TreeSet taskSet1 = h1.scheduler.getTaskSet();
			TreeSet taskSet2 = h2.scheduler.getTaskSet();
			double n1Bandwidth = 0.0;
			double n2Bandwidth = 0.0;
			double n1Bandwidth2nd = 0.0;
			double n2Bandwidth2nd = 0.0;
			if (taskSet1 != null && taskSet1.size() > 0) {
				Double bw = (Double) bandwidthByNeighbor.get(o1);
				if (bw == null) {
					TreeSet n1Neighbors = (TreeSet) taskSet1.clone();
					n1Neighbors.retainAll(neighbors);
					for (Iterator iter = n1Neighbors.iterator(); iter.hasNext();) {
						SoftwareNode neighbor = (SoftwareNode) iter.next();
						Message m = (Message) neighborsByTarget.get(neighbor);
						if (m != null) {
							n1Bandwidth += m.getBandwidth();
						}
					}
					bandwidthByNeighbor.put(o1, new Double(n1Bandwidth));
				} else
					n1Bandwidth = bw.doubleValue();
			}
			if (taskSet2 != null && taskSet2.size() > 0) {
				Double bw = (Double) bandwidthByNeighbor.get(o2);
				if (bw == null) {
					TreeSet n2Neighbors = (TreeSet) taskSet2.clone();
					n2Neighbors.retainAll(neighbors);
					for (Iterator iter = n2Neighbors.iterator(); iter.hasNext();) {
						SoftwareNode neighbor = (SoftwareNode) iter.next();
						Message m = (Message) neighborsByTarget.get(neighbor);
						if (m != null) {
							n2Bandwidth += m.getBandwidth();
						}
					}
					bandwidthByNeighbor.put(o2, new Double(n1Bandwidth));
				} else
					n2Bandwidth = bw.doubleValue();
			}

			if (n2Bandwidth == 0 && n1Bandwidth == 0) {
				/* try neighbors in neighboring hardware */
				Double bw2nd = (Double) bandwidthByNeighbor2nd.get(h1);
				if (bw2nd == null) {
					TreeSet connectivitySet = (TreeSet) problem.hardwareConnectivity.get(h1);
					if (connectivitySet != null) {
						for (Iterator iter = connectivitySet.iterator(); iter.hasNext();) {
							Link l = (Link) iter.next();
							for (Iterator iter2 = l.getConnectedNodes().iterator(); iter2.hasNext();) {
								HardwareNode hardNeighbor = (HardwareNode) iter2.next();
								Double bw = (Double) bandwidthByNeighbor.get(hardNeighbor);
								if (bw == null) {
									taskSet1 = hardNeighbor.scheduler.getTaskSet();
									TreeSet n1Neighbors = (TreeSet) taskSet1.clone();
									double neighborBandwidth = 0.0;
									n1Neighbors.retainAll(neighbors);
									for (Iterator iter3 = n1Neighbors.iterator(); iter3.hasNext();) {
										SoftwareNode neighbor = (SoftwareNode) iter3.next();
										Message m = (Message) neighborsByTarget.get(neighbor);
										if (m != null) {
											neighborBandwidth += m.getBandwidth();
										}
									}
									bandwidthByNeighbor.put(hardNeighbor, new Double(neighborBandwidth));
									n1Bandwidth2nd += neighborBandwidth;
								} else {
									n1Bandwidth2nd += bw.doubleValue();
								}
							}
							bandwidthByNeighbor2nd.put(h1, new Double(n1Bandwidth2nd));
						}
					}
				} else
					n1Bandwidth2nd = bw2nd.doubleValue();

				bw2nd = (Double) bandwidthByNeighbor2nd.get(h1);
				if (bw2nd == null) {
					TreeSet connectivitySet = (TreeSet) problem.hardwareConnectivity.get(h2);
					if (connectivitySet != null) {
						for (Iterator iter = connectivitySet.iterator(); iter.hasNext();) {
							Link l = (Link) iter.next();
							for (Iterator iter2 = l.getConnectedNodes().iterator(); iter2.hasNext();) {
								HardwareNode hardNeighbor = (HardwareNode) iter2.next();
								Double bw = (Double) bandwidthByNeighbor.get(hardNeighbor);
								if (bw == null) {
									double neighborBandwidth = 0.0;
									taskSet2 = hardNeighbor.scheduler.getTaskSet();
									TreeSet n2Neighbors = (TreeSet) taskSet2.clone();
									n2Neighbors.retainAll(neighbors);
									for (Iterator iter3 = n2Neighbors.iterator(); iter3.hasNext();) {
										SoftwareNode neighbor = (SoftwareNode) iter3.next();
										Message m = (Message) neighborsByTarget.get(neighbor);
										if (m != null) {
											neighborBandwidth += m.getBandwidth();
										}
									}
									bandwidthByNeighbor.put(hardNeighbor, new Double(neighborBandwidth));
									n2Bandwidth2nd += neighborBandwidth;
								} else {
									n2Bandwidth2nd += bw.doubleValue();
								}
							}
							bandwidthByNeighbor2nd.put(h2, new Double(n2Bandwidth2nd));
						}
					}
				} else
					n2Bandwidth2nd = bw2nd.doubleValue();
			}

			difference = difference / Math.abs(difference);

			double bandwidthDifference = n2Bandwidth - n1Bandwidth;
			bandwidthDifference = (bandwidthDifference != 0.0)
					? (bandwidthDifference / Math.abs(bandwidthDifference)) * 100.0 : 0.0;

			double bandwidthDifference2nd = n2Bandwidth2nd - n1Bandwidth2nd;
			bandwidthDifference2nd = (bandwidthDifference2nd != 0.0)
					? (bandwidthDifference2nd / Math.abs(bandwidthDifference2nd)) * 10.0 : 0.0;

			difference = difference + bandwidthDifference + bandwidthDifference2nd;
		}
		if (difference < 0.0) {
			return (int) Math.floor(difference);
		} else if (difference > 0.0) {
			return (int) Math.ceil(difference);
		} else {
			/*
			 * We cheat to enable duplicate entries int the set. Int this case
			 * we break the tie with the hashcode of the objects
			 */
			if (o1 instanceof HardwareNode && o2 instanceof HardwareNode) {
				return (int) (((HardwareNode) o1).getUniqueID() - ((HardwareNode) o2).getUniqueID());
			}
			return o1.hashCode() - o2.hashCode();
		}
	}

	public boolean equals(Object c) {
		return c.getClass().equals(getClass());
	}
}