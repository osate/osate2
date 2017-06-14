package org.osate.ge.internal.diagram;

import java.util.function.Predicate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.internal.model.SubprogramCallOrder;
import org.osate.ge.internal.model.Tag;

public enum ContentsFilter implements Predicate<Object> {
	ALLOW_FUNDAMENTAL("allow_fundamental", "Minimal", bo -> isFundamental(bo)), // Only include business objects which are manually specified or which are an inherent/fundamental part of the parent.
	ALLOW_TYPE("allow_type", "Type", bo -> isInType(bo)), // Include business objects which have been manually specified or which are related to a Classifier Type. For example, features.
	ALLOW_ALL("allow_all", "All", bo -> true); // Include all business objects
	
	private static final Map<String, ContentsFilter> idToContentsFilterMap;
	static {
		final Map<String, ContentsFilter> modifiableMap = new HashMap<>();
		for(final ContentsFilter value : ContentsFilter.values()) {
			modifiableMap.put(value.id, value);
		}
		idToContentsFilterMap = Collections.unmodifiableMap(modifiableMap);
	}		
	
	public static ContentsFilter getById(final String id) {
		return idToContentsFilterMap.get(id);
	}
	
	public final String id;// For serialization
	public final String description;
	public final Predicate<Object> filter;
	
	ContentsFilter(final String id, final String description, final Predicate<Object> filter) {
		this.id = Objects.requireNonNull(id, "id must not be null");
		this.description = Objects.requireNonNull(description, "description must not be null");
		this.filter = Objects.requireNonNull(filter, "filter must not be null");
	}
		
	@Override
	public boolean test(final Object t) {
		return filter.test(t);
	}
	
	public static ContentsFilter getDefault(final Object bo) {
		if(bo instanceof Subcomponent) {
			return ContentsFilter.ALLOW_TYPE;
		}
		
		return ContentsFilter.ALLOW_FUNDAMENTAL;
	}
	
	private static boolean isFundamental(final Object bo) {
		if(bo instanceof Generalization || 
				bo instanceof ModeTransitionTrigger ||
				bo instanceof SubprogramCallOrder) {
			return true;
		}
		
		if(bo instanceof Tag) {
			final Tag tag = (Tag)bo;
			if(tag.key.equals(Tag.KEY_UNIDIRECTIONAL) ||
					tag.key.equals(Tag.KEY_SUBPROGRAM_CALL_CALLED_SUBPROGRAM)) {
				return true;
			}
		}
		
		return false;
	}	
	
	private static boolean isInType(final Object bo) {
		if(isFundamental(bo) ||
				bo instanceof Classifier || 
				bo instanceof Generalization || 
				bo instanceof Feature || 
				bo instanceof FlowSpecification || 
				bo instanceof Mode || 
				bo instanceof ModeTransition) {
			return true;
		}
		
		if(bo instanceof Tag) {
			final Tag tag = (Tag)bo;
			if(tag.key.equals(Tag.KEY_SUBCOMPONENT_TYPE)) {
				return true;
			}
		}
		
		
		return false;
	}
}