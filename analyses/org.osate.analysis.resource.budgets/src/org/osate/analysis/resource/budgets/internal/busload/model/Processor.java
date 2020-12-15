package org.osate.analysis.resource.budgets.internal.busload.model;

import org.osate.aadl2.instance.ComponentInstance;

public class Processor extends AnalysisElement {
	private final ComponentInstance procInstance;
	private double capacity;
	private String somName;

	public final double getCapacity() {
		return capacity;
	}

	public final void setCapacity(final double capacity) {
		this.capacity = capacity;
	}

	public final String getSomName() {
		return somName;
	}

	public final void setSomName(final String somName) {
		this.somName = somName;
	}

	public Processor(final ComponentInstance procInstance, final String somName) {
		super("processor");
		this.procInstance = procInstance;
		this.somName = somName;
	}

	public final ComponentInstance getProcessorInstance() {
		return procInstance;
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
