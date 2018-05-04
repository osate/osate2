package org.osate.ge.internal.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.ModalPath;
import org.osate.aadl2.ModeBinding;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.query.Queryable;

public class AadlModalElementUtil {
	public static class ModeFeatureReference {
		private final String name;
		private final NamedElement modeFeature;
		private final BusinessObjectContext modeFeatureContainer;

		private ModeFeatureReference(final String name, final NamedElement modeFeature,
				final BusinessObjectContext modeFeatureContainer) {
			this.name = name;
			this.modeFeature = modeFeature;
			this.modeFeatureContainer = modeFeatureContainer;
		}

		public String getName() {
			return name;
		}

		public NamedElement getNamedElement() {
			return modeFeature;
		}

		public BusinessObjectContext getContainer() {
			return modeFeatureContainer;
		}
	}

	/**
	 * Returns a queryable if a container contains a qualified ModalElement. Otherwise null.
	 * @param container
	 * @return
	 */
	public static Queryable getModalElement(final Queryable container) {
		return container.getChildren().stream().filter(child -> isModalElementWithContainer(child.getBusinessObject()))
				.findAny().orElse(null);
	}

	public static boolean isModalElementWithContainer(final Object element) {
		return element instanceof ModalElement
				&& ((ModalElement) element).getContainingClassifier() instanceof ComponentClassifier;
	}

	public static ModeFeatureReference createModeFeatureReference(final String name, final NamedElement ne,
			final BusinessObjectContext parent) {
		return new ModeFeatureReference(name, ne, parent);
	}

	public static List<ModeFeature> getAllInModesOrTransitions(final ModalPath mp) {
		final List<? extends ModeFeature> inModes = mp.getAllInModes();
		final List<? extends ModeFeature> inTransitions = mp.getAllInModeTransitions();
		final int totalCount = inModes.size() + inTransitions.size();
		if(totalCount == 0) {
			return Collections.emptyList();
		}

		final List<ModeFeature> results = new ArrayList<>(totalCount);
		results.addAll(inModes);
		results.addAll(inTransitions);
		return results;
	}

	public static List<ModeBinding> getAllModeBindings(Subcomponent sc) {
		while (sc != null) {
			final List<ModeBinding> modeBindings = sc.getOwnedModeBindings();
			if (modeBindings != null && !modeBindings.isEmpty()) {
				return modeBindings;
			}

			sc = sc.getRefined();
		}
		return Collections.emptyList();
	}
}
