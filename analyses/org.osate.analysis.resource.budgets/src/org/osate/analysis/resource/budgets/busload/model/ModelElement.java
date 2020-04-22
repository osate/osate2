package org.osate.analysis.resource.budgets.busload.model;

import java.util.List;

/**
 * @since 3.0
 */
abstract class ModelElement {
	public final void visit(final Visitor visitor) {
		visitSelfPrefix(visitor);
		visitChildren(visitor);
		visitSelfPostfix(visitor);
	}

	final <E extends ModelElement> void visit(final List<E> list, final Visitor visitor) {
		list.forEach(e -> e.visit(visitor));
	}

	abstract void visitSelfPrefix(Visitor visitor);

	abstract void visitChildren(Visitor visitor);

	abstract void visitSelfPostfix(Visitor visitor);
}
