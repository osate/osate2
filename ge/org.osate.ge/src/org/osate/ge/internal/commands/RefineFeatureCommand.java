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
import org.osate.ge.internal.DiagramElement;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.di.ModifiesBusinessObjects;
import org.osate.ge.internal.query.StandaloneDiagramElementQuery;
import org.osate.ge.internal.services.QueryService;
import org.osate.ge.internal.util.AadlFeatureUtil;

@ModifiesBusinessObjects
public class RefineFeatureCommand {
	private static final StandaloneDiagramElementQuery parentQuery = StandaloneDiagramElementQuery.create((root) -> root.ancestor(1));

	@GetLabel
	public String getLabel() {
		return "Refine";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final Feature feature,
			@Named(InternalNames.DIAGRAM_ELEMENT_PROXY) final DiagramElement diagramElement,
			final QueryService queryService) {
		final Object diagram = queryService.getFirstBusinessObject(parentQuery, diagramElement);
		if(!(diagram instanceof Classifier)) {
			return false;
		}

		return feature.getContainingClassifier() != diagram &&
				(diagram instanceof FeatureGroupType || diagram instanceof ComponentType);
	}

	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final Feature feature,
			@Named(InternalNames.DIAGRAM_ELEMENT_PROXY) final DiagramElement diagramElement,
			final QueryService queryService) {
		final Object featureOwner = queryService.getFirstBusinessObject(parentQuery, diagramElement);
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
