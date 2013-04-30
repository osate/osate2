package org.osate.xtext.aadl2.ui.propertyview.associationwizard;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.InstanceObject;

public class ModeChooserWizardPage extends WizardPage {
	private final NamedElement holder;
	
	private ListViewer modesViewer = null;
	
	public ModeChooserWizardPage(NamedElement holder) {
		super("Mode Chooser Wizard Page");
		this.holder = holder;
		setTitle("Modes");
		setDescription("Select the Mode(s) that the property will exist in.");
	}
	
	@SuppressWarnings("unchecked")
	public List<Mode> getSelectedModes() {
		return Collections.checkedList(((IStructuredSelection)modesViewer.getSelection()).toList(), Mode.class);
	}
	
	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		
		modesViewer = new ListViewer(composite);
		modesViewer.setContentProvider(new ArrayContentProvider());
		modesViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((Mode)element).getName();
			}
		});
		EList<? extends Mode> modes = getModesForHolder(holder);
		if (modes == null)
			modesViewer.setInput(new Object[0]);
		else
			modesViewer.setInput(modes);
		modesViewer.getList().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		setControl(composite);
	}
	
	public static EList<? extends Mode> getModesForHolder(NamedElement holder) {
		EList<? extends Mode> modes = null;
		if (holder instanceof InstanceObject)
			modes = ((InstanceObject)holder).getSystemInstance().getSystemOperationModes();
		else if (holder instanceof ComponentClassifier)
			modes = ((ComponentClassifier)holder).getAllModes();
		else if (holder instanceof ModalElement)
			modes = ((ModalElement)holder).getAllInModes();
		return modes;
	}
}