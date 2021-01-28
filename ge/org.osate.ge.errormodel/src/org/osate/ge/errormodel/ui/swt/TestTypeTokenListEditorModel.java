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
package org.osate.ge.errormodel.ui.swt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.osate.ge.errormodel.ui.ErrorModelUiUtil;
import org.osate.ge.swt.BaseObservableModel;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelFactory;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;

/**
 * Test model for {@link TypeTokenListEditorDialog} and {@link TypeTokenListField}
 *
 */
class TestTypeTokenListEditorModel extends BaseObservableModel implements TypeTokenListEditorModel {
	private List<TypeToken> tokens;
	private final List<ErrorTypes> errorTypes;

	public TestTypeTokenListEditorModel() {
		tokens = new ArrayList<>();
		errorTypes = new ArrayList<>();

		final ErrorModelLibrary lib = ErrorModelFactory.eINSTANCE.createErrorModelLibrary();

		// Create error types and type aliases
		for (int i = 0; i < 5; i++) {
			final ErrorType t = ErrorModelFactory.eINSTANCE.createErrorType();
			lib.getTypes().add(t);
			t.setName("type" + i);

			// Odd numbered types are type aliases.
			if (i % 2 == 1) {
				t.setAliasedType((ErrorType) errorTypes.get(i - 1));
			}
			errorTypes.add(t);
		}

		// Create type set
		final TypeSet ts = ErrorModelFactory.eINSTANCE.createTypeSet();
		lib.getTypesets().add(ts);
		ts.setName("ts1");
		final TypeToken tk1 = ErrorModelFactory.eINSTANCE.createTypeToken();
		tk1.getType().add(errorTypes.get(0));
		ts.getTypeTokens().add(tk1);
		errorTypes.add(ts);

		// Create type set alias
		final TypeSet tsAlias = ErrorModelFactory.eINSTANCE.createTypeSet();
		lib.getTypesets().add(tsAlias);
		tsAlias.setName("ts1Alias");
		tsAlias.setAliasedType(ts);
		errorTypes.add(tsAlias);

		// Create type tokens for individual types and type products
		{
			final TypeToken newToken = ErrorModelFactory.eINSTANCE.createTypeToken();
			newToken.getType().add(errorTypes.get(0));
			tokens.add(newToken);
		}

		{
			final TypeToken newToken = ErrorModelFactory.eINSTANCE.createTypeToken();
			newToken.getType().add(errorTypes.get(1));
			newToken.getType().add(errorTypes.get(2));
			tokens.add(newToken);
		}

	}

	@Override
	public Stream<TypeToken> getTypeTokens() {
		return tokens.stream();
	}

	@Override
	public void setTypeTokens(final List<TypeToken> value) {
		this.tokens = new ArrayList<>(value);
		triggerChangeEvent();
	}

	@Override
	public Stream<ErrorTypes> getErrorTypes() {
		return errorTypes.stream();
	}

	@Override
	public String validate(final List<TypeToken> value) {
		if (value.isEmpty()) {
			return "At least 1 token must be contained in the list";
		}

		return "";
	}

	@Override
	public String getErrorTypeLabel(final ErrorTypes value) {
		return value.getName();
	}

	@Override
	public String getTypeTokenLabel(final TypeToken value) {
		return ErrorModelUiUtil.getTypeTokenLabel(value, t -> t.getName());
	}

	@Override
	public String getTypeTokensLabel() {
		return ErrorModelUiUtil.getTypeTokensLabel(getTypeTokens(), t -> t.getName());
	}
}
