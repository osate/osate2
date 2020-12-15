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
package org.osate.ge.errormodel.ui.viewmodels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.ge.errormodel.ui.ErrorModelUiUtil;
import org.osate.ge.errormodel.ui.swt.TypeTokenListEditorModel;
import org.osate.ge.swt.BaseObservableModel;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;

/**
 * {@link TypeTokenListEditorModel} implementation which maintains an internal list of type tokens. Does not modify the original model.
 *
 */
public class BasicTypeTokenListEditorModel extends BaseObservableModel implements TypeTokenListEditorModel {
	private final NamedObjectsProvider<ErrorTypes> accessibleErrorTypes;
	private List<TypeToken> tokens;
	private boolean allowEmpty;

	/**
	 * Creates a new instance
	 * @param accessibleErrorTypes is the source for accessible error types
	 * @param tokens the type tokens currently in the list being edited.
	 * @param allowEmpty is whether the model should allow removing all type tokens from a type set.
	 */
	public BasicTypeTokenListEditorModel(final NamedObjectsProvider<ErrorTypes> accessibleErrorTypes,
			final List<TypeToken> tokens, final boolean allowEmpty) {
		this.accessibleErrorTypes = Objects.requireNonNull(accessibleErrorTypes, "accessibleErrorTypes must not be null");

		// Make a copy of the tokens
		this.tokens = new ArrayList<>(EcoreUtil.copyAll(tokens));

		this.allowEmpty = allowEmpty;
	}

	@Override
	public Stream<TypeToken> getTypeTokens() {
		return tokens.stream();
	}

	public List<TypeToken> getTypeTokenList() {
		return Collections.unmodifiableList(tokens);
	}

	@Override
	public void setTypeTokens(final List<TypeToken> value) {
		if (!Objects.equals(tokens, value)) {
			tokens = value;
			triggerChangeEvent();
		}
	}

	@Override
	public Stream<ErrorTypes> getErrorTypes() {
		return accessibleErrorTypes.getValues();
	}

	@Override
	public String validate(List<TypeToken> value) {
		// Type tokens must have at least one type.
		if (!allowEmpty && value.isEmpty()) {
			return "At least one token must be contained in the list";
		}

		// If an unknown type is in the type set, an exception will be thrown during serialization.
		if (value.stream().flatMap(t -> t.getType().stream()).anyMatch(t -> getNameFromMap(t) == null)) {
			return "Remove unknown error type(s)";
		}

		return "";
	}

	private String getNameFromMap(final ErrorTypes value) {
		return accessibleErrorTypes.getName(value);
	}

	@Override
	public String getErrorTypeLabel(final ErrorTypes value) {
		final String label = getNameFromMap(value);
		return label == null ? "<Unknown Error Type>" : label;
	}

	@Override
	public String getTypeTokenLabel(final TypeToken value) {
		return ErrorModelUiUtil.getTypeTokenLabel(value, accessibleErrorTypes::getName);
	}

	@Override
	public String getTypeTokensLabel() {
		return ErrorModelUiUtil.getTypeTokensLabel(getTypeTokens(), accessibleErrorTypes::getName);
	}
}
