package org.osate.assure.ui.views;

import org.eclipse.core.runtime.jobs.ISchedulingRule;

public class MutexSchedulingRule implements ISchedulingRule {

	@Override
	public boolean contains(ISchedulingRule rule) {
		return rule == this;
	}

	@Override
	public boolean isConflicting(ISchedulingRule rule) {
		return rule == this;
	}

}
