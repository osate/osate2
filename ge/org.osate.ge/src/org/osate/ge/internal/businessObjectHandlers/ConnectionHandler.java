package org.osate.ge.internal.businessObjectHandlers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AccessCategory;
import org.osate.aadl2.AccessConnection;
import org.osate.aadl2.AccessConnectionEnd;
import org.osate.aadl2.BusAccess;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
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
import org.osate.ge.Categories;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.CanStartConnection;
import org.osate.ge.di.Create;
import org.osate.ge.di.GetCreateOwner;
import org.osate.ge.di.GetDestination;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.GetSource;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.di.SetName;
import org.osate.ge.di.ValidateName;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.annotations.Annotation;
import org.osate.ge.internal.annotations.AnnotationBuilder;
import org.osate.ge.internal.decorations.Decoration;
import org.osate.ge.internal.decorations.DelayedDecorationBuilder;
import org.osate.ge.internal.decorations.DirectionDecorationBuilder;
import org.osate.ge.internal.decorations.ImmediateDecorationBuilder;
import org.osate.ge.internal.di.CanRename;
import org.osate.ge.internal.di.CreateParentQuery;
import org.osate.ge.internal.di.GetAnnotations;
import org.osate.ge.internal.di.GetDecorations;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.query.DefaultQuery;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.RefactoringService;
import org.osate.ge.internal.util.AadlConnectionUtil;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.internal.util.StringUtil;
import org.osate.ge.query.Query;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;
import org.osate.xtext.aadl2.properties.util.CommunicationProperties;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;

