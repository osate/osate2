package org.osate.ge.internal.commands;

import java.util.List;

import javax.inject.Named;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.DataSubcomponentType;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.ProcessorFeature;
import org.osate.ge.di.Activate;
import org.osate.ge.di.CanActivate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.DiagramElement;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.di.ModifiesBusinessObjects;
import org.osate.ge.internal.query.StandaloneDiagramElementQuery;
import org.osate.ge.internal.services.QueryService;
import org.osate.ge.internal.util.AadlFeatureUtil;
import org.osate.ge.internal.util.StringUtil;

@ModifiesBusinessObjects
public class ChangeFeatureTypeCommand {
	private static final StandaloneDiagramElementQuery parentQuery = StandaloneDiagramElementQuery.create((root) -> root.ancestor(1));
	private final EClass featureType;	

	public ChangeFeatureTypeCommand(final EClass featureType) {
		this.featureType = featureType;
	}

	@GetLabel
	public String getLabel() {
		return "Convert to " + StringUtil.camelCaseToUser(featureType.getName());
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final NamedElement feature,
			@Named(InternalNames.DIAGRAM_ELEMENT_PROXY) final DiagramElement diagramElement,
			final QueryService queryService) {
		// Check that the shape represents a feature and that the feature is owned by the classifier represented by the shape's diagram, and that the classifier can
		// contain features of the type this feature changes features into.
		final Object diagram = queryService.getFirstBusinessObject(parentQuery, diagramElement);
		if(!((feature instanceof Feature || feature instanceof InternalFeature || feature instanceof ProcessorFeature) && diagram instanceof Classifier)) {
			return false;
		}
		
		return feature.getContainingClassifier() == diagram &&
				AadlFeatureUtil.canOwnFeatureType(feature.getContainingClassifier(), featureType) &&
				(!(feature instanceof Feature) || (((Feature)feature).getRefined() == null || ((Feature)feature).getRefined() instanceof AbstractFeature));
	}

	/**
	 *  Only allow when the feature is owned by the container
	 */
	@CanActivate
	public boolean canActivate(@Named(Names.BUSINESS_OBJECT) final NamedElement feature) {
		// Check that the feature is not already of the target type
		return feature.eClass() != featureType;
	}

	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final NamedElement feature) {
		final Classifier featureOwner = feature.getContainingClassifier();
		final NamedElement replacementFeature = AadlFeatureUtil.createFeature(featureOwner, featureType);

		// Copy structural feature values to the replacement object.
		transferStructuralFeatureValues(feature, replacementFeature);

		// Handle copying the data feature classifier
		if(replacementFeature instanceof EventDataPort) {
			((EventDataPort) replacementFeature).setDataFeatureClassifier(getDataFeatureClassifier(feature));
		} else if(replacementFeature instanceof DataPort) {
			((DataPort) replacementFeature).setDataFeatureClassifier(getDataFeatureClassifier(feature));
		}

		// Remove the old object
		EcoreUtil.remove(feature);

		return true;
	}

	private DataSubcomponentType getDataFeatureClassifier(final NamedElement feature) {
		if(feature instanceof EventDataPort) {
			return ((EventDataPort)feature).getDataFeatureClassifier();
		} else if(feature instanceof DataPort) {
			return ((DataPort)feature).getDataFeatureClassifier();
		}

		return null;
	}

	/**
	 * Copies structural feature values from original to replacement. If replacement does not contain a matching structural feature, the value is ignored. If a feature is not set,
	 * its value is not copied over to the replacement.
	 * @param original
	 * @param replacement
	 */
	private void transferStructuralFeatureValues(final EObject original, final EObject replacement) {
		for(final EStructuralFeature feature : original.eClass().getEAllStructuralFeatures()) {
			if(feature.isChangeable() && !feature.isDerived()) {
				final Object originalValue = original.eGet(feature, true);						

				// Only copy values that are set
				if(original.eIsSet(feature)) {
					if(replacement.eClass().getEAllStructuralFeatures().contains(feature)) {
						if(feature.isMany()) {
							final @SuppressWarnings("unchecked") List<Object> originalList = (List<Object>)originalValue;
							final Object replacementValue = replacement.eGet(feature);
							final @SuppressWarnings("unchecked") List<Object> replacementList = (List<Object>)replacementValue;
							replacementList.addAll(originalList);					
						} else {
							replacement.eSet(feature, originalValue);
						}
					}
				}
			}
		}
	}	
}
