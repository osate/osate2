package org.osate.analysis.security;

import java.util.Optional;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.osate.aadl2.instance.InstanceObject;

final class LabelUtil {

	private LabelUtil() {
	}

	private static AdapterFactory adapterFactory = SecurityCheckAdapterFactory.INSTANCE;

	static void setLabel(InstanceObject io, Optional<SecurityLabel> label) {
		SecurityCheckData data = (SecurityCheckData) adapterFactory.adapt(io, SecurityCheckData.class);
		data.setLabel(label);
	}

	static Optional<SecurityLabel> getLabel(InstanceObject io) {
		SecurityCheckData data = (SecurityCheckData) adapterFactory.adapt(io, SecurityCheckData.class);
		return data.getLabel();
	}

	static void setMinLabel(InstanceObject io, Optional<SecurityLabel> label) {
		SecurityCheckData data = (SecurityCheckData) adapterFactory.adapt(io, SecurityCheckData.class);
		data.setMinLabel(label);
	}

	static Optional<SecurityLabel> getMinLabel(InstanceObject io) {
		SecurityCheckData data = (SecurityCheckData) adapterFactory.adapt(io, SecurityCheckData.class);
		return data.getMinLabel();
	}

	static void setMaxLabel(InstanceObject io, Optional<SecurityLabel> label) {
		SecurityCheckData data = (SecurityCheckData) adapterFactory.adapt(io, SecurityCheckData.class);
		data.setMaxLabel(label);
	}

	static Optional<SecurityLabel> getMaxLabel(InstanceObject io) {
		SecurityCheckData data = (SecurityCheckData) adapterFactory.adapt(io, SecurityCheckData.class);
		return data.getMaxLabel();
	}

	static Optional<SecurityLabel> meet(Optional<SecurityLabel> l1, Optional<SecurityLabel> l2) {
		if (l1.isPresent() && l2.isPresent()) {
			return Optional.of(l1.get().meet(l2.get()));
		}
		if (l1.isPresent()) {
			return l1;
		}
		if (l2.isPresent()) {
			return l2;
		}
		return Optional.empty();
	}

	static Optional<SecurityLabel> join(Optional<SecurityLabel> l1, Optional<SecurityLabel> l2) {
		if (l1.isPresent() && l2.isPresent()) {
			return Optional.of(l1.get().join(l2.get()));
		}
		if (l1.isPresent()) {
			return l1;
		}
		if (l2.isPresent()) {
			return l2;
		}
		return Optional.empty();
	}

}
