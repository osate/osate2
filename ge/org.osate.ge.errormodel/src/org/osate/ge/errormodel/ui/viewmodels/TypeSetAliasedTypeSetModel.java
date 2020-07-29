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

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.aadl2.ui.AadlModelAccessUtil;
import org.osate.ge.swt.BaseObservableModel;
import org.osate.ge.swt.selectors.SingleSelectorModel;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;

/**
 * View model which sets the aliased type set for {@link TypeSet} objects included in a {@link BusinessObjectSelection}.
 * Only a single {@link TypeSet} is supported.
 *
 */
public class TypeSetAliasedTypeSetModel extends BaseObservableModel implements SingleSelectorModel<TypeSet> {
	private static class Option {
		public Option(final IEObjectDescription desc) {
			this.typeSet = (TypeSet) desc.getEObjectOrProxy();
			this.qualifiedName = ErrorModelViewModelUtil.getQualifiedName(desc);
		}

		public final TypeSet typeSet;
		public final String qualifiedName;
	}

	private BusinessObjectSelection bos;
	private Map<URI, Option> uriToOptionMap;
	private String error;

	/**
	 * Creates a new instance
	 * @param bos the initial business object selection
	 */
	public TypeSetAliasedTypeSetModel(final BusinessObjectSelection bos) {
		setBusinessObjectSelection(bos);
	}

	/**
	 * Refreshes the internal state of the model based on the specified business object selection
	 */
	public void setBusinessObjectSelection(final BusinessObjectSelection value) {
		this.bos = Objects.requireNonNull(value, "value must not be null");

		uriToOptionMap = Collections.emptyMap();
		error = null;

		final List<TypeSet> selectedTypeSets = value.boStream(TypeSet.class).collect(Collectors.toList());
		if (selectedTypeSets.size() > 1) {
			error = "<Multiple Type Sets Selected>";
		} else if (selectedTypeSets.size() == 0) {
			error = "<No Type Sets Selected>";
		} else {
			final TypeSet selectedTypeSet = selectedTypeSets.get(0);
			if (selectedTypeSet.eResource() == null) {
				error = "<No Resource Available>";
			} else {
				final Collection<IEObjectDescription> descriptions = AadlModelAccessUtil
						.getAllEObjectsByType(selectedTypeSet.eResource(), ErrorModelPackage.eINSTANCE.getTypeSet());
				uriToOptionMap = descriptions.stream().collect(Collectors.toMap(IEObjectDescription::getEObjectURI,
						Option::new));
			}
		}

		triggerChangeEvent();
	}

	@Override
	public Stream<TypeSet> getElements() {
		return uriToOptionMap.values().stream().map(v -> v.typeSet);
	}

	@Override
	public TypeSet getSelectedElement() {
		// Get the first aliased type set
		final TypeSet aliasedTypeSet = bos.boStream(TypeSet.class).map(t -> t.getAliasedType()).findFirst()
				.orElse(null);
		if (aliasedTypeSet == null) {
			return null;
		}

		// Return the element from the options list.
		final URI aliasedTypeSetUri = EcoreUtil.getURI(aliasedTypeSet);
		final Option option = uriToOptionMap.get(aliasedTypeSetUri);
		if (option == null) {
			// Return the actual error type set if an option wasn't available.
			return aliasedTypeSet;
		}

		return option.typeSet;
	}

	@Override
	public void setSelectedElement(final TypeSet value) {
		bos.modify(TypeSet.class, t -> {
			t.setAliasedType(value);
		});
	}

	@Override
	public String getLabel(final TypeSet element) {
		if (error != null) {
			return error;
		}

		if (element == null) {
			return "<null>";
		}

		final Option option = uriToOptionMap.get(EcoreUtil.getURI(element));
		if (option == null) {
			return "<unknown error type>";
		}

		return option.qualifiedName;
	}
}
