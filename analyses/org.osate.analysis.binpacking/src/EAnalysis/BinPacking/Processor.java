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

import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Vector;

/**
 * @author Dionisio de Niz
 */
public class Processor extends HardwareNode {
	public static Hashtable creationTraces = new Hashtable();

	public static Vector traces = new Vector();

	/**
	 * ordered by decreasing order of capacity
	 */
	public TreeSet netInterfaces = new TreeSet(new CapacityComparator());

	public TreeSet classNetInterfaces = new TreeSet(new CapacityComparator());

	public void attachToLink(Link l) {
		// try{throw new Exception();}catch(Exception e)
		// {
		// StackTraceElement[] el = e.getStackTrace();
		// String s="--- TRACE ---\n";
		// for (int i=0;i<el.length;i++)
		// s += el[i].toString()+"\n";
		// s+="-----------";
		// if (!traces.contains(s)) traces.add(s);
		// }

		for (Iterator iter = netInterfaces.iterator(); iter.hasNext();) {
			NetInterface nic = (NetInterface) iter.next();
			// if already attached don't do anything
			if (nic.link.equals(l))
				return;
		}

		for (Iterator iter = classNetInterfaces.iterator(); iter.hasNext();) {
			NetInterface nic = (NetInterface) iter.next();
			if (nic.link.getClass().isAssignableFrom(l.getClass())
					|| l.getClass().isAssignableFrom(nic.link.getClass())) {
				// iter.remove();
				NetInterface nicClone = (NetInterface) nic.clone();
				netInterfaces.add(nicClone);
				nicClone.connectTo(l);
				break;
			}
		}
	}

	public void replaceLink(Link oldLink, Link newLink) {
		for (Iterator iter = netInterfaces.iterator(); iter.hasNext();) {
			NetInterface nic = (NetInterface) iter.next();

			if (nic.link.equals(oldLink)) {
				nic.connectTo(newLink);
				break;
			}
		}
	}

	public static void cloneTo(Processor from, Processor to) {
		HardwareNode.cloneTo(from, to);
		// DebugMonitor.println(DebugMonitor.channels[4],
		// "proc("+to.toString()+") clonning:");
		for (Iterator iter = from.classNetInterfaces.iterator(); iter.hasNext();) {
			NetInterface n = (NetInterface) iter.next();
			to.classNetInterfaces.add(n.clone());
			// DebugMonitor.println(DebugMonitor.channels[4], "\t
			// link("+n.link.toString()+")");
		}
		for (Iterator iter = from.netInterfaces.iterator(); iter.hasNext();) {
			NetInterface n = (NetInterface) iter.next();
			to.classNetInterfaces.add(n.clone());
			// DebugMonitor.println(DebugMonitor.channels[4], "\t
			// link("+n.link.toString()+")");
		}
	}

	public Processor() {
		super();
		try {
			throw new Exception();
		} catch (Exception e) {
			StackTraceElement[] trace = e.getStackTrace();
			String s = "";
			for (int i = 0; i < trace.length; i++)
				s += trace[i].toString() + "\n";

			creationTraces.put(this, s);
		}
	}

	public Processor(String name, Scheduler s, double cyclesPerSec) {
		super(name, s, cyclesPerSec);
	}

	/**
	 * The constructor without parameters should be used to define the
	 * interfaces of this type of hardware.
	 */
	public Processor(Scheduler s, double cyclesPerSec) {
		this("", s, cyclesPerSec);
	}

	public Processor(String name, Scheduler s, double cyclesPerSec, NetInterface[] netInterfaces) {
		this(name, s, cyclesPerSec);
		for (int i = 0; i < netInterfaces.length; i++)
			classNetInterfaces.add(netInterfaces[i]);
	}

	/**
	 * All subclasses should also implement this constructor to ensure that it
	 * can be subtyped adding net interfaces the first line of this constructor
	 * should call super() to instantiate the interfaces defined in the
	 * constructor without parameters
	 */
	public Processor(Scheduler s, double cyclesPerSec, NetInterface[] netInterfaces) {
		this(s, cyclesPerSec);
		for (int i = 0; i < netInterfaces.length; i++)
			classNetInterfaces.add(netInterfaces[i]);
	}

	public boolean canTalkTo(Processor other) {
		for (Iterator iter = netInterfaces.iterator(); iter.hasNext();) {
			NetInterface myNetInterface = (NetInterface) iter.next();
			for (Iterator oIter = other.netInterfaces.iterator(); oIter.hasNext();) {
				NetInterface otherNetInterface = (NetInterface) iter.next();
				if (otherNetInterface.link.getClass().isAssignableFrom(myNetInterface.link.getClass())
						|| myNetInterface.link.getClass().isAssignableFrom(otherNetInterface.link.getClass()))
					return true;
			}
		}
		return false;
	}

