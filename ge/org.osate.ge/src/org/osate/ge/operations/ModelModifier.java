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
package org.osate.ge.operations;

import org.eclipse.emf.ecore.EObject;

/**
 * Interface for objects which performs model modification as part of an operation step.
 * @param <T> the type of the tag
 * @param <B> the type of the business object to modify
 * @param <P> the type of the user value from the result of the previous step of the operation.
 * @param <R> the type of the user value of the result of the modification step.
 * @see OperationBuilder#modifyModel(Object, org.osate.ge.operations.OperationBuilder.BusinessObjectToModifyProvider, ModelModifier)
 */
public interface ModelModifier<T, B extends EObject, P, R> {
	/**
	 * Called to perform the model modification.
	 * @param tag passed to {@link OperationBuilder#modifyModel(Object, org.osate.ge.operations.OperationBuilder.BusinessObjectToModifyProvider, ModelModifier)}. May be null.
	 * If this object is a business object, it must not be modified.
	 * @param boToModify is the business object to modify.
	 * @param prevUserValue the user value from the previous step of the operation.
	 * @return the result. Must not return null.
	 */
	StepResult<R> modify(T tag, B boToModify, P prevUserValue);
}
