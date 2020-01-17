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
package org.osate.importer.model.sm;

import org.osate.importer.Utils;

public class Transition {
	private String name;
	private State srcState;
	private State dstState;
	private int identifier;
	private int srcStateIdentifier;
	private int dstStateIdentifier;
	private String condition;
	private String action;

	public Transition() {
		this.name = null;
		this.identifier = Utils.INVALID_ID;
		this.srcState = null;
		this.dstState = null;
		this.srcStateIdentifier = Utils.INVALID_ID;
		this.dstStateIdentifier = Utils.INVALID_ID;
		this.condition = "";
		this.action = "";
	}

	public String getCondition() {
		return this.condition;
	}

	public void setCondition(String s) {
		this.condition = s;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String a) {
		this.action = a;
	}

	public int getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(int i) {
		this.identifier = i;
	}

	public void setSrcStateIdentifier(int id) {
		this.srcStateIdentifier = id;
	}

	public void setDstStateIdentifier(int id) {
		this.dstStateIdentifier = id;
	}

	public int getDstStateIdentifier() {
		return this.dstStateIdentifier;
	}

	public int getSrcStateIdentifier() {
		return this.srcStateIdentifier;
	}

	public void setSrcState(State src) {
		this.srcState = src;
	}

	public void setDstState(State dst) {
		this.dstState = dst;
	}

	public State getDstState() {
		return (this.dstState);
	}

	public State getSrcState() {
		return (this.srcState);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String n) {
		String s = n.replace('\n', '_');
		this.name = s;
	}

	public String toString() {
		String res;
		res = "";

		if (this.name != null) {
			res += "name=" + name;
		}

		if (this.identifier != Utils.INVALID_ID) {
			res += "|id=" + this.identifier;
		}

		if (this.srcState != null) {
			res += "|src state name=" + this.srcState.getName();
		}

		if (this.dstState != null) {
			res += "|dst state name=" + this.dstState.getName();
		}

		return res;
	}
}
