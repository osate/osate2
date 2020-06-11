package org.osate.analysis.security;

import java.util.Optional;

import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instance.util.InstanceSwitch;

@SuppressWarnings("restriction")
class LabelPropagator extends InstanceSwitch<Boolean> {

	private Logger logger = PlatformUI.getWorkbench().getService(org.eclipse.e4.core.services.log.Logger.class);

	private SecurityPolicy policy;

	private SystemOperationMode som;

	LabelPropagator(SecurityPolicy policy, SystemOperationMode som) {
		this.policy = policy;
		this.som = som;
	}

	void propagate(SystemInstance ci) {
		propagate(ci, Optional.empty());
	}

	private Optional<SecurityLabel> propagate(ComponentInstance ci, Optional<SecurityLabel> parentmax) {
		Optional<SecurityLabel> current = SecurityLabel.of(ci);
		LabelUtil.setLabel(ci, current);
		LabelUtil.setMaxLabel(ci, parentmax);

		Optional<SecurityLabel> max = current.isPresent() ? current : parentmax;
		Optional<SecurityLabel> min = Optional.empty();
		min = ci.getComponentInstances()
				.stream()
				.reduce(min, (l, c) -> LabelUtil.join(l, propagate(c, max)), LabelUtil::join);
		min = ci.getFeatureInstances()
				.stream()
				.reduce(min, (l, f) -> LabelUtil.join(l, propagate(f, max)), LabelUtil::join);

		LabelUtil.setMinLabel(ci, min);

		logger.info("component " + ci.getName() + ": " + min + " <= " + current + " <= " + max);
		return min;
	}

	private Optional<SecurityLabel> propagate(FeatureInstance fi, Optional<SecurityLabel> parentmax) {
		Optional<SecurityLabel> current = SecurityLabel.of(fi);
		LabelUtil.setLabel(fi, current);
		LabelUtil.setMaxLabel(fi, parentmax);

		Optional<SecurityLabel> max = current.isPresent() ? current : parentmax;
		Optional<SecurityLabel> min = Optional.empty();
		min = fi.getFeatureInstances()
				.stream()
				.reduce(min, (l, f) -> LabelUtil.join(l, propagate(f, max)), LabelUtil::join);

		LabelUtil.setMinLabel(fi, min);

		logger.info("feature " + fi.getName() + ": " + min + " <= " + current + " <= " + max);
		return min;
	}
}
