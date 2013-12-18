/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package edu.uah.rsesc.aadl.age.dialogs;

import java.lang.reflect.Array;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.NamedElement;

/**
 * Dialog to allow the user to select objects. Uses org.eclipse.ui.dialogs.ElementListSelectionDialog internally, but handles null objects. Contains
 * special handling for IEobjectDescription and NamedElement objects
 * @author philip.alldredge
 *
 */
public class ElementSelectionDialog {
	private static final Object nullObject = new Object(); // Object that represents a null value. ElementListSelectionDialog does not support having null elements
	private final org.eclipse.ui.dialogs.ElementListSelectionDialog dlg;
	
	public ElementSelectionDialog(final Shell parentShell, final String dlgTitle, final String prompt, final List<?> elementDescriptions) {
		dlg = new org.eclipse.ui.dialogs.ElementListSelectionDialog(parentShell, new org.eclipse.jface.viewers.LabelProvider() {
			@Override
			public String getText(Object element) {
				if(element == nullObject) {
					return "<None>";
				} else if(element instanceof IEObjectDescription){
					return ((IEObjectDescription)element).getName().toString();
				} else if(element instanceof NamedElement){
					return ((NamedElement)element).getName();
				} else {
					return element.toString();
				}				
			}
		});
		
		dlg.setTitle(dlgTitle);
		dlg.setMessage(prompt);
		
		// Convert null values to point to the nullObject
		final Object[] elementsArray = convertToNullObject(elementDescriptions.toArray());		
		dlg.setElements(elementsArray);
	}
	
	public Object getFirstSelectedElement() {
		return getFirstSelectedElement(Object.class);
	}
	
	public <T> Object getFirstSelectedElement(final Class<T> c) {
		final T[] selectedElements = getAllSelectedElements(c);
		if(selectedElements.length > 0) {
			return selectedElements[0];
		} else {
			return null;
		}
	}
	
	public Object[] getAllSelectedElements() {
		return getAllSelectedElements(Object.class);
	}
	
	/**
	 * Converts an array of values to an array that is identical except that references to the nullObject field have been replaced with null values.
	 * @param values
	 * @return
	 */
	private Object[] convertToNullValue(final Object[] values) {
		final Object[] converted = new Object[values.length];
		
		// Convert the nullObject to a null value
		for(int i = 0; i < values.length; i++) {
			converted[i] = (values[i] == nullObject) ? null : values[i];
		}
		
		return converted;
	}
	
	/**
	 * Converts an array of values to an array that is identical except that null references have been replaced to referenced to the nullObject field.
	 * @param values
	 * @return
	 */
	private Object[] convertToNullObject(final Object[] values) {
		final Object[] converted = new Object[values.length];
		
		// Convert null values to point to the nullObject
		for(int i = 0; i < values.length; i++) {
			converted[i] = (values[i] == null) ? nullObject : values[i];
		}
		
		return converted;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T[] getAllSelectedElements(final Class<T> c) {
		// Get the results and handle null objects
		final Object[] results = convertToNullValue(dlg.getResult());		
		
		final T[] selectedElements = (T[])Array.newInstance(c, results.length);
		for(int i = 0; i < results.length; i++) {
			final Object obj = results[i];
			if(obj == null) {
				selectedElements[i] = null;
			} else if(obj instanceof IEObjectDescription) {
				final EObject element = ((IEObjectDescription)obj).getEObjectOrProxy();	
				selectedElements[i] = (T)element;
			} else {
				selectedElements[i] = (T)obj;
			}
		}

		return selectedElements;
	}
	
	public int open() {
		return dlg.open();
	}
	
	public void setMultipleSelection(final boolean value) {
		dlg.setMultipleSelection(value);
	}
	
	public void setInitialSelections(Object[] elements) {
		dlg.setInitialSelections(convertToNullObject(elements));
	}
}