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

import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.ProjectUtil;
import org.osate.ge.errormodel.ui.swt.TypeTokenListEditorModel;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelFactory;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;

/**
 * {@link TypeTokenListEditorModel} implementation which edits the target error type instance of an {@link ErrorPath} provided by a
 * {@link BusinessObjectSelection}
 *
 */
public class ErrorPathTargetErrorTypeInstanceModel extends BaseTypeSetTypeTokensModel implements TypeTokenListEditorModel {
	private BusinessObjectSelection bos;

	/**
	 * Creates a new instance
	 * @param bos the initial business object selection
	 */
	public ErrorPathTargetErrorTypeInstanceModel(final BusinessObjectSelection bos) {
		super(true);
		setBusinessObjectSelection(bos);
	}

	public final void setBusinessObjectSelection(final BusinessObjectSelection value) {
		this.bos = Objects.requireNonNull(value, "value must not be null");

		// Find the first valid project based on the error flow.
		final IProject project = ProjectUtil.getProjectForBo(bos.boStream(ErrorPath.class).findAny().orElse(null))
				.orElse(null);

		// Set the type sets used by the model. Create an empty type set object to use in place of null values.
		setState(bos.boStream(ErrorPath.class)
				.map(f -> f.getTargetToken() == null ? ErrorModelFactory.eINSTANCE.createTypeSet()
						: f.getTargetToken())
				.collect(Collectors.toList()), project);
	}

	@Override
	protected void modifyTypeSets(final Consumer<TypeSet> modifier) {
		bos.modify(ErrorPath.class, f -> {
			// Create the type set if it doesn't exist so that there will be a non-null type set to pass to the modifier
			if (f.getTargetToken() == null) {
				f.setTargetToken(ErrorModelFactory.eINSTANCE.createTypeSet());
			}

			modifier.accept(f.getTargetToken());

			// Set the type set to null if it is empty. Type sets are not allowed to be empty.
			if (f.getTargetToken().getTypeTokens().isEmpty()) {
				f.setTargetToken(null);
			}
		});
	}
}
