package org.osate.ge.internal.connections;

import java.util.Objects;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.osate.ge.di.CreateDestinationQuery;
import org.osate.ge.di.CreateParentQuery;
import org.osate.ge.di.CreateSourceQuery;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.query.PictogramQuery;
import org.osate.ge.internal.query.Query;
import org.osate.ge.internal.query.QueryRunner;
import org.osate.ge.internal.query.QueryUtil;
import org.osate.ge.internal.query.RootPictogramQuery;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.PropertyService;

public class BusinessObjectHandlerConnectionInfoProvider implements ConnectionInfoProvider {
	private final ConnectionService connectionService;
	private final PropertyService propertyService;
	private final ExtensionService extService;
	private final BusinessObjectResolutionService bor;
	private final Object handler;
	private final QueryRunner queryRunner;
	private final RootPictogramQuery rootQuery = new RootPictogramQuery(() -> this.rootValue);
	private final RootPictogramQuery srcRootQuery = new RootPictogramQuery(() -> this.srcRootValue); // For getting the connection's source
	private final RootPictogramQuery dstRootQuery = new RootPictogramQuery(() -> this.dstRootValue); // For getting the connection's destination
	private final Query<Object> ownerDiagramElementQuery;
	private final Query<Object> srcQuery;
	private final Query<Object> dstQuery;	

	// Values retrieved by the root queries
	private PictogramElement rootValue;
	private PictogramElement srcRootValue;
	private PictogramElement dstRootValue;

	@SuppressWarnings("unchecked")
	public BusinessObjectHandlerConnectionInfoProvider(final ConnectionService connectionService,
			final PropertyService propertyService,
			final ExtensionService extService, 
			final BusinessObjectResolutionService bor,
			final Object boHandler, 
			final QueryRunner queryRunner) {
		this.connectionService = Objects.requireNonNull(connectionService, "connectionService must not be null");
		this.propertyService = Objects.requireNonNull(propertyService, "propertyService must not be null");
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.bor = Objects.requireNonNull(bor, "bor must not be null");
		this.handler = Objects.requireNonNull(boHandler, "boHandler must not be null");
		this.queryRunner = Objects.requireNonNull(queryRunner, "queryRunner muts not be null");

		// Create queries using the business object handler
		final IEclipseContext childCtx = extService.createChildContext();
		try {
			childCtx.set(Names.SOURCE_ROOT_QUERY, srcRootQuery);
			childCtx.set(Names.DESTINATION_ROOT_QUERY, dstRootQuery);
			ownerDiagramElementQuery = QueryUtil.ensureFirst(Objects.requireNonNull((PictogramQuery<Object>)ContextInjectionFactory.invoke(handler, CreateParentQuery.class, childCtx), "unable to create parent diagram element query"));
			childCtx.remove(Names.SOURCE_ROOT_QUERY);
			childCtx.remove(Names.DESTINATION_ROOT_QUERY);
			
			childCtx.set(Names.ROOT_QUERY, rootQuery);	
			srcQuery = QueryUtil.ensureFirst(Objects.requireNonNull((PictogramQuery<Object>)ContextInjectionFactory.invoke(handler, CreateSourceQuery.class, childCtx), "unable to create source query"));
			dstQuery = QueryUtil.ensureFirst(Objects.requireNonNull((PictogramQuery<Object>)ContextInjectionFactory.invoke(handler, CreateDestinationQuery.class, childCtx), "unable to create destination query"));
		} finally {
			childCtx.dispose();
		}
	}	
	
	@Override
	public boolean isBusinessObjectApplicable(final Object bo) {
		if(bo == null) {
			return false;			
		}
		
		final IEclipseContext childCtx = extService.createChildContext();
		try {
			childCtx.set(Names.BUSINESS_OBJECT, bo);			
			return (boolean)ContextInjectionFactory.invoke(handler, IsApplicable.class, childCtx, false);
		} finally {
			childCtx.dispose();
		}
	}
	
	@Override
	public boolean isApplicable(final Connection connection) {
		return isBusinessObjectApplicable(bor.getBusinessObjectForPictogramElement(connection));
	}
	
	@Override
	public PictogramElement getOwner(final Connection connection) {
		try {			
			final Anchor srcAnchor = connection.getStart();
			final Anchor dstAnchor = connection.getEnd();
			
			if(srcAnchor == null || srcAnchor.getParent() == null || dstAnchor == null || dstAnchor.getParent() == null) {
				return null;
			}
			
			this.srcRootValue = propertyService.isConnectionAnchor(srcAnchor) ? null : srcAnchor.getParent();
			this.dstRootValue = propertyService.isConnectionAnchor(dstAnchor) ? null : dstAnchor.getParent();
			final Object bo = bor.getBusinessObjectForPictogramElement(connection);
			final PictogramElement result = queryRunner.getFirstPictogramElement(ownerDiagramElementQuery, bo);
			return result;
		} finally {
			this.srcRootValue = null;
			this.dstRootValue = null;
		}
	}

	@Override
	public Anchor[] getAnchors(final PictogramElement owner, final Object bo) {
		try {
			// Set root value of queries
			this.rootValue = owner;

			// Get the anchors
			final Anchor a1 = getAnchor(queryRunner.getFirstPictogramElement(srcQuery, bo));
			if(a1 == null) {
				return null;
			}
			
			final Anchor a2 = getAnchor(queryRunner.getFirstPictogramElement(dstQuery, bo));
			if(a2 == null) {
				return null;
			}
	
			return new Anchor[] {a1, a2};
		} finally {
			this.rootValue = null;
		}
	}
	
	private Anchor getAnchor(final PictogramElement pe) {
		if(pe instanceof Connection) {
			return connectionService.createUpdateConnectionAnchor((Connection)pe);
		} else if(pe instanceof AnchorContainer) {
			final AnchorContainer anchorContainer = (AnchorContainer)pe;
			return Graphiti.getPeService().getChopboxAnchor(anchorContainer);
		} else {		
			return null;
		}
	}
}
