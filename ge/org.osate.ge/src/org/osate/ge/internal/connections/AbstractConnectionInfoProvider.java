/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.connections;

import java.util.List;

import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.osate.ge.internal.services.BusinessObjectResolutionService;

public abstract class AbstractConnectionInfoProvider implements ConnectionInfoProvider {
	private final BusinessObjectResolutionService bor;
	private final Diagram diagram;
	
	public AbstractConnectionInfoProvider(final BusinessObjectResolutionService bor, final Diagram diagram) {
		this.bor = bor;
		this.diagram = diagram;
	}

	protected final Object getBusinessObject(final Connection connection) {
		return this.getBusinessObjectResolver().getBusinessObjectForPictogramElement(connection);
	}

	protected final BusinessObjectResolutionService getBusinessObjectResolver() {
		return this.bor;
	}
	
	/**
	 * Returns all connections in the diagram
	 * @return
	 */
	protected final List<Connection> getConnections() {
		return this.diagram.getConnections();
	}
	
	@Override
	public boolean isApplicable(final Connection connection) {
		return isBusinessObjectApplicable(getBusinessObject(connection));
	}
}
