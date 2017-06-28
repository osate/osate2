package org.osate.ge.internal.commands;

import javax.inject.Named;

import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.Names;
import org.osate.ge.internal.di.GetBusinessObjectToModify;

public class MoveSubprogramCallUpCommand extends ReorderSubprogramCallCommand {
	public MoveSubprogramCallUpCommand() {
		super();
	}

	@GetLabel
	public String getLabel() {
		return "Move Up";
	}
	
	@GetBusinessObjectToModify
	public Object getBusinessObjectToModify(@Named(Names.BUSINESS_OBJECT) final SubprogramCall call) {
		return call.eContainer();
	}

	protected int getNewIndex(final SubprogramCall call) {
		final SubprogramCallSequence cs = (SubprogramCallSequence)call.eContainer();
		final int currentIndex = cs.getOwnedSubprogramCalls().indexOf(call);
		return currentIndex == -1 ? -1 : currentIndex - 1;
	}
}
