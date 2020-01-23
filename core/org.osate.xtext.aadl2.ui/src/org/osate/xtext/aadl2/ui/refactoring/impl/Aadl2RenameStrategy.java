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
package org.osate.xtext.aadl2.ui.refactoring.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategy;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringException;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.util.ITextRegion;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.xtext.aadl2.util.Aadl2LocationInFile;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class Aadl2RenameStrategy extends DefaultRenameStrategy {

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	protected List<ITextRegion> endNameRegions;

	@Override
	public boolean initialize(EObject targetElement, IRenameElementContext context) {
		endNameRegions = new ArrayList<>();
		if (super.initialize(targetElement, context)) {
			ITextRegion region = ((Aadl2LocationInFile) locationInFileProvider).getSecondaryTextRegion(targetElement,
					!(targetElement instanceof ComponentImplementation));
			if (region != null) {
				endNameRegions.add(region);
			}
			if (targetElement instanceof ComponentType) {
				AadlPackage pkg = EcoreUtil2.getContainerOfType(targetElement, AadlPackage.class);
				for (ComponentImplementation impl : EcoreUtil2.getAllContentsOfType(pkg,
						ComponentImplementation.class)) {
					if (impl.getType() == targetElement) {
						endNameRegions
								.add(((Aadl2LocationInFile) locationInFileProvider).getSecondaryTextRegion(impl, true));
					}
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public void createDeclarationUpdates(String newName, ResourceSet resourceSet,
			IRefactoringUpdateAcceptor updateAcceptor) {
		super.createDeclarationUpdates(newName, resourceSet, updateAcceptor);
		if (endNameRegions != null) {
			for (ITextRegion region : endNameRegions) {
				updateAcceptor.accept(getTargetElementOriginalURI().trimFragment(),
						getSecondaryTextEdit(region, newName));
			}
		}
	}

	protected TextEdit getSecondaryTextEdit(ITextRegion region, String newName) {
		String text = newName;
		return new ReplaceEdit(region.getOffset(), region.getLength(), text);
	}

	@Override
	protected EObject setName(URI targetElementURI, String newName, ResourceSet resourceSet) {
		EObject targetElement = super.setName(targetElementURI, newName, resourceSet);
		if (targetElement == null) {
			throw new RefactoringException("Target element not loaded.");
		}
		if (targetElement instanceof ComponentImplementation && !newName.contains(".")) {
			ComponentImplementation ci = (ComponentImplementation) targetElement;
			ComponentType ct = ci.getType();
			newName = ct.getName() + "." + newName;
			ci.setName(newName);
		}
		return targetElement;
	}

	@Override
	public void applyDeclarationChange(String newName, ResourceSet resourceSet) {
		// rename component implementations
		EObject targetElement = resourceSet.getEObject(getTargetElementOriginalURI(), false);
		if (targetElement instanceof ComponentType) {
			AadlPackage pkg = EcoreUtil2.getContainerOfType(targetElement, AadlPackage.class);
			for (ComponentImplementation impl : EcoreUtil2.getAllContentsOfType(pkg, ComponentImplementation.class)) {
				if (impl.getType() == targetElement) {
					impl.setName(newName + "." + impl.getImplementationName());
				}
			}
		}

		super.applyDeclarationChange(newName, resourceSet);
	}

	@Override
	public void revertDeclarationChange(ResourceSet resourceSet) {
		super.revertDeclarationChange(resourceSet);

		// rename component implementations
		EObject targetElement = resourceSet.getEObject(getTargetElementOriginalURI(), false);
		if (targetElement instanceof ComponentType) {
			String oldName = getTargetElementOriginalURI().fragment();
			oldName = oldName.substring(oldName.lastIndexOf('.') + 1);
			AadlPackage pkg = EcoreUtil2.getContainerOfType(targetElement, AadlPackage.class);
			for (ComponentImplementation impl : EcoreUtil2.getAllContentsOfType(pkg, ComponentImplementation.class)) {
				if (impl.getType() == targetElement) {
					impl.setName(oldName + "." + impl.getImplementationName());
				}
			}
		}
	}

}
