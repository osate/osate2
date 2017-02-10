/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.features;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.AbstractSubcomponent;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.AadlModificationService.AbstractModifier;
import org.osate.ge.internal.util.StringUtil;
import org.osate.ge.internal.util.SubcomponentUtil;

public class ChangeSubcomponentTypeFeature extends AbstractCustomFeature {
	private final AadlModificationService aadlModService;
	private final BusinessObjectResolutionService bor;
	private final EClass subcomponentType;	
	
	@Inject
	public ChangeSubcomponentTypeFeature(final AadlModificationService aadlModService, final BusinessObjectResolutionService bor, 
			final IFeatureProvider fp, final @Named("Subcomponent Type") EClass subcomponentType) {
		super(fp);
		this.aadlModService = aadlModService;
		this.bor = bor;
		this.subcomponentType = subcomponentType;
	}

	@Override
    public String getName() {
        return "Convert to " + StringUtil.camelCaseToUser(subcomponentType.getName());
    }
	
    @Override
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		final PictogramElement[] pes = customCtx.getPictogramElements();		
		if(customCtx.getPictogramElements().length < 1 || !(customCtx.getPictogramElements()[0] instanceof Shape)) {
			return false;
		}
		
		// Check that the shape represents a subcomponent and that the subcomponent is owned by the classifier represented by the shape's container, and that the classifier can
		// contain subcomponents of the type this feature changes subcomponents into.
		final PictogramElement pe = pes[0];		
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		final Object containerBo = bor.getBusinessObjectForPictogramElement(((Shape)pe).getContainer());
		
		if(!(bo instanceof Subcomponent && containerBo instanceof ComponentImplementation)) {
			return false;
		}
		
		final Subcomponent sc = (Subcomponent)bo;
		final ComponentImplementation ci = (ComponentImplementation)containerBo;		
		return sc.getContainingClassifier() == ci && 
				SubcomponentUtil.canContainSubcomponentType(ci, subcomponentType) &&
				(sc.getRefined() == null || sc.getRefined() instanceof AbstractSubcomponent);
	}   	
    
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}
    
    @Override
    public boolean canExecute(final ICustomContext context) {
    	// Only allow when the subcomponent is owned by the container
    	final PictogramElement pe = context.getPictogramElements()[0];
    	final Subcomponent sc = (Subcomponent)bor.getBusinessObjectForPictogramElement(((Shape)pe));
		
		// Check that the subcomponent is not already of the target type
    	return sc.eClass() != subcomponentType;
    }
    
	@Override
	public void execute(final ICustomContext context) {
		final PictogramElement pe = context.getPictogramElements()[0];		
		final Subcomponent sc = (Subcomponent)bor.getBusinessObjectForPictogramElement(pe);
		aadlModService.modify(sc, new AbstractModifier<Subcomponent, Object>() {
			@Override
			public Object modify(final Resource resource, final Subcomponent sc) {
				final ComponentImplementation ci = sc.getContainingComponentImpl();
				final Subcomponent replacementSc = SubcomponentUtil.createSubcomponent(ci, subcomponentType);
				
				// Copy structural feature values to the replacement object.
				transferStructuralFeatureValues(sc, replacementSc);
				
				// Remove the old object
				EcoreUtil.remove(sc);

				return null;
			}			
		});
	}
	
	/**
	 * Copies structural feature values from original to replacement. If replacement does not contain a matching structural feature, the value is ignored. If a feature is not set,
	 * its value is not copied over to the replacement.
	 * @param original
	 * @param replacement
	 */
	private void transferStructuralFeatureValues(final EObject original, final EObject replacement) {
		for(final EStructuralFeature feature : original.eClass().getEAllStructuralFeatures())	{
			if(feature.isChangeable() && !feature.isDerived()) {
				final Object originalValue = original.eGet(feature, true);						

				// Only copy values that are set
				if(original.eIsSet(feature)) {
					if(replacement.eClass().getEAllStructuralFeatures().contains(feature)) {
						if(feature.isMany()) {
							final @SuppressWarnings("unchecked") List<Object> originalList = (List<Object>)originalValue;
							final Object replacementValue = replacement.eGet(feature);
							final @SuppressWarnings("unchecked") List<Object> replacementList = (List<Object>)replacementValue;
							replacementList.addAll(originalList);					
						} else {
							replacement.eSet(feature, originalValue);
						}
					}
				}
			}
		}
	}	
}
