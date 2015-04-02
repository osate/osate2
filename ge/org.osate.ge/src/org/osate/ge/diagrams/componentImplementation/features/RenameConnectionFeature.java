/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.diagrams.componentImplementation.features;

import javax.inject.Inject;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.NamedElement;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.NamingService;
import org.osate.ge.services.RefactoringService;
import org.osate.ge.services.ShapeService;

public class RenameConnectionFeature extends AbstractDirectEditingFeature {
	private final ShapeService shapeService;
	private final NamingService namingService;
	private final RefactoringService refactoringService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public RenameConnectionFeature(final IFeatureProvider fp, final ShapeService shapeService, final NamingService namingService, final RefactoringService refactoringService, final BusinessObjectResolutionService bor) {
		super(fp);
		this.shapeService = shapeService;
		this.namingService = namingService;
		this.refactoringService = refactoringService;
		this.bor = bor;
	}

	@Override
    public boolean canDirectEdit(final IDirectEditingContext context) {
		final Connection connection;
		if(context.getPictogramElement() instanceof Connection) {
			connection = (Connection)context.getPictogramElement();
		} else if(context.getPictogramElement() instanceof ConnectionDecorator) {
			connection = ((ConnectionDecorator)context.getPictogramElement()).getConnection();	
		} else {
			return false;
		}
		
		final Object bo = bor.getBusinessObjectForPictogramElement(connection);
		final ComponentImplementation ci = getComponentImplementation(connection);

		return bo instanceof org.osate.aadl2.Connection && ((org.osate.aadl2.Connection)bo).getRefined() == null && ci != null && ((org.osate.aadl2.Connection)bo).getContainingClassifier() == ci;
	}
    
	/**
	 * Returns the first component implementation associated with the specified or a containing shape.
	 * @param shape
	 * @return
	 */
	private ComponentImplementation getComponentImplementation(final Connection connection) {
		final AnchorContainer startContainer = connection.getStart().getParent();
		if(!(startContainer instanceof Shape)) {
			return null;
		}
		
		return shapeService.getClosestBusinessObjectOfType((Shape)startContainer, ComponentImplementation.class);
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
		final org.osate.aadl2.Connection connection = (org.osate.aadl2.Connection)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		if(connection != null) {
			return connection.getName();
		}
		return "";
	}
	
	public void setValue(final String value, final IDirectEditingContext context) {
    	final org.osate.aadl2.Connection aadlConnection = (org.osate.aadl2.Connection)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
    	refactoringService.renameElement(aadlConnection, value); 	
    }
}
