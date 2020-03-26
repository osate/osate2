package org.osate.ge.internal.viewModels;

import java.util.stream.Stream;

import org.osate.aadl2.Prototype;
import org.osate.ge.swt.BaseObservableModel;
import org.osate.ge.swt.prototypes.PrototypeDirection;
import org.osate.ge.swt.prototypes.PrototypeType;
import org.osate.ge.swt.prototypes.PrototypesEditorModel;

// TODO: Implement
// TODO; WIll need to update with the BOS like the feature direction model
// TODO: Decide what type of object to use to referece classifier
public class BusinessObjectSelectionPrototypesModel extends BaseObservableModel
implements PrototypesEditorModel<Prototype, Object> {

	@Override
	public Stream<Prototype> getPrototypes() {
		return Stream.empty();
	}

	@Override
	public void addPrototype() {
		// TODO
	}

	@Override
	public void removePrototype(Prototype prototype) {
		// TODO
	}

	@Override
	public Prototype getSelectedPrototype() {
		// TODO
		return null;
	}

	@Override
	public void setSelectedPrototype(Prototype value) {
		// TODO?
	}

	@Override
	public String getPrototypeName(Prototype prototype) {
		return "TODO";
	}

	@Override
	public void setPrototypeName(Prototype prototype, String value) {
		// TODO
	}

	@Override
	public String validatePrototypeName(Prototype prototype, String newName) {
		// TODO
		return null;
	}

	@Override
	public PrototypeDirection getPrototypeDirection(Prototype prototype) {
		// TODO
		return null;
	}

	@Override
	public void setPrototypeDirection(Prototype prototype, PrototypeDirection value) {
		// TODO
	}

	@Override
	public PrototypeType getPrototypeType(Prototype prototype) {
		// TODO
		return PrototypeType.ABSTRACT;
	}

	@Override
	public void setPrototypeType(Prototype prototype, PrototypeType value) {
		// TODO
	}

	@Override
	public Stream<Object> getConstrainingClassifierOptions(Prototype prototype) {
		return Stream.empty();
	}

	@Override
	public String getClassifierLabel(Object classifier) {
		return "TODO";
	}

	@Override
	public Object getConstrainingClassifier(Prototype prototype) {
		// TODO
		return null;
	}

	@Override
	public void setConstrainingClassifier(Prototype prototype, Object value) {
		// TODO
	}

	@Override
	public Boolean isArray(Prototype prototype) {
		// TODO
		return null;
	}

	@Override
	public void setArray(Prototype prototype, boolean value) {
		// TODO
	}
}
