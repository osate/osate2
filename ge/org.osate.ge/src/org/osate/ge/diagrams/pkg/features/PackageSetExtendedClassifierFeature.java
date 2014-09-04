/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.diagrams.pkg.features;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageSection;
import org.osate.ge.dialogs.ElementSelectionDialog;
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.AadlModificationService.AbstractModifier;
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval;

public class PackageSetExtendedClassifierFeature extends AbstractCustomFeature {
	private final BusinessObjectResolutionService bor;
	private final AadlModificationService modificationService;
	
	@Inject
	public PackageSetExtendedClassifierFeature(final IFeatureProvider fp, final BusinessObjectResolutionService bor, final AadlModificationService modificationService) {
		super(fp);
		this.bor = bor;
		this.modificationService = modificationService;
	}

	@Override
	public String getDescription() {
		return "Set the classifier that the classifier extends.";
	}

	@Override
	public String getName() {
		return "Set Extended Classifier...";
	}

	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}
	
	@Override
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		
		if(customCtx.getPictogramElements().length < 1) {
			return false;
		}
		final Object bo = bor.getBusinessObjectForPictogramElement(customCtx.getPictogramElements()[0]);	
		return bo instanceof ComponentType || bo instanceof ComponentImplementation || bo instanceof FeatureGroupType;		
	}
	
	@Override
	public boolean canExecute(final ICustomContext context) {
		if(context.getPictogramElements().length < 1) {
			return false;
		}
		
		final Object bo = bor.getBusinessObjectForPictogramElement(context.getPictogramElements()[0]);		
		return bo instanceof ComponentType || bo instanceof ComponentImplementation || bo instanceof FeatureGroupType;
	}
	
	@Override
	public void execute(final ICustomContext context) {
		final Classifier classifier = (Classifier)bor.getBusinessObjectForPictogramElement(context.getPictogramElements()[0]);
		
		// Prompt the user for the element
		final ElementSelectionDialog dlg = new ElementSelectionDialog(Display.getCurrent().getActiveShell(), "Select a Classifier", "Select a classifier to extend.", getExtensibleClassifierDescriptions(classifier));
		if(dlg.open() == Dialog.CANCEL) {
			return;
		}		
		
		// Make the modification
		modificationService.modify(classifier, new AbstractModifier<Classifier, Object>() {
			@Override
			public Object modify(final Resource resource, final Classifier classifier) {
				final AadlPackage pkg = (AadlPackage)resource.getContents().get(0);
				final PackageSection section = pkg.getPublicSection();
				
				// Resolve the selected classifier
				final Classifier selectedClassifier = (dlg.getFirstSelectedElement() != null && ((EObject)dlg.getFirstSelectedElement()).eIsProxy()) ? (Classifier)EcoreUtil.resolve(((EObject)dlg.getFirstSelectedElement()), resource) : (Classifier)dlg.getFirstSelectedElement();
				if(selectedClassifier == null) {
					return null;
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

				return null;
			}			
		});
	}
	
	/**
	 * Return a list of EObjectDescriptions for classifiers that could be extended.
	 * @return
	 */
	private List<IEObjectDescription> getExtensibleClassifierDescriptions(final NamedElement bo) {
		final List<IEObjectDescription> objectDescriptions = new ArrayList<IEObjectDescription>();
		final String name = bo.getQualifiedName();
		
		// Populate the list with valid classifier descriptions
		if(name != null) {		
			for(final IEObjectDescription desc : EMFIndexRetrieval.getAllClassifiersOfTypeInWorkspace(bo.eClass())) {
				if(!name.equalsIgnoreCase(desc.getName().toString("::"))) {
					objectDescriptions.add(desc);
				}
			}
			
			// Ensure that abstract classifiers are in the list
			if(bo instanceof ComponentType) {
				if(bo.eClass() != Aadl2Factory.eINSTANCE.getAadl2Package().getAbstractType()) {
					for(final IEObjectDescription desc : EMFIndexRetrieval.getAllClassifiersOfTypeInWorkspace(Aadl2Factory.eINSTANCE.getAadl2Package().getAbstractType())) {
						if(!name.equalsIgnoreCase(desc.getName().toString("::"))) {
							objectDescriptions.add(desc);
						}
					}
				}
			} else if(bo instanceof ComponentImplementation) {
					if(bo.eClass() != Aadl2Factory.eINSTANCE.getAadl2Package().getAbstractImplementation()) {
					for(final IEObjectDescription desc : EMFIndexRetrieval.getAllClassifiersOfTypeInWorkspace(Aadl2Factory.eINSTANCE.getAadl2Package().getAbstractImplementation())) {
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
