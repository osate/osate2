package org.osate.xtext.aadl2.ui.propertyview.associationwizard.assistant;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class StringAssistant extends AbstractAssistant {
	private Label fieldLabel = null;
	private Text stringValueField = null;
	
	public StringAssistant(Composite parent, AssistantValueChangedListener listener) {
		super(parent, listener);
		layoutComponents();
	}
	
	private void layoutComponents() {
		setLayout(new GridLayout(1, false));
		
		fieldLabel = new Label(this, SWT.NONE);
		fieldLabel.setText("En&ter string value without quotes.");
		fieldLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		
		stringValueField = new Text(this, SWT.BORDER);
		stringValueField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		stringValueField.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				requestUpdate();
			}
		});
	}
	
	@Override
	public String getValueText() {
		return '\"' + stringValueField.getText() + '\"';
	}
	
	@Override
	public boolean isComplete() {
		return true;
	}
	
	@Override
	public void setAssistantEnabled(boolean enabled) {
		fieldLabel.setEnabled(enabled);
		stringValueField.setEnabled(enabled);
	}
}