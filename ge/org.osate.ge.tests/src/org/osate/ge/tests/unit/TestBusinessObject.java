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
package org.osate.ge.tests.unit;

import org.osate.ge.DockingPosition;
import org.osate.ge.graphics.Point;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;

// Class used for test business objects. Allowed to contain children or have a value specified but not both.
public class TestBusinessObject {
	public final int value;
	public final TestBusinessObject[] children;
	public boolean isConnection = false;
	public RelativeBusinessObjectReference connectionStartReference; // Reference to sibling which is the start of the connection
	public RelativeBusinessObjectReference connectionEndReference; // Reference to sibling which is the end of the connection
	public DockingPosition defaultDockingPosition = DockingPosition.NOT_DOCKABLE;
	
	public TestBusinessObject(final int value) {
		this.value = value;
		this.children = new TestBusinessObject[0];
	}
	
	public TestBusinessObject(final TestBusinessObject[] children) {
		this.value = -1;
		this.children = children;
	}

	public RelativeBusinessObjectReference getRelativeReference() {
		return new RelativeBusinessObjectReference("test_relative", Integer.toString(value), Integer.toString(children.length));
	}

	public Point getTestPosition() {
		return new Point(value, children.length);
	}	
	
	public void makeConnection(final TestBusinessObject startSiblingBo, final TestBusinessObject endSiblingBo) {
		this.isConnection = true;
		connectionStartReference = startSiblingBo == null ? null : startSiblingBo.getRelativeReference();
		connectionEndReference = endSiblingBo == null ? null : endSiblingBo.getRelativeReference();
	}
	
	@Override
	public String toString() {
		return getRelativeReference().toString();
	}
	
	// Helper method to reduce code length
	public static TestBusinessObject newBO(final int v) {
		return new TestBusinessObject(v);
	}
	
	public static TestBusinessObject newBO(final TestBusinessObject... args) {
		return new TestBusinessObject(args);
	}
}
