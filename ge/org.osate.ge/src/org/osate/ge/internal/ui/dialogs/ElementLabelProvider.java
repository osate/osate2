/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092
 *******************************************************************************/
package org.osate.ge.internal.ui.dialogs;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.NamedElement;

/**
 * A label provider that is designed to work for NamedElement and IEObjectDescription objects
 *
 */
public class ElementLabelProvider extends LabelProvider {
	private final Object nullObject;
	
	public ElementLabelProvider(final Object nullObject) {
		this.nullObject = nullObject;
	}
	
	public ElementLabelProvider() {
		this.nullObject = null;
	}
	
	@Override
	public String getText(final Object element) {
		if(element == nullObject) {
			return "<None>";
		} else if(element instanceof IEObjectDescription){
			return ((IEObjectDescription)element).getName().toString("::");
		} else if(element instanceof NamedElement){
			return ((NamedElement)element).getQualifiedName();
		} else {
			return element.toString();
		}				
	}
}
