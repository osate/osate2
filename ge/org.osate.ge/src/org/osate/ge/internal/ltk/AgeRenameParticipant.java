package org.osate.ge.internal.ltk;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;

public class AgeRenameParticipant extends RenameParticipant {
	public AgeRenameParticipant() {
		System.err.println("CREATED");
	}

	@Override
	protected boolean initialize(final Object element) {
		System.err.println("initialize: " + element);
		return false;
	}

	@Override
	public String getName() {
		System.err.println(getName());
		return null;
	}

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor pm, CheckConditionsContext context)
			throws OperationCanceledException {
		System.err.println("checkConditions()");
		return null;
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		System.err.println("createChange()");
		return null;
	}

}
