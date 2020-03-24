package org.osate.ge.swt.list;

import java.util.ArrayList;
import java.util.List;

import org.osate.ge.swt.BaseObservableModel;

/**
 * Test view model for various list views contained in this package.
 *
 */
class TestListEditorModel extends BaseObservableModel implements ListEditorModel<String> {
	private final List<String> elements = new ArrayList<>();
	private String selectedElement = null;
	private int numberOfElementsCreated = 0;

	public TestListEditorModel() {
		// Add initial elements
		addElement();
		addElement();
		addElement();

		// Set initial selection
		setSelectedElement(elements.get(1));
	}

	@Override
	public String[] getElements() {
		return elements.toArray(new String[elements.size()]);
	}

	@Override
	public String getSelectedElement() {
		return selectedElement;
	}

	@Override
	public void setSelectedElement(String value) {
		if (selectedElement != value) {
			this.selectedElement = value;
			triggerChangeEvent();
		}
	}

	@Override
	public void addElement() {
		elements.add("Value " + ++numberOfElementsCreated);
		triggerChangeEvent();
	}

	@Override
	public void removeElement(String element) {
		elements.remove(element);
		triggerChangeEvent();
	}
}
