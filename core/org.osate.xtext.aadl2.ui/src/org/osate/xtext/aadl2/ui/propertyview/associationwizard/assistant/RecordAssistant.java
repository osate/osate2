package org.osate.xtext.aadl2.ui.propertyview.associationwizard.assistant;

import java.util.ArrayList;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.xtext.serializer.ISerializer;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.RecordType;

public class RecordAssistant extends AbstractAssistant
{
	private final RecordType type;
	private final ISerializer serializer;
	private final NamedElement holder;
	
	private ArrayList<Button> fieldButtons = new ArrayList<Button>();
	private ArrayList<Label> fieldLabels = new ArrayList<Label>();
	
	public RecordAssistant(Composite parent, RecordType type, ISerializer serializer, NamedElement holder, AssistantValueChangedListener listener)
	{
		super(parent, listener);
		this.type = type;
		this.serializer = serializer;
		this.holder = holder;
		layoutComponents();
	}
	
	private void layoutComponents()
	{
		setLayout(new GridLayout(2, false));
		
		for (final BasicProperty field : type.getOwnedFields())
		{
			Button fieldButton = new Button(this, SWT.PUSH);
			fieldButton.setText(field.getName());
			fieldButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
			fieldButtons.add(fieldButton);
			
			final Label fieldLabel = new Label(this, SWT.BORDER);
			fieldLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			fieldLabels.add(fieldLabel);
			
			fieldButton.addSelectionListener(new SelectionAdapter()
			{
				@Override
				public void widgetSelected(SelectionEvent e)
				{
					AssistantDialog assistantDialog = new AssistantDialog(getShell(), field.getPropertyType(), serializer, holder);
					if (assistantDialog.open() == Dialog.OK)
					{
						fieldLabel.setText(assistantDialog.getValueText());
						requestUpdate();
					}
				}
			});
		}
	}
	
	@Override
	public String getValueText()
	{
		StringBuilder valueText = new StringBuilder("[");
		for (int i = 0; i < type.getOwnedFields().size(); i++)
		{
			valueText.append(type.getOwnedFields().get(i).getName());
			valueText.append(" => ");
			valueText.append(fieldLabels.get(i).getText());
			valueText.append(";");
		}
		valueText.append("]");
		return valueText.toString();
	}
	
	@Override
	public boolean isComplete()
	{
		for (Label fieldLabel : fieldLabels)
			if (fieldLabel.getText() == null || fieldLabel.getText().isEmpty())
				return false;
		return true;
	}
	
	@Override
	public void setAssistantEnabled(boolean enabled)
	{
		for (Button fieldButton : fieldButtons)
			fieldButton.setEnabled(enabled);
		for (Label fieldLabel : fieldLabels)
			fieldLabel.setEnabled(enabled);
	}
}