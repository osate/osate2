package org.osate.ge.internal.viewModels;

import java.util.Objects;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EClass;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.swt.BaseObservableModel;
import org.osate.ge.swt.classifiers.PrototypeBindingsModel;

// TODO: Use appropriate types. Can adapt this to work in all cases.
// TODO: Implemement this based on plan.. Populate in another form to allow rebuilding on flush.

public class BusinessObjectSelectionPrototypeBindingsModel
extends BaseObservableModel
implements PrototypeBindingsModel<Element, Object, EClass, Object> {
	private BusinessObjectSelection bos;

	public BusinessObjectSelectionPrototypeBindingsModel(final BusinessObjectSelection bos) {
		setBusinessObjectSelection(bos);
	}


	@Override
	public Stream<Element> getChildren(final Element parent) {
		if (parent instanceof Classifier) {
			// TODO; This isn't correct.. Need to find applicable bindings in appropriate object.
			final Classifier classifier = (Classifier) parent;
			return classifier.getOwnedPrototypeBindings().stream().map(Element.class::cast);
		} else {
			return Stream.empty();
		}
		// TODO: Throw if invalid type
	}

	@Override
	public String getLabel(Element node) {
		return "TODO";
	}

	@Override
	public Stream<Object> getDirectionOptions(Element node) {
		return Stream.empty(); // TODO
	}

	@Override
	public String getDirectionLabel(Object direction) {
		return "TODO";
	}

	@Override
	public Object getDirection(Element node) {
		return null; // TODO
	}

	@Override
	public void setDirection(Element node, Object value) {
		// TODO
	}

	@Override
	public Stream<EClass> getTypeOptions(Element node) {
		return Stream.empty(); // TODO
	}

	@Override
	public String getTypeLabel(EClass type) {
		return "TODO";
	}

	@Override
	public EClass getType(Element node) {
		return null; // TODO
	}

	@Override
	public void setType(Element node, EClass value) {
		// TODO
	}

	@Override
	public Stream<Object> getClassifierOptions(Element node) {
		return Stream.empty(); // TODO
	}

	@Override
	public String getClassifierLabel(Object classifier) {
		return "TODO";
	}

	@Override
	public Object getClassifier(Element node) {
		return null;
	}

	@Override
	public void setClassifier(Element node, Object value) {
		// TODO
	}

	@Override
	public void flush() {
		// TODO
	}

	/**
	 * Refreshes the internal state of the model based on the specified business object selection
	 */
	public void setBusinessObjectSelection(final BusinessObjectSelection value) {
		this.bos = Objects.requireNonNull(value, "value must not be null");
	}

	// TODO: Rename.. If there are bindings to be set.
	public static boolean hasAvailableBindings(final Classifier classifier) {
		// TODO
		return classifier.getName().startsWith("n");
	}
}
