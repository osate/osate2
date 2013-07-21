package org.osate.xtext.aadl2.ui.propertyview.associationwizard.assistant;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
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
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.UnitsType;

public class SingleNumberTypeWithUnitsAssistant extends AbstractAssistant {
	private final NumberType type;
	private final UnitsType units;
	private final ISerializer serializer;
	
	private Label fieldLabel = null;
	private Text valueField = null;
	private ComboViewer unitsViewer = null;
	
	public SingleNumberTypeWithUnitsAssistant(Composite parent, NumberType type, ISerializer serializer, AssistantValueChangedListener listener) {
		super(parent, listener);
		this.type = type;
		this.serializer = serializer;
		units = type.getUnitsType();
		layoutComponents();
	}
	
	private void layoutComponents() {
		setLayout(new GridLayout(3, false));
		
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
		valueField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		unitsViewer = new ComboViewer(this, SWT.DROP_DOWN | SWT.READ_ONLY);
		unitsViewer.setContentProvider(new ArrayContentProvider());
		unitsViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((UnitLiteral)element).getName();
			}
		});
		unitsViewer.setInput(units.getOwnedLiterals());
		unitsViewer.setSelection(new StructuredSelection(units.getOwnedLiterals().get(0)));
		unitsViewer.getCombo().setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		
		addListeners();
	}
	
	private void addListeners() {
		valueField.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				requestUpdate();
			}
		});
		unitsViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				requestUpdate();
			}
		});
	}
	
	@Override
	public String getValueText() {
		StringBuilder valueText = new StringBuilder(valueField.getText());
		valueText.append(' ');
		valueText.append(((UnitLiteral)((IStructuredSelection)unitsViewer.getSelection()).getFirstElement()).getName());
		return valueText.toString();
	}
	
	@Override
	public boolean isComplete() {
		return valueField.getText().length() != 0;
	}
	
	@Override
	public void setAssistantEnabled(boolean enabled) {
		fieldLabel.setEnabled(enabled);
		valueField.setEnabled(enabled);
		unitsViewer.getCombo().setEnabled(enabled);
	}
}