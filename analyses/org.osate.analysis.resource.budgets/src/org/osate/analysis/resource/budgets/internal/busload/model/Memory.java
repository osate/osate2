package org.osate.analysis.resource.budgets.internal.busload.model;

import org.osate.aadl2.instance.SystemInstance;

public class Memory extends AnalysisElement {
	private SystemInstance si;
	public Memory(String label) {
		super(label);
	}

	public Memory(final SystemInstance si) {
		super("Memory");
		this.si = si;
	}

	@Override
	void visitSelfPrefix(Visitor visitor) {
		// TODO Auto-generated method stub

	}

	@Override
	void visitChildren(Visitor visitor) {
		// TODO Auto-generated method stub

	}

	@Override
	void visitSelfPostfix(Visitor visitor) {
		// TODO Auto-generated method stub

	}
}