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
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author Dionisio de Niz This is the Expansor for the Not Fully Connected
 *         architectures
 */
public class NFCExpansor implements Expansor {
	int processorNumber = 0;

	int linkNumber = 0;

	SiteArchitecture siteArchitecture;

	public void setSiteArchitecture(SiteArchitecture s) {
		siteArchitecture = s;
	}

	public NFCExpansor() {
	}

	/**
	 * @param s
	 *            is the site architecture limiting the growth of the hardware
	 *            graph
	 */

	public NFCExpansor(SiteArchitecture s) {
		siteArchitecture = s;
	}

	public void createInitialHardware(OutDegreeAssignmentProblem problem, TreeSet validProcessors,
			double softwareLoad) {

		/* experimental overallocation */
		// softwareLoad *= 1.25;

		/*
		 * The general strategy is to fill up the sites to the maximum to
		 * minimize the number of sites required and therefore the wiring among
		 * them. Hence we start adding processors to the largest site until it
		 * is full, then the second largest and so on and so for.
		 */

		double capacity = 0.0;

		/* initialize the capacity to whatever we already have */
		for (Iterator procs = problem.hardwareGraph.iterator(); procs.hasNext();) {
			HardwareNode proc = (HardwareNode) procs.next();
			capacity += proc.getAvailableCapacity();
		}

		while (capacity < softwareLoad) {
			Processor p = null;
			Site site = null;
			Iterator sites = siteArchitecture.sitesBySize.iterator();
			while (p == null && sites.hasNext()) {
				// Select the site
				site = (Site) sites.next();

				// select the next processor type
				for (Iterator potGuests = site.potentialGuests.iterator(); potGuests.hasNext();) {
					Object o = potGuests.next();
					if (!(o instanceof Processor))
						continue;
					p = (Processor) o;
					if (site.canFitGuest(p))
						break;
					else
						p = null;
				}
				if (p != null) {
					/* we got the next processor */
					break;
				}
			}
			if (p != null) {
				Processor p1 = null;
				try {
					p1 = (Processor) p.getClass().newInstance();
				} catch (Exception e) {
					e.printStackTrace();
				}
				Processor.cloneTo(p, p1);
				p1.name = Integer.toString(processorNumber++);
				siteArchitecture.addSiteGuest(p1, site);
				// site.addGuest(p1);
				/* this processor type fits */
				capacity += p1.getAvailableCapacity();
				// System.out.println("\n\n********* 1 new
				// Proc.netInterfaces.size("+p1.classNetInterfaces.size()+")\n");
				problem.hardwareGraph.add(p1);
				// DebugMonitor.println(DebugMonitor.channels[2]," NEW
				// PROCESSOR("+p1.toString()+") 1 ");
				validProcessors.add(p1);
				if (p1.getHost() == null)
					System.out.println("1 Node(" + p1 + ").hashCode(" + p1.hashCode() + ") host==null");
			} else {
				/* I cannot add more processors */
			}

		}
	}

	public double getLargestProcessorSizeForModule(SoftwareNode module, TreeSet validProcessors,
			OutDegreeAssignmentProblem problem) {
		/* find the processors of neighboring modules */
		TreeSet procNeighborhood = new TreeSet(new DecreasingCapacityComparator());

		for (Iterator moduleNeighbors = ((TreeMap) problem.softwareConnectivity.get(module)).entrySet()
				.iterator(); moduleNeighbors.hasNext();) {
			SoftwareNode neighbor = (SoftwareNode) ((Map.Entry) moduleNeighbors.next()).getValue();
			HardwareNode proc = neighbor.getDeployedTo();
			if (proc != null)
				procNeighborhood.add(proc);
		}

		for (Iterator procs = procNeighborhood.iterator(); procs.hasNext();) {
			HardwareNode proc = (HardwareNode) procs.next();
			if (validProcessors.contains(proc))
				return proc.getAvailableCapacity();
		}

		// If no neighbors then return the largest valid processor
		if (validProcessors.size() > 0)
			return ((HardwareNode) validProcessors.last()).getAvailableCapacity();

		return 0.0;
	}

