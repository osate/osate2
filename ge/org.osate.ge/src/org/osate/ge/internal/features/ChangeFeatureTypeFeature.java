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
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.DataSubcomponentType;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.ProcessorFeature;
import org.osate.ge.internal.businessObjectHandlers.AadlFeatureUtil;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.AadlModificationService.AbstractModifier;
import org.osate.ge.internal.util.StringUtil;

public class ChangeFeatureTypeFeature extends AbstractCustomFeature {
	private final AadlModificationService aadlModService;
	private final BusinessObjectResolutionService bor;
	private final EClass featureType;	
	
	@Inject
	public ChangeFeatureTypeFeature(final AadlModificationService aadlModService, final BusinessObjectResolutionService bor, 
			final IFeatureProvider fp, final @Named("Feature Type") EClass featureType) {
		super(fp);
		this.aadlModService = aadlModService;
		this.bor = bor;
		this.featureType = featureType;
	}

	@Override
    public String getName() {
        return "Convert to " + StringUtil.camelCaseToUser(featureType.getName());
    }
	
    @Override
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		final PictogramElement[] pes = customCtx.getPictogramElements();		
		if(customCtx.getPictogramElements().length < 1 || !(customCtx.getPictogramElements()[0] instanceof Shape)) {
			return false;
		}
		
		// Check that the shape represents a feature and that the feature is owned by the classifier represented by the shape's container, and that the classifier can
		// contain features of the type this feature changes features into.
		final PictogramElement pe = pes[0];		
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		final Object containerBo = bor.getBusinessObjectForPictogramElement(((Shape)pe).getContainer());
		
		if(!((bo instanceof Feature || bo instanceof InternalFeature || bo instanceof ProcessorFeature) && containerBo instanceof Classifier)) {
			return false;
		}
		
		final NamedElement feature = (NamedElement)bo;	
		return feature.getContainingClassifier() == containerBo && 
				AadlFeatureUtil.canOwnFeatureType(feature.getContainingClassifier(), featureType) &&
				(!(feature instanceof Feature) || (((Feature)feature).getRefined() == null || ((Feature)feature).getRefined() instanceof AbstractFeature));
	}   	
    
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}
    
    @Override
    public boolean canExecute(final ICustomContext context) {
    	// Only allow when the feature is owned by the container
    	final PictogramElement pe = context.getPictogramElements()[0];
    	final NamedElement feature = (NamedElement)bor.getBusinessObjectForPictogramElement(((Shape)pe));
		
		// Check that the feature is not already of the target type
    	return feature.eClass() != featureType;
    }
    
	@Override
	public void execute(final ICustomContext context) {
		final PictogramElement pe = context.getPictogramElements()[0];		
		final NamedElement feature = (NamedElement)bor.getBusinessObjectForPictogramElement(pe);
		aadlModService.modify(feature, new AbstractModifier<NamedElement, Object>() {
			@Override
			public Object modify(final Resource resource, final NamedElement featurec) {
				final Classifier featureOwner = feature.getContainingClassifier();
				final NamedElement replacementFeature = AadlFeatureUtil.createFeature(featureOwner, featureType);
				
				// Copy structural feature values to the replacement object.
				transferStructuralFeatureValues(feature, replacementFeature);
				
				// Handle copying the data feature classifier
				if(replacementFeature instanceof EventDataPort) {
					((EventDataPort) replacementFeature).setDataFeatureClassifier(getDataFeatureClassifier(feature));
				} else if(replacementFeature instanceof DataPort) {
					((DataPort) replacementFeature).setDataFeatureClassifier(getDataFeatureClassifier(feature));
				}
				
				// Remove the old object
				EcoreUtil.remove(feature);
				
				return null;
			}			
		});
	}
	
	private DataSubcomponentType getDataFeatureClassifier(final NamedElement feature) {
		if(feature instanceof EventDataPort) {
			return ((EventDataPort) feature).getDataFeatureClassifier();
		} else if(feature instanceof DataPort) {
			return ((DataPort) feature).getDataFeatureClassifier();
		}
		
		return null;
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
