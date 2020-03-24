package org.osate.ge.internal.ui.models;

import org.osate.aadl2.Prototype;
import org.osate.ge.swt.BaseObservableModel;
import org.osate.ge.swt.prototypes.PrototypeDirection;
import org.osate.ge.swt.prototypes.PrototypeType;
import org.osate.ge.swt.prototypes.PrototypesEditorModel;

// TODO: Implement
// TODO; WIll need to update with the BOS like the feature direction model
public class BusinessObjectSelectionPrototypesModel extends BaseObservableModel
implements PrototypesEditorModel<Prototype> {

	@Override
	public Prototype[] getPrototypes() {
		return new Prototype[0];
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
		return null;
	}

	@Override
	public void setPrototypeType(Prototype prototype, PrototypeType value) {
		// TODO
	}
}