public class ConnectionHandler {
	private static final StandaloneQuery componentImplementationQuery = StandaloneQuery.create((root) -> root.ancestors().filter((fa) -> fa.getBusinessObject() instanceof ComponentImplementation).first());
	private static final Graphic graphic = ConnectionBuilder.create().build();
	private static final Decoration delayedDecoration = DelayedDecorationBuilder.create().build();
	private static final Decoration immediateDecoration = ImmediateDecorationBuilder.create().build();
	private static final Decoration directionDecoration = DirectionDecorationBuilder.create().build();
	private static final StandaloneQuery selfQuery = StandaloneQuery.create((root) -> root);
	private static final StandaloneQuery parentQuery = StandaloneQuery.create((root) -> root.ancestor(1));
	private static final StandaloneQuery grandparentQuery = StandaloneQuery.create((root) -> root.ancestor(2));
	private static StandaloneQuery srcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().descendantsByBusinessObjects((Connection c) -> getBusinessObjectsPathToConnectionEnd(c.getAllSourceContext(), c.getAllSource())).first());
	private static StandaloneQuery dstQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().descendantsByBusinessObjects((Connection c) -> getBusinessObjectsPathToConnectionEnd(c.getAllDestinationContext(), c.getAllDestination())).first());
	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) Connection c) {
		return true;
	}
	
	@GetGraphic
	public Graphic getGraphicalRepresentation() {
		return graphic;
	}

	@GetSource
	public BusinessObjectContext getSource(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, 
			final QueryService queryService) {
		return queryService.getFirstResult(srcQuery, boc);
	}
	
	@GetDestination
	public BusinessObjectContext getDestination(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, 
			final QueryService queryService) {
		return queryService.getFirstResult(dstQuery, boc);
	}
	
	@CreateParentQuery
	public Query createParentQuery(final @Named(InternalNames.SOURCE_ROOT_QUERY) DefaultQuery srcRootQuery, 
			final @Named(InternalNames.DESTINATION_ROOT_QUERY) DefaultQuery dstRootQuery) {
		return srcRootQuery.commonAncestors(dstRootQuery).filter((fa) -> fa.getBusinessObject() instanceof Subcomponent || fa.getBusinessObject() instanceof ComponentClassifier);
	}
	
	/**
	 * Gets an array of business objects which describes the logical diagram element path to the connection end.
	 * @param ctx
	 * @param connectionEnd
	 * @return
	 */
	private static Object[] getBusinessObjectsPathToConnectionEnd(final Context ctx, final Object connectionEnd) {
		if(connectionEnd == null) {
			return null;
		}
		
		final List<Object> path = new ArrayList<>(3);
		if(ctx instanceof SubprogramCall) {
			path.add(ctx.eContainer());
		}
		
		if(ctx != null) {
			path.add(ctx);
		}
		
		path.add(connectionEnd);

		return path.toArray();
	}
	
	// Decorations
	@GetDecorations
	public Decoration[] getDecorations(final @Named(Names.BUSINESS_OBJECT) Connection c) {
		final ArrayList<Decoration> decorations = new ArrayList<Decoration>(3);
		
		// Determine which indicators should be shown
		final boolean showImmediateDecoration;
		final boolean showDelayedDecoration;
		if(c instanceof PortConnection) {
			final PortConnection pc = (PortConnection)c;
			final EnumerationLiteral connectionTiming = GetProperties.getConnectionTiming(pc);
			final String connectionTimingName = connectionTiming == null ? null : connectionTiming.getName();
			if(CommunicationProperties.DELAYED.equals(connectionTimingName)) {
				showDelayedDecoration = true;
				showImmediateDecoration = false;
			} else if(CommunicationProperties.IMMEDIATE.equals(connectionTimingName)) {
				showDelayedDecoration = false;
				showImmediateDecoration = true;
			} else {
			
				showImmediateDecoration = showDelayedDecoration = false;
			}
		} else {
			showImmediateDecoration = showDelayedDecoration = false;
		}
				
		// Create decorations
		if(showDelayedDecoration) {
			decorations.add(delayedDecoration);
		} else if(showImmediateDecoration) {
			decorations.add(immediateDecoration);
		}

		final boolean showDirectionDecoration;
		if(!showImmediateDecoration && !c.isBidirectional()) {
			final ConnectionEnd src = c.getAllSource();
			final ConnectionEnd dst = c.getAllDestination();
			if((src != null && src instanceof DirectedFeature && (((DirectedFeature)src).getDirection() == null || ((DirectedFeature)src).getDirection() == DirectionType.IN_OUT)) ||
			 (dst != null && dst instanceof DirectedFeature && (((DirectedFeature)dst).getDirection() == null || ((DirectedFeature)dst).getDirection() == DirectionType.IN_OUT))) {
				showDirectionDecoration = true;
			} else {
				showDirectionDecoration = false;
			}
		} else {
			showDirectionDecoration = false;
		}		
		
		if(showDirectionDecoration) {
			decorations.add(directionDecoration);
		}
		
		return decorations.toArray(new Decoration[decorations.size()]);
	}
	
	// Labels
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) Connection c) {
		return c.getName(); 
	}
	
	@GetAnnotations
	public Annotation[] getAnnotations(final @Named(Names.BUSINESS_OBJECT) Connection c) {
		final String connectionPatterns = getConnectionPatterns(c);
		return connectionPatterns == null ? null : new Annotation[] {AnnotationBuilder.create().text(connectionPatterns).name("connection_pattern").build()};
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
	
	// Creating
	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) Object diagramBo) {
		final boolean applicable = diagramBo == null || diagramBo instanceof AadlPackage || diagramBo instanceof ComponentImplementation;
		if(!applicable) {
			return null;
		}
		
		final List<PaletteEntry> paletteEntries = new ArrayList<>();
		
		// Create palette entries for each connection type
		for(final EClass connectionType : AadlConnectionUtil.getConnectionTypes()) {
			paletteEntries.add(PaletteEntryBuilder.create().
					connectionCreation().
					label(StringUtil.camelCaseToUser(connectionType.getName())).
					icon(ImageHelper.getImage(connectionType)).
					category(Categories.CONNECTIONS).context(connectionType).
					build());
		}

		return paletteEntries.toArray(new PaletteEntry[paletteEntries.size()]);		
	}
	
	@GetCreateOwner
	public ComponentClassifier getCreateConnectionOwner(@Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext srcBoc, 
			final QueryService queryService) {
		return (ComponentImplementation)queryService.getFirstBusinessObject(componentImplementationQuery, srcBoc);
	}
	
	@CanStartConnection
	public boolean canStartConnection(@Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext srcBoc, 
			final @Named(Names.PALETTE_ENTRY_CONTEXT) EClass connectionType,
			final QueryService queryService) {
		final ConnectedElement srcConnectedElement = getConnectedElementForBusinessObjectContext(srcBoc, queryService);
		if(srcConnectedElement == null) {
			return false;
		}
		
		// Perform type specific connection start connection validity check
		final Class<?> connectionEndType = getConnectionEndType(connectionType);
		if(connectionEndType == null || !connectionEndType.isInstance(srcConnectedElement.getConnectionEnd())) {
			return false;
		}
		
		return true;
		
	}	
	
	@CanCreate
	public boolean canCreate(@Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext srcBoc, 
			@Named(Names.DESTINATION_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext dstBoc, 
			final @Named(Names.PALETTE_ENTRY_CONTEXT) EClass connectionType,
			final QueryService queryService) {		

		// Get the connection elements for the source and destination
		final ConnectedElement srcConnectedElement = getConnectedElementForBusinessObjectContext(srcBoc, queryService);
		final ConnectedElement dstConnectedElement = getConnectedElementForBusinessObjectContext(dstBoc, queryService);

		// Ensure they are valid and are not the same
		if(dstConnectedElement == null || EcoreUtil.equals(srcConnectedElement, dstConnectedElement)) {
			return false;
		}

		final Class<?> connectionEndType = getConnectionEndType(connectionType);
		if(connectionEndType == null || !connectionEndType.isInstance(dstConnectedElement.getConnectionEnd())) {
			return false;
		}
		
		return true;
	}

	@Create
	public Connection createBusinessObject(@Named(Names.OWNER_BO) final ComponentImplementation ci, 
			@Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext srcBoc, 
			@Named(Names.DESTINATION_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext dstBoc, 
			final @Named(Names.PALETTE_ENTRY_CONTEXT) EClass connectionType,
			final QueryService queryService,
			final NamingService namingService) {
		
		// Determine the name for the new connection
		final String newConnectionName = namingService.buildUniqueIdentifier(ci, "new_connection");
		
		// Create the appropriate type of connection object
		final org.osate.aadl2.Connection newAadlConnection = AadlConnectionUtil.createConnection(ci, connectionType);
		if(newAadlConnection == null) {
			return null;
		}
		
		// Reset the no connections flag
		ci.setNoConnections(false);

		// Set the name
		newAadlConnection.setName(newConnectionName);
		
		// Set the source and destination
		final ConnectedElement src = getConnectedElementForBusinessObjectContext(srcBoc, queryService);
		newAadlConnection.setSource(src);
		final ConnectedElement dst = getConnectedElementForBusinessObjectContext(dstBoc, queryService);
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
	
	private ConnectedElement getConnectedElementForBusinessObjectContext(final BusinessObjectContext boc, final QueryService queryService) {
		final ConnectedElement ce = Aadl2Factory.eINSTANCE.createConnectedElement();
		final Object bo = queryService.getFirstBusinessObject(selfQuery, boc);
		if(!(bo instanceof ConnectionEnd)) {
			return null;
		} 
		
		ce.setConnectionEnd((ConnectionEnd)bo);

		final Object parentBo = queryService.getFirstBusinessObject(parentQuery, boc);
		if(parentBo instanceof Context) {
			ce.setContext((Context)parentBo);
			// Grandparent must be the root of the feature specification path. Arbitrary length feature specifications aren't supported at this time.
			final Object grandparentBo = queryService.getFirstBusinessObject(grandparentQuery, boc);
			if(!(grandparentBo instanceof Subcomponent || grandparentBo instanceof ComponentImplementation)) {
				return null;
			}
		} else if(!(parentBo instanceof Subcomponent || parentBo instanceof ComponentImplementation)) {
			return null;
		}
		
		return ce;
	}
	
	/**
	 * Retrieves the appropriate interface for connection ends for the current connection type
	 * @return
	 */
	private Class<?> getConnectionEndType(final EClass connectionType) {
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
	
	// Renaming
	@CanRename
    public boolean canRename(final @Named(Names.BUSINESS_OBJECT) Connection c, final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, final QueryService queryService) {
		final ComponentImplementation ci = (ComponentImplementation)queryService.getFirstBusinessObject(componentImplementationQuery, boc);
		return c.getContainingClassifier() == ci && c.getRefined() == null;
    }
	
	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) Connection c, final @Named(Names.NAME) String value, final NamingService namingService) {
		return namingService.checkNameValidity(c, value);
	}
	
	@SetName
	public void setName(final @Named(Names.BUSINESS_OBJECT) Connection c, final @Named(Names.NAME) String value, final RefactoringService refactoringService) {
		refactoringService.renameElement(c, value);
	}
	
	// Deleting
	@CanDelete
    public boolean canDelete(final @Named(Names.BUSINESS_OBJECT) Connection c, final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, final QueryService queryService) {
		final ComponentImplementation ci = (ComponentImplementation)queryService.getFirstBusinessObject(componentImplementationQuery, boc);
		return c.getContainingClassifier() == ci;
    }
}