	public boolean expandProcessorForModule(SoftwareNode module, TreeSet validProcessors,
			OutDegreeAssignmentProblem problem, HardwareNode[] largestProcessor, Site[] largestSite) {
		/* find the sites of neighboring modules */
		TreeSet siteNeighborhood = new TreeSet(new CapacityComparator());

		Location site = null;
		for (Iterator moduleNeighbors = ((TreeMap) problem.softwareConnectivity.get(module)).entrySet()
				.iterator(); moduleNeighbors.hasNext();) {
			SoftwareNode neighbor = (SoftwareNode) ((Map.Entry) moduleNeighbors.next()).getValue();
			HardwareNode proc = neighbor.getDeployedTo();
			site = (proc != null) ? proc.getHost() : null;
			if (site != null)
				if (!siteNeighborhood.contains(site))
					siteNeighborhood.add(site);
		}

		/* Is this module isolated or none of the neighbors have been deployed */
		if (siteNeighborhood.size() == 0) {
			siteNeighborhood = siteArchitecture.sitesBySize;
		}

		Iterator sites = siteNeighborhood.iterator();
		Processor newHardware = null;
		if (sites.hasNext()) {
			/* the first one is the largest */
			site = (Location) sites.next();
			// System.out.println("NFCExpansor: trying site("+site+")");
			newHardware = (Processor) site.getLargestPotentialProcessor();
			if (newHardware != null) {
				if (newHardware.canAddToFeasibility(module)) {
					// System.out.println("NFCExpansor:
					// largestPotnetialGuest("+newHardware+")");
					/* add new hardware to hardware graph */
					Processor p1 = null;
					try {
						p1 = (Processor) newHardware.getClass().newInstance();
					} catch (Exception e) {
						e.printStackTrace();
					}
					Processor.cloneTo(newHardware, p1);
					p1.name = Integer.toString(processorNumber++);
					siteArchitecture.addSiteGuest((HardwareNode) p1, (Site) site);
					// site.addGuest(p1);
					// System.out.println("\n\n********* 2 new
					// Proc.netInterfaces.size("+p1.classNetInterfaces.size()+")
					// newHardware.netIntf.size("+
					// newHardware.classNetInterfaces.size()+")\n");
					problem.hardwareGraph.add(p1);
					// DebugMonitor.println(DebugMonitor.channels[2]," NEW
					// PROCESSOR("+p1.toString()+") 2");
					validProcessors.add(p1);
					largestProcessor[0] = p1;
					largestSite[0] = (Site) site;
					if (p1.getHost() == null)
						System.out.println("2 Node(" + p1 + ").hashCode(" + p1.hashCode() + ") host==null");

					return true;
				} else {
					largestProcessor[0] = newHardware;
					largestSite[0] = (Site) site;
				}
			}
		}

		/*
		 * if it could not fit in site of module's neighbors look into
		 * neighboring sites keep adding to same neighborhood
		 * 
		 * The only neighboring sites are the one that neighbors with all of
		 * this module neighbors -- likely a reduced set
		 */
		if (newHardware == null) {
			// System.out.println("trying to add independent hardware");
			for (Iterator allSites = siteArchitecture.sitesBySize.iterator(); allSites.hasNext();) {
				Location neighborSite = (Location) allSites.next();
				// System.out.println("trying site("+neighborSite+")");
				boolean neighbor = false;
				for (sites = siteNeighborhood.iterator(); sites.hasNext();) {
					site = (Location) sites.next();
					if (neighborSite.equals(site)) {
						/* self means neighbor */
						// System.out.println("--- SELF SITE");
						neighbor = true;
						break;
					} else if (siteArchitecture.neighbor((Site) site, (Site) neighborSite)) {
						neighbor = true;
					} else {
						/* no neighbor look for next one */
						neighbor = false;
						break;
					}
				}

				if (neighbor) {
					newHardware = (Processor) neighborSite.getLargestPotentialProcessor();
					// System.out.println("Largest Processor
					// ("+newHardware+")");
					if (newHardware != null) {
						if (newHardware.canAddToFeasibility(module)) {
							/* add new hardware to hardware graph */
							Processor p1 = null;
							try {
								p1 = (Processor) newHardware.getClass().newInstance();
							} catch (Exception e) {
								e.printStackTrace();
							}
							Processor.cloneTo(newHardware, p1);
							p1.name = Integer.toString(processorNumber++);
							siteArchitecture.addSiteGuest((HardwareNode) p1, (Site) neighborSite);
							// neighborSite.addGuest(p1);
							largestProcessor[0] = p1;
							largestSite[0] = (Site) neighborSite;
							// System.out.println("\n\n********* 3 new
							// Proc.netInterfaces.size("+p1.classNetInterfaces.size()+")\n");
							problem.hardwareGraph.add(p1);
							// DebugMonitor.println(DebugMonitor.channels[2],"
							// NEW PROCESSOR("+p1.toString()+") 3");
							validProcessors.add(p1);
							if (p1.getHost() == null)
								System.out.println("3 Node(" + p1 + ").hashCode(" + p1.hashCode() + ") host==null");

							return true;
						} else {
							largestProcessor[0] = newHardware;
							largestSite[0] = (Site) neighborSite;
						}
					}
				}
			}
		}
		return false;
	}

