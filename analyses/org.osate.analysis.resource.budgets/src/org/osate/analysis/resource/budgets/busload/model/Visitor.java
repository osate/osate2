package org.osate.analysis.resource.budgets.busload.model;

public interface Visitor {
	public void visitModel(BusLoadModel model);

	public void visitBus(AbstractBus bus);

	public void visitVirtualBus(VirtualBus virtualBus);

	public void visitConnection(Connection connection);
}
