package org.osate.ge.internal.connections;

import java.util.Objects;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.osate.ge.di.CreateDestinationQuery;
import org.osate.ge.di.CreateParentQuery;
import org.osate.ge.di.CreateSourceQuery;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.graphics.AgeConnection;
import org.osate.ge.internal.graphiti.AnchorNames;
import org.osate.ge.internal.query.Query;
import org.osate.ge.internal.query.QueryRunner;
import org.osate.ge.internal.query.QueryUtil;
import org.osate.ge.internal.query.RootQuery;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.PropertyService;

// TODO: Remove after migration to new systme
// TODO: Replace with new system
public class BusinessObjectHandlerConnectionInfoProvider/* implements ConnectionInfoProvider */{
	/*
	private final ConnectionService connectionService;
	private final PropertyService propertyService;
	private final ExtensionService extService;
	private final AnchorService anchorService;
	private final BusinessObjectResolutionService bor;
	private final Object handler;
	private final QueryRunner queryRunner;
	private final IFeatureProvider fp;
	private final RootAgeDiagramElementQuery rootQuery = new RootAgeDiagramElementQuery(() -> this.rootValue);
	private final RootAgeDiagramElementQuery srcRootQuery = new RootAgeDiagramElementQuery(() -> this.srcRootValue); // For getting the connection's source
	private final RootAgeDiagramElementQuery dstRootQuery = new RootAgeDiagramElementQuery(() -> this.dstRootValue); // For getting the connection's destination
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
			final AnchorService anchorService,
			final BusinessObjectResolutionService bor,
			final Object boHandler, 
			final QueryRunner queryRunner,
			final IFeatureProvider fp) {
		this.connectionService = Objects.requireNonNull(connectionService, "connectionService must not be null");
		this.propertyService = Objects.requireNonNull(propertyService, "propertyService must not be null");
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.anchorService = Objects.requireNonNull(anchorService, "anchorService must not be null");
		this.bor = Objects.requireNonNull(bor, "bor must not be null");
		this.handler = Objects.requireNonNull(boHandler, "boHandler must not be null");
		this.queryRunner = Objects.requireNonNull(queryRunner, "queryRunner muts not be null");
		this.fp = Objects.requireNonNull(fp, "fp must not be null");

		// Create queries using the business object handler
		final IEclipseContext childCtx = extService.createChildContext();
		try {
			childCtx.set(Names.SOURCE_ROOT_QUERY, srcRootQuery);
			childCtx.set(Names.DESTINATION_ROOT_QUERY, dstRootQuery);
			ownerDiagramElementQuery = QueryUtil.ensureFirst(Objects.requireNonNull((AgeDiagramElementQuery<Object>)ContextInjectionFactory.invoke(handler, CreateParentQuery.class, childCtx), "unable to create parent diagram element query"));
			childCtx.remove(Names.SOURCE_ROOT_QUERY);
			childCtx.remove(Names.DESTINATION_ROOT_QUERY);
			
			childCtx.set(Names.ROOT_QUERY, rootQuery);	
			srcQuery = QueryUtil.ensureFirst((AgeDiagramElementQuery<Object>)ContextInjectionFactory.invoke(handler, CreateSourceQuery.class, childCtx, null));
			dstQuery = QueryUtil.ensureFirst((AgeDiagramElementQuery<Object>)ContextInjectionFactory.invoke(handler, CreateDestinationQuery.class, childCtx, null));
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
	public Anchor[] getAnchors(final PictogramElement owner, final Object bo) {
		// Get the graphic
		final IEclipseContext eclipseCtx = extService.createChildContext();
		final Object gr;
		try {			
			eclipseCtx.set(Names.BUSINESS_OBJECT, bo);	
			eclipseCtx.set(InternalNames.INTERNAL_DIAGRAM_BO, bor.getBusinessObjectForPictogramElement(fp.getDiagramTypeProvider().getDiagram()));		
			eclipseCtx.set(InternalNames.PARENT_DIAGRAM_ELEMENT_PROXY, new PictogramElementProxy(owner));
			gr = ContextInjectionFactory.invoke(handler, GetGraphic.class, eclipseCtx, null);
		} finally {
			eclipseCtx.dispose();
		}
		
		try {
			// Set root value of queries
			this.rootValue = owner;

			if(gr instanceof AgeConnection) {
				final AgeConnection ac = (AgeConnection)gr;
				
				// Get the anchors
				Objects.requireNonNull(srcQuery, "Source query must not be null for connections");
				final PictogramElement src = queryRunner.getFirstResult(srcQuery, bo);
				final Anchor a1 = getAnchor(src);
				if(a1 == null) {
					return null;
				}
				
				final Anchor a2;
				if(ac.isFlowIndicator) {
					if(!(src instanceof AnchorContainer)) {
						return null;
					}
					
					a2 = anchorService.getAnchorByName(src, AnchorNames.FLOW_SPECIFICATION);						
				} else {
					Objects.requireNonNull(dstQuery, "Destination query must not be null for flow indicators");
					a2 = getAnchor(queryRunner.getFirstResult(dstQuery, bo));
				}
		
				if(a2 == null) {
					return null;
				}
				
				return new Anchor[] {a1, a2};
			} else {
				throw new RuntimeException("Unsupported graphic: " + gr);
			}
		} finally {
			this.rootValue = null;
		}
	}

	*/
}
