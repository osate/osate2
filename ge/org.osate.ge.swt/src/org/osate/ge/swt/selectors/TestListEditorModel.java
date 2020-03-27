package org.osate.ge.swt.selectors;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.osate.ge.swt.BaseObservableModel;

/**
 * Test view model for various list views contained in this package. Allows up to 5 items in the list.
 *
 */
final class TestListEditorModel extends BaseObservableModel
		implements ListEditorModel<String> {
	private final List<String> elements = new ArrayList<>();
	private String selectedElement = null;
	private int numberOfElementsCreated = 0;

	public TestListEditorModel() {
		// Add initial elements
		elements.add(null);
		addElement();
		addElement();
		addElement();

		// Set initial selection
		setSelectedElement(elements.get(1));
	}

	@Override
	public Stream<String> getElements() {
		return elements.stream();
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

	@Override
	public String getLabel(final String element) {
		return element == null ? "<None>" : element;
	}

	@Override
	public boolean canAdd() {
		return elements.size() < 5;
	}

}
