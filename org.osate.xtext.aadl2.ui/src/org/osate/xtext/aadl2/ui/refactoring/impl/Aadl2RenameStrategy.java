package org.osate.xtext.aadl2.ui.refactoring.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategy;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringException;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.util.ITextRegion;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.xtext.aadl2.util.Aadl2LocationInFile;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class Aadl2RenameStrategy extends DefaultRenameStrategy {

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	protected ITextRegion secondaryNameRegion;

	@Override
	public boolean initialize(EObject targetElement, IRenameElementContext context) {
		if (super.initialize(targetElement, context)) {
			secondaryNameRegion = ((Aadl2LocationInFile) locationInFileProvider).getSecondaryTextRegion(targetElement,
					!(targetElement instanceof ComponentImplementation));
			return true;
		}
		return false;
	}

	@Override
	public void createDeclarationUpdates(String newName, ResourceSet resourceSet,
			IRefactoringUpdateAcceptor updateAcceptor) {
		super.createDeclarationUpdates(newName, resourceSet, updateAcceptor);
		if (secondaryNameRegion != null) {
			updateAcceptor.accept(getTargetElementOriginalURI().trimFragment(), getSecondaryTextEdit(newName));
		}
	}

	protected TextEdit getSecondaryTextEdit(String newName) {
		String text = newName;
		return new ReplaceEdit(secondaryNameRegion.getOffset(), secondaryNameRegion.getLength(), text);
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

}
