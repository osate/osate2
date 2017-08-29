package org.osate.ge.internal.businessObjectHandlers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
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
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.FeatureConnectionEnd;
import org.osate.aadl2.FeatureGroupConnectionEnd;
import org.osate.aadl2.ParameterConnectionEnd;
import org.osate.aadl2.PortConnectionEnd;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.Categories;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.CanStartConnection;
import org.osate.ge.di.Create;
import org.osate.ge.di.GetCreateOwner;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.di.ValidateName;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.di.CanRename;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.util.AadlConnectionUtil;
import org.osate.ge.internal.util.AadlInheritanceUtil;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.internal.util.StringUtil;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class ConnectionHandler {
	private static final StandaloneQuery componentImplementationQuery = StandaloneQuery.create((root) -> root.ancestors().filter((fa) -> fa.getBusinessObject() instanceof ComponentImplementation).first());
	private static final Graphic graphic = ConnectionBuilder.create().build();
	private static StandaloneQuery srcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().descendantsByBusinessObjectsRelativeReference((Connection c) -> getBusinessObjectsPathToConnectedElement(c.getAllSourceContext(), c.getRootConnection().getSource())).first());
	private static StandaloneQuery partialSrcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().descendantsByBusinessObjectsRelativeReference((Connection c) -> getBusinessObjectsPathToConnectedElement(c.getAllSourceContext(), c.getRootConnection().getSource()), 1).first());
	private static StandaloneQuery dstQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().descendantsByBusinessObjectsRelativeReference((Connection c) -> getBusinessObjectsPathToConnectedElement(c.getAllDestinationContext(), c.getRootConnection().getDestination())).first());
	private static StandaloneQuery partialDstQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().descendantsByBusinessObjectsRelativeReference((Connection c) -> getBusinessObjectsPathToConnectedElement(c.getAllDestinationContext(), c.getRootConnection().getDestination()), 1).first());

	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) Connection c) {
		return true;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(final @Named(Names.BUSINESS_OBJECT) Connection c,
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final QueryService queryService) {
		BusinessObjectContext src = queryService.getFirstResult(srcQuery, boc);
		BusinessObjectContext dst = queryService.getFirstResult(dstQuery, boc);
		boolean partial = false;

		if(src == null) {
			src = queryService.getFirstResult(partialSrcQuery, boc);
			partial = true;
		}

		if(dst == null) {
			dst = queryService.getFirstResult(partialDstQuery, boc);
			partial = true;
		}

		final StyleBuilder sb = StyleBuilder
				.create(AadlInheritanceUtil.isInherited(boc) ? Styles.INHERITED_ELEMENT_STYLE : Style.EMPTY)
				.backgroundColor(Color.BLACK);
		if (partial) {
			sb.dotted();
		}

		return GraphicalConfigurationBuilder.create().
				graphic(graphic).
				style(sb.build()).
				source(src).
				destination(dst).
				build();
	}

	/**
	 * Gets an array of business objects which describes the logical diagram element path to the connection end.
	 * @param ctx
	 * @param connectionEnd
	 * @return
	 */
	private static Object[] getBusinessObjectsPathToConnectedElement(final Context ctx, final ConnectedElement connectedElement) {
		if(connectedElement == null) {
			return null;
		}

		final List<Object> path = new ArrayList<>(6);
		if(ctx instanceof SubprogramCall) {
			path.add(ctx.eContainer());
		}

		if(ctx != null) {
			path.add(ctx);
		}

		for(ConnectedElement tmp = connectedElement; tmp != null; tmp = tmp.getNext()) {
			path.add(tmp.getConnectionEnd());
		}

		return path.toArray();
	}

	// Labels
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) Connection c) {
		return c.getName();
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
	public BusinessObjectContext getCreateConnectionOwner(@Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext srcBoc,
			final QueryService queryService) {
		return queryService.getFirstResult(componentImplementationQuery, srcBoc);
	}

	@CanStartConnection
	public boolean canStartConnection(@Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext srcBoc,
			final @Named(Names.PALETTE_ENTRY_CONTEXT) EClass connectionType,
			final QueryService queryService) {
		final ConnectedElement srcConnectedElement = getConnectedElementForBusinessObjectContext(srcBoc, connectionType, false);
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
		final ConnectedElement srcConnectedElement = getConnectedElementForBusinessObjectContext(srcBoc, connectionType, false);
		final ConnectedElement dstConnectedElement = getConnectedElementForBusinessObjectContext(dstBoc, connectionType, !(srcConnectedElement.getContext() instanceof Subcomponent));

		// Ensure they are valid and are not the same
		if(dstConnectedElement == null || EcoreUtil.equals(srcConnectedElement, dstConnectedElement)) {
			return false;
		}

		final Class<?> connectionEndType = getConnectionEndType(connectionType);
		if(connectionEndType == null || !connectionEndType.isInstance(dstConnectedElement.getConnectionEnd())) {
			return false;
		}

		if(getComponentImplementation(srcBoc, queryService) != getComponentImplementation(dstBoc, queryService)) {
			return false;
		}

		return true;
	}

	private ComponentImplementation getComponentImplementation(final BusinessObjectContext boc, final QueryService queryService) {
		return (ComponentImplementation)queryService.getFirstBusinessObject(componentImplementationQuery, boc);
	}

	@Create
	public Connection createBusinessObject(@Named(Names.MODIFY_BO) final ComponentImplementation ci,
			@Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext srcBoc,
			@Named(Names.DESTINATION_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext dstBoc,
			final @Named(Names.PALETTE_ENTRY_CONTEXT) EClass connectionType,
			final QueryService queryService,
			final NamingService namingService) {

		// Create the appropriate type of connection object
		final org.osate.aadl2.Connection newAadlConnection = AadlConnectionUtil.createConnection(ci, connectionType);
		if(newAadlConnection == null) {
			return null;
		}

		// Reset the no connections flag
		ci.setNoConnections(false);

		// Set the source and destination
		final ConnectedElement src = getConnectedElementForBusinessObjectContext(srcBoc, connectionType, false);
		newAadlConnection.setSource(src);
		final ConnectedElement dst = getConnectedElementForBusinessObjectContext(dstBoc, connectionType, !(src.getContext() instanceof Subcomponent));
		newAadlConnection.setDestination(dst);

		// Determine the name for the new connection
		final String newConnectionName = namingService.buildUniqueIdentifier(ci, "new_connection");
		newAadlConnection.setName(newConnectionName);

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


	private ConnectedElement getConnectedElementForBusinessObjectContext(final BusinessObjectContext boc,
			final EClass connectionType,
			final boolean disableNesting) {
		final Object bo = boc.getBusinessObject();
		if(!(bo instanceof ConnectionEnd)) {
			return null;
		}

		// Build a list of business objects which make up the path to the connection end.
		int numberOfSubcomponents = 0;
		final LinkedList<Object> path = new LinkedList<>();
		for(BusinessObjectContext tmp = boc; tmp != null && tmp.getBusinessObject() != null && !(tmp.getBusinessObject() instanceof ComponentImplementation); tmp = tmp.getParent()) {
			path.add(0, tmp.getBusinessObject());

			if(tmp.getBusinessObject() instanceof Subcomponent) {
				numberOfSubcomponents++;
			}
		}

		if(path.size() == 0 || numberOfSubcomponents > 1) {
			return null;
		}

		final Object[] pathObjects = path.toArray();

		final Object firstBo = pathObjects[0];
		final boolean allowNested = !disableNesting &&
				connectionType == Aadl2Factory.eINSTANCE.getAadl2Package().getFeatureConnection() &&
				firstBo instanceof Subcomponent; // Only allow nested connections for feature connections between subcomponents and nesting is not disabled

		// If nesting is not allowed, then the number of objects must be at most 2.
		if(!allowNested && pathObjects.length > 2) {
			return null;
		}

		final ConnectedElement ce = Aadl2Factory.eINSTANCE.createConnectedElement();

		// Add the context
		int i = 0;
		if(pathObjects.length > 1) {
			if(!(firstBo instanceof Context)) {
				return null;
			}

			ce.setContext((Context)firstBo);
			i++;
		}

		// Add the first connection end
		if(!(pathObjects[i] instanceof ConnectionEnd)) {
			return null;
		}

		ce.setConnectionEnd((ConnectionEnd)pathObjects[i]);
		i++;

		// Add other segments
		ConnectedElement tmp = ce;
		for(;i < pathObjects.length; i++) {
			tmp = tmp.createNext();
			if(!(pathObjects[i] instanceof ConnectionEnd)) {
				return null;
			}

			tmp.setConnectionEnd((ConnectionEnd)pathObjects[i]);
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
		final ComponentImplementation ci = getComponentImplementation(boc, queryService);
		return c.getContainingClassifier() == ci && c.getRefined() == null;
	}

	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) Connection c, final @Named(Names.NAME) String value, final NamingService namingService) {
		return namingService.checkNameValidity(c, value);
	}

	// Deleting
	@CanDelete
	public boolean canDelete(final @Named(Names.BUSINESS_OBJECT) Connection c, final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, final QueryService queryService) {
		final ComponentImplementation ci = (ComponentImplementation)queryService.getFirstBusinessObject(componentImplementationQuery, boc);
		return c.getContainingClassifier() == ci;
	}
}
