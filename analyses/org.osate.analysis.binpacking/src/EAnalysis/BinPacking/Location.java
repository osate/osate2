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

public class Location implements CapacityProvider {
	/**
	 * returns the simple sum of the hosting dimensions: space & power
	 * 
	 * This sum can be later weighted.
	 */
	public double getAvailableHostingCapacity() {
		return availableSpace + availablePower;
	}

	public double getAvailableCapacity() {
		return totalAvailableCapacity;
	}

	/**
	 * The potential classes of guest this site can support ordered in
	 * decreasing order of capacity
	 */
	public TreeSet potentialGuests = new TreeSet(new DecreasingCapacityComparator());

	public TreeSet increasingPotentialGuests = new TreeSet(new CapacityComparator());

	public TreeSet guests = new TreeSet(new DecreasingCapacityComparator());

	double totalAvailableCapacity = 0.0;

	public Object clone() {
		Location l = null;
		try {
			l = (Location) getClass().newInstance();
			l.potentialGuests = (TreeSet) potentialGuests.clone();
			l.increasingPotentialGuests = (TreeSet) increasingPotentialGuests.clone();
			l.guests = (TreeSet) guests.clone();
			l.maximumPower = maximumPower;
			l.availablePower = availablePower;
			l.basePower = basePower;
			l.maximumSpace = maximumSpace;
			l.availableSpace = availableSpace;
			l.baseSpace = baseSpace;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	public SiteGuest getLargestCurrentGuest() {
		for (Iterator iter = guests.iterator(); iter.hasNext();) {
			SiteGuest guest = (SiteGuest) iter.next();
			if (guest.getPowerRequirement() <= availablePower && guest.getSpaceRequirement() <= availableSpace)
				return guest;
		}

		/* none fit */
		return null;
	}

	public SiteGuest getLargestCurrentGuest(TreeSet compatibleLinks) {
		for (Iterator iter = guests.iterator(); iter.hasNext();) {
			SiteGuest guest = (SiteGuest) iter.next();
			for (Iterator iter1 = compatibleLinks.iterator(); iter1.hasNext();) {
				SiteGuest compatibleLink = (SiteGuest) iter1.next();
				if ((guest.getClass().isAssignableFrom(compatibleLink.getClass())
						|| compatibleLink.getClass().isAssignableFrom(guest.getClass()))
						&& guest.getPowerRequirement() <= availablePower
						&& guest.getSpaceRequirement() <= availableSpace)
					return guest;
			}
		}

		/* none fit */
		return null;
	}

	public SiteGuest getLargestPotentialProcessor() {
		for (Iterator iter = potentialGuests.iterator(); iter.hasNext();) {
			SiteGuest guest = (SiteGuest) iter.next();
			if (!(guest instanceof Processor))
				continue;

			if (guest.getPowerRequirement() <= availablePower && guest.getSpaceRequirement() <= availableSpace) {
				return guest;
			}
		}

		/* none fit */
		return null;
	}

	public HardwareNode replaceWithBestFit(HardwareNode node) {
		double cyclesPerSecondNeeded = node.cyclesPerSecond - node.getAvailableCapacity();
		HardwareNode replacement = null;
		for (Iterator iter = increasingPotentialGuests.iterator(); iter.hasNext();) {
			replacement = (HardwareNode) iter.next();
			if (replacement.canReplace(node)) {
				/* if processor check links */
				if (node instanceof Processor) {
					Processor proc = (Processor) node;
					boolean stillCompatible = true;
					for (Iterator nets = proc.netInterfaces.iterator(); stillCompatible && nets.hasNext();) {
						NetInterface net = (NetInterface) nets.next();
						Processor replace = (Processor) replacement;
						for (Iterator rNets = replace.classNetInterfaces.iterator(); stillCompatible
								&& rNets.hasNext();) {
							NetInterface rNet = (NetInterface) rNets.next();
							if (!rNet.link.canReplace(net.link))
								stillCompatible = false;
						}
					}
					if (!stillCompatible) {
						replacement = null;
					} else {
						// this is it
						break;
					}
				} else {
					// DebugMonitor.println(DebugMonitor.channels[4], "TENTATIVE
					// REPLACEMENT LINK("+replacement.toString()+
					// ") BW("+Double.toString(replacement.cyclesPerSecond)+"
					// bits/s)");
					// if a link check compatibility with processors
					Link link = (Link) replacement;
					Link original = (Link) node;
					boolean compatible = true;
					for (Iterator procs = original.getConnectedNodes().iterator(); compatible && procs.hasNext();) {
						Processor p = (Processor) procs.next();
						if (!p.couldReplaceLink(link, original)) {
							compatible = false;
							// DebugMonitor.println(DebugMonitor.channels[4],
							// "\t NOT COMPATIBLE WITH PROC("+p.toString()+")");
							// String trace = (String)
							// Processor.creationTraces.get(p);
							// if (trace != null)
							// DebugMonitor.println(DebugMonitor.channels[4],
							// "Creation trace:\n "+trace);
							break;
						}
					}
					if (!compatible)
						replacement = null;
					else
						break;
				}
			} else
				replacement = null;
		}
		if (replacement != null) {
			if (replacement instanceof Processor) {
				Processor rep = (Processor) replacement;
				try {
					replacement = (HardwareNode) replacement.getClass().newInstance();
					HardwareNode.cloneTo(rep, replacement);
				} catch (Exception e) {
					e.printStackTrace();
				}

				for (Iterator iter = node.getTaskSet().iterator(); iter.hasNext();)
					if (!replacement.addIfFeasible((ProcessingLoad) iter.next())) {
						// System.out.println("replacement.addIfFeasible FAILED
						// !!!!");
					}

				Processor proc = (Processor) node;
				Processor rProc = (Processor) replacement;
				for (Iterator iter = proc.netInterfaces.iterator(); iter.hasNext();) {
					NetInterface net = (NetInterface) iter.next();
					rProc.attachToLink(net.link);
					net.link.remove(proc);
					net.link.add(rProc);
				}
			} else // Link
			{
				Link rep = (Link) replacement;
				try {
					replacement = (HardwareNode) replacement.getClass().newInstance();
					HardwareNode.cloneTo(rep, replacement);
				} catch (Exception e) {
					e.printStackTrace();
				}

				for (Iterator iter = node.getTaskSet().iterator(); iter.hasNext();)
					if (!replacement.addIfFeasible((ProcessingLoad) iter.next())) {
						// System.out.println("replacement.addIfFeasible FAILED
						// !!!!");
					}

				Link link = (Link) replacement;
				Link original = (Link) node;
				link.addAllNodes(original.getConnectedNodes());
				for (Iterator procs = original.getConnectedNodes().iterator(); procs.hasNext();) {
					Processor p = (Processor) procs.next();
					p.replaceLink(original, link);
				}
			}
			return replacement;
		}
		return null;
	}

	public SiteGuest getLargestPotentialGuest() {
		for (Iterator iter = potentialGuests.iterator(); iter.hasNext();) {
			SiteGuest guest = (SiteGuest) iter.next();
			if (guest.getPowerRequirement() <= availablePower && guest.getSpaceRequirement() <= availableSpace)
				return guest;
		}

		/* none fit */
		return null;
	}

	public boolean canFitGuest(HardwareNode node) {
		boolean compatible = false;
		Class nodeClass = node.getClass();
		for (Iterator iter = potentialGuests.iterator(); iter.hasNext();) {

			SiteGuest potGuest = (SiteGuest) iter.next();
			if (potGuest.getClass().isAssignableFrom(nodeClass) || nodeClass.isAssignableFrom(potGuest.getClass())) {
				compatible = true;
				break;
			}
		}
		SiteGuest guest = node;
		// System.out.println("compatible("+compatible+
		// "), enoughPower("+(guest.getPowerRequirement() <= availablePower)+
		// "), enoughSpace("+(guest.getSpaceRequirement() <=
		// availableSpace)+")");

		return (guest.getPowerRequirement() <= availablePower && guest.getSpaceRequirement() <= availableSpace
				&& compatible);
	}

	public boolean addGuest(HardwareNode node) {
		SiteGuest guest = node;
		double guestPowerReq = guest.getPowerRequirement();
		double guestSpaceReq = guest.getSpaceRequirement();
		if ((guestPowerReq <= availablePower) && (guestSpaceReq <= availableSpace)) {
			guests.add(node);
			totalAvailableCapacity += node.getAvailableCapacity();
			availablePower -= guest.getPowerRequirement();
			availableSpace -= guest.getSpaceRequirement();
			guest.setHost(this);
			return true;
		}
		return false;
	}

	public void removeGuest(HardwareNode node) {
		guests.remove(node);
		totalAvailableCapacity -= node.getAvailableCapacity();
		SiteGuest guest = node;
		availablePower += guest.getPowerRequirement();
		availableSpace += guest.getSpaceRequirement();
		((SiteGuest) node).setHost(null);
	}

	/**
	 * power initially configure to be able to supply -- it can grow to
	 * maximumPower in watts.
	 */
	public double basePower;

	/**
	 * unused power in watts
	 */
	public double availablePower;

	/**
	 * Cost in dollars
	 */
	public double basePowerCost;

	/**
	 * Cost of the additionl watt
	 */
	public double powerCostFactor;

	/**
	 * Maximum power in watts
	 */
	public double maximumPower;

	/**
	 * The space initially configured -- it can grow to maximumSpace in square
	 * centimeters
	 */
	public double baseSpace;

	/**
	 * currently available space
	 */
	public double availableSpace;

	/**
	 * in dollars
	 */
	public double baseSpaceCost;

	/**
	 * cost of square centimeter additional to base space
	 */
	public double spaceCostFactor;

	/**
	 * maximum possible space this site can be enlarge to
	 */
	public double maximumSpace;

	public Location() {
	}

	public Location(double maxPower, double maxSpace, TreeSet supportedGuests) {
		maximumPower = maxPower;
		availablePower = maxPower;
		basePower = maxPower;
		maximumSpace = maxSpace;
		availableSpace = maxSpace;
		baseSpace = maxSpace;
		for (Iterator iter = supportedGuests.iterator(); iter.hasNext();) {
			SiteGuest o = (SiteGuest) iter.next();

			potentialGuests.add(o);
			increasingPotentialGuests.add(o);
		}
	}

	public Location(double maxPower, double maxSpace, SiteGuest[] supportedGuests) {
		maximumPower = maxPower;
		availablePower = maxPower;
		basePower = maxPower;
		maximumSpace = maxSpace;
		availableSpace = maxSpace;
		baseSpace = maxSpace;
		for (int i = 0; i < supportedGuests.length; i++) {
			potentialGuests.add(supportedGuests[i]);
			increasingPotentialGuests.add(supportedGuests[i]);
		}
	}
}