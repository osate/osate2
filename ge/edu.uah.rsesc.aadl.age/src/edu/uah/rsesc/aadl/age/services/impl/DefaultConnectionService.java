/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package edu.uah.rsesc.aadl.age.services.impl;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import edu.uah.rsesc.aadl.age.diagrams.common.connections.AadlConnectionInfoProvider;
import edu.uah.rsesc.aadl.age.diagrams.common.connections.ConnectionInfoProvider;
import edu.uah.rsesc.aadl.age.diagrams.common.connections.FlowSpecificationInfoProvider;
import edu.uah.rsesc.aadl.age.diagrams.common.connections.GeneralizationInfoProvider;
import edu.uah.rsesc.aadl.age.diagrams.common.connections.ModeTransitionInfoProvider;
import edu.uah.rsesc.aadl.age.services.AnchorService;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.ConnectionService;
import edu.uah.rsesc.aadl.age.services.ShapeService;

//TODO:Split class so that one will be the utility class and one will be the delegate to the extensions
public class DefaultConnectionService implements ConnectionService {	
	private final ConnectionInfoProvider[] infoProviders;
	private final BusinessObjectResolutionService bor;
	private final IFeatureProvider fp;
	
	public DefaultConnectionService(final AnchorService anchorUtil, final ShapeService shapeHelper, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		this.bor = bor;
		this.fp = fp;
		
		// TODO: Use extension point or something
		final Diagram diagram = getDiagram();
		infoProviders = new ConnectionInfoProvider[] {
				new AadlConnectionInfoProvider(bor, diagram, anchorUtil, shapeHelper),
				new FlowSpecificationInfoProvider(bor, diagram, anchorUtil, shapeHelper),
				new GeneralizationInfoProvider(bor, diagram, shapeHelper),
				new ModeTransitionInfoProvider(bor, diagram, anchorUtil, shapeHelper)
		};
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ConnectionService#getConnection(org.eclipse.graphiti.mm.pictograms.ContainerShape, java.lang.Object)
	 */
	@Override
	public Connection getConnection(final ContainerShape ownerShape, final Object bo) {
		// Find all connections that match the anchors
		final Diagram diagram = getDiagram();
		for(final Connection c : diagram.getConnections()) {
			if(getOwnerShape(c) == ownerShape && bor.getBusinessObjectForPictogramElement(c) == bo) {
				return c;
			}
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ConnectionService#getAnchors(org.eclipse.graphiti.mm.pictograms.ContainerShape, java.lang.Object)
	 */
	@Override
	public Anchor[] getAnchors(final ContainerShape ownerShape, final Object bo) {
		final ConnectionInfoProvider p = getInfoProvider(bo);
		if(p != null) {
			return p.getAnchors(ownerShape, bo);
		}

		return null;
	}	
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ConnectionService#getOwnerShape(org.eclipse.graphiti.mm.pictograms.Connection)
	 */
	@Override
	public ContainerShape getOwnerShape(final Connection connection) {
		final ConnectionInfoProvider p = getInfoProvider(bor.getBusinessObjectForPictogramElement(connection));
		if(p != null) {
			return p.getOwnerShape(connection);
		}
		
		return null;
	}
	
	private ConnectionInfoProvider getInfoProvider(final Object bo) {
		for(final ConnectionInfoProvider p : infoProviders) {
			if(p.isBusinessObjectApplicable(bo)) {
				return p;
			}
		}
		
		return null;
	}
	
	private Diagram getDiagram() {
		return fp.getDiagramTypeProvider().getDiagram();
	}
}
