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
package org.osate.aadl2;

import org.osate.aadl2.properties.EvaluatedProperty;
import org.osate.aadl2.properties.EvaluationContext;
import org.osate.aadl2.properties.InvalidModelException;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>From package AADLProperties::Expressions.</p>
 * <!-- end-model-doc -->
 *
 *
 * @see org.osate.aadl2.Aadl2Package#getPropertyExpression()
 * @model abstract="true"
 * @generated
 */
public interface PropertyExpression extends Element {
	/**
	 * Evaluate a property value.
	 *
	 * @param context
	 *            The context in which to look up any property value references.
	 * @param modes
	 *            The mode in which to look up the value; a mapping from
	 *            component impls to modes
	 * @return The evaluated property value.
	 * @exception InvalidModelException Thrown if there is some problem
	 * or inconsistency in the model that prevents the property value from
	 * being evaluated.
	 */
	EvaluatedProperty evaluate(EvaluationContext ctx, int depth) throws InvalidModelException;

	/**
	 * Compare to another expression
	 *
	 * @param other The expression to compare with
	 * @return If the expressions represent the same value
	 */
	boolean sameAs(PropertyExpression other);
} // PropertyExpression
