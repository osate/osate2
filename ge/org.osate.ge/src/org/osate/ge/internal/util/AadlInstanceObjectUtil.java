package org.osate.ge.internal.util;

import java.util.Optional;

import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.ModalPath;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.ge.internal.query.Queryable;

public class AadlInstanceObjectUtil {
	public static Optional<ComponentInstance> getComponentInstance(final Object bo) {
		final ComponentInstance ci;
		if (bo instanceof Queryable) {
			return getComponentInstance(((Queryable) bo).getBusinessObject());
		} else if (bo instanceof ComponentInstance) {
			// If component instance is a subcomponent, it must extend a component implementation
			ci = (((ComponentInstance) bo).getSubcomponent() == null
					|| (((ComponentInstance) bo).getSubcomponent() != null && (((ComponentInstance) bo)
							.getSubcomponent().getAllClassifier() instanceof ComponentImplementation)))
					? (ComponentInstance) bo
							: null;
		} else {
			ci = null;
		}

		return Optional.ofNullable(ci);
	}

	/**
	 * Get the modal element that is represented by an instance object.
	 * @param instanceObject
	 * @return modal element. Null if not a modal element.
	 */
	public static ModalElement getModalElement(final InstanceObject instanceObject) {
		if (instanceObject instanceof FlowSpecificationInstance) {
			return ((FlowSpecificationInstance) instanceObject).getFlowSpecification();
		} else if (instanceObject instanceof ConnectionReference) {
			return ((ConnectionReference) instanceObject).getConnection();
		} else if (instanceObject instanceof EndToEndFlowInstance) {
			return ((EndToEndFlowInstance) instanceObject).getEndToEndFlow();
		} else if (instanceObject instanceof ComponentInstance) {
			return ((ComponentInstance) instanceObject).getSubcomponent();
		}

		return null;
	}

	/**
	 * Get the modal path that is represented by an instance object
	 * @param childBo
	 * @return
	 */
	public static ModalPath getModalPath(final Object childBo) {
		if (childBo instanceof FlowSpecificationInstance) {
			return ((FlowSpecificationInstance) childBo).getFlowSpecification();
		} else if (childBo instanceof ConnectionReference) {
			return ((ConnectionReference) childBo).getConnection();
		} else if (childBo instanceof EndToEndFlowInstance) {
			return ((EndToEndFlowInstance) childBo).getEndToEndFlow();
		} else {
			throw new RuntimeException(childBo + "unsupported instance object");
		}
	}
}
