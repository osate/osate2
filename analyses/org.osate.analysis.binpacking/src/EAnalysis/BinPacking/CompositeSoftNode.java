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
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

import javax.swing.JOptionPane;

public class CompositeSoftNode extends SoftwareNode {

	public boolean deployed() {
		for (Iterator iter = getBasicComponents().iterator(); iter.hasNext();) {
			SoftwareNode n = (SoftwareNode) iter.next();
			if (!n.deployed())
				return false;
		}
		return true;
	}

	double bandwidthCompressionFactor = 0.0;

	public double getBandwidthCompressionFactor() {
		return bandwidthCompressionFactor;
	}

	/**
	 * Cummulative bandwidth requirements int cycles per second.
	 */
	double totalBandwidth = 0.0;

	Comparator comparator;

	Comparator outDegreeComparator;

	protected boolean breakable = true;

	public double getBandwidth() {
		return totalBandwidth;
	}

	/**
	 * Cummulative external message bandwidth from this composite to the outside
	 */
	public double totalMsgBandwidth = 0.0;

	public double getTotalMsgBandwidth() {
		return totalMsgBandwidth;
	}

	/**
	 * The composing modules
	 */
	TreeSet components;

	TreeSet componentsByOutDegree;

	public Object clone() {
		CompositeSoftNode n = (CompositeSoftNode) super.clone();
		n.components = (TreeSet) components.clone();
		n.componentsByOutDegree = (TreeSet) componentsByOutDegree.clone();
		return n;
	}

	public TreeSet getComponents() {
		return components;
	}

	public TreeSet getComponentsByOutDegree() {
		return componentsByOutDegree;
	}

	public boolean containsComponent(SoftwareNode n) {
		if (n.equals(this))
			return true;
		boolean result = components.contains(n);
		if (!result) {
			for (Iterator iter = components.iterator(); iter.hasNext();) {
				SoftwareNode node = (SoftwareNode) iter.next();
				if (node instanceof CompositeSoftNode)
					result = ((CompositeSoftNode) node).containsComponent(n);
				if (result)
					break;
			}
		}
		return result;
	}

	public TreeSet getBasicComponents() {
		TreeSet all = new TreeSet(components.comparator());
		for (Iterator iter = components.iterator(); iter.hasNext();) {
			SoftwareNode n = (SoftwareNode) iter.next();
			if (n instanceof CompositeSoftNode) {
				all.addAll(((CompositeSoftNode) n).getBasicComponents());
			} else {
				all.add(n);
			}
		}
		return all;
	}

	/**
	 * Deploy all components to same hardware
	 */
	public void setDeployedTo(HardwareNode n) {
		for (Iterator iter = components.iterator(); iter.hasNext();) {
			ProcessingLoad l = (ProcessingLoad) iter.next();
			l.setDeployedTo(n);
		}
	}

	/**
	 * Cannot provide consistent answer, i.e., a component can be deployed
	 * individually.
	 */
	public HardwareNode getDeployedTo() {
		return null;
	}

