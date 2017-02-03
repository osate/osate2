// Based on OSATE Graphical Editor. Modifications are: 
/*
Copyright (c) 2016, Rockwell Collins.
Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
including any software or models in source or binary form, as well as any drawings, specifications, 
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
*/
/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.patterns;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedHashMap;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Font;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AccessCategory;
import org.osate.aadl2.AccessConnection;
import org.osate.aadl2.AccessConnectionEnd;
import org.osate.aadl2.BusAccess;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.FeatureConnectionEnd;
import org.osate.aadl2.FeatureGroupConnectionEnd;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.ParameterConnectionEnd;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.PortConnectionEnd;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.patterns.AgeConnectionPattern;
import org.osate.ge.internal.Categorized;
import org.osate.ge.Categories;
import org.osate.ge.internal.services.AadlFeatureService;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.DiagramModificationService;
import org.osate.ge.internal.services.ColoringService;
import org.osate.ge.internal.services.GhostingService;
import org.osate.ge.internal.services.GraphicsAlgorithmCreationService;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.ShapeService;
import org.osate.ge.internal.services.StyleService;
import org.osate.ge.internal.services.UserInputService;
import org.osate.ge.internal.services.AadlModificationService.AbstractModifier;
import org.osate.ge.internal.styles.StyleConstants;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.internal.util.StringUtil;
import org.osate.xtext.aadl2.properties.util.CommunicationProperties;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;

public class ConnectionPattern extends AgeConnectionPattern implements Categorized {
	private static final String labelDecoratorName = "label";
	private static final String connectionPatternDecoratorName = "connection_pattern";
	private final AadlFeatureService featureService;
	private final StyleService styleUtil;
	private final BusinessObjectResolutionService bor;
	private final AadlModificationService aadlModService;
	private final NamingService namingService;
	private final DiagramModificationService diagramModService;
	private final ShapeService shapeService;
	private final UserInputService userInputService;
	private final PropertyService propertyService;
	private final GraphicsAlgorithmCreationService gaCreationService;
	private final EClass connectionType;
	private static LinkedHashMap<EClass, String> connectionTypeToMethodNameMap = new LinkedHashMap<EClass, String>();
	
	/**
	 * Populate the map that contains the connection type to create method name mapping
	 */
	static {
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();
		connectionTypeToMethodNameMap.put(p.getAccessConnection(), "createOwnedAccessConnection");
		connectionTypeToMethodNameMap.put(p.getFeatureConnection(), "createOwnedFeatureConnection");
		connectionTypeToMethodNameMap.put(p.getFeatureGroupConnection(), "createOwnedFeatureGroupConnection");
		connectionTypeToMethodNameMap.put(p.getParameterConnection(), "createOwnedParameterConnection");
		connectionTypeToMethodNameMap.put(p.getPortConnection(), "createOwnedPortConnection");
	}
	
	public static Collection<EClass> getConnectionTypes() {
		return connectionTypeToMethodNameMap.keySet();
	}
	
	@Inject
	public ConnectionPattern(final AadlFeatureService featureService, final GhostingService ghostingService, final StyleService styleUtil,final ColoringService coloringService, 
			final ConnectionService connectionHelper, final BusinessObjectResolutionService bor, AadlModificationService aadlModService, NamingService namingService,
			final DiagramModificationService diagramModService, final ShapeService shapeService, final UserInputService userInputService, final PropertyService propertyService,
			final GraphicsAlgorithmCreationService gaCreationService, final @Named("Connection Type") EClass connectionType) {
		super(coloringService, ghostingService, connectionHelper, propertyService, bor);
		this.featureService = featureService;
		this.styleUtil = styleUtil;
		this.bor = bor;
		this.aadlModService = aadlModService;
		this.namingService = namingService;
		this.connectionType = connectionType;
		this.diagramModService = diagramModService;
		this.shapeService = shapeService;
		this.userInputService = userInputService;		
		this.propertyService = propertyService;
		this.gaCreationService = gaCreationService;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		return connectionType.isInstance(AadlElementWrapper.unwrap(mainBusinessObject));
	}
	
