package org.osate.xtext.aadl2.ui.propertyview.associationwizard.assistant;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtext.serializer.ISerializer;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.NumberType;

public class SingleNumberTypeAssistant extends AbstractAssistant {
	private final NumberType type;
	private final ISerializer serializer;
	
	private Label fieldLabel = null;
	private Text valueField = null;
	
	public SingleNumberTypeAssistant(Composite parent, NumberType type, ISerializer serializer, AssistantValueChangedListener listener) {
		super(parent, listener);
		this.type = type;
		this.serializer = serializer;
		layoutComponents();
	}
	
	private void layoutComponents() {
		setLayout(new GridLayout(2, false));
		
		fieldLabel = new Label(this, SWT.NONE);
		StringBuilder labelText = new StringBuilder("En&ter ");
		labelText.append(type instanceof AadlInteger ? "integer" : "real");
		labelText.append(" value");
		if (type.getRange() != null) {
			labelText.append(" between ");
			labelText.append(serializer.serialize(type.getRange().getLowerBound()).trim());
			labelText.append(" and ");
			labelText.append(serializer.serialize(type.getRange().getUpperBound()).trim());
		}
		labelText.append(":");
		fieldLabel.setText(labelText.toString());
		fieldLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		
		valueField = new Text(this, SWT.BORDER);
		valueField.setFocus();
		valueField.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				requestUpdate();
			}
		});
		valueField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	}
	
	@Override
	public String getValueText() {
		return valueField.getText();
	}
	
	@Override
	public boolean isComplete() {
		return valueField.getText().length() != 0;
	}
	
	@Override
	public void setAssistantEnabled(boolean enabled) {
		fieldLabel.setEnabled(enabled);
		valueField.setEnabled(enabled);
	}
}