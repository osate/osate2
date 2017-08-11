package org.osate.ge.internal.diagram.runtime;

public interface DiagramTransactionHandler {
	interface TransactionOperation {
		void run();
		boolean canUndo();
		void undo();
		void redo();
	}
	
	void modify(final String label, final TransactionOperation op);
}
