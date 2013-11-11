package edu.uah.rsesc.aadl.age.dialogs;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.NamedElement;

public class ElementSelectionDialog extends org.eclipse.ui.dialogs.ElementListSelectionDialog {
	private static final Object nullObject = new Object(); // Object that represents a null value. ElementListSelectionDialog does not support having null elements
	
	public ElementSelectionDialog(final Shell parentShell, final String prompt, final List<?> elementDescriptions) {
		super(parentShell, new org.eclipse.jface.viewers.LabelProvider() {
			@Override
			public String getText(Object element) {
				if(element == nullObject) {
					return "<None>";
				} else if(element instanceof IEObjectDescription){
					return ((IEObjectDescription)element).getName().toString();
				} else if(element instanceof NamedElement){
					return ((NamedElement)element).getName();
				} else {
					throw new RuntimeException("Unsupported object type: " + element.getClass());
				}				
			}
		});
		
		this.setTitle("Select a Classifier");
		this.setMessage(prompt);
		
		// Convert null values to point to the nullObject
		final Object[] elementsArray = elementDescriptions.toArray();
		for(int i = 0; i < elementsArray.length; i++) {
			if(elementsArray[i] == null) {
				elementsArray[i] = nullObject;
			}
		}
		
		this.setElements(elementsArray);
	}
	
	@Override
	public Object[] getResult() {
		final Object[] results = super.getResult();
		
		// Convert the nullObject to a null value
		for(int i = 0; i < results.length; i++) {
			if(results[i] == nullObject) {
				results[i] = null;
			}
		}
	
		return results;
	}

	public NamedElement getSelectedElement() {
		// Get the actual object
		final Object firstResult = super.getFirstResult();
		if(firstResult == null) {
			return null;
		} else if(firstResult instanceof IEObjectDescription) {
			final EObject element = ((IEObjectDescription)firstResult).getEObjectOrProxy();	
			
			// Return the element
			if(element instanceof NamedElement) {
				return (NamedElement)element;
			}
		} else if(firstResult instanceof NamedElement) {
			return (NamedElement)firstResult;
		}
		
		return null;
	}
}