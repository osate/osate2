/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.features;

import javax.inject.Inject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ConnectedElement;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ShapeService;
import org.osate.ge.internal.services.AadlModificationService.AbstractModifier;

public class SwitchDirectionOfConnectionFeature extends AbstractCustomFeature {
	private final BusinessObjectResolutionService bor;
	private final AadlModificationService aadlModService;
	private final ShapeService shapeService;
		
	@Inject
	public SwitchDirectionOfConnectionFeature(final IFeatureProvider fp, final BusinessObjectResolutionService bor, 
			final AadlModificationService aadlModService, final ShapeService shapeService) {
		super(fp);
		this.bor = bor;
		this.aadlModService = aadlModService;
		this.shapeService = shapeService;
	}

	@Override
	public String getName() {
		return "Switch Direction";
	}
		
	@Override
	public String getDescription() {
		return "Swap the ends of the selected connection.";
	}

	@Override
	public boolean canExecute(final ICustomContext context) {
		return true;
	}

	@Override
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		final PictogramElement[] pes = customCtx.getPictogramElements();		
		if(customCtx.getPictogramElements().length < 1 || !(customCtx.getPictogramElements()[0] instanceof Connection)) {
			return false;
		}
		
		final Connection connection = (Connection)pes[0];		
		final Object bo = bor.getBusinessObjectForPictogramElement(connection);
		if(bo instanceof org.osate.aadl2.Connection) {
			final ComponentImplementation ci = getComponentImplementation(connection);			
			return ci != null && ((org.osate.aadl2.Connection)bo).getContainingClassifier() == ci && ((org.osate.aadl2.Connection)bo).getRefined() == null;
		}
		
		return false;
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
	public void execute(final ICustomContext context) {
		final PictogramElement[] pes = context.getPictogramElements();
		final PictogramElement pe = pes[0];
		final org.osate.aadl2.Connection connection = (org.osate.aadl2.Connection)bor.getBusinessObjectForPictogramElement(pe);
		// Make modifications			
		aadlModService.modify(connection, new AbstractModifier<org.osate.aadl2.Connection, Object>() {
			@Override
			public Object modify(final Resource resource, final org.osate.aadl2.Connection connection) {
				final ConnectedElement ceSource = connection.getSource();
				connection.setSource(connection.getDestination());
				connection.setDestination(ceSource);	
				return null;
			}
		});
	}
}


