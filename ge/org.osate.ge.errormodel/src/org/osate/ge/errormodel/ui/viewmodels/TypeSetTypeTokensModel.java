/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.errormodel.ui.swt.TypeTokenListEditorModel;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;

/**
 * {@link TypeTokenListEditorModel} implementation which edits the type tokens of a {@link TypeSet} provided by a
 * {@link BusinessObjectSelection}
 *
 */
public class TypeSetTypeTokensModel extends BaseTypeSetTypeTokensModel
		implements TypeTokenListEditorModel {
	private BusinessObjectSelection bos;

	/**
	 * Creates a new instance
	 * @param bos the initial business object selection
	 */
	public TypeSetTypeTokensModel(final BusinessObjectSelection bos) {
		super(false);
		setBusinessObjectSelection(bos);
	}

	/**
	 * Refreshes the state of the model based on the specified business object selection
	 * @param value the business object selection
	 */
	public final void setBusinessObjectSelection(final BusinessObjectSelection value) {
		this.bos = Objects.requireNonNull(value, "value must not be null");
		setTypeSets(bos.boStream(TypeSet.class).collect(Collectors.toList()));
	}

	@Override
	protected void modifyTypeSets(final Consumer<TypeSet> modifier) {
		bos.modify(TypeSet.class, modifier);
	}

	@Override
	public Stream<ErrorTypes> getErrorTypes() {
		// Filter out self from available error types
		final Set<URI> selectedTypeSetURIs = bos.boStream(TypeSet.class)
				.map(EcoreUtil::getURI)
				.collect(Collectors.toSet());
		return super.getErrorTypes().filter(errorType -> !selectedTypeSetURIs.contains(EcoreUtil.getURI(errorType)));
	}
}

