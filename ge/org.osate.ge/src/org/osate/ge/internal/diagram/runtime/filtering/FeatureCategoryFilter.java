package org.osate.ge.internal.diagram.runtime.filtering;

import java.util.Objects;

import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.BusAccess;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.EventPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.ge.ContentFilter;

public class FeatureCategoryFilter implements ContentFilter {
	private final FeatureCategory category;
	private final String id;

	public FeatureCategoryFilter(final FeatureCategory category) {
		this.category = Objects.requireNonNull(category, "category must not be null");
		this.id = getId(category);
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getParentId() {
		return FeatureFilter.ID;
	}

	@Override
	public String getName() {
		switch (category) {
		case ABSTRACT_FEATURE:
			return "Abstract Features";
		case BUS_ACCESS:
			return "Bus Accesses";
		case DATA_ACCESS:
			return "Data Accesses";
		case DATA_PORT:
			return "Data Ports";
		case EVENT_DATA_PORT:
			return "Event Data Ports";
		case EVENT_PORT:
			return "Event Ports";
		case FEATURE_GROUP:
			return "Feature Groups";
		case PARAMETER:
			return "Parameters";
		case SUBPROGRAM_ACCESS:
			return "Subprogram Accesses";
		case SUBPROGRAM_GROUP_ACCESS:
			return "Subprogram Group Accesses";
		default:
			throw new RuntimeException("Unsupported category: " + category);
		}
	}

	@Override
	public boolean isApplicable(final Object bo) {
		return bo instanceof Classifier || bo instanceof Subcomponent || bo instanceof SubprogramCall
				|| bo instanceof FeatureGroup || bo instanceof ComponentInstance || (bo instanceof FeatureInstance
						&& ((FeatureInstance) bo).getCategory() == FeatureCategory.FEATURE_GROUP);
	}

	@Override
	public boolean test(Object bo) {
		return (bo instanceof Feature && (getCategory((Feature) bo)) == category)
				|| (bo instanceof FeatureInstance && ((FeatureInstance) bo).getCategory() == category);
	}

	public static String getId(final FeatureCategory category) {
		return category.getLiteral() + "Features";
	}

	private FeatureCategory getCategory(final Feature feature) {
		if(feature instanceof AbstractFeature) {
			return FeatureCategory.ABSTRACT_FEATURE;
		} else if (feature instanceof BusAccess) {
			return FeatureCategory.BUS_ACCESS;
		} else if (feature instanceof DataAccess) {
			return FeatureCategory.DATA_ACCESS;
		} else if (feature instanceof DataPort) {
			return FeatureCategory.DATA_PORT;
		} else if (feature instanceof EventDataPort) {
			return FeatureCategory.EVENT_DATA_PORT;
		} else if (feature instanceof EventPort) {
			return FeatureCategory.EVENT_PORT;
		} else if(feature instanceof FeatureGroup) {
			return FeatureCategory.FEATURE_GROUP;
		} else if(feature instanceof Parameter) {
			return FeatureCategory.PARAMETER;
		} else if(feature instanceof SubprogramAccess) {
			return FeatureCategory.SUBPROGRAM_ACCESS;
		} else if (feature instanceof SubprogramGroupAccess) {
			return FeatureCategory.SUBPROGRAM_GROUP_ACCESS;
		} else {
			return null;
		}
	}

}
