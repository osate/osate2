package org.osate.alisa.common.ui.shared;

import org.eclipse.xtext.builder.impl.IToBeBuiltComputerContribution;
import org.osate.alisa.common.ui.builder.AlisaToBeBuiltComputer;

import com.google.inject.Binder;
import com.google.inject.Module;

public class AlisaSharedContribution implements Module {

	public void configure(Binder binder) {
		binder.bind(IToBeBuiltComputerContribution.class).to(AlisaToBeBuiltComputer.class);
	}

}