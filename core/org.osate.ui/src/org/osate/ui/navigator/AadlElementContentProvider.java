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
package org.osate.ui.navigator;

import java.util.stream.Stream;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierFeature;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.modelsupport.EObjectURIWrapper;
import org.osate.xtext.aadl2.ui.resource.ContributedAadlStorage;

public class AadlElementContentProvider implements ITreeContentProvider {
	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		Stream<EObject> children;
		if (parentElement instanceof IFile) {
			String path = ((IFile) parentElement).getFullPath().toString();
			URI uri = URI.createPlatformResourceURI(path, true);
			Resource resource = new ResourceSetImpl().getResource(uri, true);
			children = resource.getContents().stream();
		} else if (parentElement instanceof ContributedAadlStorage) {
			URI uri = ((ContributedAadlStorage) parentElement).getUri();
			Resource resource = new ResourceSetImpl().getResource(uri, true);
			children = resource.getContents().stream();
		} else {
			EObjectURIWrapper wrapper = (EObjectURIWrapper) parentElement;
			EObject eObject = new ResourceSetImpl().getEObject(wrapper.getUri(), true);
			if (eObject instanceof AadlPackage || eObject instanceof PropertySet
					|| eObject instanceof ComponentInstance) {
				children = eObject.eContents().stream();
			} else if (eObject instanceof PackageSection) {
				children = eObject.eContents().stream()
						.filter(element -> element instanceof Classifier || element instanceof AnnexLibrary);
			} else if (eObject instanceof Classifier) {
				children = eObject.eContents().stream().filter(
						element -> element instanceof ClassifierFeature || element instanceof PropertyAssociation);
			} else {
				children = Stream.empty();
			}
		}
		return children.map(element -> new EObjectURIWrapper(element)).toArray();
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof EObjectURIWrapper) {
			return new ResourceSetImpl().getEObject(((EObjectURIWrapper) element).getUri(), true).eContainer();
		} else {
			return null;
		}
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof IFile || element instanceof ContributedAadlStorage) {
			return true;
		} else {
			EObjectURIWrapper wrapper = (EObjectURIWrapper) element;
			EObject eObject = new ResourceSetImpl().getEObject(wrapper.getUri(), true);
			if (eObject instanceof AadlPackage || eObject instanceof PropertySet
					|| eObject instanceof ComponentInstance) {
				return !eObject.eContents().isEmpty();
			} else if (eObject instanceof PackageSection) {
				return eObject.eContents().stream()
						.anyMatch(member -> member instanceof Classifier || member instanceof AnnexLibrary);
			} else if (eObject instanceof Classifier) {
				return eObject.eContents().stream().anyMatch(
						member -> member instanceof ClassifierFeature || member instanceof PropertyAssociation);
			} else {
				return false;
			}
		}
	}
}