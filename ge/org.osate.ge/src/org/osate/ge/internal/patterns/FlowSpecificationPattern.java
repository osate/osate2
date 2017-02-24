/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.patterns;

import javax.inject.Inject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataType;
import org.osate.aadl2.DeviceType;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.Port;
import org.osate.aadl2.ProcessType;
import org.osate.aadl2.ProcessorType;
import org.osate.aadl2.SubprogramGroupType;
import org.osate.aadl2.SubprogramType;
import org.osate.aadl2.SystemType;
import org.osate.aadl2.ThreadGroupType;
import org.osate.aadl2.ThreadType;
import org.osate.aadl2.VirtualProcessorType;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.Categorized;
import org.osate.ge.internal.graphiti.graphics.AgeGraphitiGraphicsUtil;
import org.osate.ge.Categories;
import org.osate.ge.internal.services.AadlFeatureService;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.DiagramModificationService;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.ColoringService;
import org.osate.ge.internal.services.ShapeService;
import org.osate.ge.internal.services.StyleService;
import org.osate.ge.internal.services.UserInputService;
import org.osate.ge.internal.services.GhostingService;
import org.osate.ge.internal.services.AadlModificationService.AbstractModifier;
import org.osate.ge.internal.styles.StyleConstants;
import org.osate.ge.internal.util.ImageHelper;

public class FlowSpecificationPattern extends AgeConnectionPattern implements Categorized {
	private final StyleService styleUtil;
	private final ShapeService shapeService;
	private final AadlModificationService aadlModService;
	private final DiagramModificationService diagramModService;
	private final UserInputService userInputService;
	private final AadlFeatureService featureService;
	private final NamingService namingService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public FlowSpecificationPattern(final GhostingService ghostingService, final StyleService styleUtil, 
			final ColoringService coloringService, final ConnectionService connectionHelper, final ShapeService shapeService, AadlModificationService aadlModService, 
			final DiagramModificationService diagramModService, final UserInputService userInputService, final AadlFeatureService featureService, 
			final NamingService namingService, final PropertyService propertyService, final BusinessObjectResolutionService bor) {
		super(coloringService, ghostingService, connectionHelper, propertyService, bor);
		this.styleUtil = styleUtil;
		this.shapeService = shapeService;
		this.aadlModService = aadlModService;
		this.diagramModService = diagramModService;
		this.userInputService = userInputService;
		this.featureService = featureService;
		this.namingService = namingService;
		this.bor = bor;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		return AadlElementWrapper.unwrap(mainBusinessObject) instanceof FlowSpecification;
	}
	
	@Override
	public boolean isPaletteApplicable() {
		final Object diagramBo = bor.getBusinessObjectForPictogramElement(getDiagram());
		return diagramBo instanceof ThreadGroupType || 
				diagramBo instanceof ThreadType || 
				diagramBo instanceof VirtualProcessorType || 
				diagramBo instanceof ProcessType ||
				diagramBo instanceof DeviceType ||
				diagramBo instanceof AbstractType ||
				diagramBo instanceof ProcessorType ||
				diagramBo instanceof DataType ||
				diagramBo instanceof SystemType ||
				diagramBo instanceof SubprogramType ||
				diagramBo instanceof SubprogramGroupType;
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
		        createArrow(arrowConnectionDecorator, styleUtil.getStyle(StyleConstants.DECORATOR_STYLE));	
				break;
			}
			
		case SOURCE:
			{
				final ConnectionDecorator arrowConnectionDecorator = peCreateService.createConnectionDecorator(connection, false, 0.0, true);
				createArrow(arrowConnectionDecorator, styleUtil.getStyle(StyleConstants.DECORATOR_STYLE));
				final ConnectionDecorator vbarConnectionDecorator = peCreateService.createConnectionDecorator(connection, false, 1.0, true);
				createVbar(vbarConnectionDecorator, styleUtil.getStyle(StyleConstants.DECORATOR_STYLE));	
				break;
			}
			
		case SINK:
			{
				final ConnectionDecorator arrowConnectionDecorator = peCreateService.createConnectionDecorator(connection, false, 0.0, true);
				AgeGraphitiGraphicsUtil.mirror(createArrow(arrowConnectionDecorator, styleUtil.getStyle(StyleConstants.DECORATOR_STYLE)));
				final ConnectionDecorator vbarConnectionDecorator = peCreateService.createConnectionDecorator(connection, false, 1.0, true);
				createVbar(vbarConnectionDecorator, styleUtil.getStyle(StyleConstants.DECORATOR_STYLE));	
				break;
			}
		}
		
		// Create Label
		final IGaService gaService = Graphiti.getGaService();
		final ConnectionDecorator textDecorator = peCreateService.createConnectionDecorator(connection, true, 0.5, true);
		final Text text = gaService.createDefaultText(getDiagram(), textDecorator);
		text.setStyle(styleUtil.getStyle(StyleConstants.LABEL_STYLE));
		gaService.setLocation(text, labelX, labelY);
	    text.setValue(fs.getName());
	    getFeatureProvider().link(textDecorator, new AadlElementWrapper(fs));
	}
	
	@Override
	protected void createGraphicsAlgorithm(final Connection connection) {
		final IGaService gaService = Graphiti.getGaService();
		final Polyline polyline = gaService.createPlainPolyline(connection);
		final Style style = getFlowSpecificationStyle();
		polyline.setStyle(style);
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
 				diagramMod.markOpenRelatedDiagramsAsDirty(fs.getContainingClassifier());

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
	
	// Gets the first ComponentClassifier container for the shape
	private ComponentClassifier getComponentClassifier(final Shape shape) {
		return shapeService.getClosestBusinessObjectOfType(shape, ComponentClassifier.class);
	}	

	@Override
	public String getCategory() {
		return Categories.FLOWS;
	}
	
	private Style getFlowSpecificationStyle() {
		return styleUtil.getStyle("flow_specification");
    }
}
