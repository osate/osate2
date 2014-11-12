/*******************************************************************************
 * Copyright (C) 2014 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.diagrams.common.connections;

import javax.inject.Inject;

import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.osate.aadl2.Mode;
import org.osate.ge.diagrams.common.patterns.ModePattern;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.PropertyService;

/**
 * Connection Info Provider for initial mode indicator connections. The connections are transient. They are recreated whenever the mode is updated. 
 * They are owned by the mode shape of the mode which is the initial mode.
 */
public class InitialModeConnectionInfoProvider extends AbstractConnectionInfoProvider {
	private final PropertyService propertyService;
	
	@Inject
	public InitialModeConnectionInfoProvider(final BusinessObjectResolutionService bor, final Diagram diagram, final PropertyService propertyService) {
		super(bor, diagram);
		this.propertyService = propertyService;
	}

	@Override
	public boolean isBusinessObjectApplicable(final Object bo) {
		return false;
	}

	@Override
	public boolean isApplicable(final Connection connection) {
		return ModePattern.INITIAL_MODE_CONNECTION_TYPE.equals(propertyService.getConnectionType(connection));
	}
	
	@Override
	public ContainerShape getOwnerShape(final Connection connection) {
		ContainerShape modeShape = getModeShape(connection.getStart());
		if(modeShape == null) {
			modeShape = getModeShape(connection.getEnd());
		}

		return modeShape;
	}
	
	private ContainerShape getModeShape(final Anchor anchor) {
		if(anchor != null) {
			final AnchorContainer parent = anchor.getParent();
			if(parent instanceof ContainerShape) {
				final ContainerShape parentContainer = ((ContainerShape) parent).getContainer();
				if(getBusinessObjectResolver().getBusinessObjectForPictogramElement(parentContainer) instanceof Mode) {
					return (ContainerShape)parentContainer;
				}
			}
		}
		
		return null;
	}
	
	@Override
	public Anchor[] getAnchors(final ContainerShape ownerShape, final Object bo) {
		// Not supported. Mode will recreate the intial mode connection on every update.
		return null;
	}
}
