package org.osate.ge.internal.commands;

import javax.inject.Named;

import org.osate.aadl2.Access;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.NamedElement;
import org.osate.ge.di.Activate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.di.GetBusinessObjectToModify;
import org.osate.ge.internal.util.AadlFeatureUtil;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class RefineFeatureCommand {
	private static final StandaloneQuery parentQuery = StandaloneQuery.create((root) -> root.ancestor(1));

	@GetLabel
	public String getLabel() {
		return "Refine";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final Feature feature,
			@Named(Names.BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext boc,
			final QueryService queryService) {
		final Object parent = queryService.getFirstBusinessObject(parentQuery, boc);
		if(!(parent instanceof Classifier)) {
			return false;
		}

		return feature.getContainingClassifier() != parent &&
				(parent instanceof FeatureGroupType || parent instanceof ComponentType);
	}

	@GetBusinessObjectToModify
	public Object getBusinessObjectToModify(@Named(Names.BUSINESS_OBJECT) final Feature feature,
			@Named(Names.BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext boc,
			final QueryService queryService) {
		return queryService.getFirstBusinessObject(parentQuery, boc);
	}
	
	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final Feature feature,
			@Named(Names.BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext boc,
			final QueryService queryService) {
		final Object featureOwner = queryService.getFirstBusinessObject(parentQuery, boc);
		
		// Refine the feature
		final NamedElement newFeatureEl = AadlFeatureUtil.createFeature((Classifier)featureOwner, feature.eClass());
		final Feature newFeature = (Feature)newFeatureEl;
		newFeature.setRefined(feature);

		if(feature instanceof DirectedFeature) {
			final DirectedFeature refinedDirectedFeature= (DirectedFeature)feature;
			final DirectedFeature newDirectedFeature = (DirectedFeature)newFeature;						
			newDirectedFeature.setIn(refinedDirectedFeature.isIn());
			newDirectedFeature.setOut(refinedDirectedFeature.isOut());
		} else if(feature instanceof Access) {
			((Access)newFeature).setKind(((Access)feature).getKind());
		}

		return true;
	}
}
