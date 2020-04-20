package org.osate.ge.internal.viewModels;

import org.osate.aadl2.Classifier;
import org.osate.ge.BusinessObjectSelection;

// TODO: Cleanup, rename implement, etc
public class ClassifierBusinessObjectSelectionPrototypeBindingsModel
extends BusinessObjectSelectionPrototypeBindingsModel {

	public ClassifierBusinessObjectSelectionPrototypeBindingsModel(BusinessObjectSelection bos) {
		super(bos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void flush() {
		// TODO
		bos.modify(Classifier.class, c -> {
			// TODO: Update bindings
			// c.getOwnedPrototypeBindings()
		});

	}
}