	// public Processor cloneProcessorInto(Processor n, Location site, TreeSet
	// validProcessors, OutDegreeAssignmentProblem problem)
	public HardwareNode cloneProcessorInto(HardwareNode n, Location site, TreeSet validProcessors,
			OutDegreeAssignmentProblem problem) {
		HardwareNode p1 = null;
		try {
			p1 = (HardwareNode) n.getClass().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		HardwareNode.cloneTo(n, p1);
		// System.out.println("cloneInto()
		// n.interfaces.size("+n.classNetInterfaces.size()+
		// ") p1.interfaces.size("+p1.classNetInterfaces.size()+")");
		p1.name = Integer.toString(processorNumber++);
		siteArchitecture.addSiteGuest(p1, (Site) site);
		// site.addGuest(p1);
		// System.out.println("\n\n********* 4 new
		// Proc.netInterfaces.size("+p1.classNetInterfaces.size()+")\n");
		problem.hardwareGraph.add(p1);
		// DebugMonitor.println(DebugMonitor.channels[2]," NEW
		// PROCESSOR("+p1.toString()+") 4");
		validProcessors.add(p1);
		if (p1.getHost() == null)
			System.out.println("4 Node(" + p1 + ").hashCode(" + p1.hashCode() + ") host==null");

		return p1;
	}

	public Link addLinkBetween(HardwareNode node1, HardwareNode node2, Message msg,
			OutDegreeAssignmentProblem problem) {
		Site site1 = (Site) node1.getHost();
		Site site2 = (Site) node2.getHost();

		// System.out.println("node("+node1.name+") site("+site1+")");
		// System.out.println("node("+node2.name+") site("+site2+")");

		/* first try to see if we can connect to existing link */
		Processor proc1 = (Processor) node1;
		Processor proc2 = (Processor) node2;

		TreeSet commonLinkTypes = proc1.getCommonLinkTypes(proc2);

		// System.out.println(" -- common links --");
		// for (Iterator iter = commonLinkTypes.iterator();
		// iter.hasNext();)
		// {
		// Link l = (Link) iter.next();
		// System.out.println("\t "+l);
		// }
		if (site1.equals(site2)) {
			Link link = (Link) site1.getLargestCurrentGuest(commonLinkTypes);
			if (link != null && link.canAddToFeasibility(msg)) {
				problem.removeLink(link);
				link.addIfFeasible(msg);
				link.add(proc1);
				link.add(proc2);
				/* update the connectivity matrix */
				problem.addLink(link);
				siteArchitecture.addSiteGuest(link, site1);
				// site1.addGuest(link);
				proc1.attachToLink(link);
				proc2.attachToLink(link);
				// DebugMonitor.println(DebugMonitor.channels[1],"RECONNECT
				// LINK("+link.toString()+") proc("+proc1.toString()+")
				// proc("+proc2.toString()+")");
				return link;
			} else {
				/* now try to add largest possible link */
				link = null;
				Iterator iter = commonLinkTypes.iterator();
				// if (iter.hasNext())
				// link = (Link) iter.next();
				// if (link != null)
				// {
				while (iter.hasNext()) {
					link = (Link) iter.next();
					if (link.canAddToFeasibility(msg)) {
						// System.out.println("POSITIVE: Can add
						// Msg.bw("+msg.getBandwidth()+") to Link("+link+")");
						Link link2 = null;
						if (site1.canFitGuest(link)) {
							// System.out.println("POSITIVE: Can Fit
							// link("+link+") in site1("+site1+")");
							try {
								link2 = (Link) link.getClass().newInstance();
								HardwareNode.cloneTo(link, link2);
								link2.name = Integer.toString(linkNumber++);
								// site1.addGuest(link2);
								link2.addIfFeasible(msg);
								link2.add(node1);
								link2.add(node2);
								problem.addLink(link2);
								// site1.addGuest(link2);
								((Processor) node1).attachToLink(link2);
								((Processor) node2).attachToLink(link2);
								siteArchitecture.addSiteGuest(link2, site1);
								// DebugMonitor.println(DebugMonitor.channels[1],"BRAND
								// NEW LINK("+link2.toString()+")
								// proc("+proc1.toString()+")
								// proc("+proc2.toString()+")");
								if (link2.getHost() == null)
									System.out.println(
											"5 Node(" + link2 + ").hashCode(" + link2.hashCode() + ") host==null");
								return link2;
							} catch (Exception e) {
								e.printStackTrace();
							}
						} else {
							// System.out.println("NEGATIVE: Cannot fit
							// link("+link+") in site("+site1+")");
							link = null;
						}
					} else {
						// System.out.println("NEGATIVE: Cannot add
						// Msg.bw("+msg.getBandwidth()+") to Link("+link+")");
						link = null;
					}
				}
				if (link == null) {
					System.out.println("\t\t 1 Could not add link");
				}
			}
			return link;
		} else {
			Duct duct = siteArchitecture.getDuctBetween(site1, site2);

			if (duct == null) {
				System.out.println(
						"\t\t 2 Could not add link : no duct between site(" + site1 + ") and site(" + site2 + ")");
				return null;
			}

			Link link = (Link) duct.getLargestCurrentGuest(commonLinkTypes);
			if (link != null && link.canAddToFeasibility(msg)) {
				problem.removeLink(link);
				link.addIfFeasible(msg);
				link.add(node1);
				link.add(node2);
				/* update the connectivity matrix */
				problem.addLink(link);
				proc1.attachToLink(link);
				proc2.attachToLink(link);
				return link;
			} else {
				/* now try to add largest possible link */
				link = (Link) duct.getLargestPotentialGuest();
				if (link != null) {
					if (link.canAddToFeasibility(msg)) {
						Link link2 = null;
						try {
							link2 = (Link) link.getClass().newInstance();
							HardwareNode.cloneTo(link, link2);
							link2.name = Integer.toString(linkNumber++);
							// duct.addGuest(link2);
							link2.addIfFeasible(msg);
							link2.add(node1);
							link2.add(node2);
							problem.addLink(link2);
							// duct.addGuest(link2);
							((Processor) node1).attachToLink(link2);
							((Processor) node2).attachToLink(link2);
							siteArchitecture.addDuctGuest(link2, duct);
							if (link2.getHost() == null)
								System.out
										.println("6 Node(" + link2 + ").hashCode(" + link2.hashCode() + ") host==null");
							return link2;
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		System.out.println("\t\t 3 Could not add link");
		return null;
	}
}