	@Override
	public boolean isPaletteApplicable() {
		final Object diagramBo = bor.getBusinessObjectForPictogramElement(getDiagram());
		return diagramBo instanceof ComponentImplementation;
	}
	
	private org.osate.aadl2.Connection getAadlConnection(final Connection connection) {
		return (org.osate.aadl2.Connection)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(connection));
	}
	
	@Override
	protected void onAfterRefresh(final Connection connection) {
		updateAnchors(connection);
		super.onAfterRefresh(connection);
	}
	
	private void updateAnchors(final Connection connection) {
		connectionService.updateConnectionAnchor(connection);
	}
	
	@Override
	protected void createDecorators(final Connection connection) {
		final org.osate.aadl2.Connection aadlConnection = getAadlConnection(connection);
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
		if(aadlConnection == null) {
			connection.getConnectionDecorators().clear();
			return;
		}
		
		// Determine fonts and values for text decorators
		final Font decoratorFont = GraphitiUi.getGaService().manageDefaultFont(getDiagram());
		final String labelTxtValue = aadlConnection.getName();
		final String connectionPatternTxtValue = getConnectionPatterns(aadlConnection);
		int labelTxtWidth = GraphitiUi.getUiLayoutService().calculateTextSize(labelTxtValue, decoratorFont).getWidth();
		int connectionPatternTxtWidth = GraphitiUi.getUiLayoutService().calculateTextSize(connectionPatternTxtValue, decoratorFont).getWidth();
		
		// Before removing all the decorators, get position of the label(if one exists)
		int labelX = -labelTxtWidth/2;
		int labelY = -20;
		// Determine position of the label pattern
		for(final ConnectionDecorator d : connection.getConnectionDecorators()) {
			if(d.getGraphicsAlgorithm() instanceof Text) {
				final String name = propertyService.getName(d);
				if(name == null || labelDecoratorName.equals(name)) {
					final Text text = (Text)d.getGraphicsAlgorithm();
					labelX = text.getX();
					labelY = text.getY();
				}				
			}
		}
		
		// Determine position for the connection pattern decorator. Initial position is based on the label position
		int connectionPatternX = -connectionPatternTxtWidth/2;
		int connectionPatternY = labelY+30;
		for(final ConnectionDecorator d : connection.getConnectionDecorators()) {
			if(d.getGraphicsAlgorithm() instanceof Text) {
				if(connectionPatternDecoratorName.equals(propertyService.getName(d))) {
					final Text text = (Text)d.getGraphicsAlgorithm();
					connectionPatternX = text.getX();
					connectionPatternY = text.getY();
				}				
			}
		}
		
		connection.getConnectionDecorators().clear();		
			
		final boolean showImmediateDecoration;
		final boolean showDelayedDecoration;
		if(aadlConnection instanceof PortConnection) {
			final PortConnection pc = (PortConnection)aadlConnection;
			final EnumerationLiteral connectionTiming = GetProperties.getConnectionTiming(pc);
			if(connectionTiming.equals(GetProperties.getDelayedUnitLiteral(pc))) {
				showDelayedDecoration = true;
				showImmediateDecoration = false;
			} else if(connectionTiming.equals(GetProperties.getImmediateUnitLiteral(pc))) {
				showDelayedDecoration = false;
				showImmediateDecoration = true;
			} else {
			
				showImmediateDecoration = showDelayedDecoration = false;
			}
		} else {
			showImmediateDecoration = showDelayedDecoration = false;
		}
		
		// Show the direction indicator IF:
		// Connection is not bidirectional
		// Immediate Decoration is not being shown
		// One of the ports is not directional
		// Not Feature Group...
		final boolean showDirectionDecoration;
		if(!showImmediateDecoration && !aadlConnection.isBidirectional()) {
			final ConnectionEnd src = aadlConnection.getAllSource();
			final ConnectionEnd dst = aadlConnection.getAllDestination();
			if((src != null && src instanceof DirectedFeature && (((DirectedFeature)src).getDirection() == null || ((DirectedFeature)src).getDirection() == DirectionType.IN_OUT)) ||
			 (dst != null && dst instanceof DirectedFeature && (((DirectedFeature)dst).getDirection() == null || ((DirectedFeature)dst).getDirection() == DirectionType.IN_OUT))) {
				showDirectionDecoration = true;
			} else {
				showDirectionDecoration = false;
			}
		} else {
			showDirectionDecoration = false;
		}
		
		// Determine how much to shift the decorators incase multiple decorators will be displayed
		final int decoratorXShift = (showDelayedDecoration && showDirectionDecoration) ? 10 : 0;
		if(showDelayedDecoration) {
			final int delayedSpacing = 3;
			final ConnectionDecorator timingDecorator1 = peCreateService.createConnectionDecorator(connection, false, 0.5, true);
			gaCreationService.createDelayedIndicator(timingDecorator1, -delayedSpacing - decoratorXShift, styleUtil.getStyle(StyleConstants.DECORATOR_STYLE));
			final ConnectionDecorator timingDecorator2 = peCreateService.createConnectionDecorator(connection, false, 0.5, true);
			gaCreationService.createDelayedIndicator(timingDecorator2, delayedSpacing - decoratorXShift, styleUtil.getStyle(StyleConstants.DECORATOR_STYLE));
		} else if(showImmediateDecoration) {
			final int immediateSpacing = 5;
			final ConnectionDecorator timingDecorator1 = peCreateService.createConnectionDecorator(connection, false, 0.5, true);
			gaCreationService.createDirectionIndicator(timingDecorator1, -immediateSpacing, styleUtil.getStyle(StyleConstants.DECORATOR_STYLE));
			final ConnectionDecorator timingDecorator2 = peCreateService.createConnectionDecorator(connection, false, 0.5, true);
			gaCreationService.createDirectionIndicator(timingDecorator2, immediateSpacing, styleUtil.getStyle(StyleConstants.DECORATOR_STYLE));
		}

		// Draw a direction indicator
		if(showDirectionDecoration) {
	        final ConnectionDecorator directionDecorator = peCreateService.createConnectionDecorator(connection, false, 0.5, true);    
	        gaCreationService.createDirectionIndicator(directionDecorator, decoratorXShift, styleUtil.getStyle(StyleConstants.DECORATOR_STYLE));
		}
		
		// Create Label
		final IGaService gaService = Graphiti.getGaService();
		final ConnectionDecorator textDecorator = peCreateService.createConnectionDecorator(connection, true, 0.5, true);
		propertyService.setName(textDecorator, labelDecoratorName);
		final Text text = gaService.createDefaultText(getDiagram(), textDecorator);
		text.setStyle(styleUtil.getStyle(StyleConstants.LABEL_STYLE));
		gaService.setLocation(text, labelX, labelY);
	    text.setValue(labelTxtValue);
	    getFeatureProvider().link(textDecorator, new AadlElementWrapper(aadlConnection));
		
	    // Create Connection Pattern Label
		final ConnectionDecorator patternTxtDecorator = peCreateService.createConnectionDecorator(connection, true, 0.5, true);
		propertyService.setName(patternTxtDecorator, connectionPatternDecoratorName);
		final Text patternTxt = gaService.createDefaultText(getDiagram(), patternTxtDecorator);
		patternTxt.setStyle(styleUtil.getStyle(StyleConstants.LABEL_STYLE));
		patternTxt.setValue(connectionPatternTxtValue);
		gaService.setLocation(patternTxt, connectionPatternX, connectionPatternY);
	    getFeatureProvider().link(patternTxtDecorator, new AadlElementWrapper(aadlConnection));
	}
	
	/**
	 * Returns a string representation of the connection's connection patterns
	 * @param aadlConnection
	 * @return
	 */
	private String getConnectionPatterns(final org.osate.aadl2.Connection aadlConnection) {
		final Property cpProperty = GetProperties.lookupPropertyDefinition(aadlConnection, CommunicationProperties._NAME, "Connection_Pattern");
		String patterns = "";
		try {
			final ListValue cpValues = (ListValue)PropertyUtils.getSimplePropertyListValue(aadlConnection, cpProperty);
			patterns = StringUtil.join(cpValues.getOwnedListElements(), ",", new StringUtil.Converter<PropertyExpression, String>() {
				private final StringUtil.Converter<PropertyExpression, String> innerListConverter = new StringUtil.Converter<PropertyExpression, String>() {
					@Override
					public String convert(PropertyExpression input) {
						if(input instanceof NamedValue) {
							final Object v = ((NamedValue) input).getNamedValue();
							if(v instanceof EnumerationLiteral) {
								return ((EnumerationLiteral) v).getName();
							}
						}
						
						return "";
					}					
				};
				
				@Override
				public String convert(PropertyExpression input) {
					return "(" + StringUtil.join(((ListValue)input).getOwnedListElements(), ",", innerListConverter) + ")";
				}				
			});
		} catch (PropertyNotPresentException e) {
		}

		return patterns;
	}

	@Override
	protected void createGraphicsAlgorithm(final org.eclipse.graphiti.mm.pictograms.Connection connection) {
		final IGaService gaService = Graphiti.getGaService();
		final Polyline polyline = gaService.createPlainPolyline(connection);
		final Style style = styleUtil.getStyle(StyleConstants.DECORATOR_STYLE);
		polyline.setStyle(style);
	}

	private ConnectedElement getConnectedElementForShape(PictogramElement pe) {
		if(!(pe instanceof Shape) || propertyService.isTransient(pe)) {
			return null;
		}
		
		Shape shape = (Shape)pe;
		
		final ConnectedElement ce = Aadl2Factory.eINSTANCE.createConnectedElement();
		for(; shape != null; shape = shape.getContainer()) {
			if(!propertyService.isInnerShape(shape) && !propertyService.isTransient(pe)) {
				final Object bo = bor.getBusinessObjectForPictogramElement(shape);
				if(bo instanceof ConnectionEnd) {
					ce.setConnectionEnd((ConnectionEnd)bo);
					break;
				}			
			}
		}
		
		if(ce.getConnectionEnd() == null) {
			return null;
		}

		for(shape = shape.getContainer(); shape != null; shape = shape.getContainer()) {
			final Object bo = bor.getBusinessObjectForPictogramElement(shape);
			if(bo instanceof Context) {
				ce.setContext((Context)bo);
				break;
			}			
		}

		return ce;
	}
	
	@Override
	public boolean canDelete(final IDeleteContext context) {
		final Object bo = bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		if(!(bo instanceof org.osate.aadl2.Connection)) {
			return false;
		}
		
		final org.osate.aadl2.Connection aadlConnection = (org.osate.aadl2.Connection)bo;
		final Connection connection = (Connection)context.getPictogramElement();
		if(connection.getStart() == null) {
			return false; 
		}
		
		final AnchorContainer startContainer = connection.getStart().getParent();
		if(!(startContainer instanceof Shape)) {
			return false;
		}
		
		final ComponentImplementation ci = getComponentImplementation((Shape)startContainer);
		return aadlConnection.getContainingComponentImpl() == ci;
	}
	
	@Override
	public void delete(final IDeleteContext context) {
		if(!userInputService.confirmDelete(context)) {
			return;
		}
		
		// Make the modification
		final Connection connection = (Connection)context.getPictogramElement();
		final org.osate.aadl2.Connection aadlConnection = (org.osate.aadl2.Connection)bor.getBusinessObjectForPictogramElement(connection);
		aadlModService.modify(aadlConnection, new AbstractModifier<org.osate.aadl2.Connection, Object>() {
			private DiagramModificationService.Modification diagramMod;
			
			@Override
			public Object modify(final Resource resource, final org.osate.aadl2.Connection aadlConnection) {
				// Start the diagram modification
	 			diagramMod = diagramModService.startModification();	 			
	 			
	 			final AnchorContainer startContainer = connection.getStart().getParent();
	 			if(startContainer instanceof Shape) {
	 				diagramMod.markOpenRelatedDiagramsAsDirty(getComponentImplementation((Shape)startContainer));
	 			}	 			
	 			
	 			// Remove instead of delete. If there are any refines then there will be an error in the resulting AADL model. Refactoring would be ideal but may 
	 			// not always be what the user wants.
				//EcoreUtil.delete(aadlConnection);
	 			EcoreUtil.remove(aadlConnection);
				
				return null;
			}
			
	 		@Override
			public void beforeCommit(final Resource resource, final org.osate.aadl2.Connection aadlConnection, final Object modificationResult) {
				diagramMod.commit();
			}

		});	
		
		// Clear selection
		getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().selectPictogramElements(new PictogramElement[0]);
	}
	@Override
	public String getCreateImageId() { 
		return ImageHelper.getImage(connectionType.getName());
	}
	
	@Override
	public String getCreateName() {
		return StringUtil.camelCaseToUser(connectionType.getName());
	}
	
	@Override
	public boolean canStartConnection(final ICreateConnectionContext context) {
		// Get the connection elements for the source and destination
		final ConnectedElement srcConnectedElement = getConnectedElementForShape(context.getSourcePictogramElement());
		if(srcConnectedElement == null) {
			return false;
		}

		// Perform type specific connection start connection validity check
		final Class<?> connectionEndType = getConnectionEndType();
		if(connectionEndType == null || !connectionEndType.isInstance(srcConnectedElement.getConnectionEnd())) {
			return false;
		}
		
		final Context srcScContainer = shapeService.getClosestBusinessObjectOfType((Shape)context.getSourcePictogramElement(), Subcomponent.class, SubprogramCall.class);
		final ConnectionEnd srcConnectionEnd = srcConnectedElement.getConnectionEnd();
		if(srcConnectionEnd instanceof DirectedFeature) {
			final DirectionType direction = featureService.getFeatureDirection((Shape)context.getSourcePictogramElement(), (DirectedFeature)srcConnectionEnd);
			if((direction == DirectionType.OUT && srcScContainer == null) || (direction == DirectionType.IN && srcScContainer != null)) {
				return false;
			}
		}
		
		return true;
    }
	
	/**
	 * Retrieves the appropriate interface for connection ends for the current connection type
	 * @return
	 */
	private Class<?> getConnectionEndType() {
		final Class<?> connectionEndType;
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();
		if(connectionType == p.getAccessConnection()) {
			connectionEndType = AccessConnectionEnd.class;
		} else if(connectionType == p.getFeatureConnection()) {
			connectionEndType = FeatureConnectionEnd.class;
		} else if(connectionType == p.getFeatureGroupConnection()) {
			connectionEndType = FeatureGroupConnectionEnd.class;
		} else if(connectionType == p.getParameterConnection()) {
			connectionEndType = ParameterConnectionEnd.class;
		} else if(connectionType == p.getPortConnection()) {
			connectionEndType = PortConnectionEnd.class;
		} else {
			connectionEndType = null;
		}
		
		return connectionEndType;
	}
	
	@Override
	public boolean canCreate(final ICreateConnectionContext context) {
		if(context.getSourcePictogramElement() == null || context.getTargetPictogramElement() == null || 
				!(context.getSourcePictogramElement() instanceof Shape) || getComponentImplementation((Shape)context.getSourcePictogramElement()) == null) {
			return false;
		}
		
		// Get the connection elements for the source and destination
		final ConnectedElement srcConnectedElement = getConnectedElementForShape(context.getSourcePictogramElement());
		final ConnectedElement dstConnectedElement = getConnectedElementForShape(context.getTargetPictogramElement());
		
		// Ensure they are valid and are not the same
		if(dstConnectedElement == null || EcoreUtil.equals(srcConnectedElement, dstConnectedElement)) {
			return false;
		}

		final Class<?> connectionEndType = getConnectionEndType();
		if(connectionEndType == null || !connectionEndType.isInstance(dstConnectedElement.getConnectionEnd())) {
			return false;
		}
		
		final Context dstScContainer = shapeService.getClosestBusinessObjectOfType((Shape)context.getTargetPictogramElement(), Subcomponent.class, SubprogramCall.class);
		final ConnectionEnd dstConnectionEnd = dstConnectedElement.getConnectionEnd();
		if(dstConnectionEnd instanceof DirectedFeature) {
			final DirectionType direction = featureService.getFeatureDirection((Shape)context.getTargetPictogramElement(), (DirectedFeature)dstConnectionEnd);
			if((direction == DirectionType.IN && dstScContainer == null) || (direction == DirectionType.OUT && dstScContainer != null)) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public Connection create(final ICreateConnectionContext context) {
		// Get the Component Implementation
		final ComponentImplementation ci = getComponentImplementation((Shape)context.getSourcePictogramElement());
		
		// Determine the name for the new connection
		final String newConnectionName = namingService.buildUniqueIdentifier(ci, "new_connection");
		
		// Make the modification
		aadlModService.modify(ci, new AbstractModifier<ComponentImplementation, org.osate.aadl2.Connection>() {
			private DiagramModificationService.Modification diagramMod;
			
			@Override
			public org.osate.aadl2.Connection modify(final Resource resource, final ComponentImplementation ci) {
				// Create the appropriate type of connection object
				final org.osate.aadl2.Connection newAadlConnection = createConnection(ci, connectionType);
				if(newAadlConnection == null) {
					return null;
				}
				
				// Reset the no connections flag
				ci.setNoConnections(false);

				// Handle diagram updates
	 			diagramMod = diagramModService.startModification();
	 			diagramMod.markOpenRelatedDiagramsAsDirty(ci);
	 			
				// Set the name
				newAadlConnection.setName(newConnectionName);
				
				// Set the source and destination
				final ConnectedElement src = getConnectedElementForShape(context.getSourcePictogramElement());
				newAadlConnection.setSource(src);
				final ConnectedElement dst = getConnectedElementForShape(context.getTargetPictogramElement());
				newAadlConnection.setDestination(dst);
				
				// Set type of access connection
				if(newAadlConnection instanceof AccessConnection) {
					final AccessConnection ac = (AccessConnection)newAadlConnection;
					if(src.getConnectionEnd() instanceof SubprogramAccess || dst.getConnectionEnd() instanceof SubprogramAccess) {
						ac.setAccessCategory(AccessCategory.SUBPROGRAM);
					} else if(src.getConnectionEnd() instanceof SubprogramGroupAccess || dst.getConnectionEnd() instanceof SubprogramGroupAccess) {
						ac.setAccessCategory(AccessCategory.SUBPROGRAM_GROUP);
					} else if(src.getConnectionEnd() instanceof BusAccess || dst.getConnectionEnd() instanceof BusAccess) {
						ac.setAccessCategory(AccessCategory.BUS);
					} else if(src.getConnectionEnd() instanceof DataAccess || dst.getConnectionEnd() instanceof DataAccess) {
						ac.setAccessCategory(AccessCategory.DATA);
					}
				}
				
				return newAadlConnection;
			}
			
			@Override
			public void beforeCommit(final Resource resource, final ComponentImplementation ci, final org.osate.aadl2.Connection newAadlConnection) {
				diagramMod.commit();
			}
		});
		
		return null;
	}
	
	/**
	 * Returns the first component implementation associated with the specified or a containing shape.
	 * @param shape
	 * @return
	 */
	private ComponentImplementation getComponentImplementation(final Shape shape) {
		return shapeService.getClosestBusinessObjectOfType(shape, ComponentImplementation.class);
	}
	
	private static Method getConnectionCreateMethod(final ComponentImplementation ci, final EClass connectionType) {
		// Determine the method name for the type of feature
		final String methodName = connectionTypeToMethodNameMap.get(connectionType);
		if(methodName == null) {
			return null;
		}
		
		// Get the method
		try {
			final Method method = ci.getClass().getMethod(methodName);
			return method;
		} catch(final Exception ex) {
			return null;
		}
	}
	
	public static org.osate.aadl2.Connection createConnection(final ComponentImplementation ci, final EClass connectionClass) {
		try {
			return (org.osate.aadl2.Connection)getConnectionCreateMethod(ci, connectionClass).invoke(ci);
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String getCategory() {
		return Categories.CONNECTIONS;
	}
}
