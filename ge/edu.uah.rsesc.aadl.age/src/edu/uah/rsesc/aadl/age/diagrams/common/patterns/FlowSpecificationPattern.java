/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package edu.uah.rsesc.aadl.age.diagrams.common.patterns;

import javax.inject.Inject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.FlowSpecification;
import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.services.AadlModificationService;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.ConnectionService;
import edu.uah.rsesc.aadl.age.services.DiagramModificationService;
import edu.uah.rsesc.aadl.age.services.GraphicsAlgorithmManipulationService;
import edu.uah.rsesc.aadl.age.services.HighlightingService;
import edu.uah.rsesc.aadl.age.services.ShapeService;
import edu.uah.rsesc.aadl.age.services.StyleService;
import edu.uah.rsesc.aadl.age.services.UserInputService;
import edu.uah.rsesc.aadl.age.services.VisibilityService;
import edu.uah.rsesc.aadl.age.services.AadlModificationService.AbstractModifier;

public class FlowSpecificationPattern extends AgeConnectionPattern {
	private final StyleService styleUtil;
	private final GraphicsAlgorithmManipulationService graphicsAlgorithmUtil;
	private final HighlightingService highlightingHelper;
	private final ConnectionService connectionHelper;
	private final ShapeService shapeService;
	private final AadlModificationService aadlModService;
	private final DiagramModificationService diagramModService;
	private final UserInputService userInputService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public FlowSpecificationPattern(final VisibilityService visibilityHelper, final StyleService styleUtil, final GraphicsAlgorithmManipulationService graphicsAlgorithmUtil, 
			final HighlightingService highlightingHelper, final ConnectionService connectionHelper, final ShapeService shapeService, AadlModificationService aadlModService, 
			final DiagramModificationService diagramModService, final UserInputService userInputService, final BusinessObjectResolutionService bor) {
		super(visibilityHelper);
		this.styleUtil = styleUtil;
		this.graphicsAlgorithmUtil = graphicsAlgorithmUtil;
		this.highlightingHelper = highlightingHelper;
		this.connectionHelper = connectionHelper;
		this.shapeService = shapeService;
		this.aadlModService = aadlModService;
		this.diagramModService = diagramModService;
		this.userInputService = userInputService;
		this.bor = bor;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		return AadlElementWrapper.unwrap(mainBusinessObject) instanceof FlowSpecification;
	}

	@Override
	protected void createDecorators(final Connection connection) {
		final FlowSpecification fs = getFlowSpecification(connection);
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
		// Before removing all the decorators, get position of the label(if one exists)
		int labelX = 5;
		int labelY = 10;
		for(final ConnectionDecorator d : connection.getConnectionDecorators()) {
			if(d.getGraphicsAlgorithm() instanceof Text) {
				final Text text = (Text)d.getGraphicsAlgorithm();
				labelX = text.getX();
				labelY = text.getY();
			}
		}
		
		connection.getConnectionDecorators().clear();
		
		switch(fs.getKind()) {
		case PATH:
			{
				// Create the arrow
		        final ConnectionDecorator arrowConnectionDecorator = peCreateService.createConnectionDecorator(connection, false, 1.0, true);    
		        createArrow(arrowConnectionDecorator, styleUtil.getDecoratorStyle());	
				break;
			}
			
		case SOURCE:
			{
				final ConnectionDecorator arrowConnectionDecorator = peCreateService.createConnectionDecorator(connection, false, 0.0, true);
				createArrow(arrowConnectionDecorator, styleUtil.getDecoratorStyle());
				final ConnectionDecorator vbarConnectionDecorator = peCreateService.createConnectionDecorator(connection, false, 1.0, true);
				createVbar(vbarConnectionDecorator, styleUtil.getDecoratorStyle());	
				break;
			}
			
		case SINK:
			{
				final ConnectionDecorator arrowConnectionDecorator = peCreateService.createConnectionDecorator(connection, false, 0.0, true);
				graphicsAlgorithmUtil.mirror(createArrow(arrowConnectionDecorator, styleUtil.getDecoratorStyle()));
				final ConnectionDecorator vbarConnectionDecorator = peCreateService.createConnectionDecorator(connection, false, 1.0, true);
				createVbar(vbarConnectionDecorator, styleUtil.getDecoratorStyle());	
				break;
			}
		}
		
		// Set color for the decorators
		for(final ConnectionDecorator cd : connection.getConnectionDecorators()) {
			highlightingHelper.highlight(fs, cd.getGraphicsAlgorithm());
		}
		
		// Create Label
		final IGaService gaService = Graphiti.getGaService();
		final ConnectionDecorator textDecorator = peCreateService.createConnectionDecorator(connection, true, 0.5, true);
		final Text text = gaService.createDefaultText(getDiagram(), textDecorator);
		text.setStyle(styleUtil.getLabelStyle());
		gaService.setLocation(text, labelX, labelY);
	    text.setValue(fs.getName());
	    getFeatureProvider().link(textDecorator, new AadlElementWrapper(fs));
	}
	
