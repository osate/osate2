/*******************************************************************************
 * Copyright (C) 2015 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.osate.ge.internal.patterns;

import javax.inject.Inject;

import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ColoringService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.GhostingService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.StyleService;
import org.osate.ge.internal.styles.StyleConstants;

public class SubprogramCallOrderPattern extends AgeConnectionPattern {
	private final StyleService styleUtil;

	@Inject
	public SubprogramCallOrderPattern(final ColoringService coloringService, final GhostingService ghostingService, final StyleService styleUtil, 
			final ConnectionService connectionService, final PropertyService propertyService, final BusinessObjectResolutionService bor) {
		super(coloringService, ghostingService, connectionService, propertyService, bor);
		this.styleUtil = styleUtil;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		return AadlElementWrapper.unwrap(mainBusinessObject) instanceof SubprogramCallOrder;
	}

	@Override
	public boolean isPaletteApplicable() {
		return false;
	}
	
	@Override
	protected void createDecorators(final Connection connection) {
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
		connection.getConnectionDecorators().clear();
		
		// Create the arrow
        final ConnectionDecorator arrowConnectionDecorator = peCreateService.createConnectionDecorator(connection, false, 1.0, true);    
        createArrow(arrowConnectionDecorator, styleUtil.getStyle(StyleConstants.DECORATOR_STYLE));	
	}
	
	@Override
	protected void createGraphicsAlgorithm(final Connection connection) {
		final IGaService gaService = Graphiti.getGaService();
		final Polyline polyline = gaService.createPlainPolyline(connection);
		final Style style = getSubprogramCallOrderStyle();
		polyline.setStyle(style);
	}
	
	private Style getSubprogramCallOrderStyle() {
		return styleUtil.getStyle("subprogram_call_order");
    }

	private GraphicsAlgorithm createArrow(final GraphicsAlgorithmContainer gaContainer, final Style style) {
	    final IGaService gaService = Graphiti.getGaService();
	    final GraphicsAlgorithm ga = gaService.createPlainPolyline(gaContainer, new int[] {
	    		-12, 8, 
	    		2, 0, 
	    		-12, -8});
	    ga.setStyle(style);
	    
	    return ga;
	}
}
