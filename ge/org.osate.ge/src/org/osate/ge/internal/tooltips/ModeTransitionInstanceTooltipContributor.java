package org.osate.ge.internal.tooltips;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Named;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.ge.di.Activate;
import org.osate.ge.di.Names;

public class ModeTransitionInstanceTooltipContributor {
	@Activate
	public void getTooltip(final Composite parent, @Named(Names.BUSINESS_OBJECT) ModeTransitionInstance mti) {
		// Mode transition trigger port names
		final List<String> triggerPortNames = mti.getModeTransition().getOwnedTriggers().stream()
				.map(mtt -> mtt.getTriggerPort().getName()).collect(Collectors.toList());
		// Formatted for tooltip
		final String modeTransitionTriggers = " -[" + String.join(",", triggerPortNames) + "]-> ";

		final Label lbl = new Label(parent, SWT.NONE);
		lbl.setText(mti.getName() + ": " + mti.getSource().getName() + modeTransitionTriggers
				+ mti.getDestination().getName());
	}
}
