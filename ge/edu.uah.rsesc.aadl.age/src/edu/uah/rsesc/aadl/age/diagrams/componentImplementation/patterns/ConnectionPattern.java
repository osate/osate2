package edu.uah.rsesc.aadl.age.diagrams.componentImplementation.patterns;

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
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Access;
import org.osate.aadl2.AccessCategory;
import org.osate.aadl2.AccessConnection;
import org.osate.aadl2.AccessConnectionEnd;
import org.osate.aadl2.BusAccess;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureConnection;
import org.osate.aadl2.FeatureConnectionEnd;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupConnectionEnd;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.ParameterConnectionEnd;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.PortConnectionEnd;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.xtext.aadl2.properties.util.GetProperties;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.AgeConnectionPattern;
import edu.uah.rsesc.aadl.age.services.AadlModificationService;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.ConnectionService;
import edu.uah.rsesc.aadl.age.services.DiagramModificationService;
import edu.uah.rsesc.aadl.age.services.HighlightingService;
import edu.uah.rsesc.aadl.age.services.NamingService;
import edu.uah.rsesc.aadl.age.services.ShapeService;
import edu.uah.rsesc.aadl.age.services.StyleService;
import edu.uah.rsesc.aadl.age.services.UserInputService;
import edu.uah.rsesc.aadl.age.services.VisibilityService;
import edu.uah.rsesc.aadl.age.services.AadlModificationService.AbstractModifier;
import edu.uah.rsesc.aadl.age.util.StringUtil;

public class ConnectionPattern extends AgeConnectionPattern {
	private final StyleService styleUtil;
	private final HighlightingService highlightingHelper;
	private final ConnectionService connectionHelper;
	private final BusinessObjectResolutionService bor;
	private final AadlModificationService aadlModService;
	private final NamingService namingService;
	private final DiagramModificationService diagramModService;
	private final ShapeService shapeService;
	private final UserInputService userInputService;
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
	public ConnectionPattern(final VisibilityService visibilityHelper, final StyleService styleUtil,final HighlightingService highlightingHelper, 
			final ConnectionService connectionHelper, final BusinessObjectResolutionService bor, AadlModificationService aadlModService, NamingService namingService,
			final DiagramModificationService diagramModService, final ShapeService shapeService, final UserInputService userInputService, final @Named("Connection Type") EClass connectionType) {
		super(visibilityHelper);
		this.styleUtil = styleUtil;
		this.highlightingHelper = highlightingHelper;
		this.connectionHelper = connectionHelper;
		this.bor = bor;
		this.aadlModService = aadlModService;
		this.namingService = namingService;
		this.connectionType = connectionType;
		this.diagramModService = diagramModService;
		this.shapeService = shapeService;
		this.userInputService = userInputService;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		return connectionType.isInstance(AadlElementWrapper.unwrap(mainBusinessObject));
	}
	
