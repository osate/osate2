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
package org.osate.ge.internal.model;

import java.util.Objects;

/**
 * Generic business object for use with simple indicator which include an optional values.
 * There must be at most one tag with a particular key for any particular parent business object.
 *
 */
public class Tag {
	public static final String KEY_SUBCOMPONENT_TYPE = "sc_type";
	public static final String KEY_SUBPROGRAM_CALL_CALLED_SUBPROGRAM = "spc_csp";
	public static final String KEY_UNIDIRECTIONAL = "unidirectional"; // A tagged value of this type indicates that the connection is a unidirectional connection
	public static final String KEY_MODE_TRANSITION_TRIGGERS = "mtt";

	public final String key;
	public final Object value;

	/**
	 *
	 * @param key
	 * @param value is optional
	 */
	public Tag(final String key, final Object value) {
		this.key = Objects.requireNonNull(key, "key must not be null");
		this.value = value;
	}
}
