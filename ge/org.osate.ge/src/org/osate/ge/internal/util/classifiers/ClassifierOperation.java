package org.osate.ge.internal.util.classifiers;

import java.util.Objects;

public class ClassifierOperation {
	private final ClassifierOperationPart primaryPart;
	private final ClassifierOperationPart basePart; // Part of the operation that specifies the base classifier.

	public ClassifierOperation(final ClassifierOperationPart primaryOp,
			final ClassifierOperationPart baseOp) {
		this.primaryPart = Objects.requireNonNull(primaryOp, "primaryPart must not be null");
		this.basePart = Objects.requireNonNull(baseOp, "basePart must not be null");
	}

	public final ClassifierOperationPart getPrimaryPart() {
		return primaryPart;
	}

	public final ClassifierOperationPart getBasePart() {
		return basePart;
	}
}
