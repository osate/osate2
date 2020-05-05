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
package org.osate.ge.swt.prototypes;

import java.util.Objects;

/**
 * Enumeration of types of prototype. Concatenation of the various types of component classifiers with a feature and feature group
 *
 */
public enum PrototypeType {
	//@formatter:off
	ABSTRACT("Abstract"),
	BUS("Bus"),
	DATA("Data"),
	DEVICE("Device"),
	MEMORY("Memory"),
	PROCESSOR("Processor"),
	PROCESS("Process"),
	SUBPROGRAM_GROUP("Subprogram Group"),
	SUBPROGRAM("Subprogram"),
	SYSTEM("System"),
	THREAD_GROUP("Thread Group"),
	THREAD("Thread"),
	VIRTUAL_BUS("Virtual Bus"),
	VIRTUAL_PROCESSOR("Virtual Processor"),
	FEATURE("Feature"),
	FEATURE_GROUP("Feature Group");
	//@formatter:on

	private final String label;

	PrototypeType(final String label) {
		this.label = Objects.requireNonNull(label);
	}

	@Override
	public String toString() {
		return label;
	}

	public boolean isComponent() {
		return this != FEATURE && this != FEATURE_GROUP;
	}
}
