package org.osate.ge.internal.commands;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.PackageSection;
import org.osate.ge.di.Activate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.di.ModifiesBusinessObjects;
import org.osate.ge.internal.ui.dialogs.ElementSelectionDialog;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;

@ModifiesBusinessObjects
public class PackageSetExtendedClassifierCommand {
	@GetLabel
	public String getLabel() {
		return "Set Extended Classifier...";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final Classifier classifier) {
		return classifier instanceof ComponentType || classifier instanceof ComponentImplementation || classifier instanceof FeatureGroupType;
	}

	@Activate
	public boolean Activate(@Named(Names.BUSINESS_OBJECT) final Classifier classifier) {		
		// Prompt the user for the element
		final ElementSelectionDialog dlg = new ElementSelectionDialog(Display.getCurrent().getActiveShell(), "Select a Classifier", "Select a classifier to extend.", getExtensibleClassifierDescriptions(classifier));
		if(dlg.open() == Dialog.CANCEL) {
			return false;
		}		

		final AadlPackage pkg = (AadlPackage)classifier.eResource().getContents().get(0);
		final PackageSection section = pkg.getPublicSection();

		// Resolve the selected classifier
		final Classifier selectedClassifier = (dlg.getFirstSelectedElement() != null && ((EObject)dlg.getFirstSelectedElement()).eIsProxy()) ? (Classifier)EcoreUtil.resolve(((EObject)dlg.getFirstSelectedElement()), classifier.eResource()) : (Classifier)dlg.getFirstSelectedElement();
		if(selectedClassifier == null) {
			return false;
		}

		// Import the package if necessary
		if(selectedClassifier.getNamespace() != null) {
			final AadlPackage selectedClassifierPkg = (AadlPackage)selectedClassifier.getNamespace().getOwner();
			if(pkg != selectedClassifierPkg && !section.getImportedUnits().contains(selectedClassifierPkg)) {
				section.getImportedUnits().add(selectedClassifierPkg);
			}
		}

		// Extend the classifier
		if(classifier instanceof ComponentType) {
			((ComponentType)classifier).createOwnedExtension().setExtended((ComponentType)selectedClassifier);
		} else if(classifier instanceof ComponentImplementation) {
			((ComponentImplementation) classifier).createOwnedExtension().setExtended((ComponentImplementation)selectedClassifier);
		} else if(classifier instanceof FeatureGroupType) {
			((FeatureGroupType) classifier).createOwnedExtension().setExtended((FeatureGroupType)selectedClassifier);
		}

		return true;
	}			

	/**
	 * Return a list of EObjectDescriptions for classifiers that could be extended.
	 * @return
	 */
	private List<IEObjectDescription> getExtensibleClassifierDescriptions(final Classifier classifier) {
		final List<IEObjectDescription> objectDescriptions = new ArrayList<IEObjectDescription>();
		final String name = classifier.getQualifiedName();

		// Populate the list with valid classifier descriptions
		if(name != null) {		
			for(final IEObjectDescription desc : ScopedEMFIndexRetrieval.getAllEObjectsByType(classifier.eResource(), classifier.eClass())) {
				if(!name.equalsIgnoreCase(desc.getName().toString("::"))) {
					objectDescriptions.add(desc);
				}
			}

			// Ensure that abstract classifiers are in the list
			if(classifier instanceof ComponentType) {
				if(classifier.eClass() != Aadl2Factory.eINSTANCE.getAadl2Package().getAbstractType()) {
					for(final IEObjectDescription desc : ScopedEMFIndexRetrieval.getAllEObjectsByType(classifier.eResource(), Aadl2Factory.eINSTANCE.getAadl2Package().getAbstractType())) {
						if(!name.equalsIgnoreCase(desc.getName().toString("::"))) {
							objectDescriptions.add(desc);
						}
					}
				}
			} else if(classifier instanceof ComponentImplementation) {
				if(classifier.eClass() != Aadl2Factory.eINSTANCE.getAadl2Package().getAbstractImplementation()) {
					for(final IEObjectDescription desc : ScopedEMFIndexRetrieval.getAllEObjectsByType(classifier.eResource(), Aadl2Factory.eINSTANCE.getAadl2Package().getAbstractImplementation())) {
						if(!name.equalsIgnoreCase(desc.getName().toString("::"))) {
							objectDescriptions.add(desc);
						}
					}
				}
			}	
		}

		return objectDescriptions;
	}
}
