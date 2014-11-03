/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.diagrams.common.features;

import javax.inject.Inject;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.NamingService;
import org.osate.ge.services.RefactoringService;

public class RenameModeTransitionFeature extends AbstractDirectEditingFeature {
	private final NamingService namingService;
	private final BusinessObjectResolutionService bor;
	private final RefactoringService refactoringService;
	
	@Inject
	public RenameModeTransitionFeature(final IFeatureProvider fp, final NamingService namingService, final BusinessObjectResolutionService bor, final RefactoringService refactoringService) {
		super(fp);
		this.namingService = namingService;
		this.bor = bor;
		this.refactoringService = refactoringService;
	}

	@Override
    public boolean canDirectEdit(final IDirectEditingContext context) {
		if(!(context.getPictogramElement() instanceof ConnectionDecorator)) {
			return false;
		}

		final Connection connection = ((ConnectionDecorator)context.getPictogramElement()).getConnection();		
		final Object bo = bor.getBusinessObjectForPictogramElement(connection);
		final Object diagramBo = bor.getBusinessObjectForPictogramElement(getDiagram());
		
		return bo instanceof ModeTransition && diagramBo != null && ((ModeTransition)bo).getContainingClassifier() == diagramBo;
	}
	
	@Override
	public int getEditingType() {
		return TYPE_TEXT;
	}
	
	@Override
	public boolean stretchFieldToFitText() {
		return true;
	}

    @Override
    public String checkValueValid(final String value, final IDirectEditingContext context) {
    	return namingService.checkNameValidity((NamedElement)bor.getBusinessObjectForPictogramElement(context.getPictogramElement()), value);
    }    
	
	@Override
	public String getInitialValue(final IDirectEditingContext context) {
		final ModeTransition mt = (ModeTransition)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		if(mt != null) {
			return mt.getName();
		}
		return "";
	}
	
	public void setValue(final String value, final IDirectEditingContext context) {
    	final ModeTransition mt = (ModeTransition)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
    	refactoringService.renameElement(mt, value);
    }
}
