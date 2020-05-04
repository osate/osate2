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
package org.osate.ge.internal.viewModels;

import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.FeaturePrototype;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.util.AadlPrototypeUtil;
import org.osate.ge.swt.BaseObservableModel;
import org.osate.ge.swt.selectors.SelectorModel;

import com.google.common.base.Strings;

/**
 * View model for setting the feature prototype for abstract features.
 */
public class AbstractFeaturePrototypeModel extends BaseObservableModel
implements SelectorModel<Set<FeaturePrototype>> {
	private BusinessObjectSelection bos;

	public AbstractFeaturePrototypeModel(final BusinessObjectSelection bos) {
		setBusinessObjectSelection(bos);
	}

	@Override
	public Stream<Set<FeaturePrototype>> getElements() {
		final Classifier containingClassifier = getCommonContainingClassifier();
		if (containingClassifier == null) {
			return Stream.empty();
		}

		return Stream
				.concat(Stream.of((FeaturePrototype) null),
						AadlPrototypeUtil.getAllPrototypes(containingClassifier)
						.filter(FeaturePrototype.class::isInstance).map(FeaturePrototype.class::cast))
				.map(Collections::singleton);
	}

	@Override
	public Set<FeaturePrototype> getSelectedElement() {
		return bos.boStream(AbstractFeature.class).map(f -> f.getFeaturePrototype()).collect(Collectors.toSet());
	}

	/**
	 * Return the containing classifier which is shared between the selected abstract features.
	 * @return the containing classifier which is shared between the selected abstract features. Returns null if the containing classifier does not match.
	 */
	private Classifier getCommonContainingClassifier() {
		final Iterator<Classifier> it = bos.boStream(AbstractFeature.class).map(f -> f.getContainingClassifier())
				.iterator();
		if (!it.hasNext()) {
			return null;
		}

		final Classifier classifier = it.next();
		while (it.hasNext()) {
			if (classifier != it.next()) {
				return null;
			}
		}

		return classifier;
	}

	@Override
	public void setSelectedElement(final Set<FeaturePrototype> value) {
		final FeaturePrototype fpValue = value == null || value.size() == 0 ? null : value.iterator().next();
		bos.modify(AbstractFeature.class, (Consumer<AbstractFeature>) f -> {
			f.setFeaturePrototype(fpValue);
			f.setAbstractFeatureClassifier(null);
		});
	}

	@Override
	public String getLabel(final Set<FeaturePrototype> elements) {
		if (elements.size() == 1) {
			final FeaturePrototype element = elements.iterator().next();
			if (element == null) {
				return "<None>";
			}

			return Strings.nullToEmpty(((FeaturePrototype) element).getQualifiedName());
		} else {
			return "<Multiple>";
		}
	}

	/**
	 * Refreshes the internal state of the model based on the specified business object selection
	 */
	public void setBusinessObjectSelection(final BusinessObjectSelection value) {
		this.bos = Objects.requireNonNull(value, "value must not be null");
		triggerChangeEvent();
	}

}
