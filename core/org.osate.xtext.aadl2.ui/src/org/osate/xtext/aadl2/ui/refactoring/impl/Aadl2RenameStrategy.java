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
		endNameRegions = new ArrayList<ITextRegion>();
		if (super.initialize(targetElement, context)) {
			ITextRegion region = ((Aadl2LocationInFile) locationInFileProvider).getSecondaryTextRegion(targetElement,
					!(targetElement instanceof ComponentImplementation));
			if (region != null && targetElement instanceof ComponentType) {
				endNameRegions.add(region);
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
