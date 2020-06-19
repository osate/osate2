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
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class OutDegreeAssignmentProblem extends AssignmentProblem {
	public SiteArchitecture siteArchitecture;

	public TreeSet orderedModulesByOutDegree;

	Comparator outDegreeComparator;

	public OutDegreeAssignmentProblem() {
	}

	public OutDegreeAssignmentProblem(Comparator outDegreeComparator, Comparator bwComparator,
			Comparator capComparator) {
		super(bwComparator, capComparator);
		this.outDegreeComparator = outDegreeComparator;
		orderedModulesByOutDegree = new TreeSet(outDegreeComparator);
	}

	public Object clone() {
		OutDegreeAssignmentProblem p = new OutDegreeAssignmentProblem();
		p.siteArchitecture = (SiteArchitecture) siteArchitecture.clone();
		// BinPackerTester.showSiteArchitecture(p.siteArchitecture);
		p.hardwareGraph = (TreeSet) hardwareGraph.clone();
		p.softwareGraph = new TreeSet(softwareGraph.comparator());
		p.orderedModulesByOutDegree = new TreeSet(orderedModulesByOutDegree.comparator());
		p.nonDeployableModules = (TreeSet) nonDeployableModules.clone();
		p.hardwareConnectivity = (TreeMap) hardwareConnectivity.clone();
		p.softwareConnectivity = new TreeMap(softwareConnectivity.comparator());
		p.softConnectivityByTarget = new Hashtable();
		p.constraints = (Hashtable) constraints.clone();
		p.bwComparator = bwComparator;
		p.capComparator = capComparator;
		p.outDegreeComparator = outDegreeComparator;

		System.out.println("Cloning modules...");
		// clone software modules
		Hashtable originalToClone = new Hashtable();
		for (Iterator iter = softwareGraph.iterator(); iter.hasNext();) {
			SoftwareNode n = (SoftwareNode) iter.next();
			SoftwareNode clone = (SoftwareNode) n.clone();
			originalToClone.put(n, clone);
			p.softwareGraph.add(clone);
			p.orderedModulesByOutDegree.add(clone);
		}

		Vector processedMessages = new Vector();

		System.out.println("Cloning messages...");
		int moduleCount = 0;
		for (Iterator iter = softwareGraph.iterator(); iter.hasNext();) {
			moduleCount++;
			SoftwareNode n = (SoftwareNode) iter.next();
			SoftwareNode clone = (SoftwareNode) originalToClone.get(n);
			TreeMap connVector = (TreeMap) softwareConnectivity.get(n);
			if (connVector != null) {
				TreeMap clonedConnVector = (TreeMap) p.softwareConnectivity.remove(clone);
				if (clonedConnVector == null) {
					clonedConnVector = new TreeMap(connVector.comparator());
				}
				int msgCount = 0;
				for (Iterator msgMaps = connVector.entrySet().iterator(); msgMaps.hasNext();) {
					msgCount++;
					// System.out.print(moduleCount+":"+msgCount+"\r");
					Map.Entry entry = (Map.Entry) msgMaps.next();
					Message msg = (Message) entry.getKey();
					SoftwareNode partner = (SoftwareNode) entry.getValue();
					SoftwareNode clonedPartner = (SoftwareNode) originalToClone.get(partner);
					if (partner == null || clonedPartner == null)
						continue;
					if (processedMessages
							.contains(Integer.toString(clone.hashCode()) + Integer.toString(clonedPartner.hashCode()))
							|| processedMessages.contains(
									Integer.toString(clonedPartner.hashCode()) + Integer.toString(clone.hashCode())))
						continue;

					processedMessages
							.add(Integer.toString(clone.hashCode()) + Integer.toString(clonedPartner.hashCode()));
					Message clonedMsg = new Message(msg.cycles, msg.period, msg.deadline, clone, clonedPartner);
					clonedConnVector.put(msg, clonedPartner);
					TreeMap clonedPartnerConn = (TreeMap) p.softwareConnectivity.remove(clonedPartner);
					if (clonedPartnerConn == null)
						clonedPartnerConn = new TreeMap(connVector.comparator());
					clonedPartnerConn.put(msg, clone);
					p.softwareConnectivity.put(clonedPartner, clonedPartnerConn);
				}
				p.softwareConnectivity.put(clone, clonedConnVector);
			}
		}

		return p;
	}

	public void addConstraint(Constraint c) {
		if (c instanceof SetConstraint) {
			for (int i = 0; i < c.members.size(); i++) {
				SoftwareNode n = (SoftwareNode) c.members.get(i);
				Vector v = (Vector) constraints.get(n);
				if (v == null) {
					v = new Vector();
					constraints.put(n, v);
				}
				v.add(c);
			}
		} else if (c instanceof Joint) {
			System.out.println("Adding a joint");
			CompositeSoftNode compNode = new CompositeSoftNode(bwComparator);
			for (int i = 0; i < c.members.size(); i++) {
				compNode.add((SoftwareNode) c.members.elementAt(i), softwareConnectivity, softConnectivityByTarget);
				softwareGraph.remove(c.members.elementAt(i));
				orderedModulesByOutDegree.remove(c.members.elementAt(i));
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
			orderedModulesByOutDegree.add(compNode);
			((Joint) c).setCompositeNode(compNode);
		} else
			super.addConstraint(c);
	}

	public void addMessage(Message m) {
		super.addMessage(m);
		orderedModulesByOutDegree.remove(m.getSender());
		orderedModulesByOutDegree.remove(m.getReceiver());

		m.getSender().addBandwidthOutDegree(m.getBandwidth());
		m.getReceiver().addBandwidthOutDegree(m.getBandwidth());

		orderedModulesByOutDegree.add(m.getSender());
		orderedModulesByOutDegree.add(m.getReceiver());
	}

	public void addSoftwareNode(SoftwareNode n) {
		if (!softwareGraph.add(n))
			System.out.println(this + ".addSoftwareNode(" + n + "): Failed ARGGG! ");
		orderedModulesByOutDegree.add(n);
	}

	public void removeSoftwareNode(SoftwareNode n) {
		softwareGraph.remove(n);
		orderedModulesByOutDegree.remove(n);
	}
}