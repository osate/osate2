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
package org.osate.ge.errormodel.model;

import com.google.common.base.Objects;

/**
 * Enumeration for keywords that refer to predefined propagation points.
 *
 */
public enum KeywordPropagationPointType {
	/**
	 * All is not a propagation point exactly but is used for flow declarations
	 */
	ALL("all"), ACCESS("access"), PROCESSOR("processor"), MEMORY("memory"), CONNECTION("connection"), BINDING(
			"binding"), BINDINGS("bindings");

	private final String kind;

	/**
	 * Create a new instance
	 * @param kind must match the kind string used for propagations for this type.
	 */
	KeywordPropagationPointType(final String kind) {
		this.kind = kind;
	}

	public String getKind() {
		return kind;
	}

	/**
	 * Gets an instance based on the name which matches the "kind" used in the EMV2 model
	 * @param kind the name to look for
	 * @return the matching instance
	 */
	public static KeywordPropagationPointType getByKind(final String kind) {
		for (final KeywordPropagationPointType k : KeywordPropagationPointType.values()) {
			if (Objects.equal(kind, k.kind)) {
				return k;
			}
		}
		return null;
	}
}