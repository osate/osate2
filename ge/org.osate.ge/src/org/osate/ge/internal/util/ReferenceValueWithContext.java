package org.osate.ge.internal.util;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.ReferenceValue;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

/**
 * Contains the reference value and information regarding the start of the path relative to the Queryable with which it is association. 
 *
 */
public class ReferenceValueWithContext {
	private static StandaloneQuery cneQuery = StandaloneQuery.create((rootQuery) -> rootQuery.descendantsByBusinessObjectsRelativeReference((ContainedNamedElement cne) -> getBusinessObjectsPath(cne)).first());
	private static StandaloneQuery partialCneQuery = StandaloneQuery.create((rootQuery) -> rootQuery.descendantsByBusinessObjectsRelativeReference((ContainedNamedElement cne) -> getBusinessObjectsPath(cne), 1).first());
	
	public final ReferenceValue referenceValue;
	
	/**
	 * The property association belongs to an ancestor this many levels up from the element the Queryable is associated.
	 * For example, a value of 1 indicates that the path begins at the parent of the Queryable.
	 * The first element in the reference value's path will be a sibling of the queryable.
	 */
	public final int propertyAssociationOwnerAncestorLevel;
	
	public ReferenceValueWithContext(final ReferenceValue referenceValue, 
			final int propertyAssociationOwnerAncestorLevel) {
		this.referenceValue = referenceValue;
		this.propertyAssociationOwnerAncestorLevel = propertyAssociationOwnerAncestorLevel;
	}
	
	public static class ResolutionResults {
		public final Queryable dst;
		public final boolean isPartial;
		
		public ResolutionResults(final Queryable dst, 
				final boolean isPartial) {
			this.dst = dst;
			this.isPartial = isPartial;
		}
	}
	
	// Rename q. It is the lowest element to which the element applies.
	public ResolutionResults resolve(final Queryable q, final QueryService queryService) {
		// Get the queryable
		boolean referenceOwnerInTree = true;
		Queryable tmp = q;
		for(int i = 0; i < propertyAssociationOwnerAncestorLevel; i++) {
			tmp = tmp.getParent();
			if(tmp == null) {
				referenceOwnerInTree = false;
				break;
			}
		}
		
		// Decide whether to show it as connection or not.
		// OPTIMIZE: Don't use queries. Should be able to do this in one loop instead of requiring 2 queries.		
		final boolean hasPartialDestination;
		final boolean hasFinalDestination;
		final Queryable dst;
		if(referenceOwnerInTree) {
			dst = queryService.getFirstResult(partialCneQuery, tmp, referenceValue);
			hasPartialDestination = dst != null;
			
			if(hasPartialDestination) {
				final Queryable referencedQueryable = queryService.getFirstResult(cneQuery, tmp, referenceValue);
				hasFinalDestination = dst == referencedQueryable && !containsArrayElementReference(referenceValue);
			} else {
				hasFinalDestination = false;
			}
		} else {
			dst = null;
			hasPartialDestination = false;
			hasFinalDestination = false;
		}
	
		return new ResolutionResults(dst, hasPartialDestination && !hasFinalDestination);
	}
	
	/**
	 * Gets an array of business objects which describes the logical diagram element path to a contained named element
	 * Ignores array references
	 * @param ctx
	 * @param cne
	 * @return
	 */
	private static Object[] getBusinessObjectsPath(final ContainedNamedElement cne) {
		if(cne == null) {
			return null;
		}
		
		final List<Object> path = new ArrayList<>();
		for(ContainmentPathElement pathElement = cne.getPath(); pathElement != null; pathElement = pathElement.getPath()) {
			path.add(pathElement.getNamedElement());
		}
		
		return path.toArray();
	}
	
	private static boolean containsArrayElementReference(final ContainedNamedElement cne) {
		if(cne == null) {
			return false;
		}
		
		for(ContainmentPathElement pathElement = cne.getPath(); pathElement != null; pathElement = pathElement.getPath()) {
			if(pathElement.getArrayRanges() != null && pathElement.getArrayRanges().size() > 0) {
				return true;
			}
		}
		
		return false;
	}		
}