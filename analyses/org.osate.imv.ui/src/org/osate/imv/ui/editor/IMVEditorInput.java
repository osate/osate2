/************************************************************************************
 * Copyright (c) 2012 Brandon Breuil. Contributions by Peter Feiler.                                               *
 *                                                                                  *
 * All rights reserved. This program and the accompanying materials are made        *
 * available under the terms of the Eclipse Public License v1.0 which accompanies   *
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html *
 *                                                                                  *
 * Use is subject to the terms of Eclipse Public License v1.0.                      *
 *                                                                                  *
 ************************************************************************************/

package org.osate.imv.ui.editor;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.instance.SystemInstance;

public class IMVEditorInput implements IEditorInput{
	// TODO this is not used anywhere

	// Constants.
	private static final String IMV_EXT = ".imv";

	private SystemInstance si;
	private AadlPackage pkg;
	private String name;

	public IMVEditorInput(SystemInstance si){
		super();
		// System instance should never be null.
		Assert.isNotNull(si);
		this.si = si;
		this.pkg = null;
		createName();
	}

	public IMVEditorInput(AadlPackage pkg){
		super();
		// System instance should never be null.
		Assert.isNotNull(pkg);
		this.si = null;
		this.pkg = pkg;
		createName();
	}

	public SystemInstance getSi() {
		return si;
	}

	public void setSi(SystemInstance si) {
		this.si = si;
	}

	@Override
	public Object getAdapter(Class adapter) {
		return null;
	}

	@Override
	public boolean exists() {
		return false;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	@Override
	public String getName() {
		return name;
	}

	private void createName(){
		if (si != null)
			this.name = si.getFullName() + IMV_EXT;
		if (pkg != null)
			this.name = pkg.getFullName() + IMV_EXT;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IMVEditorInput other = (IMVEditorInput) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public IPersistableElement getPersistable() {
		return null;
	}


	@Override
	public String getToolTipText() {
		return getName();
	}

}
