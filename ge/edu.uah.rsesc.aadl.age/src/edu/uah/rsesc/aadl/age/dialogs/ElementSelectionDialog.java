package edu.uah.rsesc.aadl.age.dialogs;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.NamedElement;

public class ElementSelectionDialog extends org.eclipse.ui.dialogs.ElementListSelectionDialog {
	public ElementSelectionDialog(final Shell parentShell, final String prompt, final List<IEObjectDescription> elementDescriptions) {
		super(parentShell, new org.eclipse.jface.viewers.LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((IEObjectDescription)element).getName().toString();
			}
		});
		
		this.setTitle("Select a Classifier");
		this.setMessage(prompt);
		this.setElements(elementDescriptions.toArray());
	}

	public NamedElement getSelectedElement() {
		// Get the actual object
		final IEObjectDescription elementDescription = (IEObjectDescription)super.getFirstResult();
		final EObject element = elementDescription.getEObjectOrProxy();
		
		// Return the element
		if(element instanceof NamedElement) {
			return (NamedElement)element;
		}
		
		return null;
	}
}