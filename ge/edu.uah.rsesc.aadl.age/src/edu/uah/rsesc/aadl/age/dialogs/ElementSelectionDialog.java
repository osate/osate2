/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package edu.uah.rsesc.aadl.age.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.NamedElement;

public class ElementSelectionDialog extends org.eclipse.ui.dialogs.ElementListSelectionDialog {
	private static final Object nullObject = new Object(); // Object that represents a null value. ElementListSelectionDialog does not support having null elements
	
	public ElementSelectionDialog(final Shell parentShell, final String dlgTitle, final String prompt, final List<?> elementDescriptions) {
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
		
		this.setTitle(dlgTitle);
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

	public NamedElement getFirstSelectedNamedElement() {
		final NamedElement[] selectedElements = getSelectedNamedElements();
		if(selectedElements.length > 0) {
			return selectedElements[0];
		} else {
			return null;
		}
	}
	
	public NamedElement[] getSelectedNamedElements() {
		final Object[] result = getResult();
		final NamedElement[] selectedElements = new NamedElement[result.length];
		for(int i = 0; i < result.length; i++) {
			final Object obj = result[i];
			if(obj == null) {
				selectedElements[i] = null;
			} else if(obj instanceof IEObjectDescription) {
				final EObject element = ((IEObjectDescription)obj).getEObjectOrProxy();	
				
				// Return the element
				if(element instanceof NamedElement) {
					selectedElements[i] = (NamedElement)element;
				}
			} else if(obj instanceof NamedElement) {
				selectedElements[i] = (NamedElement)obj;
			}
		}
		
		return selectedElements;
	}
}