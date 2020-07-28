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
package org.osate.ge.errormodel.ui.swt;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.osate.ge.swt.ObservableModel;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;

/**
 * Model for the {@link TypeTokenListEditorDialog}
 *
 */
public interface TypeTokenListEditorModel extends ObservableModel {
	/**
	 * Stream of tokens being edited. The returned tokens must not be modified.
	 * @return a stream containing tokens.
	 */
	Stream<TypeToken> getTypeTokens();

	/**
	 * Called to update the type tokens.
	 * @param value the new type tokens.
	 */
	void setTypeTokens(List<TypeToken> value);

	/**
	 * Returns all the {@link ErrorTypes} that are available for use.
	 * @return the error types.
	 */
	Stream<ErrorTypes> getErrorTypes();

	/**
	 * Validates a potential new list of type tokens. Provides an error when validation fails.
	 * @param value the list of tokens to validate.
	 * @return must not return null. In the case of no error, a blank string should be returned.
	 */
	String validate(List<TypeToken> value);

	/**
	 * Provides a label for an error type.
	 * @param value the name of the error types.
	 * @return a label for the error type. must not return null.
	 */
	String getErrorTypeLabel(ErrorTypes value);

	default String getTypeTokenLabel(TypeToken value) {
		return value.getType().stream().map(this::getErrorTypeLabel).collect(Collectors.joining(" * "));
	}

	default String getTypeTokensLabel() {
		return getTypeTokens().map(this::getTypeTokenLabel).collect(Collectors.joining(", "));
	}
}
