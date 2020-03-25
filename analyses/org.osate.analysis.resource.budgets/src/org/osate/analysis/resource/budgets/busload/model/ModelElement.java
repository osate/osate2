package org.osate.analysis.resource.budgets.busload.model;

import java.util.List;

abstract class ModelElement {
	@FunctionalInterface
	public static interface Traversal {
		@FunctionalInterface
		public static interface SimpleAction {
			public void doIt();
		}

		public void traverse(SimpleAction visitChildren, SimpleAction visitSelf);

		public static final Traversal PREORDER = (visitChildren, visitSelf) -> {
			visitSelf.doIt();
			visitChildren.doIt();
		};
		public static final Traversal POSTORDER = (visitChildren, visitSelf) -> {
			visitChildren.doIt();
			visitSelf.doIt();
		};
	}

	public final void visitPostOrder(final Visitor visitor) {
		visit(visitor, Traversal.POSTORDER);
	}

	public final void visitPreOrder(final Visitor visitor) {
		visit(visitor, Traversal.PREORDER);
	}

	final void visit(final Visitor visitor, final Traversal traversal) {
		traversal.traverse(() -> visitChildren(visitor, traversal), () -> visitSelf(visitor));
	}

	final <E extends ModelElement> void visit(final List<E> list, final Visitor visitor, final Traversal traversal) {
		list.forEach(e -> e.visit(visitor, traversal));
	}

	protected abstract void visitChildren(Visitor visitor, Traversal traversal);

	protected abstract void visitSelf(Visitor visitor);
}