	public void addExternalEdgeTo(Map.Entry msgNodePair, TreeMap connectivityVector, Hashtable connVectorByTarget,
			TreeMap connectivityMatrix, Hashtable connMatrixByTarget) {
		Message msg = null;
		try {
			msg = (Message) ((Message) msgNodePair.getKey()).clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		msg.setPartner((SoftwareNode) msgNodePair.getValue(), this);
		// neighbors.remove();
		connectivityVector.put(msg, msgNodePair.getValue());
		connVectorByTarget.put(msgNodePair.getValue(), msg);

		/* modify the partners connectivity vector */
		TreeMap partnerConnectivityVector = (TreeMap) connectivityMatrix.get(msgNodePair.getValue());
		if (partnerConnectivityVector == null) {
			partnerConnectivityVector = new TreeMap(comparator);
			connectivityMatrix.put(msgNodePair.getValue(), partnerConnectivityVector);
		}
		partnerConnectivityVector.remove(msgNodePair.getKey());
		partnerConnectivityVector.put(msg, this);
		Hashtable partnerConnVectorByTarget = (Hashtable) connMatrixByTarget.get(msgNodePair.getValue());
		if (partnerConnVectorByTarget == null) {
			partnerConnVectorByTarget = new Hashtable();
			connMatrixByTarget.put(msgNodePair.getValue(), partnerConnVectorByTarget);
		}
		partnerConnVectorByTarget.remove(msgNodePair.getValue());
		partnerConnVectorByTarget.put(this, msg);
		totalMsgBandwidth += msg.getBandwidth();
		addBandwidthOutDegree(msg.getBandwidth());
	}

	public void addAll(Collection set, TreeMap connectivityMatrix, Hashtable softConnectivityByTarget,
			Hashtable constraints) {
		for (Iterator iter = set.iterator(); iter.hasNext();) {
			add((SoftwareNode) iter.next(), connectivityMatrix, softConnectivityByTarget, constraints);
		}
	}

	public void addAll(Collection set, TreeMap connectivityMatrix, Hashtable softConnectivityByTarget) {
		for (Iterator iter = set.iterator(); iter.hasNext();) {
			add((SoftwareNode) iter.next(), connectivityMatrix, softConnectivityByTarget);
		}
	}

	public void add(SoftwareNode n, TreeMap connectivityMatrix, Hashtable softConnectivityByTarget,
			Hashtable constraints) {
		add(n, connectivityMatrix, softConnectivityByTarget);
		Vector v = (Vector) constraints.get(n);
		if (v != null) {
			int vSize = v.size();
			for (int i = 0; i < vSize; i++) {
				Constraint c = (Constraint) v.get(i);
				if (c instanceof SetConstraint) {
					TreeSet bComp = getBasicComponents();
					boolean allIn = true;
					for (Iterator iter = bComp.iterator(); iter.hasNext();) {
						if (!c.members.contains(iter.next())) {
							allIn = false;
							break;
						}
					}
					if (allIn) {
						c.members.add(this);
						Vector v1 = (Vector) constraints.get(this);
						if (v1 == null) {
							v1 = new Vector();
							constraints.put(this, v1);
						}
						v1.add(c);
					}
				} else {
					c.members.add(this);
					Vector v1 = (Vector) constraints.get(this);
					if (v1 == null) {
						v1 = new Vector();
						constraints.put(this, v1);
					}
					v1.add(c);
				}
			}
		}
	}

	/**
	 * add
	 * 
	 * @param n
	 *            to the set of components add to the totalMsgBandwidth all the
	 *            messages from
	 * @param connectivityVector
	 *            that do not lead to an internal module
	 */
	public void add(SoftwareNode n, TreeMap connectivityMatrix, Hashtable softConnectivityByTarget) {
		if (n instanceof CompositeSoftNode) {
			TreeSet basicComponents = ((CompositeSoftNode) n).getBasicComponents();
			for (Iterator iter = basicComponents.iterator(); iter.hasNext();) {
				add((SoftwareNode) iter.next(), connectivityMatrix, softConnectivityByTarget);
			}
			return;
		}

//		CouplerElement newElement = (CouplerElement) n.getSemanticObject();
//		String newElementID = (newElement == null ? "composite:"
//				+ Integer.toString(n.hashCode()) : newElement.getClass()
//				.getName()
//				+ ":" + Integer.toString(newElement.ID().hashCode()));
		/*
		 * get the connectivity vector BEFORE!! modifying this To avoid problems
		 * with modified hashcode we completely remove the connectivity vector
		 * and add it at the end of the method.
		 */
		TreeMap thisConnectivityVector = (TreeMap) connectivityMatrix.remove(this);
		Hashtable thisConnVectorByTarget = (Hashtable) softConnectivityByTarget.get(this);

		boolean firstNode = false;
		/* Reset the message bandwidth */
		if (components.isEmpty()) {
			totalMsgBandwidth = 0.0;
			firstNode = true;
		}

		components.add(n);
		componentsByOutDegree.add(n);

		TreeSet basicComponents = getBasicComponents();

		TreeSet newBasicComponents = (n instanceof CompositeSoftNode) ? ((CompositeSoftNode) n).getBasicComponents()
				: new TreeSet(new BandwidthComparator());

		// name += name.substring(0,1)+name.substring(1,name.length()-1)+n.name+
		// name.substring(name.length()-1,name.length());
		name += n.name;
		totalBandwidth += n.getBandwidth();
		TreeMap connectivityVector = (TreeMap) connectivityMatrix.get(n);
		Hashtable connVectorByTarget = (Hashtable) softConnectivityByTarget.get(n);

		if (thisConnectivityVector == null) {
			if (connectivityVector != null)
				thisConnectivityVector = new TreeMap(connectivityVector.comparator());
			else
				thisConnectivityVector = new TreeMap(new BandwidthComparator());
		}

		if (thisConnVectorByTarget == null) {
			thisConnVectorByTarget = new Hashtable();
		}

		if (connectivityVector != null) {
			Comparator msgComp = connectivityVector.comparator();
			Vector addedMsgs = new Vector();
			TreeMap pendingAdditions = new TreeMap(msgComp);
			Hashtable pendingAdditionsByTarget = new Hashtable();
			Hashtable targetToMsgMap = new Hashtable();

			int i = 0;
			for (Object[] neighbors = connectivityVector.entrySet().toArray(); i < neighbors.length; i++) {
				Map.Entry entry = (Map.Entry) neighbors[i];
				if (entry == null || entry.getValue() == null)
					continue;

				Message message = (Message) entry.getKey();

				// process only messages to basic nodes
				if ((message.getSender() instanceof CompositeSoftNode)
						|| (message.getReceiver() instanceof CompositeSoftNode))
					continue;

				if (addedMsgs.contains(entry.getKey())) {
					// It is included in the pending additions
					Message msg = (Message) entry.getKey();
					pendingAdditions.remove(entry.getKey());
					pendingAdditionsByTarget.remove(entry.getValue());
					targetToMsgMap.remove(entry.getValue());
					totalMsgBandwidth -= msg.getBandwidth();
					removeBandwidthOutDegree(msg.getBandwidth());

					System.out.println("\n**********************");
					System.out.println("* (0) removing msg(" + /* senderID + */ "," + /* receiverID + */ ") bw("
							+ msg.getBandwidth() + ") from composite: " + hashCode());
					System.out.println("**********************");
				} else if ( // !(((Message)entry.getKey()).getSender()
							// instanceof CompositeSoftNode) &&
				// !(((Message)entry.getKey()).getReceiver() instanceof
				// CompositeSoftNode) &&
				(!containsComponent(((Message) entry.getKey()).getSender())
						|| !containsComponent(((Message) entry.getKey()).getReceiver()))
						&& (((Message) entry.getKey()).getDeployedTo() == null)) {
					/*
					 * message to external component. The message needs to point
					 * now to the composite node (this)
					 */
					Message msg = null;
					try {
						msg = (Message) ((Message) entry.getKey()).clone();
					} catch (Exception e) {
						e.printStackTrace();
					}
					// msg.setPartner(n, this);
					msg.setPartner((SoftwareNode) entry.getValue(), this);
					msg.setPartner(this, (SoftwareNode) entry.getValue());

//					CouplerElement eSender = (CouplerElement) msg.getSender()
//							.getSemanticObject();
//					CouplerElement eReceiver = (CouplerElement) msg
//							.getReceiver().getSemanticObject();
//
//					String senderID = (eSender == null ? "composite:"
//							+ Integer.toString(msg.getSender().hashCode())
//							: eSender.getClass().getName() + ":"
//									+ Integer.toString(eSender.ID().hashCode()));
//					String receiverID = (eReceiver == null ? "composite:"
//							+ Integer.toString(msg.getReceiver().hashCode())
//							: eReceiver.getClass().getName()
//									+ ":"
//									+ Integer.toString(eReceiver.ID()
//											.hashCode()));

					System.out.println("/////////////////////////");
					System.out.println(" Pending addition to this(" + Integer.toString(hashCode()) + ") msg("
							+ /* senderID + */ "," + /* receiverID + */ ")");
					System.out.println("////////////////////////");
					// neighbors.remove();

					Message prevMsg = null;
					/*
					 * Merge messages
					 */
					if ((prevMsg = (Message) targetToMsgMap.get(entry.getValue())) != null) {
						if (prevMsg instanceof CompositeMsgNode) {
							((CompositeMsgNode) prevMsg).add(msg);
						} else {
							CompositeMsgNode compMsg = new CompositeMsgNode(new BandwidthComparator());

							compMsg.setSender(msg.getSender());
							compMsg.setReceiver(msg.getReceiver());

							compMsg.add(msg);
							// remove previous
							pendingAdditions.remove(msg);
							pendingAdditionsByTarget.remove(entry.getValue());
							targetToMsgMap.remove(entry.getValue());

							addedMsgs.add(msg);

							// Add new composite
							pendingAdditions.put(compMsg, entry.getValue());
							pendingAdditionsByTarget.put(entry.getValue(), compMsg);
							targetToMsgMap.put(entry.getValue(), compMsg);
						}
					} else {
						addedMsgs.add(msg);

						pendingAdditions.put(msg, entry.getValue());
						pendingAdditionsByTarget.put(entry.getValue(), msg);
						targetToMsgMap.put(entry.getValue(), msg);
					}

					/* modify the partners connectivity vector */
					TreeMap partnerConnectivityVector = (TreeMap) connectivityMatrix.get(entry.getValue());
					// partnerConnectivityVector.remove(entry.getKey());
					if (partnerConnectivityVector == null) {
						if (comparator == null) {
							System.out.println(" ***** comparator == null ****");
							try {
								throw new Exception();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						partnerConnectivityVector = new TreeMap(comparator);
						connectivityMatrix.put(entry.getValue(), partnerConnectivityVector);
					}

					Hashtable partnerConnVectorByTarget = (Hashtable) softConnectivityByTarget.get(entry.getValue());
					// partnerConnectivityVector.remove(entry.getKey());
					if (partnerConnVectorByTarget == null) {
						partnerConnVectorByTarget = new Hashtable();
						softConnectivityByTarget.put(entry.getValue(), partnerConnVectorByTarget);
					}

					partnerConnectivityVector.put(msg, this);
					// partnerConnectivityVector.remove(entry.getKey());

					partnerConnVectorByTarget.put(this, msg);
					// partnerConnVectorByTarget.remove(entry.getValue());

					Message entryMsg = (Message) entry.getKey();
					if (!(entryMsg.getSender() instanceof CompositeSoftNode)
							&& !(entryMsg.getReceiver() instanceof CompositeSoftNode)) {
						totalMsgBandwidth += msg.getBandwidth();
						addBandwidthOutDegree(msg.getBandwidth());
					}
				} else if (containsComponent(((Message) entry.getKey()).getSender())
						&& containsComponent(((Message) entry.getKey()).getReceiver()))
				// else if (!entry.getValue().equals(this)&&
				// (components.contains(entry.getValue()) ||
				// basicComponents.contains(entry.getValue())))
				{
					/*
					 * if it leads to internal modules then it means that it was
					 * added before and now we need to substract it
					 */
					Message msg = ((Message) entry.getKey());
					totalMsgBandwidth -= msg.getBandwidth();
//					CouplerElement eSender = (CouplerElement) msg.getSender()
//							.getSemanticObject();
//					CouplerElement eReceiver = (CouplerElement) msg
//							.getReceiver().getSemanticObject();
//					String senderID = (eSender == null ? "composite:"
//							+ Integer.toString(msg.getSender().hashCode())
//							: eSender.getClass().getName() + ":"
//									+ Integer.toString(eSender.ID().hashCode()));
//					String receiverID = (eReceiver == null ? "composite:"
//							+ Integer.toString(msg.getReceiver().hashCode())
//							: eReceiver.getClass().getName()
//									+ ":"
//									+ Integer.toString(eReceiver.ID()
//											.hashCode()));

					System.out.println("\n**********************");
					System.out.println("* (1) removing msg(" + /* senderID + */ "," + /* receiverID + */ ") bw("
							+ msg.getBandwidth() + ") from composite: " + hashCode());
					System.out.println("**********************");

					removeBandwidthOutDegree(msg.getBandwidth());

					// try removing all composing messages
					// if (msg instanceof CompositeMsgNode)
					// {
					// CompositeMsgNode compositeMsg = (CompositeMsgNode) msg;
					// TreeSet compMsgs = new TreeSet(comparator);
					// compositeMsg.getBasicMessages(compMsgs);
					// for (Iterator iter=compMsgs.iterator(); iter.hasNext();)
					// {
					// Message msg1 = (Message) iter.next();
					// thisConnectivityVector.remove(msg1);
					// }
					// }

					/*
					 * internal edges should dissappear in both row and column
					 * of the connectivity matrix
					 */
					// neighbors.remove();
					/* remove message from component */
					// connectivityVector.remove(entry.getKey());
					// connVectorByTarget.remove(entry.getValue());
					/* remove message from composite */
					Message msg1 = (Message) thisConnVectorByTarget.get(msg.getSender());
					if (msg1 != null) {
						thisConnVectorByTarget.remove(msg.getSender());
						thisConnectivityVector.remove(msg1);
					} else {
						msg1 = (Message) thisConnVectorByTarget.get(msg.getReceiver());
						if (msg1 != null) {
							thisConnVectorByTarget.remove(msg.getReceiver());
							thisConnectivityVector.remove(msg1);
						} else {
						}
					}

					// Message msg1 = (Message) thisConnVectorByTarget.get(n);
					// if (msg1 != null)
					// {
					// thisConnVectorByTarget.remove(n);
					// thisConnectivityVector.remove(msg1);
					// }
					// else
					// debugArea.append("cannot remove
					// msg("+senderID+","+receiverID+")\n");
				} else if (entry.getValue().equals(this)) {
//					Message msg2 = (Message) entry.getKey();
//					CouplerElement eSender = (CouplerElement) msg2.getSender();
//					CouplerElement eReceiver = (CouplerElement) msg2
//							.getReceiver();
//					String senderID = (eSender == null ? "composite:"
//							+ Integer.toString(msg2.getSender().hashCode())
//							: eSender.getClass().getName() + ":"
//									+ Integer.toString(eSender.ID().hashCode()));
//					String receiverID = (eReceiver == null ? "composite:"
//							+ Integer.toString(msg2.getReceiver().hashCode())
//							: eReceiver.getClass().getName()
//									+ ":"
//									+ Integer.toString(eReceiver.ID()
//											.hashCode()));

					System.out.println("************************");
					System.out.println("* (2) removing msg(" + /* senderID + */ "," + /* receiverID + */ ")*");
					System.out.println("************************");
					/* remove message from component */
					connectivityVector.remove(entry.getKey());
					connVectorByTarget.remove(entry.getValue());

					/* remove message from composite */
					Message msg1 = (Message) thisConnVectorByTarget.get(n);
					if (msg1 != null) {
						thisConnVectorByTarget.remove(n);
						thisConnectivityVector.remove(msg1);
					}
				} else {
					Message msg = (Message) entry.getKey();
					JOptionPane.showMessageDialog(null,
							" msg(" + msg.getSender().toString() + "," + msg.getReceiver().toString() + ")");
				}
			}

			/*
			 * add any pending additions. This pending additions already have
			 * merged messages
			 */
			for (Iterator iter = pendingAdditions.entrySet().iterator(); iter.hasNext();) {
				Map.Entry entry = (Map.Entry) iter.next();
				Message msg = (Message) entry.getKey();

				if (!containsComponent(msg.getSender()) || !containsComponent(msg.getReceiver())) {
					thisConnectivityVector.put(entry.getKey(), entry.getValue());
				}
			}
			// thisConnectivityVector.putAll(pendingAdditions);
			for (Iterator iter = pendingAdditionsByTarget.entrySet().iterator(); iter.hasNext();) {
				Map.Entry entry = (Map.Entry) iter.next();
				Message msg = (Message) entry.getValue();
				if (!containsComponent(msg.getSender()) || !containsComponent(msg.getReceiver())) {
					thisConnVectorByTarget.put(entry.getKey(), entry.getValue());
				}
			}
			// thisConnVectorByTarget.putAll(pendingAdditionsByTarget);

		}

		/*
		 * alway add back the connectivity vector of 'this' because modifying
		 * 'this' (adding components) has being as a cause of not keeping the
		 * correct mapping in the connectivityMatrix
		 */
		connectivityMatrix.put(this, thisConnectivityVector);
		softConnectivityByTarget.put(this, thisConnVectorByTarget);

		/*
		 * int i=0; totalMsgBandwidth = 0.0; for (Object[] neig =
		 * thisConnectivityVector.entrySet().toArray(); i < neig.length; i++) {
		 * Map.Entry entry = (Map.Entry) neig[i]; Message msg = (Message)
		 * entry.getKey(); totalMsgBandwidth += msg.getBandwidth(); }
		 */
		bandwidthCompressionFactor = totalMsgBandwidth / totalBandwidth;
	}

	public CompositeSoftNode(Comparator bwComparator, Comparator outDComparator) {
		super();
		if (bwComparator == null || outDComparator == null) {
			throw new IllegalArgumentException("comparator == null");
		}
		this.comparator = bwComparator;
		components = new TreeSet(comparator);
		outDegreeComparator = outDComparator;
		componentsByOutDegree = new TreeSet(outDegreeComparator);
		name = ":";
	}

	public CompositeSoftNode(Comparator comp) {
		super();
		if (comp == null) {
			throw new IllegalArgumentException("comparator == null");
		}
		this.comparator = comp;
		components = new TreeSet(comparator);
		outDegreeComparator = new OutDegreeComparator();
		componentsByOutDegree = new TreeSet(outDegreeComparator);
		name = ":";
	}

	public void getSoftwareNodes(Vector v) {
		for (Iterator iter = components.iterator(); iter.hasNext();) {
			SoftwareNode n = (SoftwareNode) iter.next();
			if (n instanceof CompositeSoftNode)
				((CompositeSoftNode) n).getSoftwareNodes(v);
			else
				v.add(n);
		}
	}

	public String componentsToString() {
		String temp = "";

		for (Iterator iter = components.iterator(); iter.hasNext();) {
			SoftwareNode n = (SoftwareNode) iter.next();
			if (n instanceof CompositeSoftNode)
				temp += "[" + ((CompositeSoftNode) n).componentsToString() + "]";
			else
				temp += ":" + n.name;
		}
		return temp;
	}
}
