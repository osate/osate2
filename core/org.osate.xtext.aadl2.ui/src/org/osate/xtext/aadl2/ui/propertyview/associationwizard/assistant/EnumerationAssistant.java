package org.osate.xtext.aadl2.ui.propertyview.associationwizard.assistant;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EnumerationType;

public class EnumerationAssistant extends AbstractAssistant {
	private final EnumerationType type;
	
	private ComboViewer enumLiteralViewer = null;
	
	public EnumerationAssistant(Composite parent, EnumerationType type, AssistantValueChangedListener listener) {
		super(parent, listener);
		this.type = type;
		layoutComponents();
	}
	
	private void layoutComponents() {
		setLayout(new GridLayout(1, false));
		
		enumLiteralViewer = new ComboViewer(this, SWT.DROP_DOWN | SWT.READ_ONLY);
		enumLiteralViewer.setContentProvider(new ArrayContentProvider());
		enumLiteralViewer.setLabelProvider(new LabelProvider()
		{
			@Override
			public String getText(Object element)
			{
				return ((EnumerationLiteral)element).getName();
			}
		});
		enumLiteralViewer.setInput(type.getOwnedLiterals());
		enumLiteralViewer.setSelection(new StructuredSelection(type.getOwnedLiterals().get(0)));
		enumLiteralViewer.addSelectionChangedListener(new ISelectionChangedListener()
		{
			@Override
			public void selectionChanged(SelectionChangedEvent event)
			{
				requestUpdate();
			}
		});
		enumLiteralViewer.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	}
	
	@Override
	public String getValueText() {
		return ((EnumerationLiteral)((IStructuredSelection)enumLiteralViewer.getSelection()).getFirstElement()).getName();
	}
	
	@Override
	public boolean isComplete() {
		return true;
	}
	
	@Override
	public void setAssistantEnabled(boolean enabled) {
		enumLiteralViewer.getCombo().setEnabled(enabled);
	}
}