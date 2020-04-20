package org.osate.ge.internal.viewModels;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.NamedElement;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.swt.BaseObservableModel;
import org.osate.ge.swt.classifiers.PrototypeBindingsModel;

import com.google.common.base.Strings;

// TODO: Use appropriate types. Can adapt this to work in all cases.
// TODO: Implemement this based on plan.. Populate in another form to allow rebuilding on flush.


public abstract class BusinessObjectSelectionPrototypeBindingsModel
extends BaseObservableModel
implements PrototypeBindingsModel<PrototypeBindingNode, Object, Object, Object> {
	// TODO: Adjust types
	private Map<PrototypeBindingNode, Object> directionMap = new HashMap<>();
	private Map<PrototypeBindingNode, Object> typeMap = new HashMap<>();
	private Map<PrototypeBindingNode, Object> classifierMap = new HashMap<>();

	protected BusinessObjectSelection bos;

	public BusinessObjectSelectionPrototypeBindingsModel(final BusinessObjectSelection bos) {
		setBusinessObjectSelection(bos);
	}


	@Override
	public final Stream<PrototypeBindingNode> getChildren(final PrototypeBindingNode parent) {
		// TODO: Need to build stream of stable references.

		return Stream.empty();

//		if (parent instanceof Classifier) {
//			// TODO; This isn't correct.. Need to find applicable bindings in appropriate object.
//			final Classifier classifier = (Classifier) parent;
//			return classifier.getOwnedPrototypeBindings().stream().map(Element.class::cast);
//		} else {
//			return Stream.empty();
//		}
		// TODO: Throw if invalid type
	}

	@Override
	public final String getLabel(final PrototypeBindingNode node) {
		// The root node never has a label.
		if (node == null) {
			return "";
		}

		// TODO: node will be a reference to a prototype binding path..
		return "TODO";
	}

	@Override
	public final Stream<Object> getDirectionOptions(final PrototypeBindingNode node) {
		// The root node never has direction options.
		if (node == null) {
			return Stream.empty();
		}

		return Stream.empty(); // TODO
	}

	@Override
	public final String getDirectionLabel(Object direction) {
		return "TODO";
	}

	@Override
	public final Object getDirection(PrototypeBindingNode node) {
		return directionMap.get(node);
	}

	@Override
	public final void setDirection(PrototypeBindingNode node, Object value) {
		directionMap.put(node, value);
		triggerChangeEvent();
	}

	@Override
	public final Stream<Object> getTypeOptions(PrototypeBindingNode node) {
		// The root node never has type options.
		if (node == null) {
			return Stream.empty();
		}

		return Stream.empty(); // TODO
	}

	@Override
	public final String getTypeLabel(Object type) {
		return "TODO";
	}

	@Override
	public final Object getType(PrototypeBindingNode node) {
		return typeMap.get(node);
	}

	@Override
	public final void setType(PrototypeBindingNode node, Object value) {
		typeMap.put(node, value);
		triggerChangeEvent();
	}

	@Override
	public final Stream<Object> getClassifierOptions(final PrototypeBindingNode node) {
		if (node == null) {
			return getClassifierOptionsForRoot();
		}

		return Stream.empty(); // TODO
	}

	@Override
	public final String getClassifierLabel(final Object classifier) {
		if (classifier == null) {
			return "<None>";
		}

		if (classifier instanceof Set) {
			final Collection<?> c = (Collection<?>) classifier;
			if (c.isEmpty()) {
				return "";
			}

			if (c.size() > 1) {
				return "<Multiple>";
			}

			return getClassifierLabel(c.iterator().next());
		}

		// TODO: Support for whatever form we use for options
		// TODO: Document usage of IEObjectDescription
		if (classifier instanceof IEObjectDescription) {
			return ((IEObjectDescription) classifier).getName().toString("::");
		} else if (classifier instanceof NamedElement) {
			return Strings.emptyToNull((((NamedElement) classifier).getQualifiedName()));
		} else {
			return "<Unsupported Value>";
		}
	}

	@Override
	public final Object getClassifier(final PrototypeBindingNode node) {
		return classifierMap.get(node);
	}

	// TODO: Move these
	// TODO: Document expected return value
	protected Object getClassifierForRoot() {
		return null;
	}

	protected Stream<Object> getClassifierOptionsForRoot() {
		return Stream.empty();
	}

	/// TODO; END

	@Override
	public final void setClassifier(PrototypeBindingNode node, Object value) {
		classifierMap.put(node, value);
		triggerChangeEvent();
	}



	/**
	 * Refreshes the internal state of the model based on the specified business object selection
	 */
	public final void setBusinessObjectSelection(final BusinessObjectSelection value) {
		this.bos = Objects.requireNonNull(value, "value must not be null");

		// Clear maps
		directionMap.clear();
		typeMap.clear();
		classifierMap.clear();

		// Load maps
		classifierMap.put(null, getClassifierForRoot());
		// TODO Bindings information

		triggerChangeEvent();

	}

	// TODO: Rename.. If there are bindings to be set.
	public static boolean hasAvailableBindings(final Classifier classifier) {
		// TODO
		return classifier.getName().startsWith("n");
	}
}

// TODO; Implement equals and hashcode
class PrototypeBindingNode {

}
