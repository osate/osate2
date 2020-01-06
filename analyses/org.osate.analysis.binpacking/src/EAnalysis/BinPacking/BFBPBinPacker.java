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

public class BFBPBinPacker extends BaseLowLevelBinPacker {
	Expansor expansor;

	public BFBPBinPacker(Expansor e) {
		expansor = e;
	}

	/**
	 * returns true if progress was made and we find no component that could not
	 * be deployed
	 */
	public boolean solve(TreeSet moduleAggregate, TreeSet validProcessors, OutDegreeAssignmentProblem problem) {
		HardwareNode[] largestProcessor = new HardwareNode[1];
		Site[] largestSite = new Site[1];

		double aggregateBandwidth = 0.0;
		for (Iterator iter = moduleAggregate.iterator(); iter.hasNext();) {
			aggregateBandwidth += ((ProcessingLoad) iter.next()).getBandwidth();
		}

		expansor.createInitialHardware(problem, validProcessors, aggregateBandwidth);

		// System.out.print("--- DISCONNECTED COMPONENTS FOR AGGREGATE(");
		// for (Iterator iter = moduleAggregate.iterator();
		// iter.hasNext();)
		// {
		// SoftwareNode n = (SoftwareNode) iter.next();
		// System.out.print(n.name+":");
		// }
		// System.out.println(") ---");
		TreeSet disconnectedComponents = getDisconnectedComponents(new BandwidthComparator(), moduleAggregate, problem);

		// for (Iterator iter = disconnectedComponents.iterator();
		// iter.hasNext();)
		// {
		// SoftwareNode n = (SoftwareNode) iter.next();
		// System.out.println("\t comp("+n.name+")");
		// }
		// System.out.println("---- END OF DISCONNECTED COMPONENT ---");
		for (Iterator subGraphsList = disconnectedComponents.iterator(); subGraphsList.hasNext();) {
			boolean deployed = false;
			CompositeSoftNode composite = (CompositeSoftNode) subGraphsList.next();
			// System.out.println("\t checking module("+composite.name+")");

			/* order processors into affinity groups */
			TreeSet affinityProcessorList = new TreeSet(new AffinityComparator(composite, problem));
			affinityProcessorList.addAll(validProcessors);

			// System.out.println("\n --- AFFINITY PROCESSORS ---");
			// for (Iterator iter = affinityProcessorList.iterator();
			// iter.hasNext();)
			// {
			// Processor p = (Processor) iter.next();
			// System.out.println("\t proc("+p.name+")");
			// }
			// System.out.println("------ END OF AFFINITY LIST ---");
			/* Search for processor where the subgraph fits */
			for (Iterator processorList = affinityProcessorList.iterator(); // validProcessors.iterator();
			processorList.hasNext();) {
				HardwareNode processor = (HardwareNode) processorList.next();
				/* verify constraints */
				if (processor.canAddToFeasibility(composite)) {
					/* reorder processor */
					if (!problem.hardwareGraph.remove(processor)) {
						// System.out.println("\n **** processor not properly
						// removed *** \n");
					}
					if (!validProcessors.remove(processor)) {
						// System.out.println("\n *** processor not properly
						// removed from valid set *** \n");
					}
					processor.addIfFeasible(composite);
					deployed = true;
					TreeSet members = composite.getBasicComponents();
					// System.out.println(" \t\t ++++ ADDED
					// COMPOSITE("+composite.name+") TO
					// PROCESSOR("+processor.name+")");
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
								HardwareNode neighborProcessor = null;
								if ((neighborProcessor = neighbor.getDeployedTo()) != null) {
									// System.out.println("\t\tchecking
									// neighbor("+neighbor.name+")
									// proc("+neighborProcessor.name+")");
									/* search for the links between */
									if (neighborProcessor.equals(processor)) {
										processor.addIfFeasible(msg);
										continue;
									}

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
									}
									if (!foundLink) {
										/*
										 * If I could not find current link add
										 * it
										 */
										hostLink = expansor.addLinkBetween(processor, neighborProcessor, msg, problem);
										if (hostLink == null) {
											/* failed to add new link */
											// System.out.println("\t\t Failed
											// to add new link");
											processor.removeFromFeasibleSet(composite);
											if (problem.errorReporter != null)
												problem.errorReporter.reportError(1, problem);
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

			if (!deployed) {
				// System.out.println("\t composite("+composite.name+")");
				if (validProcessors.size() > 0) {
					/* select module to partition */
					TreeSet componentsByCompression = new TreeSet(new BandwidthCompressionComparator());
					componentsByCompression.addAll(disconnectedComponents);
					componentsByCompression.add(composite);
					CompositeSoftNode toPartition = (CompositeSoftNode) componentsByCompression.iterator().next();
					if (toPartition.equals(composite))
						subGraphsList.remove();
					double partitionSize = expansor.getLargestProcessorSizeForModule(toPartition, validProcessors,
							problem);
					// System.out.println("trying to partition
					// module("+toPartition.name+") into chunks
					// size("+partitionSize+")");
					// System.out.print("\t into processors[");
					// for (Iterator iter1 = validProcessors.iterator();
					// iter1.hasNext();)
					// {
					// HardwareNode hn = (HardwareNode) iter1.next();
					// System.out.print(hn.name+"("+hn.getAvailableCapacity()+"),");
					// }
					// System.out.println("]");
					double cutBandwidth = partition(toPartition, partitionSize, disconnectedComponents, problem,
							BY_SIZE);
					if (cutBandwidth >= 0) {
						/* partition successful */
						problem.removeSoftwareNode(toPartition);
						// System.out.println("\t\t partition successful");
						// System.out.println("--- NEW PARTS --- ");
						// for (Iterator iter =
						// disconnectedComponents.iterator();
						// iter.hasNext();)
						// {
						// SoftwareNode sn = (SoftwareNode) iter.next();
						// System.out.println("\t node("+sn.name+")");
						// }
						// System.out.println("-----------------");
						subGraphsList = disconnectedComponents.iterator();
					} else {
						/* partition failed */
						// System.out.println("\t\t partition failed! -- trying
						// to expand...");
						largestProcessor[0] = null;
						largestSite[0] = null;
						if (!expansor.expandProcessorForModule(toPartition, validProcessors, problem, largestProcessor,
								largestSite)) {
							/*
							 * cannot expand and there is a module that does not
							 * fit any processor
							 */

							/*
							 * see if the largest processor found is largest
							 * than the partitionSize
							 */
							if (largestProcessor[0] != null
									&& largestProcessor[0].getAvailableCapacity() > partitionSize) {
								partitionSize = largestProcessor[0].getAvailableCapacity();
								/*
								 * we should try partitioning again with the new
								 * size
								 */
								cutBandwidth = partition(toPartition, partitionSize, disconnectedComponents, problem,
										BY_SIZE);
								if (cutBandwidth >= 0) {
									// System.out.println("\t\t partition
									// successful");
									// System.out.println("--- NEW PARTS --- ");
									// for (Iterator iter =
									// disconnectedComponents.iterator();
									// iter.hasNext();)
									// {
									// SoftwareNode sn = (SoftwareNode)
									// iter.next();
									// System.out.println("\t
									// node("+sn.name+")");
									// }
									// System.out.println("-----------------");
									expansor.cloneProcessorInto(largestProcessor[0], largestSite[0], validProcessors,
											problem);
									subGraphsList = disconnectedComponents.iterator();
								} else {
									// System.out.println("\t\t\t partition
									// FAILED!");
									return false;
								}

							} else {
								// System.out.println("\t\t\texpansion
								// FAILED!");
								return false;
							}
						} else {
							/*
							 * addition of hardware succesful restart subgraph
							 * list
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
							largestSite))
						return false;
					else
						subGraphsList = disconnectedComponents.iterator();
				}
			}
		}
		return true;
	}
}