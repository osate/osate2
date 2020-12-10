package org.osate.analysis.resource.budgets.internal.busload.model;

import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;

public class PowerRequirementModel extends ModelElement {
	/**
	 * Use {@link #buildModel(SystemInstance, SystemOperationMode)} to get an instance of the
	 * model.
	 */
	private PowerRequirementModel() {
		super();
	}

	@Override
	void visitSelfPrefix(final Visitor visitor) {
		// visitor.visitModelPrefix(this);
	}

	@Override
	void visitChildren(final Visitor visitor) {
		// visit(rootBuses, visitor);
	}

	@Override
	void visitSelfPostfix(final Visitor visitor) {
		// visitor.visitModelPostfix(this);
	}

}
