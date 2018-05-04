package org.osate.ge.internal.operations;

import org.osate.ge.operations.Operation;

public interface Step<ResultUserType> extends Operation {
	Step<?> getNextStep();
}
