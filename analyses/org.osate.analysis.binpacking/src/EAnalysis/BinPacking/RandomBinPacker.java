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
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class RandomBinPacker extends BaseLowLevelBinPacker {
	Expansor expansor;

	Random randomGenerator = new Random();

	public RandomBinPacker(Expansor e) {
		expansor = e;
	}

	/**
	 * returns true if progress was made and we find no component that could not
	 * be deployed
	 */
	public boolean solve(TreeSet moduleAggregatePrime, TreeSet validProcessors, OutDegreeAssignmentProblem problem) {
		Vector v = new Vector();
		v.addAll(moduleAggregatePrime);
		Vector moduleAggregate = new Vector();
		while (v.size() > 0) {
			int index = (int) Math.ceil(randomGenerator.nextDouble() * (v.size() - 1));
			moduleAggregate.add(v.remove(index));
		}

		HardwareNode[] largestProcessor = new HardwareNode[1];
		Site[] largestSite = new Site[1];

		double aggregateBandwidth = 0.0;
		for (Iterator iter = moduleAggregate.iterator(); iter.hasNext();) {
			aggregateBandwidth += ((ProcessingLoad) iter.next()).getBandwidth();
		}

		expansor.createInitialHardware(problem, validProcessors, aggregateBandwidth);

		for (Iterator iter = problem.hardwareGraph.iterator(); iter.hasNext();) {
			HardwareNode n = (HardwareNode) iter.next();
			if (n.getHost() == null)
				System.out.println("Node(" + n + ").hashCode(" + n.hashCode() + ") host == null");
		}
		// //System.out.print("--- DISCONNECTED COMPONENTS FOR AGGREGATE(");
		// for (Iterator iter = moduleAggregate.iterator();
		// iter.hasNext();)
		// {
		// SoftwareNode n = (SoftwareNode) iter.next();
		// //System.out.print(n.name+":");
		// }
		// //System.out.println(") ---");
		TreeSet disconnectedComponents = problem.softwareGraph;

		// for (Iterator iter = disconnectedComponents.iterator();
		// iter.hasNext();)
		// {
		// SoftwareNode n = (SoftwareNode) iter.next();
		// //System.out.println("\t comp("+n.name+")");
		// }
		// //System.out.println("---- END OF DISCONNECTED COMPONENT ---");
		for (Iterator subGraphsList = disconnectedComponents.iterator(); subGraphsList.hasNext();) {
			CompositeSoftNode composite = (CompositeSoftNode) subGraphsList.next();
			// System.out.println("\t checking module("+composite.name+")");

			/* order processors into affinity groups */
			TreeSet affinityProcessorList = validProcessors;

			/* Search for processor where the subgraph fits */
			for (Iterator processorList = affinityProcessorList.iterator(); processorList.hasNext();) {
				HardwareNode processor = (HardwareNode) processorList.next();
				/* verify constraints */
				if (processor.canAddToFeasibility(composite)) {
					/* reorder processor */
					if (!problem.hardwareGraph.remove(processor)) {
						// DebugMonitor.println(DebugMonitor.channels[1]," NOT
						// PROPERLY REMOVE
						// processor("+processor.toString()+")");
					}
					if (!validProcessors.remove(processor)) {
						// System.out.println("\n *** processor not properly
						// removed from valid set *** \n");
					}
					processor.addIfFeasible(composite);
					TreeSet members = composite.getBasicComponents();
					/* add messages to neighbors already deployed */
					TreeMap connVector = (TreeMap) problem.softwareConnectivity.get(composite);
					if (connVector != null) {
						for (Iterator neighborMsgs = connVector.entrySet().iterator(); neighborMsgs.hasNext();) {
							Map.Entry entry = (Map.Entry) neighborMsgs.next();
							SoftwareNode neighbor = (SoftwareNode) entry.getValue();

							if (members.contains(neighbor)) {
								/* avoid neighbors members of this composite */
								continue;
							}

							Message msg = (Message) entry.getKey();
							if (msg.getDeployedTo() != null) {
								// Ignore already deployed messages
								continue;
							}
							if (neighbor instanceof CompositeSoftNode) {
								// Ignore composites we will trace their
								// individual messages
								continue;
							} else {
								boolean someNull = false;
								HardwareNode neighborProcessor = null;
								if ((neighborProcessor = neighbor.getDeployedTo()) != null) {
									// System.out.println("\t\tchecking
									// neighbor("+neighbor.name+")
									// proc("+neighborProcessor.name+")");
									/* search for the links between */
									TreeSet links = (TreeSet) problem.hardwareConnectivity.get(processor);
									Link hostLink = null;
									boolean foundLink = false;
									if (links != null) {
										for (Iterator linkList = links.iterator(); (!foundLink)
												&& linkList.hasNext();) {
											hostLink = (Link) linkList.next();
											// System.out.println("\t\t\t ---
											// checking link
											// ("+hostLink.name+")");
											for (Iterator connNodes = hostLink.getConnectedNodes()
													.iterator(); (!foundLink) && connNodes.hasNext();) {
												HardwareNode other = (HardwareNode) connNodes.next();
												// System.out.println("\t\t\t\t
												// ->
												// connectedTo("+other.name+")");
												if (other.equals(neighborProcessor)) {
													// System.out.println("\t\t\t\t\t
													// connected!");
													if (hostLink.addIfFeasible(msg)) {
														// System.out.println("\t\t\t\t\t
														// msg deployed!");
														foundLink = true;
													} else {
														// System.out.println("\t\t\t\t\t
														// msg DOESN'T FIT!");
													}
												}
											}
										}
									} else {
										// DebugMonitor.println(DebugMonitor.channels[1],
										// " LINKS == NULL
										// processor("+processor.toString()+")");
										someNull = true;
									}
									if (!foundLink) {
										/*
										 * If I could not find current link add
										 * it
										 */
										// DebugMonitor.println(DebugMonitor.channels[0],"RandomBinPacker:
										// Adding link
										// between(node("+processor.toString()+"),
										// node("+neighborProcessor.toString()+"))");
										if (problem.hardwareConnectivity.get(neighborProcessor) == null) {
											// DebugMonitor.println(DebugMonitor.channels[1],"LINKS
											// == NULL
											// neighbor("+neighborProcessor.toString()+")");
											someNull = true;
										}
										hostLink = expansor.addLinkBetween(processor, neighborProcessor, msg, problem);
										if (someNull) {
											// System.out.println("processor("+processor+")");
											// DebugMonitor.println(DebugMonitor.channels[1],"NEW
											// LINK proc("+processor.toString()+
											// ").LINKS("+problem.hardwareConnectivity.get(processor).toString()+
											// ")
											// neigh("+neighborProcessor.toString()+").LINKS("+
											// problem.hardwareConnectivity.get(neighborProcessor).toString()+")");
											someNull = false;
										}
										if (hostLink == null) {
											/* failed to add new link */
											// System.out.println("\t\t Failed
											// to add new link");
											processor.removeFromFeasibleSet(composite);
											BinPackerTester.failureCode = 1;
											return false;
										}
									}
								}
							}
						}
					}

					subGraphsList.remove();
					problem.removeSoftwareNode(composite);
					problem.hardwareGraph.add(processor);
					validProcessors.add(processor);
					break;
				} else {
					// System.out.println("processor("+processor.name+").avail("+processor.getAvailableCapacity()+").addIfFeasible(module("+composite.name+").size("+composite.getBandwidth()+"))
					// FAILED!");
				}
			}

			/*
			 * if there are still composites get the next one. SubGraphs that
			 * are not deployable are skipped.
			 */
			if (!subGraphsList.hasNext()) {
				// System.out.println("Checking undeployed components ...");
				/*
				 * finished traversing the iterator, reinstantiate to traverse
				 * again for the subgraphs that could not be deployed.
				 */
				subGraphsList = disconnectedComponents.iterator();
				if (subGraphsList.hasNext()) {
					composite = (CompositeSoftNode) subGraphsList.next();
					// System.out.println("\t composite("+composite.name+")");
					subGraphsList.remove();
					if (validProcessors.size() > 0) {
						double partitionSize = expansor.getLargestProcessorSizeForModule(composite, validProcessors,
								problem);
						// System.out.println("trying to partition
						// module("+composite.name+") into chunks
						// size("+partitionSize+")");
						// System.out.print("\t into processors[");
						// for (Iterator iter1 = validProcessors.iterator();
						// iter1.hasNext();)
						// {
						// HardwareNode hn = (HardwareNode) iter1.next();
						// //System.out.print(hn.name+"("+hn.getAvailableCapacity()+"),");
						// }
						// System.out.println("]");
						double cutBandwidth = partition(composite, partitionSize, disconnectedComponents, problem,
								BY_SIZE);
						if (cutBandwidth >= 0) {
							/* partition successful */
							problem.removeSoftwareNode(composite);
							// System.out.println("\t\t partition successful");
							// System.out.println("--- NEW PARTS --- ");
							// for (Iterator iter =
							// disconnectedComponents.iterator();
							// iter.hasNext();)
							// {
							// SoftwareNode sn = (SoftwareNode) iter.next();
							// //System.out.println("\t node("+sn.name+")");
							// }
							// System.out.println("-----------------");
							subGraphsList = disconnectedComponents.iterator();
						} else {
							/* partition failed */
							// System.out.println("\t\t partition failed! --
							// trying to expand...");
							largestProcessor[0] = null;
							largestSite[0] = null;
							if (!expansor.expandProcessorForModule(composite, validProcessors, problem,
									largestProcessor, largestSite)) {
								/*
								 * cannot expand and there is a module that does
								 * not fit any processor
								 */

								/*
								 * see if the largest processor found is largest
								 * than the partitionSize
								 */
								if (largestProcessor[0] != null
										&& largestProcessor[0].getAvailableCapacity() > partitionSize) {
									partitionSize = largestProcessor[0].getAvailableCapacity();
									/*
									 * we should try partitioning again with the
									 * new size
									 */
									cutBandwidth = partition(composite, partitionSize, disconnectedComponents, problem,
											BY_SIZE);
									if (cutBandwidth >= 0) {
										// System.out.println("\t\t partition
										// successful");
										// System.out.println("--- NEW PARTS ---
										// ");
										// for (Iterator iter =
										// disconnectedComponents.iterator();
										// iter.hasNext();)
										// {
										// SoftwareNode sn = (SoftwareNode)
										// iter.next();
										// //System.out.println("\t
										// node("+sn.name+")");
										// }
										// System.out.println("-----------------");
										expansor.cloneProcessorInto(largestProcessor[0], largestSite[0],
												validProcessors, problem);
										subGraphsList = disconnectedComponents.iterator();
									} else {
										// System.out.println("\t\t\t partition
										// FAILED!");
										BinPackerTester.failureCode = 2;
										return false;
									}

								} else {
									// System.out.println("\t\t\texpansion
									// FAILED!");
									BinPackerTester.failureCode = 3;
									return false;
								}
							} else {
								/*
								 * addition of hardware succesful restart
								 * subgraph list
								 */
								// System.out.println("\t\t\texpansion
								// SUCCESSFUL!");
								subGraphsList = disconnectedComponents.iterator();
							}
						}
					} else {
						largestProcessor[0] = null;
						largestSite[0] = null;
						if (!expansor.expandProcessorForModule(composite, validProcessors, problem, largestProcessor,
								largestSite)) {
							System.out.println("valid processors.size(" + validProcessors.size() + ") composite("
									+ composite.name + ").BW(" + composite.getBandwidth() + ")");
							BinPackerTester.failureCode = 4;
							return false;
						} else
							subGraphsList = disconnectedComponents.iterator();
					}
				}
			}
		}
		return true;
	}
}