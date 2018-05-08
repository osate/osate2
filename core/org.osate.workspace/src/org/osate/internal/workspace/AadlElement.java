/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Carnegie Mellon University - adapted for use in OSATE
 *******************************************************************************/
package org.osate.internal.workspace;

import org.eclipse.core.runtime.PlatformObject;
import org.osate.workspace.AadlModelException;
import org.osate.workspace.IAadlElement;
import org.osate.workspace.IAadlProject;

/**
 * @author lwrage TODO To change the template for this generated type comment go
 *         to Window - Preferences - Java - Code Style - Code Templates
 */
public class AadlElement extends PlatformObject implements IAadlElement {

	/**
	 * This element's parent, or <code>null</code> if this element does not have
	 * a parent.
	 */
	protected AadlElement parent;

	/**
	 * This element's name, or an empty <code>String</code> if this element does
	 * not have a name.
	 */
	protected String name;

	protected static final AadlElement[] NO_ELEMENTS = new AadlElement[0];

	/**
	 * Constructs a handle for an AADL element with the given parent element and
	 * name.
	 *
	 * @param parent The parent of this AADL element
	 * @param name The name of this AADL element
	 * @exception IllegalArgumentException if the type is not one of the valid
	 *                Java element type constants
	 */
	protected AadlElement(AadlElement parent, String name) throws IllegalArgumentException {
		this.parent = parent;
		this.name = name;
	}

	/**
	 * @return Returns the name.
	 */
	public String getElementName() {
		return name;
	}

	/**
	 * @return Returns the parent.
	 */
	@Override
	public IAadlElement getParent() {
		return parent;
	}

	/**
	 * @see IAadlElement
	 */
	@Override
	public IAadlProject getAadlProject() {
		IAadlElement current = this;
		do {
			if (current instanceof IAadlProject) {
				return (IAadlProject) current;
			}
		} while ((current = current.getParent()) != null);
		return null;
	}

	/**
	 * @see org.osate.workspace.IParent
	 */
	public boolean hasChildren() throws AadlModelException {
		// if I am not open, return true to avoid opening (case of a Java project, a compilation unit or a class file).
		// also see https://bugs.eclipse.org/bugs/show_bug.cgi?id=52474
//		Object elementInfo = JavaModelManager.getJavaModelManager().getInfo(this);
//		if (elementInfo instanceof JavaElementInfo) {
//			return ((JavaElementInfo)elementInfo).getChildren().length > 0;
//		} else {
		return true;
//		}
	}

	/**
	 * @see org.osate.workspace.IParent
	 */
	public IAadlElement[] getChildren() throws AadlModelException {
//		Object elementInfo = getElementInfo();
//		if (elementInfo instanceof JavaElementInfo) {
//			return ((JavaElementInfo)elementInfo).getChildren();
//		} else {
		return NO_ELEMENTS;
//		}
	}
}