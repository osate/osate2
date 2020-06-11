package org.osate.analysis.security;

import java.util.Optional;

import org.eclipse.emf.common.notify.impl.AdapterImpl;

class SecurityCheckAdapter extends AdapterImpl implements SecurityCheckData {

	protected Optional<SecurityLabel> current;

	protected Optional<SecurityLabel> min;

	protected Optional<SecurityLabel> max;

	@Override
	public void setLabel(Optional<SecurityLabel> label) {
		current = label;
	}

	@Override
	public Optional<SecurityLabel> getLabel() {
		return current;
	}

	@Override
	public void setMinLabel(Optional<SecurityLabel> label) {
		min = label;
	}

	@Override
	public Optional<SecurityLabel> getMinLabel() {
		return min;
	}

	@Override
	public void setMaxLabel(Optional<SecurityLabel> label) {
		max = label;
	}

	@Override
	public Optional<SecurityLabel> getMaxLabel() {
		return max;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == SecurityCheckData.class;
	}

}