	/**
	 * test based on the potential net interfaces that can be instantiated
	 */
	public boolean couldTalkTo(Processor other) {
		for (Iterator iter = classNetInterfaces.iterator(); iter.hasNext();) {
			NetInterface myNetInterface = (NetInterface) iter.next();
			for (Iterator oIter = other.classNetInterfaces.iterator(); oIter.hasNext();) {
				NetInterface otherNetInterface = (NetInterface) iter.next();
				if (otherNetInterface.link.getClass().isAssignableFrom(myNetInterface.link.getClass())
						|| myNetInterface.link.getClass().isAssignableFrom(otherNetInterface.link.getClass()))
					return true;
			}
		}
		return false;
	}

	public boolean couldReplaceLink(Link newLink, Link oldLink) {
		for (Iterator iter = classNetInterfaces.iterator(); iter.hasNext();) {
			NetInterface myNetInterface = (NetInterface) iter.next();
			if (myNetInterface.link.getClass().isAssignableFrom(newLink.getClass())
					|| newLink.getClass().isAssignableFrom(myNetInterface.link.getClass()))
				return true;
			else {
				// DebugMonitor.println(DebugMonitor.channels[4], "\t\t NOT
				// COMPATIBLE WITH LINK("+myNetInterface.link.toString()+")");
			}
		}
		for (Iterator iter = netInterfaces.iterator(); iter.hasNext();) {
			NetInterface myNetInterface = (NetInterface) iter.next();
			if (oldLink.equals(myNetInterface.link)) {
				if (myNetInterface.link.getClass().isAssignableFrom(newLink.getClass())
						|| newLink.getClass().isAssignableFrom(myNetInterface.link.getClass()))
					return true;
				else {
					// DebugMonitor.println(DebugMonitor.channels[4], "\t\t NOT
					// COMPATIBLE WITH
					// LINK("+myNetInterface.link.toString()+")");
				}
			}
		}
		return false;
	}

	/**
	 * links already instantiated ordered in decreasing bandwidth capacity
	 */
	public TreeSet getCommonLinks(Processor other) {
		TreeSet commonLinks = new TreeSet(new CapacityComparator());

		for (Iterator iter = netInterfaces.iterator(); iter.hasNext();) {
			NetInterface myNetInterface = (NetInterface) iter.next();
			for (Iterator oIter = other.netInterfaces.iterator(); oIter.hasNext();) {
				NetInterface otherNetInterface = (NetInterface) iter.next();
				if (otherNetInterface.link.getClass().isAssignableFrom(myNetInterface.link.getClass())
						|| myNetInterface.link.getClass().isAssignableFrom(otherNetInterface.link.getClass())) {
					commonLinks.add(myNetInterface.link);
				}
			}
		}
		return commonLinks;
	}

	/**
	 * links that can potentially be instantiated (including the already
	 * instantiated ones) ordered in decreasing bandwidth capacity
	 */
	public TreeSet getCommonLinkTypes(Processor other) {
		TreeSet commonLinks = new TreeSet(new DecreasingCapacityComparator());
		// System.out.println("this("+this+").Interface.size("+classNetInterfaces.size()+
		// ")
		// other("+other+").Interfaces.size("+other.classNetInterfaces.size()+")");
		for (Iterator iter = classNetInterfaces.iterator(); iter.hasNext();) {
			NetInterface myNetInterface = (NetInterface) iter.next();
			// System.out.println("myLink("+myNetInterface.link+")");
			for (Iterator oIter = other.classNetInterfaces.iterator(); oIter.hasNext();) {
				NetInterface otherNetInterface = (NetInterface) oIter.next();
				// System.out.println("\t
				// otherLink("+otherNetInterface.link+")");
				if (otherNetInterface.link.getClass().isAssignableFrom(myNetInterface.link.getClass())
						|| myNetInterface.link.getClass().isAssignableFrom(otherNetInterface.link.getClass())) {
					commonLinks.add(myNetInterface.link);
				}
			}
		}
		return commonLinks;
	}

	public Link getLargestCommonLinkType(Processor other) {
		for (Iterator iter = classNetInterfaces.iterator(); iter.hasNext();) {
			NetInterface myNetInterface = (NetInterface) iter.next();
			for (Iterator oIter = other.classNetInterfaces.iterator(); oIter.hasNext();) {
				NetInterface otherNetInterface = (NetInterface) iter.next();
				if (otherNetInterface.link.getClass().isAssignableFrom(myNetInterface.link.getClass())
						|| myNetInterface.link.getClass().isAssignableFrom(otherNetInterface.link.getClass())) {
					return myNetInterface.link;
				}
			}
		}
		return null;
	}
}