	private org.osate.aadl2.Connection getAadlConnection(final Connection connection) {
		return (org.osate.aadl2.Connection)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(connection));
	}
	
	@Override
	protected void createDecorators(final Connection connection) {
		final org.osate.aadl2.Connection aadlConnection = getAadlConnection(connection);
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
		if(aadlConnection == null) {
			return;
		}
			
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
			createDelayedIndicator(timingDecorator1, -delayedSpacing - decoratorXShift, styleUtil.getDecoratorStyle());
			final ConnectionDecorator timingDecorator2 = peCreateService.createConnectionDecorator(connection, false, 0.5, true);
			createDelayedIndicator(timingDecorator2, delayedSpacing - decoratorXShift, styleUtil.getDecoratorStyle());
		} else if(showImmediateDecoration) {
			final int immediateSpacing = 5;
			final ConnectionDecorator timingDecorator1 = peCreateService.createConnectionDecorator(connection, false, 0.5, true);
			createDirectionIndicator(timingDecorator1, -immediateSpacing, styleUtil.getDecoratorStyle());
			final ConnectionDecorator timingDecorator2 = peCreateService.createConnectionDecorator(connection, false, 0.5, true);
			createDirectionIndicator(timingDecorator2, immediateSpacing, styleUtil.getDecoratorStyle());
		}

		// Draw a direction indicator
		if(showDirectionDecoration) {
	        final ConnectionDecorator directionDecorator = peCreateService.createConnectionDecorator(connection, false, 0.5, true);    
	        createDirectionIndicator(directionDecorator, decoratorXShift, styleUtil.getDecoratorStyle());
		}
		
		// Create Label
		final IGaService gaService = Graphiti.getGaService();
		final ConnectionDecorator textDecorator = peCreateService.createConnectionDecorator(connection, true, 0.5, true);
		final Text text = gaService.createDefaultText(getDiagram(), textDecorator);
		text.setStyle(styleUtil.getLabelStyle());
		gaService.setLocation(text, labelX, labelY);
	    text.setValue(aadlConnection.getName());
	    getFeatureProvider().link(textDecorator, new AadlElementWrapper(aadlConnection));
	    
	    // Set color based on current mode/mode transition
	    highlightingHelper.highlight(aadlConnection, connection.getGraphicsAlgorithm());
	}

	@Override
	protected void createGraphicsAlgorithm(final org.eclipse.graphiti.mm.pictograms.Connection connection) {
		final IGaService gaService = Graphiti.getGaService();
		final Polyline polyline = gaService.createPlainPolyline(connection);
		final Style style = styleUtil.getDecoratorStyle();
		polyline.setStyle(style);
	}
	
	private void createDirectionIndicator(final GraphicsAlgorithmContainer gaContainer, final int x, final Style style) {
	    final IGaService gaService = Graphiti.getGaService();
	    final GraphicsAlgorithm ga = gaService.createPlainPolyline(gaContainer, new int[] {
	    		x+4, 6, 
	    		x-4, 0, 
	    		x+4, -6});
	    ga.setStyle(style);
	}
		
	private void createDelayedIndicator(final GraphicsAlgorithmContainer gaContainer, final int x, final Style style) {
	    final IGaService gaService = Graphiti.getGaService();
		gaService.createPlainPolyline(gaContainer, new int[] {
			x, -10, 
			x, 10}).setStyle(style);
	}
	
	@Override
	protected Anchor[] getAnchors(final Connection connection) {
		final org.osate.aadl2.Connection aadlConnection = getAadlConnection(connection);
		final ContainerShape ownerShape = connectionHelper.getOwnerShape(connection);
		return (ownerShape == null) ? null : connectionHelper.getAnchors(ownerShape, aadlConnection);	
	}

	// TODO: Document
	private ConnectedElement getConnectedElementForShape(PictogramElement pe) {
		if(!(pe instanceof Shape)) {
			return null;
		}
		
		Shape shape = (Shape)pe;
		
		final ConnectedElement ce = Aadl2Factory.eINSTANCE.createConnectedElement();
		for(; shape != null; shape = shape.getContainer()) {
			final Object bo = bor.getBusinessObjectForPictogramElement(shape);
			if(bo instanceof ConnectionEnd) {
				ce.setConnectionEnd((ConnectionEnd)bo);
				break;
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
	
	// TODO: Comment
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
		final org.osate.aadl2.Connection aadlConnection = (org.osate.aadl2.Connection)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		aadlModService.modify(aadlConnection, new AbstractModifier<org.osate.aadl2.Connection, Object>() {
			@Override
			public Object modify(final Resource resource, final org.osate.aadl2.Connection aadlConnection) {
				EcoreUtil.delete(aadlConnection);
				
				return null;
			}			
		});	
		
		// Clear selection
		getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().selectPictogramElements(new PictogramElement[0]);
	}

	@Override
	public String getCreateName() {
		return StringUtil.camelCaseToUser(connectionType.getName());
	}
	
	@Override
	public boolean canStartConnection(final ICreateConnectionContext context) {
		if(getConnectedElementForShape(context.getSourcePictogramElement()) == null) {
			return false;
		}
		
		// Get the connection elements for the source and destination
		final ConnectedElement srcConnectedElement = getConnectedElementForShape(context.getSourcePictogramElement());
		if(srcConnectedElement == null) {
			return false;
		}

		// Perform type specific connection start connection validity check
		final Class<?> connectionEndType = getConnectionEndType();
		return connectionEndType != null && connectionEndType.isInstance(srcConnectedElement.getConnectionEnd());
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

		// TODO: Need to take into account prototypes, and inverses when dealing with them?
		// TODO: Need to take into account feature group inverses, and context and check directions.
		// TODO: Additional checks for access features
		
		final Class<?> connectionEndType = getConnectionEndType();
		return connectionEndType != null && connectionEndType.isInstance(dstConnectedElement.getConnectionEnd());
	}

	@Override
	public Connection create(final ICreateConnectionContext context) {
		// Get the Component Implementation
		final ComponentImplementation ci = getComponentImplementation((Shape)context.getSourcePictogramElement());
		
		// Determine the name for the new connection
		final String newConnectionName = namingService.buildUniqueIdentifier(ci, "new_connection");
		
		// Make the modification
		final org.osate.aadl2.Connection newAadlConnection = aadlModService.modify(ci, new AbstractModifier<ComponentImplementation, org.osate.aadl2.Connection>() {			
			@Override
			public org.osate.aadl2.Connection modify(final Resource resource, final ComponentImplementation ci) {
				// Create the appropriate type of connection object
				final org.osate.aadl2.Connection newAadlConnection = createConnection(ci, connectionType);
				if(newAadlConnection == null) {
					return null;
				}
				
			//	newAadlConnection.setBidirectional(true); // TODO: Don't set this? May not always be a valid option?
				
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
}
