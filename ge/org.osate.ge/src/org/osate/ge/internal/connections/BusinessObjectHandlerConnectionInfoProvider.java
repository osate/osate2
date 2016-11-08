package org.osate.ge.internal.connections;

import java.util.Objects;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
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
import org.osate.ge.internal.services.ExtensionService;

public class BusinessObjectHandlerConnectionInfoProvider implements ConnectionInfoProvider {
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
	public BusinessObjectHandlerConnectionInfoProvider(final ExtensionService extService, final BusinessObjectResolutionService bor,
			final Object boHandler, final QueryRunner queryRunner) {
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.bor = Objects.requireNonNull(bor, "bor must not be null");
		this.handler = Objects.requireNonNull(boHandler, "boHandler must not be null");
		this.queryRunner = Objects.requireNonNull(queryRunner, "queryRunner muts not be null");

		// Create queries using the business object handler
		final IEclipseContext childCtx = extService.createChildContext();
		try {
			childCtx.set(Names.SOURCE_ROOT_QUERY, srcRootQuery);
			childCtx.set(Names.DESTINATION_ROOT_QUERY, dstRootQuery);
			ownerDiagramElementQuery = QueryUtil.ensureFirst(Objects.requireNonNull((PictogramQuery<Object>)ContextInjectionFactory.invoke(handler, CreateParentQuery.class, childCtx), "unable to create owner diagram element query"));
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
	public boolean allowMidpointAnchor() {
		return false;
	}
	
	@Override
	public ContainerShape getOwnerShape(final Connection connection) {
		try {
			if(connection.getStart() == null || connection.getStart().getParent() == null || connection.getEnd() == null || connection.getEnd().getParent() == null) {
				return null;
			}
			
			this.srcRootValue = connection.getStart().getParent();
			this.dstRootValue = connection.getEnd().getParent();
			final Object bo = bor.getBusinessObjectForPictogramElement(connection);
			final PictogramElement result = queryRunner.getFirstPictogramElement(ownerDiagramElementQuery, bo);
			if(result instanceof ContainerShape) {
				return (ContainerShape)result;
			}
			
			if(result == null) {
				return null;
			}
			
			throw new RuntimeException("Query result is of unexpected type: " + result.getClass());
		} finally {
			this.srcRootValue = null;
			this.dstRootValue = null;
		}
	}

	@Override
	public Anchor[] getAnchors(final ContainerShape ownerShape, final Object bo) {
		try {
			// Run queries to get the source and destination shapes
			this.rootValue = ownerShape;
			final PictogramElement srcPe = queryRunner.getFirstPictogramElement(srcQuery, bo);
			final PictogramElement dstPe = queryRunner.getFirstPictogramElement(dstQuery, bo);
			
			if(!(srcPe instanceof AnchorContainer &&dstPe instanceof AnchorContainer)) {
				return null;
			}
			
			final AnchorContainer srcAnchorContainer = (AnchorContainer)srcPe;
			final AnchorContainer dstAnchorContainer = (AnchorContainer)dstPe;
					
			// Get anchor
			// For now only chopbox anchors are supported.
			final Anchor a1 = Graphiti.getPeService().getChopboxAnchor(srcAnchorContainer);
			final Anchor a2 = Graphiti.getPeService().getChopboxAnchor(dstAnchorContainer);
			if(a1 == null || a2 == null) {
				return null;
			}
	
			return new Anchor[] {a1, a2};
		} finally {
			this.rootValue = null;
		}
	}
}
