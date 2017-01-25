/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.patterns;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.PrecisionPoint;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.algorithms.styles.StylesFactory;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.CurvedConnection;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.ILayoutService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.ui.dialogs.ModeTransitionTriggerSelectionDialog;
import org.osate.ge.internal.ui.dialogs.ModeTransitionTriggerSelectionDialog.ModeTransitionTriggerInfo;
import org.osate.ge.internal.Categorized;
import org.osate.ge.Categories;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.AnchorService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ColoringService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.DiagramModificationService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.SerializableReferenceService;
import org.osate.ge.internal.services.ShapeService;
import org.osate.ge.internal.services.StyleService;
import org.osate.ge.internal.services.SubcomponentService;
import org.osate.ge.internal.services.UserInputService;
import org.osate.ge.internal.services.GhostingService;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.AadlModificationService.AbstractModifier;
import org.osate.ge.internal.styles.StyleConstants;
import org.osate.ge.internal.util.ImageHelper;

public class ModeTransitionPattern extends AgeConnectionPattern implements Categorized {
	public static String MODE_TRANSITION_TRIGGER_CONNECTION_TYPE = "mode_transition_trigger";
	private final StyleService styleService;
	private final AnchorService anchorService;
	private final NamingService namingService;
	private final ShapeService shapeService;
	private final AadlModificationService aadlModService;
	private final DiagramModificationService diagramModService;
	private final UserInputService userInputService;
	private final SerializableReferenceService referenceService;
	private final BusinessObjectResolutionService bor;
	private final PropertyService propertyService;
	private final SubcomponentService subcomponentService;
	
	@Inject
	public ModeTransitionPattern(final ColoringService coloringService, final GhostingService ghostingService, final StyleService styleUtil, final AnchorService anchorUtil, final NamingService namingService,
			final ConnectionService connectionHelper, final ShapeService shapeHelper, AadlModificationService aadlModService, final DiagramModificationService diagramModService,
			final UserInputService userInputService, final SerializableReferenceService referenceService, final BusinessObjectResolutionService bor, final PropertyService propertyService,
			final SubcomponentService subcomponentService) {
		super(coloringService, ghostingService, connectionHelper, propertyService, bor);
		this.styleService = styleUtil;
		this.anchorService = anchorUtil;
		this.namingService = namingService;
		this.shapeService = shapeHelper;
		this.aadlModService = aadlModService;
		this.diagramModService = diagramModService;
		this.userInputService = userInputService;
		this.referenceService = referenceService;
		this.bor = bor;
		this.propertyService = propertyService;
		this.subcomponentService = subcomponentService;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		return AadlElementWrapper.unwrap(mainBusinessObject) instanceof ModeTransition;
	}
	
	@Override
	public boolean isPaletteApplicable() {
		final Object diagramBo = bor.getBusinessObjectForPictogramElement(getDiagram());
		return diagramBo instanceof ComponentClassifier;
	}
	
	@Override
	public boolean canUpdate(final IUpdateContext context) {
		if(super.canUpdate(context)) {
			// Check that the mode transition is actually contained in the component classifier
			final ContainerShape ownerShape = connectionService.getOwnerShape((Connection)context.getPictogramElement());
			final Object ownerBo = bor.getBusinessObjectForPictogramElement(ownerShape);
			final ComponentClassifier cc;
			if(ownerBo instanceof Subcomponent) {
				cc = subcomponentService.getComponentClassifier(ownerShape, (Subcomponent)ownerBo);
			} else if(ownerBo instanceof ComponentClassifier) {
				cc = (ComponentClassifier)ownerBo;
			} else {
				cc = null;
			}
			if(cc == null) {
				return false;
			}
			
			return cc.getAllModeTransitions().contains(bor.getBusinessObjectForPictogramElement(context.getPictogramElement()));
		}
		
		return false;
	}

