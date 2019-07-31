package org.osate.ge.internal.businessObjectHandlers;

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
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureConnectionEnd;
import org.osate.aadl2.FeatureGroupConnectionEnd;
import org.osate.aadl2.ParameterConnectionEnd;
import org.osate.aadl2.PortConnectionEnd;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.Categories;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.BuildCreateOperation;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.CanRename;
import org.osate.ge.di.CanStartConnection;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.di.ValidateName;
import org.osate.ge.graphics.Color;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.util.AadlConnectionUtil;
import org.osate.ge.internal.util.AadlInheritanceUtil;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.internal.util.StringUtil;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.OperationBuilderHelper;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class ConnectionHandler {
	private static final Graphic graphic = ConnectionBuilder.create().build();
	private static StandaloneQuery srcQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.parent()
					.descendantsByBusinessObjectsRelativeReference(
							(Connection c) -> getBusinessObjectsPathToConnectedElement(c.getAllSourceContext(),
									c.getRootConnection().getSource()))
					.first());
	private static StandaloneQuery partialSrcQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.parent()
					.descendantsByBusinessObjectsRelativeReference(
							(Connection c) -> getBusinessObjectsPathToConnectedElement(c.getAllSourceContext(),
									c.getRootConnection().getSource()),
							1)
					.first());
	private static StandaloneQuery dstQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.parent()
					.descendantsByBusinessObjectsRelativeReference(
							(Connection c) -> getBusinessObjectsPathToConnectedElement(c.getAllDestinationContext(),
									c.getRootConnection().getDestination()))
					.first());
	private static StandaloneQuery partialDstQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.parent()
					.descendantsByBusinessObjectsRelativeReference(
							(Connection c) -> getBusinessObjectsPathToConnectedElement(c.getAllDestinationContext(),
									c.getRootConnection().getDestination()),
							1)
					.first());

	@IsApplicable
	@CanRename
	@CanDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) Connection c) {
		return true;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(final @Named(Names.BUSINESS_OBJECT) Connection c,
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, final QueryService queryService) {
		BusinessObjectContext src = queryService.getFirstResult(srcQuery, boc);
		BusinessObjectContext dst = queryService.getFirstResult(dstQuery, boc);
		boolean partial = false;

		if (src == null) {
			src = queryService.getFirstResult(partialSrcQuery, boc);
			partial = true;
		}

		if (dst == null) {
			dst = queryService.getFirstResult(partialDstQuery, boc);
			partial = true;
		}

		final StyleBuilder sb = StyleBuilder
				.create(AadlInheritanceUtil.isInherited(boc) ? Styles.INHERITED_ELEMENT : Style.EMPTY)
				.backgroundColor(Color.BLACK);
		if (partial) {
			sb.dotted();
		}

		return GraphicalConfigurationBuilder.create().graphic(graphic).style(sb.build()).source(src).destination(dst)
				.build();
	}

	/**
	 * Gets an array of business objects which describes the logical diagram element path to the connection end.
	 * @param ctx
	 * @param connectionEnd
	 * @return
	 */
	private static Object[] getBusinessObjectsPathToConnectedElement(final Context ctx,
			final ConnectedElement connectedElement) {
		if (connectedElement == null) {
			return null;
		}

		final List<Object> path = new ArrayList<>(6);
		if (ctx instanceof SubprogramCall) {
			path.add(ctx.eContainer());
		}

		if (ctx != null) {
			path.add(ctx);
		}

		for (ConnectedElement tmp = connectedElement; tmp != null; tmp = tmp.getNext()) {
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
		final boolean applicable = diagramBo == null || diagramBo instanceof AadlPackage
				|| diagramBo instanceof ComponentImplementation;
		if (!applicable) {
			return null;
		}

		final List<PaletteEntry> paletteEntries = new ArrayList<>();

		// Create palette entries for each connection type
		for (final EClass connectionType : AadlConnectionUtil.getConnectionTypes()) {
			paletteEntries.add(PaletteEntryBuilder.create().connectionCreation()
					.label(StringUtil.camelCaseToUser(connectionType.getName()))
					.icon(ImageHelper.getImage(connectionType)).category(Categories.CONNECTIONS).context(connectionType)
					.build());
		}

		return paletteEntries.toArray(new PaletteEntry[paletteEntries.size()]);
	}

	@CanStartConnection
	public boolean canStartConnection(@Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext srcBoc,
			final @Named(Names.PALETTE_ENTRY_CONTEXT) EClass connectionType, final QueryService queryService) {
		if (!(srcBoc.getBusinessObject() instanceof ConnectionEnd)) {
			return false;
		}

		final ConnectionEnd srcConnectionEnd = (ConnectionEnd)srcBoc.getBusinessObject();

		// Perform type specific connection start connection validity check
		final Class<?> connectionEndType = getConnectionEndType(connectionType);
		if (connectionEndType == null || !connectionEndType.isInstance(srcConnectionEnd)) {
			return false;
		}

		return true;
	}

	private static OperationBuilderHelper<ComponentImplementation> getClassifierOpBuilder() {
		return OperationBuilderHelper.componentImplementations();
	}

	@CanCreate
	public boolean canCreate(@Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext srcBoc,
			@Named(Names.DESTINATION_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext dstBoc,
			final @Named(Names.PALETTE_ENTRY_CONTEXT) EClass connectionType, final QueryService queryService) {

		final BusinessObjectContext ownerBoc = getOwnerBoc(srcBoc, dstBoc);
		if (ownerBoc == null) {
			return false;
		}

		// Get the connection elements for the source and destination
		final ConnectedElement srcConnectedElement = getConnectedElementForBusinessObjectContext(srcBoc, connectionType,
				false, ownerBoc);

		if (srcConnectedElement == null) {
			return false;
		}

		final ConnectedElement dstConnectedElement = getConnectedElementForBusinessObjectContext(dstBoc, connectionType,
				!(srcConnectedElement.getContext() instanceof Subcomponent), ownerBoc);

		// Ensure they are valid and are not the same
		if (dstConnectedElement == null || EcoreUtil.equals(srcConnectedElement, dstConnectedElement)) {
			return false;
		}

		// Don't allow connecting two features owned by the same classifier
		if (!(srcConnectedElement.getContext() instanceof Subcomponent
				|| srcConnectedElement.getContext() instanceof SubprogramCall)
				&& srcConnectedElement.getConnectionEnd() instanceof Feature
				&& !(dstConnectedElement.getContext() instanceof Subcomponent
						|| dstConnectedElement.getContext() instanceof SubprogramCall)
				&& dstConnectedElement.getConnectionEnd() instanceof Feature) {
			return false;
		}

		final Class<?> connectionEndType = getConnectionEndType(connectionType);
		if (connectionEndType == null || !connectionEndType.isInstance(dstConnectedElement.getConnectionEnd())) {
			return false;
		}

		return ownerBoc == null ? false : getClassifierOpBuilder().canBuildOperation(ownerBoc.getBusinessObject());
	}

	@BuildCreateOperation
	public Operation buildCreateOperation(
			final @Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext srcBoc,
			final @Named(Names.DESTINATION_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext dstBoc,
			final @Named(Names.PALETTE_ENTRY_CONTEXT) EClass connectionType, final QueryService queryService,
			final NamingService namingService) {
		// Find the common ancestor which will be the BOC which will own the new connection.
		final BusinessObjectContext container = getOwnerBoc(srcBoc, dstBoc);
		if (container == null) {
			return null;
		}

		return Operation.create(createOp -> {
			// Create the subcomponent
			getClassifierOpBuilder().buildOperation(createOp, container.getBusinessObject())
			.modifyPreviousResult(owner -> {
				// Create the appropriate type of connection object
				final org.osate.aadl2.Connection newAadlConnection = AadlConnectionUtil.createConnection(owner,
						connectionType);
				if (newAadlConnection == null) {
					return null;
				}

				// Reset the no connections flag
				owner.setNoConnections(false);

				// Set the source and destination
				final ConnectedElement src = getConnectedElementForBusinessObjectContext(srcBoc, connectionType,
						false, container);
				newAadlConnection.setSource(src);
				final ConnectedElement dst = getConnectedElementForBusinessObjectContext(dstBoc, connectionType,
						!(src.getContext() instanceof Subcomponent), container);
				newAadlConnection.setDestination(dst);

				// Determine the name for the new connection
				final String newConnectionName = namingService.buildUniqueIdentifier(owner, "new_connection");
				newAadlConnection.setName(newConnectionName);

				// Set type of access connection
				if (newAadlConnection instanceof AccessConnection) {
					final AccessConnection ac = (AccessConnection) newAadlConnection;
					if (src.getConnectionEnd() instanceof SubprogramAccess
							|| dst.getConnectionEnd() instanceof SubprogramAccess) {
						ac.setAccessCategory(AccessCategory.SUBPROGRAM);
					} else if (src.getConnectionEnd() instanceof SubprogramGroupAccess
							|| dst.getConnectionEnd() instanceof SubprogramGroupAccess) {
						ac.setAccessCategory(AccessCategory.SUBPROGRAM_GROUP);
					} else if (src.getConnectionEnd() instanceof BusAccess
							|| dst.getConnectionEnd() instanceof BusAccess) {
						ac.setAccessCategory(AccessCategory.BUS);
					} else if (src.getConnectionEnd() instanceof DataAccess
							|| dst.getConnectionEnd() instanceof DataAccess) {
						ac.setAccessCategory(AccessCategory.DATA);
					}
				}

				return StepResultBuilder.create().showNewBusinessObject(container, newAadlConnection).build();
			});
		});
	}

	private static BusinessObjectContext getOwnerBoc(final BusinessObjectContext srcBoc,
			final BusinessObjectContext dstBoc) {

		// Search for an appropriate owner. To be appropriate the owner BOC must be a component implementation or a subcomponent which is reachable from both the source and destination BOC.
		int subcomponentsChecked1 = 0;
		BusinessObjectContext temp1 = srcBoc.getParent();
		while (temp1 != null) {
			final Object bo1 = temp1.getBusinessObject();
			if (bo1 instanceof Subcomponent || bo1 instanceof ComponentImplementation) {
				BusinessObjectContext temp2 = dstBoc.getParent();
				int subcomponentsChecked2 = 0;
				while (temp2 != null) {
					final Object bo2 = temp2.getBusinessObject();
					if (bo2 instanceof Subcomponent || bo2 instanceof ComponentImplementation) {
						if (temp1 == temp2) {
							return temp1;
						}

						if (bo2 instanceof Subcomponent) {
							subcomponentsChecked2++;

							// Stop checking at second subcomponent
							if (subcomponentsChecked2 >= 2) {
								break;
							}
						} else if (bo2 instanceof ComponentImplementation) {
							// Stop checking at component implementations
							break;
						}
					}
					temp2 = temp2.getParent();
				}

				if (temp1.getBusinessObject() instanceof Subcomponent) {
					subcomponentsChecked1++;

					// Stop checking at second subcomponent
					if (subcomponentsChecked1 >= 2) {
						break;
					}
				} else if (bo1 instanceof ComponentImplementation) {
					// Stop checking at component implementations
					break;
				}
			}

			temp1 = temp1.getParent();
		}

		return null;
	}

	/**
	 * Builds a ConnectedElement for the specific business object.
	 * @param boc
	 * @param connectionType
	 * @param disableNesting
	 * @param limitBoc is an optional business object context which limits the path of the connected element
	 * @return
	 */
	private ConnectedElement getConnectedElementForBusinessObjectContext(final BusinessObjectContext boc,
			final EClass connectionType, final boolean disableNesting, final BusinessObjectContext limitBoc) {
		final Object bo = boc.getBusinessObject();
		if (!(bo instanceof ConnectionEnd)) {
			return null;
		}

		// Build a list of business objects which make up the path to the connection end.
		boolean pathIncludesSubcomponent = false;
		final LinkedList<Object> path = new LinkedList<>();
		for (BusinessObjectContext tmp = boc; tmp != null && tmp != limitBoc
				&& tmp.getBusinessObject() != null; tmp = tmp.getParent()) {
			if (tmp.getBusinessObject() instanceof ComponentImplementation
					|| tmp.getBusinessObject() instanceof SubprogramCallSequence) {
				break;
			} else if (tmp.getBusinessObject() instanceof Subcomponent) {
				if (pathIncludesSubcomponent) {
					break;
				}

				pathIncludesSubcomponent = true;
			}

			path.add(0, tmp.getBusinessObject());
		}

		if (path.size() == 0) {
			return null;
		}

		final Object[] pathObjects = path.toArray();

		final Object firstBo = pathObjects[0];
		final boolean allowNested = !disableNesting
				&& connectionType == Aadl2Factory.eINSTANCE.getAadl2Package().getFeatureConnection();

		// If nesting is not allowed, then the number of objects must be at most 2.
		if (!allowNested && pathObjects.length > 2) {
			return null;
		}

		final ConnectedElement ce = Aadl2Factory.eINSTANCE.createConnectedElement();

		// Add the context
		int i = 0;
		if (pathObjects.length > 1) {
			if (!(firstBo instanceof Context)) {
				return null;
			}

			ce.setContext((Context) firstBo);
			i++;
		}

		// Add the first connection end
		if (!(pathObjects[i] instanceof ConnectionEnd)) {
			return null;
		}

		ce.setConnectionEnd((ConnectionEnd) pathObjects[i]);
		i++;

		// Add other segments
		ConnectedElement tmp = ce;
		for (; i < pathObjects.length; i++) {
			tmp = tmp.createNext();
			if (!(pathObjects[i] instanceof ConnectionEnd)) {
				return null;
			}

			tmp.setConnectionEnd((ConnectionEnd) pathObjects[i]);
		}

		// SubprogramSubcomponent elements are never a valid context
		if (ce.getContext() instanceof SubprogramSubcomponent) {
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
		if (connectionType == p.getAccessConnection()) {
			connectionEndType = AccessConnectionEnd.class;
		} else if (connectionType == p.getFeatureConnection()) {
			connectionEndType = FeatureConnectionEnd.class;
		} else if (connectionType == p.getFeatureGroupConnection()) {
			connectionEndType = FeatureGroupConnectionEnd.class;
		} else if (connectionType == p.getParameterConnection()) {
			connectionEndType = ParameterConnectionEnd.class;
		} else if (connectionType == p.getPortConnection()) {
			connectionEndType = PortConnectionEnd.class;
		} else {
			connectionEndType = null;
		}

		return connectionEndType;
	}

// Renaming
	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) Connection c, final @Named(Names.NAME) String value,
			final NamingService namingService) {
		return namingService.checkNameValidity(c, value);
	}
}
