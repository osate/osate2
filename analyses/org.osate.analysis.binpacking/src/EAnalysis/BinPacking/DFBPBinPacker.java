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

public class DFBPBinPacker extends BaseLowLevelBinPacker {
	Expansor expansor;

	public DFBPBinPacker(Expansor e) {
		expansor = e;
	}

	/**
	 * returns true if progress was made and we find no component
	 * that could not be deployed
	 */
	public boolean solve(TreeSet moduleAggregate, TreeSet validProcessors, OutDegreeAssignmentProblem problem) {
		int deploymentCount = 0;
		HardwareNode[] largestProcessor = new HardwareNode[1];
		Site[] largestSite = new Site[1];

		double aggregateBandwidth = 0.0;
		for (Iterator iter = moduleAggregate.iterator(); iter.hasNext();) {
			aggregateBandwidth += ((ProcessingLoad) iter.next()).getBandwidth();
		}

		expansor.createInitialHardware(problem, validProcessors, aggregateBandwidth);

		System.out.println("\n\n *** DFBPBinPacker initial Hardware.size(" + problem.hardwareGraph.size()
				+ ") validProcessor.size(" + validProcessors.size() + ") for total bandwidth(" + aggregateBandwidth
				+ ") ** \n");

// 	System.out.print("--- DISCONNECTED COMPONENTS FOR AGGREGATE(");
// 	for (Iterator iter = moduleAggregate.iterator();
// 	     iter.hasNext();)
// 	    {
// 		SoftwareNode n = (SoftwareNode) iter.next();
// 		System.out.print(n.name+":");
// 	    }
// 	System.out.println(") ---");
		TreeSet disconnectedComponents = getDisconnectedComponents(new BandwidthComparator(), moduleAggregate, problem);

// 	for (Iterator iter = disconnectedComponents.iterator();
// 	     iter.hasNext();)
// 	    {
// 		SoftwareNode n = (SoftwareNode) iter.next();
// 		System.out.println("\t comp("+n.name+")");
// 	    }
// 	System.out.println("---- END OF DISCONNECTED COMPONENT ---");
		boolean progress = true;
		for (Iterator subGraphsList = disconnectedComponents.iterator(); subGraphsList.hasNext();) {
			CompositeSoftNode composite = (CompositeSoftNode) subGraphsList.next();
			// System.out.println("\t checking module("+composite.name+")");

			/* order processors into affinity groups */
			TreeSet affinityProcessorList = new TreeSet(new AffinityComparator(composite, problem));
			affinityProcessorList.addAll(validProcessors);

			System.out.println("\n --- AFFINITY PROCESSORS ---");
			for (Iterator iter = affinityProcessorList.iterator(); iter.hasNext();) {
				HardwareNode p = (HardwareNode) iter.next();
				System.out.println("\t proc(" + p + ").name(" + p.name + ")");
				System.out.println("\t\t links = " + problem.hardwareConnectivity.get(p));
			}
			System.out.println("------ END OF AFFINITY LIST ---");
			/* Search for processor where the subgraph fits */
			for (Iterator processorList = affinityProcessorList.iterator(); // validProcessors.iterator();
			processorList.hasNext();) {
				HardwareNode processor = (HardwareNode) processorList.next();
				/* verify constraints */
				if (processor.canAddToFeasibility(composite)) {
					deploymentCount++;
					/* reorder processor */
					if (!problem.hardwareGraph.remove(processor)) {
						System.out.println("\n **** processor not properly removed *** \n");
					}
					if (!validProcessors.remove(processor)) {
						System.out.println("\n *** processor not properly removed from valid set *** \n");
					}

					System.out.println(
							"\n \t\t--- AFFINITY PROCESSORS before addIfFeasible to proc(" + processor + ")---");
					for (Iterator iter = affinityProcessorList.iterator(); iter.hasNext();) {
						HardwareNode p = (HardwareNode) iter.next();
						System.out.println("\t\t\t proc(" + p + ").name(" + p.name + ")");
						System.out.println("\t\t\t\t links = " + problem.hardwareConnectivity.get(p));
					}
					System.out.println("\t\t ------ END OF AFFINITY LIST ---");

					TreeSet l = (TreeSet) problem.hardwareConnectivity.remove(processor);
					processor.addIfFeasible(composite);
					problem.hardwareConnectivity.put(processor, l);

					progress = true;

					System.out.println("\n \t\t--- AFFINITY PROCESSORS  after addIfFeasible---");
					for (Iterator iter = affinityProcessorList.iterator(); iter.hasNext();) {
						HardwareNode p = (HardwareNode) iter.next();
						System.out.println("\t\t\t proc(" + p + ").name(" + p.name + ")");
						System.out.println("\t\t\t\t links = " + problem.hardwareConnectivity.get(p));
					}
					System.out.println("\t\t ------ END OF AFFINITY LIST ---");

					TreeSet members = composite.getBasicComponents();
					System.out.println(" \t\t ++++ ADDED COMPOSITE(" + composite.name + ") TO PROCESSOR(" + processor
							+ ").NAME(" + processor.name + ")");
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
								// Ignore composites we will trace their individual messages
								continue;
							} else {
								HardwareNode neighborProcessor = null;
								if ((neighborProcessor = neighbor.getDeployedTo()) != null) {
									// System.out.println("\t\tchecking neighbor("+neighbor.name+") proc("+neighborProcessor.name+")");
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
											System.out.println("\t\t\t --- checking link (" + hostLink + ")");
											for (Iterator connNodes = hostLink.getConnectedNodes()
													.iterator(); (!foundLink) && connNodes.hasNext();) {
												HardwareNode other = (HardwareNode) connNodes.next();
												System.out.println("\t\t\t\t -> connectedTo(" + other + ")");
												if (other.equals(neighborProcessor)) {
													// System.out.println("\t\t\t\t\t connected!");
													if (hostLink.canAddToFeasibility(msg))
													// if (hostLink.addIfFeasible(msg))
													{
														problem.removeLink(hostLink);
														hostLink.addIfFeasible(msg);
														problem.addLink(hostLink);
														System.out.println(
																"\t\t\t\t\t msg deployed to link(" + hostLink + ")!");
														foundLink = true;
													} else {
														System.out.println("\t\t\t\t\t msg,bw(" + msg.getBandwidth()
																+ ") DOESN'T FIT in link.bw("
																+ hostLink.getAvailableCapacity() + ")!");
													}
												}
											}
										}
									} else
										System.out.println("Links == null for processor(" + processor + ")!!!");
									if (!foundLink) {
										/* If I could not find current link add it */
										hostLink = expansor.addLinkBetween(processor, neighborProcessor, msg, problem);
										if (hostLink == null) {
											/* failed to add new link */
											System.out.println("\t\t 1 Failed to add new link");
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

			System.out.println("Finished deployment of unpartition");
			/*
			 * if there are still composites get the next one.
			 * SubGraphs that are not deployable are skipped.
			 */
			if (!subGraphsList.hasNext()) {
				System.out.println("Checking undeployed components ...");
				/*
				 * finished traversing the iterator, reinstantiate to traverse
				 * again for the subgraphs that could not be deployed.
				 */
				subGraphsList = disconnectedComponents.iterator();
				if (subGraphsList.hasNext()) {

					// If we have not make any progress since last time we split
					// components then we fail already
					if (!progress)
						return false;

					// Mark progress as false to see if any change we do in this
					// section leads to a progress or not
					progress = false;

					// composite = (CompositeSoftNode) subGraphsList.next();
					// System.out.println("\t composite("+composite.name+")");
					if (validProcessors.size() > 0) {
						/* select module to partition */
						TreeSet componentsByCompression = new TreeSet(new BandwidthCompressionComparator());
						componentsByCompression.addAll(disconnectedComponents);
						CompositeSoftNode toPartition = null;
						for (Iterator components = componentsByCompression.iterator(); components.hasNext();) {
							toPartition = (CompositeSoftNode) components.next();
							if (toPartition.getBasicComponents().size() > 0)
								break;
							else
								toPartition = null;
						}

						// CompositeSoftNode toPartition = (CompositeSoftNode)componentsByCompression.iterator().next();
						double partitionSize = expansor.getLargestProcessorSizeForModule(toPartition, validProcessors,
								problem);
						System.out.println("trying to partition module(" + toPartition.name + ") into chunks size("
								+ partitionSize + ")");
// 					System.out.print("\t into processors[");
// 					for (Iterator iter1 = validProcessors.iterator();
// 					     iter1.hasNext();)
// 					    {
// 						HardwareNode hn = (HardwareNode) iter1.next();
// 						System.out.print(hn.name+"("+hn.getAvailableCapacity()+"),");
// 					    }
// 					System.out.println("]");
						double cutBandwidth = partition(toPartition, partitionSize, disconnectedComponents, problem,
								BY_BANDWIDTH); // BY_SIZE);
						if (cutBandwidth >= 0) {
							/* partition successful */
							disconnectedComponents.remove(toPartition);
							problem.removeSoftwareNode(toPartition);
// 						System.out.println("\t\t partition successful");
// 						System.out.println("--- NEW PARTS --- ");
// 						for (Iterator iter = disconnectedComponents.iterator();
// 						     iter.hasNext();)
// 						    {
// 							SoftwareNode sn = (SoftwareNode) iter.next();
// 							System.out.println("\t node("+sn.name+")");
// 						    }
// 						System.out.println("-----------------");
							subGraphsList = disconnectedComponents.iterator();
						} else {
							/* partition failed */
							System.out.println("\t\t partition failed! -- trying to expand...");
							System.out.println("--- DEPLOYED NODES ------");
							for (Iterator iter = problem.softwareGraph.iterator(); iter.hasNext();) {
								SoftwareNode n = (SoftwareNode) iter.next();
								if (n instanceof CompositeSoftNode) {
									for (Iterator iter1 = ((CompositeSoftNode) n).getBasicComponents().iterator(); iter1
											.hasNext();) {
										SoftwareNode inN = (SoftwareNode) iter1.next();
										if (inN.getDeployedTo() != null) {
											System.out.println("DEPLOYED node(" + inN + ")");
										} else {
											System.out.println("NOT DEPLOYED node(" + inN + ")");
										}
									}
								} else {
									if (n.getDeployedTo() != null) {
										System.out.println("DEPLOYED node(" + n + ")");
									} else {
										System.out.println("NOT DEPLOYEDnode(" + n + ")");
									}
								}
							}
							System.out.println("\t\t\t toPartition.size = " + toPartition.getBandwidth()
									+ " partitionSize = " + partitionSize);
							largestProcessor[0] = null;
							largestSite[0] = null;
							if (!expansor.expandProcessorForModule(toPartition, validProcessors, problem,
									largestProcessor, largestSite)) {
								/*
								 * cannot expand and there is a module
								 * that does not fit any processor
								 */

								/* see if the largest processor found is larger than the partitionSize */
								if (largestProcessor[0] != null
										&& largestProcessor[0].getAvailableCapacity() > partitionSize) {
									partitionSize = largestProcessor[0].getAvailableCapacity();
									/* we should try partitioning again with the new size */
									cutBandwidth = partition(toPartition, partitionSize, disconnectedComponents,
											problem, BY_BANDWIDTH); // BY_SIZE);
									if (cutBandwidth >= 0) {
// 									System.out.println("\t\t partition successful");
// 									System.out.println("--- NEW PARTS --- ");
// 									for (Iterator iter = disconnectedComponents.iterator();
// 									     iter.hasNext();)
// 									    {
// 										SoftwareNode sn = (SoftwareNode) iter.next();
// 										System.out.println("\t node("+sn.name+")");
// 									    }
// 									System.out.println("-----------------");
										System.out.println("largestProcessor[" + largestProcessor[0] + "] largestSite["
												+ largestSite[0] + "] validProcessors[" + validProcessors
												+ "], problem[" + problem + "]");
										expansor.cloneProcessorInto(largestProcessor[0], largestSite[0],
												validProcessors, problem);
										disconnectedComponents.remove(toPartition);
										subGraphsList = disconnectedComponents.iterator();
									} else {
										System.out.println("\t\t\t partition FAILED!");
										return false;
									}

								} else {
									System.out.println("\t\t\texpansion FAILED! deploymentCount = " + deploymentCount);
									System.out.println("\t\t largestProcessor = " + largestProcessor[0]);
									System.out.println("\t\t validProcessors = " + validProcessors);
									if (largestProcessor[0] != null)
										System.out.println("\t\t\t Available Capacity= "
												+ largestProcessor[0].getAvailableCapacity() + " partitionSize= "
												+ partitionSize);
									return false;
								}
							} else {
								/*
								 * addition of hardware succesful
								 * restart subgraph list
								 */
								// System.out.println("\t\t\texpansion SUCCESSFUL!");
								subGraphsList = disconnectedComponents.iterator();
							}
						}
					} else {
						largestProcessor[0] = null;
						largestSite[0] = null;
						if (!expansor.expandProcessorForModule(composite, validProcessors, problem, largestProcessor,
								largestSite)) {
							System.out.println("Failed to add processor");
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
