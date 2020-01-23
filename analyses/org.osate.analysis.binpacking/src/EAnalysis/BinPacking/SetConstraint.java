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

import java.util.Vector;

/**
 * @author Dionisio de Niz
 * 
 * The SetConstraint is a constrained used to limit the possibilities of
 * assignment from software nodes to hardware nodes. It includes two sets (as
 * vectors) the software set and the hardware set. These sets implies
 * compatibility software to hardware. The hardware set can contain classes,
 * e.g. MPC555.class meaning that any processor of that class would be
 * compatible. For an example see BinPackerTester.SimpleConstrainedTest()
 */
public class SetConstraint extends Constraint implements Cloneable {
	public Vector hardwareMembers = new Vector();

	public SetConstraint() {
	}

	public SetConstraint(Object[] s, Object[] h) {
		if (members == null)
			members = new Vector();

		for (int i = 0; i < s.length; i++) {
			members.add(s[i]);
		}
		for (int i = 0; i < h.length; i++) {
			hardwareMembers.add(h[i]);
		}
	}

	public void addSoftwareMember(Object o) {
		if (!members.contains(o)) {
			members.add(o);
		}
	}

	public void addHardwareMember(Object o) {
		if (!hardwareMembers.contains(o)) {
			hardwareMembers.add(o);
		}
	}

	public boolean isAssignable(SoftwareNode s, HardwareNode h) {
		boolean hardwareMembership = false;
		boolean softwareMembership = false;

		// Does the hardware has membership?
		int hardSize = hardwareMembers.size();
		for (int i = 0; i < hardSize; i++) {
			Object node = hardwareMembers.get(i);
			if (node instanceof Class) {
				Class clazz = (Class) node;
				if (clazz.isInstance(h)) {
					hardwareMembership = true;
					break;
				}
			} else {
				if (node.equals(h)) {
					hardwareMembership = true;
					break;
				}
			}
		}

		int softSize = members.size();
		for (int i = 0; i < softSize; i++) {
			Object node = members.get(i);
			if (node instanceof Class) {
				Class clazz = (Class) node;
				if (clazz.isInstance(s)) {
					softwareMembership = true;
					break;
				}
			} else {
				if (node.equals(s)) {
					softwareMembership = true;
					break;
				}
			}
		}

		return (hardwareMembership && softwareMembership);
	}

	public Object clone() {
		SetConstraint c = new SetConstraint();

		c.members = (Vector) members.clone();
		c.hardwareMembers = (Vector) hardwareMembers.clone();
		return c;
	}
}