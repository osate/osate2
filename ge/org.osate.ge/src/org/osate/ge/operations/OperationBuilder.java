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
package org.osate.ge.operations;

import java.util.function.Function;
import java.util.function.Supplier;

import org.eclipse.emf.ecore.EObject;

public interface OperationBuilder<PrevResultUserType> {
	interface BusinessObjectProvider<TagType, BusinessObjectType, PrevResultUserType> {
		BusinessObjectType getBusinessObject(TagType tag, PrevResultUserType previousUserValue);
	}

	<TagType, BusinessObjectType extends EObject, ResultUserType> OperationBuilder<ResultUserType> modifyModel(
			TagType obj, BusinessObjectProvider<TagType, BusinessObjectType, PrevResultUserType> boProvider,
			ModelModifier<TagType, BusinessObjectType, PrevResultUserType, ResultUserType> modifier);

	/**
	 * Modifies the previous result. The previous result is expected to be an EObject belonging to the AADL model.
	 * @param modifier must not return null
	 * @return
	 */
	@SuppressWarnings("unchecked")
	default <TagType, ResultUserType> OperationBuilder<ResultUserType> modifyPreviousResult(
			final Function<PrevResultUserType, StepResult<ResultUserType>> modifier) {

		return modifyModel(null, (tag, prevResult) -> {
			if (!(prevResult instanceof EObject)) {
				throw new IllegalStateException("Previous result must be an EObject. Previous result: " + prevResult);
			}
			return (EObject) prevResult;
		}, (tag, boToModify, prevResult) -> modifier.apply((PrevResultUserType) boToModify));
	}

	<ResultUserType> OperationBuilder<ResultUserType> map(
			Function<PrevResultUserType, StepResult<ResultUserType>> mapper);

	/**
	 * A map which ignores the previous result.
	 * @param supplier
	 * @return
	 */
	default <ResultUserType> OperationBuilder<ResultUserType> supply(
			final Supplier<StepResult<ResultUserType>> supplier) {
		return map(prevResult -> supplier.get());
	}
}
