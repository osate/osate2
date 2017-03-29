package org.osate.ge.internal.services.impl;

import org.osate.ge.internal.DiagramElement;
import org.osate.ge.internal.diagram.AgeDiagramElement;
import org.osate.ge.internal.diagram.DiagramNode;
import org.osate.ge.internal.query.QueryRunner;
import org.osate.ge.internal.query.StandaloneDiagramElementQuery;
import org.osate.ge.internal.query.StandaloneAgeDiagramNodeQuery;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.InternalReferenceBuilderService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.QueryService;

public class DefaultQueryService implements QueryService {
	private final QueryRunner queryRunner;
	
	public DefaultQueryService(final PropertyService propertyService, final BusinessObjectResolutionService bor, final InternalReferenceBuilderService refBuilder) {
		this.queryRunner = new QueryRunner(propertyService, bor, refBuilder);
	}
	
	@Override
	public Object getFirstBusinessObject(final StandaloneDiagramElementQuery query, final DiagramElement rootElement) {
		final DiagramNode result = ((StandaloneAgeDiagramNodeQuery)query).getFirstResult(queryRunner, (DiagramNode)rootElement);
		return result instanceof AgeDiagramElement ? ((AgeDiagramElement)result).getBusinessObject() : null;
	}
}
