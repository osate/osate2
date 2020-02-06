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

import java.math.BigInteger;
import java.util.Comparator;
import java.util.TreeMap;

public class SoftwareNode implements FixedPriorityProcessingLoad, Cloneable, BandwidthCompressor {
	static long nextUniqueID = 0;

	long uniqueID = 0;

	public long getUniqueID() {
		return uniqueID;
	}

	double bandwidthCompressionFactor = 0.0;

	public double getBandwidthCompressionFactor() {
		return bandwidthOutDegree / getBandwidth();
	}

	double bandwidthOutDegree = 0.0;

	/**
	 * @return the total communication bandwidth of this module with all its
	 *         neighbors in bits per second
	 */
	public double getBandwidthOutDegree() {
		return bandwidthOutDegree;
	}

	public void addBandwidthOutDegree(double br) {
		bandwidthOutDegree += br;
	}

	public void removeBandwidthOutDegree(double br) {
		bandwidthOutDegree -= br;
	}

	Object semanticObject = null;

	public void setSemanticObject(Object o) {
		semanticObject = o;
	}

	public Object getSemanticObject() {
		return semanticObject;
	}

	public HardwareNode deployedTo = null;

	public void setDeployedTo(HardwareNode n) {
		deployedTo = n;
	}

	public HardwareNode getDeployedTo() {
		return deployedTo;
	}

	public boolean deployed() {
		return (deployedTo != null);
	}

	/**
	 * In nanoseconds
	 */
	protected long period;

	public long getPeriod() {
		return period;
	}

	/**
	 * Either bits or cycles
	 */
	protected long cycles;

	protected long cyclesPerSecond = 0;

	public long getCyclesPerSecond() {
		return cyclesPerSecond;
	}

	public long getCycles() {
		return cycles;
	}

	/**
	 * return the required bandwidth in cycles/second
	 */
	public double getBandwidth() {
		return (double) cycles / ((double) period / 1000000000.0);
	}

	/**
	 * Nanoseconds relative to the start of the period
	 */
	protected long deadline;

	public long getDeadline() {
		return deadline;
	}

	/**
	 * The messages send/receive by this software node. Ordered by messages
	 * bandwidth requirement. This uses the message as an index with the
	 * SoftwareNodes as the values.
	 */

	protected TreeMap messages;

	public TreeMap getMessages() {
		return messages;
	}

	public Comparator comparator;

	public String name = "";

	public void setName(String s) {
		name = s;
	}

	public String getName() {
		return name;
	}

	public SoftwareNode() {
		uniqueID = ++nextUniqueID;
	}

	public Object clone() {
		SoftwareNode n = null;
		try {
			n = (SoftwareNode) getClass().newInstance();
			n.cycles = cycles;
			n.period = period;
			n.deadline = deadline;
			n.deployedTo = deployedTo;
			if (messages != null)
				n.messages = (TreeMap) messages.clone();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;
	}

	public SoftwareNode(long cycles, long period, long deadline) {
		this();
		this.cycles = cycles;
		if (period == 0) {
			period = 1;
		}
		this.period = period;
		this.deadline = deadline;
		BigInteger bi = new BigInteger("0");
		BigInteger giga = new BigInteger("1000000000");
		BigInteger bigCycles = new BigInteger(Long.toString(cycles));
		BigInteger bigPeriod = new BigInteger(Long.toString(period));
		bi = bi.add(bigCycles);
		bi = bi.multiply(giga);
		bi = bi.divide(bigPeriod);
		cyclesPerSecond = bi.longValue();
	}

	public SoftwareNode(long cycles, long period, long deadline, String name) {
		this(cycles, period, deadline);
		this.name = name;
	}

	public SoftwareNode(long cycles, long period, long deadline, Comparator messageComparator) {
		this(cycles, period, deadline);
		messages = new TreeMap(messageComparator);
	}

	public SoftwareNode(long cycles, long period, long deadline, Comparator messageComparator, String name) {
		this(cycles, period, deadline, messageComparator);
		this.name = name;
	}

	long priority = 0;

	public void setPriority(long priority) {
		this.priority = priority;
	}

	public long getPriority() {
		return priority;
	}
}