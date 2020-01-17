/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.aadl2.modelsupport.resources;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.osate.aadl2.Element;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;

/* Author: Robert Coop
 * Adapted by Peter Feiler
 * Usage:	ModelUnit target = (ModelUnit)Platform.getAdapterManager().getAdapter(f, ModelUnit.class);
 * See: http://coopology.com/2011/06/easily-load-xtext-files-and-objects-in-eclipse-plugin-or-rcp-projects-using-adapters/
 */
@SuppressWarnings("rawtypes")
public class ModelLoadingAdapter implements IAdapterFactory {

	/**
	 * XXX: Notice - the methods dealing with EMF Index operations has been moved to the EMFIndexRetrieval Class in org.osate.xtext.aadl2.properties.util
	 */
	/*
	 * * Usage: ModelUnit target = (ModelUnit)Platform.getAdapterManager().getAdapter(f, ModelUnit.class);
	 */
	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adapterType == ModelUnit.class || adapterType == Element.class || adapterType == InstanceObject.class
				|| adapterType == SystemInstance.class) {

			if (adaptableObject instanceof ISelection) {
				final ISelection sel = (ISelection) adaptableObject;
				if (!(sel instanceof IStructuredSelection)) {
					return null;
				}
				final IStructuredSelection selection = (IStructuredSelection) sel;
				if (!(selection.getFirstElement() instanceof IFile)) {
					return null;
				}
				adaptableObject = selection.getFirstElement();
			}
			if (adaptableObject instanceof IFile) {
				final IFile file = (IFile) adaptableObject;
				String ext = file.getFileExtension();
				if (ext == null) {
					return null;
				}
				if (ext.toLowerCase().equals("aadl") || ext.toLowerCase().equals("aadl2")) {
					ModelUnit model;
					ResourceSet resourceSet = new ResourceSetImpl();
					String sp = file.getFullPath().toString();
					Resource resource = resourceSet.getResource(URI.createPlatformResourceURI(sp, false), true);
					if (!resource.getContents().isEmpty()) {
						model = (ModelUnit) resource.getContents().get(0);
					} else {
						model = null;
					}
					return model;
				} else if (ext.toLowerCase().equals("aaxl2")) {
					SystemInstance model;
					ResourceSet resourceSet = new ResourceSetImpl();
					String sp = file.getFullPath().toString();
					Resource resource = resourceSet.getResource(URI.createPlatformResourceURI(sp, false), true);

					if (!resource.getContents().isEmpty()) {
						model = (SystemInstance) resource.getContents().get(0);
					} else {
						model = null;
					}
					return model;
				}

			}
		}

		return null;
	}

	@Override
	public Class[] getAdapterList() {
		return new Class[] { Element.class };
	}

}