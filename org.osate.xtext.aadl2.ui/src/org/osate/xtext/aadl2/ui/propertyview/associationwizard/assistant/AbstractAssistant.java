package org.osate.xtext.aadl2.ui.propertyview.associationwizard.assistant;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public abstract class AbstractAssistant extends Composite {
	private final AssistantValueChangedListener listener;
	
	public AbstractAssistant(Composite parent, AssistantValueChangedListener listener) {
		super(parent, SWT.NONE);
		this.listener = listener;
	}
	
	protected void requestUpdate() {
		listener.assistantValueChanged();
	}
	
	public abstract void setAssistantEnabled(boolean enabled);
	public abstract boolean isComplete();
	public abstract String getValueText();
}