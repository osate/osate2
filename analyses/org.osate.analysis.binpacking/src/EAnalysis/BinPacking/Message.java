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

public class Message extends SoftwareNode implements Cloneable {
	protected SoftwareNode sender;

	protected SoftwareNode receiver;

	public Message() {
		super();
	}

	public Message(SoftwareNode s, SoftwareNode r) {
		this();
		sender = s;
		receiver = r;
		if (sender == null || receiver == null) {
			double i = s.getBandwidth() + r.getBandwidth();
		}
	}

	public Message(SoftwareNode s, SoftwareNode r, String name) {
		this(s, r);
		this.name = name;
	}

	public Message(long cycles, long period, long deadline, SoftwareNode s, SoftwareNode r) {
		super(cycles, period, deadline);
		sender = s;
		receiver = r;
		if (sender == null || receiver == null) {
			double i = s.getBandwidth() + r.getBandwidth();
		}
	}

	public Message(long cycles, long period, long deadline, SoftwareNode s, SoftwareNode r, String name) {
		this(cycles, period, deadline, s, r);
		this.name = name;
	}

	/**
	 * Returns the partner of
	 * 
	 * @param self
	 */
	public SoftwareNode getPartner(SoftwareNode self) {
		return (self.equals(sender) ? receiver : sender);
	}

	/**
	 * Set the partner of
	 * 
	 * @param self
	 *            to
	 * @param p
	 */
	public void setPartner(SoftwareNode self, SoftwareNode p) {
		if (self == null || p == null) {
			double d = self.getBandwidth() + p.getBandwidth();
		}
		if (self.equals(sender))
			receiver = p;
		else
			sender = p;
	}

	public SoftwareNode getSender() {
		return sender;
	}

	public void setSender(SoftwareNode n) {
		if (n == null) {
			double d = n.getBandwidth();
		}
		sender = n;
	}

	public SoftwareNode getReceiver() {
		return receiver;
	}

	public void setReceiver(SoftwareNode n) {
		if (n == null) {
			double d = n.getBandwidth();
		}
		receiver = n;
	}

	public Object clone() {
		Message m = (Message) super.clone();
		m.sender = sender;
		m.receiver = receiver;
		return m;
	}
}