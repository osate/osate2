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

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.Prototype;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.util.AadlPrototypeUtil;
import org.osate.ge.swt.classifiers.PrototypeBindingsModel;

/**
 * {@link PrototypeBindingsModel} implementation for editing the bindings for a classifier.
 */
public class ClassifierPrototypeBindingsModel
extends BusinessObjectSelectionPrototypeBindingsModel {

	public ClassifierPrototypeBindingsModel(BusinessObjectSelection bos) {
		super(bos);
	}

	@Override
	protected void loadData() {
		final List<Classifier> classifiers = getBusinessObjectSelection().boStream(Classifier.class)
				.collect(Collectors.toList());

		// Don't support displaying or editing bindings when multiple classifiers are selected
		if (classifiers.size() != 1) {
			setMultipleValues(true);
			return;
		}

		final Classifier classifier = classifiers.get(0);

		// Don't populate data if classifier is null.
		if (classifier == null) {
			return;
		}

		PrototypeBindingsModelNode parent = null;
		data(parent).bo = classifier;
		setNodeDataClassifier(parent, classifier);
		loadBindingData(parent, classifier.getOwnedPrototypeBindings());
	}

	@Override
	protected Stream<Prototype> getReferenceablePrototypes() {
		// Get prototypes for the select classifier
		final List<Classifier> classifiers = getBusinessObjectSelection().boStream(Classifier.class)
				.collect(Collectors.toList());
		if (classifiers.isEmpty()) {
			return null;
		}

		final Classifier c = classifiers.iterator().next();
		return AadlPrototypeUtil.getAllPrototypes(c);
	}

	@Override
	public void flush() {
		// Replace the classifier's prototype bindings with the selected ones.
		getBusinessObjectSelection().modify(Classifier.class, c -> {
			c.getOwnedPrototypeBindings().clear();
			createNewBindings(null, c, c, c.getOwnedPrototypeBindings());
		});
	}
}