	/**
	 * Overridden to create a curved connection for the mode transition
	 */
	@Override
	protected Connection createConnection(final Diagram diagram) {
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		return peCreateService.createCurvedConnection(new double[] {0.0, 0.0}, getDiagram());
	}	

	public static void updateControlPoints(final Connection connection) {
		if(connection instanceof CurvedConnection) {
			final CurvedConnection cc = (CurvedConnection)connection;
			final ILayoutService layoutService = Graphiti.getLayoutService();			

			// Decide a sign for the control point
			final ILocation startLocation = layoutService.getLocationRelativeToDiagram(connection.getStart());
			final ILocation endLocation = layoutService.getLocationRelativeToDiagram(connection.getEnd());
			final int sign = (startLocation.getX() - endLocation.getX()) > 0 ? -1 : 1; 
			
			final int magnitude = 30;

			// Determine a reasonable control point
			int y = sign * magnitude;
			boolean unique = false;
			while(!unique) {
				unique = true;
				for(final Connection tempConnection : connection.getParent().getConnections()) {
					if(tempConnection != connection) {
						if(tempConnection instanceof CurvedConnection) {
							final CurvedConnection tempCC = (CurvedConnection)tempConnection;
							if(connection.getStart() == tempCC.getStart() && connection.getEnd() == tempCC.getEnd()) {
								if(tempCC.getControlPoints().get(0).getY() == y) {
									unique = false;
									y += sign * magnitude;
									break;
								}
							}
						}
					}
				}
			}
			
			// Set the control point
			cc.getControlPoints().clear();
			final PrecisionPoint pp = StylesFactory.eINSTANCE.createPrecisionPoint();
			pp.setX(1.0);
			pp.setY(y);
			cc.getControlPoints().add(pp);
		}
	}
	
	@Override
	protected void createDecorators(final Connection connection) {
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
		// Before removing all the decorators, get position of the label(if one exists)
		int labelX = 0;
		int labelY = 0;
		for(final ConnectionDecorator d : connection.getConnectionDecorators()) {
			if(d.getGraphicsAlgorithm() instanceof Text) {
				final Text text = (Text)d.getGraphicsAlgorithm();
				labelX = text.getX();
				labelY = text.getY();
			}
		}
		
		connection.getConnectionDecorators().clear();
		
		// Create the arrow
        final ConnectionDecorator arrowConnectionDecorator = peCreateService.createConnectionDecorator(connection, false, 1.0, true);    
        createArrow(arrowConnectionDecorator, styleService.getStyle(StyleConstants.DECORATOR_STYLE));
        
		// Create Label
        final ModeTransition mt = (ModeTransition)bor.getBusinessObjectForPictogramElement(connection);
        if(mt != null) {
	        final IGaService gaService = Graphiti.getGaService();
			final ConnectionDecorator textDecorator = peCreateService.createConnectionDecorator(connection, true, 0.5, true);
			final Text text = gaService.createDefaultText(getDiagram(), textDecorator);
			text.setStyle(styleService.getStyle(StyleConstants.LABEL_STYLE));
	 		gaService.setLocation(text, labelX, labelY);
		    text.setValue(mt.getName() == null ? "" : mt.getName());
		    getFeatureProvider().link(textDecorator, new AadlElementWrapper(mt));
        }
	}
	
	@Override
	protected void createGraphicsAlgorithm(final Connection connection) {
		updateControlPoints(connection);
		final IGaService gaService = Graphiti.getGaService();
		final Polyline polyline = gaService.createPlainPolyline(connection);
		final Style style = styleService.getStyle(StyleConstants.DECORATOR_STYLE);
		polyline.setStyle(style);
	}
	
