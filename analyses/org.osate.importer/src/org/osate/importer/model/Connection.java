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

package org.osate.importer.model;

public class Connection {
	String content;
	Component source;
	Component destination;

	public Connection(String c, Component s, Component d) {
		this.content = c;
		this.source = s;
		this.destination = d;
	}

	public Connection(Component s, Component d) {
		this("1", s, d);
	}

	public Connection(Component s, Component d, int st) {

		this(new String("" + st), s, d);
	}

	public Component getSource() {
		return this.source;
	}

	public Component getDestination() {
		return this.destination;
	}

	public String getContent() {
		return this.content;
	}

	public void setSource(Component s) {
		this.source = s;
	}

	public void setDestination(Component d) {
		this.destination = d;
	}

	public String toString() {
		String r;
		r = "Connection value=" + this.content;
		if (this.source != null) {
			r += " (src=" + this.source + ") ";
		}
		if (this.destination != null) {
			r += " (dst=" + this.destination + ") ";
		}
		return r;
	}
}
