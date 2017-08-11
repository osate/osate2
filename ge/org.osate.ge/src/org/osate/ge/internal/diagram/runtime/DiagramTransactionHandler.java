package org.osate.ge.internal.diagram.runtime;

public interface DiagramTransactionHandler {
	void modify(final String label, final Runnable modifier);
}