	private void createTriggerGraphicsAlgorithm(final Connection connection) {
		final IGaService gaService = Graphiti.getGaService();
		final Polyline polyline = gaService.createPlainPolyline(connection);
		final Style style = styleService.getStyle(StyleConstants.MODE_TRANSITION_TRIGGER_STYLE);
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
	
	private static ContainerShape getModeContainer(final Connection connection) {
		return getStartModeShape(connection).getContainer();
	}

	// CLEAN-UP: Dependent on behavior of ModePattern to determine how many levels to go up
	private static ContainerShape getStartModeShape(final Connection connection) {
		return ((Shape)connection.getStart().getParent()).getContainer();
	}
	
	// Assume freeform and no bendpoints
	private static Point getConnectionMidpoint(final Connection connection, final double d) {
		final ILayoutService layoutService = Graphiti.getLayoutService();

		//final IGefService gefService = GraphitiUiInternal.getGefService();
		// Should be end point?
		final Shape startShape = (Shape)connection.getStart().getParent();
		final Shape endShape = (Shape)connection.getEnd().getParent();
		final ILocation startShapeLocation = layoutService.getLocationRelativeToDiagram(startShape);
		final ILocation endShapeLocation = layoutService.getLocationRelativeToDiagram(endShape);
		
		final GraphicsAlgorithm startShapeGa = startShape.getGraphicsAlgorithm();
		final GraphicsAlgorithm endShapeGa = endShape.getGraphicsAlgorithm();
		
		final Rectangle startShapeRect = new Rectangle(startShapeLocation.getX(), startShapeLocation.getY(), startShapeGa.getWidth(), startShapeGa.getHeight());
		final Rectangle endShapeRect = new Rectangle(endShapeLocation.getX(), endShapeLocation.getY(), endShapeGa.getWidth(), endShapeGa.getHeight());
		
		// Find a point on the the line
		if(connection instanceof CurvedConnection) {			
			final Point startPoint = new Point(startShapeLocation.getX() + startShapeRect.width/2, startShapeLocation.getY() + startShapeRect.height/2);
			final Point endPoint = new Point(endShapeLocation.getX() + endShapeRect.width/2, endShapeLocation.getY() + endShapeRect.height/2);
	
			final CurvedConnection cc = (CurvedConnection)connection;
			final BezierRouter router = new BezierRouter(cc.getControlPoints());
			final List<org.eclipse.draw2d.geometry.PrecisionPoint> altResults = router.route(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
			
			// Not technically the midpoint but in practice the point is a reasonable substitute
			final org.eclipse.draw2d.geometry.PrecisionPoint altPoint = altResults.get(altResults.size()/2-2);
			return new Point(altPoint.x, altPoint.y);
		}
		
		final ILocation startLoc = layoutService.getLocationRelativeToDiagram(connection.getStart());
		final ILocation endLoc = layoutService.getLocationRelativeToDiagram(connection.getEnd());
		
		// Need a method that will work with CurvedConnections
		return new Point((int)(startLoc.getX() + (endLoc.getX() - startLoc.getX()) * d), (int)(startLoc.getY() + (endLoc.getY() - startLoc.getY()) * d));
	}
	
	
	// Copied and adapted from: org.eclipse.graphiti.ui.internal.parts.CurvedConnectionEditPart.BezierRouter
	private static class BezierRouter {
		private List<PrecisionPoint> bezierPoints;

		public BezierRouter(List<PrecisionPoint> bezierPoints) {
			this.bezierPoints = bezierPoints;
		}

		public List<org.eclipse.draw2d.geometry.PrecisionPoint> route(final int startX, final int startY, final int endX, final int endY) {
			final List<org.eclipse.draw2d.geometry.PrecisionPoint> points = new ArrayList<org.eclipse.draw2d.geometry.PrecisionPoint>();
			List<org.eclipse.draw2d.geometry.PrecisionPoint> controllPoints = new ArrayList<org.eclipse.draw2d.geometry.PrecisionPoint>();
			org.eclipse.draw2d.geometry.PrecisionPoint start = new org.eclipse.draw2d.geometry.PrecisionPoint();
			org.eclipse.draw2d.geometry.PrecisionPoint end = new org.eclipse.draw2d.geometry.PrecisionPoint();
			start.setLocation(startX, startY);
			end.setLocation(endX, endY);
			controllPoints.add(start);
			double gradient = (end.preciseY() - start.preciseY()) / (-end.preciseX() + start.preciseX());
			double ortho_gradient = -Math.pow(gradient, -1);
			double orthovector_x = 1;
			double orthovector_y = ortho_gradient;
			double factor_to_length = 1 / Math.sqrt((Math.pow(orthovector_y, 2) + Math.pow(orthovector_x, 2)));
			for (PrecisionPoint precisionPoint : this.bezierPoints) {

				double orthovector_x_cp = factor_to_length * orthovector_x * precisionPoint.getY();
				double orthovector_y_cp = factor_to_length * orthovector_y * precisionPoint.getY();
				if (Double.isNaN(orthovector_x_cp)) {
					orthovector_x_cp = 0;
				}
				if (Double.isNaN(orthovector_y_cp)) {
					orthovector_y_cp = 1 * precisionPoint.getY();
				}
				org.eclipse.draw2d.geometry.PrecisionPoint anchor = new org.eclipse.draw2d.geometry.PrecisionPoint(
						(start.x + (end.x - start.x) * precisionPoint.getX() - orthovector_x_cp),
						(start.y - (start.y - end.y) * precisionPoint.getX()) + orthovector_y_cp);

				controllPoints.add(anchor);
			}
			controllPoints.add(end);
			int precision = 10;
			double factor = 1.0d / precision;
			points.add(start);
			for (int i = 1; i < precision; i++) {
				int j = 0;
				double sum_x = 0;
				double sum_y = 0;
				for (Point point : controllPoints) {
					sum_x += (bezier(j, controllPoints.size() - 1, i * factor) * point.preciseX());
					sum_y += (bezier(j, controllPoints.size() - 1, i * factor) * point.preciseY());
					j++;
				}
				org.eclipse.draw2d.geometry.PrecisionPoint bezierPoint = new org.eclipse.draw2d.geometry.PrecisionPoint(
						sum_x, sum_y);
				points.add(bezierPoint);
			}
			points.add(end);
			
			return points;
		}

		private double bezier(int i, int n, double t) {
			return binomialCoefficients(n, i) * Math.pow(t, i) * Math.pow((1 - t), (n - i));
		}

		private long binomialCoefficients(int n, int k) {
			long coeff = 1;
			for (int i = n - k + 1; i <= n; i++) {
				coeff *= i;
			}
			for (int i = 1; i <= k; i++) {
				coeff /= i;
			}
			return coeff;
		}
	}
	
	// CLEAN-UP: Should be private and not static. Develop another way for ModePattern to trigger updating of the anchors without causing issues
	public static void updateAnchors(final SerializableReferenceService referenceService, final Connection connection, final ModeTransition mt, final AnchorService anchorUtil) {
		final ILayoutService layoutService = Graphiti.getLayoutService();
		final ContainerShape modeShape = getStartModeShape(connection);
		final ILocation modeLocation = layoutService.getLocationRelativeToDiagram(modeShape);
		final Point l = getConnectionMidpoint(connection, 0.5);
		anchorUtil.createOrUpdateFixPointAnchor(modeShape, getTransitionAnchorName(referenceService, mt), l.x - modeLocation.getX(), l.y - modeLocation.getY());
	}
	
	private void updateTriggers(final Connection connection, final ModeTransition mt) {	
		if(mt != null) {
			updateAnchors(referenceService, connection, mt, anchorService);
	
			final ContainerShape modeShape = getStartModeShape(connection);
			final Anchor anchor = anchorService.getAnchorByName(modeShape, getTransitionAnchorName(referenceService, mt));
			for(final ModeTransitionTrigger trigger : mt.getOwnedTriggers()) {
				final ContainerShape modeTransitionContainer = getModeContainer(connection);	
				final Anchor eventSourceAnchor = getAnchorForModeTransitionTrigger(trigger, modeTransitionContainer, modeShape, getFeatureProvider());
				if(eventSourceAnchor != null) {
					final IPeCreateService peCreateService = Graphiti.getPeCreateService();
					final Connection triggerConnection = peCreateService.createFreeFormConnection(getDiagram());
					propertyService.setIsTransient(triggerConnection, true);
					propertyService.setConnectionType(triggerConnection, MODE_TRANSITION_TRIGGER_CONNECTION_TYPE);
					triggerConnection.setStart(eventSourceAnchor);
					triggerConnection.setEnd(anchor);
					createTriggerGraphicsAlgorithm(triggerConnection);
				}
			}
		}		
	}
	
	/**
	 * Builds a unique name for the anchor that will be used for the end of the trigger connection that connects it to the transition connection.
	 * @param trigger
	 * @return
	 */
	private static String getTransitionAnchorName(final SerializableReferenceService referenceService, final ModeTransition mt) {
		return mt == null ? "null_transition" : referenceService.getReference(mt);
	}

	@Override
	protected void onAfterRefresh(final Connection connection) {
		final ModeTransition mt = (ModeTransition)bor.getBusinessObjectForPictogramElement(connection);
		updateTriggers(connection, mt);
	}
	
	/**
	 * Returns the anchor for the feature references by a mode transition trigger
	 * @param trigger
	 * @param ownerShape the shape corresponding to the owner of the mode and mode transition. Should be a representation of Component Classifier.
	 * @param fp
	 * @return
	 */
	private Anchor getAnchorForModeTransitionTrigger(final ModeTransitionTrigger trigger, final ContainerShape ownerShape, final ContainerShape modeShape, final IFeatureProvider fp) {		
		// Get the shapes for the trigger port. 
		final ContainerShape portShapeOwner = trigger.getContext() == null ? ownerShape : (ContainerShape)shapeService.getChildShapeByElementName(ownerShape, trigger.getContext());
		final Shape portShape = (portShapeOwner == null || trigger.getTriggerPort() == null) ? null : shapeService.getDescendantShapeByElementName(portShapeOwner, trigger.getTriggerPort());

		if(portShape == null) {
			return null;
		}
		
		// Get appropriate anchor depending on whether the port belongs to the component classifier or a subcomponent
		//return anchorService.getAnchorByName(portShape, shapeService.doesShapeContain(portShape.getContainer(), modeShape) ? FeaturePattern.innerConnectorAnchorName : FeaturePattern.outerConnectorAnchorName);
		// TODO: Changed as part of migration
		return Graphiti.getPeService().getChopboxAnchor(portShape);
	}
	
	@Override
	public String getCreateImageId(){
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();
		return ImageHelper.getImage(p.getModeTransition().getName());
	}
	@Override
	public String getCreateName() {
		return "Mode Transition";
	}
	
	@Override
	public boolean canStartConnection(final ICreateConnectionContext context) {
		if(!(context.getSourcePictogramElement() instanceof Shape)) {
			return false;
		}
		
		final Shape shape = (Shape)context.getSourcePictogramElement();
		if(getMode(shape) == null) {
			return false;
		}
		final ComponentClassifier cc = getComponentClassifier(shape);
		if(cc == null) {
			return false;
		}
		
		return !cc.isDerivedModes();
    }
	
	private ComponentClassifier getComponentClassifier(final Shape modeShape) {
		return shapeService.getClosestBusinessObjectOfType(modeShape, ComponentClassifier.class);
	}

	private Mode getMode(final PictogramElement pe) {
		if(!(pe instanceof Shape)) {
			return null;
		}
		
		Shape shape = (Shape)pe;
		Object bo = null;
		while(shape != null && bo == null) {
			bo = bor.getBusinessObjectForPictogramElement(shape);
			
			if(bo == null) {
				if(propertyService.isInnerShape(shape)) {
					shape = shape.getContainer();
				}
			}
		}
			
		return bo instanceof Mode ? (Mode)bo : null;
	}
	
	@Override
	public boolean canCreate(final ICreateConnectionContext context) {
		return getMode(context.getTargetPictogramElement()) != null;
	}
	
	@Override
	public Connection create(final ICreateConnectionContext context) {
		// Get the Component Implementation
		final ComponentClassifier cc = getComponentClassifier((Shape)context.getSourcePictogramElement());
		
		// Determine the name for the new mode transition
		final String newElementName = namingService.buildUniqueIdentifier(cc, "new_transition");

		final ModeTransitionTriggerInfo[] selectedTriggers = ModeTransitionTriggerSelectionDialog.promptForTriggers(cc, null);
		if(selectedTriggers != null) {
			// Make the modification
			aadlModService.modify(cc, new AbstractModifier<ComponentClassifier, ModeTransition>() {
				private DiagramModificationService.Modification diagramMod;
				
				@Override
				public ModeTransition modify(final Resource resource, final ComponentClassifier cc) {
					final ModeTransition newModeTransition = cc.createOwnedModeTransition();
					
					// Clear the no modes flag
					cc.setNoModes(false);
					
					// Handle diagram updates
		 			diagramMod = diagramModService.startModification();
		 			diagramMod.markOpenRelatedDiagramsAsDirty(cc);
				
					// Set the name
		 			newModeTransition.setName(newElementName);
		 			
		 			// Set the source and destination
		 			newModeTransition.setSource(getMode(context.getSourcePictogramElement()));
		 			newModeTransition.setDestination(getMode(context.getTargetPictogramElement()));
		 			
		 			for(ModeTransitionTriggerInfo selectedPort : selectedTriggers) {
		 				final ModeTransitionTrigger mtt = newModeTransition.createOwnedTrigger();
		 				mtt.setTriggerPort(selectedPort.port);
		 				mtt.setContext(selectedPort.context);
		 			}
	
					return newModeTransition;
				}
				
				@Override
				public void beforeCommit(final Resource resource, final ComponentClassifier cc, final ModeTransition newModeTransition) {
					diagramMod.commit();
				}
			});
		}

		return null;
	}
	
	@Override
	public boolean canDelete(final IDeleteContext context) {
		final Object bo = bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		if(!(bo instanceof ModeTransition)) {
			return false;
		}
		
		final ModeTransition mt = (ModeTransition)bo;
		final Connection connection = (Connection)context.getPictogramElement();
		if(connection.getStart() == null) {
			return false; 
		}
		
		final AnchorContainer startContainer = connection.getStart().getParent();
		if(!(startContainer instanceof Shape)) {
			return false;
		}
		
		final ComponentClassifier cc = getComponentClassifier((Shape)startContainer);
		return mt.getContainingClassifier() == cc;
	}
	
	@Override
	public void delete(final IDeleteContext context) {
		if(!userInputService.confirmDelete(context)) {
			return;
		}

		// Make the modification
		final Connection connection = (Connection)context.getPictogramElement();
		final ModeTransition mt = (ModeTransition)bor.getBusinessObjectForPictogramElement(connection);
		aadlModService.modify(mt, new AbstractModifier<ModeTransition, Object>() {
			private DiagramModificationService.Modification diagramMod;
			
			@Override
			public Object modify(final Resource resource, final ModeTransition mt) {
				// Start the diagram modification
	 			diagramMod = diagramModService.startModification();	 			
	 			
	 			// Mark other diagrams for updating
 				diagramMod.markOpenRelatedDiagramsAsDirty(mt.getContainingClassifier());

	 			EcoreUtil.remove(mt);
				
				return null;
			}
			
	 		@Override
			public void beforeCommit(final Resource resource, final ModeTransition mt, final Object modificationResult) {
				diagramMod.commit();
			}

		});	
		
		// Clear selection
		getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().selectPictogramElements(new PictogramElement[0]);
	}

	@Override
	public String getCategory() {
		return Categories.MODES;
	}
}
