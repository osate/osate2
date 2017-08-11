package org.osate.ge.internal.diagram.runtime.boTree;

import java.util.Objects;

import org.osate.ge.internal.diagram.runtime.ContentsFilter;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.services.ProjectReferenceService;

public class DefaultBusinessObjectNodeFactory {
	private final ProjectReferenceService referenceService;
	
	public DefaultBusinessObjectNodeFactory(final ProjectReferenceService referenceService) {
		this.referenceService = Objects.requireNonNull(referenceService, "referenceService must not be null");
	}
	
	public BusinessObjectNode create(final BusinessObjectNode parent, 
			final Long id,
			final Object bo,
			final boolean manual,
			final ContentsFilter autoContentsFilter,
			final Completeness completeness) {		
		final RelativeBusinessObjectReference relativeReference = bo == null ? null : Objects.requireNonNull(referenceService.getRelativeReference(bo), "unable to get relative reference");
		
		// Validate
		if(parent == null) {
			if(relativeReference != null) {
				throw new RuntimeException("Root nodes must have a null relative reference");
			}
			
			if(bo != null) {
				throw new RuntimeException("Root nodes must have a null business object");
			}
		} else {
			Objects.requireNonNull(id, "id must not be null");
			Objects.requireNonNull(bo, "bo must not be null");
		}
		
		return new BusinessObjectNode(parent, id, relativeReference, bo, manual, autoContentsFilter, completeness);
	}
}
