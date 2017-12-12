package org.osate.ge.internal.commands;

import java.util.List;

import javax.inject.Named;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.AbstractSubcomponent;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.Activate;
import org.osate.ge.di.CanActivate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.di.GetBusinessObjectToModify;
import org.osate.ge.internal.util.AadlSubcomponentUtil;
import org.osate.ge.internal.util.StringUtil;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class ChangeSubcomponentTypeCommand {
	private static final StandaloneQuery parentQuery = StandaloneQuery.create((root) -> root.ancestor(1));
	private final EClass subcomponentType;

	public ChangeSubcomponentTypeCommand(final EClass subcomponentType) {
		this.subcomponentType = subcomponentType;
	}

	@GetLabel
	public String getLabel() {
		return "Convert to " + StringUtil.camelCaseToUser(subcomponentType.getName());
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final Subcomponent sc,
			@Named(Names.BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext boc,
			final QueryService queryService) {
		final Object parent = queryService.getFirstBusinessObject(parentQuery, boc);

		if(!(sc instanceof Subcomponent && parent instanceof ComponentImplementation)) {
			return false;
		}

		final ComponentImplementation ci = (ComponentImplementation)parent;
		return sc.getContainingClassifier() == ci &&
				AadlSubcomponentUtil.canContainSubcomponentType(ci, subcomponentType)
				&&
				(sc.getRefined() == null || sc.getRefined() instanceof AbstractSubcomponent);
	}

	/**
	 *  Only allow when the subcomponent is owned by the container
	 */
	@CanActivate
	public boolean canActivate(@Named(Names.BUSINESS_OBJECT) final Subcomponent sc) {
		// Check that the subcomponent is not already of the target type
		return sc.eClass() != subcomponentType;
	}

	@GetBusinessObjectToModify
	public Object getBusinessObjectToModify(@Named(Names.BUSINESS_OBJECT) final Subcomponent sc) {
		return sc.getContainingComponentImpl();
	}

	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final Subcomponent sc) {
		final ComponentImplementation ci = sc.getContainingComponentImpl();
		final Subcomponent replacementSc = AadlSubcomponentUtil.createSubcomponent(ci, subcomponentType);

		// Copy structural feature values to the replacement object.
		transferStructuralFeatureValues(sc, replacementSc);

		// Remove the old object
		EcoreUtil.remove(sc);

		return true;
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
