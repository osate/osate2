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
package org.osate.ge.internal.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.ModalPath;
import org.osate.aadl2.ModeBinding;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.query.Queryable;

public class AadlModalElementUtil {
	public static class ModeFeatureReference {
		private final String name;
		private final NamedElement modeFeature;
		private final BusinessObjectContext modeFeatureContainer;

		private ModeFeatureReference(final String name, final NamedElement modeFeature,
				final BusinessObjectContext modeFeatureContainer) {
			this.name = name;
			this.modeFeature = modeFeature;
			this.modeFeatureContainer = modeFeatureContainer;
		}

		public String getName() {
			return name;
		}

		public NamedElement getNamedElement() {
			return modeFeature;
		}

		public BusinessObjectContext getContainer() {
			return modeFeatureContainer;
		}
	}

	/**
	 * Returns a queryable if a container contains a qualified ModalElement. Otherwise null.
	 * @param container
	 * @return
	 */
	public static Queryable getModalElement(final Queryable container) {
		return container.getChildren().stream().filter(child -> isModalElementWithContainer(child.getBusinessObject()))
				.findAny().orElse(null);
	}

	public static boolean isModalElementWithContainer(Object element) {
		if (element instanceof InstanceObject) {
			element = AadlInstanceObjectUtil.getModalElement((InstanceObject) element);
		}

		return element instanceof ModalElement
				&& ((ModalElement) element).getContainingClassifier() instanceof ComponentClassifier;
	}

	public static ModeFeatureReference createModeFeatureReference(final String name, final NamedElement ne,
			final BusinessObjectContext parent) {
		return new ModeFeatureReference(name, ne, parent);
	}

	public static List<ModeFeature> getAllInModesOrTransitions(final ModalElement modalElement) {
		final Stream<? extends ModeFeature> inModeFeatures = modalElement instanceof ModalPath
				? Stream.concat(((ModalPath) modalElement).getAllInModes().stream(),
						((ModalPath) modalElement).getAllInModeTransitions().stream())
				: modalElement.getAllInModes().stream();
				return inModeFeatures.collect(Collectors.toList());
	}

	public static List<ModeBinding> getAllModeBindings(Subcomponent sc) {
		while (sc != null) {
			final List<ModeBinding> modeBindings = sc.getOwnedModeBindings();
			if (modeBindings != null && !modeBindings.isEmpty()) {
				return modeBindings;
			}

			sc = sc.getRefined();
		}
		return Collections.emptyList();
	}
}
