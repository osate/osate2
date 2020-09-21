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

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.ge.ProjectUtil;
import org.osate.ge.errormodel.ui.ErrorModelUiUtil;
import org.osate.ge.errormodel.ui.swt.TypeTokenListEditorModel;
import org.osate.ge.swt.BaseObservableModel;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;

/**
 * {@link TypeTokenListEditorModel} implementation which edits the type tokens of a {@link TypeSet}.
 * Only a single type set is supported. If multiple type sets are provided an error label will be provided as the label.
 *
 */
public abstract class BaseTypeSetTypeTokensModel extends BaseObservableModel implements TypeTokenListEditorModel {
	private final boolean allowEmpty;
	private BasicTypeTokenListEditorModel inner;
	private String error = null;
	private NamedObjectsProvider<ErrorTypes> knownErrorTypes;

	public BaseTypeSetTypeTokensModel() {
		this(false);
	}

	/**
	 * Creates a new instance
	 * @param allowEmpty is whether the model should allow removing all type tokens from a type set.
	 */
	public BaseTypeSetTypeTokensModel(final boolean allowEmpty) {
		this.allowEmpty = allowEmpty;
		setTypeSets(Collections.emptyList());
	}

	/**
	* Updates the state of the model. If possible, retrieves the project from the first type set in the list.
	* {@link BaseTypeSetTypeTokensModel#setState(List, IProject)}
	*/
	protected final void setTypeSets(final List<TypeSet> typeSets) {
		final IProject project = typeSets.isEmpty() ? null : ProjectUtil.getProjectForBo(typeSets.get(0)).orElse(null);
		setState(typeSets, project);
	}

	/**
	 * Refreshes the internal state of the model based on the specified type sets.
	 * Must be called to update the state of the model.
	 */
	protected final void setState(List<TypeSet> typeSets, final IProject project) {
		inner = null;
		error = null;
		knownErrorTypes = EmptyNamedObjectsProvider.instance();

		// If there are multiple error types provided, then check if the type sets are equal.
		// If they are all equal, then only use the first type set. This allows editing
		// when all the types sets are equal.
		// Otherwise, pass all the type sets to the base class and let it handle things.
		if (typeSets.size() > 1) {
			final Object comparisonKey = getComparisonKey(typeSets.get(0));
			boolean allMatch = true;

			for (int i = 1; i < typeSets.size() && allMatch; i++) {
				allMatch = Objects.equals(comparisonKey, getComparisonKey(typeSets.get(i)));
			}

			if (allMatch) {
				typeSets = Collections.singletonList(typeSets.get(0));
			}
		}

		if (typeSets.size() == 1) {
			final TypeSet typeSet = typeSets.get(0);

			// When switching from the text editor the project is often not available.
			// This issue is transient and is usually not noticeable.
			if (project == null) {
				error = "<Unable to retrieve project>";
			} else {
				knownErrorTypes = new ProjectErrorTypesProvider(project);
				inner = new BasicTypeTokenListEditorModel(knownErrorTypes, typeSet.getTypeTokens(), allowEmpty);
			}
		}
		triggerChangeEvent();
	}

	/**
	 * Returns an object than can be compared using equals to determine if two type sets are equivalent
	 * @param typeSet is the type set to return the key for
	 * @return
	 */
	private Object getComparisonKey(final TypeSet typeSet) {
		return typeSet.getTypeTokens().stream().map(t -> {
			return t.getType().stream().map(type -> EcoreUtil.getURI(type)).collect(Collectors.toSet());
		}).collect(Collectors.toSet());
	}

	/**
	 * Called to modify the type sets. The implementer must call the modifier to perform actual type set modification.
	 * @param modifier the function that modifies the type set.
	 */
	protected abstract void modifyTypeSets(final Consumer<TypeSet> modifier);

	@Override
	public final Stream<TypeToken> getTypeTokens() {
		return inner == null ? Stream.empty() : inner.getTypeTokens();
	}

	@Override
	public final void setTypeTokens(final List<TypeToken> value) {
		if (inner != null) {
			inner.setTypeTokens(value);

			// Modify the AADL model
			modifyTypeSets(ts -> {
				ts.getTypeTokens().clear();
				ts.getTypeTokens().addAll(inner.getTypeTokenList());
			});
		}
	}

	@Override
	public final Stream<ErrorTypes> getErrorTypes() {
		return inner == null ? Stream.empty() : inner.getErrorTypes();
	}

	@Override
	public final String getErrorTypeLabel(final ErrorTypes value) {
		return inner == null ? "" : inner.getErrorTypeLabel(value);
	}

	@Override
	public final String validate(List<TypeToken> value) {
		return inner == null ? "" : inner.validate(value);
	}


	@Override
	public String getTypeTokenLabel(final TypeToken value) {
		return ErrorModelUiUtil.getTypeTokenLabel(value, knownErrorTypes::getName);
	}

	@Override
	public final String getTypeTokensLabel() {
		if (error != null) {
			return error;
		}

		if (inner == null) {
			return "<Multiple Type Sets Selected>";
		}

		return ErrorModelUiUtil.getTypeTokensLabel(getTypeTokens(), knownErrorTypes::getName);
	}
}
