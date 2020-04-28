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