	@Override
	protected void createGraphicsAlgorithm(final Connection connection) {
		final FlowSpecification fs = getFlowSpecification(connection);
		final IGaService gaService = Graphiti.getGaService();
		final Polyline polyline = gaService.createPlainPolyline(connection);
		final Style style = styleUtil.getFlowSpecificationStyle();
		polyline.setStyle(style);
		highlightingHelper.highlight(fs, polyline);
	}
	
	private GraphicsAlgorithm createArrow(final GraphicsAlgorithmContainer gaContainer, final Style style) {
	    final IGaService gaService = Graphiti.getGaService();
	    final GraphicsAlgorithm ga = gaService.createPlainPolygon(gaContainer, new int[] {
	    		-6, 4, 
	    		2, 0, 
	    		-6, -4});
	    ga.setStyle(style);
	    return ga;
	}
	
	private GraphicsAlgorithm createVbar(final GraphicsAlgorithmContainer gaContainer, final Style style) {
	    final IGaService gaService = Graphiti.getGaService();
	    final GraphicsAlgorithm ga = gaService.createPlainPolyline(gaContainer, new int[] {
	    		0, 8,
	    		0, -8});
	    ga.setStyle(style);

	    return ga;
	}
	
	final FlowSpecification getFlowSpecification(final Connection connection) {
		return (FlowSpecification)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(connection));
	}
	
	@Override
	protected Anchor[] getAnchors(final Connection connection) {
		final FlowSpecification fs = getFlowSpecification(connection);
		final ContainerShape ownerShape = connectionHelper.getOwnerShape(connection);
		return (ownerShape == null) ? null : connectionHelper.getAnchors(ownerShape, fs);		
	}
	
	@Override
	public boolean canDelete(final IDeleteContext context) {
		final Object bo = bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		if(!(bo instanceof FlowSpecification)) {
			return false;
		}
		
		final FlowSpecification fs = (FlowSpecification)bo;
		final Connection connection = (Connection)context.getPictogramElement();
		if(connection.getStart() == null) {
			return false; 
		}
		
		final AnchorContainer startContainer = connection.getStart().getParent();
		if(!(startContainer instanceof Shape)) {
			return false;
		}
		
		final ComponentClassifier cc = getComponentClassifier((Shape)startContainer);
		return fs.getContainingClassifier() == cc;
	}
	
	@Override
	public void delete(final IDeleteContext context) {
		if(!userInputService.confirmDelete(context)) {
			return;
		}

		// Make the modification
		final Connection connection = (Connection)context.getPictogramElement();
		final FlowSpecification fs = (FlowSpecification)bor.getBusinessObjectForPictogramElement(connection);
		aadlModService.modify(fs, new AbstractModifier<FlowSpecification, Object>() {
			private DiagramModificationService.Modification diagramMod;
			
			@Override
			public Object modify(final Resource resource, final FlowSpecification fs) {
				// Start the diagram modification
	 			diagramMod = diagramModService.startModification();	 			
	 			
	 			// Mark other diagrams for updating
 				diagramMod.markRelatedDiagramsAsDirty(fs.getContainingClassifier());

	 			EcoreUtil.remove(fs);
				
				return null;
			}
			
	 		@Override
			public void beforeCommit(final Resource resource, final FlowSpecification fs, final Object modificationResult) {
				diagramMod.commit();
			}
		});	
		
		// Clear selection
		getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().selectPictogramElements(new PictogramElement[0]);
	}
	
	private ComponentClassifier getComponentClassifier(final Shape shape) {
		return shapeService.getClosestBusinessObjectOfType(shape, ComponentClassifier.class);
	}
}
