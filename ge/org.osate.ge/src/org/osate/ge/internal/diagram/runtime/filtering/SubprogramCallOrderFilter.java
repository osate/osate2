package org.osate.ge.internal.diagram.runtime.filtering;

import org.osate.aadl2.SubprogramCallSequence;
import org.osate.ge.ContentFilter;
import org.osate.ge.internal.model.SubprogramCallOrder;

public class SubprogramCallOrderFilter implements ContentFilter {
	public static final String ID = "subprogramCallOrders";

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public String getName() {
		return "Subprogram Call Order";
	}

	@Override
	public boolean isApplicable(final Object bo) {
		return bo instanceof SubprogramCallSequence;
	}

	@Override
	public boolean test(Object bo) {
		return bo instanceof SubprogramCallOrder;
	}
}
