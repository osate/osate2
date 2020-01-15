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
import java.util.Comparator;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class AssignmentProblem implements Cloneable {

	BPErrorReporter errorReporter;

	public void setErrorReporter(BPErrorReporter r) {
		errorReporter = r;
	}

	/**
	 * SoftwareNodes set ordered byte non-increasing bandwidth requirement
	 */
	public TreeSet softwareGraph;

	public TreeSet nonDeployableModules;

	/**
	 * Connectivity matrix: each row is indexed by software node object. Each
	 * row contains another TreeMap with (key, value) pairs as (message,
	 * software node) ordered by non-increasing bandwidth requirement.
	 */
	public TreeMap softwareConnectivity;

	/**
	 * This is a matrix (hashtable of hashtables) to address node-to-node
	 * indexing of the messages. This speeds up the lookup of the messages to a
	 * particular target
	 */
	public Hashtable softConnectivityByTarget;

	/**
	 * Hardware nodes ordered byte non-decreasing available bandwidth capacity
	 */
	public TreeSet hardwareGraph;

	/**
	 * Hardware connectivity. Rows indexed byte hardwareNode. Each row contains
	 * another TreeMap with pairs key->value: key in$ link} and value in$
	 * {hardware Node}. These rows are ordered int non-decreasing available
	 * bandwidth capacity
	 */
	public TreeMap hardwareConnectivity;

	/**
	 * The constraints is a set of SoftwareNode groups of two types: jointion
	 * and disjointion. Jointion is the set of SoftwareNodes that must be
	 * deployed together. Disjointion is the set of SoftwareNodes that must be
	 * deployed on different nodes. This set will be indexed by node, i.e., each
	 * node will have a pointer to a set of constraints in which it is involved.
	 * This way each time we try to deploy a node we would be able to check the
	 * constraints.
	 */
	public Hashtable constraints = new Hashtable();

	public Comparator bwComparator;

	public Comparator capComparator;

	public AssignmentProblem() {
	}

	public AssignmentProblem(Comparator bwComparator, Comparator capComparator) {
		if (bwComparator == null || capComparator == null) {
			throw new IllegalArgumentException("Comparators are null");
		}

		hardwareGraph = new TreeSet(capComparator);
		softwareGraph = new TreeSet(bwComparator);
		nonDeployableModules = new TreeSet(bwComparator);
		hardwareConnectivity = new TreeMap(capComparator);
		softwareConnectivity = new TreeMap(bwComparator);
		softConnectivityByTarget = new Hashtable();
		this.bwComparator = bwComparator;
		this.capComparator = capComparator;
	}

	public Object clone() {
		AssignmentProblem p = new AssignmentProblem();
		p.hardwareGraph = (TreeSet) hardwareGraph.clone();
		p.softwareGraph = (TreeSet) softwareGraph.clone();
		p.nonDeployableModules = (TreeSet) nonDeployableModules.clone();
		p.hardwareConnectivity = (TreeMap) hardwareConnectivity.clone();
		p.softwareConnectivity = (TreeMap) softwareConnectivity.clone();
		p.softConnectivityByTarget = (Hashtable) softConnectivityByTarget.clone();
		p.constraints = (Hashtable) constraints.clone();
		p.bwComparator = bwComparator;
		p.capComparator = capComparator;
		return p;
	}

	/**
	 * Add a new constraint to the AssignmentProblem. It will merge
	 * SoftwareNodes as necessary to simplify the search.
	 */
	public void addConstraint(Constraint c) {
		if (c instanceof Joint) {
			System.out.println("Adding a Joint");
			/*
			 * Merge the SoftwareNodes into a single composite to ensure that
			 * they are deployed together
			 */
			CompositeSoftNode compNode = new CompositeSoftNode(bwComparator);
			for (int i = 0; i < c.members.size(); i++) {
				compNode.add((SoftwareNode) c.members.elementAt(i), softwareConnectivity, softConnectivityByTarget);
				softwareGraph.remove(c.members.elementAt(i));
				Vector v = (Vector) constraints.get(c.members.get(i));
				if (v == null) {
					v = new Vector();
					constraints.put(c.members.get(i), v);
				}
				if (v.size() != 0) {
					for (int j = 0; j < v.size(); j++) {
						if (v.get(j) instanceof Joint) {
							Joint joint = (Joint) v.get(j);
							for (int k = 0; k < joint.members.size(); k++) {
								compNode.add((SoftwareNode) joint.members.get(k), softwareConnectivity,
										softConnectivityByTarget);
							}
							softwareGraph.remove(joint.getCompositeNode());
							// TODO do I need to remove the old joint
							// constraint?
						} else if (v.get(j) instanceof Disjoint) {
							((Disjoint) v.get(j)).add(compNode);
						}
					}
				}
				v.add(c);
			}
			compNode.breakable = false;
			softwareGraph.add(compNode);
			((Joint) c).setCompositeNode(compNode);
		} else if (c.members.size() > 0) // Disjoint or Isolation
		{
			System.out.print("Adding a disjoint members [");
			for (int i = 0; i < c.members.size(); i++) {
				SoftwareNode n = (SoftwareNode) c.members.get(i);
				System.out.print(n.getSemanticObject());
			}
			System.out.println("]");
			for (int i = 0; i < c.members.size(); i++) {
				Vector v = (Vector) constraints.get(c.members.get(i));
				System.out.println("\t got constaint Vector v(" + v + ") [0] = "
						+ ((v != null && v.size() > 0) ? v.get(0).toString() : "null"));
				if (v == null) {
					v = new Vector();
					constraints.put(c.members.get(i), v);
				}
				if (v.size() != 0) {
					for (int j = 0; j < v.size(); j++) {
						if (v.get(j) instanceof Joint) {
							System.out.println("\t Recursively adding a Joint to the disjoint");
							c.add(((Joint) v.get(j)).getCompositeNode());
						}
					}
				}
				v.add(c);
			}
		}
	}

	/**
	 * Add the
	 * 
	 * @param link
	 *            to the hardware connectivity matrix
	 */
	public void addLink(Link link) {
		for (Iterator iter = link.getConnectedNodes().iterator(); iter.hasNext();) {
			HardwareNode node = (HardwareNode) iter.next();
			TreeSet connectivitySet = (TreeSet) hardwareConnectivity.remove(node);
			if (connectivitySet == null) {
				connectivitySet = new TreeSet(capComparator);
				// DebugMonitor.println(DebugMonitor.channels[1],"ADDED
				// CONNECTIVITY: LINK("+link.toString()+")
				// PROC("+node.toString()+")");
			}
			if (!connectivitySet.contains(link))
				connectivitySet.add(link);
			hardwareConnectivity.put(node, connectivitySet);
		}
	}

	public void removeLink(Link link) {
		for (Iterator iter = link.getConnectedNodes().iterator(); iter.hasNext();) {
			HardwareNode node = (HardwareNode) iter.next();
			TreeSet connectivitySet = (TreeSet) hardwareConnectivity.remove(node);
			if (connectivitySet != null) {
				connectivitySet.remove(link);
				// if (!connectivitySet.remove(link))
				// DebugMonitor.println(DebugMonitor.channels[1],"WARNING --
				// could not remove link("+link.toString()+") from
				// node("+node.toString()+")");
				hardwareConnectivity.put(node, connectivitySet);
			} else {
				// DebugMonitor.println(DebugMonitor.channels[1],"REMOVE LINK
				// ERROR: LINK("+link.toString()+") PROC("+node.toString()+")
				// w/o connectivity");
			}
		}
	}

	public Link getConnectingLink(HardwareNode n1, HardwareNode n2) {
		TreeSet cs = (TreeSet) hardwareConnectivity.get(n1);
		if (cs == null)
			return null;

		for (Iterator iter = cs.iterator(); iter.hasNext();) {
			Link l = (Link) iter.next();
			if (l.getConnectedNodes().contains(n2))
				return l;
		}
		return null;
	}

	/**
	 * Add the message
	 * 
	 * @param m
	 *            to the software connectivity matrix. FIXME: we should use
	 *            multicast messages similar to links in hardware.
	 */
	public void addMessage(Message m) {
		TreeMap sConnVector = (TreeMap) softwareConnectivity.get(m.getSender());
		Hashtable sConnVectorByTarget = (Hashtable) softConnectivityByTarget.get(m.getSender());
		TreeMap rConnVector = (TreeMap) softwareConnectivity.get(m.getReceiver());
		Hashtable rConnVectorByTarget = (Hashtable) softConnectivityByTarget.get(m.getReceiver());

		if (sConnVector == null) {
			sConnVector = new TreeMap(bwComparator);
			softwareConnectivity.put(m.getSender(), sConnVector);
		}
		if (rConnVector == null) {
			rConnVector = new TreeMap(bwComparator);
			softwareConnectivity.put(m.getReceiver(), rConnVector);
		}
		if (sConnVectorByTarget == null) {
			sConnVectorByTarget = new Hashtable();
			softConnectivityByTarget.put(m.getSender(), sConnVectorByTarget);
		}
		if (rConnVectorByTarget == null) {
			rConnVectorByTarget = new Hashtable();
			softConnectivityByTarget.put(m.getReceiver(), rConnVectorByTarget);
		}
		sConnVector.put(m, m.getReceiver());
		rConnVector.put(m, m.getSender());

		sConnVectorByTarget.put(m.getReceiver(), m);
		rConnVectorByTarget.put(m.getSender(), m);
	}

	/**
	 * get the processors that do not conflict with the module.
	 */
	public TreeSet getValidProcessorsForModule(SoftwareNode n) {
		TreeSet set = null;

		/* check if */
		Vector v = (Vector) constraints.get(n);
		if (v != null) {
			set = (TreeSet) hardwareGraph.clone();
			int vSize = v.size();
			for (int i = 0; i < vSize; i++) {
				Constraint c = (Constraint) v.get(i);
				if (c instanceof SetConstraint) {
					SetConstraint sc = (SetConstraint) c;
					for (Iterator iter = set.iterator(); iter.hasNext();) {
						HardwareNode hn = (HardwareNode) iter.next();
						boolean belongs = false;
						for (int j = 0; j < sc.hardwareMembers.size(); j++) {
							Object o = sc.hardwareMembers.get(j);
							if (o instanceof Class) {
								Class clazz = (Class) o;
								if (clazz.isInstance(hn)) {
									belongs = true;
									break;
								}
							} else {
								if (o.equals(hn)) {
									belongs = true;
									break;
								}
							}
						}
						if (!belongs)
							iter.remove();
					}
				} else if (c instanceof Disjoint) {
					int cSize = c.members.size();
					for (int j = 0; j < cSize; j++) {
						SoftwareNode other = (SoftwareNode) c.members.get(j);
						if (other instanceof CompositeSoftNode) {
							TreeSet basicNodes = ((CompositeSoftNode) other).getBasicComponents();
							for (Iterator iter = basicNodes.iterator(); iter.hasNext();) {
								SoftwareNode elem = (SoftwareNode) iter.next();
								HardwareNode hn = elem.getDeployedTo();
								/* remove where the other is deployed */
								if (hn != null)
									set.remove(hn);
							}
						} else {
							HardwareNode hn = other.getDeployedTo();
							/* remove where the other is deployed */
							if (hn != null)
								set.remove(hn);
						}
					}
				}
			}
			return set;
		}
		return (set != null) ? set : hardwareGraph;
	}

	public int dumpHardwareText(PrintWriter writer, int initialNodeID, int initY, boolean printGraphHeader) {
		int nextNodeID = initialNodeID;
		Hashtable nodeToID = new Hashtable();
		HashSet printedLinks = new HashSet();
		String tabs = "";

		int nodeYposition = initY;
		int nextLinkID = nextNodeID;

		for (Iterator iter = hardwareGraph.iterator(); iter.hasNext();) {
			HardwareNode node = (HardwareNode) iter.next();
			Integer nodeInt = (Integer) nodeToID.get(node);
			if (nodeInt == null) {
				nodeInt = new Integer(nextNodeID++);
				nodeToID.put(node, nodeInt);
			}
			int nodeID = nodeInt.intValue();
			writer.println("node[" + nodeID + "]C(" + node.getAvailableCapacity() + ")");

			TreeSet connSet = (TreeSet) hardwareConnectivity.get(node);
			if (connSet != null)
				for (Iterator links = connSet.iterator(); links.hasNext();) {
					Link link = (Link) links.next();

					/* avoid double printing */
					if (!printedLinks.contains(link)) {
						int linkID = nextLinkID++;
						// printedLinks.add(link);
						writer.println("\t link[" + linkID + "]BW(" + link.getAvailableCapacity() + " bits/s)");

						for (Iterator conNodes = link.getConnectedNodes().iterator(); conNodes.hasNext();) {
							HardwareNode conNode = (HardwareNode) conNodes.next();
							Integer conNodeInteger = (Integer) nodeToID.get(conNode);
							int conNodeID;
							if (conNodeInteger == null) {
								conNodeID = nextNodeID++;
								conNodeInteger = new Integer(conNodeID);
								nodeToID.put(conNode, conNodeInteger);
							}
							conNodeID = ((Integer) nodeToID.get(conNode)).intValue();
							writer.println("\t\t node [" + conNodeID + "]");
						}
					}
				}
		}

		if (printGraphHeader)
			writer.println("]");

		return nextLinkID;
	}

	/**
	 * dumps the hardware graph into a GML stream (e.g. file) and returns the
	 * smallest node id unused.
	 */
	public int dumpHardwareGML(PrintWriter writer, int initialNodeID, int initY, boolean printGraphHeader) {
		int nextNodeID = initialNodeID;
		Hashtable nodeToID = new Hashtable();
		HashSet printedLinks = new HashSet();
		String tabs = "";
		if (printGraphHeader) {
			writer.println("graph[");
			writer.println("directed 0");
		}

		int nodeYposition = initY;
		for (Iterator iter = hardwareGraph.iterator(); iter.hasNext();) {
			HardwareNode node = (HardwareNode) iter.next();
			Integer nodeInt = (Integer) nodeToID.get(node);
			if (nodeInt == null) {
				nodeInt = new Integer(nextNodeID++);
				nodeToID.put(node, nodeInt);
			}
			int nodeID = nodeInt.intValue();

			writer.println("\t node [");
			writer.println("\t\t id " + nodeID);

			String taskList = "";

			for (Iterator iter1 = node.getTaskSet().iterator(); iter1.hasNext();) {
				ProcessingLoad l = (ProcessingLoad) iter1.next();
				taskList += l.getName();
			}

			writer.println("\t\t label \"" + node.name + ":" + taskList + ":" + node.cyclesPerSecond + " cycles/s\"");
			writer.println("\t\t graphics [");
			writer.println("\t\t\t Image [");
			writer.println("\t\t\t\t Type \"URL\"");
			writer.println("\t\t\t\t Location \"\"");
			writer.println("\t\t\t ]");
			writer.println("\t\t\t center [");
			writer.println("\t\t\t\t x 100.0");
			writer.println("\t\t\t\t y " + nodeYposition + ".0");
			nodeYposition += 50;
			writer.println("\t\t\t\t z 0.0");
			writer.println("\t\t\t ]");
			writer.println("\t\t\t width 20.0");
			writer.println("\t\t\t height 20.0");
			writer.println("\t\t\t depth 20.0");
			writer.println("\t\t ]");
			writer.println("\t\t vgj [");
			writer.println("\t\t\t labelPosition \"below\"");
			writer.println("\t\t\t shape \"Rectangle\"");
			writer.println("\t\t ]");
			writer.println("\t ]");
		}

		int nextLinkID = nextNodeID;

		for (Iterator iter = hardwareGraph.iterator(); iter.hasNext();) {
			HardwareNode node = (HardwareNode) iter.next();
			int nodeID = ((Integer) nodeToID.get(node)).intValue();
			TreeSet connSet = (TreeSet) hardwareConnectivity.get(node);
			for (Iterator links = connSet.iterator(); links.hasNext();) {
				Link link = (Link) links.next();

				/* avoid double printing */
				if (!printedLinks.contains(link)) {
					int linkID = nextLinkID++;
					printedLinks.add(link);
					writer.println("\t node [");
					writer.println("\t\t id " + linkID);
					writer.println("\t\t label \"" + link.name + ":" + link.cyclesPerSecond + " bits/s\"");
					writer.println("\t\t graphics [");
					writer.println("\t\t\t Image [");
					writer.println("\t\t\t\t Type \"URL\"");
					writer.println("\t\t\t\t Location \"\"");
					writer.println("\t\t\t ]");
					writer.println("\t\t\t center [");
					writer.println("\t\t\t\t x 100.0");
					writer.println("\t\t\t\t y " + nodeYposition + ".0");
					nodeYposition += 50;
					writer.println("\t\t\t\t z 0.0");
					writer.println("\t\t\t ]");
					writer.println("\t\t\t width 30.0");
					writer.println("\t\t\t height 10.0");
					writer.println("\t\t\t depth 10.0");
					writer.println("\t\t ]");
					writer.println("\t\t vgj [");
					writer.println("\t\t\t labelPosition \"below\"");
					writer.println("\t\t\t shape \"Rectangle\"");
					writer.println("\t\t ]");
					writer.println("\t ]");

					for (Iterator conNodes = link.getConnectedNodes().iterator(); conNodes.hasNext();) {
						HardwareNode conNode = (HardwareNode) conNodes.next();
						int conNodeID = ((Integer) nodeToID.get(conNode)).intValue();
						writer.println("\t edge [");
						writer.println("\t\t linestyle \"solid\"");
						writer.println("\t\t label \"\"");
						writer.println("\t\t source " + linkID);
						writer.println("\t\t target " + conNodeID);
						writer.println("\t ]");
					}
				}
			}
		}

		if (printGraphHeader)
			writer.println("]");

		return nextLinkID;
	}

	/**
	 * dumps the software graph to GML stream (e.g. file) and returns the
	 * smallest node id unused
	 */
	public int dumpSoftwareGML(PrintWriter writer, int initialNodeID, int initY, boolean printGraphHeader) {
		return dumpSoftGraphGML(softwareGraph, writer, initialNodeID, initY, printGraphHeader);
	}

	public int dumpNonDeployableGML(PrintWriter writer, int initialNodeID, int initY, boolean printGraphHeader) {
		return dumpSoftGraphGML(nonDeployableModules, writer, initialNodeID, initY, printGraphHeader);
	}

	public int dumpSoftGraphGML(TreeSet softGraph, PrintWriter writer, int initialNodeID, int initY,
			boolean printGraphHeader) {
		int nextNodeID = initialNodeID;
		Hashtable nodeToID = new Hashtable();
		HashSet printedLinks = new HashSet();

		if (printGraphHeader) {
			writer.println("graph[");
			writer.println("directed 0");
		}

		int nodeYposition = initY;
		for (Iterator iter = softGraph.iterator(); iter.hasNext();) {
			SoftwareNode node = (SoftwareNode) iter.next();
			Integer nodeInt = (Integer) nodeToID.get(node);
			if (nodeInt == null) {
				nodeInt = new Integer(nextNodeID++);
				nodeToID.put(node, nodeInt);
			}
			int nodeID = nodeInt.intValue();

			writer.println("\t node [");
			writer.println("\t\t id " + nodeID);
			writer.println(
					"\t\t label \"" + node.name + ": BW(" + node.getBandwidth() + " cycle/s), C(" + node.getCycles()
							+ " cycles), T(" + node.getPeriod() + " nanos), D(" + node.getDeadline() + " nanos)\"");
			writer.println("\t\t graphics [");
			writer.println("\t\t\t Image [");
			writer.println("\t\t\t\t Type \"URL\"");
			writer.println("\t\t\t\t Location \"\"");
			writer.println("\t\t\t ]");
			writer.println("\t\t\t center [");
			writer.println("\t\t\t\t x 100.0");
			writer.println("\t\t\t\t y " + nodeYposition + ".0");
			nodeYposition += 50;
			writer.println("\t\t\t\t z 0.0");
			writer.println("\t\t\t ]");
			writer.println("\t\t\t width 20.0");
			writer.println("\t\t\t height 20.0");
			writer.println("\t\t\t depth 20.0");
			writer.println("\t\t ]");
			writer.println("\t\t vgj [");
			writer.println("\t\t\t labelPosition \"below\"");
			writer.println("\t\t\t shape \"Oval\"");
			writer.println("\t\t ]");
			writer.println("\t ]");
		}

		Vector printedMessages = new Vector();
		for (Iterator iter = softGraph.iterator(); iter.hasNext();) {
			SoftwareNode node = (SoftwareNode) iter.next();
			int nodeID = ((Integer) nodeToID.get(node)).intValue();
			TreeMap connSet = (TreeMap) softwareConnectivity.get(node);
			if (connSet != null) {
				for (Iterator messages = connSet.keySet().iterator(); messages.hasNext();) {
					Message msg = (Message) messages.next();
					System.out.println("dumping msg(" + node.getName() + "," + msg.getPartner(node).getName() + ")");
					int partnerID = 0;
					try {
						partnerID = ((Integer) nodeToID.get(msg.getPartner(node))).intValue();
					} catch (Exception e) {
						System.out.println(msg.getPartner(node).name);
					}

					String msgID = Integer.toString((nodeID > partnerID) ? nodeID : partnerID)
							+ Integer.toString((nodeID < partnerID) ? nodeID : partnerID);
					if (printedMessages.contains(msgID))
						continue;

					printedMessages.add(msgID);

					writer.println("\t edge [");
					writer.println("\t\t linestyle \"solid\"");
					writer.println("\t\t label \"C(" + msg.getCycles() + "),T(" + msg.getPeriod() + "),D("
							+ msg.getDeadline() + ")\"");
					writer.println("\t\t source " + nodeID);
					writer.println("\t\t target " + partnerID);
					writer.println("\t ]");

				}
			}
		}

		if (printGraphHeader)
			writer.println("]");

		return nextNodeID;
	}

	public int dumpSoftGraphText(TreeSet softGraph, PrintWriter writer, int initialNodeID, int initY,
			boolean printGraphHeader) {
		int nextNodeID = initialNodeID;
		int nextMsgID = 0;
		Hashtable nodeToID = new Hashtable();
		HashSet printedLinks = new HashSet();

		int nodeYposition = initY;

		for (Iterator iter = softGraph.iterator(); iter.hasNext();) {
			SoftwareNode node = (SoftwareNode) iter.next();
			Integer nodeInt = (Integer) nodeToID.get(node);
			if (nodeInt == null) {
				nodeInt = new Integer(nextNodeID++);
				nodeToID.put(node, nodeInt);
			}
			int nodeID = nodeInt.intValue();

			writer.println(" software node(" + node + ") [" + nodeID + ",name(" + node.name + ")]: BW("
					+ node.getBandwidth() + "), C(" + node.getCycles() + "), T(" + node.getPeriod() + "), D("
					+ node.getDeadline() + ")");

			TreeMap connSet = (TreeMap) softwareConnectivity.get(node);
			if (connSet != null) {
				for (Iterator messages = connSet.keySet().iterator(); messages.hasNext();) {
					Message msg = (Message) messages.next();
					SoftwareNode other = msg.getPartner(node);
					int partnerID = 0;
					Integer partnerInteger;
					if (msg.getPartner(node) != null) {
						partnerInteger = (Integer) ((msg.getPartner(node) == null) ? null
								: nodeToID.get(msg.getPartner(node)));
						if (partnerInteger == null) {
							partnerID = nextNodeID++;
							partnerInteger = new Integer(partnerID);
							nodeToID.put(msg.getPartner(node), partnerInteger);
						}

						writer.println("\t msg C(" + msg.getCycles() + "),T(" + msg.getPeriod() + "),D("
								+ msg.getDeadline() + ") BW(" + msg.getBandwidth() + ")");
						writer.println("\t\t target " + other.name); // partnerID);
					}
				}
			}
		}
		return nextNodeID;
	}
}
