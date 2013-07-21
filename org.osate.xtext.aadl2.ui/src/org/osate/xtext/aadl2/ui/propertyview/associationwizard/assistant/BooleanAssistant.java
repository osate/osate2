package org.osate.xtext.aadl2.ui.propertyview.associationwizard.assistant;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class BooleanAssistant extends AbstractAssistant {
	private Button trueButton = null;
	private Button falseButton = null;
	
	public BooleanAssistant(Composite parent, AssistantValueChangedListener listener) {
		super(parent, listener);
		layoutComponents();
	}
	
	private void layoutComponents() {
		setLayout(new GridLayout(2, false));
		
		trueButton = new Button(this, SWT.RADIO);
		trueButton.setText("True");
		trueButton.setSelection(true);
		trueButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		
		falseButton = new Button(this, SWT.RADIO);
		falseButton.setText("False");
		falseButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		
		addListeners();
	}
	
	private void addListeners() {
		trueButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				requestUpdate();
			}
		});
		falseButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				requestUpdate();
			}
		});
	}
	
	@Override
	public String getValueText() {
		return Boolean.valueOf(trueButton.getSelection()).toString();
	}
	
	@Override
	public boolean isComplete() {
		return true;
	}
	
	@Override
	public void setAssistantEnabled(boolean enabled) {
		trueButton.setEnabled(enabled);
		falseButton.setEnabled(enabled);
	}
}