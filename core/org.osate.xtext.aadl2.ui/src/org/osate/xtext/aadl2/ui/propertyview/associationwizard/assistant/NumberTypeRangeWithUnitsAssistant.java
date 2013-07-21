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

public class NumberTypeRangeWithUnitsAssistant extends AbstractAssistant {
	private final NumberType numType;
	private final UnitsType units;
	private final ISerializer serializer;
	
	private Label typeLabel = null;
	private Label lowerLabel = null;
	private Text lowerField = null;
	private ComboViewer lowerUnitsViewer = null;
	private Label upperLabel = null;
	private Text upperField = null;
	private ComboViewer upperUnitsViewer = null;
	private Label deltaLabel = null;
	private Text deltaField = null;
	private ComboViewer deltaUnitsViewer = null;
	
	public NumberTypeRangeWithUnitsAssistant(Composite parent, NumberType numType, ISerializer serializer, AssistantValueChangedListener listener) {
		super(parent, listener);
		this.numType = numType;
		this.serializer = serializer;
		units = numType.getUnitsType();
		layoutComponents();
	}
	
	private void layoutComponents() {
		setLayout(new GridLayout(3, false));
		
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
		typeLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		
		lowerLabel = new Label(this, SWT.NONE);
		lowerLabel.setText("Lower bound:");
		lowerLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		
		lowerField = new Text(this, SWT.BORDER);
		lowerField.setFocus();
		lowerField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		lowerUnitsViewer = new ComboViewer(this, SWT.DROP_DOWN | SWT.READ_ONLY);
		lowerUnitsViewer.setContentProvider(new ArrayContentProvider());
		lowerUnitsViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((UnitLiteral)element).getName();
			}
		});
		lowerUnitsViewer.setInput(units.getOwnedLiterals());
		lowerUnitsViewer.setSelection(new StructuredSelection(units.getOwnedLiterals().get(0)));
		lowerUnitsViewer.getCombo().setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		
		upperLabel = new Label(this, SWT.NONE);
		upperLabel.setText("Upper bound:");
		upperLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		
		upperField = new Text(this, SWT.BORDER);
		upperField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		upperUnitsViewer = new ComboViewer(this, SWT.DROP_DOWN | SWT.READ_ONLY);
		upperUnitsViewer.setContentProvider(new ArrayContentProvider());
		upperUnitsViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((UnitLiteral)element).getName();
			}
		});
		upperUnitsViewer.setInput(units.getOwnedLiterals());
		upperUnitsViewer.setSelection(new StructuredSelection(units.getOwnedLiterals().get(0)));
		upperUnitsViewer.getCombo().setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		
		deltaLabel = new Label(this, SWT.NONE);
		deltaLabel.setText("Delta (Optional):");
		deltaLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		
		deltaField = new Text(this, SWT.BORDER);
		deltaField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		deltaUnitsViewer = new ComboViewer(this, SWT.DROP_DOWN | SWT.READ_ONLY);
		deltaUnitsViewer.setContentProvider(new ArrayContentProvider());
		deltaUnitsViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((UnitLiteral)element).getName();
			}
		});
		deltaUnitsViewer.setInput(units.getOwnedLiterals());
		deltaUnitsViewer.setSelection(new StructuredSelection(units.getOwnedLiterals().get(0)));
		deltaUnitsViewer.getCombo().setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		
		addListeners();
	}
	
	private void addListeners() {
		lowerField.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				requestUpdate();
			}
		});
		lowerUnitsViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				requestUpdate();
			}
		});
		upperField.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				requestUpdate();
			}
		});
		upperUnitsViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				requestUpdate();
			}
		});
		deltaField.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				requestUpdate();
			}
		});
		deltaUnitsViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				requestUpdate();
			}
		});
	}
	
	@Override
	public String getValueText() {
		StringBuilder valueText = new StringBuilder(lowerField.getText());
		valueText.append(' ');
		valueText.append(((UnitLiteral)((IStructuredSelection)lowerUnitsViewer.getSelection()).getFirstElement()).getName());
		valueText.append(" .. ");
		valueText.append(upperField.getText());
		valueText.append(' ');
		valueText.append(((UnitLiteral)((IStructuredSelection)upperUnitsViewer.getSelection()).getFirstElement()).getName());
		if (deltaField.getText().length() != 0) {
			valueText.append(" delta ");
			valueText.append(deltaField.getText());
			valueText.append(' ');
			valueText.append(((UnitLiteral)((IStructuredSelection)deltaUnitsViewer.getSelection()).getFirstElement()).getName());
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
		lowerUnitsViewer.getCombo().setEnabled(enabled);
		upperLabel.setEnabled(enabled);
		upperField.setEnabled(enabled);
		upperUnitsViewer.getCombo().setEnabled(enabled);
		deltaLabel.setEnabled(enabled);
		deltaField.setEnabled(enabled);
		deltaUnitsViewer.getCombo().setEnabled(enabled);
	}
}