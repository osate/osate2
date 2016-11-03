package org.osate.ge.internal.services.impl;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.internal.DiagramElementProxy;
import org.osate.ge.internal.graphiti.PictogramElementProxy;
import org.osate.ge.internal.query.QueryRunner;
import org.osate.ge.internal.query.StandaloneDiagramElementQuery;
import org.osate.ge.internal.query.StandalonePictogramElementQuery;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.InternalReferenceBuilderService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.QueryService;

public class DefaultQueryService implements QueryService {
	private final QueryRunner queryRunner;
	private final BusinessObjectResolutionService bor;
	
	public DefaultQueryService(final PropertyService propertyService, final ConnectionService connectionService, final BusinessObjectResolutionService bor, final InternalReferenceBuilderService refBuilder) {
		this.queryRunner = new QueryRunner(propertyService, connectionService, bor, refBuilder);
		this.bor = bor;
	}
	
	@Override
	public Object getFirstBusinessObject(final StandaloneDiagramElementQuery query, final DiagramElementProxy rootElement) {
		final PictogramElement result = ((StandalonePictogramElementQuery)query).getFirstResult(queryRunner, ((PictogramElementProxy)rootElement).getPictogramElement());
		return result == null ? null : bor.getBusinessObjectForPictogramElement((PictogramElement)result);
	}
}
