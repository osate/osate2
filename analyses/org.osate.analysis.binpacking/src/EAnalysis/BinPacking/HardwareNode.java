/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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

import java.util.TreeSet;

/**
 * @since 3.0
 */
public class HardwareNode implements CapacityProvider, SiteGuest {

	static long nextUniqueID = 0;

	long uniqueID = 0;

	public long getUniqueID() {
		return uniqueID;
	}

	Object semanticObject = null;

	public void setSemanticObject(Object o) {
		semanticObject = o;
	}

	public Object getSemanticObject() {
		return semanticObject;
	}

	/**
	 * in watts
	 */
	private double powerRequirement = 0.0;

	@Override
	public double getPowerRequirement() {
		return powerRequirement;
	}

	/**
	 * in square centimeters
	 */
	private double spaceRequirement = 0.0;

	@Override
	public double getSpaceRequirement() {
		return spaceRequirement;
	}

	Location hostSite = null;

	@Override
	public void setHost(Location l) {
		hostSite = l;
	}

	public Location getHost() {
		return hostSite;
	}

	private String name;

	/**
	 * Speed: either cycles per second or bits per second.
	 */
	private double cyclesPerSecond = 0.0;

	/**
	 * cycles per second.
	 */

	@Override
	public double getAvailableCapacity() {
		return (scheduler.getAvailableCapacity() * getCyclesPerSecond());
	}

	protected Scheduler scheduler;

	public static void cloneTo(HardwareNode from, HardwareNode to) {
		try {
			to.scheduler = from.scheduler.getClass().newInstance();
			to.scheduler.cloneTo(from.scheduler, to.scheduler);
			to.scheduler.setHardwareNode(to);
			to.setCyclesPerSecond(from.getCyclesPerSecond());
			to.setName(from.getName());
			to.setPowerRequirement(from.getPowerRequirement());
			to.setSpaceRequirement(from.getSpaceRequirement());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HardwareNode() {
		uniqueID = ++nextUniqueID;
	}

	public HardwareNode(Scheduler s, double cyclesPerSec) {
		this();
		scheduler = s;
		s.setHardwareNode(this);
		setCyclesPerSecond(cyclesPerSec);
	}

	public HardwareNode(String n, Scheduler s, double c) {
		this(s, c);
		setName(n);
	}

	public TreeSet getTaskSet() {
		return scheduler.getTaskSet();
	}

	public boolean addIfFeasible(ProcessingLoad sNode) {
		/* check to see if it fits */

		boolean b = scheduler.addIfFeasible(sNode);
		// if (b && sNode instanceof SoftwareNode )
		// BinPackerTester.progress += ( sNode instanceof CompositeSoftNode) ?
		// ((CompositeSoftNode)sNode).getBasicComponents().size() : 1;
		return b;
	}

	public void removeFromFeasibleSet(ProcessingLoad sNode) {
		scheduler.removeFromFeasibleSet(sNode);
	}

	public boolean canAddToFeasibility(ProcessingLoad sNode) {
		return scheduler.canAddToFeasibility(sNode);
	}

	public boolean canReplace(HardwareNode other) {
		/* compatibles */
		if (other.getClass().isAssignableFrom(getClass()) || getClass().isAssignableFrom(other.getClass())) {
			Scheduler sched = (Scheduler) ((BaseScheduler) other.scheduler).clone();
			sched.setHardwareNode(this);
			if (sched.isSchedulable(other.getTaskSet())) {
				return true;
			}
		}
		return false;
	}

	public double getCyclesPerSecond() {
		return cyclesPerSecond;
	}

	/**
	 * @since 3.0
	 */
	public void setPowerRequirement(double powerRequirement) {
		this.powerRequirement = powerRequirement;
	}

	/**
	 * @since 3.0
	 */
	public void setSpaceRequirement(double spaceRequirement) {
		this.spaceRequirement = spaceRequirement;
	}

	/**
	 * @since 3.0
	 */
	public String getName() {
		return name;
	}

	/**
	 * @since 3.0
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @since 3.0
	 */
	public void setCyclesPerSecond(double cyclesPerSecond) {
		this.cyclesPerSecond = cyclesPerSecond;
	}

}
