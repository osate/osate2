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

public class NumberTypeRangeAssistant extends AbstractAssistant {
	private final NumberType numType;
	private final ISerializer serializer;
	
	private Label typeLabel = null;
	private Label lowerLabel = null;
	private Text lowerField = null;
	private Label upperLabel = null;
	private Text upperField = null;
	private Label deltaLabel = null;
	private Text deltaField = null;
	
	public NumberTypeRangeAssistant(Composite parent, NumberType numType, ISerializer serializer, AssistantValueChangedListener listener) {
		super(parent, listener);
		this.numType = numType;
		this.serializer = serializer;
		layoutComponents();
	}
	
	private void layoutComponents() {
		setLayout(new GridLayout(2, false));
		
		typeLabel = new Label(this, SWT.NONE);
		StringBuilder labelText = new StringBuilder("Enter ");
		labelText.append(numType instanceof AadlInteger ? "integer" : "real");
		labelText.append(" range value");
		if (numType.getRange() != null) {
			labelText.append(" between ");
			labelText.append(serializer.serialize(numType.getRange().getLowerBound()).trim());
			labelText.append(" and ");
			labelText.append(serializer.serialize(numType.getRange().getUpperBound()).trim());
		}
		labelText.append(".");
		typeLabel.setText(labelText.toString());
		typeLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		
		lowerLabel = new Label(this, SWT.NONE);
		lowerLabel.setText("Lower bound:");
		lowerLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		
		lowerField = new Text(this, SWT.BORDER);
		lowerField.setFocus();
		lowerField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		upperLabel = new Label(this, SWT.NONE);
		upperLabel.setText("Upper bound:");
		upperLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		
		upperField = new Text(this, SWT.BORDER);
		upperField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		deltaLabel = new Label(this, SWT.NONE);
		deltaLabel.setText("Delta (Optional)");
		deltaLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		
		deltaField = new Text(this, SWT.BORDER);
		deltaField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		addListeners();
	}
	
	private void addListeners() {
		lowerField.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				requestUpdate();
			}
		});
		upperField.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				requestUpdate();
			}
		});
		deltaField.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				requestUpdate();
			}
		});
	}
	
	@Override
	public String getValueText() {
		StringBuilder valueText = new StringBuilder(lowerField.getText());
		valueText.append(" .. ");
		valueText.append(upperField.getText());
		if (deltaField.getText().length() != 0) {
			valueText.append(" delta ");
			valueText.append(deltaField.getText());
		}
		return valueText.toString();
	}
	
	@Override
	public boolean isComplete() {
		return lowerField.getText().length() != 0 && upperField.getText().length() != 0;
	}
	
	@Override
	public void setAssistantEnabled(boolean enabled) {
		typeLabel.setEnabled(enabled);
		lowerLabel.setEnabled(enabled);
		lowerField.setEnabled(enabled);
		upperLabel.setEnabled(enabled);
		upperField.setEnabled(enabled);
		deltaLabel.setEnabled(enabled);
		deltaField.setEnabled(enabled);
	}
}