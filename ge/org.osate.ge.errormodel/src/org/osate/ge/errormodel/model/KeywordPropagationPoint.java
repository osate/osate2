/**
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.errormodel.model;

import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Classifier;
import org.osate.ge.EmfContainerProvider;

/**
 * A model object that represents a {@link KeywordPropagationPointType} in the context of a containing classifier.
 *
 */
public class KeywordPropagationPoint implements EmfContainerProvider {
	private final Classifier classifier;

	private final KeywordPropagationPointType type;

	private final boolean isUsed;

	/**
	 * Creates a new instance
	 * @param classifier the classifier which owns the propagation point
	 * @param type the type of keyword propagation point
	 * @param isUsed whether the propgation point is referenced by other model elements
	 */
	public KeywordPropagationPoint(final Classifier classifier, final KeywordPropagationPointType type,
			final boolean isUsed) {
		this.type = Objects.requireNonNull(type, "type must not be null");
		this.classifier = Objects.requireNonNull(classifier, "clasifier must not be null");
		this.isUsed = isUsed;
	}

	@Override
	public EObject getEmfContainer() {
		return getClassifier();
	}

	/**
	 * Returns the classifier which owns the propagation point
	 * @return the classifier which owns the propagation point
	 */
	public final Classifier getClassifier() {
		return classifier;
	}

	/**
	 * Returns the keyword which identifies the propagation point
	 * @return the keyword which identifies the propagation point
	 */
	public final KeywordPropagationPointType getType() {
		return type;
	}

	/**
	 * Returns whether the keyword propagation point is referenced by another error model annex element
	 * @return whether the keyword propagation point is referenced by another error model annex element
	 */
	public final boolean isUsed() {
		return isUsed;
	}
}
