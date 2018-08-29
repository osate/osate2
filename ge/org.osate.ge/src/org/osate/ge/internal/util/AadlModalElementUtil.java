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
import org.osate.aadl2.instance.AnnexInstance;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceObject;
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
		return container.getChildren().stream().filter((child) -> {
			return isModalElementWithContainer(child.getBusinessObject());
		}).findAny().orElse(null);
	}

	public static boolean isModalElementWithContainer(final Object element) {
		if (element instanceof InstanceObject) {
			if (element instanceof FlowSpecificationInstance) {
				return hasContainer(((FlowSpecificationInstance) element).getFlowSpecification());
			} else if (element instanceof AnnexInstance) {
				return hasContainer(((AnnexInstance) element).getAnnexSubclause());
			} else if (element instanceof ConnectionReference) {
				return hasContainer(((ConnectionReference) element).getConnection());
			} else if (element instanceof EndToEndFlowInstance) {
				return hasContainer(((EndToEndFlowInstance) element).getEndToEndFlow());
			} else if (element instanceof ComponentInstance) {
				return hasContainer(((ComponentInstance) element).getSubcomponent());
			}

			return false;
		}

		return (element instanceof ModalElement && hasContainer((ModalElement) element));
	}

	public static boolean hasContainer(final ModalElement element) {
		return element.getContainingClassifier() instanceof ComponentClassifier;
	}

	public static ModeFeatureReference createModeFeatureReference(final String name, final NamedElement ne,
			final BusinessObjectContext parent) {
		return new ModeFeatureReference(name, ne, parent);
	}

	public static List<ModeFeature> getAllInModesOrTransitions(final ModalPath mp) {
		final List<? extends ModeFeature> inModes = mp.getAllInModes();
		final List<? extends ModeFeature> inTransitions = mp.getAllInModeTransitions();
		final int totalCount = inModes.size() + inTransitions.size();
		if (totalCount == 0) {
			return Collections.emptyList();
		}

		final List<ModeFeature> results = new ArrayList<>(totalCount);
		results.addAll(inModes);
		results.addAll(inTransitions);
		return results;
	}

	public static ModalPath getModalPath(final Object childBo) {
		if (childBo instanceof FlowSpecificationInstance) {
			return ((FlowSpecificationInstance) childBo).getFlowSpecification();
		} else if (childBo instanceof ConnectionReference) {
			return ((ConnectionReference) childBo).getConnection();
		} else if (childBo instanceof EndToEndFlowInstance) {
			return ((EndToEndFlowInstance) childBo).getEndToEndFlow();
		} else {
			// TODO fix msg
			throw new RuntimeException(childBo + "unsupported instance object");
		}
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
