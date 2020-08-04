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

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.resources.IProject;
import org.osate.aadl2.AadlPackage;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.ProjectUtil;
import org.osate.ge.errormodel.ui.swt.TypeTokenListEditorModel;
import org.osate.ge.swt.BaseObservableModel;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;

/**
 * {@link TypeTokenListEditorModel} implementation which edits the type tokens of a {@link TypeSet}
 *
 */
public class TypeSetTypeTokensModel extends BaseObservableModel
		implements TypeTokenListEditorModel {
	private BusinessObjectSelection bos;
	private BasicTypeTokenListEditorModel inner;
	private String error = null;

	/**
	 * Creates a new instance
	 * @param bos the initial business object selection
	 */
	public TypeSetTypeTokensModel(final BusinessObjectSelection bos) {
		setBusinessObjectSelection(bos);
	}

	/**
	* Refreshes the internal state of the model based on the specified business object selection
	*/
	public final void setBusinessObjectSelection(final BusinessObjectSelection value) {
		this.bos = Objects.requireNonNull(value, "value must not be null");
		inner = null;
		error = null;

		final List<TypeSet> typeSets = value.boStream(TypeSet.class).collect(Collectors.toList());
		if (typeSets.size() == 1) {
			final TypeSet typeSet = typeSets.get(0);
			final AadlPackage pkg = (AadlPackage) typeSet.getElementRoot();

			// When switching from the text editor the project is often not available.
			// This issue is transient and is usually not noticeable.
			final IProject project = ProjectUtil.getProjectForBo(pkg).orElse(null);
			if (project == null) {
				error = "<Unable to retrieve project>";
			} else {
				inner = new BasicTypeTokenListEditorModel(project, typeSet.getTypeTokens());
			}
		}
		triggerChangeEvent();
	}

	@Override
	public Stream<TypeToken> getTypeTokens() {
		return inner == null ? Stream.empty() : inner.getTypeTokens();
	}

	@Override
	public void setTypeTokens(final List<TypeToken> value) {
		if (inner != null) {
			inner.setTypeTokens(value);

			// Modify the AADL model
			bos.modify(TypeSet.class, ts -> {
				ts.getTypeTokens().clear();
				ts.getTypeTokens().addAll(inner.getTypeTokenList());
			});
		}
	}

	@Override
	public Stream<ErrorTypes> getErrorTypes() {
		return inner == null ? Stream.empty() : inner.getErrorTypes();
	}

	@Override
	public String getErrorTypeLabel(final ErrorTypes value) {
		return inner == null ? "" : inner.getErrorTypeLabel(value);
	}

	@Override
	public String validate(List<TypeToken> value) {
		return inner == null ? "" : inner.validate(value);
	}

	@Override
	public String getTypeTokensLabel() {
		if (error != null) {
			return error;
		}

		if (inner == null) {
			return "<Multiple Type Sets Selected>";
		}

		return TypeTokenListEditorModel.super.getTypeTokensLabel();
	}
}
