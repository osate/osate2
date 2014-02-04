/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package edu.uah.rsesc.aadl.age.diagrams.componentImplementation.features;

import javax.inject.Inject;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.ComponentImplementation;

import edu.uah.rsesc.aadl.age.dialogs.EditFlowsDialog;
import edu.uah.rsesc.aadl.age.services.AadlModificationService;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.PrototypeService;

public class EditFlowsFeature extends AbstractCustomFeature {
	private final PrototypeService prototypeService;
	private final AadlModificationService aadlModService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public EditFlowsFeature(final PrototypeService prototypeService, final AadlModificationService aadlModService, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		super(fp);
		this.prototypeService = prototypeService;
		this.aadlModService = aadlModService;
		this.bor = bor;
	}

	@Override
    public String getName() {
        return "Edit Flows...";
    }
	
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}
	
    @Override
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		final PictogramElement[] pes = customCtx.getPictogramElements();		
		if(customCtx.getPictogramElements().length < 1) {
			return false;
		}
		
		// Check that the shape represents a component implementation
		final PictogramElement pe = pes[0];		
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		return bo instanceof ComponentImplementation;
	}
    
    @Override
    public boolean canExecute(final ICustomContext context) {
    	return true;
    }
        
	@Override
	public void execute(final ICustomContext context) {
		final PictogramElement pe = context.getPictogramElements()[0];
		final ComponentImplementation ci = (ComponentImplementation)bor.getBusinessObjectForPictogramElement(pe);
		
		//ci.getAllEndToEndFlows()
		//ci.getAllFlowImplementations()

		// Show the edit flows dialog
		final EditFlowsDialog dlg = new EditFlowsDialog(Display.getCurrent().getActiveShell(), prototypeService, ci);
		if(dlg.open() == Dialog.CANCEL) {
			return;
		}
				
		/*
		// Prompt the user for the classifier
		final ElementSelectionDialog dlg = new ElementSelectionDialog(Display.getCurrent().getActiveShell(), "Select a Classifier", "Select a classifier.", getPotentialSubcomponentTypes(sc));
		if(dlg.open() == Dialog.CANCEL) {
			return;
		}

		// Set the classifier
		aadlModService.modify(sc, new AbstractModifier<Subcomponent, Object>() {
			@Override
			public Object modify(final Resource resource, final Subcomponent sc) {
				
				// Import the package if necessary
				SubcomponentType selectedSubcomponentType = (SubcomponentType)dlg.getFirstSelectedElement();
				if(selectedSubcomponentType != null) {
					// Resolve the reference
					selectedSubcomponentType = (SubcomponentType)EcoreUtil.resolve(selectedSubcomponentType, resource);
					
					// Import its package if necessary
					final AadlPackage pkg = (AadlPackage)sc.getElementRoot();
					if(selectedSubcomponentType instanceof ComponentClassifier && selectedSubcomponentType.getNamespace() != null && pkg != null) {
						final PackageSection section = pkg.getPublicSection();
						final AadlPackage selectedClassifierPkg = (AadlPackage)selectedSubcomponentType.getNamespace().getOwner();
						if(pkg != selectedClassifierPkg && !section.getImportedUnits().contains(selectedClassifierPkg)) {
							section.getImportedUnits().add(selectedClassifierPkg);
						}
					}
				}				
				
				// Set the classifier
				if(sc instanceof SystemSubcomponent) {
					((SystemSubcomponent)sc).setSystemSubcomponentType((SystemSubcomponentType)selectedSubcomponentType);
				} else if(sc instanceof AbstractSubcomponent) {
					((AbstractSubcomponent)sc).setAbstractSubcomponentType((AbstractSubcomponentType)selectedSubcomponentType);
				} else if(sc instanceof ThreadGroupSubcomponent) {
					((ThreadGroupSubcomponent)sc).setThreadGroupSubcomponentType((ThreadGroupSubcomponentType)selectedSubcomponentType);
				} else if(sc instanceof ThreadSubcomponent) {
					((ThreadSubcomponent)sc).setThreadSubcomponentType((ThreadSubcomponentType)selectedSubcomponentType);
				} else if(sc instanceof SubprogramSubcomponent) {
					((SubprogramSubcomponent)sc).setSubprogramSubcomponentType((SubprogramSubcomponentType)selectedSubcomponentType);
				} else if(sc instanceof SubprogramGroupSubcomponent) {
					((SubprogramGroupSubcomponent)sc).setSubprogramGroupSubcomponentType((SubprogramGroupSubcomponentType)selectedSubcomponentType);
				} else if(sc instanceof DataSubcomponent) {
					((DataSubcomponent)sc).setDataSubcomponentType((DataSubcomponentType)selectedSubcomponentType);
				} else if(sc instanceof AbstractSubcomponent) {
					((AbstractSubcomponent)sc).setAbstractSubcomponentType((AbstractSubcomponentType)selectedSubcomponentType);
				} else if(sc instanceof VirtualBusSubcomponent) {
					((VirtualBusSubcomponent)sc).setVirtualBusSubcomponentType((VirtualBusSubcomponentType)selectedSubcomponentType);
				} else if(sc instanceof BusSubcomponent) {
					((BusSubcomponent)sc).setBusSubcomponentType((BusSubcomponentType)selectedSubcomponentType);
				} else if(sc instanceof ProcessorSubcomponent) {
					((ProcessorSubcomponent)sc).setProcessorSubcomponentType((ProcessorSubcomponentType)selectedSubcomponentType);
				} else if(sc instanceof DeviceSubcomponent) {
					((DeviceSubcomponent)sc).setDeviceSubcomponentType((DeviceSubcomponentType)selectedSubcomponentType);
				} else if(sc instanceof MemorySubcomponent) {
					((MemorySubcomponent)sc).setMemorySubcomponentType((MemorySubcomponentType)selectedSubcomponentType);
				} else {
					throw new RuntimeException("Unexpected type: " + sc.getClass().getName());
				}
				
				return null;
			}			
		});
		*/
	}	
}
